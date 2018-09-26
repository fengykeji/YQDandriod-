package com.ccsoft.yunqudao.bean;

public class GetNeedInfoBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"id":"20","comsulatent_advicer":"朱萍","comsulatent_advicer_tel":"13086680768","comsulatent_advicer_company":"销售代理公司"}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 20
         * comsulatent_advicer : 朱萍
         * comsulatent_advicer_tel : 13086680768
         * comsulatent_advicer_company : 销售代理公司
         */

        private String id;
        private String comsulatent_advicer;
        private String comsulatent_advicer_tel;
        private String comsulatent_advicer_company;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getComsulatent_advicer() {
            return comsulatent_advicer;
        }

        public void setComsulatent_advicer(String comsulatent_advicer) {
            this.comsulatent_advicer = comsulatent_advicer;
        }

        public String getComsulatent_advicer_tel() {
            return comsulatent_advicer_tel;
        }

        public void setComsulatent_advicer_tel(String comsulatent_advicer_tel) {
            this.comsulatent_advicer_tel = comsulatent_advicer_tel;
        }

        public String getComsulatent_advicer_company() {
            return comsulatent_advicer_company;
        }

        public void setComsulatent_advicer_company(String comsulatent_advicer_company) {
            this.comsulatent_advicer_company = comsulatent_advicer_company;
        }
    }
}
