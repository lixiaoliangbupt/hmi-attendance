package com.globot.hmi.attendance.web.api;/**
 * Created by lixiaoliang on 2017/11/14.
 */

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.*;

/**
 * User: lixiaoliang
 * Date: 2017/11/14
 * Time: 下午4:44
 */
public class APIAuthenticationInterceptor  extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(APIAuthenticationInterceptor.class);

    static final String KEY_HEADER_AUTH = "Authorization";
    static final String KEY_HEADER_DATE = "Date";

    /**
     * 不经过身份处理的url
     */
    private List<String> excludeUrlList;

    /**
     * 心跳方法不进行过滤
     */
    static Method monitorMethod;

    // 导入允许访问的应用密钥列表
    private static Map<String, String> client_secret = new HashMap<String, String>();


    static {

        // 初始化所有的client_id 对应的secret
        client_secret.put("test", "e25f4d62890cf318450b84b2156544ed");
    }

    private boolean filterClass(HandlerMethod handlerMethod) {
        if (handlerMethod == null) {
            return true;
        }

        boolean result = false;//handlerMethod.getBeanType().equals(ApiController.class);

        return result;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //表示验证是否通过
        boolean flag = false;

        if (handler != null && handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            if (!filterClass(handlerMethod)) {
                return true;
            } else if (excludeUrlList != null && excludeUrlList.contains(request.getRequestURI())) {
                return true;
            } else {
                // 判断是否访问的是心跳方法. 直接略过
                if (monitorMethod != null && handlerMethod.getMethod().equals(monitorMethod)) {
                    return true;
                }
            }
        } else {
            LOGGER.warn("mtcrm api 拦截器异常. handler为空或不是HandlerMethod对象.handler=" + handler);
        }

        if (request != null) {
            String authorizationStr = StringUtils.trim(request.getHeader(KEY_HEADER_AUTH));
            String dateStr = request.getHeader(KEY_HEADER_DATE);
            String clientId = getClientIdFromAuthStr(authorizationStr);
            String method = request.getMethod();
            String remoteIp = "";// NetUtil.getRealIp(request);
            String uri = StringUtils.trim(request.getRequestURI());

            String requestStr = "auth=[" + authorizationStr + "],dateStr=[" + dateStr + "],clientId=[" + clientId + "],method=[" + method
                    + "],remoteIp=[" + remoteIp + "],uri=[" + uri + "]";
            LOGGER.info(requestStr);
            flag = this.auth(request);
        }

        if (handler != null && handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (!flag ) {
                response.setStatus(HttpStatus.SC_FORBIDDEN);
            }
        }

        return flag;
    }

    // 可在Filter，Handler或者通过aop来调用此方法进行验证，前期实施时建议只输出验证结果，不影响实际调用执行
    public boolean auth(HttpServletRequest request) {
        try {
            String uri = request.getRequestURI();
            String method = request.getMethod();
            String remoteIp = this.getRealIp(request);
            String dateStr = request.getHeader(KEY_HEADER_DATE);
            String auth = request.getHeader(KEY_HEADER_AUTH);
            if (auth != null) {
                String clientId = this.getClientIdFromAuthStr(auth);
                String secret = getSecret(clientId);
                if (secret.isEmpty()) {
                    return false;
                }
                String auth2 = "";//com.sankuai.meituan.common.util.AuthUtil.getAuthorization(uri, method, dateStr, clientId, secret);
                if (auth.equals(auth2)) {
                    return !isDateStrExpire(request);
                }
            }
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return false;
    }

    private boolean isDateStrExpire(HttpServletRequest request) {
        try {
            String uri = request.getRequestURI();
            String seconds = "10"; //以秒为单位
            Integer expireSeconds;
            if (StringUtils.isBlank(seconds)) {
                expireSeconds = 600; //默认10分钟，如果sg没有设定或者zk无法接通
            } else {
                expireSeconds = Integer.valueOf(seconds.trim());
            }
            String dateStr = request.getHeader(KEY_HEADER_DATE);
            Date date = DateUtils.parseDate(dateStr, "EEE, dd MMM yyyy HH:mm:ss z");
            if (date == null) {
                return false; //解析不成功，默认通过日期验证，后续的auth会再次验证
            }
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return false;
    }

    /**
     * 获取clientId
     *
     * @param authStr
     * @return
     */
    public String getClientIdFromAuthStr(String authStr) {
        if (StringUtils.isNotBlank(authStr)) {
            return authStr.substring(authStr.indexOf(" ") + 1, authStr.indexOf(":"));
        }

        return null;
    }

    public String getSecret(String clientId) {
        if (client_secret.containsKey(clientId)) {
            return client_secret.get(clientId);
        } else {
            return "";
        }
    }

    public static String getRealIp(HttpServletRequest request) {
        String ip = head(request, "X-Real-IP");
        if(ip != null && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        } else {
            ip = head(request, "X-Forwarded-For");
            if(ip != null) {
                int index = ip.indexOf(44);
                return index != -1?ip.substring(0, index):ip;
            } else {
                if(ip == null || "unknown".equalsIgnoreCase(ip)) {
                    ip = request.getHeader("Proxy-Client-IP");
                }

                if(ip == null || "unknown".equalsIgnoreCase(ip)) {
                    ip = request.getHeader("WL-Proxy-Client-IP");
                }

                if(ip == null || "unknown".equalsIgnoreCase(ip)) {
                    ip = request.getRemoteAddr();
                }

                return ip == null?"unkown":ip;
            }
        }
    }

    private static String head(HttpServletRequest req, String s) {
        return req.getHeader(s);
    }

    /**
     * @return the excludeUrlList
     */
    public List<String> getExcludeUrlList() {
        return excludeUrlList;
    }

    /**
     * @param excludeUrlList
     */
    public void setExcludeUrlList(List<String> excludeUrlList) {
        this.excludeUrlList = excludeUrlList;
    }
}
