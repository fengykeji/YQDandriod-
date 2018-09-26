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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.CustomersGetInfoBean;
import com.ccsoft.yunqudao.bean.HouseListBean;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.model.response.ClientPrivateData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.adapter.CustomersXiangQingPagerAdapter;
import com.ccsoft.yunqudao.ui.adapter.ViewPagerAdapter;
import com.ccsoft.yunqudao.ui.home.HomeActivity;
import com.ccsoft.yunqudao.ui.mian.LoginActivity;
import com.ccsoft.yunqudao.ui.view.ViewPagerForScrollView;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LogUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;
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
    private ImageView mCustomers_button_resetclientbasic;
//    private List<ClientPrivateData.NeedInfoBean> need_info = new ArrayList<>();
    private CustomersGetInfoBean bean;
    private int need_id;
    private int needId;
    private int fid;


    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_xiangqing);

        HideIMEUtil.wrap(this);
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
        this.getArguments();
        fid = getIntent().getIntExtra("fid",0);
        addFragments();

    }

    /**
     * 请求数据
     */

    private void initData() {

        OkHttpManager.getInstance().get(HttpAdress.getInfo + "?client_id=" + mClienID, new BaseCallBack() {
            @Override
            public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {
                Type type = new TypeToken<CustomersGetInfoBean>() {}.getType();
                bean = new Gson().fromJson(obj.toString(),type);


                if(bean.getCode()==200&&bean.getData()!=null) {
                    setData(bean);

                    mCustomers_button_quick_recommend.setOnClickListener(CustomersXiangQingActivity.this);
                }
                else if(bean.getCode() == 401){
                    Intent intent = new Intent(CustomersXiangQingActivity.this, LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(CustomersXiangQingActivity.this,"token失效，请重新登陆",Toast.LENGTH_SHORT).show();
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
     * 添加Fragment
     */
    private void addFragments() {
        //int page = mCustomers_viewpager_xiangqing.getCurrentItem();
        fragments = new ArrayList<>();
        fragments.add(XuQiuXingXiFragment.newInstance());//初始化fragment  把这个Model传过去 到Fragment取里面的数据就好
        fragments.add(ClientFollowFragment.newInstance());
        fragments.add(PiPeiXinXiFragment.newInstance());
        ViewPagerAdapter adapter = new ViewPagerAdapter(fragments, getSupportFragmentManager(), this);
        mCustomers_viewpager_xiangqing.setAdapter(adapter);
        mCustomers_TabLayout.setupWithViewPager(mCustomers_viewpager_xiangqing);
        //mCustomers_viewpager_xiangqing.setCurrentItem(page);

        if(fid == 1){
            mCustomers_viewpager_xiangqing.setCurrentItem(1);
        }else if(fid == 2){
            mCustomers_viewpager_xiangqing.setCurrentItem(2);
        }else  {
            mCustomers_viewpager_xiangqing.setCurrentItem(0);
        }
        mCustomers_viewpager_xiangqing.setOffscreenPageLimit(3);
    }

    /**
     * 数据绑定
     */
    private void setData(CustomersGetInfoBean mClientPrivateData) {
        if (mClientPrivateData.getData().getBasic() != null) {
            mCustomers_text_name.setText(mClientPrivateData.getData().getBasic().getName());
            if (mClientPrivateData.getData().getBasic().getSex() ==0 ) {
                mCustomers_text_sex.setText("");
            }
            else {
                mCustomers_text_sex.setText(mClientPrivateData.getData().getBasic().getSex() ==1 ? "男" : "女");
            }
            mCustomers_text_birthday.setText(TextUtils.isEmpty(mClientPrivateData.getData().getBasic().getBirth()) ? "" : mClientPrivateData.getData().getBasic().getBirth());
            mCustomers_text_tel.setText(TextUtils.isEmpty(mClientPrivateData.getData().getBasic().getTel()) ? "" : mClientPrivateData.getData().getBasic().getTel());
            mCustomers_text_card_type.setText("身份证");
            mCustomers_text_card_id.setText(TextUtils.isEmpty(mClientPrivateData.getData().getBasic().getCard_id()) ? "" : mClientPrivateData.getData().getBasic().getCard_id());
            String address = "";
            if(mClientPrivateData.getData().getBasic().getProvince_name()!=null&&mClientPrivateData.getData().getBasic().getCity_name()!=null&&
            mClientPrivateData.getData().getBasic().getDistrict_name()!=null ) {
                address = mClientPrivateData.getData().getBasic().getProvince_name() + "-"
                        + mClientPrivateData.getData().getBasic().getCity_name() + "-" + mClientPrivateData.getData().getBasic().getDistrict_name();
            }
            mCustomers_text_address.setText(address);

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
                Intent intent3 = new Intent(this, HomeActivity.class);
                intent3.putExtra("fid",2);
                startActivity(intent3);
//                finish();
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
                Bundle bundle = new Bundle();
                bundle.putSerializable("bean",bean);

                Intent intent1 = new Intent(this,ResetClientBasicActivity.class);
                intent1.putExtras(bundle);
                startActivity(intent1);
                break;
        }
    }

    /**
     * 拿到needId
     */
    private void getInfo(){
        needId = bean.getData().getNeed_info().get(0).getNeed_id();
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
