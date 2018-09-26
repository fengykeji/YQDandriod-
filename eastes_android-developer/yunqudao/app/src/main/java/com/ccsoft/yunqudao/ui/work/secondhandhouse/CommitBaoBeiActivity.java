package com.ccsoft.yunqudao.ui.work.secondhandhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.bean.ProjectDanYuanBean;
import com.ccsoft.yunqudao.bean.StringBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

public class CommitBaoBeiActivity extends AppCompatActivity {

    private ProjectDanYuanBean.DataBean.LISTBean list ;
    private ImageButton customers_button_back;
    private Button button_next;
    private RadioGroup rg_follow_type;
    private RadioButton radioButton;
    private TextView tv_build_name,tv_houseid;
    private EditText customers_edittext_name,customers_edittext_tel,customers_edittext_address;
    private Spinner spinner_reporter_type;
    private int build_id,project_id,unit_id,record_type = 1;
    private String unit_name,build_name;
    private String name,tel,address,stringreporter_type,survey_type;
    private String follow_type;
    private int sex = 0,reporter_type;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_baobeicommit);
        HideIMEUtil.wrap(this);
        initView();
//        initData();
//        initListener();

    }
    private void initView(){
        Bundle bundle =getIntent().getExtras();
        list = (ProjectDanYuanBean.DataBean.LISTBean) bundle.getSerializable("list");
        project_id= getIntent().getIntExtra("project_id",0);
        build_id = getIntent().getIntExtra("build_id",0);
        unit_id = getIntent().getIntExtra("unit_id",0);
        unit_name = getIntent().getStringExtra("unit_name");
        build_name = getIntent().getStringExtra("build_name");
        customers_button_back = findViewById(R.id.customers_button_back);
        button_next = findViewById(R.id.button_next);
        customers_edittext_name = findViewById(R.id.customers_edittext_name);
        customers_edittext_tel = findViewById(R.id.customers_edittext_tel);
        customers_edittext_address = findViewById(R.id.customers_edittext_address);
        spinner_reporter_type = findViewById(R.id.spinner_reporter_type);
        rg_follow_type = findViewById(R.id.rg_follow_type);
        tv_build_name = findViewById(R.id.tv_build_name);
        tv_houseid = findViewById(R.id.tv_houseid);

        tv_build_name.setText(build_name);
        tv_houseid.setText(list.getFJID()+"");

        rg_follow_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                radioButton = (RadioButton)findViewById(rg_follow_type.getCheckedRadioButtonId());
                follow_type = radioButton.getText().toString();
            }
        });

        spinner_reporter_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] data = getResources().getStringArray(R.array.与业主关系);
                stringreporter_type = data[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        customers_button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });
    }

    private void initData(){

        name = customers_edittext_name.getText().toString();
        tel = customers_edittext_tel.getText().toString();
        address = customers_edittext_address.getText().toString();
        PeizhiBean peizhiBean = MainActivity.savePeizhi();

        if(name.equals("")){
            Toast.makeText(this,"请输入姓名",Toast.LENGTH_LONG).show();
            return;
        }
        if(tel.equals("")){
            Toast.makeText(this,"请输入电话号码",Toast.LENGTH_LONG).show();
            return;
        }
        if(address.equals("")){
            Toast.makeText(this,"请输入地址",Toast.LENGTH_LONG).show();
            return;
        }
        if(stringreporter_type.equals("")){
            Toast.makeText(this,"请选择与业主关系",Toast.LENGTH_LONG).show();
            return;
        }else if (peizhiBean.getData()!=null){
            for (PeizhiBean.DataBean._$30Bean.ParamBeanXXXXXXXXXXXXXXXXXXXXXXXXXXXXX data : peizhiBean.getData().get_$30().getParam()) {
                if(data.getParam().equals(stringreporter_type)){
                    record_type = data.getId();
                }
            }
        }
        if(follow_type == null){
            Toast.makeText(this,"请选择勘察方式",Toast.LENGTH_LONG).show();
            return;
        }else if(follow_type.equals("他人勘察")){
            survey_type = 1+"";
        }
        else if(follow_type.equals("自行勘察")){
            survey_type = 2+"";
        }

        OkHttpUtils.post(HttpAdress.secondHouseRecord)
                .tag(this)
                .params("project_id",project_id)
                .params("build_id",build_id)
                .params("record_type",record_type)
                .params("build_name",build_name)
                .params("unit_id",unit_id)
                .params("unit_name",unit_name)
                .params("house_id",list.getFJID())
                .params("house_name",list.getFJMC())
                .params("property_type",list.getWYMC())
                .params("house_type",list.getHXMC())
                .params("floor_num",list.getFLOORNUM())
                .params("orientation","向东")
                .params("build_area",list.getJZMJ())
                .params("name",name)
                .params("sex",sex)
                .params("tel",tel)
                .params("address",address)
                .params("report_type",reporter_type)
                .params("survey_type",survey_type)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        StringBean bean = JsonUtil.jsonToEntity(s,StringBean.class);

                        if(bean.getCode() == 200){
                            Intent intent = new Intent(CommitBaoBeiActivity.this,WorkSecondBaoBeiActivity.class);
                            startActivity(intent);
                        }
                        Toast.makeText(CommitBaoBeiActivity.this,bean.getMsg(),Toast.LENGTH_LONG).show();
                    }
                });
    }
}
