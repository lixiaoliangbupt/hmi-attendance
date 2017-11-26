package com.globot.hmi.attendance.exception;/**
 * Created by lixiaoliang on 2017/11/19.
 */

/**
 * User: lixiaoliang
 * Date: 2017/11/19
 * Time: 下午4:33
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String errorMsg) {
        super(errorMsg);
    }

    public BusinessException(String errorMsg, Exception e) {
        super(errorMsg, e);
    }
}
