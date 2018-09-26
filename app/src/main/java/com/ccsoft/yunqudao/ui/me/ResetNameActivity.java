package com.ccsoft.yunqudao.ui.me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.ccsoft.yunqudao.utils.SpUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/8 0008
 */

public class ResetNameActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mMe_button_返回;
    private Button      mMe_button_保存;
    private EditText    mMe_edittext_姓名;
    private ImageButton mMe_button_清除;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_reset_name);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ResetNameActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         * 初始化id
         */
        mMe_button_返回 = findViewById(R.id.me_button_返回);
        mMe_button_保存 = findViewById(R.id.me_button_保存);
        mMe_edittext_姓名 = findViewById(R.id.me_edittext_姓名);
        mMe_button_清除 = findViewById(R.id.me_button_清除);
    }

    private void initListener() {
        /**
         *初始化监听器
         */
        mMe_button_返回.setOnClickListener(this);
        mMe_button_保存.setOnClickListener(this);
        mMe_button_清除.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.me_button_返回:
                finish();
                break;
            case R.id.me_button_保存:
                SpUtil.setString("name",mMe_edittext_姓名.getText().toString());
                updata(mMe_edittext_姓名.getText().toString());
                break;
            case R.id.me_button_清除:
                mMe_edittext_姓名.setText("");
                break;
        }
    }

    /**
     * 修改个人信息
     */
    public void updata(String name){
        OkHttpUtils.post(HttpAdress.meupdate)
                .params("name",name)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        StringModel model = JsonUtil.jsonToEntity(s,StringModel.class);
                        if(model.getCode() == 200){
                            finish();
                        }
                       Toast.makeText(ResetNameActivity.this,model.getMsg(),Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
