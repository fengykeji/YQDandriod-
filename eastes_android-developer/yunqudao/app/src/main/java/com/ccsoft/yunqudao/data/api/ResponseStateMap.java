package com.ccsoft.yunqudao.data.api;

import android.util.SparseArray;

/**
 * Desc:
 * Author: WangGuoku.
 * Date:2018/5/5 23:29
 */
public class ResponseStateMap {
    //注意:不能颠倒此句和static语句的顺序
    public static final SparseArray<String> responseStateArray = new SparseArray<>();

    static {
        for (ResponseState state : ResponseState.values()) {
            responseStateArray.put(state.state, state.message);
        }
    }

    public static String getErrorMessage(int code) {
        return responseStateArray.get(code);  //如果code不存在，会返回null
    }
}
