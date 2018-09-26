package com.ccsoft.yunqudao.ui.me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class RenZhengXinXiTianXieActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mMe_button_返回;
    private Button      mMe_button_提交申请;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_shenqingrenzhengxinxitianxie);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, RenZhengXinXiTianXieActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         * 初始化id
         */

        mMe_button_返回 = findViewById(R.id.me_button_返回);
        mMe_button_提交申请 = findViewById(R.id.me_button_提交申请);
    }

    private void initListener() {

        /**
         * 初始化监听器
         */

        mMe_button_返回.setOnClickListener(this);
        mMe_button_提交申请.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.me_button_返回:
                finish();
                break;
            case R.id.me_button_提交申请:
                RenZhengXinXiShenHeZhongActivity.start(this);
                finish();
                break;
        }
    }
}
