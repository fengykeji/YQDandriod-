package com.ccsoft.yunqudao.bean;

import java.util.List;

public class SurveyListBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"house_code":"CBJ1533799973","project_name":"翡翠滨江","name":"李四","tel":"15082245107","house_id":5,"survey_id":5,"follow_num":0,"last_follow_time":null,"house":"1栋-一单元-1702"}],"first_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/house/survey/list?page=1","from":1,"last_page":1,"last_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/house/survey/list?page=1","next_page_url":null,"path":"http://127.0.0.1:2797/lumen/public/index.php/agent/house/survey/list","per_page":15,"prev_page_url":null,"to":1,"total":1}
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
         * data : [{"house_code":"CBJ1533799973","project_name":"翡翠滨江","name":"李四","tel":"15082245107","house_id":5,"survey_id":5,"follow_num":0,"last_follow_time":null,"house":"1栋-一单元-1702"}]
         * first_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/house/survey/list?page=1
         * from : 1
         * last_page : 1
         * last_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/house/survey/list?page=1
         * next_page_url : null
         * path : http://127.0.0.1:2797/lumen/public/index.php/agent/house/survey/list
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
             * house_code : CBJ1533799973
             * project_name : 翡翠滨江
             * name : 李四
             * tel : 15082245107
             * house_id : 5
             * survey_id : 5
             * follow_num : 0
             * last_follow_time : null
             * house : 1栋-一单元-1702
             */

            private String house_code;
            private String project_name;
            private String name;
            private String tel;
            private int house_id;
            private int survey_id;
            private int follow_num;
            private Object last_follow_time;
            private String house;

            public String getHouse_code() {
                return house_code;
            }

            public void setHouse_code(String house_code) {
                this.house_code = house_code;
            }

            public String getProject_name() {
                return project_name;
            }

            public void setProject_name(String project_name) {
                this.project_name = project_name;
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

            public int getHouse_id() {
                return house_id;
            }

            public void setHouse_id(int house_id) {
                this.house_id = house_id;
            }

            public int getSurvey_id() {
                return survey_id;
            }

            public void setSurvey_id(int survey_id) {
                this.survey_id = survey_id;
            }

            public int getFollow_num() {
                return follow_num;
            }

            public void setFollow_num(int follow_num) {
                this.follow_num = follow_num;
            }

            public Object getLast_follow_time() {
                return last_follow_time;
            }

            public void setLast_follow_time(Object last_follow_time) {
                this.last_follow_time = last_follow_time;
            }

            public String getHouse() {
                return house;
            }

            public void setHouse(String house) {
                this.house = house;
            }
        }
    }
}
