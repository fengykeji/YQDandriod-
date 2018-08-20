package com.ccsoft.yunqudao.bean;

import java.util.List;

public class WorkDealedDetailBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"client_id":408,"name":"不知道","project_name":"传化广场","tel":"15896965656","sex":0,"current_state":"签约","contract_num":"233","total_money":457688,"inner_area":41.52,"update_time":"2018-06-05 09:24:06","house_info":"3栋2702","province":"510000","city":"510100","district":"510124","project_id":1,"create_time":"2018-06-05 17:14:47","visit_time":"2018-06-05 17:20:00","allot_time":"2018-06-05 17:21:42","butter_name":"云算对接人","butter_tel":"15082245102","broker_name":"","broker_tel":"15082245107","property_advicer_wish":"郑爽","visit_num":1,"confirm_name":"不知道","confirm_tel":"15896965656","province_name":"四川省","city_name":"成都市","district_name":"郫县","property_type":"公寓,住宅,商铺","process":[{"process_name":"推荐","time":"2018-06-05 17:14:47"},{"process_name":"到访","time":"2018-06-05 17:20:00"},{"process_name":"确认有效","time":"2018-06-05 17:21:42"},{"process_name":"认购","time":"2018-06-05 17:24:06"},{"process_name":"签约","time":"2018-06-05 17:25:51"}]}
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
         * client_id : 408
         * name : 不知道
         * project_name : 传化广场
         * tel : 15896965656
         * sex : 0
         * current_state : 签约
         * contract_num : 233
         * total_money : 457688
         * inner_area : 41.52
         * update_time : 2018-06-05 09:24:06
         * house_info : 3栋2702
         * province : 510000
         * city : 510100
         * district : 510124
         * project_id : 1
         * create_time : 2018-06-05 17:14:47
         * visit_time : 2018-06-05 17:20:00
         * allot_time : 2018-06-05 17:21:42
         * butter_name : 云算对接人
         * butter_tel : 15082245102
         * broker_name :
         * broker_tel : 15082245107
         * property_advicer_wish : 郑爽
         * visit_num : 1
         * confirm_name : 不知道
         * confirm_tel : 15896965656
         * province_name : 四川省
         * city_name : 成都市
         * district_name : 郫县
         * property_type : 公寓,住宅,商铺
         * process : [{"process_name":"推荐","time":"2018-06-05 17:14:47"},{"process_name":"到访","time":"2018-06-05 17:20:00"},{"process_name":"确认有效","time":"2018-06-05 17:21:42"},{"process_name":"认购","time":"2018-06-05 17:24:06"},{"process_name":"签约","time":"2018-06-05 17:25:51"}]
         */

        private int client_id;
        private String name;
        private String project_name;
        private String tel;
        private int sex;
        private String current_state;
        private String contract_num;
        private int total_money;
        private double inner_area;
        private String update_time;
        private String house_info;
        private String province;
        private String city;
        private String district;
        private int project_id;
        private String create_time;
        private String visit_time;
        private String allot_time;
        private String butter_name;
        private String butter_tel;
        private String broker_name;
        private String broker_tel;
        private String property_advicer_wish;
        private int visit_num;
        private String confirm_name;
        private String confirm_tel;
        private String province_name;
        private String city_name;
        private String district_name;
        private String property_type;
        private String consultant_advicer;

        public void setConsultant_advicer(String consultant_advicer) {
            this.consultant_advicer = consultant_advicer;
        }

        public String getConsultant_advicer() {

            return consultant_advicer;
        }
        private List<ProcessBean> process;

        public int getClient_id() {
            return client_id;
        }

        public void setClient_id(int client_id) {
            this.client_id = client_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProject_name() {
            return project_name;
        }

        public void setProject_name(String project_name) {
            this.project_name = project_name;
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

        public String getCurrent_state() {
            return current_state;
        }

        public void setCurrent_state(String current_state) {
            this.current_state = current_state;
        }

        public String getContract_num() {
            return contract_num;
        }

        public void setContract_num(String contract_num) {
            this.contract_num = contract_num;
        }

        public int getTotal_money() {
            return total_money;
        }

        public void setTotal_money(int total_money) {
            this.total_money = total_money;
        }

        public double getInner_area() {
            return inner_area;
        }

        public void setInner_area(double inner_area) {
            this.inner_area = inner_area;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public String getHouse_info() {
            return house_info;
        }

        public void setHouse_info(String house_info) {
            this.house_info = house_info;
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

        public int getProject_id() {
            return project_id;
        }

        public void setProject_id(int project_id) {
            this.project_id = project_id;
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

        public String getProperty_advicer_wish() {
            return property_advicer_wish;
        }

        public void setProperty_advicer_wish(String property_advicer_wish) {
            this.property_advicer_wish = property_advicer_wish;
        }

        public int getVisit_num() {
            return visit_num;
        }

        public void setVisit_num(int visit_num) {
            this.visit_num = visit_num;
        }

        public String getConfirm_name() {
            return confirm_name;
        }

        public void setConfirm_name(String confirm_name) {
            this.confirm_name = confirm_name;
        }

        public String getConfirm_tel() {
            return confirm_tel;
        }

        public void setConfirm_tel(String confirm_tel) {
            this.confirm_tel = confirm_tel;
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

        public String getProperty_type() {
            return property_type;
        }

        public void setProperty_type(String property_type) {
            this.property_type = property_type;
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
             * time : 2018-06-05 17:14:47
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
