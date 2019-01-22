package com.hx.dataobject;

/**
 * Created by DELL on 2019/1/19.
 */
public class Result {

    int code=200;
    String msg="";
    Object data=null;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
