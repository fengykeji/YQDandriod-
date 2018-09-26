package com.ccsoft.yunqudao.data.model.response;

import com.ccsoft.yunqudao.data.base.BaseData;
import java.util.List;

/**
 * author lzx
 * Created on 2018/5/27.
 */

public class RecordValidData extends BaseData {

    public int                                 current_page;
    public   String                              first_page_url;
    public   int                                 from;
    public   int                                 last_page;
    public   String                              last_page_url;
    public   String                              next_page_url;
    public   String                              path;
    public   int                                 per_page;
    public   String                              prev_page_url;
    public   int                                 to;
    public   int                                 total;
    public   List<DataBean> data;

    @Override
    public String toString() {
        return "RecordValidData{" + "current_page=" + current_page + ", first_page_url='" + first_page_url + '\'' + ", from=" + from + ", last_page=" + last_page + ", last_page_url='" + last_page_url + '\'' + ", next_page_url='" + next_page_url + '\'' + ", path='" + path + '\'' + ", per_page=" + per_page + ", prev_page_url='" + prev_page_url + '\'' + ", to=" + to + ", total=" + total + ", data=" + data + '}';
    }

    public static class DataBean {

        public int client_id;
        public String name;
        public String project_name;
        public String tel;
        public String property_advicer_wish;
        public String allot_time;
        public String current_state;

        @Override
        public String toString() {
            return "DataBean{" + "client_id=" + client_id + ", name='" + name + '\'' + ", project_name='" + project_name + '\'' + ", tel='" + tel + '\'' + ", property_advicer_wish='" + property_advicer_wish + '\'' + ", allot_time='" + allot_time + '\'' + ", current_state='" + current_state + '\'' + '}';
        }
    }


}
