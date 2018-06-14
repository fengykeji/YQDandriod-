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
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/8 0008
 */

public class ResetPassWordActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mMe_button_返回;
    private EditText    mMe_edittext_原始密码;
    private EditText    mMe_edittext_新密码;
    private EditText    mMe_edittext_再次输入新密码;
    private Button      mMe_button_完成;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_reset_password);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ResetPassWordActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         * 初始化id
         */

        mMe_button_返回 = findViewById(R.id.me_button_返回);
        mMe_edittext_原始密码 = findViewById(R.id.me_edittext_原始密码);
        mMe_edittext_新密码 = findViewById(R.id.me_edittext_新密码);
        mMe_edittext_再次输入新密码 = findViewById(R.id.me_edittext_再次输入新密码);
        mMe_button_完成 = findViewById(R.id.me_button_完成);
    }

    private void initListener() {
        /**
         *初始化监听器
         */
        mMe_button_返回.setOnClickListener(this);
        mMe_button_完成.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.me_button_返回:
                finish();
                break;
            case R.id.me_button_完成:
                finish();
                break;
        }
    }
}
