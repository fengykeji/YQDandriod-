package com.ccsoft.yunqudao.bean;

public class duijierentongjibean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"recommend_count":0,"value":0,"valueDisabled":0}
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
         * recommend_count : 0
         * value : 0
         * valueDisabled : 0
         */

        private int recommend_count;
        private int value;
        private int valueDisabled;

        public int getRecommend_count() {
            return recommend_count;
        }

        public void setRecommend_count(int recommend_count) {
            this.recommend_count = recommend_count;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValueDisabled() {
            return valueDisabled;
        }

        public void setValueDisabled(int valueDisabled) {
            this.valueDisabled = valueDisabled;
        }
    }
}
