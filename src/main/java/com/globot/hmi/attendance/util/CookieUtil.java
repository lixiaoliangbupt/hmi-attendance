package com.globot.hmi.attendance.util;/**
 * Created by lixiaoliang on 2017/11/25.
 */

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import javax.servlet.http.Cookie;

/**
 * User: lixiaoliang
 * Date: 2017/11/25
 * Time: 下午6:59
 */
public class CookieUtil {

    public static String getByName(String name, Cookie[] cookies) {
        if(ArrayUtils.isEmpty(cookies)) {
            return null;
        }
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(name)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
