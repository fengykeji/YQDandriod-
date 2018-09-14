package com.ccsoft.yunqudao.bean;

public class DuiJieDaiQueRenDetail {


    /**
     * code : 200
     * msg : 查询成功
     * data : {"client_id":925,"create_time":"2018-08-24 20:52:35","name":"1","sex":0,"tel":"13980583201","yunsuan_url":"39.108.60.120:10000","yunsuan_id":13,"broker_id":86,"project_id":1,"project_name":"翡翠滨江","province":"510000","city":"510700","district":"510722","absolute_address":"四川省绵阳市三台县涪滨路","broker_name":"547","broker_tel":"15983804766","disabled_state":0,"consulatent_advicer_id":20,"client_comment":"","is_deal":0,"timeLimit":1535201555,"property_type":"住宅","province_name":"四川省","city_name":"绵阳市","district_name":"三台县","recommend_type":"全民","comsulatent_advicer":"销售代理公司/朱萍/13086680768"}
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
         * client_id : 925
         * create_time : 2018-08-24 20:52:35
         * name : 1
         * sex : 0
         * tel : 13980583201
         * yunsuan_url : 39.108.60.120:10000
         * yunsuan_id : 13
         * broker_id : 86
         * project_id : 1
         * project_name : 翡翠滨江
         * province : 510000
         * city : 510700
         * district : 510722
         * absolute_address : 四川省绵阳市三台县涪滨路
         * broker_name : 547
         * broker_tel : 15983804766
         * disabled_state : 0
         * consulatent_advicer_id : 20
         * client_comment :
         * is_deal : 0
         * timeLimit : 1535201555
         * property_type : 住宅
         * province_name : 四川省
         * city_name : 绵阳市
         * district_name : 三台县
         * recommend_type : 全民
         * comsulatent_advicer : 销售代理公司/朱萍/13086680768
         */

        private int client_id;
        private String create_time;
        private String name;
        private int sex;
        private String tel;
        private String yunsuan_url;
        private int yunsuan_id;
        private int broker_id;
        private int project_id;
        private String project_name;
        private String province;
        private String city;
        private String district;
        private String absolute_address;
        private String broker_name;
        private String broker_tel;
        private int disabled_state;
        private int consulatent_advicer_id;
        private String client_comment;
        private int is_deal;
        private int timeLimit;
        private String property_type;
        private String province_name;
        private String city_name;
        private String district_name;
        private String recommend_type;
        private String comsulatent_advicer;
        public String comsulatent_advicer_tel;
        public String comsulatent_advicer_company;
        private int tel_complete_state;

        public int getTel_complete_state() {
            return tel_complete_state;
        }

        public String getComsulatent_advicer_company() {
            return comsulatent_advicer_company;
        }

        public String getComsulatent_advicer_tel() {

            return comsulatent_advicer_tel;
        }

        public int getClient_id() {
            return client_id;
        }

        public void setClient_id(int client_id) {
            this.client_id = client_id;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getYunsuan_url() {
            return yunsuan_url;
        }

        public void setYunsuan_url(String yunsuan_url) {
            this.yunsuan_url = yunsuan_url;
        }

        public int getYunsuan_id() {
            return yunsuan_id;
        }

        public void setYunsuan_id(int yunsuan_id) {
            this.yunsuan_id = yunsuan_id;
        }

        public int getBroker_id() {
            return broker_id;
        }

        public void setBroker_id(int broker_id) {
            this.broker_id = broker_id;
        }

        public int getProject_id() {
            return project_id;
        }

        public void setProject_id(int project_id) {
            this.project_id = project_id;
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

        public int getDisabled_state() {
            return disabled_state;
        }

        public void setDisabled_state(int disabled_state) {
            this.disabled_state = disabled_state;
        }

        public int getConsulatent_advicer_id() {
            return consulatent_advicer_id;
        }

        public void setConsulatent_advicer_id(int consulatent_advicer_id) {
            this.consulatent_advicer_id = consulatent_advicer_id;
        }

        public String getClient_comment() {
            return client_comment;
        }

        public void setClient_comment(String client_comment) {
            this.client_comment = client_comment;
        }

        public int getIs_deal() {
            return is_deal;
        }

        public void setIs_deal(int is_deal) {
            this.is_deal = is_deal;
        }

        public int getTimeLimit() {
            return timeLimit;
        }

        public void setTimeLimit(int timeLimit) {
            this.timeLimit = timeLimit;
        }

        public String getProperty_type() {
            return property_type;
        }

        public void setProperty_type(String property_type) {
            this.property_type = property_type;
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

        public String getRecommend_type() {
            return recommend_type;
        }

        public void setRecommend_type(String recommend_type) {
            this.recommend_type = recommend_type;
        }

        public String getComsulatent_advicer() {
            return comsulatent_advicer;
        }

        public void setComsulatent_advicer(String comsulatent_advicer) {
            this.comsulatent_advicer = comsulatent_advicer;
        }
    }
}
