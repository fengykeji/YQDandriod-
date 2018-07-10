package com.ccsoft.yunqudao.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class ProjectPiPeiKeHuBean implements Serializable{


    /**
     * code : 200
     * msg : 查询成功
     * data : [{"client_id":335,"need_id":323,"name":"22","intent":0,"urgency":0,"house_type":"","area":null,"price":null,"decorate":null,"need_tags":"","property_type":59,"tel":"13438389494","sex":0,"is_recommend":0,"score":"29.81","region":[{"province":"510000","province_name":"四川省","city":"510700","city_name":"绵阳市","district":"510722","district_name":"三台县"}]},{"client_id":336,"need_id":324,"name":"33","intent":26,"urgency":27,"house_type":"","area":null,"price":null,"decorate":null,"need_tags":"27","property_type":59,"tel":"13438393939","sex":0,"is_recommend":0,"score":"14.90","region":[{"province":"510000","province_name":"四川省","city":"510700","city_name":"绵阳市","district":"510722","district_name":"三台县"}]},{"client_id":337,"need_id":325,"name":"55","intent":31,"urgency":62,"house_type":"32","area":"50","price":"50","decorate":"毛坯","need_tags":"57,56","property_type":59,"tel":"13573737373","sex":1,"is_recommend":0,"score":"4.49","region":[{"province":"510000","province_name":"四川省","city":"510700","city_name":"绵阳市","district":"510722","district_name":"三台县"}]}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * client_id : 335
         * need_id : 323
         * name : 22
         * intent : 0
         * urgency : 0
         * house_type :
         * area : null
         * price : null
         * decorate : null
         * need_tags :
         * property_type : 59
         * tel : 13438389494
         * sex : 0
         * is_recommend : 0
         * score : 29.81
         * region : [{"province":"510000","province_name":"四川省","city":"510700","city_name":"绵阳市","district":"510722","district_name":"三台县"}]
         */

        private int client_id;
        private int need_id;
        private String name;
        private int intent;
        private int urgency;
        private String house_type;
        private Object area;
        private Object price;
        private Object decorate;
        private String need_tags;
        private int property_type;
        private String tel;
        private int sex;
        private int is_recommend;
        private String score;
        private List<RegionBean> region;

        public int getClient_id() {
            return client_id;
        }

        public void setClient_id(int client_id) {
            this.client_id = client_id;
        }

        public int getNeed_id() {
            return need_id;
        }

        public void setNeed_id(int need_id) {
            this.need_id = need_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public String getHouse_type() {
            return house_type;
        }

        public void setHouse_type(String house_type) {
            this.house_type = house_type;
        }

        public Object getArea() {
            return area;
        }

        public void setArea(Object area) {
            this.area = area;
        }

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        public Object getDecorate() {
            return decorate;
        }

        public void setDecorate(Object decorate) {
            this.decorate = decorate;
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

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getIs_recommend() {
            return is_recommend;
        }

        public void setIs_recommend(int is_recommend) {
            this.is_recommend = is_recommend;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public List<RegionBean> getRegion() {
            return region;
        }

        public void setRegion(List<RegionBean> region) {
            this.region = region;
        }

        public static class RegionBean implements Serializable{
            /**
             * province : 510000
             * province_name : 四川省
             * city : 510700
             * city_name : 绵阳市
             * district : 510722
             * district_name : 三台县
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
