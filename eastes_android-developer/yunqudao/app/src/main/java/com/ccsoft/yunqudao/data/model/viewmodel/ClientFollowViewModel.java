package com.ccsoft.yunqudao.data.model.viewmodel;

import com.ccsoft.yunqudao.data.base.BaseData;

/**
 * @author: Pein
 * @data: 2018/5/26 0026
 */

public class ClientFollowViewModel extends BaseData {

    public int    follow_type;
    public int    intent;
    public int    urgency;
    public String follow_time;
    public String comment;

    @Override
    public String toString() {
        return "ClientFollowViewModel{" + "follow_type=" + follow_type + ", intent=" + intent + ", urgency=" + urgency + ", comment='" + comment + '\'' + ", follow_time=" + follow_time + '}';
    }
}
