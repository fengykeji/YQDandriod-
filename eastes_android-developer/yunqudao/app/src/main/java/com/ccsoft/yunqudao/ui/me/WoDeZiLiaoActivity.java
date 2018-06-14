package com.ccsoft.yunqudao.ui.me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.model.PersonCenterModel;
import com.ccsoft.yunqudao.ui.mian.LoginActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.SpUtil;

/**
 * @author: Pein
 * @data: 2018/5/3 0003
 */

public class WoDeZiLiaoActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton  mMe_button_返回;
    private TextView     mMe_text_云算号;
    private LinearLayout mMe_button_linearlayout_查看二维码;
    private LinearLayout mMe_button_linearlayout_姓名;
    private TextView     mMe_text_姓名;
    private LinearLayout mMe_button_linearlayout_修改电话号码;
    private TextView     mMe_text_电话号码;
    private LinearLayout mMe_button_linearlayout_修改性别;
    private TextView     mMe_text_性别;
    private LinearLayout mMe_button_linearlayout_修改出生年月;
    private TextView     mMe_text_出生年月;
    private LinearLayout mMe_button_linearlayout_修改地址;
    private TextView     mMe_text_住址;
    private LinearLayout mMe_button_linearlayout_修改密码;
    private Button       mMe_button_退出登录;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_zhanghuxinxi);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, WoDeZiLiaoActivity.class);
        context.startActivity(intent);
    }

    private void initView() {

        /**
         * 初始化id
         */
        mMe_button_返回 = findViewById(R.id.me_button_返回);
        mMe_text_云算号 = findViewById(R.id.me_text_云算号);
        mMe_button_linearlayout_查看二维码 = findViewById(R.id.me_button_linearlayout_查看二维码);
        mMe_button_linearlayout_姓名 = findViewById(R.id.me_button_linearlayout_姓名);
        mMe_text_姓名 = findViewById(R.id.me_text_姓名);
        mMe_button_linearlayout_修改电话号码 = findViewById(R.id.me_button_linearlayout_修改电话号码);
        mMe_text_电话号码 = findViewById(R.id.me_text_电话号码);
        mMe_button_linearlayout_修改性别 = findViewById(R.id.me_button_linearlayout_修改性别);
        mMe_text_性别 = findViewById(R.id.me_text_性别);
        mMe_button_linearlayout_修改出生年月 = findViewById(R.id.me_button_linearlayout_修改出生年月);
        mMe_text_出生年月 = findViewById(R.id.me_text_出生年月);
        mMe_button_linearlayout_修改地址 = findViewById(R.id.me_button_linearlayout_修改地址);
        mMe_text_住址 = findViewById(R.id.me_text_住址);
        mMe_button_linearlayout_修改密码 = findViewById(R.id.me_button_linearlayout_修改密码);
        mMe_button_退出登录 = findViewById(R.id.me_button_退出登录);

        PersonCenterModel.Data data = (PersonCenterModel.Data) getIntent().getSerializableExtra("data");
        if(data!=null){
            mMe_text_云算号.setText(data.getAccount());
            mMe_text_姓名.setText(data.getName());
            mMe_text_电话号码.setText(data.getTel());
            if(data.getSex()==0){
                mMe_text_性别.setText("未设置");
            }else if(data.getSex()==1){
                mMe_text_性别.setText("男");
            }else if(data.getSex()==2){
                mMe_text_性别.setText("女");
            }
            mMe_text_出生年月.setText(data.getBirth());
            mMe_text_住址.setText(data.getAbsolute_address());
        }

    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        mMe_button_返回.setOnClickListener(this);
        mMe_button_linearlayout_查看二维码.setOnClickListener(this);
        mMe_button_linearlayout_姓名.setOnClickListener(this);
        mMe_button_linearlayout_修改电话号码.setOnClickListener(this);
        mMe_button_linearlayout_修改性别.setOnClickListener(this);
        mMe_button_linearlayout_修改出生年月.setOnClickListener(this);
        mMe_button_linearlayout_修改地址.setOnClickListener(this);
        mMe_button_linearlayout_修改密码.setOnClickListener(this);
        mMe_button_退出登录.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.me_button_返回:
                finish();
                break;

            case R.id.me_button_linearlayout_查看二维码:
                WoDeErWeiMaActivity.start(this);
                break;
            case R.id.me_button_linearlayout_姓名:
                ResetNameActivity.start(this);
                break;
            case R.id.me_button_linearlayout_修改电话号码:
                ResetPhoneActivity.start(this);
                break;
            case R.id.me_button_linearlayout_修改性别:
                Toast.makeText(this, "你点击了修改性别", Toast.LENGTH_SHORT).show();
                break;
            case R.id.me_button_linearlayout_修改出生年月:
                ResetBirthDayActivity.start(this);
                break;
            case R.id.me_button_linearlayout_修改地址:
                ResetDiZhiActivity.start(this);
                break;
            case R.id.me_button_linearlayout_修改密码:
                ResetPassWordActivity.start(this);
                break;
            case R.id.me_button_退出登录:
                LoginOut();
                Toast.makeText(this, "退出登录", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    /**
     * 退出登录
     */
    private void LoginOut() {
        XutilsHttp.getInstance().gethesder(AppConstants.URL + "agent/user/logOut", null, new XutilsHttp.XCallBack() {
            @Override
            public void onResponse(String result) {
                SpUtil.clear(AppConstants.SP.TOKEN); //chu
                ActivityManager.getInstance().finishAllActivity(); //清除掉所有activity
                LoginActivity.start(WoDeZiLiaoActivity.this);
            }

            @Override
            public void error(String message) {
                Log.i("hcc------->", "====error=====" + message);
            }
        });
    }
}
