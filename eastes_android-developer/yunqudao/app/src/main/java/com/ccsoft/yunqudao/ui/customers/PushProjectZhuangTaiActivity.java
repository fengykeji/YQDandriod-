package com.ccsoft.yunqudao.ui.customers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class PushProjectZhuangTaiActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mCustomers_button_back;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_push_project_zhuangtai);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, PushProjectZhuangTaiActivity.class);
        context.startActivity(intent);
    }



    /**
     * 初始化id
     */
    private void initView() {

        mCustomers_button_back = findViewById(R.id.customers_button_back);
    }



    /**
     * 初始化监听器
     */
    private void initListener() {

        mCustomers_button_back.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customers_button_back:
                finish();
                break;
        }
    }
}
