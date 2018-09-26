package com.ccsoft.yunqudao.bean;

import java.io.Serializable;
import java.util.List;

public class CustomersGetInfoBean implements Serializable{


    /**
     * code : 200
     * msg : 查询成功
     * data : {"basic":{"client_id":1,"name":"测试人员","sex":1,"tel":"15082245107","card_type":1,"card_id":"111111","province":"510000","city":"510100","district":"510124","address":"","birth":"0000-00-00","province_name":"四川省","city_name":"成都市","district_name":"郫县"},"need_info":[{"need_id":1,"client_id":1,"agent_id":22,"need_tags":"104,105","property_type":60,"total_price":95,"area":100,"house_type":"34","orientation":0,"floor_min":0,"floor_max":0,"ladder_ratio":"0","decorate":0,"buy_purpose":45,"pay_type":0,"intent":0,"urgency":0,"comment":"213","create_time":"0000-00-00 00:00:00","update_time":"2018-07-03 19:18:20","state":1,"region":[{"province":"310000","province_name":"上海市","city":"310100","city_name":"市辖区","district":"310106","district_name":"静安区"}]}]}
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
         * basic : {"client_id":1,"name":"测试人员","sex":1,"tel":"15082245107","card_type":1,"card_id":"111111","province":"510000","city":"510100","district":"510124","address":"","birth":"0000-00-00","province_name":"四川省","city_name":"成都市","district_name":"郫县"}
         * need_info : [{"need_id":1,"client_id":1,"agent_id":22,"need_tags":"104,105","property_type":60,"total_price":95,"area":100,"house_type":"34","orientation":0,"floor_min":0,"floor_max":0,"ladder_ratio":"0","decorate":0,"buy_purpose":45,"pay_type":0,"intent":0,"urgency":0,"comment":"213","create_time":"0000-00-00 00:00:00","update_time":"2018-07-03 19:18:20","state":1,"region":[{"province":"310000","province_name":"上海市","city":"310100","city_name":"市辖区","district":"310106","district_name":"静安区"}]}]
         */

        private BasicBean basic;
        private List<NeedInfoBean> need_info;

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public List<NeedInfoBean> getNeed_info() {
            return need_info;
        }

        public void setNeed_info(List<NeedInfoBean> need_info) {
            this.need_info = need_info;
        }

        public static class BasicBean implements Serializable{
            /**
             * client_id : 1
             * name : 测试人员
             * sex : 1
             * tel : 15082245107
             * card_type : 1
             * card_id : 111111
             * province : 510000
             * city : 510100
             * district : 510124
             * address :
             * birth : 0000-00-00
             * province_name : 四川省
             * city_name : 成都市
             * district_name : 郫县
             */

            private int client_id;
            private String name;
            private int sex;
            private String tel;
            private int card_type;
            private String card_id;
            private String province;
            private String city;
            private String district;
            private String address;
            private String birth;
            private String province_name;
            private String city_name;
            private String district_name;

            public int getClient_id() {
                return client_id;
            }

