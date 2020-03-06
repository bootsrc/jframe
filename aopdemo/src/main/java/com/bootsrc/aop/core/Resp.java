package com.bootsrc.aop.core;

import java.io.Serializable;

/**
 * 通用响应对象
 */
public class Resp implements Serializable {

    private int code;

    private String msg;

    private Object data;

    public static Resp success(Object data) {
        Resp r = new Resp();
        r.code = 0;
        r.msg = "";
        r.data = data;

        return r;
    }

    public static Resp success() {
        Resp r = new Resp();
        r.code = 0;
        r.msg = "";
        r.data = null;

        return r;
    }

    public static Resp fail(int resultCode) {
        Resp r = new Resp();
        r.code = resultCode;
        r.msg = "";
        r.data = null;

        return r;
    }

    public static Resp fail(int resultCode, String errorMsg) {
        Resp r = new Resp();
        r.code = resultCode;
        r.msg = errorMsg;
        r.data = null;

        return r;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Resp{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
