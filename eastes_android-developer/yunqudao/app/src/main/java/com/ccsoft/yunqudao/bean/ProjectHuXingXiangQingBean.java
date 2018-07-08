package com.ccsoft.yunqudao.bean;

import java.io.Serializable;
import java.util.List;

public class ProjectHuXingXiangQingBean implements Serializable{


    /**
     * code : 200
     * msg : 查询成功
     * data : {"baseInfo":{"id":1,"property_area_min":100,"property_area_max":200,"sell_point":"毫无卖点","house_type_name":"S型洋房独栋"},"imgInfo":[{"type":"户型图","list":[]},{"type":"3D图","list":[{"img_id":4,"img_url":"upload/project/img/1524539204_37.png","img_describe":"asdasdasdasdsa","update_time":"2018-04-26 19:19:22","img_type":52},{"img_id":5,"img_url":"upload/agent/headimg/1523850012_10.jpg","img_describe":"asdasdasda","update_time":"2018-05-02 11:00:02","img_type":52}]},{"type":"效果图","list":[{"img_id":6,"img_url":"upload/project/img/1524539204_37.png","img_describe":"ewrewrewwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww","update_time":"2018-04-26 19:19:24","img_type":53},{"img_id":1,"img_url":"upload/agent/headimg/1523850012_10.jpg","img_describe":"www","update_time":"2018-04-24 16:06:36","img_type":53}]},{"type":"平面图","list":[{"img_id":2,"img_url":"upload/project/img/1524539204_37.png","img_describe":"sadsadsadas","update_time":"2018-04-24 16:45:04","img_type":54}]},{"type":"实景图","list":[{"img_id":3,"img_url":"upload/agent/headimg/1523850012_10.jpg","img_describe":"asdasdasda","update_time":"2018-04-28 18:49:10","img_type":55}]}]}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * baseInfo : {"id":1,"property_area_min":100,"property_area_max":200,"sell_point":"毫无卖点","house_type_name":"S型洋房独栋"}
         * imgInfo : [{"type":"户型图","list":[]},{"type":"3D图","list":[{"img_id":4,"img_url":"upload/project/img/1524539204_37.png","img_describe":"asdasdasdasdsa","update_time":"2018-04-26 19:19:22","img_type":52},{"img_id":5,"img_url":"upload/agent/headimg/1523850012_10.jpg","img_describe":"asdasdasda","update_time":"2018-05-02 11:00:02","img_type":52}]},{"type":"效果图","list":[{"img_id":6,"img_url":"upload/project/img/1524539204_37.png","img_describe":"ewrewrewwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww","update_time":"2018-04-26 19:19:24","img_type":53},{"img_id":1,"img_url":"upload/agent/headimg/1523850012_10.jpg","img_describe":"www","update_time":"2018-04-24 16:06:36","img_type":53}]},{"type":"平面图","list":[{"img_id":2,"img_url":"upload/project/img/1524539204_37.png","img_describe":"sadsadsadas","update_time":"2018-04-24 16:45:04","img_type":54}]},{"type":"实景图","list":[{"img_id":3,"img_url":"upload/agent/headimg/1523850012_10.jpg","img_describe":"asdasdasda","update_time":"2018-04-28 18:49:10","img_type":55}]}]
         */

        private BaseInfoBean baseInfo;
        private List<ImgInfoBean> imgInfo;

        public BaseInfoBean getBaseInfo() {
            return baseInfo;
        }

        public void setBaseInfo(BaseInfoBean baseInfo) {
            this.baseInfo = baseInfo;
        }

        public List<ImgInfoBean> getImgInfo() {
            return imgInfo;
        }

        public void setImgInfo(List<ImgInfoBean> imgInfo) {
            this.imgInfo = imgInfo;
        }

        public static class BaseInfoBean implements Serializable{
            /**
             * id : 1
             * property_area_min : 100
             * property_area_max : 200
             * sell_point : 毫无卖点
             * house_type_name : S型洋房独栋
             */

            private int id;
            private int property_area_min;
            private int property_area_max;
            private String sell_point;
            private String house_type_name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getProperty_area_min() {
                return property_area_min;
            }

            public void setProperty_area_min(int property_area_min) {
                this.property_area_min = property_area_min;
            }

            public int getProperty_area_max() {
                return property_area_max;
            }

            public void setProperty_area_max(int property_area_max) {
                this.property_area_max = property_area_max;
            }

            public String getSell_point() {
                return sell_point;
            }

            public void setSell_point(String sell_point) {
                this.sell_point = sell_point;
            }

            public String getHouse_type_name() {
                return house_type_name;
            }

            public void setHouse_type_name(String house_type_name) {
                this.house_type_name = house_type_name;
            }
        }

        public static class ImgInfoBean implements Serializable{
            /**
             * type : 户型图
             * list : []
             */

            private String type;
            private List<listbean> list;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<listbean> getList() {
                return list;
            }

            public void setList(List<listbean> list) {
                this.list = list;
            }

            public static class listbean implements Serializable{
                private int img_id;
                private String img_url;
                private String img_describe;
                private String update_time;
                private int img_type;

                public void setImg_id(int img_id) {
                    this.img_id = img_id;
                }

                public void setImg_url(String img_url) {
                    this.img_url = img_url;
                }

                public void setImg_describe(String img_describe) {
                    this.img_describe = img_describe;
                }

                public void setUpdate_time(String update_time) {
                    this.update_time = update_time;
                }

                public void setImg_type(int img_type) {
                    this.img_type = img_type;
                }

                public int getImg_id() {

                    return img_id;
                }

                public String getImg_url() {
                    return img_url;
                }

                public String getImg_describe() {
                    return img_describe;
                }

                public String getUpdate_time() {
                    return update_time;
                }

                public int getImg_type() {
                    return img_type;
                }
            }
        }
    }
}
