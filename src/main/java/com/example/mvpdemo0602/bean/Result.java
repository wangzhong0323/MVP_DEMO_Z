package com.example.mvpdemo0602.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/27.
 */

public class Result<T> implements Serializable{


    /**
     * data : {"uid":15,"token":"4807f5f1681be10220a2e56e10cec7b7","userName":"公共账号"}
     * code : 0
     * msg : 成功
     */

    private T data;
    private int code;
    private String msg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

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

}
