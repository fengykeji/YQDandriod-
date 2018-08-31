package com.ccsoft.yunqudao.ui.message;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.DuiJieDaiQueRenDetail;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.model.response.ValueDetailData;
import com.ccsoft.yunqudao.data.model.response.WorkReportVerifyDetailData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.work.WorkCommendValidDetailActivity;
import com.ccsoft.yunqudao.ui.work.duijierentuijian.DuiJieQueRenActivity;
import com.ccsoft.yunqudao.ui.work.duijierentuijian.WeiDaoFangActivity;
import com.ccsoft.yunqudao.ui.work.duijierentuijian.WorkDuiJieCommendVerifyDetailActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.DataUtils;
import com.ccsoft.yunqudao.utils.ItemsDialogFragment;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.util.LogUtil;

import okhttp3.Call;
import okhttp3.Response;

public class MessageReportVerifyActivity extends AppCompatActivity {
    private TextView work_commend_number;
    private TextView work_commend_time;
    private TextView work_commend_people;
    private TextView work_commend_tel;
    private TextView work_commend_project;
    private TextView work_commend_project_address;
    private TextView work_commend_client_name;
    private TextView work_commend_client_sex;
    private TextView work_commend_client_tel;
    private int      id,message_id;
    private TextView date_day;
    private TextView date_hour;
    private TextView date_minute;
    private TextView date_seconds;
    private TextView work_commend_client_zhiye;
    private LinearLayout ll_zhiyeguwen;
    private Button button_next;
    private LinearLayout ll_showsure;
    private int project_id,client_id,property_advicer_wish_id,visit_num;
    private String client_name,client_tel,visit_time;
    private TextView work_commend_leibie,work_commend_client_comment;



    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_work_commend_verify_details);
        initView();
        initData();
    }

    public static void start(Context context, int id) {
        Intent intent = new Intent(context, WorkDuiJieCommendVerifyDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        intent.putExtra("data", bundle);
        context.startActivity(intent);
    }

    private void initView() {
//        Bundle bundle = getIntent().getBundleExtra("data");
//        id = bundle.getInt("id");
        client_id = getIntent().getIntExtra("client_id",0);
        message_id = getIntent().getIntExtra("message_id",0);
//        project_id = getIntent().getIntExtra("project_id",0);
//        client_name = getIntent().getStringExtra("client_name");
//        client_tel = getIntent().getStringExtra("client_tel");
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
        work_commend_client_zhiye = findViewById(R.id.work_commend_client_zhiye);
        ll_zhiyeguwen = findViewById(R.id.ll_zhiyeguwen);
        date_day = findViewById(R.id.date_day);
        date_hour = findViewById(R.id.date_hour);
        date_minute = findViewById(R.id.date_minute);
        date_seconds = findViewById(R.id.date_seconds);
        button_next = findViewById(R.id.button_next);
        ll_showsure = findViewById(R.id.ll_showsure);
        work_commend_leibie = findViewById(R.id.work_commend_leibie);
        work_commend_client_comment = findViewById(R.id.work_commend_client_comment);

        ll_showsure.setVisibility(View.VISIBLE);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void initData() {


        OkHttpUtils.get(AppConstants.URL+"agent/message/work/waitConfirmDetail")
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
                            DuiJieDaiQueRenDetail.DataBean data = JsonUtil.jsonToEntity(data1,DuiJieDaiQueRenDetail.DataBean.class);
                            if (data != null) {
                                if(data.getIs_deal() == 1){
                                    ll_showsure.setVisibility(View.GONE);
                                }
                                project_id = data.getProject_id();
                                client_name = data.getName();
                                client_tel = data.getTel();
                                work_commend_number.setText(String.valueOf(data.getClient_id()));
                                work_commend_time.setText(data.getCreate_time());
                                work_commend_people.setText(data.getBroker_name());
                                work_commend_tel.setText(data.getBroker_tel());
                                work_commend_project.setText(data.getProject_name());
                                work_commend_client_name.setText(data.getName());

                                if(data.getSex() == 1){
                                    work_commend_client_sex.setText("男");
                                }else if(data.getSex() == 2){
                                    work_commend_client_sex.setText("女");
                                }

                                work_commend_client_tel.setText(data.getTel());
                                work_commend_project_address.setText(data.getProvince_name() + " " + data.getCity_name() + " " + data.getDistrict_name()+" "+data.getAbsolute_address());

                                finishTime = data.getTimeLimit();
                                handler.post(runnable);

                                work_commend_leibie.setText(data.getRecommend_type());
                                work_commend_client_comment.setText(data.getClient_comment());
                                if (!data.getComsulatent_advicer().equals("")) {
                                    work_commend_client_zhiye.setText(data.getComsulatent_advicer());
                                }else {
                                    ll_zhiyeguwen.setVisibility(View.GONE);
                                }
                            }

                            button_next.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    showItemsDialogFragment();
                                }
                            });

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

//            overtime();
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

    public void showItemsDialogFragment() {
        ItemsDialogFragment itemsDialogFragment = new ItemsDialogFragment();
        String[] items = {"已到访", "未到访","取消" };
        itemsDialogFragment.show("", items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        Intent intent = new Intent(MessageReportVerifyActivity.this,DuiJieQueRenActivity.class);
                        intent.putExtra("project_id",project_id);
                        intent.putExtra("client_name",client_name);
                        intent.putExtra("client_tel",client_tel);
                        intent.putExtra("client_id",client_id);
                        intent.putExtra("daofangid",1);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(MessageReportVerifyActivity.this,WeiDaoFangActivity.class);
                        intent1.putExtra("client_id",client_id);
                        intent1.putExtra("daofangid",2);
                        startActivity(intent1);
                        break;
                    case 2:
                        itemsDialogFragment.dismiss();
                        break;

                }
            }
        }, getSupportFragmentManager());
    }


}
