package com.ccsoft.yunqudao.http;

import com.lzy.okhttputils.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by lixinke on 2018/6/9.
 */

public abstract class MyStringCallBack extends StringCallback {

    @Override
    public void onSuccess(String s, Call call, Response response) {

    }
}
