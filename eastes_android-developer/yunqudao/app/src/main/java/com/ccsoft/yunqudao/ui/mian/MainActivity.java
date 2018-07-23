package com.ccsoft.yunqudao.ui.mian;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.ccsoft.yunqudao.bean.GetDistrictListBean;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.Guide.GuideActivity;
import com.ccsoft.yunqudao.ui.home.HomeActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.ccsoft.yunqudao.utils.SpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.cookie.store.PersistentCookieStore;
import com.lzy.okhttputils.model.HttpHeaders;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.net.MalformedURLException;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends Activity {

    private static final String TAG = "time";
    private Long startTime;
    private  static PeizhiBean peizhiBean;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        startTime = System.currentTimeMillis();
        setContentView(R.layout.activity_guide);


        HttpHeaders headers = new HttpHeaders();
        headers.put("ACCESS-TOKEN", SpUtil.getToken());
        headers.put("ACCESS-ROLE","agent");
        OkHttpUtils.init(getApplication());
        OkHttpUtils.getInstance()
                .debug("NetTag")
                .setConnectTimeout(10*1000)
                .setReadTimeOut(10*1000)
                .setWriteTimeOut(10*1000)
                .setCookieStore(new PersistentCookieStore())
                .addCommonHeaders(headers);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "time===" + (System.currentTimeMillis() - startTime));
                //是否显示引导页
                boolean isShow;
                //得到Preference存储的isShow数据
                isShow = SpUtil.getBoolean(AppConstants.SP.IS_SHOW_GUIDE, true);
                Log.d("SpUtil==", isShow + "");
                if (isShow) {
                    //true

                    initHome();
                }
                else {
                    //false
                    initView();
                }
            }
        }, 1000);

        savePeizhi();
    }

    //    进入引导页
    private void initView() {

        GuideActivity.start(this);

        finish();
    }

    /**
     * 判断token，为空去login登录，不为空自动登录去home
     */
    private void initHome() {
        if (!TextUtils.isEmpty(SpUtil.getToken())) {
            HomeActivity.start(this);
            finish();
        }
        else {
            LoginActivity.start(this);
            finish();
        }
    }

    /**
     * 配置信息
     */
    public static PeizhiBean savePeizhi(){
        OkHttpManager.getInstance().get(AppConstants.URL + "config", new BaseCallBack() {
            @Override
            public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {
                Type type = new TypeToken<PeizhiBean>() {}.getType();
                peizhiBean= new Gson().fromJson(obj.toString(),type);
            }

            @Override
            public void onFailure(Call call, Exception e) {

            }

            @Override
            public void onError(Response response, int errorCode) {

            }

            @Override
            public void onRequestBefore() {

            }
        });
        return peizhiBean;
    }



}
