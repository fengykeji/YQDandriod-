package com.ccsoft.yunqudao.ui.mian;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ccsoft.yunqudao.bean.LoginBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.model.response.LoginData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.home.HomeActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.InputUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.SpUtil;
import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.lzy.okhttputils.cookie.store.PersistentCookieStore;
import com.lzy.okhttputils.model.HttpHeaders;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/8 0008
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mMe_edittext_account;
    private EditText mMe_edittext_password;
    private Button mMe_button_login;
    private Button mMe_button_register;
    private Button mMe_button_repassword;
    private ImageButton mMe_button_QQ;
    private ImageButton mMe_button_wechat;
    private LoginData loginData;
    private long firstTime = 0;//记录用户首次点击返回键的时间

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_log_in);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         * 初始化id
         */

        mMe_edittext_account = findViewById(R.id.me_edittext_account);
        mMe_edittext_password = findViewById(R.id.me_edittext_password);
        mMe_button_login = findViewById(R.id.me_button_login);
        mMe_button_register = findViewById(R.id.me_button_register);
        mMe_button_repassword = findViewById(R.id.me_button_repassword);
        mMe_button_QQ = findViewById(R.id.me_button_QQ);
        mMe_button_wechat = findViewById(R.id.me_button_wechat);
    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        mMe_button_login.setOnClickListener(this);
        mMe_button_register.setOnClickListener(this);
        mMe_button_repassword.setOnClickListener(this);
        mMe_button_QQ.setOnClickListener(this);
        mMe_button_wechat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.me_button_login:
                String account = mMe_edittext_account.getText().toString();
                String password = mMe_edittext_password.getText().toString();
                if (isNext(account, password)) {
                    login(account, password);
                }
                break;
            case R.id.me_button_register:
                RegisterActivity.start(this);
                break;
            case R.id.me_button_repassword:
                ForgetResetPassWordActivity.start(this);
            case R.id.me_button_QQ:
                Toast.makeText(this, "你点击了QQ登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.me_button_wechat:
                Toast.makeText(this, "你点击了微信登录", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 判断输入内容是否可以下一步
     *
     * @param account
     * @param password
     * @return
     */
    private Boolean isNext(String account, String password) {
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_LONG).show();
            return false;
        }
//        if (!InputUtil.isMobileLegal(account)) {
//            Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
//            return false;
//        }
        if(TextUtils.isEmpty(account)){
            Toast.makeText(this, "请输账号", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.length() < 6) {
            Toast.makeText(this, "密码长度不能小于6位", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * 登录
     *
     * @param account
     * @param password
     */
    private void login(String account, String password) {

        OkHttpUtils.post(HttpAdress.login)
                .tag(this)
                .params("account", account)
                .params("password", password)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        LoginBean loginBean = JsonUtil.jsonToEntity(s, LoginBean.class);
                        if (loginBean.getCode() == 200) {
                            SpUtil.setToken(loginBean.getData().getToken());
                            SpUtil.setInt("agent_id", loginBean.getData().getAgent_id());//保存agent_id
                            SpUtil.setString("agent_identity",loginBean.getData().getAgent_identity());//保存判断是否为经纪人

                            HttpHeaders headers = new HttpHeaders();
                            headers.put("ACCESS-TOKEN", loginBean.getData().getToken());
                            headers.put("ACCESS-ROLE", "agent");
                            OkHttpUtils.getInstance().addCommonHeaders(headers);

                            HomeActivity.start(LoginActivity.this);
                            finish();
                        }
                        Toast.makeText(LoginActivity.this, loginBean.getMsg(), Toast.LENGTH_SHORT).show();

                    }
                });

//        ClientManager.getInstance().login(account, password).compose(RxSchedulers.<LoginData>io_main()).subscribe(new ApiSubscriber<LoginData>(this) {
//            @Override
//            protected void _onNext(LoginData loginData) {
//                SpUtil.setToken(loginData.token);
//                SpUtil.setInt("agent_id",loginData.agent_id);//保存agent_id
//
//                HttpHeaders headers = new HttpHeaders();
//                headers.put("ACCESS-TOKEN", loginData.token);
//                headers.put("ACCESS-ROLE","agent");
//                OkHttpUtils.getInstance().addCommonHeaders(headers);
//
//                HomeActivity.start(LoginActivity.this);
//                finish();
//            }
//
//            @Override
//            protected void _onError(String message) {
//                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            protected void _onCompleted() {
//
//            }
//        });
    }

    /**
     * 双击返回键退出
     */
    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
            Toast.makeText(LoginActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            firstTime = secondTime;
        } else {
            ActivityManager.getInstance().AppExit();

        }

    }
}
