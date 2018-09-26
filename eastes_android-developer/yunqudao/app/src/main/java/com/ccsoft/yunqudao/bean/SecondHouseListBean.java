package com.ccsoft.yunqudao.bean;

import java.util.List;

public class SecondHouseListBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"house_id":6,"title":"测试标题","price":1230000,"property_type":"住宅","store_name":"请问请问","project_tags":["涪江畔","5.1米跃层微墅","度假村"],"house_tags":[],"price_change":0,"img_url":"","unit_price":8602,"describe":"1室1厅2卫/143㎡/1/翡翠滨江"}],"first_page_url":"http://127.0.0.1:2797/lumen/public/index.php/user/house/house/list?page=1","from":1,"last_page":1,"last_page_url":"http://127.0.0.1:2797/lumen/public/index.php/user/house/house/list?page=1","next_page_url":null,"path":"http://127.0.0.1:2797/lumen/public/index.php/user/house/house/list","per_page":15,"prev_page_url":null,"to":1,"total":1}
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
         * data : [{"house_id":6,"title":"测试标题","price":1230000,"property_type":"住宅","store_name":"请问请问","project_tags":["涪江畔","5.1米跃层微墅","度假村"],"house_tags":[],"price_change":0,"img_url":"","unit_price":8602,"describe":"1室1厅2卫/143㎡/1/翡翠滨江"}]
         * first_page_url : http://127.0.0.1:2797/lumen/public/index.php/user/house/house/list?page=1
         * from : 1
         * last_page : 1
         * last_page_url : http://127.0.0.1:2797/lumen/public/index.php/user/house/house/list?page=1
         * next_page_url : null
         * path : http://127.0.0.1:2797/lumen/public/index.php/user/house/house/list
         * per_page : 15
         * prev_page_url : null
         * to : 1
         * total : 1
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
             * house_id : 6
             * title : 测试标题
             * price : 1230000
             * property_type : 住宅
             * store_name : 请问请问
             * project_tags : ["涪江畔","5.1米跃层微墅","度假村"]
             * house_tags : []
             * price_change : 0
             * img_url :
             * unit_price : 8602
             * describe : 1室1厅2卫/143㎡/1/翡翠滨江
             */

            private int house_id;
            private String title;
            private int price;
            private String property_type;
            private String store_name;
            private int price_change;
            private String img_url;
            private int unit_price;
            private String describe;
            private List<String> project_tags;
            private List<String> house_tags;

            public int getHouse_id() {
                return house_id;
            }

            public void setHouse_id(int house_id) {
                this.house_id = house_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getProperty_type() {
                return property_type;
            }

            public void setProperty_type(String property_type) {
                this.property_type = property_type;
            }

            public String getStore_name() {
                return store_name;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }

            public int getPrice_change() {
                return price_change;
            }

            public void setPrice_change(int price_change) {
                this.price_change = price_change;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public int getUnit_price() {
                return unit_price;
            }

            public void setUnit_price(int unit_price) {
                this.unit_price = unit_price;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public List<String> getProject_tags() {
                return project_tags;
            }

            public void setProject_tags(List<String> project_tags) {
                this.project_tags = project_tags;
            }

            public List<String> getHouse_tags() {
                return house_tags;
            }

            public void setHouse_tags(List<String> house_tags) {
                this.house_tags = house_tags;
            }
        }
    }
}
