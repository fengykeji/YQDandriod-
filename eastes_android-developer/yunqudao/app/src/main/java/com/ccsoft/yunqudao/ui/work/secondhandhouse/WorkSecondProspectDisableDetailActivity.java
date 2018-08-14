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
    private TextView work_commend_phonenumber;
    private Button tv_shensu;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_second_prospect_disable_details);
        initView();
//        initData();
    }

    private void initView() {

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
}
