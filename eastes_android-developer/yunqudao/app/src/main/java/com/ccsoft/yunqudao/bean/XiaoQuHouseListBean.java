package com.ccsoft.yunqudao.bean;

import java.util.List;

public class XiaoQuHouseListBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"project_id":2,"project_name":"圣丰国际","absolute_address":"四川省眉山市经济开发区新区兴业南路18号","average_price":8500,"project_code":"CS00002","on_sale":0,"sale_focus_num":0,"img_url":"upload/project/img/project_8/s2.jpg"},{"project_id":1,"project_name":"翡翠滨江","absolute_address":"四川省绵阳市三台县涪滨路","average_price":6000,"project_code":"CS00001","on_sale":4,"sale_focus_num":0,"img_url":"upload/project/img/1532514534_57.jpg"}],"first_page_url":"http://127.0.0.1:2797/lumen/public/index.php/user/house/project/list?page=1","from":1,"last_page":1,"last_page_url":"http://127.0.0.1:2797/lumen/public/index.php/user/house/project/list?page=1","next_page_url":null,"path":"http://127.0.0.1:2797/lumen/public/index.php/user/house/project/list","per_page":15,"prev_page_url":null,"to":2,"total":2}
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
         * data : [{"project_id":2,"project_name":"圣丰国际","absolute_address":"四川省眉山市经济开发区新区兴业南路18号","average_price":8500,"project_code":"CS00002","on_sale":0,"sale_focus_num":0,"img_url":"upload/project/img/project_8/s2.jpg"},{"project_id":1,"project_name":"翡翠滨江","absolute_address":"四川省绵阳市三台县涪滨路","average_price":6000,"project_code":"CS00001","on_sale":4,"sale_focus_num":0,"img_url":"upload/project/img/1532514534_57.jpg"}]
         * first_page_url : http://127.0.0.1:2797/lumen/public/index.php/user/house/project/list?page=1
         * from : 1
         * last_page : 1
         * last_page_url : http://127.0.0.1:2797/lumen/public/index.php/user/house/project/list?page=1
         * next_page_url : null
         * path : http://127.0.0.1:2797/lumen/public/index.php/user/house/project/list
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
             * project_id : 2
             * project_name : 圣丰国际
             * absolute_address : 四川省眉山市经济开发区新区兴业南路18号
             * average_price : 8500
             * project_code : CS00002
             * on_sale : 0
             * sale_focus_num : 0
             * img_url : upload/project/img/project_8/s2.jpg
             */

            private int project_id;
            private String project_name;
            private String absolute_address;
            private int average_price;
            private String project_code;
            private int on_sale;
            private int sale_focus_num;
            private String img_url;

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

            public String getAbsolute_address() {
                return absolute_address;
            }

            public void setAbsolute_address(String absolute_address) {
                this.absolute_address = absolute_address;
            }

            public int getAverage_price() {
                return average_price;
            }

            public void setAverage_price(int average_price) {
                this.average_price = average_price;
            }

            public String getProject_code() {
                return project_code;
            }

            public void setProject_code(String project_code) {
                this.project_code = project_code;
            }

            public int getOn_sale() {
                return on_sale;
            }

            public void setOn_sale(int on_sale) {
                this.on_sale = on_sale;
            }

            public int getSale_focus_num() {
                return sale_focus_num;
            }

            public void setSale_focus_num(int sale_focus_num) {
                this.sale_focus_num = sale_focus_num;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }
        }
    }
}
