package com.ccsoft.yunqudao.bean;

import java.util.List;

public class UnPlayListBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"broker_id":303,"name":"刘瑞林","tel":"13485868934","client_id":575,"broker_type":"推荐佣金","create_time":"2018-07-06 05:42:42","project_name":"翡翠滨江","broker_num":3245,"type":2},{"broker_id":304,"name":"刘瑞林","tel":"13485868934","client_id":575,"broker_type":"到访佣金","create_time":"2018-07-06 05:42:42","project_name":"翡翠滨江","broker_num":6854,"type":2},{"broker_id":313,"name":"带上","tel":"13452987521","client_id":583,"broker_type":"推荐佣金","create_time":"2018-07-03 11:00:13","project_name":"翡翠滨江","broker_num":3245,"type":2},{"broker_id":314,"name":"带上","tel":"13452987521","client_id":583,"broker_type":"到访佣金","create_time":"2018-07-03 11:00:13","project_name":"翡翠滨江","broker_num":6854,"type":2},{"broker_id":311,"name":"那你","tel":"13485962345","client_id":582,"broker_type":"推荐佣金","create_time":"2018-07-03 10:52:13","project_name":"翡翠滨江","broker_num":3245,"type":2},{"broker_id":312,"name":"那你","tel":"13485962345","client_id":582,"broker_type":"到访佣金","create_time":"2018-07-03 10:52:13","project_name":"翡翠滨江","broker_num":6854,"type":2},{"broker_id":34,"name":"刘总","tel":"15983800002","client_id":533,"broker_type":"到访佣金","create_time":"2018-06-14 17:57:24","project_name":"传化广场\u2022爱尚里","broker_num":100,"type":1},{"broker_id":33,"name":"古一","tel":"15983800001","client_id":528,"broker_type":"到访佣金","create_time":"2018-06-14 12:07:04","project_name":"传化广场\u2022爱尚里","broker_num":100,"type":1},{"broker_id":32,"name":"人之源","tel":"15848742323","client_id":527,"broker_type":"推荐佣金","create_time":"2018-06-14 11:56:05","project_name":"传化广场\u2022爱尚里","broker_num":200,"type":1}],"first_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/personal/unPayList?page=1","from":1,"last_page":1,"last_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/personal/unPayList?page=1","next_page_url":null,"path":"http://127.0.0.1:2797/lumen/public/index.php/agent/personal/unPayList","per_page":15,"prev_page_url":null,"to":9,"total":9}
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
         * data : [{"broker_id":303,"name":"刘瑞林","tel":"13485868934","client_id":575,"broker_type":"推荐佣金","create_time":"2018-07-06 05:42:42","project_name":"翡翠滨江","broker_num":3245,"type":2},{"broker_id":304,"name":"刘瑞林","tel":"13485868934","client_id":575,"broker_type":"到访佣金","create_time":"2018-07-06 05:42:42","project_name":"翡翠滨江","broker_num":6854,"type":2},{"broker_id":313,"name":"带上","tel":"13452987521","client_id":583,"broker_type":"推荐佣金","create_time":"2018-07-03 11:00:13","project_name":"翡翠滨江","broker_num":3245,"type":2},{"broker_id":314,"name":"带上","tel":"13452987521","client_id":583,"broker_type":"到访佣金","create_time":"2018-07-03 11:00:13","project_name":"翡翠滨江","broker_num":6854,"type":2},{"broker_id":311,"name":"那你","tel":"13485962345","client_id":582,"broker_type":"推荐佣金","create_time":"2018-07-03 10:52:13","project_name":"翡翠滨江","broker_num":3245,"type":2},{"broker_id":312,"name":"那你","tel":"13485962345","client_id":582,"broker_type":"到访佣金","create_time":"2018-07-03 10:52:13","project_name":"翡翠滨江","broker_num":6854,"type":2},{"broker_id":34,"name":"刘总","tel":"15983800002","client_id":533,"broker_type":"到访佣金","create_time":"2018-06-14 17:57:24","project_name":"传化广场\u2022爱尚里","broker_num":100,"type":1},{"broker_id":33,"name":"古一","tel":"15983800001","client_id":528,"broker_type":"到访佣金","create_time":"2018-06-14 12:07:04","project_name":"传化广场\u2022爱尚里","broker_num":100,"type":1},{"broker_id":32,"name":"人之源","tel":"15848742323","client_id":527,"broker_type":"推荐佣金","create_time":"2018-06-14 11:56:05","project_name":"传化广场\u2022爱尚里","broker_num":200,"type":1}]
         * first_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/personal/unPayList?page=1
         * from : 1
         * last_page : 1
         * last_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/personal/unPayList?page=1
         * next_page_url : null
         * path : http://127.0.0.1:2797/lumen/public/index.php/agent/personal/unPayList
         * per_page : 15
         * prev_page_url : null
         * to : 9
         * total : 9
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
             * broker_id : 303
             * name : 刘瑞林
             * tel : 13485868934
             * client_id : 575
             * broker_type : 推荐佣金
             * create_time : 2018-07-06 05:42:42
             * project_name : 翡翠滨江
             * broker_num : 3245
             * type : 2
             */

            private int broker_id;
            private String name;
            private String tel;
            private int client_id;
            private String broker_type;
            private String create_time;
            private String project_name;
            private float broker_num;
            private int type;

            public int getBroker_id() {
                return broker_id;
            }

            public void setBroker_id(int broker_id) {
                this.broker_id = broker_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public int getClient_id() {
                return client_id;
            }

            public void setClient_id(int client_id) {
                this.client_id = client_id;
            }

            public String getBroker_type() {
                return broker_type;
            }

            public void setBroker_type(String broker_type) {
                this.broker_type = broker_type;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getProject_name() {
                return project_name;
            }

            public void setProject_name(String project_name) {
                this.project_name = project_name;
            }

            public float getBroker_num() {
                return broker_num;
            }

            public void setBroker_num(float broker_num) {
                this.broker_num = broker_num;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
