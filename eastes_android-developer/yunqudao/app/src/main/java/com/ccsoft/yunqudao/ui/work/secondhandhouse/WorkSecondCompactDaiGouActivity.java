package com.ccsoft.yunqudao.ui.work.secondhandhouse;

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
import android.widget.ImageButton;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.ui.home.HomeActivity;
import com.ccsoft.yunqudao.ui.work.AddWorkActivity;
import com.ccsoft.yunqudao.ui.work.WorkRecommendActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;

import java.util.ArrayList;
import java.util.List;

public class WorkSecondCompactDaiGouActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton mWork_button_back,work_button_add_recommend;
    private ViewPager mViewPager;
    private int fid;



    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_work_secong_compactdaigou);
        HideIMEUtil.wrap(this);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, WorkRecommendActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化id,把fm添加到list集合里
     */
    private void initView() {
        fid = getIntent().getIntExtra("fid",0);
        mWork_button_back = findViewById(R.id.work_button_back);
        mViewPager = findViewById(R.id.forward_view_pager);
        TabLayout mTabLayout = findViewById(R.id.forward_tab_layout);
        work_button_add_recommend = findViewById(R.id.work_button_add_recommend);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new WorkSecondBaoBeiVerfyFragment());
        fragments.add(new WorkSecondBaoBeiValidFragment());
        SelectContactsPagerAdapter adapter = new SelectContactsPagerAdapter(fragments, this.getSupportFragmentManager(), this);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        if(fid==2) {
            mViewPager.setCurrentItem(2);
        }else {
            mViewPager.setCurrentItem(0);
        }

        mViewPager.setOffscreenPageLimit(2);
    }

    /**
     * 初始化监听器
     */
    private void initListener() {
        mWork_button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkSecondCompactDaiGouActivity.this, HomeActivity.class);
                intent.putExtra("fid",3);
                startActivity(intent);
                finish();
            }
        });
        work_button_add_recommend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.work_button_add_recommend:
                Intent intent = new Intent(this,AddWorkActivity.class);
                startActivity(intent);
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
                    title = "已代购";
                    break;
                case 1:
                    title = "挞定";
                    break;
                default:
                    title = "已代购";
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
