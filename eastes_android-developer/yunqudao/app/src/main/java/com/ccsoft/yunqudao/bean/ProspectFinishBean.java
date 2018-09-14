package com.ccsoft.yunqudao.bean;

import java.io.Serializable;
import java.util.List;

public class ProspectFinishBean  {


    /**
     * code : 200
     * msg : 查询成功
     * data : {"house":{"house_code":"","house_id":5,"project_name":"翡翠滨江","title":"测试标题","price":45456,"minimum":1,"pay_way":"","property_limit":0,"property_belong":"共有","is_mortgage":"不抵押","check_way":"","intent":32,"urgency":12,"build_area":100,"decoration":0,"follow_num":0,"house":"1栋-一单元-1702","suggest_price":455,"unit_price":455,"unit_minimum":1},"detail":{"permit_code":"","permit_time":"0000-00-00","absolute_address":"四川省绵阳市三台县涪滨路","property_type":"","house_type":"","build_area":100,"floor_num":0,"decoration":"","progress":[{"name":"报备","time":"2018-08-16 18:15:27"},{"name":"接单","time":"2018-08-06 09:33:20"},{"name":"完成勘察","time":"0000-00-00 00:00:00"}],"house":"1栋-一单元-1702"},"info":{"img_list":[],"decoration_standard":"good","core_selling":"good","house_tags":[{"tag_id":"165","tag_name":"房东人很好"},{"tag_id":"166","tag_name":"高性价比"}]},"contact":[{"contact_id":3,"name":"胡志强","tel":["15983804766","15082245107"],"sex":1,"report_type":"其他","address":"","card_type":0,"card_id":"","card_type_name":""}],"follow":[{"follow_id":1,"follow_type":"微信","follow_time":"0000-00-00","comment":"2213"}]}
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
         * house : {"house_code":"","house_id":5,"project_name":"翡翠滨江","title":"测试标题","price":45456,"minimum":1,"pay_way":"","property_limit":0,"property_belong":"共有","is_mortgage":"不抵押","check_way":"","intent":32,"urgency":12,"build_area":100,"decoration":0,"follow_num":0,"house":"1栋-一单元-1702","suggest_price":455,"unit_price":455,"unit_minimum":1}
         * detail : {"permit_code":"","permit_time":"0000-00-00","absolute_address":"四川省绵阳市三台县涪滨路","property_type":"","house_type":"","build_area":100,"floor_num":0,"decoration":"","progress":[{"name":"报备","time":"2018-08-16 18:15:27"},{"name":"接单","time":"2018-08-06 09:33:20"},{"name":"完成勘察","time":"0000-00-00 00:00:00"}],"house":"1栋-一单元-1702"}
         * info : {"img_list":[],"decoration_standard":"good","core_selling":"good","house_tags":[{"tag_id":"165","tag_name":"房东人很好"},{"tag_id":"166","tag_name":"高性价比"}]}
         * contact : [{"contact_id":3,"name":"胡志强","tel":["15983804766","15082245107"],"sex":1,"report_type":"其他","address":"","card_type":0,"card_id":"","card_type_name":""}]
         * follow : [{"follow_id":1,"follow_type":"微信","follow_time":"0000-00-00","comment":"2213"}]
         */

        private HouseBean house;
        private DetailBean detail;
        private InfoBean info;
        private List<ContactBean> contact;
        private List<FollowBean> follow;

        public HouseBean getHouse() {
            return house;
        }

        public void setHouse(HouseBean house) {
            this.house = house;
        }

        public DetailBean getDetail() {
            return detail;
        }

