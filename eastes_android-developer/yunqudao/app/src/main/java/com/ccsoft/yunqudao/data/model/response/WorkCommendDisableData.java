package com.ccsoft.yunqudao.data.model.response;

import com.ccsoft.yunqudao.data.base.BaseData;

/**
 * author lzx
 * Created on 2018/5/28.
 */

public class WorkCommendDisableData extends BaseData {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"client_id":370,"create_time":"2018-05-25 16:50:37","project_id":7,"broker_name":"黄怡","broker_tel":"18048629690","project_name":"链家大唐公馆","province":"510000","city":"510100","district":"510124","absolute_address":"太阳","disabled_state":"自然失效","disabled_reason":"超过保护期限制","state_change_time":"2018-05-26 11:20:41","client_info_id":187,"name":"墨迹了","sex":0,"tel":"15400000003","client_need_id":175,"disabled_time":"2018-05-26 11:20:41","province_name":"四川省","city_name":"成都市","district_name":"郫县"}
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
         * client_id : 370
         * create_time : 2018-05-25 16:50:37
         * project_id : 7
         * broker_name : 黄怡
         * broker_tel : 18048629690
         * project_name : 链家大唐公馆
         * province : 510000
         * city : 510100
         * district : 510124
         * absolute_address : 太阳
         * disabled_state : 自然失效
         * disabled_reason : 超过保护期限制
         * state_change_time : 2018-05-26 11:20:41
         * client_info_id : 187
         * name : 墨迹了
         * sex : 0
         * tel : 15400000003
         * client_need_id : 175
         * disabled_time : 2018-05-26 11:20:41
         * province_name : 四川省
         * city_name : 成都市
         * district_name : 郫县
         */

        private int client_id;
        private String create_time;
        private int    project_id;
        private String broker_name;
        private String broker_tel;
        private String project_name;
        private String province;
        private String city;
        private String district;
        private String absolute_address;
        private String disabled_state;
        private String disabled_reason;
        private String state_change_time;
        private int    client_info_id;
        private String name;
        private int    sex;
        private String tel;
        private int    client_need_id;
        private String disabled_time;
        private String province_name;
        private String city_name;
        private String district_name;
        private String consultant_advicer;

        public String getConsultant_advicer() {
            return consultant_advicer;
        }

        public void setConsultant_advicer(String consultant_advicer) {
            this.consultant_advicer = consultant_advicer;
        }

        public int getClient_id() { return client_id;}

        public void setClient_id(int client_id) { this.client_id = client_id;}

        public String getCreate_time() { return create_time;}

        public void setCreate_time(String create_time) { this.create_time = create_time;}

        public int getProject_id() { return project_id;}

        public void setProject_id(int project_id) { this.project_id = project_id;}

        public String getBroker_name() { return broker_name;}

        public void setBroker_name(String broker_name) { this.broker_name = broker_name;}

        public String getBroker_tel() { return broker_tel;}

        public void setBroker_tel(String broker_tel) { this.broker_tel = broker_tel;}

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

        public String getDisabled_state() { return disabled_state;}

        public void setDisabled_state(String disabled_state) { this.disabled_state = disabled_state;}

        public String getDisabled_reason() { return disabled_reason;}

        public void setDisabled_reason(String disabled_reason) { this.disabled_reason = disabled_reason;}

        public String getState_change_time() { return state_change_time;}

        public void setState_change_time(String state_change_time) { this.state_change_time = state_change_time;}

        public int getClient_info_id() { return client_info_id;}

        public void setClient_info_id(int client_info_id) { this.client_info_id = client_info_id;}

        public String getName() { return name;}

        public void setName(String name) { this.name = name;}

        public int getSex() { return sex;}

        public void setSex(int sex) { this.sex = sex;}

        public String getTel() { return tel;}

        public void setTel(String tel) { this.tel = tel;}

        public int getClient_need_id() { return client_need_id;}

        public void setClient_need_id(int client_need_id) { this.client_need_id = client_need_id;}

        public String getDisabled_time() { return disabled_time;}

        public void setDisabled_time(String disabled_time) { this.disabled_time = disabled_time;}

        public String getProvince_name() { return province_name;}

        public void setProvince_name(String province_name) { this.province_name = province_name;}

        public String getCity_name() { return city_name;}

        public void setCity_name(String city_name) { this.city_name = city_name;}

        public String getDistrict_name() { return district_name;}

        public void setDistrict_name(String district_name) { this.district_name = district_name;}
    }
}
