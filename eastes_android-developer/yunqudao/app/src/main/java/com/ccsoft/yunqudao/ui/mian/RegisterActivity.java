package com.ccsoft.yunqudao.ui.mian;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.base.BaseData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.me.PactActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LogUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/8 0008
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mMe_button_返回;
    private EditText    mMe_edittext_手机号码;
    private EditText    mMe_edittext_邀请号码;
    private EditText    mMe_edittext_验证码;
    private Button      mMe_button_获取验证码;
    private EditText    mMe_edittext_密码;
    private EditText    mMe_edittext_再次输入密码;
    private CheckBox    mMe_checkbox_条例;
    private Button      mMe_button_平台条例;
    private Button      mMe_button_注册;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_sign_in);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }

    private void initView() {

        /**
         * 初始化id
         */
        mMe_button_返回 = findViewById(R.id.me_button_返回);
        mMe_edittext_手机号码 = findViewById(R.id.me_edittext_手机号码);
        mMe_edittext_验证码 = findViewById(R.id.me_edittext_验证码);
        mMe_button_获取验证码 = findViewById(R.id.me_button_获取验证码);
        mMe_edittext_密码 = findViewById(R.id.me_edittext_密码);
        mMe_edittext_再次输入密码 = findViewById(R.id.me_edittext_再次输入密码);
//        mMe_checkbox_条例 = findViewById(R.id.me_checkbox_条例);
//        mMe_button_平台条例 = findViewById(R.id.me_button_平台条例);
        mMe_button_注册 = findViewById(R.id.me_button_注册);
        mMe_edittext_邀请号码 = findViewById(R.id.me_edittext_邀请号码);
    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        mMe_button_返回.setOnClickListener(this);
        mMe_button_获取验证码.setOnClickListener(this);
//        mMe_checkbox_条例.setOnClickListener(this);
//        mMe_button_平台条例.setOnClickListener(this);
        mMe_button_注册.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.me_button_返回:
                finish();
                break;
            case R.id.me_button_获取验证码:
                sendVerification(mMe_edittext_手机号码.getText().toString());
                break;
//            case R.id.me_button_平台条例:
//                PactActivity.start(this);
//                break;
            case R.id.me_button_注册:
                String account = mMe_edittext_手机号码.getText().toString();
                String captcha = mMe_edittext_验证码.getText().toString();
                String password = mMe_edittext_密码.getText().toString();
                String againpassword = mMe_edittext_再次输入密码.getText().toString();
//                String consultant_tel = mMe_edittext_邀请号码.getText().toString();

                if (TextUtils.isEmpty(account)) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isMoble(account)) {
                    Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(captcha)) {
                    Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (captcha.length() < 4) {
                    Toast.makeText(this, "验证码长度为4位数字", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(this, "密码长度不能小于6位", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(againpassword)) {
                    Toast.makeText(this, "再次输入密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!againpassword.equals(password)) {
                    Toast.makeText(this, "请再次输入正确的密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (againpassword.length() < 6) {
                    Toast.makeText(this, "密码长度不能小于6位", Toast.LENGTH_SHORT).show();
                    return;
                }
//                if (!mMe_checkbox_条例.isChecked()) {
//                    Toast.makeText(this, "同意云算平台使用条例", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if (!isMoble(consultant_tel)) {
//                    Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
//                    return;
//                }

                register(account, password, againpassword, captcha);

                break;
        }
    }

    /**
     * 获取验证码
     */
    private void sendVerification(String account) {

//        ClientManager.getInstance().getCaptcha(account).compose(RxSchedulers.<BaseData>io_main()).subscribe(new ApiSubscriber<BaseData>(this) {
//            @Override
//            protected void _onNext(BaseData baseData) {
//                Toast.makeText(RegisterActivity.this, "验证码已发送", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            protected void _onError(String message) {
//                Toast.makeText(RegisterActivity.this, "验证码发送失败:" + message, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            protected void _onCompleted() {
//
//            }
//        });
        OkHttpUtils.get(HttpAdress.captcha)
                .params("tel",account)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        StringModel model = JsonUtil.jsonToEntity(s,StringModel.class);
                        if(model.getCode()==200){
                            handler.post(runnable);
                        }
                        Toast.makeText(RegisterActivity.this,model.getMsg(),Toast.LENGTH_SHORT).show();
                    }
                });

    }

    /**
     * 注册
     *
     * @param account       账号
     * @param password      密码
     * @param againpassword 密码
     * @param captcha       验证码
     */
    private void register(String account, String password, String againpassword, String captcha) {

//        ClientManager.getInstance().regist(account, password, againpassword, captcha).compose(RxSchedulers.<BaseData>io_main()).subscribe(new ApiSubscriber<BaseData>(this) {
//            @Override
//            protected void _onNext(BaseData baseData) {
//                Toast.makeText(RegisterActivity.this, ":注册成功", Toast.LENGTH_SHORT).show();
//                finish();
//            }
//
//            @Override
//            protected void _onError(String message) {
//                Toast.makeText(RegisterActivity.this, "注册失败:" + message, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            protected void _onCompleted() {
//
//            }
//        });
        OkHttpUtils.post(HttpAdress.regiest)
                .tag(this)
                .params("account", account)
                .params("password", password)
                .params("password_verify", againpassword)
                .params("captcha", captcha)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        StringModel model = JsonUtil.jsonToEntity(s,StringModel.class);
                        if(model.getCode()==200){
                            Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_LONG).show();
                            finish();
                        }
                        Log.e("sssa",model.getMsg());
                        Toast.makeText(RegisterActivity.this,model.getMsg(),Toast.LENGTH_SHORT).show();
                    }
                });



    }

    public static boolean isMoble(String telnumber) {

        String number = "^((13[0-9])|(17[0-9])|(14[0-9])|(15[0-9])|(18[0-9]))\\d{8}$";

        return telnumber.matches(number);
    }

    /*
倒计时
*/
    Handler handler = new Handler();
    int alltime = 60;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            alltime--;
            if (alltime < 0) {
                handler.removeCallbacks(runnable);// 关闭定时器处理
                mMe_button_获取验证码.setText("获取验证码");
                mMe_button_获取验证码.setEnabled(true);
                alltime = 60;
            } else {
                mMe_button_获取验证码.setEnabled(false);
                mMe_button_获取验证码.setText(alltime + "秒后重发");
                handler.postDelayed(runnable, 1000);// 打开定时器，执行操作
            }
        }
    };

}
