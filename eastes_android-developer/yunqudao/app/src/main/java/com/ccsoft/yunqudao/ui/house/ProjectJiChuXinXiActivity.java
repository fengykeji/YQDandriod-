package com.ccsoft.yunqudao.ui.house;

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
 * @data: 2018/5/10 0010
 */

public class ProjectJiChuXinXiActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mHouse_button_返回;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_house_project_loupanxinxi);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ProjectJiChuXinXiActivity.class);
        context.startActivity(intent);
    }

    private void initView() {

        /**
         * 初始化
         */
        mHouse_button_返回 = findViewById(R.id.house_button_返回);
    }

    private void initListener() {

        /**
         * 初始化
         */
        mHouse_button_返回.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.me_button_返回:
                finish();
                break;
        }
    }
}

