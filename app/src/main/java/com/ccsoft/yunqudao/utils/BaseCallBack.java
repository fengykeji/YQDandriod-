package com.ccsoft.yunqudao.utils;



import java.net.MalformedURLException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * www.liankewang.com
 * Created by cdlk04 on 2017/6/6.
 */

public abstract class BaseCallBack {
    public abstract void onSuccess(Call call,Response response,Object obj) throws MalformedURLException;
    public abstract void onFailure(Call call, Exception e);
    public abstract void onError(Response response,int errorCode);
    public abstract void onRequestBefore();
}
