package com.ccsoft.yunqudao.data.api;


/**
 * 服务器响应的结果数据
 */
public class ResultData<T> {

    /**
     * 状态码
     */
    public int code;

    /**
     * 描述
     */
    public String msg;


    /**
     * 数据
     */
    public T data;
}
