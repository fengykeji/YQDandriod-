package com.ccsoft.yunqudao.data.model.response;

import com.ccsoft.yunqudao.data.base.BaseData;
import java.util.List;

/**
 * desc   : 推荐-确认中列表
 * author : YangFan
 * date   : 2018/5/27 17:41
 * email  : 928902646@qq.com
 */
public class BrokerWaitConfirmData extends BaseData {

    public int    current_page;
    public int    from;
    public int    last_page;
    public int    per_page;
    public int    to;
    public int    total;
    public String first_page_url;
    public String last_page_url;
    public String next_page_url;
    public String prev_page_url;
    public String path;
    public List<WaitConfirmData> data;

    @Override
    public String toString() {
        return "BrokerWaitConfirmData{" + "current_page=" + current_page + ", from=" + from + ", last_page=" + last_page + ", per_page=" + per_page + ", to=" + to + ", total=" + total + ", first_page_url='" + first_page_url + '\'' + ", last_page_url='" + last_page_url + '\'' + ", next_page_url='" + next_page_url + '\'' + ", prev_page_url='" + prev_page_url + '\'' + ", path='" + path + '\'' + '}';
    }

    public class WaitConfirmData extends BaseData {

        /**
         * client_id : 381
         * name : 杨二jjj
         * broker_id : 18
         * tel : 18180775035
         * project_id : 3
         * yunsuan_url : 47.106.39.169:2798
         * yunsuan_id : 13
         * create_time : 2018-05-26 21:34:29
         * visit_confirm_time : 100
         * project_name : 大唐公馆
         * province : 510000
         * city : 510100
         * district : 510124
         * absolute_address : 月球
         * province_name : 四川省
         * city_name : 成都市
         * district_name : 郫县
         * timsLimit : 2018-05-26 23:14:29
         */

        public int client_id;
        public String name;
        public int    broker_id;
        public String tel;
        public int    project_id;
        public String yunsuan_url;
        public int    yunsuan_id;
        public String create_time;
        public int    visit_confirm_time;
        public String project_name;
        public String province;
        public String city;
        public String district;
        public String absolute_address;
        public String province_name;
        public String city_name;
        public String district_name;
        public String timsLimit;

    }
}
