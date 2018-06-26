package com.ccsoft.yunqudao.ui.customers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.model.response.ClientPrivateData;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.adapter.CustomersXiangQingPagerAdapter;
import com.ccsoft.yunqudao.ui.adapter.ViewPagerAdapter;
import com.ccsoft.yunqudao.ui.view.ViewPagerForScrollView;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class CustomersXiangQingActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ImageButton                    mCustomers_button_back;
    private ImageButton                    mCustomers_button_quick_recommend;
    private TextView                       mCustomers_text_name;
    private TextView                       mCustomers_text_sex;
    private TextView                       mCustomers_text_birthday;
    private TextView                       mCustomers_text_tel;
    private TextView                       mCustomers_text_card_type;
    private TextView                       mCustomers_text_card_id;
    private String                         province;
    private String                         city;
    private String                         district;
    private TextView                       mCustomers_text_address;
    private ViewPagerForScrollView mCustomers_viewpager_xiangqing;
    private CustomersXiangQingPagerAdapter mCustomersXiangQingPagerAdapter;
    private XuQiuXingXiFragment            xuQiuXingXiFragment;
    private ClientFollowFragment           clientFollowFragment;
    private PiPeiXinXiFragment             piPeiXinXiFragment;
    private List<Fragment>                 mList;
    private int                            mClienID;
    private ClientPrivateData              mClientPrivateData;
    private ViewPagerAdapter               mViewPagerAdapter;
    private TabLayout                      mCustomers_TabLayout;
    private ArrayList<Fragment>            fragments;
    private ImageButton mCustomers_button_resetclientbasic;
    private List<ClientPrivateData.NeedInfoBean> need_info = new ArrayList<>();
    private int need_id;
    private int needId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_xiangqing);
        initView();
        initListener();
        initData();

    }

    /**
     * 开启跳转
     *
     * @param context 上下文
     * @param id      传过来的客户id
     */
    public static void start(Context context, int id) {
        Intent intent = new Intent(context, CustomersXiangQingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("client_id", id);
        intent.putExtra("data", bundle);
        context.startActivity(intent);
    }

    /**
     * 初始化id,把fm添加到list集合里
     */
    private void initView() {
        this.getArguments();
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
        mCustomers_button_resetclientbasic = findViewById(R.id.customers_button_resetclientbasic);


    }

    /**
     * 请求数据
     */

    private void initData() {
        ClientManager.getInstance().getClientInfo(mClienID).compose(RxSchedulers.<ClientPrivateData>io_main())
                .subscribe(new ApiSubscriber<ClientPrivateData>(this) {
            @Override
            protected void _onNext(ClientPrivateData clientPrivateData) {
                Log.i("hcc------->", "--------------" + clientPrivateData.toString());
                setData(clientPrivateData);
                mClientPrivateData = clientPrivateData; //在这已经复制了
                need_info = clientPrivateData.need_info;
                addFragments();
                Log.i("hcc------->", "--------------2" + mClientPrivateData.toString());
                mCustomers_button_quick_recommend.setOnClickListener(CustomersXiangQingActivity.this);

            }

            @Override
            protected void _onError(String message) {

            }

            @Override
            protected void _onCompleted() {

            }
        });




    }

    /**
     * 添加Fragment
     */
    private void addFragments() {
        //int page = mCustomers_viewpager_xiangqing.getCurrentItem();
        fragments = new ArrayList<>();
        fragments.add(XuQiuXingXiFragment.newInstance(mClientPrivateData.need_info.get(0)));//初始化fragment  把这个Model传过去 到Fragment取里面的数据就好
        fragments.add(ClientFollowFragment.newInstance(mClienID));
        fragments.add(PiPeiXinXiFragment.newInstance());
        ViewPagerAdapter adapter = new ViewPagerAdapter(fragments, getSupportFragmentManager(), this);
        mCustomers_viewpager_xiangqing.setAdapter(adapter);
        mCustomers_TabLayout.setupWithViewPager(mCustomers_viewpager_xiangqing);
        //mCustomers_viewpager_xiangqing.setCurrentItem(page);
        mCustomers_viewpager_xiangqing.setOffscreenPageLimit(3);
    }

    /**
     * 数据绑定
     */
    private void setData(ClientPrivateData mClientPrivateData) {
        if (mClientPrivateData.basic != null) {
            mCustomers_text_name.setText(mClientPrivateData.basic.name);
            if (mClientPrivateData.basic.sex ==0 ) {
                mCustomers_text_sex.setText("");
            }
            else {
                mCustomers_text_sex.setText(mClientPrivateData.basic.sex ==1 ? "男" : "女");
            }
            mCustomers_text_birthday.setText(TextUtils.isEmpty(mClientPrivateData.basic.birth) ? "" : mClientPrivateData.basic.birth);
            mCustomers_text_tel.setText(TextUtils.isEmpty(mClientPrivateData.basic.tel) ? "" : mClientPrivateData.basic.tel);
            mCustomers_text_card_type.setText("身份证");
            mCustomers_text_card_id.setText(TextUtils.isEmpty(mClientPrivateData.basic.card_id) ? "" : mClientPrivateData.basic.card_id);
            mCustomers_text_address.setText(TextUtils.isEmpty(mClientPrivateData.basic.address) ? "" : mClientPrivateData.basic.address);
        }
    }

    /**
     * 获取数据
     */
    private void getArguments() {
//        Bundle data = getIntent().getBundleExtra("data");
//        mClienID = data.getInt("client_id");
        mClienID = getIntent().getIntExtra("client_id",0);
        Log.i("HCC--------》", "====卡片id====" + String.valueOf(mClienID).toString());
    }

    /**
     * 初始化监听器
     */
    private void initListener() {
        mCustomers_button_back.setOnClickListener(this);

        mCustomers_button_resetclientbasic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customers_button_back:
                finish();
                break;
            case R.id.customers_button_quick_recommend:
                getInfo();
//                QuickRecommendActivity.start(this,needId,mClienID);

                Intent intent = new Intent(this,QuickRecommendActivity.class);
                intent.putExtra("id",needId);
                intent.putExtra("mClienID",mClienID);
                startActivity(intent);
                break;
            case R.id.customers_button_resetclientbasic:
                ResetClientBasicActivity.start(this,mClientPrivateData);
                finish();
                break;
        }
    }

    /**
     * 拿到needId
     */
    private void getInfo(){
        needId = need_info.get(0).need_id;
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

    @Override
    protected void onResume() {
        super.onResume();

    }

}
