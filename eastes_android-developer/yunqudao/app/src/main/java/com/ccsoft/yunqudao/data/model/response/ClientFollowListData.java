package com.ccsoft.yunqudao.data.model.response;

import com.ccsoft.yunqudao.data.base.BaseData;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/26 0026
 */

public class ClientFollowListData extends BaseData {

    public int                    current_page;
    public String                 first_page_url;
    public int                    from;
    public int                    last_page;
    public String                 last_page_url;
    public String                 next_page_url;
    public String                 path;
    public int                    per_page;
    public String                 prev_page_url;
    public int                    to;
    public int                    total;
    public List<ClientFollowData> data;

    @Override
    public String toString() {
        return "ClientFollowListData{" + "current_page=" + current_page + ", first_page_url='" + first_page_url + '\'' + ", from=" + from + ", last_page=" + last_page + ", last_page_url='" + last_page_url + '\'' + ", next_page_url='" + next_page_url + '\'' + ", path='" + path + '\'' + ", per_page=" + per_page + ", prev_page_url='" + prev_page_url + '\'' + ", to=" + to + ", total=" + total + ", data=" + data + '}';
    }

    public class ClientFollowData {

        /**
         * "follow_id": 70,
         * "agent_id": 18,
         * "name": "黄怡",
         * "follow_type": 89,
         * "follow_time": "2018-05-27",
         * "intent": 47,
         * "urgency": 47,
         * "comment": "看房吃饭，扯淡",
         * "create_time": "2018-05-26 16:35:18",
         * "next_follow_time": "2018-05-28"
         */
        public int follow_id;
        public int agent_id;
        public int follow_type;
        public int intent;
        public int urgency;

        public String name;
        public String comment;
        public String follow_time;
        public String create_time;
        public String next_follow_time;

        @Override
        public String toString() {
            return "ClientFollowData{" + "follow_id=" + follow_id + ", agent_id=" + agent_id + ", follow_type=" + follow_type + ", intent=" + intent + ", urgency=" + urgency + ", name='" + name + '\'' + ", comment='" + comment + '\'' + ", follow_time='" + follow_time + '\'' + ", create_time='" + create_time + '\'' + ", next_follow_time='" + next_follow_time + '\'' + '}';
        }
    }
}
