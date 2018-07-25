package com.ccsoft.yunqudao.ui.house;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.BuildInfoBean;
import com.ccsoft.yunqudao.bean.HouseListBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.MalformedURLException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/10 0010
 */

public class ProjectJiChuXinXiActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mHouse_button_返回;
    private int project_id;
    private BuildInfoBean infoBean;
    private TextView tv_project_name,tv_sale_state,tv_kaifashang,tv_absolute_address,
            tv_sheji,tv_property_area,tv_shoulouchu,tv_jianzuleixing,tv_average_price,
            tv_price_area,tv_area,tv_zhuangxiubiaozhun,tv_jianzumianzhi,tv_rongjilv,
            tv_lvhualv,tv_huihuanum,tv_huihuachehua,tv_wuyeleixing,tv_wuyegongsi,
            tv_wuyefei,tv_gongnuanfangshi,tv_gongshuifangshi,tv_gongdianfangshi;
    private LinearLayout ll_yushou,ll_fazhengtime;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_house_project_loupanxinxi);
        initView();
        initListener();
        initData();

    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ProjectJiChuXinXiActivity.class);
        context.startActivity(intent);
    }

    private void initView() {

        /**
         * 初始化
         */
        mHouse_button_返回 = findViewById(R.id.house_button_返回);
        tv_project_name = findViewById(R.id.tv_project_name);
        tv_sale_state = findViewById(R.id.tv_sale_state);
        tv_kaifashang = findViewById(R.id.tv_kaifashang);
        tv_absolute_address = findViewById(R.id.tv_absolute_address);
        tv_sheji = findViewById(R.id.tv_sheji);
        tv_property_area = findViewById(R.id.tv_property_area);
        tv_shoulouchu = findViewById(R.id.tv_shoulouchu);
        tv_jianzuleixing = findViewById(R.id.tv_jianzuleixing);
        tv_average_price = findViewById(R.id.tv_average_price);
        tv_price_area = findViewById(R.id.tv_price_area);
        tv_area = findViewById(R.id.tv_area);
        tv_zhuangxiubiaozhun = findViewById(R.id.tv_zhuangxiubiaozhun);
        tv_jianzumianzhi = findViewById(R.id.tv_jianzumianzhi);
        tv_rongjilv = findViewById(R.id.tv_rongjilv);
        tv_lvhualv = findViewById(R.id.tv_lvhualv);
        tv_huihuanum = findViewById(R.id.tv_huihuanum);
        tv_huihuachehua = findViewById(R.id.tv_huihuachehua);
        tv_wuyeleixing = findViewById(R.id.tv_wuyeleixing);
        tv_wuyegongsi = findViewById(R.id.tv_wuyegongsi);
        tv_wuyefei = findViewById(R.id.tv_wuyefei);
        tv_gongnuanfangshi = findViewById(R.id.tv_gongnuanfangshi);
        tv_gongshuifangshi = findViewById(R.id.tv_gongshuifangshi);
        tv_gongdianfangshi = findViewById(R.id.tv_gongdianfangshi);
        ll_yushou = findViewById(R.id.ll_yushou);
        ll_fazhengtime = findViewById(R.id.ll_fazhengtime);

        project_id = getIntent().getIntExtra("project_id",0);

    }

    private void initListener() {

        /**
         * 初始化
         */
        mHouse_button_返回.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.house_button_返回:
                finish();
                break;
        }
    }

    private void initData(){
        OkHttpManager.getInstance().get(HttpAdress.BUILDINFO + "?project_id=" + project_id,
                new BaseCallBack() {
                    @Override
                    public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {
                        Type type = new TypeToken<BuildInfoBean>() {}.getType();
                        infoBean = new Gson().fromJson(obj.toString(),type);
                        if(infoBean.getCode()==200&&infoBean.getData()!=null){

                            if(infoBean.getData().getProject_name()==null){
                                tv_project_name.setText("暂无数据");
                            }else {
                                tv_project_name.setText(infoBean.getData().getProject_name());
                            }
                            if(infoBean.getData().getSale_state()==null){
                                tv_sale_state.setText("暂无数据");
                            }else {
                                tv_sale_state.setText(infoBean.getData().getSale_state());
                            }
                            if(infoBean.getData().getDeveloper_name() == null){
                                tv_kaifashang.setText("暂无数据");
                            }else {
                                tv_kaifashang.setText(infoBean.getData().getDeveloper_name());
                            }
                            tv_absolute_address.setText(infoBean.getData().getProvince_name()+"-"+
                            infoBean.getData().getCity_name()+"-"+infoBean.getData().getDistrict_name());
                            if(infoBean.getData().getDecoration_company().equals("")){
                                tv_sheji.setText("暂无数据");
                            }else {
                                tv_sheji.setText(infoBean.getData().getDecoration_company());
                            }
                            if(infoBean.getData().getAbsolute_address() == null){
                                tv_property_area.setText("暂无数据");
                            }else {
                                tv_property_area.setText(infoBean.getData().getAbsolute_address());
                            }
                            if(infoBean.getData().getSale_address() == null){
                                tv_shoulouchu.setText("暂无数据");
                            }else {
                                tv_shoulouchu.setText(infoBean.getData().getSale_address());
                            }
                            if(infoBean.getData().getBuild_type() == null){
                                tv_jianzuleixing.setText("暂无数据");
                            }else {
                                tv_jianzuleixing.setText(infoBean.getData().getBuild_type());
                            }
                            if(infoBean.getData().getAverage_price() == 0){
                                tv_average_price.setText("暂无数据");
                            }else {
                                tv_average_price.setText(infoBean.getData().getAverage_price() + "/㎡");
                            }
                            tv_price_area.setText(infoBean.getData().getMin_price()+"万"+"-"+
                            infoBean.getData().getMax_price()+"万");
                            if(infoBean.getData().getFloor_space() == 0){
                                tv_area.setText("暂无数据");
                            }else {
                                tv_area.setText(infoBean.getData().getFloor_space() + "㎡");
                            }
                            if(infoBean.getData().getDecoration_standard() == null){
                                tv_zhuangxiubiaozhun.setText("暂无数据");
                            }else {
                                tv_zhuangxiubiaozhun.setText(infoBean.getData().getDecoration_standard());
                            }
                            tv_jianzumianzhi.setText(infoBean.getData().getCovered_area()+"㎡");
                            tv_rongjilv.setText(infoBean.getData().getPlot_retio()+"");
                            tv_lvhualv.setText(infoBean.getData().getGreening_rate()+"5");
                            tv_huihuanum.setText(infoBean.getData().getHouseholds_num()+"");
                            tv_huihuachehua.setText(infoBean.getData().getParking_num()+"");
                            if (infoBean.getData().getProperty() != null) {
                                String need_tags = null;
                                for (int i = 0; i < infoBean.getData().getProperty().size(); i++) {
                                    String id = infoBean.getData().getProperty().get(i);
                                    if (i == 0) {
                                        need_tags = String.valueOf(infoBean.getData().getProperty().get(i));
                                    } else {
                                        need_tags = need_tags.concat("," + String.valueOf(id));
                                    }
                                }
                                tv_wuyeleixing.setText(need_tags);
                            }
                            if(infoBean.getData().getProperty_company_name() == null){
                                tv_wuyegongsi.setText("暂无数据");
                            }else {
                                tv_wuyegongsi.setText(infoBean.getData().getProperty_company_name());
                            }
                            tv_wuyefei.setText(infoBean.getData().getProperty_cost()+"元/㎡/元");

                            if(infoBean.getData().getHeat_supply().equals("")){
                                tv_gongnuanfangshi.setText("暂无数据");
                            }else {
                                tv_gongnuanfangshi.setText(infoBean.getData().getHeat_supply());
                            }
                            if(infoBean.getData().getWater_supply().equals("")){
                                tv_gongshuifangshi.setText("暂无数据");
                            }else {
                                tv_gongshuifangshi.setText(infoBean.getData().getWater_supply());
                            }
                            if(infoBean.getData().getPower_supply().equals("")){
                                tv_gongdianfangshi.setText("暂无数据");
                            }else {
                                tv_gongdianfangshi.setText(infoBean.getData().getPower_supply());
                            }
                            if(infoBean.getData().getSale_permit().size()!=0){
                                for (BuildInfoBean.DataBean.SalePermitBean salePermitBean : infoBean.getData().getSale_permit()) {
                                    TextView textView = new TextView(ProjectJiChuXinXiActivity.this);
                                    TextView textView2 = new TextView(ProjectJiChuXinXiActivity.this);
                                    textView.setText(salePermitBean.getSale_permit());
                                    textView2.setText(salePermitBean.getPermit_time());
                                    ll_yushou.addView(textView);
                                    ll_fazhengtime.addView(textView2);

                                }
                            }

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
}

