package com.ccsoft.yunqudao.bean;

import java.util.List;

public class ProjectFastRecommendListBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"client_id":461,"need_id":449,"name":"啊啊啊了","intent":0,"urgency":0,"house_type":"","area":null,"price":null,"decorate":null,"need_tags":"","property_type":0,"tel":"15086251475","sex":1,"region":[{"province":"510000","province_name":"四川省","city":"511000","city_name":"内江市","district":"511011","district_name":"东兴区"},{"province":"510000","province_name":"四川省","city":"510700","city_name":"绵阳市","district":"510704","district_name":"游仙区"}]},{"client_id":444,"need_id":432,"name":"与","intent":0,"urgency":0,"house_type":"","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13589562425","sex":1},{"client_id":443,"need_id":431,"name":"！！","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13526393538","sex":1},{"client_id":442,"need_id":430,"name":"16","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13452634123","sex":2},{"client_id":441,"need_id":429,"name":"34","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13111111111","sex":2},{"client_id":440,"need_id":428,"name":"41","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13111111111","sex":1},{"client_id":439,"need_id":427,"name":"11","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13111111111","sex":0},{"client_id":438,"need_id":426,"name":"1333","intent":43,"urgency":63,"house_type":"33","area":"90-130","price":"50-80","decorate":"简装","need_tags":"","region":"","property_type":61,"tel":"13111111111","sex":2},{"client_id":437,"need_id":425,"name":"13131","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"136,137","region":"","property_type":61,"tel":"13133411411","sex":0},{"client_id":436,"need_id":424,"name":"13331","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13111111111","sex":0},{"client_id":435,"need_id":423,"name":"1413","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13134211111","sex":1},{"client_id":434,"need_id":422,"name":"141","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13111111111","sex":1},{"client_id":433,"need_id":421,"name":"名","intent":0,"urgency":0,"house_type":"","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"15258521478","sex":0},{"client_id":428,"need_id":416,"name":"131","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"131,130,125","region":"","property_type":0,"tel":"13111111111","sex":2},{"client_id":427,"need_id":415,"name":"131","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13111111111","sex":2}],"first_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/matching/fastRecommendList?page=1","from":1,"last_page":6,"last_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/matching/fastRecommendList?page=6","next_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/matching/fastRecommendList?page=2","path":"http://127.0.0.1:2797/lumen/public/index.php/agent/matching/fastRecommendList","per_page":15,"prev_page_url":null,"to":15,"total":77}
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
         * data : [{"client_id":461,"need_id":449,"name":"啊啊啊了","intent":0,"urgency":0,"house_type":"","area":null,"price":null,"decorate":null,"need_tags":"","property_type":0,"tel":"15086251475","sex":1,"region":[{"province":"510000","province_name":"四川省","city":"511000","city_name":"内江市","district":"511011","district_name":"东兴区"},{"province":"510000","province_name":"四川省","city":"510700","city_name":"绵阳市","district":"510704","district_name":"游仙区"}]},{"client_id":444,"need_id":432,"name":"与","intent":0,"urgency":0,"house_type":"","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13589562425","sex":1},{"client_id":443,"need_id":431,"name":"！！","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13526393538","sex":1},{"client_id":442,"need_id":430,"name":"16","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13452634123","sex":2},{"client_id":441,"need_id":429,"name":"34","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13111111111","sex":2},{"client_id":440,"need_id":428,"name":"41","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13111111111","sex":1},{"client_id":439,"need_id":427,"name":"11","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13111111111","sex":0},{"client_id":438,"need_id":426,"name":"1333","intent":43,"urgency":63,"house_type":"33","area":"90-130","price":"50-80","decorate":"简装","need_tags":"","region":"","property_type":61,"tel":"13111111111","sex":2},{"client_id":437,"need_id":425,"name":"13131","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"136,137","region":"","property_type":61,"tel":"13133411411","sex":0},{"client_id":436,"need_id":424,"name":"13331","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13111111111","sex":0},{"client_id":435,"need_id":423,"name":"1413","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13134211111","sex":1},{"client_id":434,"need_id":422,"name":"141","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13111111111","sex":1},{"client_id":433,"need_id":421,"name":"名","intent":0,"urgency":0,"house_type":"","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"15258521478","sex":0},{"client_id":428,"need_id":416,"name":"131","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"131,130,125","region":"","property_type":0,"tel":"13111111111","sex":2},{"client_id":427,"need_id":415,"name":"131","intent":0,"urgency":0,"house_type":"0","area":null,"price":null,"decorate":null,"need_tags":"","region":"","property_type":0,"tel":"13111111111","sex":2}]
         * first_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/matching/fastRecommendList?page=1
         * from : 1
         * last_page : 6
         * last_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/matching/fastRecommendList?page=6
         * next_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/matching/fastRecommendList?page=2
         * path : http://127.0.0.1:2797/lumen/public/index.php/agent/matching/fastRecommendList
         * per_page : 15
         * prev_page_url : null
         * to : 15
         * total : 77
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
             * client_id : 461
             * need_id : 449
             * name : 啊啊啊了
             * intent : 0
             * urgency : 0
             * house_type :
             * area : null
             * price : null
             * decorate : null
             * need_tags :
             * property_type : 0
             * tel : 15086251475
             * sex : 1
             * region : [{"province":"510000","province_name":"四川省","city":"511000","city_name":"内江市","district":"511011","district_name":"东兴区"},{"province":"510000","province_name":"四川省","city":"510700","city_name":"绵阳市","district":"510704","district_name":"游仙区"}]
             */

            private int client_id;
            private int need_id;
            private String name;
            private int intent;
            private int urgency;
            private String house_type;
            private Object area;
            private Object price;
            private Object decorate;
            private String need_tags;
            private int property_type;
            private String tel;
            private int sex;
            private List<RegionBean> region;

            public int getClient_id() {
                return client_id;
            }

            public void setClient_id(int client_id) {
                this.client_id = client_id;
            }

            public int getNeed_id() {
                return need_id;
            }

            public void setNeed_id(int need_id) {
                this.need_id = need_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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

            public String getHouse_type() {
                return house_type;
            }

            public void setHouse_type(String house_type) {
                this.house_type = house_type;
            }

            public Object getArea() {
                return area;
            }

            public void setArea(Object area) {
                this.area = area;
            }

            public Object getPrice() {
                return price;
            }

            public void setPrice(Object price) {
                this.price = price;
            }

            public Object getDecorate() {
                return decorate;
            }

            public void setDecorate(Object decorate) {
                this.decorate = decorate;
            }

            public String getNeed_tags() {
                return need_tags;
            }

            public void setNeed_tags(String need_tags) {
                this.need_tags = need_tags;
            }

            public int getProperty_type() {
                return property_type;
            }

            public void setProperty_type(int property_type) {
                this.property_type = property_type;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public List<RegionBean> getRegion() {
                return region;
            }

            public void setRegion(List<RegionBean> region) {
                this.region = region;
            }

            public static class RegionBean {
                /**
                 * province : 510000
                 * province_name : 四川省
                 * city : 511000
                 * city_name : 内江市
                 * district : 511011
                 * district_name : 东兴区
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
            }
        }
    }
}