            public void setClient_id(int client_id) {
                this.client_id = client_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public int getCard_type() {
                return card_type;
            }

            public void setCard_type(int card_type) {
                this.card_type = card_type;
            }

            public String getCard_id() {
                return card_id;
            }

            public void setCard_id(String card_id) {
                this.card_id = card_id;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getBirth() {
                return birth;
            }

            public void setBirth(String birth) {
                this.birth = birth;
            }

            public String getProvince_name() {
                return province_name;
            }

            public void setProvince_name(String province_name) {
                this.province_name = province_name;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public String getDistrict_name() {
                return district_name;
            }

            public void setDistrict_name(String district_name) {
                this.district_name = district_name;
            }
        }

        public static class NeedInfoBean implements Serializable{
            /**
             * need_id : 1
             * client_id : 1
             * agent_id : 22
             * need_tags : 104,105
             * property_type : 60
             * total_price : 95
             * area : 100
             * house_type : 34
             * orientation : 0
             * floor_min : 0
             * floor_max : 0
             * ladder_ratio : 0
             * decorate : 0
             * buy_purpose : 45
             * pay_type : 0
             * intent : 0
             * urgency : 0
             * comment : 213
             * create_time : 0000-00-00 00:00:00
             * update_time : 2018-07-03 19:18:20
             * state : 1
             * region : [{"province":"310000","province_name":"上海市","city":"310100","city_name":"市辖区","district":"310106","district_name":"静安区"}]
             */

            private int need_id;
            private int client_id;
            private int agent_id;
            private String need_tags;
            private int property_type;
            private int total_price;
            private int area;
            private String house_type;
            private int orientation;
            private int floor_min;
            private int floor_max;
            private String ladder_ratio;
            private int decorate;
            private int buy_purpose;
            private int pay_type;
            private int intent;
            private int urgency;
            private String comment;
            private String create_time;
            private String update_time;
            private int state;
            private List<RegionBean> region;

            public int getNeed_id() {
                return need_id;
            }

            public void setNeed_id(int need_id) {
                this.need_id = need_id;
            }

            public int getClient_id() {
                return client_id;
            }

            public void setClient_id(int client_id) {
                this.client_id = client_id;
            }

            public int getAgent_id() {
                return agent_id;
            }

            public void setAgent_id(int agent_id) {
                this.agent_id = agent_id;
            }

            public String getNeed_tags() {
                return need_tags;
            }

            public void setNeed_tags(String need_tags) {
                this.need_tags = need_tags;
            }

            public int getProperty_type() {
                return property_type;
            }

            public void setProperty_type(int property_type) {
                this.property_type = property_type;
            }

            public int getTotal_price() {
                return total_price;
            }

            public void setTotal_price(int total_price) {
                this.total_price = total_price;
            }

            public int getArea() {
                return area;
            }

            public void setArea(int area) {
                this.area = area;
            }

            public String getHouse_type() {
                return house_type;
            }

            public void setHouse_type(String house_type) {
                this.house_type = house_type;
            }

            public int getOrientation() {
                return orientation;
            }

            public void setOrientation(int orientation) {
                this.orientation = orientation;
            }

            public int getFloor_min() {
                return floor_min;
            }

            public void setFloor_min(int floor_min) {
                this.floor_min = floor_min;
            }

            public int getFloor_max() {
                return floor_max;
            }

            public void setFloor_max(int floor_max) {
                this.floor_max = floor_max;
            }

            public String getLadder_ratio() {
                return ladder_ratio;
            }

            public void setLadder_ratio(String ladder_ratio) {
                this.ladder_ratio = ladder_ratio;
            }

            public int getDecorate() {
                return decorate;
            }

            public void setDecorate(int decorate) {
                this.decorate = decorate;
            }

            public int getBuy_purpose() {
                return buy_purpose;
            }

            public void setBuy_purpose(int buy_purpose) {
                this.buy_purpose = buy_purpose;
            }

            public int getPay_type() {
                return pay_type;
            }

            public void setPay_type(int pay_type) {
                this.pay_type = pay_type;
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

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
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

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public List<RegionBean> getRegion() {
                return region;
            }

            public void setRegion(List<RegionBean> region) {
                this.region = region;
            }

            public static class RegionBean implements Serializable{
                /**
                 * province : 310000
                 * province_name : 上海市
                 * city : 310100
                 * city_name : 市辖区
                 * district : 310106
                 * district_name : 静安区
                 */

                private String province;
                private String province_name;
                private String city;
                private String city_name;
                private String district;
                private String district_name;

                public String getProvince() {
                    return province;
                }

                public void setProvince(String province) {
                    this.province = province;
                }

                public String getProvince_name() {
                    return province_name;
                }

                public void setProvince_name(String province_name) {
                    this.province_name = province_name;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getCity_name() {
                    return city_name;
                }

                public void setCity_name(String city_name) {
                    this.city_name = city_name;
                }

                public String getDistrict() {
                    return district;
                }

                public void setDistrict(String district) {
                    this.district = district;
                }

                public String getDistrict_name() {
                    return district_name;
                }

                public void setDistrict_name(String district_name) {
                    this.district_name = district_name;
                }
            }
        }
    }
}
