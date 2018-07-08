package com.ccsoft.yunqudao.ui.house;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.cloud.CloudRgcResult;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.LogoPosition;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.map.offline.MKOLSearchRecord;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.search.poi.PoiSortType;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.adapter.HouseHuXing_RecyclerViewAdapter;
import com.ccsoft.yunqudao.adapter.Speed2HourAdapter;
import com.ccsoft.yunqudao.adapter.SpeedHourAdapter;
import com.ccsoft.yunqudao.adapter.TestAdapter;
import com.ccsoft.yunqudao.bean.HouseDetailBean;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.bean.ProjectPiPeiKeHuBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.ImageUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.ccsoft.yunqudao.utils.SpUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class ProjectXiangQingFragment extends Fragment implements View.OnClickListener, OnPageChangeListener {

    private View                     mView;
    private ProjectXiangQingFragment mProjectXiangQingFragment;
    private ImageView              mHouse_imageview_项目图册;
    private Button              mHouse_button_查看全部楼盘信息;
    private Button              mHouse_button_查看全部项目动态;
    private ImageView               mHouse_imageview_楼栋信息;
    private Button              mHouse_button_查看全部户型信息;
    private ViewPager                mHouse_viewpager_户型信息;
    private Button                   mHouse_button_教育;
    private Button                   mHouse_button_交通;
    private Button                   mHouse_button_医院;
    private Button                   mHouse_button_购物;
    private Button                   mHouse_button_餐饮;
    private Button              mHouse_button_查看更多推荐;
    private Button                   mHouse_button_推荐1;
    private Button                   mHouse_button_推荐2;
    private Button                   mHouse_button_电话咨询;
    private Button                   mHouse_button_推荐3;
    private TextView tv_project_name,tv_sale_state,tv_num,tv_handing_room_time,tv_average_price,
            tv_absolute_address,content_tv6,content_tv7,content_tv8,content_tv9,content_tv10,content_tv11,
            content_tv12,content_tv13,tv_loupanxiangqing,tv_shuzi;
    private LinearLayout ll_dongtaixiangqing,ll_pipeikehu1,ll_pipeikehu2,linearLayout,linearLayout1;
    private ViewPager viewPager;
    private ImageButton button;
    private ScrollView scrollView;
    private int project_id;
    private OkHttpManager okHttpManager = OkHttpManager.getInstance();
    private HouseDetailBean houseDetailBean;
    private HouseHuXing_RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    protected Context mContext;
    protected View contentView;
    protected AtomicBoolean isPreparingData;
    private SpeedHourAdapter speedHourAdapter=null;
    private TestAdapter madapter;
    private List list;
//    private SpeedHourEntity entity=null;
    private int agent_id;
    private HouseDetailBean.DataBean bean;

    private List<HouseDetailBean.DataBean.HouseTypeBean> dataList = new ArrayList<>();

    private MapView mapView;
    private BaiduMap baiduMap;
    private PoiSearch mPoiSearch;


    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView .onDestroy();
        baiduMap.setMyLocationEnabled(false);
    }


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SDKInitializer.initialize(getContext().getApplicationContext());

        mView = inflater.inflate(R.layout.fragment_house_xiangmuxiangqing_xiangmu, container, false);
        initView();
        initData();
        initListener();
        setData();
        return mView;
    }


    private void initView() {
        /**
         * 初始化id
         */
//        mHouse_imageview_项目图册 = mView.findViewById(R.id.house_imageview_项目图册);
        viewPager = mView.findViewById(R.id.viewPager);
        mHouse_button_查看全部楼盘信息 = mView.findViewById(R.id.house_button_查看全部楼盘信息);
        mHouse_button_查看全部项目动态 = mView.findViewById(R.id.house_button_查看全部项目动态);
        mHouse_imageview_楼栋信息 = mView.findViewById(R.id.house_imageview_楼栋信息);
        mHouse_viewpager_户型信息 = mView.findViewById(R.id.house_viewpager_户型信息);
        mHouse_button_查看全部户型信息 = mView.findViewById(R.id.house_button_查看全部户型信息);

        mHouse_button_教育 = mView.findViewById(R.id.house_button_教育);
        mHouse_button_交通 = mView.findViewById(R.id.house_button_交通);
        mHouse_button_医院 = mView.findViewById(R.id.house_button_医院);
        mHouse_button_购物 = mView.findViewById(R.id.house_button_购物);
        mHouse_button_餐饮 = mView.findViewById(R.id.house_button_餐饮);

        mHouse_button_查看更多推荐 = mView.findViewById(R.id.house_button_查看更多推荐);
        mHouse_button_推荐1 = mView.findViewById(R.id.house_button_推荐1);
        mHouse_button_推荐2 = mView.findViewById(R.id.house_button_推荐2);
        mHouse_button_电话咨询 = mView.findViewById(R.id.house_button_电话咨询);
        mHouse_button_推荐3 = mView.findViewById(R.id.house_button_推荐3);
        button = mView.findViewById(R.id.im_dianzan);

        tv_project_name = mView.findViewById(R.id.tv_project_name);
        tv_sale_state = mView.findViewById(R.id.tv_sale_state);
        tv_num = mView.findViewById(R.id.tv_num);
        tv_handing_room_time = mView.findViewById(R.id.tv_handing_room_time);
        tv_average_price = mView.findViewById(R.id.tv_average_price);
        tv_absolute_address = mView.findViewById(R.id.tv_absolute_address);
        content_tv6 = mView.findViewById(R.id.content_tv6);
        content_tv7 = mView.findViewById(R.id.content_tv7);
        content_tv8 = mView.findViewById(R.id.content_tv8);
        content_tv9 = mView.findViewById(R.id.content_tv9);
        content_tv10 = mView.findViewById(R.id.content_tv10);
        content_tv11 = mView.findViewById(R.id.content_tv11);
        content_tv12 = mView.findViewById(R.id.content_tv12);
        content_tv13 = mView.findViewById(R.id.content_tv13);
        tv_loupanxiangqing = mView.findViewById(R.id.tv_loupanxiangqing);
        ll_dongtaixiangqing = mView.findViewById(R.id.ll_dongtaixiangqing);
        ll_pipeikehu1 = mView.findViewById(R.id.ll_pipeikehu1);
        ll_pipeikehu2 = mView.findViewById(R.id.ll_pipeikehu2);
        tv_shuzi = mView.findViewById(R.id.tv_shuzi);
        scrollView = mView.findViewById(R.id.scrollView);
        linearLayout = mView.findViewById(R.id.ll_property);
        linearLayout1 = mView.findViewById(R.id.ll_project_tags);

        recyclerView = mView.findViewById(R.id.re_huxing);

        mapView =  mView.findViewById(R.id.mmap);
        baiduMap = mapView.getMap();




        mapView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    scrollView.requestDisallowInterceptTouchEvent(true);
                } else {
                    scrollView.requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
            });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);




        /**
         * 接受上个页面传过来的值
         */
        project_id = getActivity().getIntent().getIntExtra("project_id",0);
        agent_id = SpUtil.getInt("agent_id",0);

    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        this.viewPager.setOnClickListener(this);
        this.mHouse_button_查看全部楼盘信息.setOnClickListener(this);
        this.mHouse_button_查看全部项目动态.setOnClickListener(this);
        this.mHouse_imageview_楼栋信息.setOnClickListener(this);
        this.mHouse_button_查看全部户型信息.setOnClickListener(this);
        this.mHouse_button_教育.setOnClickListener(this);
        this.mHouse_button_交通.setOnClickListener(this);
        this.mHouse_button_医院.setOnClickListener(this);
        this.mHouse_button_购物.setOnClickListener(this);
        this.mHouse_button_餐饮.setOnClickListener(this);
        this.mHouse_button_查看更多推荐.setOnClickListener(this);
        this.mHouse_button_推荐1.setOnClickListener(this);
        this.mHouse_button_推荐2.setOnClickListener(this);
        this.mHouse_button_电话咨询.setOnClickListener(this);
        this.mHouse_button_推荐3.setOnClickListener(this);
        this.tv_loupanxiangqing.setOnClickListener(this);
        this.ll_dongtaixiangqing.setOnClickListener(this);
        this.button.setOnClickListener(this);
        this.tv_absolute_address.setOnClickListener(this);

        isPreparingData = new AtomicBoolean(false);
        ButterKnife.bind(getActivity());
    }

    public void onClick(View v) {

        switch (v.getId()) {
//            case R.id.viewPager:
//                ProjectXiangCeActivity.start(getActivity());
//                break;
            case R.id.house_button_查看全部楼盘信息:
                ProjectJiChuXinXiActivity.start(getActivity());
                break;
            case R.id.house_button_查看全部项目动态:
                Intent intent1 = new Intent(getContext(),ProjectDongLieBiaoActivity.class);
                intent1.putExtra("project_id",project_id);
                startActivity(intent1);
                break;
            case R.id.house_imageview_楼栋信息:
                ProjectLouDongXiangQingActivity.start(getActivity());
                break;
            case R.id.house_button_查看全部户型信息:
                ProjectHuXingXiangQingActivity.start(getActivity());
                break;
            case R.id.house_button_教育:
                sreach("教育",R.drawable.ic_baidujiaoyu);
                break;
            case R.id.house_button_交通:
                sreach("交通",R.drawable.ic_baidujiaotong);
                break;
            case R.id.house_button_医院:
                sreach("医院",R.drawable.ic_baiduyiyuan);
                break;
            case R.id.house_button_购物:
                sreach("购物",R.drawable.ic_baidugouwu);
                break;
            case R.id.house_button_餐饮:
                sreach("餐饮",R.drawable.ic_baiducanyin);
                break;
            case R.id.house_button_查看更多推荐:
                ProjectPiPeiKeHuActivity.start(getActivity());
                break;
            case R.id.house_button_推荐1:
                Toast.makeText(getActivity(), "你推荐了该户型", Toast.LENGTH_SHORT).show();
                break;
            case R.id.house_button_推荐2:
                Toast.makeText(getActivity(), "你推荐了该户型", Toast.LENGTH_SHORT).show();
                break;
            case R.id.house_button_电话咨询:
                //String number = mHouse_text_客户联系电话.getText().toString();
                //Intent intent = new Intent();
                //intent.setAction(Intent.ACTION_CALL);
                //intent.setData(Uri.parse("tel:"+number));
                //startActivity(intent);
                Toast.makeText(getActivity(), "你拨打了电话", Toast.LENGTH_SHORT).show();
                break;
            case R.id.house_button_推荐3:

                break;
            case R.id.tv_loupanxiangqing:
                Intent intent = new Intent(getContext(),ProjectJiChuXinXiActivity.class);
                intent.putExtra("project_id",project_id);
                startActivity(intent);
                break;
            case R.id.im_dianzan:
                if(bean.getFocus().getIs_focus()==0) {
                    OkHttpUtils.get(HttpAdress.focusProject)
                            .tag(getActivity())
                            .params("project_id", project_id)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    StringModel model = JsonUtil.jsonToEntity(s, StringModel.class);
                                    if (model.getCode() == 200) {
                                        Toast.makeText(getContext(), "关注成功", Toast.LENGTH_SHORT).show();
                                        button.setImageResource(R.drawable.ic_focus_selected);
                                        initData();
                                    }
                                    Toast.makeText(getContext(), model.getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }else {
                    OkHttpUtils.get(HttpAdress.cancelFocusProject)
                            .tag(getActivity())
                            .params("project_id", project_id)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    StringModel model = JsonUtil.jsonToEntity(s, StringModel.class);
                                    if (model.getCode() == 200) {
                                        Toast.makeText(getContext(), "取消关注成功", Toast.LENGTH_SHORT).show();
                                        button.setImageResource(R.drawable.ic_focus_2);
//
                                        initData();
                                    }
                                    Toast.makeText(getContext(), model.getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }
                break;
            case R.id.tv_absolute_address:
                goToGaode();
                break;

        }
    }

    //高德
    private void goToGaode() {

        StringBuffer stringBuffer = new StringBuffer("androidamap://route?sourceApplication=").append("amap");

        stringBuffer
                .append("&dname=").append(bean.getProject_basic_info().getAbsolute_address())
                .append("&dev=").append(0)
                .append("&t=").append(0);

        Intent intent = new Intent("android.intent.action.VIEW", android.net.Uri.parse(stringBuffer.toString()));
        intent.setPackage("com.autonavi.minimap");
        startActivity(intent);
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

    private void initData(){

        OkHttpUtils.get(HttpAdress.HOUSEDETAIL)
                .tag(getActivity())
                .params("project_id",project_id)
                .params("agent_id",agent_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        int code = 0;
                        String data = null;
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            code = jsonObject.getInt("code");
                            data = jsonObject.getString("data");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if(code == 200&& data!=null){
                            GsonBuilder builder = new GsonBuilder();
                            Gson gson = builder.create();
                             bean = gson.fromJson(data,HouseDetailBean.DataBean.class);
                             dataList = bean.getHouse_type();
                            initAdapter();

//                            ImageUtil.load(Uri.parse(AppConstants.URL + bean.getProject_basic_info().getTotal_float_url_phone()), mHouse_imageview_项目图册, 540, 275);
                            tv_project_name.setText(bean.getProject_basic_info().getProject_name());
                            tv_sale_state.setText(bean.getProject_basic_info().getSale_state());
                            tv_num.setText(bean.getFocus().getNum() + "");
                            tv_handing_room_time.setText(bean.getProject_basic_info().getDeveloper_name());
                            tv_average_price.setText(bean.getProject_basic_info().getAverage_price() + "/m2");
                            tv_absolute_address.setText(bean.getProject_basic_info().getAbsolute_address());
                            content_tv6.setText(bean.getProject_basic_info().getDeveloper_name());
                            content_tv7.setText(bean.getBuild_info().getOpen_time());
                            content_tv8.setText(bean.getBuild_info().getHanding_room_time());
                            content_tv10.setText("共"+bean.getDynamic().getCount()+"条");
                            content_tv11.setText(bean.getDynamic().getFirst().getTitle());
                            content_tv13.setText(bean.getDynamic().getFirst().getAbstracts());
                            content_tv12.setText(bean.getDynamic().getFirst().getCreate_time());
                            if(bean.getFocus().getIs_focus()==1){
                                button.setImageResource(R.drawable.ic_focus_selected);
                            }else {
                                button.setImageResource(R.drawable.ic_focus_2);
                            }
                            Picasso.with(getContext())
                                    .load(AppConstants.URL+bean.getProject_basic_info().getTotal_float_url_phone())
                                    .into(mHouse_imageview_楼栋信息);

                            List<HouseDetailBean.DataBean.ProjectImgBean.UrlBean> Imgurl = bean.getProject_img().getUrl();
                            madapter = new TestAdapter(getContext(),Imgurl,project_id);
                            viewPager.setAdapter(madapter);
                            madapter.change(Imgurl);
                            if(Imgurl.size()==0) {
                                tv_shuzi.setText("0/0");
                            }else {
                                tv_shuzi.setText("1/"+Imgurl.size());
                                viewPager.setOnPageChangeListener(new OnPageChangeListener() {
                                    @Override
                                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                                    }

                                    @Override
                                    public void onPageSelected(int position) {
                                        tv_shuzi.setText(position + 1 + "/" + Imgurl.size());
                                    }

                                    @Override
                                    public void onPageScrollStateChanged(int state) {

                                    }
                                });
                            }

                            /**
                             * 设置标签
                             */

                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            layoutParams.leftMargin = 16;
                            layoutParams.topMargin = 16;
                            layoutParams.bottomMargin = 16;
                            linearLayout.removeAllViews();
                            linearLayout1.removeAllViews();
                            PeizhiBean peizhiBean = MainActivity.savePeizhi();
                            peizhiBean.getData().get_$16().getParam();
                            peizhiBean.getData().get_$15().getParam();

                            ImageView imageView;
                            if (bean.getProject_basic_info().getProperty_type().size() > 0) {
                                linearLayout.removeAllViews();
                                for (int j = 0; j < bean.getProject_basic_info().getProperty_type().size(); j++) {
                                    if(true) {
                                        imageView = new ImageView(getContext());
                                        if (bean.getProject_basic_info().getProperty_type().get(j).equals("住宅")) {
                                            imageView.setImageResource(R.drawable.ic_residential2);
                                            linearLayout.addView(imageView, layoutParams);
                                        } else if (bean.getProject_basic_info().getProperty_type().get(j).equals("公寓")) {
                                            imageView.setImageResource(R.drawable.ic_apartment);
                                            linearLayout.addView(imageView, layoutParams);
                                        } else if (bean.getProject_basic_info().getProperty_type().get(j).equals("别墅")) {
                                            imageView.setImageResource(R.drawable.ic_officebuilding);
                                            linearLayout.addView(imageView, layoutParams);
                                        } else if (bean.getProject_basic_info().getProperty_type().get(j).equals("商铺")) {
                                            imageView.setImageResource(R.drawable.ic_shops);
                                            linearLayout.addView(imageView, layoutParams);
                                        } else if (bean.getProject_basic_info().getProperty_type().get(j).equals("写字楼")) {
                                            imageView.setImageResource(R.drawable.ic_villa);
                                            linearLayout.addView(imageView, layoutParams);
                                        }
                                    }
                                }
                            }


                            String ss = bean.getProject_basic_info().getProject_tags();
                            if (TextUtils.isEmpty(ss)) {
                                return;
                            }
                            String[] b = ss.split(",");


                            List<PeizhiBean.DataBean._$15Bean.ParamBeanXXXXXXXXXXXXXX> list = peizhiBean.getData().get_$15().getParam();
                            for (String s1 : b) {
                                for (PeizhiBean.DataBean._$15Bean.ParamBeanXXXXXXXXXXXXXX bean3 : list) {
                                    if(bean3.getId()==Integer.parseInt(s1)){
                                        TextView textView = new TextView(getContext());
                                        textView.setText(bean3.getParam());
                                        textView.setBackgroundResource(R.drawable.shape_laber);
                                        textView.setPadding(10,1,10,1);
                                        linearLayout1.addView(textView,layoutParams);
                                    }
                                }
                            }



                            location();

                        }
                    }
                });
//        getPiPeiKeHu();

    }


    private void initAdapter() {
        speedHourAdapter=new SpeedHourAdapter(getContext(),dataList);
        recyclerView.setAdapter(speedHourAdapter);




        speedHourAdapter.setOnItemClickListener(new SpeedHourAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {


                Intent intent = new Intent(getContext(),ProjectHuXingXiangQingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("list", (Serializable) dataList);
                intent.putExtra("id",dataList.get(position).getId());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void setData(){
        ll_dongtaixiangqing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getContext(),ProjectDongTaiXiangQingActivity.class);
                intent2.putExtra("url",bean.getDynamic().getFirst().getUrl());
                startActivity(intent2);
            }
        });
    }



    private void getPiPeiKeHu(){

        OkHttpUtils.get(HttpAdress.matchingproject)
                .tag(getActivity())
                .params("project_id",project_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        int code = 0;
                        String data = null;
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            code = jsonObject.getInt("code");
                            data = jsonObject.getString("data");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if(code == 200&& data!=null){
                             ProjectPiPeiKeHuBean piPeiKeHuBean = JsonUtil.jsonToEntity(s,ProjectPiPeiKeHuBean.class);

                        }
                    }
                });
    }


    private void location(){

        LatLng latLng = new LatLng(bean.getProject_basic_info().getLatitude(),
                bean.getProject_basic_info().getLongitude());//经纬度实例
        MapStatusUpdate updateLatLng = MapStatusUpdateFactory.newLatLng(latLng);//地图状态更新的实例
        baiduMap.setMapStatus(updateLatLng);//更新地图


        LatLng point = new LatLng(bean.getProject_basic_info().getLatitude(),
                bean.getProject_basic_info().getLongitude());

//构建Marker图标

        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.ic_baidulogo);

