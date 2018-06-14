package com.ccsoft.yunqudao.bean;

/**
 * Created by lixinke on 2018/6/5.
 */

public class LoginBean {

    private int code;
    private String msg;

    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data{
        private String token;
        private int agent_id;
        private String agent_identity;


        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getAgent_identity() {
            return agent_identity;
        }

        public void setAgent_identity(String agent_identity) {
            this.agent_identity = agent_identity;
        }

        public int getAgent_id() {
            return agent_id;
        }

        public void setAgent_id(int agent_id) {
            this.agent_id = agent_id;
        }
    }
}
