package com.ccsoft.yunqudao.data.model.response;

import com.ccsoft.yunqudao.data.base.BaseData;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/22 0022
 */

public class ClientListData extends BaseData {

    public int              current_page;
    public String           first_page_url;
    public int              from;
    public int              last_page;
    public String           last_page_url;
    public String           next_page_url;
    public String           path;
    public int              per_page;
    public String           prev_page_url;
    public int              to;
    public int              total;
    public List<ClientData> data;

    public class ClientData extends BaseData {
        public int    client_id;
        public String name;
        public int    sex;
        public String tel;
        public int    property_type;
        public int    total_price;
        public String house_type;
        public int    intent;
        public int    urgency;
        public List<RegionData> region;
    }

    public class RegionData extends BaseData {
        /**
         * "province": "510000",
         * "province_name": "四川省",
         * "city": "510100",
         * "city_name": "成都市",
         * "district": "510116",
         * "district_name": "双流区"
         */
        public String province;
        public String province_name;
        public String city;
        public String city_name;
        public String district;
        public String district_name;
    }
}
