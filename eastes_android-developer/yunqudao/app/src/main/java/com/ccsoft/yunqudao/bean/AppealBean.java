package com.ccsoft.yunqudao.bean;

import java.util.List;

public class AppealBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"project_client_id":315,"state":"处理中","type":107,"appeal_id":18,"solve_info":"","comment":"我的","create_time":"2018-05-24 15:43:33","update_time":"2018-05-24 07:43:33","state_change_time":"2018-05-24 07:39:15","current_state":"推荐","name":"哦我朋友","recommend_time":"2018-05-24 15:21:15","project_name":"云算2"},{"project_client_id":300,"state":"处理中","type":109,"appeal_id":17,"solve_info":"","comment":"jjkk","create_time":"2018-05-24 15:41:47","update_time":"2018-05-24 07:41:47","state_change_time":"2018-05-24 02:04:27","current_state":"推荐","name":"陆","recommend_time":"2018-05-24 10:04:27","project_name":"云算2"}],"first_page_url":"http://127.0.0.1/hs_agent/public/index.php/agent/work/broker/appeal?page=1","from":1,"last_page":1,"last_page_url":"http://127.0.0.1/hs_agent/public/index.php/agent/work/broker/appeal?page=1","next_page_url":null,"path":"http://127.0.0.1/hs_agent/public/index.php/agent/work/broker/appeal","per_page":15,"prev_page_url":null,"to":2,"total":2}
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
         * data : [{"project_client_id":315,"state":"处理中","type":107,"appeal_id":18,"solve_info":"","comment":"我的","create_time":"2018-05-24 15:43:33","update_time":"2018-05-24 07:43:33","state_change_time":"2018-05-24 07:39:15","current_state":"推荐","name":"哦我朋友","recommend_time":"2018-05-24 15:21:15","project_name":"云算2"},{"project_client_id":300,"state":"处理中","type":109,"appeal_id":17,"solve_info":"","comment":"jjkk","create_time":"2018-05-24 15:41:47","update_time":"2018-05-24 07:41:47","state_change_time":"2018-05-24 02:04:27","current_state":"推荐","name":"陆","recommend_time":"2018-05-24 10:04:27","project_name":"云算2"}]
         * first_page_url : http://127.0.0.1/hs_agent/public/index.php/agent/work/broker/appeal?page=1
         * from : 1
         * last_page : 1
         * last_page_url : http://127.0.0.1/hs_agent/public/index.php/agent/work/broker/appeal?page=1
         * next_page_url : null
         * path : http://127.0.0.1/hs_agent/public/index.php/agent/work/broker/appeal
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
             * project_client_id : 315
             * state : 处理中
             * type : 107
             * appeal_id : 18
             * solve_info :
             * comment : 我的
             * create_time : 2018-05-24 15:43:33
             * update_time : 2018-05-24 07:43:33
             * state_change_time : 2018-05-24 07:39:15
             * current_state : 推荐
             * name : 哦我朋友
             * recommend_time : 2018-05-24 15:21:15
             * project_name : 云算2
             */

            private int project_client_id;
            private String state;
            private int type;
            private int appeal_id;
            private String solve_info;
            private String comment;
            private String create_time;
            private String update_time;
            private String state_change_time;
            private String current_state;
            private String name;
            private String recommend_time;
            private String project_name;

            public int getProject_client_id() {
                return project_client_id;
            }

            public void setProject_client_id(int project_client_id) {
                this.project_client_id = project_client_id;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getAppeal_id() {
                return appeal_id;
            }

            public void setAppeal_id(int appeal_id) {
                this.appeal_id = appeal_id;
            }

            public String getSolve_info() {
                return solve_info;
            }

            public void setSolve_info(String solve_info) {
                this.solve_info = solve_info;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public String getState_change_time() {
                return state_change_time;
            }

            public void setState_change_time(String state_change_time) {
                this.state_change_time = state_change_time;
            }

            public String getCurrent_state() {
                return current_state;
            }

            public void setCurrent_state(String current_state) {
                this.current_state = current_state;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRecommend_time() {
                return recommend_time;
            }

            public void setRecommend_time(String recommend_time) {
                this.recommend_time = recommend_time;
            }

            public String getProject_name() {
                return project_name;
            }

            public void setProject_name(String project_name) {
                this.project_name = project_name;
            }
        }
    }
}
