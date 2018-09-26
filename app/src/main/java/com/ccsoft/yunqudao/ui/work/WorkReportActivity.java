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
import com.ccsoft.yunqudao.ui.adapter.WorkBaoBeiKeHuAdapter;
import com.ccsoft.yunqudao.utils.ActivityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class WorkReportActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mWork_button_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_work_baobeikehu);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, WorkReportActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化id,把fm添加到list集合里
     */
    private void initView() {
        ViewPager mViewPager = findViewById(R.id.forward_view_pager);
        TabLayout mTabLayout = findViewById(R.id.forward_tab_layout);
        mWork_button_back = findViewById(R.id.work_button_back);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new WorkReportVerifyFragment());
        fragments.add(new WorkReportVaildFragment());
        fragments.add(new WorkReportDisableFragment());
        fragments.add(new WorkReportComplainFragment());
        SelectContactsPagerAdapter adapter = new SelectContactsPagerAdapter(fragments, this.getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(3);
    }

    /**
     * 初始化监听器
     */
    private void initListener() {

        mWork_button_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.work_button_back:
                finish();
                break;
        }
    }

    public class SelectContactsPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment>  mFragments;
        private FragmentManager fragmentManager;

        SelectContactsPagerAdapter(List<Fragment> fragments, FragmentManager fm) {
            super(fm);
            this.mFragments = fragments;
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
                    title = "确认中";
                    break;
                case 1:
                    title = "有效";
                    break;
                case 2:
                    title = "无效";
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
