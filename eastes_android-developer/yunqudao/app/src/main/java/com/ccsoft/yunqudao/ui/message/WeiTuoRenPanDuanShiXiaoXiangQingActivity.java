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

public class WeiTuoRenPanDuanShiXiaoXiangQingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mMessage_button_返回;
    private Button      mMessage_button_申诉;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_workmessage_wuxiao_wtr);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, WeiTuoRenPanDuanShiXiaoXiangQingActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化
     */
    private void initView() {

        mMessage_button_返回 = findViewById(R.id.message_button_返回);
        mMessage_button_申诉 = findViewById(R.id.message_button_申诉);
    }

    /**
     * 初始化
     */
    private void initListener() {

        mMessage_button_返回.setOnClickListener(this);
        mMessage_button_申诉.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message_button_返回:
                finish();
                break;
            case R.id.message_button_申诉:
                Toast.makeText(this,"跳转到工作",Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}
