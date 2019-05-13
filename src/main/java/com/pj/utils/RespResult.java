package com.pj.utils;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Created on 2019/5/14 1:08
 * 封装返回对象  / object of return data
 * @author pj Deng
 */
public class RespResult <T> implements Serializable {

    private static final long serialVersionUID = 7834562848263385608L;
    /**
     * 默认0
     */
    private int code = 0;
    /**
     * 默认OK
     */
    private String message = "OK";

    private T data;

    public RespResult(T data) {
        this.data = data;
    }

    public RespResult(HttpStatus status) {
        if (status.value() == 200) {
            this.code = 0;
        } else {
            this.code = status.value();
            this.message = status.getReasonPhrase();
        }
    }

    public RespResult(T data, HttpStatus status) {
        if (status.value() == 200) {
            this.code = 0;
        } else {
            this.code = status.value();
        }
        this.message = status.getReasonPhrase();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}