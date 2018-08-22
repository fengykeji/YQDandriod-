package com.ccsoft.yunqudao.ui.fragment;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.ui.adapter.HouseProjectFragmentPagerAdapter;
import com.ccsoft.yunqudao.ui.customers.OpenCityActivity;
import com.ccsoft.yunqudao.ui.house.CustomViewPager;
import com.ccsoft.yunqudao.ui.house.MyLocationListener;
import com.ccsoft.yunqudao.ui.house.ProjectFenXiFragment;
import com.ccsoft.yunqudao.ui.house.ProjectXiangQingFragment;
import com.ccsoft.yunqudao.ui.house.ProjectYongJinFragment;
import com.ccsoft.yunqudao.ui.house.secondhandhouse.SecondHouseFenXiFragment;
import com.ccsoft.yunqudao.ui.house.secondhandhouse.SecondHouseListActivity;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.ItemsDialogFragment;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

public class AllHouseFragment extends Fragment implements View.OnClickListener {

    private View           mView;
    public CustomViewPager mHouse_viewpager_分类;
    private List<Fragment> mList = new ArrayList<>();
    private HouseProjectFragmentPagerAdapter mHouseProjectFragmentPagerAdapter;
    private AllHouseFragment allHouseFragment;
    private TextView house_text_housetype,house_text_城市;
    private String city_name = "成都",city_code = 510100+"";

    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();

    private Handler handler,handler1;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * 填充布局
         */
        SDKInitializer.initialize(getActivity().getApplicationContext());
        mView = inflater.inflate(R.layout.fragment_allhouse, container, false);
        HideIMEUtil.wrap(getActivity());
        allHouseFragment = new AllHouseFragment();
        mLocationClient = new LocationClient(getActivity().getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        requestPower();
        initView();
        initListener();

        return mView;
    }

    private void initView(){

        LocationClientOption option = new LocationClientOption();

        option.setIsNeedAddress(true);
//可选，是否需要地址信息，默认为不需要，即参数为false
//如果开发者需要获得当前点的地址信息，此处必须为true

        mLocationClient.setLocOption(option);
        mLocationClient.start();

        handler = new Handler(){
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                city_name = (String) msg.obj;

            }};
        handler1 = new Handler(){
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                city_code = (String) msg.obj;

            }};



        mHouse_viewpager_分类 = mView.findViewById(R.id.house_viewpager_分类);
        house_text_housetype = mView.findViewById(R.id.house_text_housetype);
        house_text_城市 = mView.findViewById(R.id.house_text_城市);
        mList = new ArrayList<>();
        mList.add(new HouseFragment());
        mList.add(new SecondHouseListActivity());

        if( getActivity().getIntent().getStringExtra("city_name")!=null) {
            city_name = getActivity().getIntent().getStringExtra("city_name");
            city_code = getActivity().getIntent().getStringExtra("city_code");

        }
        house_text_城市.setText(city_name);

        mHouse_viewpager_分类.setScanScroll(false);
        mHouseProjectFragmentPagerAdapter = new HouseProjectFragmentPagerAdapter(getFragmentManager(), mList);
        mHouse_viewpager_分类.setAdapter(mHouseProjectFragmentPagerAdapter);
        //初始化显示第一个页面
        mHouse_viewpager_分类.setCurrentItem(0);
    }

    private void initListener(){
        house_text_housetype.setOnClickListener(this);
        house_text_城市.setOnClickListener(this);
    }


    public void showItemsDialogFragment() {
        ItemsDialogFragment itemsDialogFragment = new ItemsDialogFragment();
        String[] items = {"新房", "二手房","租房","取消" };
        itemsDialogFragment.show("", items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        mHouse_viewpager_分类.setCurrentItem(0);
                        house_text_housetype.setText("新房");
                        break;
                    case 1:
                        mHouse_viewpager_分类.setCurrentItem(1);
                        house_text_housetype.setText("二手房");
                        break;
                    case 2:

                        break;
                    case 3:
                        itemsDialogFragment.dismiss();
                        break;

                }
            }
        }, getFragmentManager());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.house_text_housetype:
                showItemsDialogFragment();
                break;
            case R.id.house_text_城市:
                Intent intent = new Intent(getContext(), OpenCityActivity.class);
                intent.putExtra("id",1);
                startActivity(intent);
                break;
        }
    }

    public void requestPower() {
        //判断是否已经赋予权限
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            //如果应用之前请求过此权限但用户拒绝了请求，此方法将返回 true。
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {//这里可以写个对话框之类的项向用户解释为什么要申请权限，并在对话框的确认键后续再次申请权限
            } else {
                //申请权限，字符串数组内是一个或多个要申请的权限，1是申请权限结果的返回参数，在onRequestPermissionsResult可以得知申请结果
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,}, 1);
            }
        }
    }

    class MyLocationListener implements BDLocationListener {
        public String addr;
        public String city;
        public String city_code;

        @Override
        public void onReceiveLocation(BDLocation location) {

            addr = location.getAddrStr();    //获取详细地址信息
            String country = location.getCountry();    //获取国家
            String province = location.getProvince();    //获取省份
            city = location.getCity();    //获取城市
            String district = location.getDistrict();    //获取区县
            String street = location.getStreet();
            city_code = location.getCityCode();


            Message message = handler.obtainMessage();
            message.obj = city;
            handler.sendMessage(message);

            Message message1 = handler1.obtainMessage();
            message1.obj = city_code;
            handler1.sendMessage(message1);

        }


    }

}


