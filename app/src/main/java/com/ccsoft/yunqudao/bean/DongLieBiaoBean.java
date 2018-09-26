package com.ccsoft.yunqudao.bean;

import java.util.List;

public class DongLieBiaoBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"dynamic_id":6,"title":"测试标题","create_time":"2018-03-26 07:00:06","update_time":"2018-03-26 15:00:06","img_url":"","content":"测试内容","state":1},{"dynamic_id":5,"title":"测试标题","create_time":"2018-03-26 00:00:00","update_time":"2018-03-26 14:48:17","img_url":"","content":"测试内容","state":1},{"dynamic_id":4,"title":"测试标题","create_time":"2018-03-26 00:00:00","update_time":"2018-03-26 14:45:09","img_url":"","content":"测试内容","state":1},{"dynamic_id":3,"title":"测试标题","create_time":"2018-03-26 00:00:00","update_time":"2018-03-26 14:43:42","img_url":"","content":"测试内容","state":1},{"dynamic_id":2,"title":"测试标题","create_time":"2018-03-26 00:00:00","update_time":"2018-03-26 14:42:59","img_url":"","content":"测试内容","state":1}],"first_page_url":"http://127.0.0.1:2797/lumen/public/index.php/user/dynamic/list?page=1","from":1,"last_page":1,"last_page_url":"http://127.0.0.1:2797/lumen/public/index.php/user/dynamic/list?page=1","next_page_url":null,"path":"http://127.0.0.1:2797/lumen/public/index.php/user/dynamic/list","per_page":15,"prev_page_url":null,"to":5,"total":5}
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
         * data : [{"dynamic_id":6,"title":"测试标题","create_time":"2018-03-26 07:00:06","update_time":"2018-03-26 15:00:06","img_url":"","content":"测试内容","state":1},{"dynamic_id":5,"title":"测试标题","create_time":"2018-03-26 00:00:00","update_time":"2018-03-26 14:48:17","img_url":"","content":"测试内容","state":1},{"dynamic_id":4,"title":"测试标题","create_time":"2018-03-26 00:00:00","update_time":"2018-03-26 14:45:09","img_url":"","content":"测试内容","state":1},{"dynamic_id":3,"title":"测试标题","create_time":"2018-03-26 00:00:00","update_time":"2018-03-26 14:43:42","img_url":"","content":"测试内容","state":1},{"dynamic_id":2,"title":"测试标题","create_time":"2018-03-26 00:00:00","update_time":"2018-03-26 14:42:59","img_url":"","content":"测试内容","state":1}]
         * first_page_url : http://127.0.0.1:2797/lumen/public/index.php/user/dynamic/list?page=1
         * from : 1
         * last_page : 1
         * last_page_url : http://127.0.0.1:2797/lumen/public/index.php/user/dynamic/list?page=1
         * next_page_url : null
         * path : http://127.0.0.1:2797/lumen/public/index.php/user/dynamic/list
         * per_page : 15
         * prev_page_url : null
         * to : 5
         * total : 5
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
             * dynamic_id : 6
             * title : 测试标题
             * create_time : 2018-03-26 07:00:06
             * update_time : 2018-03-26 15:00:06
             * img_url :
             * content : 测试内容
             * state : 1
             */

            private int dynamic_id;
            private String title;
            private String create_time;
            private String update_time;
            private String img_url;
            private String content;
            private int state;

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUrl() {

                return url;
            }

            private String url;

            public int getDynamic_id() {
                return dynamic_id;
            }

            public void setDynamic_id(int dynamic_id) {
                this.dynamic_id = dynamic_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }
        }
    }
}
