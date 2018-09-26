package com.ccsoft.yunqudao.model;

import com.ccsoft.yunqudao.bean.CustomersGetInfoBean;

import java.util.List;

/**
 * Created by lixinke on 2018/5/28.
 */

public class ClientListModel {


    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"client_id":5,"name":"尴尬","sex":0,"tel":"15082245107","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":4,"name":"打击2","sex":0,"tel":"15928666883","property_type":59,"total_price":93,"house_type":"33","intent":0,"urgency":0,"region":[{"province":"510000","province_name":"四川省","city":"510700","city_name":"绵阳市","district":"510722","district_name":"三台县"}]},{"client_id":3,"name":"王强","sex":1,"tel":"13584878956","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":2,"name":"任志强","sex":1,"tel":"13482823656","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0}],"first_page_url":"http://47.106.39.169:2797/agent/client/list?page=1","from":1,"last_page":1,"last_page_url":"http://47.106.39.169:2797/agent/client/list?page=1","next_page_url":null,"path":"http://47.106.39.169:2797/agent/client/list","per_page":15,"prev_page_url":null,"to":4,"total":4}
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
         * data : [{"client_id":5,"name":"尴尬","sex":0,"tel":"15082245107","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":4,"name":"打击2","sex":0,"tel":"15928666883","property_type":59,"total_price":93,"house_type":"33","intent":0,"urgency":0,"region":[{"province":"510000","province_name":"四川省","city":"510700","city_name":"绵阳市","district":"510722","district_name":"三台县"}]},{"client_id":3,"name":"王强","sex":1,"tel":"13584878956","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0},{"client_id":2,"name":"任志强","sex":1,"tel":"13482823656","property_type":0,"region":[],"total_price":0,"house_type":"","intent":0,"urgency":0}]
         * first_page_url : http://47.106.39.169:2797/agent/client/list?page=1
         * from : 1
         * last_page : 1
         * last_page_url : http://47.106.39.169:2797/agent/client/list?page=1
         * next_page_url : null
         * path : http://47.106.39.169:2797/agent/client/list
         * per_page : 15
         * prev_page_url : null
         * to : 4
         * total : 4
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
             * client_id : 5
             * name : 尴尬
             * sex : 0
             * tel : 15082245107
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
            private List<RegionBean> region;

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

            public List<RegionBean> getRegion() {
                return region;
            }

            public void setRegion(List<RegionBean> region) {
                this.region = region;
            }

            public static class RegionBean {
                /**
                 * province : 310000
                 * province_name : 上海市
                 * city : 310100
                 * city_name : 市辖区
                 * district : 310106
                 * district_name : 静安区
                 */

                private String province;
                private String province_name;
                private String city;
                private String city_name;
                private String district;
                private String district_name;

                public String getProvince() {
                    return province;
                }

                public void setProvince(String province) {
                    this.province = province;
                }

                public String getProvince_name() {
                    return province_name;
                }

                public void setProvince_name(String province_name) {
                    this.province_name = province_name;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getCity_name() {
                    return city_name;
                }

                public void setCity_name(String city_name) {
                    this.city_name = city_name;
                }

                public String getDistrict() {
                    return district;
                }

                public void setDistrict(String district) {
                    this.district = district;
                }

                public String getDistrict_name() {
                    return district_name;
                }

                public void setDistrict_name(String district_name) {
                    this.district_name = district_name;
                }

                @Override
                public String toString() {
                    return "RegionBean{" +
                            "province='" + province + '\'' +
                            ", province_name='" + province_name + '\'' +
                            ", city='" + city + '\'' +
                            ", city_name='" + city_name + '\'' +
                            ", district='" + district + '\'' +
                            ", district_name='" + district_name + '\'' +
                            '}';
                }
            }
        }
    }
}
