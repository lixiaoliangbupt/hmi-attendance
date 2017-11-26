package com.globot.hmi.attendance.util;/**
 * Created by lixiaoliang on 2017/11/19.
 */

import com.globot.hmi.attendance.domain.Menu;
import com.globot.hmi.attendance.web.vo.UserInfo;

import java.util.List;

/**
 * User: lixiaoliang
 * Date: 2017/11/19
 * Time: 下午3:36
 */
public class ThreadCache {
    private ThreadCache() {

    }
    public static ThreadContext get() {
        return CACHE.get();
    }
    public static void set(ThreadContext context) {
        CACHE.set(context);
    }

    private static final ThreadLocal<ThreadContext> CACHE = new ThreadLocal<ThreadContext>() {
        protected ThreadContext initialValue() {
            return new ThreadContext();
        }
    };

    public static void setIsCurrentUserAdmin(Boolean isCurrentUserAdmin) {
        CACHE.get().isCurrentUserAdmin = isCurrentUserAdmin;
    }

    public static void setLoginUserId(Integer loginUserId) {
        CACHE.get().loginUserId = loginUserId;
    }

    public static Integer getLoginUserId() {
        return CACHE.get().loginUserId;
    }

    public static Boolean getIsCurrentUserAdmin() {
        return CACHE.get().isCurrentUserAdmin;
    }

    public static String getJobNumber() {
        return CACHE.get().jobNumber;
    }

    public static void setJobNumber(String jobNumber) {
        CACHE.get().jobNumber = jobNumber;
    }
    public static Integer getUserId() {
        return CACHE.get().userId;
    }

    public static void setUserId(Integer userId) {
        CACHE.get().userId = userId;

    }

    public static void setIp(String ip) {
        CACHE.get().ip = ip;
    }

    public static String getIp() {
        return CACHE.get().ip;
    }

    public static void setUri(String uri) {
        CACHE.get().uri = uri;
    }

    public static String getUri() {
        return CACHE.get().uri;
    }

    public static void release() {
        CACHE.remove();
    }


    public static String getUserName() {
        return CACHE.get().userName;
    }
    public static String getUserLogin() {
        return CACHE.get().userLogin;
    }

    public static void setUser(Integer userId, String userName) {
        CACHE.get().userId = userId;
        CACHE.get().userName = userName;
    }
    public static void setUser(UserInfo user) {
        CACHE.get().userId = user.getEmployeeId();
    }


    public static String getLogId() {
        return CACHE.get().logId;
    }

    public static void setLogId(String logId) {
        CACHE.get().logId = logId;
    }

    public static List<Menu> getMenus() {
        return CACHE.get().menus;
    }

    public static void setMenus(List<Menu> menus) {
        CACHE.get().menus = menus;

    }

}
