package com.ccsoft.yunqudao.ui.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class WeiDaoFangShenSuActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mMessage_button_返回;
    private Button      mMessage_button_提交;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_message_workmessage_shensu);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, WeiDaoFangShenSuActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化
     */
    private void initView() {

        mMessage_button_返回 = findViewById(R.id.message_button_返回);
        mMessage_button_提交 = findViewById(R.id.message_button_提交);
    }

    /**
     * 初始化
     */
    private void initListener() {

        mMessage_button_返回.setOnClickListener(this);
        mMessage_button_提交.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message_button_返回:
                finish();
                break;
            case R.id.message_button_提交:
                Toast.makeText(this,"提交了申诉",Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}
