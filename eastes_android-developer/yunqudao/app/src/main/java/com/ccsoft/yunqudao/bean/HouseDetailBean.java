package com.ccsoft.yunqudao.bean;

import java.util.List;

public class HouseDetailBean {


    /**
     * code : 200
     * msg : 查询成功
     * data : {"project_basic_info":{"project_id":1,"project_name":"云算2","absolute_address":"成都郫县菁蓉大禹东路123号","sale_state":"待售","average_price":70000,"project_tags":"56,57,58","developer_name":"云算公馆","total_float_url":"http://120.27.21.136:2798/upload/agent/headimg/1523850012_10.jpg","total_float_url_phone":"upload/agent/headimg/1526565231_31.jpg","longitude":103.86763,"latitude":30.78698349,"yunsuan_url":"39.108.60.120:10009","yunsuan_id":13,"property_type":["商铺","别墅"]},"dynamic":{"first":{"dynamic_id":2,"title":"测试标题","create_time":"2018-03-26 00:00:00","update_time":"2018-03-26 14:42:59","img_url":"","content":"测试内容","state":1},"count":5},"house_type":[{"id":1,"house_type_name":"S型洋房独栋","house_type":"3室2厅2卫","sale_state":"待售","img_url":"upload/project/img/1524539204_37.png","property_area_min":100,"property_area_max":200},{"id":2,"house_type_name":"A型别墅","house_type":"1室1厅2卫","sale_state":"在售","img_url":"upload/agent/headimg/1523850012_10.jpg","property_area_min":100,"property_area_max":200},{"id":3,"house_type_name":"B型公寓","house_type":"1室1厅1卫","sale_state":"售罄","img_url":"upload/project/img/1524539204_37.png","property_area_min":200,"property_area_max":2520},{"id":4,"house_type_name":"C型公寓","house_type":"3室2厅2卫","sale_state":"待售","img_url":"upload/agent/headimg/1523850012_10.jpg","property_area_min":100,"property_area_max":788},{"id":5,"house_type_name":"D型公寓","house_type":"1室1厅2卫","sale_state":"待售","img_url":"upload/project/img/1524539204_37.png","property_area_min":355,"property_area_max":600},{"id":6,"house_type_name":"E型公寓","house_type":"1室1厅1卫","sale_state":"待售","img_url":"upload/agent/headimg/1523850012_10.jpg","property_area_min":200,"property_area_max":200}],"project_img":{"url":[{"img_url":"upload/agent/headimg/1523850012_10.jpg"},{"img_url":"upload/agent/headimg/1523850012_10.jpg"},{"img_url":"upload/project/img/1524463483_23.png"},{"img_url":"upload/project/img/1524463483_23.png"},{"img_url":"upload/project/img/1524463483_23.png"},{"img_url":"upload/agent/headimg/1523850012_10.jpg"},{"img_url":"upload/project/img/1524463483_23.png"}]},"build_info":{"handing_room_time":"2018-05-08","open_time":"2018-05-08","open_way":"网上开盘"},"focus":{"num":7,"is_focus":0},"butter_tel":"15082245102"}
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
         * project_basic_info : {"project_id":1,"project_name":"云算2","absolute_address":"成都郫县菁蓉大禹东路123号","sale_state":"待售","average_price":70000,"project_tags":"56,57,58","developer_name":"云算公馆","total_float_url":"http://120.27.21.136:2798/upload/agent/headimg/1523850012_10.jpg","total_float_url_phone":"upload/agent/headimg/1526565231_31.jpg","longitude":103.86763,"latitude":30.78698349,"yunsuan_url":"39.108.60.120:10009","yunsuan_id":13,"property_type":["商铺","别墅"]}
         * dynamic : {"first":{"dynamic_id":2,"title":"测试标题","create_time":"2018-03-26 00:00:00","update_time":"2018-03-26 14:42:59","img_url":"","content":"测试内容","state":1},"count":5}
         * house_type : [{"id":1,"house_type_name":"S型洋房独栋","house_type":"3室2厅2卫","sale_state":"待售","img_url":"upload/project/img/1524539204_37.png","property_area_min":100,"property_area_max":200},{"id":2,"house_type_name":"A型别墅","house_type":"1室1厅2卫","sale_state":"在售","img_url":"upload/agent/headimg/1523850012_10.jpg","property_area_min":100,"property_area_max":200},{"id":3,"house_type_name":"B型公寓","house_type":"1室1厅1卫","sale_state":"售罄","img_url":"upload/project/img/1524539204_37.png","property_area_min":200,"property_area_max":2520},{"id":4,"house_type_name":"C型公寓","house_type":"3室2厅2卫","sale_state":"待售","img_url":"upload/agent/headimg/1523850012_10.jpg","property_area_min":100,"property_area_max":788},{"id":5,"house_type_name":"D型公寓","house_type":"1室1厅2卫","sale_state":"待售","img_url":"upload/project/img/1524539204_37.png","property_area_min":355,"property_area_max":600},{"id":6,"house_type_name":"E型公寓","house_type":"1室1厅1卫","sale_state":"待售","img_url":"upload/agent/headimg/1523850012_10.jpg","property_area_min":200,"property_area_max":200}]
         * project_img : {"url":[{"img_url":"upload/agent/headimg/1523850012_10.jpg"},{"img_url":"upload/agent/headimg/1523850012_10.jpg"},{"img_url":"upload/project/img/1524463483_23.png"},{"img_url":"upload/project/img/1524463483_23.png"},{"img_url":"upload/project/img/1524463483_23.png"},{"img_url":"upload/agent/headimg/1523850012_10.jpg"},{"img_url":"upload/project/img/1524463483_23.png"}]}
         * build_info : {"handing_room_time":"2018-05-08","open_time":"2018-05-08","open_way":"网上开盘"}
         * focus : {"num":7,"is_focus":0}
         * butter_tel : 15082245102
         */

