package com.ccsoft.yunqudao.data.model.response;

import com.ccsoft.yunqudao.data.base.BaseData;
import java.util.List;

/**
 * desc   :
 * author : YangFan
 * date   : 2018/5/27 20:35
 * email  : 928902646@qq.com
 */
public class BrrokerValueData extends BaseData {

    public int             current_page;
    public String          first_page_url;
    public int             from;
    public int             last_page;
    public String          last_page_url;
    public String          next_page_url;
    public String          path;
    public int             per_page;
    public String          prev_page_url;
    public int             to;
    public int             total;
    public List<ValueData> data;

    public class ValueData extends BaseData {
        /**
         * client_id : 371
         * name : 墨迹了
         * current_state : 到访
         * project_name : 大唐公馆
         * visit_time : 2018-05-25 16:51:00
         */

        public int    client_id;
        public String name;
        public String current_state;
        public String project_name;
        public String visit_time;
    }
}
