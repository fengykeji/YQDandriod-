package com.ccsoft.yunqudao.ui.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

public class YaoQingJiangLiActivity extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_yaoqingjiangli);
//        initView();
//        initData();
//        initListener();
    }
}
