package com.ccsoft.yunqudao.ui.work.secondhandhouse;

import android.content.DialogInterface;
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
import com.ccsoft.yunqudao.bean.ProspectBean;
import com.ccsoft.yunqudao.bean.ProspectFinishBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.ViewPagerAdapter;
import com.ccsoft.yunqudao.ui.adapter.ViewPagerAdapter1;
import com.ccsoft.yunqudao.ui.customers.ClientFollowFragment;
import com.ccsoft.yunqudao.ui.customers.PiPeiXinXiFragment;
import com.ccsoft.yunqudao.ui.customers.XuQiuXingXiFragment;
import com.ccsoft.yunqudao.ui.view.ViewPagerForScrollView;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.ItemsDialogFragment;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;

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
    private TextView tv_kanfangfangshi,tv_maifangyiyuan,tv_maifangjinpo,tv_cankaojiage
            ,tv_guanzhurenshu,tv_yugutime;
    private LinearLayout ll_fangyuanxinxi;
    private TabLayout mCustomers_TabLayout;
    private ViewPagerForScrollView mCustomers_viewpager_xiangqing;
    private ArrayList<Fragment>            fragments;

    private int house_id;

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_work_second_prospect_finish_details);
        HideIMEUtil.wrap(this);
        initView();
        initListener();
        initData();
    }
    private void initView(){

        house_id = getIntent().getIntExtra("house_id",0);

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
        tv_kanfangfangshi = findViewById(R.id.tv_kanfangfangshi);
        tv_maifangyiyuan = findViewById(R.id.tv_maifangyiyuan);
        tv_maifangjinpo = findViewById(R.id.tv_maifangjinpo);
        tv_cankaojiage = findViewById(R.id.tv_cankaojiage);
        tv_guanzhurenshu = findViewById(R.id.tv_guanzhurenshu);
        tv_yugutime = findViewById(R.id.tv_yugutime);

        addFragments();

    }

    private void initListener(){

        ll_fangyuanxinxi.setOnClickListener(this);
        mCustomers_button_quick_recommend.setOnClickListener(this);
        mCustomers_button_back.setOnClickListener(this);
    }

    private void initData(){
        OkHttpUtils.get(HttpAdress.houseSurveyDetail)
                .tag(this)
                .params("house_id",house_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        ProspectFinishBean bean = JsonUtil.jsonToEntity(s,ProspectFinishBean.class);
                        if(bean.getCode() == 200){
                            mCustomers_text_name.setText(bean.getData().getHouse().getProject_name());
                            mCustomers_text_sex.setText(bean.getData().getHouse().getPrice()+"");
                            mCustomers_text_birthday.setText(bean.getData().getHouse().getMinimum()+"");
                            mCustomers_text_tel.setText(bean.getData().getHouse().getPay_way());
                            mCustomers_text_card_type.setText(bean.getData().getHouse().getProperty_belong());
                            mCustomers_text_card_id.setText(bean.getData().getHouse().getIs_mortgage());
                            mCustomers_text_address.setText(bean.getData().getHouse().getProperty_limit()+"");
                            tv_kanfangfangshi.setText(bean.getData().getHouse().getCheck_way());
                            tv_maifangyiyuan.setText(bean.getData().getHouse().getIntent()+"");
                            tv_maifangjinpo.setText(bean.getData().getHouse().getUrgency()+"");
                            tv_cankaojiage.setText(bean.getData().getHouse().getSuggest_price()+"");
                            tv_guanzhurenshu.setText(bean.getData().getHouse().getFollow_num()+"");
//                            tv_yugutime.setText(bean.getData().getHouse());
                        }
                    }
                });
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
                intent.putExtra("house_id",house_id);
                startActivity(intent);
                break;
            case R.id.customers_button_quick_recommend:
                showItemsDialogFragment();
                break;
            case R.id.customers_button_back:
                finish();
                break;
        }
    }

    public void showItemsDialogFragment() {
        ItemsDialogFragment itemsDialogFragment = new ItemsDialogFragment();
        String[] items = {"转合同", "转代购","下架房源","取消" };
        itemsDialogFragment.show("", items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:

                        break;
                    case 1:
                        Intent intent = new Intent(WorkSecondProspectFinishDetailActivity.this,ZhuanDaiGouActivity.class);
                        startActivity(intent);
                        break;
                    case 2:

                        break;
                    case 3:
                        itemsDialogFragment.dismiss();
                        break;

                }
            }
        }, getSupportFragmentManager());
    }
}
