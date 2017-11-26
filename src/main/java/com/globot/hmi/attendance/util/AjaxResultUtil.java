package com.globot.hmi.attendance.util;/**
 * Created by lixiaoliang on 2017/11/25.
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * User: lixiaoliang
 * Date: 2017/11/25
 * Time: 下午3:57
 */
public class AjaxResultUtil {
    /**
     * 返回包含成功Result的Map
     */
    public static Map<String, Object> success() {
        Map<String, Object> relMap = new HashMap<String, Object>();
        relMap.put("success", true);
        relMap.put("data", null);
        return relMap;
    }

    public static Map<String, Object> success(Object data) {
        Map<String, Object> relMap = new HashMap<String, Object>();
        relMap.put("success", true);
        relMap.put("data", data);
        return relMap;
    }

    public static Map<String, Object> successWithPage(int totalCount, Collection<?> items) {
        Map<String, Object> pageMap = new HashMap<String, Object>();
        pageMap.put("success", true);
        pageMap.put("total", totalCount);
        pageMap.put("items", items);
        return success(pageMap);
    }

    /**
     * 返回包含失败Result的Map
     */
    public static Map<String, Object> fail(String message) {
        return fail(400, message);
    }

    /**
     * 返回包含失败Result的Map
     */
    public static Map<String, Object> fail(int code, String message) {
        return fail(code, "", message);
    }

    /**
     * 返回包含失败Result的Map
     */
    public static Map<String, Object> fail(int code, String type, String message) {
        Map<String, Object> relMap = new HashMap<String, Object>();
        Error error = new Error(code, type, message);
        relMap.put("success", false);
        relMap.put("error", error);
        return relMap;
    }

    static class Error {
        int code;
        String type;
        String message;

        public Error(int code, String type, String message) {
            this.code = code;
            this.type = type;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
