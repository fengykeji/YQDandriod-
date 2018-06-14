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
 * @data: 2018/5/9 0009
 */

public class ProjectDanYuanXiangQingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mHouse_button_返回;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_house_project_danyuanxiangqing);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ProjectDanYuanXiangQingActivity.class);
        context.startActivity(intent);
    }



    /**
     * 初始化
     */
    private void initView() {

        mHouse_button_返回 = findViewById(R.id.house_button_返回);
    }



    /**
     * 初始化
     */
    private void initListener() {

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
