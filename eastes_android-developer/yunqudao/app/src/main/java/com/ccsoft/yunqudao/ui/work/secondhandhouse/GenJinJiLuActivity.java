package com.ccsoft.yunqudao.ui.work.secondhandhouse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.bean.StringBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Response;

public class GenJinJiLuActivity extends AppCompatActivity {
    private int house_id,follow_type,intent,urgency,check_way,price,minimum,pay_way;
    private String follow_time,title,comment,next_visit_time,follow_type1,check_way1,pay_way1;
    private RadioGroup rg_follow_type1,rg_follow_type;
    private RadioButton radioButton1,radioButton;
    private EditText tv_kehumingcheng,tv_dijia,tv_jiage;
    private Spinner customers_spinner_看房方式;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_genjinjilu);
        HideIMEUtil.wrap(this);
        initView();
//        initListener();
        initData();
    }

    private void initView(){
        house_id = getIntent().getIntExtra("house_id",0);

        rg_follow_type1 = findViewById(R.id.rg_follow_type1);
        rg_follow_type = findViewById(R.id.rg_follow_type);
        tv_kehumingcheng = findViewById(R.id.tv_kehumingcheng);
        customers_spinner_看房方式 = findViewById(R.id.customers_spinner_看房方式);
        tv_dijia = findViewById(R.id.tv_dijia);
        tv_jiage = findViewById(R.id.tv_jiage);


        /**
         * 获取系统当前时间
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate    =   new    Date(System.currentTimeMillis());//获取当前时间
        follow_time = simpleDateFormat.format(curDate);

        /**
         * 获取跟进方式
         */
        rg_follow_type1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                radioButton1 = (RadioButton)findViewById(rg_follow_type1.getCheckedRadioButtonId());
                follow_type1 = radioButton1.getText().toString();
            }
        });

        PeizhiBean peizhiBean = MainActivity.savePeizhi();
        if(peizhiBean.getData()!=null){
            for (PeizhiBean.DataBean._$31Bean.ParamBeanXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX bean : peizhiBean.getData().get_$31().getParam()) {
                Log.e("ccccc",bean.getParam());
            }
            for (PeizhiBean.DataBean._$23Bean.ParamBeanXXXXXXXXXXXXXXXXXXXXXX data : peizhiBean.getData().get_$23().getParam()) {
                if(follow_type1.equals(data.getParam())){
                    follow_type = data.getId();
                }
            }
        }

        title = tv_kehumingcheng.getText().toString();

        /**
         * 获取看房方式
         */
        customers_spinner_看房方式.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] languages = getResources().getStringArray(R.array.看房方式);
                check_way1 = languages[i];
                if (peizhiBean.getData()!=null){
                    for (PeizhiBean.DataBean._$31Bean.ParamBeanXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX data : peizhiBean.getData().get_$31().getParam()) {
                        if(check_way1.equals(data.getParam())){
                            check_way = data.getId();
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        minimum = Integer.parseInt(tv_dijia.getText().toString());
        price = Integer.parseInt(tv_jiage.getText().toString());

        /**
         * 获取付款方式
         */
        rg_follow_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                radioButton = (RadioButton)findViewById(rg_follow_type.getCheckedRadioButtonId());
                pay_way1 = radioButton.getText().toString();
            }
        });
        if (peizhiBean.getData()!=null){
            for (PeizhiBean.DataBean._$13Bean.ParamBeanXXXXXXXXXXXX data : peizhiBean.getData().get_$13().getParam()) {
                if(pay_way1.equals(data.getParam())){
                    pay_way = data.getId();
                }
            }
        }


    }

    private void initData(){
        OkHttpUtils.post(HttpAdress.surveyAddFollow)
                .tag(this)
                .params("house_id",house_id)
                .params("follow_time",follow_time)
                .params("follow_type",follow_type)
                .params("title",title)
                .params("intent",intent)
                .params("urgency",urgency)
                .params("check_way",check_way)
                .params("price",price)
                .params("minimum",minimum)
                .params("pay_way",pay_way)
                .params("comment",comment)
                .params("next_visit_time",next_visit_time)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        StringBean bean = JsonUtil.jsonToEntity(s,StringBean.class);
                        if(bean.getCode() == 200){
                            finish();
                        }
                        Toast.makeText(GenJinJiLuActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