        public void setDetail(DetailBean detail) {
            this.detail = detail;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public List<ContactBean> getContact() {
            return contact;
        }

        public void setContact(List<ContactBean> contact) {
            this.contact = contact;
        }

        public List<FollowBean> getFollow() {
            return follow;
        }

        public void setFollow(List<FollowBean> follow) {
            this.follow = follow;
        }

        public static class HouseBean {
            /**
             * house_code :
             * house_id : 5
             * project_name : 翡翠滨江
             * title : 测试标题
             * price : 45456
             * minimum : 1
             * pay_way :
             * property_limit : 0
             * property_belong : 共有
             * is_mortgage : 不抵押
             * check_way :
             * intent : 32
             * urgency : 12
             * build_area : 100
             * decoration : 0
             * follow_num : 0
             * house : 1栋-一单元-1702
             * suggest_price : 455
             * unit_price : 455
             * unit_minimum : 1
             */

            private String house_code;
            private int house_id;
            private String project_name;
            private String title;
            private int price;
            private int minimum;
            private String pay_way;
            private int property_limit;
            private String property_belong;
            private String is_mortgage;
            private String check_way;
            private int intent;
            private int urgency;
            private int build_area;
            private int decoration;
            private int follow_num;
            private String house;
            private int suggest_price;
            private int unit_price;
            private int unit_minimum;

            public String getHouse_code() {
                return house_code;
            }

            public void setHouse_code(String house_code) {
                this.house_code = house_code;
            }

            public int getHouse_id() {
                return house_id;
            }

            public void setHouse_id(int house_id) {
                this.house_id = house_id;
            }

            public String getProject_name() {
                return project_name;
            }

            public void setProject_name(String project_name) {
                this.project_name = project_name;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getMinimum() {
                return minimum;
            }

            public void setMinimum(int minimum) {
                this.minimum = minimum;
            }

            public String getPay_way() {
                return pay_way;
            }

            public void setPay_way(String pay_way) {
                this.pay_way = pay_way;
            }

            public int getProperty_limit() {
                return property_limit;
            }

            public void setProperty_limit(int property_limit) {
                this.property_limit = property_limit;
            }

            public String getProperty_belong() {
                return property_belong;
            }

            public void setProperty_belong(String property_belong) {
                this.property_belong = property_belong;
            }

            public String getIs_mortgage() {
                return is_mortgage;
            }

            public void setIs_mortgage(String is_mortgage) {
                this.is_mortgage = is_mortgage;
            }

            public String getCheck_way() {
                return check_way;
            }

            public void setCheck_way(String check_way) {
                this.check_way = check_way;
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

            public int getBuild_area() {
                return build_area;
            }

            public void setBuild_area(int build_area) {
                this.build_area = build_area;
            }

            public int getDecoration() {
                return decoration;
            }

            public void setDecoration(int decoration) {
                this.decoration = decoration;
            }

            public int getFollow_num() {
                return follow_num;
            }

            public void setFollow_num(int follow_num) {
                this.follow_num = follow_num;
            }

            public String getHouse() {
                return house;
            }

            public void setHouse(String house) {
                this.house = house;
            }

            public int getSuggest_price() {
                return suggest_price;
            }

            public void setSuggest_price(int suggest_price) {
                this.suggest_price = suggest_price;
            }

            public int getUnit_price() {
                return unit_price;
            }

            public void setUnit_price(int unit_price) {
                this.unit_price = unit_price;
            }

            public int getUnit_minimum() {
                return unit_minimum;
            }

            public void setUnit_minimum(int unit_minimum) {
                this.unit_minimum = unit_minimum;
            }
        }

        public static class DetailBean {
            /**
             * permit_code :
             * permit_time : 0000-00-00
             * absolute_address : 四川省绵阳市三台县涪滨路
             * property_type :
             * house_type :
             * build_area : 100
             * floor_num : 0
             * decoration :
             * progress : [{"name":"报备","time":"2018-08-16 18:15:27"},{"name":"接单","time":"2018-08-06 09:33:20"},{"name":"完成勘察","time":"0000-00-00 00:00:00"}]
             * house : 1栋-一单元-1702
             */

            private String permit_code;
            private String permit_time;
            private String absolute_address;
            private String property_type;
            private String house_type;
            private int build_area;
            private int floor_num;
            private String decoration;
            private String house;
            private List<ProgressBean> progress;

            public String getPermit_code() {
                return permit_code;
            }

            public void setPermit_code(String permit_code) {
                this.permit_code = permit_code;
            }

            public String getPermit_time() {
                return permit_time;
            }

            public void setPermit_time(String permit_time) {
                this.permit_time = permit_time;
            }

            public String getAbsolute_address() {
                return absolute_address;
            }

            public void setAbsolute_address(String absolute_address) {
                this.absolute_address = absolute_address;
            }

            public String getProperty_type() {
                return property_type;
            }

            public void setProperty_type(String property_type) {
                this.property_type = property_type;
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

            public int getFloor_num() {
                return floor_num;
            }

            public void setFloor_num(int floor_num) {
                this.floor_num = floor_num;
            }

            public String getDecoration() {
                return decoration;
            }

            public void setDecoration(String decoration) {
                this.decoration = decoration;
            }

            public String getHouse() {
                return house;
            }

            public void setHouse(String house) {
                this.house = house;
            }

            public List<ProgressBean> getProgress() {
                return progress;
            }

            public void setProgress(List<ProgressBean> progress) {
                this.progress = progress;
            }

            public static class ProgressBean {
                /**
                 * name : 报备
                 * time : 2018-08-16 18:15:27
                 */

                private String name;
                private String time;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }
            }
        }

        public static class InfoBean {
            /**
             * img_list : []
             * decoration_standard : good
             * core_selling : good
             * house_tags : [{"tag_id":"165","tag_name":"房东人很好"},{"tag_id":"166","tag_name":"高性价比"}]
             */

            private String decoration_standard;
            private String core_selling;
            private List<?> img_list;
            private List<HouseTagsBean> house_tags;

            public String getDecoration_standard() {
                return decoration_standard;
            }

            public void setDecoration_standard(String decoration_standard) {
                this.decoration_standard = decoration_standard;
            }

            public String getCore_selling() {
                return core_selling;
            }

            public void setCore_selling(String core_selling) {
                this.core_selling = core_selling;
            }

            public List<?> getImg_list() {
                return img_list;
            }

            public void setImg_list(List<?> img_list) {
                this.img_list = img_list;
            }

            public List<HouseTagsBean> getHouse_tags() {
                return house_tags;
            }

            public void setHouse_tags(List<HouseTagsBean> house_tags) {
                this.house_tags = house_tags;
            }

            public static class HouseTagsBean {
                /**
                 * tag_id : 165
                 * tag_name : 房东人很好
                 */

                private String tag_id;
                private String tag_name;

                public String getTag_id() {
                    return tag_id;
                }

                public void setTag_id(String tag_id) {
                    this.tag_id = tag_id;
                }

                public String getTag_name() {
                    return tag_name;
                }

                public void setTag_name(String tag_name) {
                    this.tag_name = tag_name;
                }
            }
        }

        public static class ContactBean implements Serializable {
            /**
             * contact_id : 3
             * name : 胡志强
             * tel : ["15983804766","15082245107"]
             * sex : 1
             * report_type : 其他
             * address :
             * card_type : 0
             * card_id :
             * card_type_name :
             */

            private int contact_id;
            private String name;
            private int sex;
            private String report_type;
            private String address;
            private int card_type;
            private String card_id;
            private String card_type_name;
            private List<String> tel;

            public int getContact_id() {
                return contact_id;
            }

            public void setContact_id(int contact_id) {
                this.contact_id = contact_id;
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

            public String getReport_type() {
                return report_type;
            }

            public void setReport_type(String report_type) {
                this.report_type = report_type;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
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

            public String getCard_type_name() {
                return card_type_name;
            }

            public void setCard_type_name(String card_type_name) {
                this.card_type_name = card_type_name;
            }

            public List<String> getTel() {
                return tel;
            }

            public void setTel(List<String> tel) {
                this.tel = tel;
            }
        }

        public static class FollowBean {
            /**
             * follow_id : 1
             * follow_type : 微信
             * follow_time : 0000-00-00
             * comment : 2213
             */

            private int follow_id;
            private String follow_type;
            private String follow_time;
            private String comment;

            public int getFollow_id() {
                return follow_id;
            }

            public void setFollow_id(int follow_id) {
                this.follow_id = follow_id;
            }

            public String getFollow_type() {
                return follow_type;
            }

            public void setFollow_type(String follow_type) {
                this.follow_type = follow_type;
            }

            public String getFollow_time() {
                return follow_time;
            }

            public void setFollow_time(String follow_time) {
                this.follow_time = follow_time;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }
        }
    }
}
