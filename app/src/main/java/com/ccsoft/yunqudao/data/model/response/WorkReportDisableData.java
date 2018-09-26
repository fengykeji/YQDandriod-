package com.ccsoft.yunqudao.data.model.response;

import com.ccsoft.yunqudao.data.base.BaseData;
import java.util.List;

/**
 * author lzx
 * Created on 2018/5/28.
 */

public class WorkReportDisableData extends BaseData {

    /**
     * current_page : 1
     * data : [{"client_id":355,"name":"膜法师","project_name":"链家全民公馆","tel":"15400000002","allot_time":"2018-05-25 11:11:11","state_change_time":"2018-05-27 23:22:35","disabled_state":"自然失效"}]
     * first_page_url : http://120.27.21.136:2798/agent/work/project/disabled?page=1
     * from : 1
     * last_page : 1
     * last_page_url : http://120.27.21.136:2798/agent/work/project/disabled?page=1
     * next_page_url : null
     * path : http://120.27.21.136:2798/agent/work/project/disabled
     * per_page : 15
     * prev_page_url : null
     * to : 1
     * total : 1
     */

    public int current_page;
    public String         first_page_url;
    public int            from;
    public int            last_page;
    public String         last_page_url;
    public Object         next_page_url;
    public String         path;
    public int            per_page;
    public String         prev_page_url;
    public int            to;
    public int            total;
    public List<DataBean> data;

    @Override
    public String toString() {
        return "WorkReportDisableData{" + "current_page=" + current_page + ", first_page_url='" + first_page_url + '\'' + ", from=" + from + ", last_page=" + last_page + ", last_page_url='" + last_page_url + '\'' + ", next_page_url=" + next_page_url + ", path='" + path + '\'' + ", per_page=" + per_page + ", prev_page_url='" + prev_page_url + '\'' + ", to=" + to + ", total=" + total + ", data=" + data + '}';
    }

    public static class DataBean {

        public int client_id;
        public String name;
        public String project_name;
        public String tel;
        public String allot_time;
        public String state_change_time;
        public String disabled_state;

        @Override
        public String toString() {
            return "DataBean{" + "client_id=" + client_id + ", name='" + name + '\'' + ", project_name='" + project_name + '\'' + ", tel='" + tel + '\'' + ", allot_time='" + allot_time + '\'' + ", state_change_time='" + state_change_time + '\'' + ", disabled_state='" + disabled_state + '\'' + '}';
        }
    }
}
