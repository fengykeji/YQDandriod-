package com.ccsoft.yunqudao.bean;

import java.util.List;

public class HouseDetailBean {


    /**
     * code : 200
     * msg : 查询成功
     * data : {"project_basic_info":{"project_id":3,"project_name":"大唐公馆","absolute_address":"月球","sale_state":"待售","average_price":9000,"project_tags":"56,57,58","developer_name":"云算公馆","total_float_url":"upload/project/img/1524463483_23.png","total_float_url_phone":"upload/project/img/06.jpg","longitude":103.86763,"latitude":30.78698349,"yunsuan_url":"47.106.39.169:2798","yunsuan_id":13,"property_type":["别墅"]},"dynamic":{"first":[],"count":0},"house_type":[],"project_img":{"url":[]},"build_info":{"handing_room_time":"暂无数据","open_time":"暂无数据","open_way":"暂无数据"},"focus":{"num":2,"is_focus":0},"butter_tel":"18628850789"}
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
         * project_basic_info : {"project_id":3,"project_name":"大唐公馆","absolute_address":"月球","sale_state":"待售","average_price":9000,"project_tags":"56,57,58","developer_name":"云算公馆","total_float_url":"upload/project/img/1524463483_23.png","total_float_url_phone":"upload/project/img/06.jpg","longitude":103.86763,"latitude":30.78698349,"yunsuan_url":"47.106.39.169:2798","yunsuan_id":13,"property_type":["别墅"]}
         * dynamic : {"first":[],"count":0}
         * house_type : []
         * project_img : {"url":[]}
         * build_info : {"handing_room_time":"暂无数据","open_time":"暂无数据","open_way":"暂无数据"}
         * focus : {"num":2,"is_focus":0}
         * butter_tel : 18628850789
         */

        private ProjectBasicInfoBean project_basic_info;
        private DynamicBean dynamic;
        private ProjectImgBean project_img;
        private BuildInfoBean build_info;
        private FocusBean focus;
        private String butter_tel;
        private List<?> house_type;

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

        public List<?> getHouse_type() {
            return house_type;
        }

        public void setHouse_type(List<?> house_type) {
            this.house_type = house_type;
        }

        public static class ProjectBasicInfoBean {
            /**
             * project_id : 3
             * project_name : 大唐公馆
             * absolute_address : 月球
             * sale_state : 待售
             * average_price : 9000
             * project_tags : 56,57,58
             * developer_name : 云算公馆
             * total_float_url : upload/project/img/1524463483_23.png
             * total_float_url_phone : upload/project/img/06.jpg
             * longitude : 103.86763
             * latitude : 30.78698349
             * yunsuan_url : 47.106.39.169:2798
             * yunsuan_id : 13
             * property_type : ["别墅"]
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
             * first : []
             * count : 0
             */

            private int count;
            private List<?> first;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public List<?> getFirst() {
                return first;
            }

            public void setFirst(List<?> first) {
                this.first = first;
            }
        }

        public static class ProjectImgBean {
            private List<?> url;

            public List<?> getUrl() {
                return url;
            }

            public void setUrl(List<?> url) {
                this.url = url;
            }
        }

        public static class BuildInfoBean {
            /**
             * handing_room_time : 暂无数据
             * open_time : 暂无数据
             * open_way : 暂无数据
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
             * num : 2
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
    }
}
