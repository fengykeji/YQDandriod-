package com.ccsoft.yunqudao.ui.work;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.model.response.WorkReportVerifyDetailData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.DataUtils;
import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * author lzx
 * Created on 2018/5/28.
 */

public class WorkReportVerifyActivity extends AppCompatActivity {
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
    private int      id;

    private TextView date_day;
    private TextView date_hour;
    private TextView date_minute;
    private TextView date_seconds;
    private ImageButton work_button_back;
    private TextView mCommentNumber;

    private TextView work_commend_client_zhiye;
    private LinearLayout ll_zhiyeguwen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_work_repost_verify_details);
        initView();
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        Log.d("1111111------->", "id:" + id);
        initData();

    }

    private void initView() {
//        mNumTv = findViewById(R.id.num_tv);
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
        date_day = findViewById(R.id.date_day);
        date_hour = findViewById(R.id.date_hour);
        date_minute = findViewById(R.id.date_minute);
        date_seconds = findViewById(R.id.date_seconds);
        work_button_back = findViewById(R.id.work_button_back);
        mCommentNumber = findViewById(R.id.work_commend_number);

        ll_zhiyeguwen = findViewById(R.id.ll_zhiyeguwen);
        work_commend_client_zhiye = findViewById(R.id.work_commend_client_zhiye);

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
        XutilsHttp.getInstance().gethesder(AppConstants.URL + "agent/work/project/waitConfirmDetail", map, new XutilsHttp.XCallBack() {
            @Override
            public void onResponse(String result) {
                Gson gson = new Gson();
                WorkReportVerifyDetailData workReportVerifyDetailData = gson.fromJson(result, WorkReportVerifyDetailData.class);
                setInfo(workReportVerifyDetailData);
            }

            @Override
            public void error(String message) {

            }
        });
    }

    private void setInfo(WorkReportVerifyDetailData workReportVerifyDetailData) {
//        mNumTv.setText(workReportVerifyDetailData.getData().getName());
        mTime_Tv.setText(workReportVerifyDetailData.getData().getCreate_time());
        mPeople1Tv.setText(workReportVerifyDetailData.getData().getBroker_name());
        mTelTv.setText(workReportVerifyDetailData.getData().getBroker_tel());
        mProjectTv.setText(workReportVerifyDetailData.getData().getProject_name());
        mAddressTv.setText(workReportVerifyDetailData.getData().getAbsolute_address());
        mClientNameTv.setText(workReportVerifyDetailData.getData().getName());
        if (workReportVerifyDetailData.getData().getSex()==1){
            mClientSexTv.setText("男");
        }else if(workReportVerifyDetailData.getData().getSex()==2){
            mClientSexTv.setText("女");
        }else{
            mClientSexTv.setText("");
        }
        mClientTelTv.setText(workReportVerifyDetailData.getData().getConfirm_tel());
        mClientName1Tv.setText(workReportVerifyDetailData.getData().getConfirm_name());
        mClientTel1Tv.setText(workReportVerifyDetailData.getData().getConfirm_tel());
        mCountTv.setText(String.valueOf(workReportVerifyDetailData.getData().getVisit_num()));
        mTime1Tv.setText(workReportVerifyDetailData.getData().getVisit_time());
        mCounselorTv.setText(workReportVerifyDetailData.getData().getProperty_advicer_wish());
        mPeopleTv.setText(workReportVerifyDetailData.getData().getButter_name());
        mPeople_TelTv.setText(workReportVerifyDetailData.getData().getButter_tel());
        mCommentNumber.setText(workReportVerifyDetailData.getData().getClient_id()+"");


        if (!workReportVerifyDetailData.getData().getConsultant_advicer().equals("")) {
            work_commend_client_zhiye.setText(workReportVerifyDetailData.getData().getConsultant_advicer());
        }else {
            ll_zhiyeguwen.setVisibility(View.GONE);
        }

        finishTime = workReportVerifyDetailData.getData().getTimeLimit();
        handler.post(runnable);
    }

    int finishTime;
    String time;
    Handler handler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
             time = DataUtils.getTime(finishTime);
            String[] times = time.split("-");
            timeOver();
            date_day.setText(times[0]);
            date_hour.setText(times[1]);
            date_minute.setText(times[2]);
            date_seconds.setText(times[3]);
            handler.postDelayed(runnable,1000);
        }
    };

    private void timeOver(){
        if(time.equals("0-0-0-0")){
            OkHttpUtils.get(HttpAdress.flushDate)
                    .tag(this)
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
                            if (code == 200 && data != null) {
                                finish();
                            }
                        }
                    });
        }
    }
}
