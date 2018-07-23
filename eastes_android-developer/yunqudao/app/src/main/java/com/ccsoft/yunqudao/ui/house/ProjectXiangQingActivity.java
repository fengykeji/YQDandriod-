package com.ccsoft.yunqudao.ui.house;

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
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.ui.adapter.HouseProjectFragmentPagerAdapter;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class ProjectXiangQingActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ImageButton                      mHouse_button_返回;
    private Button                           mHouse_button_项目;
    private Button                           mHouse_button_佣金;
    private Button                           mHouse_button_分析;
    private ImageButton                      mHouse_button_分享;
    private ViewPager                        mHouse_viewpager_分类;
    private List<Fragment>                   mList;
    private HouseProjectFragmentPagerAdapter mHouseProjectFragmentPagerAdapter;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_house_project_xiangqing);

        UMConfigure.init(this,"5ac9defef29d986c30000078"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
        PlatformConfig.setQQZone("1106811849", "ik2oC5WcDQ5IOrpc");
        PlatformConfig.setWeixin("wx3e34d92e8b8cb53e", "200ee15186843d67c0d9ba6a66f3a6ba");
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ProjectXiangQingActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化id,把fm添加到list集合里
     */

    private void initView() {

        mHouse_button_返回 = findViewById(R.id.house_button_返回);
        mHouse_button_项目 = findViewById(R.id.house_button_项目);
        mHouse_button_佣金 = findViewById(R.id.house_button_佣金);
        mHouse_button_分析 = findViewById(R.id.house_button_分析);
        mHouse_button_分享 = findViewById(R.id.house_button_分享);
        mHouse_viewpager_分类 = findViewById(R.id.house_viewpager_分类);
        mList = new ArrayList<>();
        mList.add(new ProjectXiangQingFragment());
        mList.add(new ProjectYongJinFragment());
        mList.add(new ProjectFenXiFragment());

        mHouseProjectFragmentPagerAdapter = new HouseProjectFragmentPagerAdapter(getSupportFragmentManager(), mList);
        mHouse_viewpager_分类.setAdapter(mHouseProjectFragmentPagerAdapter);
        //初始化显示第一个页面
        mHouse_viewpager_分类.setCurrentItem(0);
    }
    /**
     * 初始化监听器
     */
    private void initListener() {


        mHouse_button_返回.setOnClickListener(this);
        mHouse_button_项目.setOnClickListener(this);
        mHouse_button_佣金.setOnClickListener(this);
        mHouse_button_分析.setOnClickListener(this);
        mHouse_button_分享.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.house_button_返回:
                finish();
                break;
            case R.id.house_button_项目:
                mHouse_viewpager_分类.setCurrentItem(0);
                break;
            case R.id.house_button_佣金:
                mHouse_viewpager_分类.setCurrentItem(1);
                break;
            case R.id.house_button_分析:
                mHouse_viewpager_分类.setCurrentItem(2);
                break;
            case R.id.house_button_分享:
                new ShareAction(this).withText("hello")
                        .setDisplayList(SHARE_MEDIA.QZONE,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE)
                        .setCallback(shareListener).open();

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

    /**
     * 分享回调
     */
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(ProjectXiangQingActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(ProjectXiangQingActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(ProjectXiangQingActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };
}
