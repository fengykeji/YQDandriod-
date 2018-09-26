package com.ccsoft.yunqudao.data.model.response;

import com.ccsoft.yunqudao.data.base.BaseData;

/**
 * author lzx
 * Created on 2018/5/28.
 */

public class WorkReportVerifyDetailData extends BaseData {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"client_id":371,"create_time":"2018-05-25 16:50:58","valid_visit_time":4,"name":"墨迹了","sex":0,"tel":"15400000003","butter_name":"谷治墙","butter_tel":"15983804766","project_name":"大唐公馆","province":"510000","city":"510100","district":"510124","absolute_address":"月球","project_id":3,"broker_name":"黄怡","broker_tel":"18048629690","visit_num":2,"visit_time":"2018-05-25 16:51:00","property_advicer_wish":"周静","confirm_name":"墨迹了","confirm_tel":"15400000003","province_name":"四川省","city_name":"成都市","district_name":"郫县","timeLimit":1527583858,"property_type":"别墅"}
     */

    private int code;
    private String   msg;
    private DataBean data;

    public int getCode() { return code;}

    public void setCode(int code) { this.code = code;}

    public String getMsg() { return msg;}

    public void setMsg(String msg) { this.msg = msg;}

    public DataBean getData() { return data;}

    public void setData(DataBean data) { this.data = data;}

    public static class DataBean {
        /**
         * client_id : 371
         * create_time : 2018-05-25 16:50:58
         * valid_visit_time : 4
         * name : 墨迹了
         * sex : 0
         * tel : 15400000003
         * butter_name : 谷治墙
         * butter_tel : 15983804766
         * project_name : 大唐公馆
         * province : 510000
         * city : 510100
         * district : 510124
         * absolute_address : 月球
         * project_id : 3
         * broker_name : 黄怡
         * broker_tel : 18048629690
         * visit_num : 2
         * visit_time : 2018-05-25 16:51:00
         * property_advicer_wish : 周静
         * confirm_name : 墨迹了
         * confirm_tel : 15400000003
         * province_name : 四川省
         * city_name : 成都市
         * district_name : 郫县
         * timeLimit : 1527583858
         * property_type : 别墅
         */

        private int client_id;
        private String create_time;
        private int    valid_visit_time;
        private String name;
        private int    sex;
        private String tel;
        private String butter_name;
        private String butter_tel;
        private String project_name;
        private String province;
        private String city;
        private String district;
        private String absolute_address;
        private int    project_id;
        private String broker_name;
        private String broker_tel;
        private int    visit_num;
        private String visit_time;
        private String property_advicer_wish;
        private String confirm_name;
        private String confirm_tel;
        private String province_name;
        private String city_name;
        private String district_name;
        private int    timeLimit;
        private String property_type;
        private String comsulatent_advicer;
        public String recommend_type;
        public String comsulatent_advicer_tel;

        public String getComsultant_advicer() {
            return comsulatent_advicer;
        }

        public String comsulatent_advicer_company;
        public String client_comment;

        public void setRecommend_type(String recommend_type) {
            this.recommend_type = recommend_type;
        }

        public void setComsulatent_advicer_tel(String comsulatent_advicer_tel) {
            this.comsulatent_advicer_tel = comsulatent_advicer_tel;
        }

        public void setComsulatent_advicer_company(String comsulatent_advicer_company) {
            this.comsulatent_advicer_company = comsulatent_advicer_company;
        }

        public void setClient_comment(String client_comment) {
            this.client_comment = client_comment;
        }

        public String getRecommend_type() {

            return recommend_type;
        }

        public String getComsulatent_advicer_tel() {
            return comsulatent_advicer_tel;
        }

        public String getComsulatent_advicer_company() {
            return comsulatent_advicer_company;
        }

        public String getClient_comment() {
            return client_comment;
        }





        public int getClient_id() { return client_id;}

        public void setClient_id(int client_id) { this.client_id = client_id;}

        public String getCreate_time() { return create_time;}

        public void setCreate_time(String create_time) { this.create_time = create_time;}

        public int getValid_visit_time() { return valid_visit_time;}

        public void setValid_visit_time(int valid_visit_time) { this.valid_visit_time = valid_visit_time;}

        public String getName() { return name;}

        public void setName(String name) { this.name = name;}

        public int getSex() { return sex;}

        public void setSex(int sex) { this.sex = sex;}

        public String getTel() { return tel;}

        public void setTel(String tel) { this.tel = tel;}

        public String getButter_name() { return butter_name;}

        public void setButter_name(String butter_name) { this.butter_name = butter_name;}

        public String getButter_tel() { return butter_tel;}

        public void setButter_tel(String butter_tel) { this.butter_tel = butter_tel;}

        public String getProject_name() { return project_name;}

        public void setProject_name(String project_name) { this.project_name = project_name;}

        public String getProvince() { return province;}

        public void setProvince(String province) { this.province = province;}

        public String getCity() { return city;}

        public void setCity(String city) { this.city = city;}

        public String getDistrict() { return district;}

        public void setDistrict(String district) { this.district = district;}

        public String getAbsolute_address() { return absolute_address;}

        public void setAbsolute_address(String absolute_address) { this.absolute_address = absolute_address;}

        public int getProject_id() { return project_id;}

        public void setProject_id(int project_id) { this.project_id = project_id;}

        public String getBroker_name() { return broker_name;}

        public void setBroker_name(String broker_name) { this.broker_name = broker_name;}

        public String getBroker_tel() { return broker_tel;}

        public void setBroker_tel(String broker_tel) { this.broker_tel = broker_tel;}

        public int getVisit_num() { return visit_num;}

        public void setVisit_num(int visit_num) { this.visit_num = visit_num;}

        public String getVisit_time() { return visit_time;}

        public void setVisit_time(String visit_time) { this.visit_time = visit_time;}

        public String getProperty_advicer_wish() { return property_advicer_wish;}

        public void setProperty_advicer_wish(String property_advicer_wish) { this.property_advicer_wish = property_advicer_wish;}

        public String getConfirm_name() { return confirm_name;}

        public void setConfirm_name(String confirm_name) { this.confirm_name = confirm_name;}

        public String getConfirm_tel() { return confirm_tel;}

        public void setConfirm_tel(String confirm_tel) { this.confirm_tel = confirm_tel;}

        public String getProvince_name() { return province_name;}

        public void setProvince_name(String province_name) { this.province_name = province_name;}

        public String getCity_name() { return city_name;}

        public void setCity_name(String city_name) { this.city_name = city_name;}

        public String getDistrict_name() { return district_name;}

        public void setDistrict_name(String district_name) { this.district_name = district_name;}

        public int getTimeLimit() { return timeLimit;}

        public void setTimeLimit(int timeLimit) { this.timeLimit = timeLimit;}

        public String getProperty_type() { return property_type;}

        public void setProperty_type(String property_type) { this.property_type = property_type;}
    }
}
