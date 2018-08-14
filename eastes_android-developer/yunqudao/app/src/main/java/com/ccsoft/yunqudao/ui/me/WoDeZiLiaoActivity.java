package com.ccsoft.yunqudao.ui.me;

import android.content.Context;
import android.content.DialogInterface;
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
import com.ccsoft.yunqudao.bean.WorkDealedBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.model.PersonCenterModel;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.ui.mian.LoginActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.ItemsDialogFragment;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.SpUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

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
    protected void onStart() {
        super.onStart();
        initData();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_zhanghuxinxi);
        HideIMEUtil.wrap(this);
        initView();
        initData();
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



//        PersonCenterModel.Data data = (PersonCenterModel.Data) getIntent().getSerializableExtra("data");


    }

    private void initData(){
        OkHttpUtils.post(HttpAdress.megetBaseInfo)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        int code = 0;
                        String data1 = null;
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            code = jsonObject.getInt("code");
                            data1 = jsonObject.getString("data");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (code == 200 && data1 != null) {
                            PersonCenterModel.Data data = JsonUtil.jsonToEntity(data1,PersonCenterModel.Data.class);
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
                    }
                });
    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        mMe_button_返回.setOnClickListener(this);
        mMe_button_linearlayout_查看二维码.setOnClickListener(this);
        mMe_button_linearlayout_姓名.setOnClickListener(this);
//        mMe_button_linearlayout_修改电话号码.setOnClickListener(this);
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
//                WoDeErWeiMaActivity.start(this);
                Intent intent1 = new Intent(this,WoDeErWeiMaActivity.class);
                intent1.putExtra("mename",mMe_text_姓名.getText().toString());
                intent1.putExtra("Account",mMe_text_云算号.getText().toString());
                startActivity(intent1);
                break;
            case R.id.me_button_linearlayout_姓名:
                ResetNameActivity.start(this);
                break;
//            case R.id.me_button_linearlayout_修改电话号码:
//                ResetPhoneActivity.start(this);
//                break;
            case R.id.me_button_linearlayout_修改性别:
                showItemsDialogFragment();
                break;
            case R.id.me_button_linearlayout_修改出生年月:
//                ResetBirthDayActivity.start(this);
                Intent intent = new Intent(WoDeZiLiaoActivity.this,ResetBirthDayActivity.class);
                intent.putExtra("birth",mMe_text_出生年月.getText().toString());
                startActivity(intent);
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
                Intent intent = new Intent(WoDeZiLiaoActivity.this,LoginActivity.class);
                intent.putExtra("account",SpUtil.getString("account",""));
                intent.putExtra("password",SpUtil.getString("password",""));
                startActivity(intent);
                SpUtil.clear(AppConstants.SP.TOKEN); //chu
                ActivityManager.getInstance().finishAllActivity(); //清除掉所有activity

            }

            @Override
            public void error(String message) {
                Log.i("hcc------->", "====error=====" + message);
            }
        });
    }

    public void showItemsDialogFragment() {
        ItemsDialogFragment itemsDialogFragment = new ItemsDialogFragment();
        String[] items = {"男", "女","取消" };
        itemsDialogFragment.show("", items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        updata(1);

                        break;
                    case 1:
                        updata(2);

                        break;
                    case 2:
                        itemsDialogFragment.dismiss();
                        break;

                }
            }
        }, getSupportFragmentManager());
    }

    /**
     * 修改个人信息
     */
    public void updata(int sex){
        OkHttpUtils.post(HttpAdress.meupdate)
                .params("sex",sex)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        StringModel model = JsonUtil.jsonToEntity(s,StringModel.class);
                        if(model.getCode() == 200){
                            initData();
                        }

                    }
                });
    }

}
