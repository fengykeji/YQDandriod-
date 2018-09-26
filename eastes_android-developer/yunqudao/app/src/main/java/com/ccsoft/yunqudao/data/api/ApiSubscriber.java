package com.ccsoft.yunqudao.data.api;

import android.content.Context;
import com.ccsoft.yunqudao.data.RefreshTokenData;
import com.ccsoft.yunqudao.data.base.BaseData;
import com.ccsoft.yunqudao.utils.LogUtil;
import com.ccsoft.yunqudao.utils.NetworkUtil;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Api订阅者
 *
 * @author YangFan
 * @date 2017-1-16
 */
public abstract class ApiSubscriber<T> extends Subscriber<T> {
    public static final String TAG_GET_ONLINE_LIST    = "get_online_list";
    public static final String TAG_POST_REFRESH_TOKEN = "post_refresh_token";

    private Context mContext;
    private String  mTag;

    public ApiSubscriber(Context context) {
        this.mContext = context;
    }

    public ApiSubscriber(Context context, String tag) {
        this.mContext = context;
        mTag = tag;
    }

    @Override
    public void onError(Throwable e) {
        LogUtil.i("API", "" + e.getMessage());
        if (!NetworkUtil.isNetAvailable(this.mContext)) {
            String msg = "网络连接失败，请检查您的网络设置";
            this._onError(msg);
        }
        else if (e instanceof SocketTimeoutException) {
            SocketTimeoutException socketTimeoutException = (SocketTimeoutException) e;
            String msg = "请求超时，请检查您的网络连接状态";
            this._onError(msg);
        }
        else if (e instanceof ConnectException) {
            ConnectException connectException = (ConnectException) e;
            String msg = "服务器异常，请稍后再试";
            this._onError(msg);
        }
        else if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            String msg = "服务器异常，请稍后再试";
            this._onError(msg);
        }
        else if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
            int errorCode = apiException.getErrorCode();
            BaseData data = apiException.getData();
            LogUtil.e("接口返回的错误信息：" + apiException.getErrorMessage() + "：" + errorCode + " tag=" + mTag);
            if (errorCode == ResponseState.ParametersOfTheAbnormal.state) {
                this._onError(apiException.getErrorMessage());
            }
            else {
                this._onError(apiException.getErrorMessage());
            }
        }
        else {
            this._onError(e.getMessage());
        }
    }

    @Override
    public void onNext(T t) {
        this._onNext(t);
    }

    @Override
    public void onCompleted() {
        this._onCompleted();
    }

    protected abstract void _onNext(T t);

    protected void _onErrorValidToken(BaseData data) {}

    protected abstract void _onError(String message);

    protected abstract void _onCompleted();
}
