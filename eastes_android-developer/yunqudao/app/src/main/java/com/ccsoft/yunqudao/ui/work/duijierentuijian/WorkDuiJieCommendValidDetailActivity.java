package com.ccsoft.yunqudao.ui.work.duijierentuijian;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.model.response.ValueDetailData;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.work.WorkCommendValidDetailActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

public class WorkDuiJieCommendValidDetailActivity extends AppCompatActivity {

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
    private LinearLayout mWork_condition_linearlayout1;
    private LinearLayout mWork_condition_linearlayout2;
    private ImageView mWork_condition_image1;
    private ImageView    mWork_condition_image2;
    private ImageView    mWork_condition_image3;
    private LinearLayout ll_progress;
    private TextView work_commend_client_zhiye;
    private LinearLayout ll_zhiyeguwen;
    private TextView work_commend_leibie,work_commend_client_comment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_work_commend_valid_details);
        initView();
        initData();
    }

    public static void start(Context context, int id) {
        Intent intent = new Intent(context, WorkCommendValidDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        intent.putExtra("data", bundle);
        context.startActivity(intent);
    }

    private void initView() {
        Bundle bundle = getIntent().getBundleExtra("data");
        id = bundle.getInt("id");
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
        work_commend_leibie = findViewById(R.id.work_commend_leibie);
        work_commend_client_comment = findViewById(R.id.work_commend_client_comment);

        ll_zhiyeguwen = findViewById(R.id.ll_zhiyeguwen);
        work_commend_client_zhiye = findViewById(R.id.work_commend_client_zhiye);

        ll_progress = findViewById(R.id.ll_progress);

        TextView tv_title = findViewById(R.id.tv_title);

        tv_title.setText("客户到访详情");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initData() {

        ClientManager.getInstance().getValueDetail(id).compose(RxSchedulers.<ValueDetailData>io_main()).subscribe(new ApiSubscriber<ValueDetailData>(this) {
            @Override
            protected void _onNext(ValueDetailData data) {
                if (data != null) {

                }
            }

            @Override
            protected void _onError(String message) {
                Toast.makeText(WorkDuiJieCommendValidDetailActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void _onCompleted() {

            }
        });


        OkHttpUtils.get(AppConstants.URL+"agent/personal/advice")
                .params("client_id",id)
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
                            ValueDetailData data = JsonUtil.jsonToEntity(data1,ValueDetailData.class);
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

                            work_commend_client_tel.setText(data.broker_tel);
                            work_commend_project_address.setText(data.province_name + " " + data.city_name + " " + data.district_name+" "+data.absolute_address);

                            work_commend_client_tel.setText(data.tel);


                            work_commend_client_name2.setText(data.confirm_name);
                            work_commend_client_tel2.setText(data.confirm_tel);
                            work_commend_headcount.setText(data.visit_num + "");
                            work_commend_time2.setText(data.process.get(1).time);
                            work_commend_counselor.setText(data.property_advicer_wish);
                            work_commend_verify_people.setText(data.butter_name);
                            work_commend_verify_people_tel.setText(data.butter_tel);



                            work_commend_leibie.setText(data.recommend_type);
                            work_commend_client_comment.setText(data.client_comment);
                            if (!data.comsulatent_advicer.equals("")) {
                                work_commend_client_zhiye.setText(data.comsulatent_advicer);

                            }else {
                                ll_zhiyeguwen.setVisibility(View.GONE);
                            }

                            for (int i=0;i<data.process.size();i++) {
                                ValueDetailData.ProcessBean processBean = data.process.get(i);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);


                                View view = getLayoutInflater().inflate(R.layout.view_process,null);
                                TextView tv_name = view.findViewById(R.id.tv_name);
                                TextView tv_time = view.findViewById(R.id.tv_time);

                                ImageView image = view.findViewById(R.id.image);
                                if(i<data.process.size()-1) {
                                    tv_name.setText(processBean.process_name);
                                    tv_time.setText(processBean.time);
                                }else {
                                    layoutParams.setMargins(10,-60,10,0);
                                    tv_name.setText(processBean.process_name);
                                    tv_time.setText(processBean.time);
                                }

                                LinearLayout layout = view.findViewById(R.id.ll_addImageView);
                                if (i == data.process.size() - 2) {
                                    ImageView imageView = new ImageView(WorkDuiJieCommendValidDetailActivity.this);
                                    imageView.setImageResource(R.drawable.progressbar);
                                    layout.removeAllViews();
                                    layout.addView(imageView);

                                }
                                if(i==data.process.size()-1){
                                    image.setVisibility(View.INVISIBLE);
                                }

                                ll_progress.addView(view,layoutParams);
                            }
                        }

                    }
                });
    }
}
