package com.ccsoft.yunqudao.bean;

import java.io.Serializable;
import java.util.List;

public class ProjectImgGetBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : [{"name":"3D图","data":[{"img_id":6,"img_url":"upload/agent/headimg/1523850012_10.jpg","create_time":"2018-04-20 16:49:55","comment":"奥术大师多所","sort":1},{"img_id":7,"img_url":"upload/project/img/1524463483_23.png","create_time":"2018-04-23 10:24:55","comment":"ASD","sort":2}]},{"name":"实景图","data":[{"img_id":4,"img_url":"upload/agent/headimg/1523850012_10.jpg","create_time":"2018-04-20 16:49:47","comment":"实打实大所多撒大","sort":1},{"img_id":5,"img_url":"upload/project/img/1524463483_23.png","create_time":"2018-04-20 16:49:50","comment":"奥术大师多所","sort":2}]},{"name":"效果图","data":[{"img_id":3,"img_url":"upload/project/img/1524463483_23.png","create_time":"2018-04-20 16:49:42","comment":"1234567","sort":1},{"img_id":2,"img_url":"upload/agent/headimg/1523850012_10.jpg","create_time":"2018-04-20 16:49:38","comment":"321","sort":2},{"img_id":1,"img_url":"upload/project/img/1524463483_23.png","create_time":"2018-04-20 16:49:33","comment":"123","sort":3}]}]
     */

    private int code;
    private String msg;
    private List<DataBeanX> data;

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

    public List<DataBeanX> getData() {
        return data;
    }

    public void setData(List<DataBeanX> data) {
        this.data = data;
    }

    public static class DataBeanX implements Serializable{
        /**
         * name : 3D图
         * data : [{"img_id":6,"img_url":"upload/agent/headimg/1523850012_10.jpg","create_time":"2018-04-20 16:49:55","comment":"奥术大师多所","sort":1},{"img_id":7,"img_url":"upload/project/img/1524463483_23.png","create_time":"2018-04-23 10:24:55","comment":"ASD","sort":2}]
         */

        private String name;
        private List<DataBean> data;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * img_id : 6
             * img_url : upload/agent/headimg/1523850012_10.jpg
             * create_time : 2018-04-20 16:49:55
             * comment : 奥术大师多所
             * sort : 1
             */

            private int img_id;
            private String img_url;
            private String create_time;
            private String comment;
            private int sort;

            public int getImg_id() {
                return img_id;
            }

            public void setImg_id(int img_id) {
                this.img_id = img_id;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }
        }
    }
}
