package com.ccsoft.yunqudao.ui.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.model.response.ConfirmDetailData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.work.WorkCommendVerifyDetailActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.DataUtils;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

public class MessageCommendVerifyDetailActivity extends AppCompatActivity {

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
    private int client_id;
    private int message_id;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_work_commend_verify_details);
        initView();
        initData();

    }

    public static void start(Context context, int id) {
        Intent intent = new Intent(context, WorkCommendVerifyDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        intent.putExtra("data", bundle);
        context.startActivity(intent);
    }

    private void initView() {

        client_id = getIntent().getIntExtra("client_id",0);
        message_id= getIntent().getIntExtra("message_id",0);
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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initData() {


        OkHttpUtils.get(HttpAdress.waitConfirmDetail)
                .tag(this)
                .params("client_id",client_id)
                .params("message_id",message_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        int code = 0;
                        String data1 = null;
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            code = jsonObject.getInt("code");
                            data1 = jsonObject.getString("data");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (code == 200 && data1 != null) {
                            ConfirmDetailData data = JsonUtil.jsonToEntity(data1,ConfirmDetailData.class);
                            if (data != null) {
                                work_commend_number.setText(String.valueOf(data.client_id));
                                work_commend_time.setText(data.create_time);
                                work_commend_people.setText(data.broker_name);
                                work_commend_tel.setText(data.broker_tel);
                                work_commend_project.setText(data.project_name);
                                work_commend_client_name.setText(data.name);

                                if(data.sex == 1){
                                    work_commend_client_sex.setText("男");
                                }else if(data.sex == 2){
                                    work_commend_client_sex.setText("女");
                                }

                                work_commend_client_tel.setText(data.tel);
                                work_commend_project_address.setText(data.province_name + " " + data.city_name + " " + data.district_name+" "+data.absolute_address);

                                finishTime = data.timeLimit;
                                handler.post(runnable);

                            }

                        }
                    }
                });
    }



    /*
倒计时
*/

    int finishTime;
    String time;
    String[] times;
    Handler handler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time= DataUtils.getTime(finishTime);

            overtime();
            times = time.split("-");

            date_day.setText(times[0]);
            date_hour.setText(times[1]);
            date_minute.setText(times[2]);
            date_seconds.setText(times[3]);
            handler.postDelayed(runnable,1000);
        }
    };

    private void overtime(){
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
