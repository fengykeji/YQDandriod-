package com.ccsoft.yunqudao.data.model.response;

import com.ccsoft.yunqudao.data.base.BaseData;

/**
 * @author: Pein
 * @data: 2018/5/15 0015
 */

public class LoginData extends BaseData {
    /**
     * token
     */
    public String token;
    /**
     * 用户id
     */
    public int    agent_id;
    /**
     * 代理身份
     */
    public int    agent_identity;
    /**
     * 当前访问时间戳
     */
    public int    time;
}

