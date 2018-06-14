package com.ccsoft.yunqudao.ui.house;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class ProjectXiangCeActivity extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener {

    private ImageButton mHouse_button_返回;
    private ViewPager   mHouse_viewpager_图册;
    private TextView    mHouse_text_效果图;
    private TextView    mHouse_text_全部图;
    private Button      mHouse_button_效果图;
    private Button      mHouse_button_实景图;
    private Button      mHouse_button_位置图;
    private Button      mHouse_button_户型图;
    private Button      mHouse_button_样板间;
    private Button      mHouse_button_配套图;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_house_loupanxiangce);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ProjectXiangCeActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化id
     */
    private void initView() {

        mHouse_button_返回 = findViewById(R.id.house_button_返回);
        mHouse_viewpager_图册 = findViewById(R.id.house_viewpager_图册);
        mHouse_text_效果图 = findViewById(R.id.house_text_效果图);
        mHouse_text_全部图 = findViewById(R.id.house_text_全部图);
        mHouse_button_效果图 = findViewById(R.id.house_button_效果图);
        mHouse_button_实景图 = findViewById(R.id.house_button_实景图);
        mHouse_button_位置图 = findViewById(R.id.house_button_位置图);
        mHouse_button_户型图 = findViewById(R.id.house_button_户型图);
        mHouse_button_样板间 = findViewById(R.id.house_button_样板间);
        mHouse_button_配套图 = findViewById(R.id.house_button_配套图);
    }

    /**
     * 初始化监听器
     */
    private void initListener() {

        mHouse_button_返回.setOnClickListener(this);
        //mHouse_button_效果图.setOnClickListener(this);
        //mHouse_button_实景图.setOnClickListener(this);
        //mHouse_button_位置图.setOnClickListener(this);
        //mHouse_button_户型图.setOnClickListener(this);
        //mHouse_button_样板间.setOnClickListener(this);
        //mHouse_button_配套图.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.house_button_返回:
                finish();
                break;
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
