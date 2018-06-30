package com.ccsoft.yunqudao.bean;

import java.util.List;

public class ProjectPiPeiKeHuBean {


    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"client_id":202,"name":"我","sex":0,"tel":"13500088999","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":201,"name":"钉3","sex":1,"tel":"13777546555","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":200,"name":"钉2","sex":1,"tel":"13308167738","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":199,"name":"嘤嘤嘤","sex":1,"tel":"13550653545","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":197,"name":"陆军","sex":0,"tel":"13999779999","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":196,"name":"六六零","sex":1,"tel":"13777002700","property_type":0,"region":[],"total_price":0,"house_type":"","intent":42,"urgency":24},{"client_id":194,"name":"杨二jjj","sex":1,"tel":"18180775035","property_type":61,"total_price":94,"house_type":"32","intent":47,"urgency":47,"region":[{"province":"510000","province_name":"四川省","city":"510100","city_name":"成都市","district":"510108","district_name":"成华区"},{"province":"510000","province_name":"四川省","city":"510100","city_name":"成都市","district":"510101","district_name":"市辖区"},{"province":"510000","province_name":"四川省","city":"510100","city_name":"成都市","district":"510105","district_name":"青羊区"}]},{"client_id":191,"name":"阿鹿头","sex":1,"tel":"15900000085","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":190,"name":"健健康康","sex":1,"tel":"15400000009","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":187,"name":"墨迹了","sex":0,"tel":"15400000003","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":184,"name":"黄6","sex":1,"tel":"18048629690","property_type":59,"total_price":91,"house_type":"106","intent":66,"urgency":61,"region":[{"province":"510000","province_name":"四川省","city":"510100","city_name":"成都市","district":"510101","district_name":"市辖区"}]},{"client_id":181,"name":"黄3","sex":0,"tel":"18048629690","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":180,"name":"黄2","sex":0,"tel":"18048629690","property_type":60,"total_price":92,"house_type":"106","intent":46,"urgency":47,"region":[{"province":"510000","province_name":"四川省","city":"510100","city_name":"成都市","district":"510116","district_name":"双流区"}]},{"client_id":177,"name":"来来来","sex":0,"tel":"15900000001","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":155,"name":"黄1","sex":0,"tel":"18048629690","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0}],"first_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/client/list?page=1","from":1,"last_page":2,"last_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/client/list?page=2","next_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/client/list?page=2","path":"http://127.0.0.1:2797/lumen/public/index.php/agent/client/list","per_page":15,"prev_page_url":null,"to":15,"total":22}
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
         * data : [{"client_id":202,"name":"我","sex":0,"tel":"13500088999","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":201,"name":"钉3","sex":1,"tel":"13777546555","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":200,"name":"钉2","sex":1,"tel":"13308167738","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":199,"name":"嘤嘤嘤","sex":1,"tel":"13550653545","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":197,"name":"陆军","sex":0,"tel":"13999779999","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":196,"name":"六六零","sex":1,"tel":"13777002700","property_type":0,"region":[],"total_price":0,"house_type":"","intent":42,"urgency":24},{"client_id":194,"name":"杨二jjj","sex":1,"tel":"18180775035","property_type":61,"total_price":94,"house_type":"32","intent":47,"urgency":47,"region":[{"province":"510000","province_name":"四川省","city":"510100","city_name":"成都市","district":"510108","district_name":"成华区"},{"province":"510000","province_name":"四川省","city":"510100","city_name":"成都市","district":"510101","district_name":"市辖区"},{"province":"510000","province_name":"四川省","city":"510100","city_name":"成都市","district":"510105","district_name":"青羊区"}]},{"client_id":191,"name":"阿鹿头","sex":1,"tel":"15900000085","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":190,"name":"健健康康","sex":1,"tel":"15400000009","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":187,"name":"墨迹了","sex":0,"tel":"15400000003","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":184,"name":"黄6","sex":1,"tel":"18048629690","property_type":59,"total_price":91,"house_type":"106","intent":66,"urgency":61,"region":[{"province":"510000","province_name":"四川省","city":"510100","city_name":"成都市","district":"510101","district_name":"市辖区"}]},{"client_id":181,"name":"黄3","sex":0,"tel":"18048629690","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":180,"name":"黄2","sex":0,"tel":"18048629690","property_type":60,"total_price":92,"house_type":"106","intent":46,"urgency":47,"region":[{"province":"510000","province_name":"四川省","city":"510100","city_name":"成都市","district":"510116","district_name":"双流区"}]},{"client_id":177,"name":"来来来","sex":0,"tel":"15900000001","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":155,"name":"黄1","sex":0,"tel":"18048629690","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0}]
         * first_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/client/list?page=1
         * from : 1
         * last_page : 2
         * last_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/client/list?page=2
         * next_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/client/list?page=2
         * path : http://127.0.0.1:2797/lumen/public/index.php/agent/client/list
         * per_page : 15
         * prev_page_url : null
         * to : 15
         * total : 22
         */

        private int current_page;
        private String first_page_url;
        private int from;
        private int last_page;
        private String last_page_url;
        private String next_page_url;
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

        public String getNext_page_url() {
            return next_page_url;
        }

        public void setNext_page_url(String next_page_url) {
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
             * client_id : 202
             * name : 我
             * sex : 0
             * tel : 13500088999
             * property_type : 0
             * region : []
             * total_price : 0
             * house_type :
             * intent : 0
             * urgency : 0
             */

            private int client_id;
            private String name;
            private int sex;
            private String tel;
            private int property_type;
            private int total_price;
            private String house_type;
            private int intent;
            private int urgency;
            private List<?> region;

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

            public int getProperty_type() {
                return property_type;
            }

            public void setProperty_type(int property_type) {
                this.property_type = property_type;
            }

            public int getTotal_price() {
                return total_price;
            }

            public void setTotal_price(int total_price) {
                this.total_price = total_price;
            }

            public String getHouse_type() {
                return house_type;
            }

            public void setHouse_type(String house_type) {
                this.house_type = house_type;
            }

            public int getIntent() {
                return intent;
            }

            public void setIntent(int intent) {
                this.intent = intent;
            }

            public int getUrgency() {
                return urgency;
            }

            public void setUrgency(int urgency) {
                this.urgency = urgency;
            }

            public List<?> getRegion() {
                return region;
            }

            public void setRegion(List<?> region) {
                this.region = region;
            }
        }
    }
}
