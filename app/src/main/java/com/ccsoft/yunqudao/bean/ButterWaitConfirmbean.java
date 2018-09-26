package com.ccsoft.yunqudao.bean;

import java.util.List;

public class ButterWaitConfirmbean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"client_id":918,"name":"2","broker_id":22,"tel":"15082386252","project_id":1,"sex":2,"yunsuan_url":"39.108.60.120:10000","yunsuan_id":13,"create_time":"2018-08-24 17:58:05","visit_confirm_time":1440,"project_name":"翡翠滨江","province":"510000","city":"510700","district":"510722","absolute_address":"四川省绵阳市三台县涪滨路","consulatent_advicer_id":20,"province_name":"四川省","city_name":"绵阳市","district_name":"三台县","timsLimit":"2018-08-25 17:58:05"},{"client_id":911,"name":"1231","broker_id":4,"tel":"15983804766","project_id":1,"sex":0,"yunsuan_url":"39.108.60.120:10000","yunsuan_id":13,"create_time":"2018-08-23 20:56:28","visit_confirm_time":1440,"project_name":"翡翠滨江","province":"510000","city":"510700","district":"510722","absolute_address":"四川省绵阳市三台县涪滨路","consulatent_advicer_id":0,"province_name":"四川省","city_name":"绵阳市","district_name":"三台县","timsLimit":"2018-08-24 20:56:28"},{"client_id":910,"name":"问假期","broker_id":4,"tel":"13438339177","project_id":1,"sex":1,"yunsuan_url":"39.108.60.120:10000","yunsuan_id":13,"create_time":"2018-08-23 20:53:35","visit_confirm_time":1440,"project_name":"翡翠滨江","province":"510000","city":"510700","district":"510722","absolute_address":"四川省绵阳市三台县涪滨路","consulatent_advicer_id":0,"province_name":"四川省","city_name":"绵阳市","district_name":"三台县","timsLimit":"2018-08-24 20:53:35"},{"client_id":909,"name":"问价起","broker_id":4,"tel":"15983804761","project_id":1,"sex":0,"yunsuan_url":"39.108.60.120:10000","yunsuan_id":13,"create_time":"2018-08-23 20:50:02","visit_confirm_time":1440,"project_name":"翡翠滨江","province":"510000","city":"510700","district":"510722","absolute_address":"四川省绵阳市三台县涪滨路","consulatent_advicer_id":0,"province_name":"四川省","city_name":"绵阳市","district_name":"三台县","timsLimit":"2018-08-24 20:50:02"},{"client_id":908,"name":"33","broker_id":3,"tel":"13493939292","project_id":1,"sex":0,"yunsuan_url":"39.108.60.120:10000","yunsuan_id":13,"create_time":"2018-08-23 20:43:31","visit_confirm_time":1440,"project_name":"翡翠滨江","province":"510000","city":"510700","district":"510722","absolute_address":"四川省绵阳市三台县涪滨路","consulatent_advicer_id":0,"province_name":"四川省","city_name":"绵阳市","district_name":"三台县","timsLimit":"2018-08-24 20:43:31"}],"first_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/waitConfirm?page=1","from":1,"last_page":1,"last_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/waitConfirm?page=1","next_page_url":null,"path":"http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/waitConfirm","per_page":15,"prev_page_url":null,"to":5,"total":5}
     */

    private int code;
    private String msg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * current_page : 1
         * data : [{"client_id":918,"name":"2","broker_id":22,"tel":"15082386252","project_id":1,"sex":2,"yunsuan_url":"39.108.60.120:10000","yunsuan_id":13,"create_time":"2018-08-24 17:58:05","visit_confirm_time":1440,"project_name":"翡翠滨江","province":"510000","city":"510700","district":"510722","absolute_address":"四川省绵阳市三台县涪滨路","consulatent_advicer_id":20,"province_name":"四川省","city_name":"绵阳市","district_name":"三台县","timsLimit":"2018-08-25 17:58:05"},{"client_id":911,"name":"1231","broker_id":4,"tel":"15983804766","project_id":1,"sex":0,"yunsuan_url":"39.108.60.120:10000","yunsuan_id":13,"create_time":"2018-08-23 20:56:28","visit_confirm_time":1440,"project_name":"翡翠滨江","province":"510000","city":"510700","district":"510722","absolute_address":"四川省绵阳市三台县涪滨路","consulatent_advicer_id":0,"province_name":"四川省","city_name":"绵阳市","district_name":"三台县","timsLimit":"2018-08-24 20:56:28"},{"client_id":910,"name":"问假期","broker_id":4,"tel":"13438339177","project_id":1,"sex":1,"yunsuan_url":"39.108.60.120:10000","yunsuan_id":13,"create_time":"2018-08-23 20:53:35","visit_confirm_time":1440,"project_name":"翡翠滨江","province":"510000","city":"510700","district":"510722","absolute_address":"四川省绵阳市三台县涪滨路","consulatent_advicer_id":0,"province_name":"四川省","city_name":"绵阳市","district_name":"三台县","timsLimit":"2018-08-24 20:53:35"},{"client_id":909,"name":"问价起","broker_id":4,"tel":"15983804761","project_id":1,"sex":0,"yunsuan_url":"39.108.60.120:10000","yunsuan_id":13,"create_time":"2018-08-23 20:50:02","visit_confirm_time":1440,"project_name":"翡翠滨江","province":"510000","city":"510700","district":"510722","absolute_address":"四川省绵阳市三台县涪滨路","consulatent_advicer_id":0,"province_name":"四川省","city_name":"绵阳市","district_name":"三台县","timsLimit":"2018-08-24 20:50:02"},{"client_id":908,"name":"33","broker_id":3,"tel":"13493939292","project_id":1,"sex":0,"yunsuan_url":"39.108.60.120:10000","yunsuan_id":13,"create_time":"2018-08-23 20:43:31","visit_confirm_time":1440,"project_name":"翡翠滨江","province":"510000","city":"510700","district":"510722","absolute_address":"四川省绵阳市三台县涪滨路","consulatent_advicer_id":0,"province_name":"四川省","city_name":"绵阳市","district_name":"三台县","timsLimit":"2018-08-24 20:43:31"}]
         * first_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/waitConfirm?page=1
         * from : 1
         * last_page : 1
         * last_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/waitConfirm?page=1
         * next_page_url : null
         * path : http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/waitConfirm
         * per_page : 15
         * prev_page_url : null
         * to : 5
         * total : 5
         */

        private int current_page;
        private String first_page_url;
        private int from;
        private int last_page;
        private String last_page_url;
        private Object next_page_url;
        private String path;
        private int per_page;
        private Object prev_page_url;
        private int to;
        private int total;
        private int tel_complete_state;

        public int getTel_complete_state() {
            return tel_complete_state;
        }

        private List<DataBean> data;

        public int getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(int current_page) {
            this.current_page = current_page;
        }

        public String getFirst_page_url() {
            return first_page_url;
        }

        public void setFirst_page_url(String first_page_url) {
            this.first_page_url = first_page_url;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public int getLast_page() {
            return last_page;
        }

        public void setLast_page(int last_page) {
            this.last_page = last_page;
        }

        public String getLast_page_url() {
            return last_page_url;
        }

        public void setLast_page_url(String last_page_url) {
            this.last_page_url = last_page_url;
        }

        public Object getNext_page_url() {
            return next_page_url;
        }

        public void setNext_page_url(Object next_page_url) {
            this.next_page_url = next_page_url;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public Object getPrev_page_url() {
            return prev_page_url;
        }

        public void setPrev_page_url(Object prev_page_url) {
            this.prev_page_url = prev_page_url;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * client_id : 918
             * name : 2
             * broker_id : 22
             * tel : 15082386252
             * project_id : 1
             * sex : 2
             * yunsuan_url : 39.108.60.120:10000
             * yunsuan_id : 13
             * create_time : 2018-08-24 17:58:05
             * visit_confirm_time : 1440
             * project_name : 翡翠滨江
             * province : 510000
             * city : 510700
             * district : 510722
             * absolute_address : 四川省绵阳市三台县涪滨路
             * consulatent_advicer_id : 20
             * province_name : 四川省
             * city_name : 绵阳市
             * district_name : 三台县
             * timsLimit : 2018-08-25 17:58:05
             */

            private int client_id;
            private String name;
            private int broker_id;
            private String tel;
            private int project_id;
            private int sex;
            private String yunsuan_url;
            private int yunsuan_id;
            private String create_time;
            private int visit_confirm_time;
            private String project_name;
            private String province;
            private String city;
            private String district;
            private String absolute_address;
            private int consulatent_advicer_id;
            private String province_name;
            private String city_name;
            private String district_name;
            private String timsLimit;
            private int tel_complete_state;

            public int getTel_complete_state() {
                return tel_complete_state;
            }

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

            public int getBroker_id() {
                return broker_id;
            }

            public void setBroker_id(int broker_id) {
                this.broker_id = broker_id;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public int getProject_id() {
                return project_id;
            }

            public void setProject_id(int project_id) {
                this.project_id = project_id;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
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

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public int getVisit_confirm_time() {
                return visit_confirm_time;
            }

            public void setVisit_confirm_time(int visit_confirm_time) {
                this.visit_confirm_time = visit_confirm_time;
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

            public int getConsulatent_advicer_id() {
                return consulatent_advicer_id;
            }

            public void setConsulatent_advicer_id(int consulatent_advicer_id) {
                this.consulatent_advicer_id = consulatent_advicer_id;
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

            public String getTimsLimit() {
                return timsLimit;
            }

            public void setTimsLimit(String timsLimit) {
                this.timsLimit = timsLimit;
            }
        }
    }
}
