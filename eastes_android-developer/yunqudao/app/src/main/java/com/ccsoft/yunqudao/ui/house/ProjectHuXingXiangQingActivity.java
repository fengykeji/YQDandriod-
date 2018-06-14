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
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class ProjectHuXingXiangQingActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ImageButton mHouse_button_返回;
    private ImageButton mHouse_button_分享;
    private Button      mHouse_button_平面图;
    private Button      mHouse_button_效果图;
    private Button      mHouse_button_3D图;
    private Button      mHouse_button_实景图;
    private ViewPager   mHouse_viewpager_户型信息;
    private Button      mHouse_button_查看更多匹配客户;
    private Button      mHouse_button_推荐1;
    private Button      mHouse_button_推荐2;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_house_huxingxiangqing);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ProjectHuXingXiangQingActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化
     */
    private void initView() {

        mHouse_button_返回 = findViewById(R.id.house_button_返回);
        mHouse_button_分享 = findViewById(R.id.house_button_分享);
        mHouse_button_平面图 = findViewById(R.id.house_button_平面图);
        mHouse_button_效果图 = findViewById(R.id.house_button_效果图);
        mHouse_button_3D图 = findViewById(R.id.house_button_3D图);
        mHouse_button_实景图 = findViewById(R.id.house_button_实景图);
        mHouse_viewpager_户型信息 = findViewById(R.id.house_viewpager_户型信息);
        mHouse_button_查看更多匹配客户 = findViewById(R.id.house_button_查看更多匹配客户);
        mHouse_button_推荐1 = findViewById(R.id.house_button_推荐1);
        mHouse_button_推荐2 = findViewById(R.id.house_button_推荐2);
    }

    /**
     * 初始化
     */
    private void initListener() {

        mHouse_button_返回.setOnClickListener(this);
        mHouse_button_分享.setOnClickListener(this);
        mHouse_button_平面图.setOnClickListener(this);
        mHouse_button_效果图.setOnClickListener(this);
        mHouse_button_3D图.setOnClickListener(this);
        mHouse_button_实景图.setOnClickListener(this);
        mHouse_button_查看更多匹配客户.setOnClickListener(this);
        mHouse_button_推荐1.setOnClickListener(this);
        mHouse_button_推荐2.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.house_button_返回:
                finish();
                break;

            case R.id.house_button_分享:
                Toast.makeText(this, "你分享了该户型", Toast.LENGTH_SHORT).show();
                break;

            case R.id.house_button_平面图:
                Toast.makeText(this, "你点击了平面图", Toast.LENGTH_SHORT).show();
                break;

            case R.id.house_button_效果图:
                Toast.makeText(this, "你点击了效果图", Toast.LENGTH_SHORT).show();
                break;

            case R.id.house_button_3D图:
                Toast.makeText(this, "你点击了3D图", Toast.LENGTH_SHORT).show();
                break;

            case R.id.house_button_实景图:
                Toast.makeText(this, "你点击了实景图", Toast.LENGTH_SHORT).show();
                break;

            case R.id.house_button_查看更多匹配客户:
                ProjectPiPeiKeHuActivity.start(this);
                break;

            case R.id.house_button_推荐1:
                Toast.makeText(this, "你推荐了该户型", Toast.LENGTH_SHORT).show();
                break;

            case R.id.house_button_推荐2:
                Toast.makeText(this, "你推荐了该户型", Toast.LENGTH_SHORT).show();
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
