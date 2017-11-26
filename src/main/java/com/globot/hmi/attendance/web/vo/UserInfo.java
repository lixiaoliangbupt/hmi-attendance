package com.globot.hmi.attendance.web.vo;/**
 * Created by lixiaoliang on 2017/11/19.
 */

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

/**
 * User: lixiaoliang
 * Date: 2017/11/19
 * Time: 下午3:19
 */
public class UserInfo {
    private Integer employeeId;

    public UserInfo(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
