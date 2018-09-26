package com.ccsoft.yunqudao.ui.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.ui.me.RenZhengXinXiTianXieActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class ShenHeWeiTongGuoActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mMessage_button_返回;
    private Button      mMessage_button_再次申请;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_message_systemmessage_shenheweitongguo);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ShenHeWeiTongGuoActivity.class);
        context.startActivity(intent);
    }

    private void initView() {

        /**
         * 初始化
         */
        mMessage_button_返回 = findViewById(R.id.message_button_返回);
        mMessage_button_再次申请 = findViewById(R.id.message_button_再次申请);
    }

    private void initListener() {

        /**
         * 初始化
         */
        mMessage_button_返回.setOnClickListener(this);
        mMessage_button_再次申请.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message_button_返回:
                finish();
                break;
            case R.id.message_button_再次申请:
                RenZhengXinXiTianXieActivity.start(this);
                finish();
                break;
        }
    }
}
