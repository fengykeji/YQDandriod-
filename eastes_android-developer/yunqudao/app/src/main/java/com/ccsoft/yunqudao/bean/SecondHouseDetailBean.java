package com.ccsoft.yunqudao.bean;

import java.util.List;

public class SecondHouseDetailBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"basic_info":{"house_id":4,"title":"测试标题","house_type":"1室1厅2卫","build_area":143,"project_name":"翡翠滨江","price":1230000,"price_change":0,"property_type":"住宅","project_tags":["涪江畔","5.1米跃层微墅","度假村"],"house_tags":[],"orientation":"1","project_img_url":"upload/project/img/1532514534_57.jpg","check_way":"随时看房","decoration":"暂无装修数据","intent":22,"urgency":33,"project_average_price":6000,"unit_price":8602,"project_total_build":"8"},"img":[{"name":"123","img_url":"upload/project/img/1532514534_57.jpg"}],"focus":{"num":0,"is_focus":0}}
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

    public static class DataBean {
        /**
         * basic_info : {"house_id":4,"title":"测试标题","house_type":"1室1厅2卫","build_area":143,"project_name":"翡翠滨江","price":1230000,"price_change":0,"property_type":"住宅","project_tags":["涪江畔","5.1米跃层微墅","度假村"],"house_tags":[],"orientation":"1","project_img_url":"upload/project/img/1532514534_57.jpg","check_way":"随时看房","decoration":"暂无装修数据","intent":22,"urgency":33,"project_average_price":6000,"unit_price":8602,"project_total_build":"8"}
         * img : [{"name":"123","img_url":"upload/project/img/1532514534_57.jpg"}]
         * focus : {"num":0,"is_focus":0}
         */

        private BasicInfoBean basic_info;
        private FocusBean focus;
        private List<ImgBean> img;

        public BasicInfoBean getBasic_info() {
            return basic_info;
        }

        public void setBasic_info(BasicInfoBean basic_info) {
            this.basic_info = basic_info;
        }

        public FocusBean getFocus() {
            return focus;
        }

        public void setFocus(FocusBean focus) {
            this.focus = focus;
        }

        public List<ImgBean> getImg() {
            return img;
        }

        public void setImg(List<ImgBean> img) {
            this.img = img;
        }

        public static class BasicInfoBean {
            /**
             * house_id : 4
             * title : 测试标题
             * house_type : 1室1厅2卫
             * build_area : 143
             * project_name : 翡翠滨江
             * price : 1230000
             * price_change : 0
             * property_type : 住宅
             * project_tags : ["涪江畔","5.1米跃层微墅","度假村"]
             * house_tags : []
             * orientation : 1
             * project_img_url : upload/project/img/1532514534_57.jpg
             * check_way : 随时看房
             * decoration : 暂无装修数据
             * intent : 22
             * urgency : 33
             * project_average_price : 6000
             * unit_price : 8602
             * project_total_build : 8
             */

            private int house_id;
            private String title;
            private String house_type;
            private int build_area;
            private String project_name;
            private int price;
            private int price_change;
            private String property_type;
            private String orientation;
            private String project_img_url;
            private String check_way;
            private String decoration;
            private int intent;
            private int urgency;
            private int project_average_price;
            private int unit_price;
            private String project_total_build;
            private List<String> project_tags;
            private List<String> house_tags;

            public int getHouse_id() {
                return house_id;
            }

            public void setHouse_id(int house_id) {
                this.house_id = house_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getHouse_type() {
                return house_type;
            }

            public void setHouse_type(String house_type) {
                this.house_type = house_type;
            }

            public int getBuild_area() {
                return build_area;
            }

            public void setBuild_area(int build_area) {
                this.build_area = build_area;
            }

            public String getProject_name() {
                return project_name;
            }

            public void setProject_name(String project_name) {
                this.project_name = project_name;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getPrice_change() {
                return price_change;
            }

            public void setPrice_change(int price_change) {
                this.price_change = price_change;
            }

            public String getProperty_type() {
                return property_type;
            }

            public void setProperty_type(String property_type) {
                this.property_type = property_type;
            }

            public String getOrientation() {
                return orientation;
            }

            public void setOrientation(String orientation) {
                this.orientation = orientation;
            }

            public String getProject_img_url() {
                return project_img_url;
            }

            public void setProject_img_url(String project_img_url) {
                this.project_img_url = project_img_url;
            }

            public String getCheck_way() {
                return check_way;
            }

            public void setCheck_way(String check_way) {
                this.check_way = check_way;
            }

            public String getDecoration() {
                return decoration;
            }

            public void setDecoration(String decoration) {
                this.decoration = decoration;
            }

            public int getIntent() {
                return intent;
            }

            public void setIntent(int intent) {
                this.intent = intent;
            }

            public int getUrgency() {
                return urgency;
            }

            public void setUrgency(int urgency) {
                this.urgency = urgency;
            }

            public int getProject_average_price() {
                return project_average_price;
            }

            public void setProject_average_price(int project_average_price) {
                this.project_average_price = project_average_price;
            }

            public int getUnit_price() {
                return unit_price;
            }

            public void setUnit_price(int unit_price) {
                this.unit_price = unit_price;
            }

            public String getProject_total_build() {
                return project_total_build;
            }

            public void setProject_total_build(String project_total_build) {
                this.project_total_build = project_total_build;
            }

            public List<String> getProject_tags() {
                return project_tags;
            }

            public void setProject_tags(List<String> project_tags) {
                this.project_tags = project_tags;
            }

            public List<String> getHouse_tags() {
                return house_tags;
            }

            public void setHouse_tags(List<String> house_tags) {
                this.house_tags = house_tags;
            }
        }

        public static class FocusBean {
            /**
             * num : 0
             * is_focus : 0
             */

            private int num;
            private int is_focus;

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getIs_focus() {
                return is_focus;
            }

            public void setIs_focus(int is_focus) {
                this.is_focus = is_focus;
            }
        }

        public static class ImgBean {
            /**
             * name : 123
             * img_url : upload/project/img/1532514534_57.jpg
             */

            private String name;
            private String img_url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }
        }
    }
}
