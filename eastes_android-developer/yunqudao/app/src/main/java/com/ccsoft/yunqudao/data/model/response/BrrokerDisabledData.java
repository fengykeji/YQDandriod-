package com.ccsoft.yunqudao.data.model.response;

import com.ccsoft.yunqudao.data.base.BaseData;
import java.util.List;

/**
 * desc   :
 * author : YangFan
 * date   : 2018/5/27 20:38
 * email  : 928902646@qq.com
 */
public class BrrokerDisabledData extends BaseData {


    public int                current_page;
    public String             first_page_url;
    public int                from;
    public int                last_page;
    public String             last_page_url;
    public String             next_page_url;
    public String             path;
    public int                per_page;
    public String             prev_page_url;
    public int                to;
    public int                total;
    public List<DisabledData> data;

    public class DisabledData extends BaseData {
        /**
         * client_id : 381
         * name : 杨二jjj
         * broker_id : 18
         * tel : 18180775035
         * create_time : 2018-05-26 21:34:29
         * current_state : 推荐
         * state_change_time : 2018-05-27 18:06:20
         * project_name : 大唐公馆
         * visit_time : null
         * property_advicer_wish :
         */

        public int    client_id;
        public String name;
        public int    broker_id;
        public String tel;
        public String create_time;
        public String current_state;
        public String state_change_time;
        public String project_name;
        public Object visit_time;
        public String property_advicer_wish;
    }
}
