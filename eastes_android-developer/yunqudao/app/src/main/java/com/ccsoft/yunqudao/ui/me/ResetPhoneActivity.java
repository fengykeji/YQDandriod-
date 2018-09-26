package com.ccsoft.yunqudao.ui.me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/8 0008
 */

public class ResetPhoneActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mMe_button_返回;
    private EditText    mMe_edittext_原始手机号码;
    private EditText    mMe_edittext_验证码;
    private Button      mMe_button_获取验证码;
    private EditText    mMe_edittext_新号码;
    private Button      mMe_button_确定;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_reset_phone);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ResetPhoneActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         * 初始化id
         */

        mMe_button_返回 = findViewById(R.id.me_button_返回);
        mMe_edittext_原始手机号码 = findViewById(R.id.me_edittext_原始手机号码);
        mMe_edittext_验证码 = findViewById(R.id.me_edittext_验证码);
        mMe_button_获取验证码 = findViewById(R.id.me_button_获取验证码);
        mMe_edittext_新号码 = findViewById(R.id.me_edittext_新号码);
        mMe_button_确定 = findViewById(R.id.me_button_确定);
    }

    private void initListener() {
        /**
         *初始化监听器
         */
        mMe_button_返回.setOnClickListener(this);
        mMe_button_获取验证码.setOnClickListener(this);
        mMe_button_确定.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.me_button_返回:
            finish();
                break;
            case R.id.me_button_获取验证码:
                Toast.makeText(this,"你获取了验证码",Toast.LENGTH_SHORT).show();
                break;
            case R.id.me_button_确定:
                finish();
                break;
        }
    }
}
