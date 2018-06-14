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

public class WorkWeiDaoFangShiXiaoXiangQingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mWork_button_back;
    private Button      mWork_button_complain;
    private Button      mWork_button_recommend;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_work_shixiaoxiangqing_wdf);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, WorkWeiDaoFangShiXiaoXiangQingActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化
     */
    private void initView() {

        mWork_button_back = findViewById(R.id.work_button_back);
        mWork_button_complain = findViewById(R.id.work_button_complain);
        mWork_button_recommend = findViewById(R.id.work_button_recommend);
    }

    /**
     * 初始化
     */
    private void initListener() {

        mWork_button_back.setOnClickListener(this);
        mWork_button_complain.setOnClickListener(this);
        mWork_button_recommend.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.work_button_back:
                finish();
                break;
            case R.id.work_button_complain:
                Toast.makeText(this,"点击了提交",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.work_button_recommend:
                Toast.makeText(this,"点击了重新推荐",Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}
