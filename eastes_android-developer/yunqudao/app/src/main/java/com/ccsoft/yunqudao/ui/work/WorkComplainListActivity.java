package com.ccsoft.yunqudao.ui.work;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.AppealDetailBean;

import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.model.response.ValueDetailData;
import com.ccsoft.yunqudao.data.model.response.WorkReportDisableDetailsData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.XutilsHttp;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;


/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class WorkComplainListActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mWork_button_back;
    private Button mWork_button_cancel;
    private TextView tv_shensuleixing, tv_shensumiaosu, tv_shensuzhuangtai, tv_shensujieguo,
            tv_shixiaoleixing, tv_shixiaoxiaosu, tv_shixiaotime,
            work_commend_number, work_commend_time, work_commend_people, work_commend_tel,
            work_commend_project, work_commend_project_address, work_commend_client_name,
            work_commend_client_sex, work_commend_client_tel, tv_daofangperson, tv_daofangnum,
            tv_daofangtime;
    private String appeal_id;
    private AppealDetailBean bean;
    private LinearLayout ll_progress,ll_gone,ll_chengjiaoxingxi;
    private String gone ;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_work_shensuzhong_xiangqing);
        initView();
        initListener();
        ininData();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, WorkComplainListActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化
     */
    private void initView() {

        mWork_button_back = findViewById(R.id.work_button_back);
        mWork_button_cancel = findViewById(R.id.work_button_cancel);
        tv_shensuleixing = findViewById(R.id.tv_shensuleixing);
        tv_shensumiaosu = findViewById(R.id.tv_shensuxiaosu);
        tv_shensujieguo = findViewById(R.id.tv_shensujiegou);
        tv_shensuzhuangtai = findViewById(R.id.tv_shensuzhuangtai);
        tv_shixiaoleixing = findViewById(R.id.tv_shixiaoleixing);
        tv_shixiaoxiaosu = findViewById(R.id.tv_shixiaomiaoshi);
        tv_shixiaotime = findViewById(R.id.tv_shixiaotime);
        work_commend_number = findViewById(R.id.work_commend_number);
        work_commend_time = findViewById(R.id.work_commend_time);
        work_commend_people = findViewById(R.id.work_commend_people);
        work_commend_tel = findViewById(R.id.work_commend_tel);
        work_commend_project = findViewById(R.id.work_commend_project);
        work_commend_project_address = findViewById(R.id.work_commend_project_address);
        work_commend_client_name = findViewById(R.id.work_commend_client_name);
        work_commend_client_sex = findViewById(R.id.work_commend_client_sex);
        work_commend_client_tel = findViewById(R.id.work_commend_client_tel);
        tv_daofangperson = findViewById(R.id.tv_daofangperson);
        tv_daofangnum = findViewById(R.id.tv_daofangnum);
        tv_daofangtime = findViewById(R.id.tv_daofangtime);
        ll_progress = findViewById(R.id.ll_progress);
        ll_gone = findViewById(R.id.ll_gone);
        ll_chengjiaoxingxi = findViewById(R.id.ll_chengjiaoxinxi);

        appeal_id = getIntent().getStringExtra("appeal_id");
        gone = getIntent().getStringExtra("gone");
        if(gone.equals("gone")){
            ll_gone.setVisibility(View.GONE);
        }
        if(gone.equals("show")){
            ll_chengjiaoxingxi.setVisibility(View.VISIBLE);
        }

    }

    /**
     * 初始化
     */
    private void initListener() {

        mWork_button_back.setOnClickListener(this);
        mWork_button_cancel.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.work_button_back:
                finish();
                break;
            case R.id.work_button_cancel:
                Toast.makeText(this, "点击了申诉", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
    private void ininData(){


//        OkHttpUtils.get(HttpAdress.APPEALDETAIL)
//                .tag(this)
//                .params("appeal_id",appeal_id)
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(String s, Call call, Response response) {
//                        int code = 0;
//                        String data = null;
//                        try {
//                            JSONObject jsonObject = new JSONObject(s);
//                            code = jsonObject.getInt("code");
//                            data = jsonObject.getString("data");
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        if (code == 200 && data != null) {
//                            AppealDetailBean bean = JsonUtil.jsonToEntity(s,AppealDetailBean.class);
//
//                        }
//                    }
//                });







        OkHttpManager.getInstance().get(HttpAdress.APPEALDETAIL+"?appeal_id="+appeal_id, new BaseCallBack() {
            @Override
            public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {
                Type type = new TypeToken<AppealDetailBean>() {}.getType();
                bean = new Gson().fromJson(obj.toString(), type);
                Log.e("AppealDetailBean","解析成功");
                if(bean.getCode()==200&&bean.getData()!=null){
                    tv_shensuleixing.setText(bean.getData().getType());
                    tv_shensumiaosu.setText(bean.getData().getComment());
                    tv_shensujieguo.setText(bean.getData().getSolve_info());
                    tv_shensuzhuangtai.setText(bean.getData().getState()+"");
                    tv_shixiaoleixing.setText(bean.getData().getDisabled_state());
                    tv_shixiaoxiaosu.setText(bean.getData().getDisabled_reason());
                    tv_shixiaotime.setText(bean.getData().getDisabled_time());
                    work_commend_number.setText(bean.getData().getClient_id()+"");
                    work_commend_time.setText(bean.getData().getRecommend_time());
                    work_commend_people.setText(bean.getData().getBroker_name());
                    work_commend_tel.setText(bean.getData().getBroker_tel());
                    work_commend_project.setText(bean.getData().getProject_name());
                    work_commend_project_address.setText(bean.getData().getProvince_name()+"-"
                    +bean.getData().getCity_name()+"-"+bean.getData().getDistrict_name()
                    +"-"+bean.getData().getAbsolute_address());
                    work_commend_client_name.setText(bean.getData().getName());
                    work_commend_client_sex.setText(bean.getData().getSex()== 1 ? "男" : "女");
                    work_commend_client_tel.setText(bean.getData().getTel());
                    tv_daofangperson.setText(bean.getData().getButter_name());
                    tv_daofangnum.setText(bean.getData().getButter_tel());
                    tv_daofangtime.setText(bean.getData().getVisit_time());

                    for (int i=0;i<bean.getData().getProcess().size();i++) {
                        AppealDetailBean.DataBean.ProcessBean processBean = bean.getData().getProcess().get(i);

                        View view = getLayoutInflater().inflate(R.layout.view_process, null);
                        TextView tv_name = view.findViewById(R.id.tv_name);
                        TextView tv_time = view.findViewById(R.id.tv_time);
                        ImageView image = view.findViewById(R.id.image);
                        tv_name.setText(processBean.getProcess_name());
                        tv_time.setText(processBean.getTime());
                        if (i == bean.getData().getProcess().size() - 1) {
                            image.setVisibility(View.INVISIBLE);
                        }

                        ll_progress.addView(view);
                    }
                }
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
}