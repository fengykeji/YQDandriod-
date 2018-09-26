package com.ccsoft.yunqudao.bean;

public class HouseAnalyseBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"id":3,"project_id":3,"fetch":"大唐公馆","advantage":"大唐公馆","rim":"大唐公馆","increase_value":"大唐公馆"}
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
         * id : 3
         * project_id : 3
         * fetch : 大唐公馆
         * advantage : 大唐公馆
         * rim : 大唐公馆
         * increase_value : 大唐公馆
         */

        private int id;
        private int project_id;
        private String fetch;
        private String advantage;
        private String rim;
        private String increase_value;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getProject_id() {
            return project_id;
        }

        public void setProject_id(int project_id) {
            this.project_id = project_id;
        }

        public String getFetch() {
            return fetch;
        }

        public void setFetch(String fetch) {
            this.fetch = fetch;
        }

        public String getAdvantage() {
            return advantage;
        }

        public void setAdvantage(String advantage) {
            this.advantage = advantage;
        }

        public String getRim() {
            return rim;
        }

        public void setRim(String rim) {
            this.rim = rim;
        }

        public String getIncrease_value() {
            return increase_value;
        }

        public void setIncrease_value(String increase_value) {
            this.increase_value = increase_value;
        }
    }
}