        private ProjectBasicInfoBean project_basic_info;
        private DynamicBean dynamic;
        private ProjectImgBean project_img;
        private BuildInfoBean build_info;
        private FocusBean focus;
        private String butter_tel;
        private List<HouseTypeBean> house_type;

        public ProjectBasicInfoBean getProject_basic_info() {
            return project_basic_info;
        }

        public void setProject_basic_info(ProjectBasicInfoBean project_basic_info) {
            this.project_basic_info = project_basic_info;
        }

        public DynamicBean getDynamic() {
            return dynamic;
        }

        public void setDynamic(DynamicBean dynamic) {
            this.dynamic = dynamic;
        }

        public ProjectImgBean getProject_img() {
            return project_img;
        }

        public void setProject_img(ProjectImgBean project_img) {
            this.project_img = project_img;
        }

        public BuildInfoBean getBuild_info() {
            return build_info;
        }

        public void setBuild_info(BuildInfoBean build_info) {
            this.build_info = build_info;
        }

        public FocusBean getFocus() {
            return focus;
        }

        public void setFocus(FocusBean focus) {
            this.focus = focus;
        }

        public String getButter_tel() {
            return butter_tel;
        }

        public void setButter_tel(String butter_tel) {
            this.butter_tel = butter_tel;
        }

        public List<HouseTypeBean> getHouse_type() {
            return house_type;
        }

        public void setHouse_type(List<HouseTypeBean> house_type) {
            this.house_type = house_type;
        }

        public static class ProjectBasicInfoBean {
            /**
             * project_id : 1
             * project_name : 云算2
             * absolute_address : 成都郫县菁蓉大禹东路123号
             * sale_state : 待售
             * average_price : 70000
             * project_tags : 56,57,58
             * developer_name : 云算公馆
             * total_float_url : http://120.27.21.136:2798/upload/agent/headimg/1523850012_10.jpg
             * total_float_url_phone : upload/agent/headimg/1526565231_31.jpg
             * longitude : 103.86763
             * latitude : 30.78698349
             * yunsuan_url : 39.108.60.120:10009
             * yunsuan_id : 13
             * property_type : ["商铺","别墅"]
             */

            private int project_id;
            private String project_name;
            private String absolute_address;
            private String sale_state;
            private int average_price;
            private String project_tags;
            private String developer_name;
            private String total_float_url;
            private String total_float_url_phone;
            private double longitude;
            private double latitude;
            private String yunsuan_url;
            private int yunsuan_id;
            private List<String> property_type;

            public int getProject_id() {
                return project_id;
            }

            public void setProject_id(int project_id) {
                this.project_id = project_id;
            }

            public String getProject_name() {
                return project_name;
            }

            public void setProject_name(String project_name) {
                this.project_name = project_name;
            }

            public String getAbsolute_address() {
                return absolute_address;
            }

