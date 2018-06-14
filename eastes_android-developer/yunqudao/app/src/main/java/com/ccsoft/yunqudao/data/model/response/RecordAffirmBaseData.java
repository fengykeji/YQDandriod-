package com.ccsoft.yunqudao.data.model.response;

import com.ccsoft.yunqudao.data.base.BaseData;
import java.util.List;

/**
 *
 * 报备确认中Data
 *
 * author lzx
 * Created on 2018/5/27.
 */

public class RecordAffirmBaseData extends BaseData{

    /**
     * current_page : 1
     * data : [{"client_id":371,"name":"墨迹了","project_name":"大唐公馆","tel":"15400000003","create_time":"2018-05-25 16:50:58","timsLimit":"2018-05-29 16:50:58"},{"client_id":348,"name":"不来","project_name":"云算2","tel":"15900000001","create_time":"2018-05-24 19:33:17","timsLimit":"2018-05-27 19:33:17"}]
     * first_page_url : http://120.27.21.136:2798/agent/work/project/waitConfirm?page=1
     * from : 1
     * last_page : 1
     * last_page_url : http://120.27.21.136:2798/agent/work/project/waitConfirm?page=1
     * next_page_url : null
     * path : http://120.27.21.136:2798/agent/work/project/waitConfirm
     * per_page : 15
     * prev_page_url : null
     * to : 2
     * total : 2
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
        return "RecordAffirmBaseData{" + "current_page=" + current_page + ", first_page_url='" + first_page_url + '\'' + ", from=" + from + ", last_page=" + last_page + ", last_page_url='" + last_page_url + '\'' + ", next_page_url=" + next_page_url + ", path='" + path + '\'' + ", per_page=" + per_page + ", prev_page_url='" + prev_page_url + '\'' + ", to=" + to + ", total=" + total + ", data=" + data + '}';
    }

    public static class DataBean {
        /**
         * client_id : 371
         * name : 墨迹了
         * project_name : 大唐公馆
         * tel : 15400000003
         * create_time : 2018-05-25 16:50:58
         * timsLimit : 2018-05-29 16:50:58
         */

        public int client_id;
        public String name;
        public String project_name;
        public String tel;
        public String create_time;
        public String timsLimit;

        @Override
        public String toString() {
            return "DataBean{" + "client_id=" + client_id + ", name='" + name + '\'' + ", project_name='" + project_name + '\'' + ", tel='" + tel + '\'' + ", create_time='" + create_time + '\'' + ", timsLimit='" + timsLimit + '\'' + '}';
        }
    }
}
