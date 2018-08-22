package com.ccsoft.yunqudao.ui.message;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.MessageDisableDetailsBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.model.response.ConfirmDetailData;
import com.ccsoft.yunqudao.data.model.response.WorkCommendDisableData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.ui.work.WorkComplainActivity;
import com.ccsoft.yunqudao.ui.work.WrokCommendDisableDetailsActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

public class MessageCommendDisableDetailsActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView mDisableType;
    private TextView mDisableDescribe;
    private TextView mDisableTime;
    private TextView mNumTv;
    private TextView work_commend_time;

    private TextView  work_commend_people;
    private TextView  work_commend_tel;
    private TextView  work_commend_project;
    private TextView  work_commend_project_address;
    private TextView  work_commend_client_name;
    private TextView  work_commend_client_sex;
    private TextView  work_commend_client_tel;
    private int       id;
    private ImageView work_button_back;
    private Button tv_shensu,tv_retuijian;
    private int project_id,client_need_id,client_id;
    private int client_id1;
    private int message_id;

    private TextView work_commend_client_zhiye;
    private LinearLayout ll_zhiyeguwen;

    private int NumTv;
    private String   mwork_commend_client_name,mwork_commend_project,mwork_commend_project_address,
            DisableTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_work_commend_disable_details);
        initView();
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        initData();
    }

    private void initView() {
        client_id1 = getIntent().getIntExtra("client_id",0);
        message_id= getIntent().getIntExtra("message_id",0);
        mDisableType = findViewById(R.id.work_commend_disable_type);
        mDisableDescribe = findViewById(R.id.work_commend_disable_describe);
        mDisableTime = findViewById(R.id.work_commend_disable_time);
        mNumTv = findViewById(R.id.work_commend_number);
        work_commend_time = findViewById(R.id.work_commend_time);
        work_commend_people = findViewById(R.id.work_commend_people);
        work_commend_tel = findViewById(R.id.work_commend_tel);
        work_commend_project = findViewById(R.id.work_commend_project);
        work_commend_project_address = findViewById(R.id.work_commend_project_address);
        work_commend_client_sex = findViewById(R.id.work_commend_client_sex);
        work_commend_client_tel = findViewById(R.id.work_commend_client_tel);
        work_commend_client_name = findViewById(R.id.work_commend_client_name);
        work_commend_client_zhiye = findViewById(R.id.work_commend_client_zhiye);
        ll_zhiyeguwen = findViewById(R.id.ll_zhiyeguwen);
        tv_shensu = findViewById(R.id.tv_shensu);
        tv_retuijian = findViewById(R.id.tv_retuijian);
        work_button_back = findViewById(R.id.work_button_back);
        work_button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tv_shensu.setOnClickListener(this);
        tv_retuijian.setOnClickListener(this);
    }

    private void initData() {


        OkHttpManager.getInstance().get(HttpAdress.DisabledDetail + "?client_id="+client_id1+"&message_id="+message_id, new BaseCallBack() {
            @Override
            public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {
                Type type = new TypeToken<MessageDisableDetailsBean>(){}.getType();
                MessageDisableDetailsBean bean = new Gson().fromJson(obj.toString(),MessageDisableDetailsBean.class);
                setInfo(bean);

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



    private void setInfo(MessageDisableDetailsBean workCommendDisableData) {

        if (workCommendDisableData != null) {
            project_id = workCommendDisableData.getData().getProject_id();
            client_need_id = workCommendDisableData.getData().getClient_need_id();
            client_id = workCommendDisableData.getData().getClient_info_id();

            mDisableType.setText(workCommendDisableData.getData().getDisabled_state());
            mDisableDescribe.setText(workCommendDisableData.getData().getDisabled_reason());
            mDisableTime.setText(workCommendDisableData.getData().getDisabled_time());
            mNumTv.setText(String.valueOf(workCommendDisableData.getData().getClient_id()));
            work_commend_time.setText(workCommendDisableData.getData().getCreate_time());
            work_commend_people.setText(workCommendDisableData.getData().getBroker_name());

            if (!workCommendDisableData.getData().getConsultant_advicer().equals("")) {
                work_commend_client_zhiye.setText(workCommendDisableData.getData().getConsultant_advicer());
            }else {
                ll_zhiyeguwen.setVisibility(View.GONE);
            }

            work_commend_people.setText(workCommendDisableData.getData().getBroker_name());
            work_commend_tel.setText(workCommendDisableData.getData().getBroker_tel());
            work_commend_project.setText(workCommendDisableData.getData().getProject_name());
            work_commend_project_address.setText(workCommendDisableData.getData().getProvince_name() + "-" +
                    workCommendDisableData.getData().getCity_name() + "-" +
                    workCommendDisableData.getData().getDistrict_name() +
                    workCommendDisableData.getData().getAbsolute_address());
            work_commend_client_name.setText(workCommendDisableData.getData().getName());

            if (workCommendDisableData.getData().getSex() == 0) {
                work_commend_client_sex.setText("");
            } else if (workCommendDisableData.getData().getSex() == 1) {
                work_commend_client_sex.setText("男");
            } else if (workCommendDisableData.getData().getSex() == 2) {
                work_commend_client_sex.setText("女");
            }

            work_commend_client_tel.setText(workCommendDisableData.getData().getTel());

            NumTv = workCommendDisableData.getData().getClient_id();
            mwork_commend_client_name = workCommendDisableData.getData().getName();
            mwork_commend_project = workCommendDisableData.getData().getProject_name();
            mwork_commend_project_address = workCommendDisableData.getData().getProvince_name()+"-"+
                    workCommendDisableData.getData().getCity_name()+"-"+
                    workCommendDisableData.getData().getDistrict_name()+
                    workCommendDisableData.getData().getAbsolute_address();
            DisableTime = workCommendDisableData.getData().getDisabled_time();

        }
    }

    @Override
    public void onClick(View view){
            switch (view.getId()) {
                case R.id.tv_shensu:
                    Intent intent = new Intent(this, WorkComplainActivity.class);
                    intent.putExtra("poject_client_id", id);
                    startActivity(intent);
                    break;
                case R.id.tv_retuijian:
                    OkHttpUtils.post(HttpAdress.RECOMMEND)
                            .tag(this)
                            .params("project_id", project_id)
                            .params("client_need_id", client_need_id)
                            .params("client_id", client_id)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    Date date = new Date();
                                    String dateString = date.toLocaleString();

                                    StringModel model = JsonUtil.jsonToEntity(s, StringModel.class);
                                    if (model.getCode() == 200) {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(MessageCommendDisableDetailsActivity.this);
                                        builder.setTitle("推荐成功");
                                        builder.setMessage("推荐编号:"+NumTv+"\n客户:"+mwork_commend_client_name
                                                +"\n项目名字:"+mwork_commend_project+"\n项目地址:"+mwork_commend_project_address
                                                +"\n失效时间:"+DisableTime);
                                        builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                            }
                                        });
                                        AlertDialog dialog = builder.create();
                                        dialog.show();
                                    }
                                    if (model.getCode() == 400) {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(MessageCommendDisableDetailsActivity.this);
                                        builder.setTitle("推荐失败");
                                        builder.setMessage(model.getMsg() + "\n时间:" + dateString);

                                        builder.setNegativeButton("返回", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                            }
                                        });
                                        AlertDialog dialog = builder.create();
                                        dialog.show();
                                    }
                                }
                            });
                    break;
            }
    }
}