//构建MarkerOption，用于在地图上添加Marker

        OverlayOptions option = new MarkerOptions()
                .position(point)
                .icon(bitmap);

//在地图上添加Marker，并显示

        baiduMap.addOverlay(option);
    }



    private void sreach(String key,int drawable){


        mPoiSearch =  PoiSearch.newInstance();
        OnGetPoiSearchResultListener poiListener = new OnGetPoiSearchResultListener(){

            public void onGetPoiResult(PoiResult poiResult){
                //获取POI检索结果
                //如果搜索到的结果不为空，并且没有错误
                if (poiResult != null && poiResult.error == PoiResult.ERRORNO.NO_ERROR) {

                    PoiOverlay overlay = new PoiOverlay(baiduMap,drawable);//这传入search对象，因为一般搜索到后，点击时方便发出详细搜索

                    //设置数据,这里只需要一步，
                    overlay.setData(poiResult);
                    //添加到地图
                    overlay.addToMap();
                    //将显示视图拉倒正好可以看到所有POI兴趣点的缩放等级OverlayManager.java
                    overlay.zoomToSpan();//计算工具
                    //设置标记物的点击监听事件


                    baiduMap.setOnMarkerClickListener(overlay);
                } else {
                    Toast.makeText(getContext(), "搜索不到你需要的信息！", Toast.LENGTH_SHORT).show();
                }


            }

            public void onGetPoiDetailResult(PoiDetailResult result){
                //获取Place详情页检索结果

            }

            @Override
            public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {

            }
        };
        mPoiSearch.setOnGetPoiSearchResultListener(poiListener);

        LatLng point = new LatLng(bean.getProject_basic_info().getLatitude(),
                bean.getProject_basic_info().getLongitude());



        mPoiSearch.searchNearby(new PoiNearbySearchOption()
                .keyword(key)
                .sortType(PoiSortType.distance_from_near_to_far)
                .location(point)
                .radius(3000)
                .pageNum(10));
        mPoiSearch.destroy();

    }

}



