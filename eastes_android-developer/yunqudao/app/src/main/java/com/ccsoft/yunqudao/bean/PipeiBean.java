package com.ccsoft.yunqudao.bean;

import java.util.ArrayList;
import java.util.List;

public class PipeiBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"list":[{"project_id":6,"project_name":"翡翠滨江","project_tags":"125,126,127","min_price":0,"max_price":0,"decoration_standard":"毛胚","img_url":"upload/project/img/06.jpg","province":"510000","city":"510700","district":"510722","absolute_address":"三台县北坝会仙路与涪滨路交汇处","sort":1,"brokerSortCompare":0,"cycle":3,"province_name":"四川省","city_name":"绵阳市","district_name":"三台县","property_tags":[59,60,62],"score":"65.96"}],"recommend_project":[{"current_state":1,"project_name":"翡翠滨江","disabled_state":0,"state_change_time":"2018-06-20 15:42:04"}]}
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
        private List<ListBean> list;
        private List<RecommendProjectBean> recommend_project;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<RecommendProjectBean> getRecommend_project() {
            return recommend_project;
        }

        public void setRecommend_project(List<RecommendProjectBean> recommend_project) {
            this.recommend_project = recommend_project;
        }

        public static class ListBean {
            /**
             * project_id : 6
             * project_name : 翡翠滨江
             * project_tags : 125,126,127
             * min_price : 0
             * max_price : 0
             * decoration_standard : 毛胚
             * img_url : upload/project/img/06.jpg
             * province : 510000
             * city : 510700
             * district : 510722
             * absolute_address : 三台县北坝会仙路与涪滨路交汇处
             * sort : 1
             * brokerSortCompare : 0
             * cycle : 3
             * province_name : 四川省
             * city_name : 绵阳市
             * district_name : 三台县
             * property_tags : [59,60,62]
             * score : 65.96
             */

            private int project_id;
            private String project_name;
            private String project_tags;
            private int min_price;
            private int max_price;
            private String decoration_standard;
            private String img_url;
            private String province;
            private String city;
            private String district;
            private String absolute_address;
            private int sort;
            private int brokerSortCompare;
            private int cycle;
            private String province_name;
            private String city_name;
            private String district_name;
            private String score;
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

            public String getProject_tags() {
                return project_tags;
            }

            public void setProject_tags(String project_tags) {
                this.project_tags = project_tags;
            }

            public int getMin_price() {
                return min_price;
            }

            public void setMin_price(int min_price) {
                this.min_price = min_price;
            }

            public int getMax_price() {
                return max_price;
            }

            public void setMax_price(int max_price) {
                this.max_price = max_price;
            }

            public String getDecoration_standard() {
                return decoration_standard;
            }

            public void setDecoration_standard(String decoration_standard) {
                this.decoration_standard = decoration_standard;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
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

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public int getBrokerSortCompare() {
                return brokerSortCompare;
            }

            public void setBrokerSortCompare(int brokerSortCompare) {
                this.brokerSortCompare = brokerSortCompare;
            }

            public int getCycle() {
                return cycle;
            }

            public void setCycle(int cycle) {
                this.cycle = cycle;
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

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public List<Integer> getProperty_tags() {
                return property_tags;
            }

            public void setProperty_tags(List<Integer> property_tags) {
                this.property_tags = property_tags;
            }
        }

        public static class RecommendProjectBean {
            /**
             * current_state : 1
             * project_name : 翡翠滨江
             * disabled_state : 0
             * state_change_time : 2018-06-20 15:42:04
             */

            private int current_state;
            private String project_name;
            private int disabled_state;
            private String state_change_time;

            public int getCurrent_state() {
                return current_state;
            }

            public void setCurrent_state(int current_state) {
                this.current_state = current_state;
            }

            public String getProject_name() {
                return project_name;
            }

            public void setProject_name(String project_name) {
                this.project_name = project_name;
            }

            public int getDisabled_state() {
                return disabled_state;
            }

            public void setDisabled_state(int disabled_state) {
                this.disabled_state = disabled_state;
            }

            public String getState_change_time() {
                return state_change_time;
            }

            public void setState_change_time(String state_change_time) {
                this.state_change_time = state_change_time;
            }
        }
    }
}
