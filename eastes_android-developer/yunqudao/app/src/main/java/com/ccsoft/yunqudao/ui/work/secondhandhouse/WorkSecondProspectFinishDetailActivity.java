package com.ccsoft.yunqudao.ui.work.secondhandhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.ui.adapter.ViewPagerAdapter;
import com.ccsoft.yunqudao.ui.adapter.ViewPagerAdapter1;
import com.ccsoft.yunqudao.ui.customers.ClientFollowFragment;
import com.ccsoft.yunqudao.ui.customers.PiPeiXinXiFragment;
import com.ccsoft.yunqudao.ui.customers.XuQiuXingXiFragment;
import com.ccsoft.yunqudao.ui.view.ViewPagerForScrollView;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;

import java.util.ArrayList;

public class WorkSecondProspectFinishDetailActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton mCustomers_button_back;
    private ImageButton                    mCustomers_button_quick_recommend;
    private TextView mCustomers_text_name;
    private TextView                       mCustomers_text_sex;
    private TextView                       mCustomers_text_birthday;
    private TextView                       mCustomers_text_tel;
    private TextView                       mCustomers_text_card_type;
    private TextView                       mCustomers_text_card_id;
    private TextView                       mCustomers_text_address;
    private LinearLayout ll_fangyuanxinxi;
    private TabLayout mCustomers_TabLayout;
    private ViewPagerForScrollView mCustomers_viewpager_xiangqing;
    private ArrayList<Fragment>            fragments;



    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_work_second_prospect_finish_details);
        HideIMEUtil.wrap(this);
        initView();
        initListener();
    }
    private void initView(){
        mCustomers_button_back = findViewById(R.id.customers_button_back);
        mCustomers_button_quick_recommend = findViewById(R.id.customers_button_quick_recommend);
        mCustomers_text_name = findViewById(R.id.customers_text_name);
        mCustomers_text_sex = findViewById(R.id.customers_text_sex);
        mCustomers_text_birthday = findViewById(R.id.customers_text_birthday);
        mCustomers_text_tel = findViewById(R.id.customers_text_tel);
        mCustomers_text_card_type = findViewById(R.id.customers_text_card_type);
        mCustomers_text_card_id = findViewById(R.id.customers_text_card_id);
        mCustomers_text_address = findViewById(R.id.customers_text_address);
        mCustomers_TabLayout = findViewById(R.id.customers_TabLayout);
        mCustomers_viewpager_xiangqing = findViewById(R.id.customers_viewpager_xiangqing);
        ll_fangyuanxinxi = findViewById(R.id.ll_fangyuanxinxi);
        addFragments();

    }

    private void initListener(){
        ll_fangyuanxinxi.setOnClickListener(this);
    }

    /**
     * 添加Fragment
     */
    private void addFragments() {
        //int page = mCustomers_viewpager_xiangqing.getCurrentItem();
        fragments = new ArrayList<>();
        fragments.add(new LinkmanFragment());//初始化fragment  把这个Model传过去 到Fragment取里面的数据就好
        fragments.add(new HouseInfoFragment());
        fragments.add(new GenJinFragment());
        ViewPagerAdapter1 adapter = new ViewPagerAdapter1(fragments, getSupportFragmentManager(), this);
        mCustomers_viewpager_xiangqing.setAdapter(adapter);
        mCustomers_TabLayout.setupWithViewPager(mCustomers_viewpager_xiangqing);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_fangyuanxinxi:
                Intent intent = new Intent(this,HouseInfoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
