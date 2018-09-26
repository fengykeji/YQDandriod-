package com.ccsoft.yunqudao.ui.work;

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

public class WorkShiXiaoXiangQing3Activity extends AppCompatActivity implements View.OnClickListener {


    /**
     * 到访人失效详情
     * @param savedInstanceState
     */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_work_shixiaoxiangqing_dfr);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, WorkShiXiaoXiangQing3Activity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化
     */
    private void initView() {

    }

    /**
     * 初始化
     */
    private void initListener() {

    }

    public void onClick(View v) {
        switch (v.getId()) {
        }
    }
}
