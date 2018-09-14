package com.ccsoft.yunqudao.ui.work.secondhandhouse;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.WaitGrabDetailBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.utils.DataUtils;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

public class WorkSecondBaoBeiVerfyDetailActivity extends AppCompatActivity {

    private TextView work_commend_number;
    private TextView work_commend_time;
    private TextView work_commend_people;
    private TextView work_commend_tel;
    private TextView work_commend_project;
    private TextView work_commend_project_address;
    private TextView work_commend_client_name;
    private TextView work_commend_client_sex;
    private TextView work_commend_client_tel;
    private int      record_id;
    private TextView date_day;
    private TextView date_hour;
    private TextView date_minute;
    private TextView date_seconds;
    private TextView tv_xiaoqumingzi;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_second_baobei_verify_details);
        initView();
        initData();
    }

    private void initView() {

        record_id = getIntent().getIntExtra("record_id",0);
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
        date_day = findViewById(R.id.date_day);
        date_hour = findViewById(R.id.date_hour);
        date_minute = findViewById(R.id.date_minute);
        date_seconds = findViewById(R.id.date_seconds);
        tv_xiaoqumingzi = findViewById(R.id.tv_xiaoqumingzi);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initData(){
        OkHttpUtils.get(HttpAdress.waitGrabDetail)
                .tag(this)
                .params("record_id",record_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        WaitGrabDetailBean bean = JsonUtil.jsonToEntity(s,WaitGrabDetailBean.class);
                        if(bean.getCode() == 200){
                            tv_xiaoqumingzi.setText(bean.getData().getProject_name());
                            work_commend_number.setText(bean.getData().getHouse_code());
                            work_commend_time.setText(bean.getData().getStore_name());
                            work_commend_people.setText(bean.getData().getName());
                            if(bean.getData().getSex() == 1) {
                                work_commend_tel.setText("男");
                            }else if(bean.getData().getSex() == 2) {
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
