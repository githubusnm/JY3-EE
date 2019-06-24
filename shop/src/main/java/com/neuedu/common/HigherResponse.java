package com.neuedu.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class HigherResponse<T> {
    private Integer status;
    private T data;
    private String msg;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HigherResponse() {
    }

    public HigherResponse(Integer status) {
        this.status = status;
    }

    public HigherResponse(Integer status, String msg, T data) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public HigherResponse(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public HigherResponse(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    @JsonIgnore
    public boolean isResponseSuccess() {
        return this.status == StatusUtil.SUCCESS_STATUS;
    }

    /**
     * 提供对外公开的方法
     */
    //success
    public static HigherResponse getResponseSuccess() {
        return new HigherResponse(StatusUtil.SUCCESS_STATUS);
    }

    public static HigherResponse getResponseSuccess(String msg) {
        return new HigherResponse(StatusUtil.SUCCESS_STATUS, msg);
    }

    public static <T> HigherResponse getResponseSuccess(T t) {
        return new HigherResponse(StatusUtil.FAILED_STATUS, t);
    }

    public static <T> HigherResponse getResponseSuccess(String msg, T t) {
        return new HigherResponse(StatusUtil.SUCCESS_STATUS, msg, t);
    }

    //failed
    @JsonIgnore
    public boolean isResponseFailed() {
        return this.status == StatusUtil.FAILED_STATUS;
    }

    public static HigherResponse getResponseFailed() {
        return new HigherResponse(StatusUtil.FAILED_STATUS);
    }

    public static HigherResponse getResponseFailed(String msg) {
        return new HigherResponse(StatusUtil.FAILED_STATUS, msg);
    }

}
