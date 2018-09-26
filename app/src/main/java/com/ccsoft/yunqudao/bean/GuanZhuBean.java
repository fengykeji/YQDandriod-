package com.ccsoft.yunqudao.bean;

import java.util.List;

public class GuanZhuBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : [{"focus_id":29,"project_id":1,"img_url":"upload/project/img/1529910374_21.jpg","project_name":"翡翠滨江","province":"510000","city":"510700","district":"510722","absolute_address":"四川省绵阳市三台县涪滨路","deposit":6000,"sale_state":"待售","guarantee_brokerage":1,"province_name":"四川省","city_name":"绵阳市","district_name":"三台县","property_tags":["住宅","公寓"],"project_tags_name":["涪江畔","景区房","度假村"]}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * focus_id : 29
         * project_id : 1
         * img_url : upload/project/img/1529910374_21.jpg
         * project_name : 翡翠滨江
         * province : 510000
         * city : 510700
         * district : 510722
         * absolute_address : 四川省绵阳市三台县涪滨路
         * deposit : 6000
         * sale_state : 待售
         * guarantee_brokerage : 1
         * province_name : 四川省
         * city_name : 绵阳市
         * district_name : 三台县
         * property_tags : ["住宅","公寓"]
         * project_tags_name : ["涪江畔","景区房","度假村"]
         */

        private int focus_id;
        private int project_id;
        private String img_url;
        private String project_name;
        private String province;
        private String city;
        private String district;
        private String absolute_address;
        private int deposit;
        private String sale_state;
        private int guarantee_brokerage;
        private String province_name;
        private String city_name;
        private String district_name;
        private List<String> property_tags;
        private List<String> project_tags_name;

        public int getFocus_id() {
            return focus_id;
        }

        public void setFocus_id(int focus_id) {
            this.focus_id = focus_id;
        }

        public int getProject_id() {
            return project_id;
        }

        public void setProject_id(int project_id) {
            this.project_id = project_id;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
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

        public int getDeposit() {
            return deposit;
        }

        public void setDeposit(int deposit) {
            this.deposit = deposit;
        }

        public String getSale_state() {
            return sale_state;
        }

        public void setSale_state(String sale_state) {
            this.sale_state = sale_state;
        }

        public int getGuarantee_brokerage() {
            return guarantee_brokerage;
        }

        public void setGuarantee_brokerage(int guarantee_brokerage) {
            this.guarantee_brokerage = guarantee_brokerage;
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

        public List<String> getProperty_tags() {
            return property_tags;
        }

        public void setProperty_tags(List<String> property_tags) {
            this.property_tags = property_tags;
        }

        public List<String> getProject_tags_name() {
            return project_tags_name;
        }

        public void setProject_tags_name(List<String> project_tags_name) {
            this.project_tags_name = project_tags_name;
        }
    }
}
