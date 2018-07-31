package com.ccsoft.yunqudao.bean;

import java.util.List;

public class UnPayDetailBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"name":"带上","tel":"13452987521","sex":0,"broker_type":"推荐佣金","broker_create_time":"0000-00-00 00:00:00","client_id":583,"project_name":"翡翠滨江","absolute_address":"四川省绵阳市三台县涪滨路","broker_num":3245,"project_id":1,"current_state":"签约","pay_time":"2018-07-03 11:01:19","debit":0,"create_time":"2018-07-03 11:00:13","visit_time":"2018-07-03 11:00:00","allot_time":"2018-07-03 11:03:30","property":"住宅,公寓","process":[{"process_name":"推荐","time":"2018-07-03 11:00:13"},{"process_name":"到访","time":"2018-07-03 11:00:00"},{"process_name":"确认有效","time":"2018-07-03 11:03:30"},{"process_name":"认购","time":"2018-07-02 00:00:00"}]}
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
         * name : 带上
         * tel : 13452987521
         * sex : 0
         * broker_type : 推荐佣金
         * broker_create_time : 0000-00-00 00:00:00
         * client_id : 583
         * project_name : 翡翠滨江
         * absolute_address : 四川省绵阳市三台县涪滨路
         * broker_num : 3245
         * project_id : 1
         * current_state : 签约
         * pay_time : 2018-07-03 11:01:19
         * debit : 0
         * create_time : 2018-07-03 11:00:13
         * visit_time : 2018-07-03 11:00:00
         * allot_time : 2018-07-03 11:03:30
         * property : 住宅,公寓
         * process : [{"process_name":"推荐","time":"2018-07-03 11:00:13"},{"process_name":"到访","time":"2018-07-03 11:00:00"},{"process_name":"确认有效","time":"2018-07-03 11:03:30"},{"process_name":"认购","time":"2018-07-02 00:00:00"}]
         */

        private String name;
        private String tel;
        private int sex;
        private String broker_type;
        private String broker_create_time;
        private int client_id;
        private String project_name;
        private String absolute_address;
        private int broker_num;
        private int project_id;
        private String current_state;
        private String pay_time;
        private int debit;
        private String create_time;
        private String visit_time;
        private String allot_time;
        private String property;
        private List<ProcessBean> process;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getBroker_type() {
            return broker_type;
        }

        public void setBroker_type(String broker_type) {
            this.broker_type = broker_type;
        }

        public String getBroker_create_time() {
            return broker_create_time;
        }

        public void setBroker_create_time(String broker_create_time) {
            this.broker_create_time = broker_create_time;
        }

        public int getClient_id() {
            return client_id;
        }

        public void setClient_id(int client_id) {
            this.client_id = client_id;
        }

        public String getProject_name() {
            return project_name;
        }

        public void setProject_name(String project_name) {
            this.project_name = project_name;
        }

        public String getAbsolute_address() {
            return absolute_address;
        }

        public void setAbsolute_address(String absolute_address) {
            this.absolute_address = absolute_address;
        }

        public int getBroker_num() {
            return broker_num;
        }

        public void setBroker_num(int broker_num) {
            this.broker_num = broker_num;
        }

        public int getProject_id() {
            return project_id;
        }

        public void setProject_id(int project_id) {
            this.project_id = project_id;
        }

        public String getCurrent_state() {
            return current_state;
        }

        public void setCurrent_state(String current_state) {
            this.current_state = current_state;
        }

        public String getPay_time() {
            return pay_time;
        }

        public void setPay_time(String pay_time) {
            this.pay_time = pay_time;
        }

        public int getDebit() {
            return debit;
        }

        public void setDebit(int debit) {
            this.debit = debit;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getVisit_time() {
            return visit_time;
        }

        public void setVisit_time(String visit_time) {
            this.visit_time = visit_time;
        }

        public String getAllot_time() {
            return allot_time;
        }

        public void setAllot_time(String allot_time) {
            this.allot_time = allot_time;
        }

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public List<ProcessBean> getProcess() {
            return process;
        }

        public void setProcess(List<ProcessBean> process) {
            this.process = process;
        }

        public static class ProcessBean {
            /**
             * process_name : 推荐
             * time : 2018-07-03 11:00:13
             */

            private String process_name;
            private String time;

            public String getProcess_name() {
                return process_name;
            }

            public void setProcess_name(String process_name) {
                this.process_name = process_name;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }
    }
}
