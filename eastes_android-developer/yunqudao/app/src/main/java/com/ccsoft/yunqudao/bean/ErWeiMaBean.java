package com.ccsoft.yunqudao.bean;

public class ErWeiMaBean {

    private int code;
    private String msg;
    private ErWeiMaBean.DataBean data;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public  ErWeiMaBean.DataBean getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(ErWeiMaBean.DataBean data) {
        this.data = data;
    }

    public static class DataBean{
       private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
