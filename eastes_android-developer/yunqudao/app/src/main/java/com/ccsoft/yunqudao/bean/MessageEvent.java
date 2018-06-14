package com.ccsoft.yunqudao.bean;

/**
 * @author: Pein
 * @data: 2018/5/4 0004
 */

public class MessageEvent {

    private String message;

    public  MessageEvent(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;

    }
}
