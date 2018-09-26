package com.ccsoft.yunqudao.data.api;

import com.ccsoft.yunqudao.data.base.BaseData;
import rx.functions.Func1;

/**
 * 来统一处理Http的ResponseState,并将ResultData的Data部分剥离出来返回给subscriber
 *
 * @author YangFan
 * @date 2017-1-17
 */
public class ApiResultFunc<T extends BaseData> implements Func1<ResultData<T>, T> {

    @Override
    public T call(ResultData<T> resultData) {
        int state = resultData.code;
        if (state != ResponseState.Ok.state) {  // 不是200
            throw new ApiException(resultData.data, state, resultData.msg);
        }
        return resultData.data;
    }
}
