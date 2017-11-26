package com.globot.hmi.attendance.web.filter;/**
 * Created by lixiaoliang on 2017/11/18.
 */

import com.globot.hmi.attendance.constants.Constants;
import com.globot.hmi.attendance.util.ThreadCache;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * User: lixiaoliang
 * Date: 2017/11/18
 * Time: 下午7:26
 */
public class AuthFilter implements Filter {

    private final AntPathMatcher pathMatcher = new AntPathMatcher();

    private Set<String> noneFilterPath = new HashSet<String>();



    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;


        //判断如果没有取到用户信息,就跳转到登陆页面
        String authInfo = this.getUserAuthInfo(req);
        // TODO 从redis查看是否有此authInfo
        if (!ignoreMatch(req.getRequestURI()) && StringUtils.isBlank(authInfo)) {
            //跳转到登陆页面
            res.sendRedirect("/index");
        }
        else {
            if(StringUtils.isNotBlank(authInfo)) {
                ThreadCache.setJobNumber(authInfo);
            }
            //已经登陆,继续此次请求
            chain.doFilter(request,response);
        }
    }

    private String getUserAuthInfo(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
        for(Cookie cookie : cookies){
            if(Constants.AUTH_INFO.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public void setNoneFilterPath(String pathStr){
        String[] paths = pathStr.split("\n");
        for (String p : paths){
            if (StringUtils.isNotBlank(p.trim())) {
                this.noneFilterPath.add(p.trim());
            }
        }
    }

    private boolean ignoreMatch(String uri) {
        for (String path : this.noneFilterPath){
            if(pathMatcher.match(path, uri)) {
                return true;
            }
        }
        return false;
    }

    public void destroy() {

    }

}
