package com.globot.hmi.attendance.util;/**
 * Created by lixiaoliang on 2017/11/14.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

/**
 * User: lixiaoliang
 * Date: 2017/11/14
 * Time: 下午6:44
 */
public class SpringBeanUtil {
    private static ApplicationContext applicationContext;

    public static <T> T getBean(Class<T> clazz, String beanName) {
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        if (context == null) {
            context = applicationContext;
        }
        if(context == null) {
            return null;
        }
        return (T) context.getBean(beanName);
    }

    public static <T> T getBean(Class<T> clazz) {
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        if (context == null) {
            context = applicationContext;
        }
        if(context == null) {
            return null;
        }
        return (T) context.getBean(clazz);
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringBeanUtil.applicationContext = applicationContext;
    }
}

