package com.ccsoft.yunqudao.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.StringBean;
import com.ccsoft.yunqudao.bean.UnPayDetailBean;
import com.ccsoft.yunqudao.data.model.response.ValueDetailData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.ui.home.HomeActivity;
import com.ccsoft.yunqudao.ui.house.ProjectXiangQingActivity;
import com.ccsoft.yunqudao.ui.work.WorkCommendValidDetailActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

public class WeiJieYongJinXiangQingActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton back;
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
    private TextView     tv_cuiyong;
    private TextView     tv_chakanyongjin;
    private LinearLayout mWork_condition_linearlayout1;
    private LinearLayout mWork_condition_linearlayout2;
    private ImageView mWork_condition_image1;
    private ImageView    mWork_condition_image2;
    private ImageView    mWork_condition_image3;
    private LinearLayout ll_progress;
    private UnPayDetailBean bean;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_weijiexiangqing);
        initView();
        initData();
        initListener();
    }

    private void initView(){
        id = getIntent().getIntExtra("id",0);
         back = findViewById(R.id.work_button_back);
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

        ll_progress = findViewById(R.id.ll_progress);

        tv_cuiyong = findViewById(R.id.tv_cuiyong);
        tv_chakanyongjin = findViewById(R.id.tv_chakanyongjin);

    }

    private void initData(){
        OkHttpUtils.get(HttpAdress.unPayDetail)
                .tag(this)
                .params("broker_id",id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                         bean = JsonUtil.jsonToEntity(s,UnPayDetailBean.class);
                        if(bean.getCode() == 200){
                            UnPayDetailBean.DataBean data = bean.getData();
                            work_commend_number.setText(data.getClient_id()+"");
                            work_commend_time.setText(data.getCreate_time());
                            work_commend_project.setText(data.getProject_name());
                            work_commend_project_address.setText(data.getAbsolute_address());
                            work_commend_client_name.setText(data.getName());
                            if(data.getSex() == 1){
                                work_commend_client_sex.setText("男");
                            }else if(data.getSex() == 2){
                                work_commend_client_sex.setText("女");
                            }
                            work_commend_client_tel.setText(data.getTel());
                            work_commend_client_name2.setText(data.getBroker_type());
                            work_commend_client_tel2.setText(data.getVisit_time());

                            for (int i=0;i<data.getProcess().size();i++) {
                                UnPayDetailBean.DataBean.ProcessBean processBean = data.getProcess().get(i);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                                View view = getLayoutInflater().inflate(R.layout.view_process,null);
                                TextView tv_name = view.findViewById(R.id.tv_name);
                                TextView tv_time = view.findViewById(R.id.tv_time);
                                ImageView image = view.findViewById(R.id.image);
                                if(i<data.getProcess().size()-1) {
                                    tv_name.setText(processBean.getProcess_name());
                                    tv_time.setText(processBean.getTime());
                                }else {
                                    layoutParams.setMargins(10,-60,10,0);
                                    tv_name.setText(processBean.getProcess_name());
                                    tv_time.setText(processBean.getTime());
                                }

                                LinearLayout layout = view.findViewById(R.id.ll_addImageView);
                                if (i == data.getProcess().size() - 2) {
                                    ImageView imageView = new ImageView(WeiJieYongJinXiangQingActivity.this);
                                    imageView.setImageResource(R.drawable.progressbar);
                                    layout.removeAllViews();
                                    layout.addView(imageView);

                                }
                                if(i==data.getProcess().size()-1){
                                    image.setVisibility(View.INVISIBLE);
                                }

                                ll_progress.addView(view,layoutParams);
                            }
                        }
                    }
                });
    }

    private void initListener(){
        back.setOnClickListener(this);
        tv_cuiyong.setOnClickListener(this);
        tv_chakanyongjin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.work_button_back:
                finish();
                break;
            case R.id.tv_cuiyong:
                urge();
                break;
            case R.id.tv_chakanyongjin:
                Intent intent = new Intent(WeiJieYongJinXiangQingActivity.this, ProjectXiangQingActivity.class);
                intent.putExtra("project_id",bean.getData().getProject_id());
                startActivity(intent);
                break;
        }
    }
    private void urge(){

        OkHttpUtils.post(HttpAdress.urge)
                .tag(this)
                .params("broker_id",id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        StringBean model = JsonUtil.jsonToEntity(s,StringBean.class);

                        Toast.makeText(WeiJieYongJinXiangQingActivity.this,model.getMsg(),Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
