package com.ccsoft.yunqudao.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GongSiRenZhengBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.SpUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

public class GongSiRenZhengZhongActivity  extends AppCompatActivity{

    private ImageButton me_button_返回;
    private TextView tv_name,tv_companyname,tv_companynum,tv_companybumen,tv_companyweizhi,
    tv_companytime;
    private Button button_next;
    private int id;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_renzhengzhong);
        HideIMEUtil.wrap(this);
        initView();
        initData();


    }
    private void initView(){
        me_button_返回 = findViewById(R.id.me_button_返回);
        tv_name = findViewById(R.id.tv_name);
        tv_companyname = findViewById(R.id.tv_companyname);
        tv_companynum = findViewById(R.id.tv_companynum);
        tv_companybumen = findViewById(R.id.tv_companybumen);
        tv_companyweizhi = findViewById(R.id.tv_companyweizhi);
        tv_companytime = findViewById(R.id.tv_companytime);
        button_next = findViewById(R.id.button_next);


        id = getIntent().getIntExtra("id",0);
        me_button_返回.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OkHttpUtils.get(AppConstants.URL+"agent/personal/canCelAuth")
                        .tag(this)
                        .params("id",id)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                StringModel model = JsonUtil.jsonToEntity(s,StringModel.class);
                                if(model.getCode()==200){
                                    finish();
                                }
                                Toast.makeText(GongSiRenZhengZhongActivity.this,
                                        model.getMsg(),Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    private void initData(){
        OkHttpUtils.get(HttpAdress.getAuthInfo)
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

                        if(code == 200 && data==null){

                        }
                        else if (code == 200 && data != null) {
                            GongSiRenZhengBean bean = JsonUtil.jsonToEntity(s,GongSiRenZhengBean.class);

                            tv_name.setText(SpUtil.getString("name",""));
                            tv_companyname.setText(bean.getData().getCompany_name());
                            tv_companynum.setText(bean.getData().getWork_code());
                            tv_companyweizhi.setText(bean.getData().getPosition());
                            tv_companybumen.setText(bean.getData().getDepartment());
                            tv_companytime.setText(bean.getData().getCreate_time());
                            }


                    }
                });
    }
}
