package com.globot.hmi.attendance.constants;/**
 * Created by lixiaoliang on 2017/11/18.
 */

/**
 * User: lixiaoliang
 * Date: 2017/11/18
 * Time: 上午9:49
 */
public enum  EmployeeStatusEnum {
    NOT_READY(1, "未生效"),
    NORMAL(2,"正常状态"),
    FROZEN(3, "冻结"),
    LEAVE(4, "离职");

    private int code;

    private String desc;

    private EmployeeStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
