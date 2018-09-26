package com.ccsoft.yunqudao.ui.work;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
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

public class WorkChengJiaoKeHuActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton    mWork_button_back;
    private Button         mWork_button_over_verify;
    private Button         mWork_button_over_valid;
    private Button         mWork_button_over_disable;
    private Button         mWork_button_over_complain;
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
        mWork_button_over_complain = findViewById(R.id.work_button_over_complain);


        ViewPager mViewPager = findViewById(R.id.forward_view_pager);
        TabLayout mTabLayout = findViewById(R.id.forward_tab_layout);
        mList = new ArrayList<>();
        mList.add(new WorkChengjiaoVerifyFragment());
        mList.add(new WorkChengjiaoVaildFragment());
        mList.add(new WorkChengjiaoDisableFragment());
        mList.add(new WorkChengjiaoComplainFragment());

        SelectContactsPagerAdapter adapter = new SelectContactsPagerAdapter(mList, this.getSupportFragmentManager(), this);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(4);
    }

    /**
     * 初始化监听器
     */
    private void initListener() {

        mWork_button_back.setOnClickListener(this);
        mWork_button_over_verify.setOnClickListener(this);
        mWork_button_over_valid.setOnClickListener(this);
        mWork_button_over_disable.setOnClickListener(this);
        mWork_button_over_complain.setOnClickListener(this);
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
            case R.id.work_button_over_complain:
                mWork_viewpager_over_client.setCurrentItem(3);
                break;
        }
    }




    public class SelectContactsPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment>  mFragments;
        private Context         mContext;
        private FragmentManager fragmentManager;

        SelectContactsPagerAdapter(List<Fragment> fragments, FragmentManager fm, Context context) {
            super(fm);
            this.mFragments = fragments;
            this.mContext = context;
            this.fragmentManager = fm;
        }

        @Override
        public Fragment getItem(int position) {
            return this.mFragments.get(position);
        }

        @Override
        public int getCount() {
            return this.mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title;
            switch (position) {
                case 0:
                    title = "待成交";
                    break;
                case 1:
                    title = "成交";
                    break;
                case 2:
                    title = "未成交";
                    break;
                case 3:
                    title = "申诉";
                    break;
                default:
                    title = "确认中";
                    break;
            }
            return title;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            this.fragmentManager.beginTransaction().show(fragment).commit();
            return fragment;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Fragment fragment = mFragments.get(position);
            fragmentManager.beginTransaction().hide(fragment).commit();
        }
    }
}
