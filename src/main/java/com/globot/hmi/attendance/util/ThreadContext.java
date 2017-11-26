package com.globot.hmi.attendance.util;/**
 * Created by lixiaoliang on 2017/11/19.
 */

import com.globot.hmi.attendance.domain.Menu;

import java.util.List;

/**
 * User: lixiaoliang
 * Date: 2017/11/19
 * Time: 下午3:41
 */
public class ThreadContext {
    String ip;
    Integer userId;
    String jobNumber;
    String userName;
    String userLogin;
    Integer loginUserId;
    String logId;
    String uri;
    List<Menu> menus;
    Boolean isCurrentUserAdmin;
}
