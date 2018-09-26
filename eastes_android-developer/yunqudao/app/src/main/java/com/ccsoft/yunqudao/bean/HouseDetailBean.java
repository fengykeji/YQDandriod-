package com.ccsoft.yunqudao.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class HouseDetailBean implements Serializable{


    /**
     * code : 200
     * msg : 查询成功
     * data : {"project_basic_info":{"project_id":1,"project_name":"翡翠滨江","absolute_address":"四川省绵阳市三台县涪滨路","sale_state":"待售","average_price":6000,"project_tags":"145,146","developer_name":"三台县鸿州房地产开发有限公司","total_float_url":"upload/project/img/1529910374_21.jpg","total_float_url_phone":"upload/project/img/1529914691_58.jpg","longitude":105.11082458,"latitude":31.10180855,"yunsuan_url":"","yunsuan_id":0,"property_type":["住宅","公寓"]},"dynamic":{"first":{"dynamic_id":31,"title":"232","create_time":"2018-07-03 10:07:06","update_time":"2018-07-03 10:07:06","abstract":"4324334","url":"upload/project/dynamic/31.html"},"count":5},"house_type":[{"id":26,"house_type_name":"A型户型","house_type":"3室2厅2卫","sale_state":"待售","img_url":"upload/project/img/1530676746_46.jpg","property_area_min":214,"property_area_max":412},{"id":3,"house_type_name":"B型公寓","house_type":"1室1厅1卫","sale_state":"售罄","img_url":"upload/project/img/hx.jpg","property_area_min":200,"property_area_max":2520},{"id":2,"house_type_name":"C型别墅","house_type":"3室2厅2卫","sale_state":"在售","img_url":"upload/project/img/hx.jpg","property_area_min":200,"property_area_max":300},{"id":52,"house_type_name":"D户型","house_type":"3室2厅1卫","sale_state":"待售","img_url":"","property_area_min":200,"property_area_max":300},{"id":27,"house_type_name":"E型房","house_type":"3室2厅1卫","sale_state":"待售","img_url":null,"property_area_min":80,"property_area_max":120},{"id":50,"house_type_name":"G型别墅","house_type":"3室2厅2卫","sale_state":"待售","img_url":null,"property_area_min":100,"property_area_max":200}],"project_img":{"url":[{"img_url":"upload/aio/2018-06-07/1528381828811087.jpg"},{"img_url":"upload/project/img/1530584382_96.jpeg"},{"img_url":"upload/project/img/1528186024_84.jpg"},{"img_url":"upload/project/img/1530502259_71.jpeg"},{"img_url":"upload/project/img/1528186052_58.jpg"},{"img_url":"upload/project/img/1528273888_94.jpg"},{"img_url":"upload/project/img/1530261030_88.jpg"},{"img_url":"upload/aio/2018-06-07/1528381810302274.jpg"},{"img_url":"upload/project/img/1530521842_13.jpg"},{"img_url":"upload/project/img/1530697677_75.png"}]},"build_info":{"handing_room_time":"2018-06-03","open_time":"2018-06-02","open_way":"线下开盘"},"focus":{"num":8,"is_focus":0},"butter_tel":"15983804767"}
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
         * project_basic_info : {"project_id":1,"project_name":"翡翠滨江","absolute_address":"四川省绵阳市三台县涪滨路","sale_state":"待售","average_price":6000,"project_tags":"145,146","developer_name":"三台县鸿州房地产开发有限公司","total_float_url":"upload/project/img/1529910374_21.jpg","total_float_url_phone":"upload/project/img/1529914691_58.jpg","longitude":105.11082458,"latitude":31.10180855,"yunsuan_url":"","yunsuan_id":0,"property_type":["住宅","公寓"]}
         * dynamic : {"first":{"dynamic_id":31,"title":"232","create_time":"2018-07-03 10:07:06","update_time":"2018-07-03 10:07:06","abstract":"4324334","url":"upload/project/dynamic/31.html"},"count":5}
         * house_type : [{"id":26,"house_type_name":"A型户型","house_type":"3室2厅2卫","sale_state":"待售","img_url":"upload/project/img/1530676746_46.jpg","property_area_min":214,"property_area_max":412},{"id":3,"house_type_name":"B型公寓","house_type":"1室1厅1卫","sale_state":"售罄","img_url":"upload/project/img/hx.jpg","property_area_min":200,"property_area_max":2520},{"id":2,"house_type_name":"C型别墅","house_type":"3室2厅2卫","sale_state":"在售","img_url":"upload/project/img/hx.jpg","property_area_min":200,"property_area_max":300},{"id":52,"house_type_name":"D户型","house_type":"3室2厅1卫","sale_state":"待售","img_url":"","property_area_min":200,"property_area_max":300},{"id":27,"house_type_name":"E型房","house_type":"3室2厅1卫","sale_state":"待售","img_url":null,"property_area_min":80,"property_area_max":120},{"id":50,"house_type_name":"G型别墅","house_type":"3室2厅2卫","sale_state":"待售","img_url":null,"property_area_min":100,"property_area_max":200}]
         * project_img : {"url":[{"img_url":"upload/aio/2018-06-07/1528381828811087.jpg"},{"img_url":"upload/project/img/1530584382_96.jpeg"},{"img_url":"upload/project/img/1528186024_84.jpg"},{"img_url":"upload/project/img/1530502259_71.jpeg"},{"img_url":"upload/project/img/1528186052_58.jpg"},{"img_url":"upload/project/img/1528273888_94.jpg"},{"img_url":"upload/project/img/1530261030_88.jpg"},{"img_url":"upload/aio/2018-06-07/1528381810302274.jpg"},{"img_url":"upload/project/img/1530521842_13.jpg"},{"img_url":"upload/project/img/1530697677_75.png"}]}
         * build_info : {"handing_room_time":"2018-06-03","open_time":"2018-06-02","open_way":"线下开盘"}
         * focus : {"num":8,"is_focus":0}
         * butter_tel : 15983804767
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

        public static class ProjectBasicInfoBean implements Serializable{
            /**
             * project_id : 1
             * project_name : 翡翠滨江
             * absolute_address : 四川省绵阳市三台县涪滨路
             * sale_state : 待售
             * average_price : 6000
             * project_tags : 145,146
             * developer_name : 三台县鸿州房地产开发有限公司
             * total_float_url : upload/project/img/1529910374_21.jpg
             * total_float_url_phone : upload/project/img/1529914691_58.jpg
             * longitude : 105.11082458
             * latitude : 31.10180855
             * yunsuan_url :
             * yunsuan_id : 0
             * property_type : ["住宅","公寓"]
             */

            private int project_id;
            private String project_name;
            private String absolute_address;
            private String sale_state;
            private float average_price;
            private String project_tags;
            private String developer_name;
            private String total_float_url;
            private String total_float_url_phone;
            private String total_float_url_panorama;

            public void setTotal_float_url_panorama(String total_float_url_panorama) {
                this.total_float_url_panorama = total_float_url_panorama;
            }

            public String getTotal_float_url_panorama() {

                return total_float_url_panorama;
            }

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

            public float getAverage_price() {
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

        public static class DynamicBean implements Serializable{
            /**
             * first : {"dynamic_id":31,"title":"232","create_time":"2018-07-03 10:07:06","update_time":"2018-07-03 10:07:06","abstract":"4324334","url":"upload/project/dynamic/31.html"}
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

            public static class FirstBean implements Serializable{
                /**
                 * dynamic_id : 31
                 * title : 232
                 * create_time : 2018-07-03 10:07:06
                 * update_time : 2018-07-03 10:07:06
                 * abstract : 4324334
                 * url : upload/project/dynamic/31.html
                 */

                private int dynamic_id;
                private String title;
                private String create_time;
                private String update_time;
                private String url;
                private String abstracts;

                public void setAbstracts(String abstracts) {
                    this.abstracts = abstracts;
                }

                public String getAbstracts() {

                    return abstracts;
                }

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


                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class ProjectImgBean implements Serializable{
            private List<UrlBean> url;

            public List<UrlBean> getUrl() {
                return url;
            }

            public void setUrl(List<UrlBean> url) {
                this.url = url;
            }

            public static class UrlBean implements Serializable{
                /**
                 * img_url : upload/aio/2018-06-07/1528381828811087.jpg
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

        public static class BuildInfoBean implements Serializable{
            /**
             * handing_room_time : 2018-06-03
             * open_time : 2018-06-02
             * open_way : 线下开盘
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

        public static class FocusBean implements Serializable{
            /**
             * num : 8
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

        public static class HouseTypeBean implements Serializable{
            /**
             * id : 26
             * house_type_name : A型户型
             * house_type : 3室2厅2卫
             * sale_state : 待售
             * img_url : upload/project/img/1530676746_46.jpg
             * property_area_min : 214
             * property_area_max : 412
             */

            private int id;
            private String house_type_name;
            private String house_type;
            private String sale_state;
            private String img_url;
            private float property_area_min;
            private float property_area_max;

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

            public float getProperty_area_min() {
                return property_area_min;
            }

            public void setProperty_area_min(int property_area_min) {
                this.property_area_min = property_area_min;
            }

            public float getProperty_area_max() {
                return property_area_max;
            }

            public void setProperty_area_max(int property_area_max) {
                this.property_area_max = property_area_max;
            }
        }
    }
}
