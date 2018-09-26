package com.ccsoft.yunqudao.data.model.response;

import com.ccsoft.yunqudao.data.base.BaseData;
import com.google.gson.internal.bind.DateTypeAdapter;

/**
 * author lzx
 * Created on 2018/5/27.
 */

public class ResultData extends BaseData {

    /**
     * code : 400
     * msg : 您来晚一步，该用户已经被推荐到了项目[链家大唐公馆]
     * data : null
     */

    public int    code;
    public String msg;
    public Date   data;

    @Override
    public String toString() {
        return "ResultData{" + "code=" + code + ", msg='" + msg + '\'' + ", data=" + data + '}';
    }

    public class Date extends BaseData {}
}
