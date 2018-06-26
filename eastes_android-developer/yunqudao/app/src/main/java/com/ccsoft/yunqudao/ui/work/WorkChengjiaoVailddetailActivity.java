package com.ccsoft.yunqudao.ui.work;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.WorkDealedDetailBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.model.response.ValueDetailData;
import com.ccsoft.yunqudao.data.model.response.WorkReportVerifyDetailData;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;

public class WorkChengjiaoVailddetailActivity extends AppCompatActivity{
    private TextView work_commend_number;
    private TextView     work_commend_time;
    private TextView     work_commend_people;
    private TextView     work_commend_tel;
    private TextView     work_commend_project;
    private TextView     work_commend_project_address;
    private TextView     work_commend_client_name;
    private TextView     work_commend_client_sex;
    private TextView     work_commend_client_tel;
    private int          id;
    private TextView     work_commend_client_name2;
    private TextView     work_commend_client_tel2;
    private TextView     work_commend_headcount;
    private TextView     work_commend_time2;
    private TextView     work_commend_counselor;
    private TextView     work_commend_verify_people;
    private TextView     work_commend_verify_people_tel;
    private TextView     work_commend_time3;
    private TextView     work_commend_arrive_time;
    private TextView     work_commend_verify_arrive_time;
    private TextView     work_commend_buy_time;
    private LinearLayout mWork_condition_linearlayout1,ll_chengjiaoxinxi;
    private LinearLayout mWork_condition_linearlayout2;
    private ImageView mWork_condition_image1;
    private ImageView    mWork_condition_image2;
    private ImageView    mWork_condition_image3;
    private LinearLayout ll_progress;
    private TextView tv_work_housenum,tv_work_totalprice,tv_work_area,tv_work_dealstata,tv_work_dealtime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_work_commend_valid_details);
        initView();
        initData();
    }




    private void initView() {

        id = getIntent().getIntExtra("id",0);
        ImageButton back = findViewById(R.id.work_button_back);
        work_commend_number = findViewById(R.id.work_commend_number);
        work_commend_time = findViewById(R.id.work_commend_time);
        work_commend_people = findViewById(R.id.work_commend_people);
        work_commend_tel = findViewById(R.id.work_commend_tel);
        work_commend_project = findViewById(R.id.work_commend_project);
        work_commend_project_address = findViewById(R.id.work_commend_project_address);
        work_commend_client_name = findViewById(R.id.work_commend_client_name);
        work_commend_client_sex = findViewById(R.id.work_commend_client_sex);
        work_commend_client_tel = findViewById(R.id.work_commend_client_tel);

        work_commend_client_name2 = findViewById(R.id.work_commend_client_name2);
        work_commend_client_tel2 = findViewById(R.id.work_commend_client_tel2);
        work_commend_headcount = findViewById(R.id.work_commend_headcount);
        work_commend_time2 = findViewById(R.id.work_commend_time2);
        work_commend_counselor = findViewById(R.id.work_commend_counselor);
        work_commend_verify_people = findViewById(R.id.work_commend_verify_people);
        work_commend_verify_people_tel = findViewById(R.id.work_commend_verify_people_tel);
        ll_chengjiaoxinxi = findViewById(R.id.ll_chengjiaoxinxi);
        tv_work_housenum = findViewById(R.id.tv_work_housenum);
        tv_work_area = findViewById(R.id.tv_work_area);
        tv_work_totalprice = findViewById(R.id.tv_work_totalprice);
        tv_work_dealstata = findViewById(R.id.tv_work_dealstata);
        tv_work_dealtime = findViewById(R.id.tv_work_dealtime);
//        work_commend_time3 = findViewById(R.id.work_commend_time3);
//        work_commend_arrive_time = findViewById(R.id.work_commend_arrive_time);
//        work_commend_verify_arrive_time = findViewById(R.id.work_commend_verify_arrive_time);
//        work_commend_buy_time = findViewById(R.id.work_commend_buy_time);
//
//        mWork_condition_linearlayout1 = findViewById(R.id.work_condition_linearlayout1);
//        mWork_condition_linearlayout2 = findViewById(R.id.work_condition_linearlayout2);
//        mWork_condition_image1 = findViewById(R.id.work_condition_image1);
//        mWork_condition_image2 = findViewById(R.id.work_condition_image2);
//        mWork_condition_image3 = findViewById(R.id.work_condition_image3);

        ll_progress = findViewById(R.id.ll_progress);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initData() {
//        ClientManager.getInstance().getDetail(id).compose(RxSchedulers.<ValueDetailData>io_main()).subscribe(new ApiSubscriber<ValueDetailData>(this) {
//            @Override
//            protected void _onNext(ValueDetailData data) {
//                if (data != null) {
//                    work_commend_number.setText(String.valueOf(data.client_id));
//                    work_commend_time.setText(data.create_time);
//                    work_commend_people.setText(data.broker_name);
//                    work_commend_tel.setText(data.broker_tel);
//                    work_commend_project.setText(data.project_name);
//                    work_commend_client_name.setText(data.name);
//                    work_commend_client_sex.setText(data.sex == 1 ? "男" : "女");
//                    work_commend_client_tel.setText(data.broker_tel);
//                    work_commend_project_address.setText(data.province_name + " " + data.city_name + " " + data.district_name);
//
//                    work_commend_client_name2.setText(data.confirm_name);
//                    work_commend_client_tel2.setText(data.confirm_tel);
//                    work_commend_headcount.setText(data.visit_num + "");
//                    work_commend_time2.setText(data.process.get(1).time);
//                    work_commend_counselor.setText(data.property_advicer_wish);
//                    work_commend_verify_people.setText(data.butter_name);
//                    work_commend_verify_people_tel.setText(data.butter_tel);
//
//                    for (int i=0;i<data.process.size();i++) {
//                        ValueDetailData.ProcessBean processBean = data.process.get(i);
//
//                        View view = getLayoutInflater().inflate(R.layout.view_process,null);
//                        TextView tv_name = view.findViewById(R.id.tv_name);
//                        TextView tv_time = view.findViewById(R.id.tv_time);
//                        ImageView image = view.findViewById(R.id.image);
//                        tv_name.setText(processBean.process_name);
//                        tv_time.setText(processBean.time);
//                        if(i==data.process.size()-1){
//                            image.setVisibility(View.INVISIBLE);
//                        }
//
//                        ll_progress.addView(view);
//                    }
//                }
//            }
//
//            @Override
//            protected void _onError(String message) {
//            }
//
//            @Override
//            protected void _onCompleted() {
//
//            }
//        });

        Map<String, String> map = new HashMap<>();
        map.put("client_id", String.valueOf(id));
        XutilsHttp.getInstance().gethesder(AppConstants.URL + "agent/work/project/waitDealDetail", map, new XutilsHttp.XCallBack() {
            @Override
            public void onResponse(String result) {
                ll_chengjiaoxinxi.setVisibility(View.VISIBLE);
                Gson gson = new Gson();
                WorkDealedDetailBean data = gson.fromJson(result, WorkDealedDetailBean.class);
                if (data != null) {
                    work_commend_number.setText(String.valueOf(data.getData().getClient_id()));
                    work_commend_time.setText(data.getData().getCreate_time());
                    work_commend_people.setText(data.getData().getBroker_name());
                    work_commend_tel.setText(data.getData().getBroker_tel());
                    work_commend_project.setText(data.getData().getProject_name());
                    work_commend_client_name.setText(data.getData().getName());
                    work_commend_client_sex.setText(data.getData().getSex() == 1 ? "男" : "女");
                    work_commend_client_tel.setText(data.getData().getBroker_tel());
                    work_commend_project_address.setText(data.getData().getProvince_name() + "-" + data.getData().getCity_name() + "-" + data.getData().getDistrict_name());
                    work_commend_headcount.setText(data.getData().getVisit_num() + "");
                    work_commend_client_name2.setText(data.getData().getConfirm_name());
                    work_commend_client_tel2.setText(data.getData().getConfirm_tel());
                    work_commend_counselor.setText(data.getData().getProperty_advicer_wish());
                    work_commend_verify_people.setText(data.getData().getButter_name());
                    work_commend_verify_people_tel.setText(data.getData().getButter_tel());
                    tv_work_housenum.setText(data.getData().getHouse_info());
                    tv_work_totalprice.setText(data.getData().getTotal_money()+"元");
                    tv_work_area.setText(data.getData().getInner_area()+"m2");
                    tv_work_dealstata.setText(data.getData().getCurrent_state());
                    tv_work_dealtime.setText(data.getData().getUpdate_time());
                    if(data.getData().getProcess()==null){
                        return;
                    }else {
                        work_commend_time2.setText(data.getData().getProcess().get(1).getTime());

                        for (int i = 0; i < data.getData().getProcess().size(); i++) {
                            WorkDealedDetailBean.DataBean.ProcessBean processBean = data.getData().getProcess().get(i);

                            View view = getLayoutInflater().inflate(R.layout.view_process, null);
                            TextView tv_name = view.findViewById(R.id.tv_name);
                            TextView tv_time = view.findViewById(R.id.tv_time);
                            ImageView image = view.findViewById(R.id.image);
                            tv_name.setText(processBean.getProcess_name());
                            tv_time.setText(processBean.getTime());
                            if (i == data.getData().getProcess().size() - 1) {
                                image.setVisibility(View.INVISIBLE);
                            }

                            ll_progress.addView(view);
                        }
                    }
                }
            }

            @Override
            public void error(String message) {

            }
        });

 }
}
