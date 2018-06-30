package com.ccsoft.yunqudao.ui.house;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.adapter.MyFragmentPagerAdapter;
import com.ccsoft.yunqudao.bean.ProjectImgGetBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;

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
    private TabLayout tabLayout;
    private int project_id;
    private ProjectImgGetBean bean;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_house_loupanxiangce);
        initView();
        initData();
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
        tabLayout = findViewById(R.id.xc_tablaout);

        project_id = getIntent().getIntExtra("project_id",0);
    }

    private void initData(){
        OkHttpManager.getInstance().get(HttpAdress.imgget + "?project_id=" + project_id, new BaseCallBack() {
            @Override
            public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {
                Type type = new TypeToken<ProjectImgGetBean>(){}.getType();
                bean = new Gson().fromJson(obj.toString(),type);
                if(bean.getCode()==200&&bean.getData()!=null){

                    ArrayList<Fragment> fragments = new ArrayList<>();
                    ArrayList<String> mTitles = new ArrayList<>();
                    Bundle bundle = new Bundle();

                    for (ProjectImgGetBean.DataBeanX dataBeanX : bean.getData()) {
                        ProjectXiangCeFragment fragment = new ProjectXiangCeFragment();
                        fragments.add(fragment);
                        bundle.putSerializable("list", (Serializable)dataBeanX.getData());
                        fragment.setArguments(bundle);
                        mTitles.add(dataBeanX.getName());
                    }

                    MyFragmentPagerAdapter fragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),  fragments,  mTitles);
                    mHouse_viewpager_图册.setAdapter(fragmentPagerAdapter);
                    tabLayout.setupWithViewPager(mHouse_viewpager_图册);
                }

            }

            @Override
            public void onFailure(Call call, Exception e) {

            }

            @Override
            public void onError(Response response, int errorCode) {

            }

            @Override
            public void onRequestBefore() {

            }
        });

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
