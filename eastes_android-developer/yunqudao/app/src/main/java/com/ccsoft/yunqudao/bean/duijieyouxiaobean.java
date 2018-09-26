package com.ccsoft.yunqudao.bean;

import java.util.List;

public class duijieyouxiaobean {


    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"client_id":734,"name":"温加七","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-19 15:51:00"},{"client_id":732,"name":"温经理","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-19 15:32:00"},{"client_id":639,"name":"小红","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-09 19:11:00"},{"client_id":637,"name":"到底","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-09 14:31:00"},{"client_id":635,"name":"了解了","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-09 10:42:00"},{"client_id":600,"name":"阿里巴","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-06 18:12:00"},{"client_id":593,"name":"热热热","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-04 20:52:00"},{"client_id":583,"name":"带上","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-03 11:00:00"},{"client_id":582,"name":"那你","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-03 10:52:00"},{"client_id":578,"name":"嗯呢","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-06-29 19:04:00"},{"client_id":576,"name":"诶哦","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-06-29 18:45:00"}],"first_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/value?page=1","from":1,"last_page":1,"last_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/value?page=1","next_page_url":null,"path":"http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/value","per_page":15,"prev_page_url":null,"to":11,"total":11}
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
         * data : [{"client_id":734,"name":"温加七","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-19 15:51:00"},{"client_id":732,"name":"温经理","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-19 15:32:00"},{"client_id":639,"name":"小红","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-09 19:11:00"},{"client_id":637,"name":"到底","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-09 14:31:00"},{"client_id":635,"name":"了解了","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-09 10:42:00"},{"client_id":600,"name":"阿里巴","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-06 18:12:00"},{"client_id":593,"name":"热热热","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-04 20:52:00"},{"client_id":583,"name":"带上","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-03 11:00:00"},{"client_id":582,"name":"那你","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-07-03 10:52:00"},{"client_id":578,"name":"嗯呢","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-06-29 19:04:00"},{"client_id":576,"name":"诶哦","current_state":"签约","project_name":"翡翠滨江","visit_time":"2018-06-29 18:45:00"}]
         * first_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/value?page=1
         * from : 1
         * last_page : 1
         * last_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/value?page=1
         * next_page_url : null
         * path : http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/value
         * per_page : 15
         * prev_page_url : null
         * to : 11
         * total : 11
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
             * client_id : 734
             * name : 温加七
             * current_state : 签约
             * project_name : 翡翠滨江
             * visit_time : 2018-07-19 15:51:00
             */

            private int client_id;
            private String name;
            private String current_state;
            private String project_name;
            private String visit_time;

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

            public String getCurrent_state() {
                return current_state;
            }

            public void setCurrent_state(String current_state) {
                this.current_state = current_state;
            }

            public String getProject_name() {
                return project_name;
            }

            public void setProject_name(String project_name) {
                this.project_name = project_name;
            }

            public String getVisit_time() {
                return visit_time;
            }

            public void setVisit_time(String visit_time) {
                this.visit_time = visit_time;
            }
        }
    }
}
