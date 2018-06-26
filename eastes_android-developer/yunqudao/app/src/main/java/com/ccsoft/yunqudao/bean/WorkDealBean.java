package com.ccsoft.yunqudao.bean;

import java.util.List;

public class WorkDealBean {


    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"client_id":537,"name":"模块","project_name":"翡翠滨江","tel":"15632514780","allot_time":"2018-06-15 17:21:58","create_time":"2018-06-15 17:13:09","timsLimit":"2018-06-16 17:21:58"}],"first_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/work/project/waitDeal?page=1","from":1,"last_page":1,"last_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/work/project/waitDeal?page=1","next_page_url":null,"path":"http://127.0.0.1:2797/lumen/public/index.php/agent/work/project/waitDeal","per_page":15,"prev_page_url":null,"to":1,"total":1}
     */

    private int code;
    private String msg;

    @Override
    public String toString() {
        return "WorkDealBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

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
         * data : [{"client_id":537,"name":"模块","project_name":"翡翠滨江","tel":"15632514780","allot_time":"2018-06-15 17:21:58","create_time":"2018-06-15 17:13:09","timsLimit":"2018-06-16 17:21:58"}]
         * first_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/work/project/waitDeal?page=1
         * from : 1
         * last_page : 1
         * last_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/work/project/waitDeal?page=1
         * next_page_url : null
         * path : http://127.0.0.1:2797/lumen/public/index.php/agent/work/project/waitDeal
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
             * client_id : 537
             * name : 模块
             * project_name : 翡翠滨江
             * tel : 15632514780
             * allot_time : 2018-06-15 17:21:58
             * create_time : 2018-06-15 17:13:09
             * timsLimit : 2018-06-16 17:21:58
             */

            private int client_id;
            private String name;
            private String project_name;
            private String tel;
            private String allot_time;
            private String create_time;
            private String timsLimit;

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

            public String getProject_name() {
                return project_name;
            }

            public void setProject_name(String project_name) {
                this.project_name = project_name;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getAllot_time() {
                return allot_time;
            }

            public void setAllot_time(String allot_time) {
                this.allot_time = allot_time;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
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
