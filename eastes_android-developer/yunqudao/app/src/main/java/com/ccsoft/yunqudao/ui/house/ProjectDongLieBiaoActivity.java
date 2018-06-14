package com.ccsoft.yunqudao.ui.house;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class ProjectDongLieBiaoActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton  mHouse_button_返回;
    private LinearLayout mHouse_item_linearlayout_项目动态1;
    private LinearLayout mHouse_item_linearlayout_项目动态2;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_house_project_dongtailiebiao);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ProjectDongLieBiaoActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化id
     */
    private void initView() {

        mHouse_button_返回 = findViewById(R.id.house_button_返回);
        mHouse_item_linearlayout_项目动态1 = findViewById(R.id.house_item_linearlayout_项目动态1);
        mHouse_item_linearlayout_项目动态2 = findViewById(R.id.house_item_linearlayout_项目动态2);
    }

    /**
     * 初始化监听器
     */
    private void initListener() {

        mHouse_button_返回.setOnClickListener(this);
        mHouse_item_linearlayout_项目动态1.setOnClickListener(this);
        mHouse_item_linearlayout_项目动态2.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.house_button_返回:
                finish();
                break;

            case R.id.house_item_linearlayout_项目动态1:
                ProjectDongTaiXiangQingActivity.start(this);
                break;

            case R.id.house_item_linearlayout_项目动态2:
                ProjectDongTaiXiangQingActivity.start(this);
                break;
        }
    }
}
