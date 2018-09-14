package com.ccsoft.yunqudao.ui.work.secondhandhouse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ProspectFinishBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

public class HouseInfoActivity extends AppCompatActivity {

    private int house_id;
    private TextView tv_house_code,work_commend_number,work_commend_time
            ,work_commend_people,work_commend_tel,work_commend_project,work_commend_project_address
            ,work_commend_client_name,work_commend_client_sex,work_commend_client_tel,tv_zhuangxiu;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_housexinxi);
        HideIMEUtil.wrap(this);
        initView();
//        initListener();
        initData();

    }
    private void initView(){
        house_id = getIntent().getIntExtra("house_id",0);

        tv_house_code  = findViewById(R.id.tv_house_code);
        work_commend_number = findViewById(R.id.work_commend_number);
        work_commend_time = findViewById(R.id.work_commend_time);
        work_commend_people = findViewById(R.id.work_commend_people);
        work_commend_tel = findViewById(R.id.work_commend_tel);
        work_commend_project = findViewById(R.id.work_commend_project);
        work_commend_project_address = findViewById(R.id.work_commend_project_address);
        work_commend_client_name = findViewById(R.id.work_commend_client_name);
        work_commend_client_sex = findViewById(R.id.work_commend_client_sex);
        work_commend_client_tel = findViewById(R.id.work_commend_client_tel);
        tv_zhuangxiu = findViewById(R.id.tv_zhuangxiu);
    }

    private void initData(){
        OkHttpUtils.get(HttpAdress.houseSurveyDetail)
                .tag(this)
                .params("house_id",house_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        ProspectFinishBean bean = JsonUtil.jsonToEntity(s,ProspectFinishBean.class);
                        if(bean.getCode() == 200){
                            tv_house_code.setText(bean.getData().getHouse().getHouse_code());
                            work_commend_number.setText(bean.getData().getDetail().getPermit_code());
                            work_commend_time.setText(bean.getData().getDetail().getPermit_time());
                            work_commend_people.setText(bean.getData().getDetail().getAbsolute_address());
                            work_commend_tel.setText(bean.getData().getDetail().getProperty_type());
                            work_commend_project.setText(bean.getData().getHouse().getHouse());
                            work_commend_project_address.setText(bean.getData().getDetail().getHouse_type());
                            work_commend_client_name.setText(bean.getData().getDetail().getBuild_area()+"");
                            work_commend_client_tel.setText(bean.getData().getDetail().getFloor_num()+"");
                            tv_zhuangxiu.setText(bean.getData().getDetail().getDecoration());
                        }
                    }
                });
    }
}
