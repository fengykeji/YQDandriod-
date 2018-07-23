package com.ccsoft.yunqudao.ui.me;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

public class GongSiRenZhengWanActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button_nex,button_nex1;
    private TextView tv_company,tv_tuzhitime;
    private TextView et_suoshubumen,et_zhiwei,et_gonghao;
    private ImageButton me_button_返回;
    private ImageView ib_photo;
    private int id;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.gongsirenzhengwan_activity);
        HideIMEUtil.wrap(this);
        initView();
        initData();
        initlistener();
    }

    private void initView(){

        me_button_返回 = findViewById(R.id.me_button_返回);
        button_nex = findViewById(R.id.button_next);
        button_nex1 = findViewById(R.id.button_next1);
        tv_company = findViewById(R.id.tv_company);
        tv_tuzhitime = findViewById(R.id.tv_tuzhitime);
        et_suoshubumen = findViewById(R.id.et_suoshubumen);
        et_zhiwei = findViewById(R.id.tv_zhiwei);
        ib_photo = findViewById(R.id.ib_photo);
        et_gonghao = findViewById(R.id.et_gonghao);

        id = getIntent().getIntExtra("id",0);


    }

    private void initlistener(){
        me_button_返回.setOnClickListener(this);
        button_nex.setOnClickListener(this);
        button_nex1.setOnClickListener(this);


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

                         if (code == 200 && data != null) {

                            GongSiRenZhengBean bean = JsonUtil.jsonToEntity(s,GongSiRenZhengBean.class);
                            tv_company.setText(bean.getData().getCompany_name());
                            et_gonghao.setText(bean.getData().getWork_code());
                            et_suoshubumen.setText(bean.getData().getDepartment());
                            et_zhiwei.setText(bean.getData().getPosition()+"");
                            tv_tuzhitime.setText(bean.getData().getCreate_time());
                            ib_photo.setImageURI(Uri.parse(AppConstants.URL+bean.getData().getImg_url()));

                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.me_button_返回:
                finish();
                break;
            case R.id.button_next:
                Intent intent = new Intent(GongSiRenZhengWanActivity.this,GongSiRenZheng1Activity.class);
                startActivity(intent);

                break;
            case R.id.button_next1:
                OkHttpUtils.get(AppConstants.URL+"agent/personal/quit")
                        .tag(this)
                        .params("id",id)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                StringModel model = JsonUtil.jsonToEntity(s,StringModel.class);
                                if (model.getCode()==200){
                                    finish();
                                }
                                Toast.makeText(GongSiRenZhengWanActivity.this,
                                        model.getMsg(),Toast.LENGTH_SHORT).show();
                            }
                        });

                break;
        }
    }
}
