package com.ccsoft.yunqudao.bean;

import java.util.List;

public class WorkListBean {
    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"name":"任我行","project_name":"云算2","client_id":272,"create_time":"2018-05-29 09:14:06","title":"客户无效信息","message_id":1013,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":1013}},{"name":"钉3","project_name":"链家大唐公馆","client_id":397,"create_time":"2018-05-29 01:21:36","title":"客户无效信息","message_id":1012,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":1012}},{"name":"钉3","project_name":"大唐公馆","client_id":398,"create_time":"2018-05-28 22:18:38","title":"客户无效信息","message_id":1009,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":1009}},{"name":"六六零","project_name":"大唐公馆","client_id":393,"create_time":"2018-05-28 14:37:39","title":"客户无效信息","message_id":1001,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":1001}},{"name":"六六零","project_name":"链家大唐公馆","client_id":392,"create_time":"2018-05-28 14:37:39","title":"客户无效信息","message_id":1000,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":1000}},{"name":"黄怡","project_name":"链家大唐公馆","client_id":390,"create_time":"2018-05-28 14:37:39","title":"客户无效信息","message_id":999,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":999}},{"name":"黄怡","project_name":"大唐公馆","client_id":389,"create_time":"2018-05-28 14:37:39","title":"客户无效信息","message_id":998,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":998}},{"name":"杨二jjj","project_name":"大唐公馆","client_id":385,"create_time":"2018-05-28 14:37:39","title":"客户无效信息","message_id":997,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":997}},{"name":"杨二jjj","project_name":"链家大唐公馆","client_id":384,"create_time":"2018-05-28 14:37:39","title":"客户无效信息","message_id":996,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":996}},{"name":"健健康康","project_name":"大唐公馆","client_id":383,"create_time":"2018-05-28 14:37:39","title":"客户无效信息","message_id":995,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":995}},{"name":"阿鹿头","project_name":"链家大唐公馆","client_id":382,"create_time":"2018-05-28 14:37:39","title":"客户无效信息","message_id":994,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":994}},{"name":"陆军","project_name":"云算2","client_id":395,"create_time":"2018-05-28 01:15:58","title":"客户有效到访","message_id":990,"message_type":3,"attribute":{"is_read":0,"type":2,"message_id":990}},{"name":"陆军","project_name":"云算2","client_id":395,"create_time":"2018-05-28 01:14:33","title":"客户确认来访","message_id":989,"message_type":2,"attribute":{"is_read":0,"type":2,"message_id":989}},{"name":"杨二jjj","project_name":"云算2","client_id":394,"create_time":"2018-05-28 01:10:07","title":"客户无效信息","message_id":986,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":986}},{"name":"六六零","project_name":"云算2","client_id":391,"create_time":"2018-05-28 01:10:07","title":"客户无效信息","message_id":985,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":985}}],"first_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/message/work/list?page=1","from":1,"last_page":4,"last_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/message/work/list?page=4","next_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/message/work/list?page=2","path":"http://127.0.0.1:2797/lumen/public/index.php/agent/message/work/list","per_page":15,"prev_page_url":null,"to":15,"total":56}
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
         * data : [{"name":"任我行","project_name":"云算2","client_id":272,"create_time":"2018-05-29 09:14:06","title":"客户无效信息","message_id":1013,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":1013}},{"name":"钉3","project_name":"链家大唐公馆","client_id":397,"create_time":"2018-05-29 01:21:36","title":"客户无效信息","message_id":1012,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":1012}},{"name":"钉3","project_name":"大唐公馆","client_id":398,"create_time":"2018-05-28 22:18:38","title":"客户无效信息","message_id":1009,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":1009}},{"name":"六六零","project_name":"大唐公馆","client_id":393,"create_time":"2018-05-28 14:37:39","title":"客户无效信息","message_id":1001,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":1001}},{"name":"六六零","project_name":"链家大唐公馆","client_id":392,"create_time":"2018-05-28 14:37:39","title":"客户无效信息","message_id":1000,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":1000}},{"name":"黄怡","project_name":"链家大唐公馆","client_id":390,"create_time":"2018-05-28 14:37:39","title":"客户无效信息","message_id":999,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":999}},{"name":"黄怡","project_name":"大唐公馆","client_id":389,"create_time":"2018-05-28 14:37:39","title":"客户无效信息","message_id":998,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":998}},{"name":"杨二jjj","project_name":"大唐公馆","client_id":385,"create_time":"2018-05-28 14:37:39","title":"客户无效信息","message_id":997,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":997}},{"name":"杨二jjj","project_name":"链家大唐公馆","client_id":384,"create_time":"2018-05-28 14:37:39","title":"客户无效信息","message_id":996,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":996}},{"name":"健健康康","project_name":"大唐公馆","client_id":383,"create_time":"2018-05-28 14:37:39","title":"客户无效信息","message_id":995,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":995}},{"name":"阿鹿头","project_name":"链家大唐公馆","client_id":382,"create_time":"2018-05-28 14:37:39","title":"客户无效信息","message_id":994,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":994}},{"name":"陆军","project_name":"云算2","client_id":395,"create_time":"2018-05-28 01:15:58","title":"客户有效到访","message_id":990,"message_type":3,"attribute":{"is_read":0,"type":2,"message_id":990}},{"name":"陆军","project_name":"云算2","client_id":395,"create_time":"2018-05-28 01:14:33","title":"客户确认来访","message_id":989,"message_type":2,"attribute":{"is_read":0,"type":2,"message_id":989}},{"name":"杨二jjj","project_name":"云算2","client_id":394,"create_time":"2018-05-28 01:10:07","title":"客户无效信息","message_id":986,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":986}},{"name":"六六零","project_name":"云算2","client_id":391,"create_time":"2018-05-28 01:10:07","title":"客户无效信息","message_id":985,"message_type":0,"attribute":{"is_read":0,"type":2,"message_id":985}}]
         * first_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/message/work/list?page=1
         * from : 1
         * last_page : 4
         * last_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/message/work/list?page=4
         * next_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/message/work/list?page=2
         * path : http://127.0.0.1:2797/lumen/public/index.php/agent/message/work/list
         * per_page : 15
         * prev_page_url : null
         * to : 15
         * total : 56
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
             * name : 任我行
             * project_name : 云算2
             * client_id : 272
             * create_time : 2018-05-29 09:14:06
             * title : 客户无效信息
             * message_id : 1013
             * message_type : 0
             * attribute : {"is_read":0,"type":2,"message_id":1013}
             */

            private String name;
            private String project_name;
            private int client_id;
            private String create_time;
            private String title;
            private int message_id;
            private int message_type;
            private AttributeBean attribute;

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

            public int getClient_id() {
                return client_id;
            }

            public void setClient_id(int client_id) {
                this.client_id = client_id;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getMessage_id() {
                return message_id;
            }

            public void setMessage_id(int message_id) {
                this.message_id = message_id;
            }

            public int getMessage_type() {
                return message_type;
            }

            public void setMessage_type(int message_type) {
                this.message_type = message_type;
            }

            public AttributeBean getAttribute() {
                return attribute;
            }

            public void setAttribute(AttributeBean attribute) {
                this.attribute = attribute;
            }

            public static class AttributeBean {
                /**
                 * is_read : 0
                 * type : 2
                 * message_id : 1013
                 */

                private int is_read;
                private int type;
                private int message_id;

                public int getIs_read() {
                    return is_read;
                }

                public void setIs_read(int is_read) {
                    this.is_read = is_read;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public int getMessage_id() {
                    return message_id;
                }

                public void setMessage_id(int message_id) {
                    this.message_id = message_id;
                }
            }
        }
    }
}
