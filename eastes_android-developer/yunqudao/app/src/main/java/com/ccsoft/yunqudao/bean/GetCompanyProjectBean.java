package com.ccsoft.yunqudao.bean;

import java.util.List;

public class GetCompanyProjectBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"project_id":57,"project_name":"保利房屋","sale_state":"在售","province":"510000","city":"510400","district":"510402","absolute_address":"攀枝花市东区摩尔盈盛-东门","deposit":0,"province_name":"四川省","city_name":"攀枝花市","district_name":"东区","property_tags":["住宅","商铺","车位"],"project_tags_name":["学区房","农产品批发","全时商业潮圣地"]},{"project_id":96,"project_name":"中冶世界","sale_state":"在售","province":"510000","city":"510100","district":"510101","absolute_address":"成都市青羊区成都新城市广场","deposit":0,"province_name":"四川省","city_name":"成都市","district_name":"市辖区","property_tags":["住宅","写字楼","车位"],"project_tags_name":["学区房","五证齐全","地铁房"]}],"first_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/personal/getCompanyProject?page=1","from":1,"last_page":1,"last_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/personal/getCompanyProject?page=1","next_page_url":null,"path":"http://127.0.0.1:2797/lumen/public/index.php/agent/personal/getCompanyProject","per_page":15,"prev_page_url":null,"to":2,"total":2}
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
         * data : [{"project_id":57,"project_name":"保利房屋","sale_state":"在售","province":"510000","city":"510400","district":"510402","absolute_address":"攀枝花市东区摩尔盈盛-东门","deposit":0,"province_name":"四川省","city_name":"攀枝花市","district_name":"东区","property_tags":["住宅","商铺","车位"],"project_tags_name":["学区房","农产品批发","全时商业潮圣地"]},{"project_id":96,"project_name":"中冶世界","sale_state":"在售","province":"510000","city":"510100","district":"510101","absolute_address":"成都市青羊区成都新城市广场","deposit":0,"province_name":"四川省","city_name":"成都市","district_name":"市辖区","property_tags":["住宅","写字楼","车位"],"project_tags_name":["学区房","五证齐全","地铁房"]}]
         * first_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/personal/getCompanyProject?page=1
         * from : 1
         * last_page : 1
         * last_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/personal/getCompanyProject?page=1
         * next_page_url : null
         * path : http://127.0.0.1:2797/lumen/public/index.php/agent/personal/getCompanyProject
         * per_page : 15
         * prev_page_url : null
         * to : 2
         * total : 2
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
             * project_id : 57
             * project_name : 保利房屋
             * sale_state : 在售
             * province : 510000
             * city : 510400
             * district : 510402
             * absolute_address : 攀枝花市东区摩尔盈盛-东门
             * deposit : 0
             * province_name : 四川省
             * city_name : 攀枝花市
             * district_name : 东区
             * property_tags : ["住宅","商铺","车位"]
             * project_tags_name : ["学区房","农产品批发","全时商业潮圣地"]
             */

            private int project_id;
            private String project_name;
            private String sale_state;
            private String province;
            private String city;
            private String district;
            private String absolute_address;
            private int deposit;
            private String province_name;
            private String city_name;
            private String district_name;
            private List<String> property_tags;
            private List<String> project_tags_name;

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

            public String getSale_state() {
                return sale_state;
            }

            public void setSale_state(String sale_state) {
                this.sale_state = sale_state;
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
}
