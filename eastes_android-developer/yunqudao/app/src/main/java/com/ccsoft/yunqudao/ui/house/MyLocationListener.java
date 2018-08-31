package com.ccsoft.yunqudao.ui.house;

import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;

public class MyLocationListener implements BDLocationListener {
    public static String addr;
    public static String city;
    public static String city_code;
    @Override
    public void onReceiveLocation(BDLocation location) {

//         addr = location.getAddrStr();    //获取详细地址信息
//        String country = location.getCountry();    //获取国家
//        String province = location.getProvince();    //获取省份
//         city = location.getCity();    //获取城市
//        String district = location.getDistrict();    //获取区县
//        String street = location.getStreet();
//        city_code = location.getCityCode();
//        Log.e("cccccw",city+" "+city_code);
    }


}
