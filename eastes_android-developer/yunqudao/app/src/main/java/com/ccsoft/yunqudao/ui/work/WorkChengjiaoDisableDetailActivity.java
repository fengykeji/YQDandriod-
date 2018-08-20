package com.ccsoft.yunqudao.ui.work;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.model.response.WorkReportDisableDetailsData;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class WorkChengjiaoDisableDetailActivity extends AppCompatActivity {
    private TextView mNumTv;
    private TextView mTime_Tv;
    private TextView mTelTv;
    private TextView mProjectTv;
    private TextView mAddressTv;
    private TextView mClientNameTv;
    private TextView mClientSexTv;
    private TextView mClientTelTv;
    private TextView mClientName1Tv;
    private TextView mClientTel1Tv;
    private TextView mCountTv;
    private TextView mCounselorTv;
    private TextView mTime1Tv;
    private TextView mPeopleTv;
    private TextView mPeople_TelTv;
    private TextView mPeople1Tv;
    private TextView mDisableDescribe;
    private TextView mDisableTime;

    private TextView mDisableTpye;
    private Button button;
    private int      id;

    private ImageButton work_button_back;
    private TextView work_commend_client_zhiye;
    private LinearLayout ll_zhiyeguwen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_work_repost_disable_details);
        initView();
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        initData();
    }

    private void initView() {
        mNumTv = findViewById(R.id.work_commend_number);
        mTime_Tv = findViewById(R.id.work_commend_time);
        mPeople1Tv = findViewById(R.id.work_commend_people);
        mTelTv = findViewById(R.id.work_commend_tel);
        mProjectTv = findViewById(R.id.work_commend_project);
        mAddressTv = findViewById(R.id.work_commend_project_address);
        mClientNameTv = findViewById(R.id.work_commend_client_name);
        mClientSexTv = findViewById(R.id.work_commend_client_sex);
        mClientTelTv = findViewById(R.id.work_commend_client_tel);
        mClientName1Tv = findViewById(R.id.work_commend_client_name2);
        mClientTel1Tv = findViewById(R.id.work_commend_client_tel2);
        mCountTv = findViewById(R.id.work_commend_headcount);
        mTime1Tv = findViewById(R.id.work_commend_time2);
        mCounselorTv = findViewById(R.id.work_commend_counselor);
        mPeopleTv = findViewById(R.id.work_commend_verify_people);
        mPeople_TelTv = findViewById(R.id.work_commend_verify_people_tel);
        mDisableTpye = findViewById(R.id.work_commend_disable_type);
        mDisableDescribe = findViewById(R.id.work_commend_disable_describe);
        mDisableTime = findViewById(R.id.work_commend_disable_time);
        button = findViewById(R.id.button_sure);
        work_commend_client_zhiye = findViewById(R.id.work_commend_client_zhiye);
        ll_zhiyeguwen = findViewById(R.id.ll_zhiyeguwen);

        work_button_back = findViewById(R.id.work_button_back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkChengjiaoDisableDetailActivity.this,WorkComplainActivity.class);
                intent.putExtra("poject_client_id",id);
                startActivity(intent);
            }
        });
        work_button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("client_id", String.valueOf(id));
        XutilsHttp.getInstance().gethesder(AppConstants.URL + "agent/work/project/dealDisabledDetail", map, new XutilsHttp.XCallBack() {
            @Override
            public void onResponse(String result) {
                Gson gson = new Gson();
                WorkReportDisableDetailsData workReportVerifyDetailData = gson.fromJson(result, WorkReportDisableDetailsData.class);
                setInfo(workReportVerifyDetailData);
            }

            @Override
            public void error(String message) {

            }
        });
    }

    private void setInfo(WorkReportDisableDetailsData workReportDisableDetailsData) {
        mNumTv.setText(String.valueOf(workReportDisableDetailsData.getData().getClient_id()));
        mTime_Tv.setText(workReportDisableDetailsData.getData().getCreate_time());
        mPeople1Tv.setText(workReportDisableDetailsData.getData().getBroker_name());
        mTelTv.setText(workReportDisableDetailsData.getData().getBroker_tel());
        mProjectTv.setText(workReportDisableDetailsData.getData().getProject_name());
        mAddressTv.setText(workReportDisableDetailsData.getData().getAbsolute_address());
        mClientNameTv.setText(workReportDisableDetailsData.getData().getName());
        if (workReportDisableDetailsData.getData().getSex() == 0) {
            mClientSexTv.setText("");
        }
        else if(workReportDisableDetailsData.getData().getSex() == 1){
            mClientSexTv.setText("男");
        }else if(workReportDisableDetailsData.getData().getSex() == 2){
            mClientSexTv.setText("女");
        }
        mClientTelTv.setText(workReportDisableDetailsData.getData().getTel());
        mClientName1Tv.setText(workReportDisableDetailsData.getData().getConfirm_name());
        mClientTel1Tv.setText(workReportDisableDetailsData.getData().getConfirm_tel());
        mCountTv.setText(String.valueOf(workReportDisableDetailsData.getData().getVisit_num()));
        mTime1Tv.setText(workReportDisableDetailsData.getData().getVisit_time());
        mCounselorTv.setText(workReportDisableDetailsData.getData().getProperty_advicer_wish());
        mPeopleTv.setText(workReportDisableDetailsData.getData().getButter_name());
        mPeople_TelTv.setText(workReportDisableDetailsData.getData().getButter_tel());

        mDisableTpye.setText(workReportDisableDetailsData.getData().getDisabled_state());
        mDisableDescribe.setText(workReportDisableDetailsData.getData().getDisabled_reason());
        mDisableTime.setText(workReportDisableDetailsData.getData().getDisabled_time());
        if (!workReportDisableDetailsData.getData().getConsultant_advicer().equals("")) {
            work_commend_client_zhiye.setText(workReportDisableDetailsData.getData().getConsultant_advicer());
        }else {
            ll_zhiyeguwen.setVisibility(View.GONE);
        }
    }
}
