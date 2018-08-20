package com.ccsoft.yunqudao.ui.mian;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.InputUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class ForgetResetPassWordActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mMe_button_返回;
    private Button      mMe_button_获取验证码;
    private Button      mMe_button_确定修改;
    private EditText    mMe_edittext_手机号码;
    private EditText    mMe_edittext_验证码;
    private EditText    mMe_edittext_新密码;
    private EditText    mMe_edittext_再次输入新密码;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_reset_password_wangji);
        HideIMEUtil.wrap(this);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ForgetResetPassWordActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化
     */
    private void initView() {

        mMe_button_返回 = findViewById(R.id.me_button_返回);
        mMe_button_确定修改 = findViewById(R.id.me_button_确定修改);
        mMe_button_获取验证码 = findViewById(R.id.me_button_获取验证码);
        mMe_edittext_手机号码 = findViewById(R.id.me_edittext_手机号码);
        mMe_edittext_验证码 = findViewById(R.id.me_edittext_验证码);
        mMe_edittext_新密码 = findViewById(R.id.me_edittext_新密码);
        mMe_edittext_再次输入新密码 = findViewById(R.id.me_edittext_再次输入新密码);
    }

    /**
     * 初始化
     */
    private void initListener() {

        mMe_button_返回.setOnClickListener(this);
        mMe_button_确定修改.setOnClickListener(this);
        mMe_button_获取验证码.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.me_button_返回:
                finish();
                break;
            case R.id.me_button_获取验证码:
                sendVerification(mMe_edittext_手机号码.getText().toString());
                break;

            case R.id.me_button_确定修改:

                String account = mMe_edittext_手机号码.getText().toString();
                String captcha = mMe_edittext_验证码.getText().toString();
                String password = mMe_edittext_新密码.getText().toString();
                String againpassword = mMe_edittext_再次输入新密码.getText().toString();

                if (TextUtils.isEmpty(account)) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isMoble(account)) {
                    Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!InputUtil.isMobileLegal(account)) {
                    Toast.makeText(this, "请输入正确的手机号1", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(captcha)) {
                    Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (captcha.length() < 4) {
                    Toast.makeText(this, "验证码长度为4位", Toast.LENGTH_SHORT).show();
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

                forgetpassword(account, password, againpassword, captcha);



                break;
        }
    }

    /**
     * 获取验证码
     */
//    private void sendVerification(String account) {
//        Map<String,String> params = new HashMap<>();
//        params.put("tel",account);
//        XutilsHttp.getInstance().post(AppConstants.URL + "agent/user/captcha", params, new XutilsHttp.XCallBack() {
//            @Override
//            public void onResponse(String result) {
//                Toast.makeText(ForgetResetPassWordActivity.this, "验证码已发送", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void error(String message) {
//                Toast.makeText(ForgetResetPassWordActivity.this, "验证码发送失败:" + message, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
    private void sendVerification(String account) {


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
                        Toast.makeText(ForgetResetPassWordActivity.this,model.getMsg(),Toast.LENGTH_SHORT).show();
                    }
                });

    }

    /**
     * 忘记密码
     *
     * @param account       账号
     * @param password      密码
     * @param againpassword 密码
     * @param captcha       验证码
     */

    private void forgetpassword(String account, String password, String againpassword, String captcha) {


        OkHttpUtils.post(AppConstants.URL+"user/resetPassword")
                .tag(this)
                .params("tel", account)
                .params("password", password)
                .params("password_verify", againpassword)
                .params("captcha", captcha)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        StringModel model = JsonUtil.jsonToEntity(s,StringModel.class);

                        if(model.getCode()==200){
                            Toast.makeText(ForgetResetPassWordActivity.this,"修改成功",Toast.LENGTH_LONG).show();
                            LoginActivity.start(ForgetResetPassWordActivity.this);
                        }else {
                            Toast.makeText(ForgetResetPassWordActivity.this, "修改失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private static boolean isMoble(String telnumber) {

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
