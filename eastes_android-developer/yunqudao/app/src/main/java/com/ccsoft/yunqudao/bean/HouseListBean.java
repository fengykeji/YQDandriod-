package com.ccsoft.yunqudao.bean;

import java.util.List;

public class HouseListBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : [{"project_id":9,"project_name":"卓越南城一期","province":"510000","city":"510100","district":"510116","project_tags":"132","sale_state":"待售","img_url":"upload/project/img/zy1.jpg","absolute_address":"双流区西航港空港一路一段189号","guarantee_brokerage":0,"sort":0,"cycle":0,"property_tags":[59,60,62,64]},{"project_id":4,"project_name":"链家全民公馆","province":"510000","city":"510100","district":"510124","project_tags":"56,57,104","sale_state":"待售","img_url":"upload/agent/headimg/1523850012_10.jpg","absolute_address":"火星","guarantee_brokerage":0,"sort":1,"cycle":3,"brokerSortCompare":0,"property_tags":[61]},{"project_id":3,"project_name":"大唐公馆","province":"510000","city":"510100","district":"510124","project_tags":"56,57,58","sale_state":"待售","img_url":"upload/agent/headimg/1523850012_10.jpg","absolute_address":"月球","guarantee_brokerage":1,"sort":0,"cycle":0,"property_tags":[61]},{"project_id":2,"project_name":"链家公馆","province":"510000","city":"510100","district":"510124","project_tags":"56,57,58","sale_state":"待售","img_url":"upload/agent/headimg/1523850012_10.jpg","absolute_address":"风的杨希中心","guarantee_brokerage":1,"sort":0,"cycle":0,"property_tags":[59,60,61]}]
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

    @Override
    public String toString() {
        return "HouseListBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        /**
         * project_id : 9
         * project_name : 卓越南城一期
         * province : 510000
         * city : 510100
         * district : 510116
         * project_tags : 132
         * sale_state : 待售
         * img_url : upload/project/img/zy1.jpg
         * absolute_address : 双流区西航港空港一路一段189号
         * guarantee_brokerage : 0
         * sort : 0
         * cycle : 0
         * property_tags : [59,60,62,64]
         * brokerSortCompare : 0
         */

        private int project_id;
        private String project_name;
        private String province;
        private String city;
        private String district;
        private String project_tags;
        private String sale_state;
        private String img_url;
        private String absolute_address;
        private int guarantee_brokerage;
        private int sort;
        private int cycle;
        private int brokerSortCompare;
        private List<Integer> property_tags;

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

        public String getProject_tags() {
            return project_tags;
        }

        public void setProject_tags(String project_tags) {
            this.project_tags = project_tags;
        }

        public String getSale_state() {
            return sale_state;
        }

        public void setSale_state(String sale_state) {
            this.sale_state = sale_state;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public String getAbsolute_address() {
            return absolute_address;
        }

        public void setAbsolute_address(String absolute_address) {
            this.absolute_address = absolute_address;
        }

        public int getGuarantee_brokerage() {
            return guarantee_brokerage;
        }

        public void setGuarantee_brokerage(int guarantee_brokerage) {
            this.guarantee_brokerage = guarantee_brokerage;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getCycle() {
            return cycle;
        }

        public void setCycle(int cycle) {
            this.cycle = cycle;
        }

        public int getBrokerSortCompare() {
            return brokerSortCompare;
        }

        public void setBrokerSortCompare(int brokerSortCompare) {
            this.brokerSortCompare = brokerSortCompare;
        }

        public List<Integer> getProperty_tags() {
            return property_tags;
        }

        public void setProperty_tags(List<Integer> property_tags) {
            this.property_tags = property_tags;
        }
    }
}
