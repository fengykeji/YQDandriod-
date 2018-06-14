package com.ccsoft.yunqudao.ui.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/8 0008
 */

public class WorkMessageActivity extends AppCompatActivity implements View.OnClickListener {


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_message_workmessage);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, WorkMessageActivity.class);
        context.startActivity(intent);
    }

    private void initView() {

        /**
         * 初始化id
         */
    }

    private void initListener() {
        /**
         * 初始化监听器
         */
    }
    public void onClick(View v) {

        switch (v.getId()) {
        }
    }
}
