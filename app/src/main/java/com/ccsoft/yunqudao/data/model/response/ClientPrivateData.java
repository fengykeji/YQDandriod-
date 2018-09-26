package com.ccsoft.yunqudao.data.model.response;

import com.ccsoft.yunqudao.data.base.BaseData;
import java.io.Serializable;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/24 0024
 */

public class ClientPrivateData extends BaseData implements Serializable {

    public BasicBean          basic;
    public List<NeedInfoBean> need_info;

    public class BasicBean extends BaseData {
        public int    client_id;
        public String name;
        public int    sex;
        public String tel;
        public int    card_type;
        public String card_id;
        public String province;
        public String city;
        public String district;
        public String address;
        public String birth;

        @Override
        public String toString() {
            return "BasicBean{" + "client_id=" + client_id + ", name='" + name + '\'' + ", sex=" + sex + ", tel='" + tel + '\'' + ", card_type=" + card_type + ", card_id='" + card_id + '\'' + ", province='" + province + '\'' + ", city='" + city + '\'' + ", district='" + district + '\'' + ", address='" + address + '\'' + ", birth='" + birth + '\'' + '}';
        }
    }

    public class NeedInfoBean extends BaseData {
        public int    need_id;
        public int    client_id;
        public int    agent_id;
        public String need_tags;
        public String region;
        public int    property_type;
        public int    total_price;
        public int    area;
        public String house_type;
        public int    orientation;
        public int    floor_min;
        public int    floor_max;
        public String    ladder_ratio;
        public int    decorate;
        public int    buy_purpose;
        public int    pay_type;
        public int    intent;
        public int    urgency;
        //public Object comment;
        public String create_time;
        public String update_time;
        public int    state;

        public class Region extends BaseData {
            public String province;//省识别码
            public String city;//市识别码
            public String district;//区识别码
            public String province_name;//省
            public String city_name;//市
            public String district_name;//区
        }


    }

    @Override
    public String toString() {
        return "ClientPrivateData{" + "basic=" + basic + ", need_info=" + need_info + '}';
    }
}
