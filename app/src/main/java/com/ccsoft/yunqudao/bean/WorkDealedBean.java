package com.ccsoft.yunqudao.bean;

import java.util.List;

public class WorkDealedBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"client_id":386,"name":"李加成","project_name":"云算2","tel":"13981935101","state_change_time":"2018-05-27 14:29:53"},{"client_id":357,"name":"薛俊","project_name":"云算2","tel":"13981935199","state_change_time":"2018-05-25 04:44:04"},{"client_id":316,"name":"哦我朋友","project_name":"云算2","tel":"15325809658","state_change_time":"2018-05-24 07:40:43"},{"client_id":261,"name":"666","project_name":"云算2","tel":"13500000007","state_change_time":"2018-05-19 10:32:46"}],"first_page_url":"http://127.0.0.1/hs_agent/public/index.php/agent/work/project/deal?page=1","from":1,"last_page":1,"last_page_url":"http://127.0.0.1/hs_agent/public/index.php/agent/work/project/deal?page=1","next_page_url":null,"path":"http://127.0.0.1/hs_agent/public/index.php/agent/work/project/deal","per_page":15,"prev_page_url":null,"to":4,"total":4}
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
         * data : [{"client_id":386,"name":"李加成","project_name":"云算2","tel":"13981935101","state_change_time":"2018-05-27 14:29:53"},{"client_id":357,"name":"薛俊","project_name":"云算2","tel":"13981935199","state_change_time":"2018-05-25 04:44:04"},{"client_id":316,"name":"哦我朋友","project_name":"云算2","tel":"15325809658","state_change_time":"2018-05-24 07:40:43"},{"client_id":261,"name":"666","project_name":"云算2","tel":"13500000007","state_change_time":"2018-05-19 10:32:46"}]
         * first_page_url : http://127.0.0.1/hs_agent/public/index.php/agent/work/project/deal?page=1
         * from : 1
         * last_page : 1
         * last_page_url : http://127.0.0.1/hs_agent/public/index.php/agent/work/project/deal?page=1
         * next_page_url : null
         * path : http://127.0.0.1/hs_agent/public/index.php/agent/work/project/deal
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
             * client_id : 386
             * name : 李加成
             * project_name : 云算2
             * tel : 13981935101
             * state_change_time : 2018-05-27 14:29:53
             */

            private int client_id;
            private String name;
            private String project_name;
            private String tel;
            private String state_change_time;

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

            public String getState_change_time() {
                return state_change_time;
            }

            public void setState_change_time(String state_change_time) {
                this.state_change_time = state_change_time;
            }
        }
    }
}
