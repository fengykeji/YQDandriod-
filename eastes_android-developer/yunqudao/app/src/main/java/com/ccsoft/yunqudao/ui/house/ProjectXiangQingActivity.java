package com.ccsoft.yunqudao.ui.house;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.StringBean;
import com.ccsoft.yunqudao.bean.UrlBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.ui.adapter.HouseProjectFragmentPagerAdapter;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;


import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.onekeyshare.OnekeyShare;
import okhttp3.Call;
import okhttp3.Response;

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
    private CustomViewPager                        mHouse_viewpager_分类;
    private List<Fragment>                   mList;
    private HouseProjectFragmentPagerAdapter mHouseProjectFragmentPagerAdapter;
    private int color,color1;
    private int project_id;
    private String url;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_house_project_xiangqing);


        initView();
        getUrl();
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

        color = getResources().getColor(R.color.liji_material_blue_500);
        color1 = getResources().getColor(R.color.chunhei);
        project_id = getIntent().getIntExtra("project_id",0);
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

        mHouse_viewpager_分类.setScanScroll(false);
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
                mHouse_button_项目.setTextColor(color);
                mHouse_button_佣金.setTextColor(color1);
                mHouse_button_分析.setTextColor(color1);
                break;
            case R.id.house_button_佣金:
                mHouse_viewpager_分类.setCurrentItem(1);
                mHouse_button_项目.setTextColor(color1);
                mHouse_button_佣金.setTextColor(color);
                mHouse_button_分析.setTextColor(color1);
                break;
            case R.id.house_button_分析:
                mHouse_viewpager_分类.setCurrentItem(2);
                mHouse_button_项目.setTextColor(color1);
                mHouse_button_佣金.setTextColor(color1);
                mHouse_button_分析.setTextColor(color);
                break;
            case R.id.house_button_分享:

                showShare();

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




    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("云渠道");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl(url);
// text是分享文本，所有平台都需要这个字段
        oks.setText("房地产分销渠道平台");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setImageUrl(AppConstants.URL+"assets/img/logo.jpg");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
//        oks.setComment("我是测试评论文本");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
//        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
    }

    /**
     * 获取分享链接
     */
    private void getUrl(){
        OkHttpUtils.get(AppConstants.URL+"user/project/getShare")
                .tag(this)
                .params("project_id",project_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        StringBean bean = JsonUtil.jsonToEntity(s,StringBean.class);
                        if(bean.getCode() == 200){
                            url = bean.getData().toString();
                        }
                    }
                });
    }
}
