package com.ccsoft.yunqudao.bean;

import java.util.List;

public class QiangDanListBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"property_type":"","project_name":"翡翠滨江","house_type":"","create_time":"2018-08-16 15:22:41","record_id":3},{"property_type":"","project_name":"翡翠滨江","house_type":"","create_time":"2018-08-16 18:15:27","record_id":5}],"first_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/house/record/list?page=1","from":1,"last_page":1,"last_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/house/record/list?page=1","next_page_url":null,"path":"http://127.0.0.1:2797/lumen/public/index.php/agent/house/record/list","per_page":15,"prev_page_url":null,"to":2,"total":2}
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
         * data : [{"property_type":"","project_name":"翡翠滨江","house_type":"","create_time":"2018-08-16 15:22:41","record_id":3},{"property_type":"","project_name":"翡翠滨江","house_type":"","create_time":"2018-08-16 18:15:27","record_id":5}]
         * first_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/house/record/list?page=1
         * from : 1
         * last_page : 1
         * last_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/house/record/list?page=1
         * next_page_url : null
         * path : http://127.0.0.1:2797/lumen/public/index.php/agent/house/record/list
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
             * property_type :
             * project_name : 翡翠滨江
             * house_type :
             * create_time : 2018-08-16 15:22:41
             * record_id : 3
             */

            private String property_type;
            private String project_name;
            private String house_type;
            private String create_time;
            private int record_id;

            public String getProperty_type() {
                return property_type;
            }

            public void setProperty_type(String property_type) {
                this.property_type = property_type;
            }

            public String getProject_name() {
                return project_name;
            }

            public void setProject_name(String project_name) {
                this.project_name = project_name;
            }

            public String getHouse_type() {
                return house_type;
            }

            public void setHouse_type(String house_type) {
                this.house_type = house_type;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public int getRecord_id() {
                return record_id;
            }

            public void setRecord_id(int record_id) {
                this.record_id = record_id;
            }
        }
    }
}
