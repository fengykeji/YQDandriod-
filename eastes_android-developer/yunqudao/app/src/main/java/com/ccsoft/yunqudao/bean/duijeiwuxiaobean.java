package com.ccsoft.yunqudao.bean;

import java.util.List;

public class duijeiwuxiaobean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"client_id":896,"name":"三","broker_id":87,"tel":"13333333332","create_time":"2018-08-23 11:34:51","current_state":"推荐","state_change_time":"2018-08-23 11:41:00","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":883,"name":"与","broker_id":58,"tel":"13589562425","create_time":"2018-08-22 18:55:43","current_state":"推荐","state_change_time":"2018-08-23 19:03:34","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":880,"name":"全民","broker_id":47,"tel":"15555555554","create_time":"2018-08-22 18:40:57","current_state":"推荐","state_change_time":"2018-08-23 18:54:56","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":878,"name":"全民","broker_id":47,"tel":"15555555554","create_time":"2018-08-22 18:40:19","current_state":"推荐","state_change_time":"2018-08-22 18:40:41","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":877,"name":"用户1","broker_id":87,"tel":"13551027802","create_time":"2018-08-22 18:27:14","current_state":"推荐","state_change_time":"2018-08-22 18:36:16","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":875,"name":"分销2","broker_id":87,"tel":"15555555552","create_time":"2018-08-22 18:24:25","current_state":"推荐","state_change_time":"2018-08-22 18:28:33","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":873,"name":"全民2","broker_id":87,"tel":"15984569812","create_time":"2018-08-22 18:18:46","current_state":"推荐","state_change_time":"2018-08-23 18:28:15","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":872,"name":"全民1","broker_id":87,"tel":"15984569811","create_time":"2018-08-22 18:15:11","current_state":"推荐","state_change_time":"2018-08-23 18:15:47","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":868,"name":"4","broker_id":88,"tel":"15082386254","create_time":"2018-08-21 17:58:31","current_state":"推荐","state_change_time":"2018-08-22 20:52:39","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":867,"name":"3","broker_id":88,"tel":"15082386253","create_time":"2018-08-21 17:57:51","current_state":"推荐","state_change_time":"2018-08-22 20:52:39","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":866,"name":"2","broker_id":88,"tel":"15082386252","create_time":"2018-08-21 17:53:09","current_state":"推荐","state_change_time":"2018-08-22 20:52:39","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":865,"name":"1","broker_id":88,"tel":"15082386251","create_time":"2018-08-21 17:50:47","current_state":"推荐","state_change_time":"2018-08-22 20:52:39","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":864,"name":"余杰姐","broker_id":88,"tel":"15928666181","create_time":"2018-08-21 17:49:33","current_state":"推荐","state_change_time":"2018-08-22 20:52:39","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":863,"name":"用户22","broker_id":87,"tel":"13551027822","create_time":"2018-08-20 16:13:36","current_state":"推荐","state_change_time":"2018-08-21 16:46:13","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":862,"name":"用户21","broker_id":87,"tel":"13551027821","create_time":"2018-08-20 16:12:09","current_state":"推荐","state_change_time":"2018-08-21 16:46:13","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0}],"first_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/disabled?page=1","from":1,"last_page":10,"last_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/disabled?page=10","next_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/disabled?page=2","path":"http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/disabled","per_page":15,"prev_page_url":null,"to":15,"total":143}
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
         * data : [{"client_id":896,"name":"三","broker_id":87,"tel":"13333333332","create_time":"2018-08-23 11:34:51","current_state":"推荐","state_change_time":"2018-08-23 11:41:00","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":883,"name":"与","broker_id":58,"tel":"13589562425","create_time":"2018-08-22 18:55:43","current_state":"推荐","state_change_time":"2018-08-23 19:03:34","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":880,"name":"全民","broker_id":47,"tel":"15555555554","create_time":"2018-08-22 18:40:57","current_state":"推荐","state_change_time":"2018-08-23 18:54:56","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":878,"name":"全民","broker_id":47,"tel":"15555555554","create_time":"2018-08-22 18:40:19","current_state":"推荐","state_change_time":"2018-08-22 18:40:41","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":877,"name":"用户1","broker_id":87,"tel":"13551027802","create_time":"2018-08-22 18:27:14","current_state":"推荐","state_change_time":"2018-08-22 18:36:16","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":875,"name":"分销2","broker_id":87,"tel":"15555555552","create_time":"2018-08-22 18:24:25","current_state":"推荐","state_change_time":"2018-08-22 18:28:33","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":873,"name":"全民2","broker_id":87,"tel":"15984569812","create_time":"2018-08-22 18:18:46","current_state":"推荐","state_change_time":"2018-08-23 18:28:15","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":872,"name":"全民1","broker_id":87,"tel":"15984569811","create_time":"2018-08-22 18:15:11","current_state":"推荐","state_change_time":"2018-08-23 18:15:47","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":868,"name":"4","broker_id":88,"tel":"15082386254","create_time":"2018-08-21 17:58:31","current_state":"推荐","state_change_time":"2018-08-22 20:52:39","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":867,"name":"3","broker_id":88,"tel":"15082386253","create_time":"2018-08-21 17:57:51","current_state":"推荐","state_change_time":"2018-08-22 20:52:39","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":866,"name":"2","broker_id":88,"tel":"15082386252","create_time":"2018-08-21 17:53:09","current_state":"推荐","state_change_time":"2018-08-22 20:52:39","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":865,"name":"1","broker_id":88,"tel":"15082386251","create_time":"2018-08-21 17:50:47","current_state":"推荐","state_change_time":"2018-08-22 20:52:39","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":864,"name":"余杰姐","broker_id":88,"tel":"15928666181","create_time":"2018-08-21 17:49:33","current_state":"推荐","state_change_time":"2018-08-22 20:52:39","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":863,"name":"用户22","broker_id":87,"tel":"13551027822","create_time":"2018-08-20 16:13:36","current_state":"推荐","state_change_time":"2018-08-21 16:46:13","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0},{"client_id":862,"name":"用户21","broker_id":87,"tel":"13551027821","create_time":"2018-08-20 16:12:09","current_state":"推荐","state_change_time":"2018-08-21 16:46:13","project_name":"翡翠滨江","visit_time":null,"property_advicer_wish_id":0}]
         * first_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/disabled?page=1
         * from : 1
         * last_page : 10
         * last_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/disabled?page=10
         * next_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/disabled?page=2
         * path : http://127.0.0.1:2797/lumen/public/index.php/agent/work/butter/disabled
         * per_page : 15
         * prev_page_url : null
         * to : 15
         * total : 143
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
             * client_id : 896
             * name : 三
             * broker_id : 87
             * tel : 13333333332
             * create_time : 2018-08-23 11:34:51
             * current_state : 推荐
             * state_change_time : 2018-08-23 11:41:00
             * project_name : 翡翠滨江
             * visit_time : null
             * property_advicer_wish_id : 0
             */

            private int client_id;
            private String name;
            private int broker_id;
            private String tel;
            private String create_time;
            private String current_state;
            private String state_change_time;
            private String project_name;
            private Object visit_time;
            private int property_advicer_wish_id;

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

            public int getBroker_id() {
                return broker_id;
            }

            public void setBroker_id(int broker_id) {
                this.broker_id = broker_id;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getCurrent_state() {
                return current_state;
            }

            public void setCurrent_state(String current_state) {
                this.current_state = current_state;
            }

            public String getState_change_time() {
                return state_change_time;
            }

            public void setState_change_time(String state_change_time) {
                this.state_change_time = state_change_time;
            }

            public String getProject_name() {
                return project_name;
            }

            public void setProject_name(String project_name) {
                this.project_name = project_name;
            }

            public Object getVisit_time() {
                return visit_time;
            }

            public void setVisit_time(Object visit_time) {
                this.visit_time = visit_time;
            }

            public int getProperty_advicer_wish_id() {
                return property_advicer_wish_id;
            }

            public void setProperty_advicer_wish_id(int property_advicer_wish_id) {
                this.property_advicer_wish_id = property_advicer_wish_id;
            }
        }
    }
}
