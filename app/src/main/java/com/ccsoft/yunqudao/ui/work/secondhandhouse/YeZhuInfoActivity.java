package com.ccsoft.yunqudao.ui.work.secondhandhouse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.bean.ProspectFinishBean;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;

public class YeZhuInfoActivity extends AppCompatActivity {

    private ProspectFinishBean.DataBean.ContactBean bean;
    private TextView work_commend_number,work_commend_time,work_commend_people
            ,work_commend_tel,work_commend_project,work_commend_project_address
            ,work_commend_client_name;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_yezhuinfo);
        HideIMEUtil.wrap(this);
        initView();
//        initListener();
    }

    private void initView(){
        Bundle bundle = getIntent().getExtras();

        work_commend_number = findViewById(R.id.work_commend_number);
        work_commend_time = findViewById(R.id.work_commend_time);
        work_commend_tel = findViewById(R.id.work_commend_tel);
        work_commend_people = findViewById(R.id.work_commend_people);
        work_commend_project = findViewById(R.id.work_commend_project);
        work_commend_project_address = findViewById(R.id.work_commend_project_address);

        /**
         * 获取config
         */

//        PeizhiBean peizhiBean = MainActivity.savePeizhi();


        bean = (ProspectFinishBean.DataBean.ContactBean) bundle.getSerializable("bean");
        if(bean!=null){
            work_commend_number.setText(bean.getName());
            work_commend_time.setText(bean.getReport_type());
            work_commend_people.setText(bean.getTel().get(0));
            work_commend_tel.setText(bean.getTel().get(1));
            work_commend_project.setText("身份证");
            work_commend_project_address.setText(bean.getCard_id());
//            work_commend_client_name.setText(bean.getAddress()+"");

        }
    }
}
