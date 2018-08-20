package com.ccsoft.yunqudao.bean;

import java.util.List;

public class AppealDetailBean {


    /**
     * code : 200
     * msg : 查询成功
     * data : {"client_id":545,"recommend_time":"2018-06-22 15:01:17","disabled_time":"2018-06-25 10:12:24","state":"处理中","solve_info":"","type":"申述类型3","comment":"呵呵","disabled_state":"自然失效","disabled_reason":"超过保护期限制","visit_time":"2018-06-22 15:02:00","project_name":"翡翠滨江","province":"510000","city":"510700","district":"510722","absolute_address":"三台县北坝会仙路与涪滨路交汇处","name":"实验2","tel":"13458795649","sex":0,"visit_num":3,"property_advicer_wish":"朱萍","butter_name":"温家琪","butter_tel":"13438339177","broker_name":"","broker_tel":"15082245107","province_name":"四川省","city_name":"绵阳市","district_name":"三台县","process":[{"process_name":"无效","time":"2018-06-25 10:12:24"},{"process_name":"申述时间","time":"2018-06-25 10:55:03"}]}
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
         * client_id : 545
         * recommend_time : 2018-06-22 15:01:17
         * disabled_time : 2018-06-25 10:12:24
         * state : 处理中
         * solve_info :
         * type : 申述类型3
         * comment : 呵呵
         * disabled_state : 自然失效
         * disabled_reason : 超过保护期限制
         * visit_time : 2018-06-22 15:02:00
         * project_name : 翡翠滨江
         * province : 510000
         * city : 510700
         * district : 510722
         * absolute_address : 三台县北坝会仙路与涪滨路交汇处
         * name : 实验2
         * tel : 13458795649
         * sex : 0
         * visit_num : 3
         * property_advicer_wish : 朱萍
         * butter_name : 温家琪
         * butter_tel : 13438339177
         * broker_name :
         * broker_tel : 15082245107
         * province_name : 四川省
         * city_name : 绵阳市
         * district_name : 三台县
         * process : [{"process_name":"无效","time":"2018-06-25 10:12:24"},{"process_name":"申述时间","time":"2018-06-25 10:55:03"}]
         */

        private int client_id;
        private String recommend_time;
        private String disabled_time;
        private String state;
        private String solve_info;
        private String type;
        private String comment;
        private String disabled_state;
        private String disabled_reason;
        private String visit_time;
        private String project_name;
        private String province;
        private String city;
        private String district;
        private String absolute_address;
        private String name;
        private String tel;
        private int sex;
        private int visit_num;
        private String property_advicer_wish;
        private String butter_name;
        private String butter_tel;
        public String consultant_advicer;

        public void setConsultant_advicer(String consultant_advicer) {
            this.consultant_advicer = consultant_advicer;
        }

        public String getConsultant_advicer() {

            return consultant_advicer;
        }

        public String getConfirm_name() {
            return confirm_name;
        }

        public String getConfirm_tel() {
            return confirm_tel;
        }

        public void setConfirm_name(String confirm_name) {

            this.confirm_name = confirm_name;
        }

        public void setConfirm_tel(String confirm_tel) {
            this.confirm_tel = confirm_tel;
        }

        private String broker_name;
        private String broker_tel;
        private String province_name;
        private String city_name;
        private String district_name;
        private String confirm_name;
        private String confirm_tel;
        private List<ProcessBean> process;

        public int getClient_id() {
            return client_id;
        }

        public void setClient_id(int client_id) {
            this.client_id = client_id;
        }

        public String getRecommend_time() {
            return recommend_time;
        }

        public void setRecommend_time(String recommend_time) {
            this.recommend_time = recommend_time;
        }

        public String getDisabled_time() {
            return disabled_time;
        }

        public void setDisabled_time(String disabled_time) {
            this.disabled_time = disabled_time;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getSolve_info() {
            return solve_info;
        }

        public void setSolve_info(String solve_info) {
            this.solve_info = solve_info;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getDisabled_state() {
            return disabled_state;
        }

        public void setDisabled_state(String disabled_state) {
            this.disabled_state = disabled_state;
        }

        public String getDisabled_reason() {
            return disabled_reason;
        }

        public void setDisabled_reason(String disabled_reason) {
            this.disabled_reason = disabled_reason;
        }

        public String getVisit_time() {
            return visit_time;
        }

        public void setVisit_time(String visit_time) {
            this.visit_time = visit_time;
        }

        public String getProject_name() {
            return project_name;
        }

        public void setProject_name(String project_name) {
            this.project_name = project_name;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getAbsolute_address() {
            return absolute_address;
        }

        public void setAbsolute_address(String absolute_address) {
            this.absolute_address = absolute_address;
        }

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

        public int getVisit_num() {
            return visit_num;
        }

        public void setVisit_num(int visit_num) {
            this.visit_num = visit_num;
        }

        public String getProperty_advicer_wish() {
            return property_advicer_wish;
        }

        public void setProperty_advicer_wish(String property_advicer_wish) {
            this.property_advicer_wish = property_advicer_wish;
        }

        public String getButter_name() {
            return butter_name;
        }

        public void setButter_name(String butter_name) {
            this.butter_name = butter_name;
        }

        public String getButter_tel() {
            return butter_tel;
        }

        public void setButter_tel(String butter_tel) {
            this.butter_tel = butter_tel;
        }

        public String getBroker_name() {
            return broker_name;
        }

        public void setBroker_name(String broker_name) {
            this.broker_name = broker_name;
        }

        public String getBroker_tel() {
            return broker_tel;
        }

        public void setBroker_tel(String broker_tel) {
            this.broker_tel = broker_tel;
        }

        public String getProvince_name() {
            return province_name;
        }

        public void setProvince_name(String province_name) {
            this.province_name = province_name;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getDistrict_name() {
            return district_name;
        }

        public void setDistrict_name(String district_name) {
            this.district_name = district_name;
        }

        public List<ProcessBean> getProcess() {
            return process;
        }

        public void setProcess(List<ProcessBean> process) {
            this.process = process;
        }

        public static class ProcessBean {
            /**
             * process_name : 无效
             * time : 2018-06-25 10:12:24
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
