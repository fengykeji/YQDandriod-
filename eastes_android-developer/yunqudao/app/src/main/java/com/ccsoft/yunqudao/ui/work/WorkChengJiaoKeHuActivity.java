package com.ccsoft.yunqudao.ui.work;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.ui.adapter.WorkChengJiaoKeHuAdapter;
import com.ccsoft.yunqudao.utils.ActivityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class WorkChengJiaoKeHuActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ImageButton    mWork_button_back;
    private Button         mWork_button_over_verify;
    private Button         mWork_button_over_valid;
    private Button         mWork_button_over_disable;
    //private Button         mWork_button_over_complain;
    private ViewPager      mWork_viewpager_over_client;
    private List<Fragment> mList;
    WorkChengJiaoKeHuAdapter mWorkChengJiaoKeHuAdapter;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_work_chengjiaokehu);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, WorkChengJiaoKeHuActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化id,把fm添加到list集合里
     */
    private void initView() {

        mWork_button_back = findViewById(R.id.work_button_back);
        mWork_button_over_verify = findViewById(R.id.work_button_over_verify);
        mWork_button_over_valid = findViewById(R.id.work_button_over_valid);
        mWork_button_over_disable = findViewById(R.id.work_button_over_disable);
        //mWork_button_over_complain = findViewById(R.id.work_button_over_complain);
        mWork_viewpager_over_client = findViewById(R.id.work_viewpager_over_client);
        mList = new ArrayList<>();
        mList.add(new WorkReportVerifyFragment());
        mList.add(new WorkReportVaildFragment());
        mList.add(new WorkReportDisableFragment());
        mList.add(new WorkReportComplainFragment());

        mWorkChengJiaoKeHuAdapter = new WorkChengJiaoKeHuAdapter(getSupportFragmentManager(), mList);
        mWork_viewpager_over_client.setAdapter(mWorkChengJiaoKeHuAdapter);
        mWork_viewpager_over_client.setCurrentItem(0);
    }

    /**
     * 初始化监听器
     */
    private void initListener() {

        mWork_button_back.setOnClickListener(this);
        mWork_button_over_verify.setOnClickListener(this);
        mWork_button_over_valid.setOnClickListener(this);
        mWork_button_over_disable.setOnClickListener(this);
        //mWork_button_over_complain.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.work_button_back:
                finish();
                break;
            case R.id.work_button_over_verify:
                mWork_viewpager_over_client.setCurrentItem(0);

                break;
            case R.id.work_button_over_valid:
                mWork_viewpager_over_client.setCurrentItem(1);
                break;
            case R.id.work_button_over_disable:
                mWork_viewpager_over_client.setCurrentItem(2);
                break;
            //case R.id.work_button_over_complain:
            //    mWork_viewpager_over_client.setCurrentItem(3);
            //    break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