            public void setAbsolute_address(String absolute_address) {
                this.absolute_address = absolute_address;
            }

            public String getSale_state() {
                return sale_state;
            }

            public void setSale_state(String sale_state) {
                this.sale_state = sale_state;
            }

            public int getAverage_price() {
                return average_price;
            }

            public void setAverage_price(int average_price) {
                this.average_price = average_price;
            }

            public String getProject_tags() {
                return project_tags;
            }

            public void setProject_tags(String project_tags) {
                this.project_tags = project_tags;
            }

            public String getDeveloper_name() {
                return developer_name;
            }

            public void setDeveloper_name(String developer_name) {
                this.developer_name = developer_name;
            }

            public String getTotal_float_url() {
                return total_float_url;
            }

            public void setTotal_float_url(String total_float_url) {
                this.total_float_url = total_float_url;
            }

            public String getTotal_float_url_phone() {
                return total_float_url_phone;
            }

            public void setTotal_float_url_phone(String total_float_url_phone) {
                this.total_float_url_phone = total_float_url_phone;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public String getYunsuan_url() {
                return yunsuan_url;
            }

            public void setYunsuan_url(String yunsuan_url) {
                this.yunsuan_url = yunsuan_url;
            }

            public int getYunsuan_id() {
                return yunsuan_id;
            }

            public void setYunsuan_id(int yunsuan_id) {
                this.yunsuan_id = yunsuan_id;
            }

            public List<String> getProperty_type() {
                return property_type;
            }

            public void setProperty_type(List<String> property_type) {
                this.property_type = property_type;
            }
        }

        public static class DynamicBean {
            /**
             * first : {"dynamic_id":2,"title":"测试标题","create_time":"2018-03-26 00:00:00","update_time":"2018-03-26 14:42:59","img_url":"","content":"测试内容","state":1}
             * count : 5
             */

            private FirstBean first;
            private int count;

            public FirstBean getFirst() {
                return first;
            }

            public void setFirst(FirstBean first) {
                this.first = first;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public static class FirstBean {
                /**
                 * dynamic_id : 2
                 * title : 测试标题
                 * create_time : 2018-03-26 00:00:00
                 * update_time : 2018-03-26 14:42:59
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

        public static class ProjectImgBean {
            private List<UrlBean> url;

            public List<UrlBean> getUrl() {
                return url;
            }

            public void setUrl(List<UrlBean> url) {
                this.url = url;
            }

            public static class UrlBean {
                /**
                 * img_url : upload/agent/headimg/1523850012_10.jpg
                 */

                private String img_url;

                public String getImg_url() {
                    return img_url;
                }

                public void setImg_url(String img_url) {
                    this.img_url = img_url;
                }
            }
        }

        public static class BuildInfoBean {
            /**
             * handing_room_time : 2018-05-08
             * open_time : 2018-05-08
             * open_way : 网上开盘
             */

            private String handing_room_time;
            private String open_time;
            private String open_way;

            public String getHanding_room_time() {
                return handing_room_time;
            }

            public void setHanding_room_time(String handing_room_time) {
                this.handing_room_time = handing_room_time;
            }

            public String getOpen_time() {
                return open_time;
            }

            public void setOpen_time(String open_time) {
                this.open_time = open_time;
            }

            public String getOpen_way() {
                return open_way;
            }

            public void setOpen_way(String open_way) {
                this.open_way = open_way;
            }
        }

        public static class FocusBean {
            /**
             * num : 7
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

        public static class HouseTypeBean {
            /**
             * id : 1
             * house_type_name : S型洋房独栋
             * house_type : 3室2厅2卫
             * sale_state : 待售
             * img_url : upload/project/img/1524539204_37.png
             * property_area_min : 100
             * property_area_max : 200
             */

            private int id;
            private String house_type_name;
            private String house_type;
            private String sale_state;
            private String img_url;
            private int property_area_min;
            private int property_area_max;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getHouse_type_name() {
                return house_type_name;
            }

            public void setHouse_type_name(String house_type_name) {
                this.house_type_name = house_type_name;
            }

            public String getHouse_type() {
                return house_type;
            }

            public void setHouse_type(String house_type) {
                this.house_type = house_type;
            }

            public String getSale_state() {
                return sale_state;
            }

            public void setSale_state(String sale_state) {
                this.sale_state = sale_state;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
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
        }
    }
}
