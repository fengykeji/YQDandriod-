package com.ccsoft.yunqudao.ui.work.secondhandhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ProspectBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

public class WorkSecondProspectDisableDetailActivity extends AppCompatActivity {

    private TextView mDisableType;
    private TextView mDisableDescribe;
    private TextView mDisableTime;
    private TextView work_commend_number;
    private TextView work_commend_time;
    private TextView work_commend_people;
    private TextView work_commend_tel;
    private TextView work_commend_project;
    private TextView work_commend_project_address;
    private TextView work_commend_client_name;
    private TextView work_commend_client_sex;
    private TextView work_commend_client_tel;
    private int      id;
    private TextView date_day;
    private TextView date_hour;
    private TextView date_minute;
    private TextView date_seconds;
    private TextView work_qiangdan_time;
    private TextView work_commend_jingjiren;
    private TextView work_commend_phonenumber,work_commend_disable_type,work_commend_disable_describe
            ,work_commend_disable_time;
    private Button tv_shensu;

    private int survey_id;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_second_prospect_disable_details);
        initView();
        initData();
    }

    private void initView() {

        survey_id = getIntent().getIntExtra("survey_id",0);

        ImageButton back = findViewById(R.id.work_button_back);
        mDisableType = findViewById(R.id.work_commend_disable_type);
        mDisableDescribe = findViewById(R.id.work_commend_disable_describe);
        mDisableTime = findViewById(R.id.work_commend_disable_time);
        work_commend_number = findViewById(R.id.work_commend_number);
        work_commend_time = findViewById(R.id.work_commend_time);
        work_commend_people = findViewById(R.id.work_commend_people);
        work_commend_tel = findViewById(R.id.work_commend_tel);
        work_commend_project = findViewById(R.id.work_commend_project);
        work_commend_project_address = findViewById(R.id.work_commend_project_address);
        work_commend_client_name = findViewById(R.id.work_commend_client_name);
        work_commend_client_sex = findViewById(R.id.work_commend_client_sex);
        work_commend_client_tel = findViewById(R.id.work_commend_client_tel);
        date_day = findViewById(R.id.date_day);
        date_hour = findViewById(R.id.date_hour);
        date_minute = findViewById(R.id.date_minute);
        date_seconds = findViewById(R.id.date_seconds);
        work_qiangdan_time = findViewById(R.id.work_qiangdan_time);
        work_commend_jingjiren = findViewById(R.id.work_commend_jingjiren);
        work_commend_phonenumber = findViewById(R.id.work_commend_phonenumber);
        work_commend_disable_type = findViewById(R.id.work_commend_disable_type);
        work_commend_disable_describe = findViewById(R.id.work_commend_disable_describe);
        work_commend_disable_time = findViewById(R.id.work_commend_disable_time);
        tv_shensu = findViewById(R.id.tv_shensu);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tv_shensu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkSecondProspectDisableDetailActivity.this,WorkSecondShenSuActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData(){
        OkHttpUtils.get(HttpAdress.surveyDisabledDetail)
                .tag(this)
                .params("survey_id",survey_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        ProspectBean bean = JsonUtil.jsonToEntity(s,ProspectBean.class);
                        if(bean.getCode() == 200){
                            work_commend_disable_type.setText(bean.getData().getDisabled_state());
                            work_commend_disable_describe.setText(bean.getData().getDisabled_reason());
                            work_commend_disable_time.setText(bean.getData().getDisabled_time());
                            work_qiangdan_time.setText(bean.getData().getSurvey_time());
                            work_commend_jingjiren.setText(bean.getData().getAgent_tel());
                            work_commend_phonenumber.setText(bean.getData().getAgent_name());
                            work_commend_number.setText(survey_id+"");
                            work_commend_time.setText(bean.getData().getStore_name());
                            work_commend_people.setText(bean.getData().getName());
                            if(bean.getData().getSex() == 1){
                                work_commend_tel.setText("男");
                            }else if(bean.getData().getSex() == 2){
                                work_commend_tel.setText("女");
                            }
                            work_commend_project.setText(bean.getData().getCard_id());
                            work_commend_project_address.setText(bean.getData().getTel());
                            work_commend_client_name.setText(bean.getData().getReport_type());
                            work_commend_client_sex.setText(bean.getData().getRecord_time());
                            work_commend_client_tel.setText(bean.getData().getComment());
                        }
                    }
                });
    }
}
