package com.ccsoft.yunqudao.ui.me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/3 0003
 */

public class WoDeGuanZhuActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton  me_button_返回;
    private RecyclerView me_recyclerview_关注列表;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_guanzhu);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, WoDeGuanZhuActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         * 初始化id
         */
        me_button_返回 = findViewById(R.id.me_button_返回);
        me_recyclerview_关注列表 = findViewById(R.id.me_recyclerview_关注列表);
    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        me_button_返回.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.me_button_返回:
                finish();
                break;
        }
    }
}
