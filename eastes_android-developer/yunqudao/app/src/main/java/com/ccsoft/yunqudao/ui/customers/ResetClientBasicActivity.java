package com.ccsoft.yunqudao.ui.customers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.CustomersGetInfoBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.model.response.ClientPrivateData;
import com.ccsoft.yunqudao.data.model.response.ResultData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.DateUtil;
import com.ccsoft.yunqudao.utils.InputUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.wheelview.TimePickerView;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/28 0028
 */

public class ResetClientBasicActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView          mCustomers_edittext_name;
    private Spinner           mCustomers_spinner_sex;
    private TextView          mCustomers_text_birthday;
    private EditText          mCustomers_edittext_tel;
    private EditText          mCustomers_edittext_card_id;
    private EditText          mCustomers_edittext_address1;
    private ImageButton       mCustomers_button_back,mCustomers_button_birthday;
    private Button            mButton_next;
    private String            mTelnumber1;
    private String            mName;
    private String            mSex;
    private int               type;
    private int                mClient_id;
    private CustomersGetInfoBean mClientPrivateData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_add_customers1);
        initView();
        initListener();
    }

    public static void start(Context context, CustomersGetInfoBean mClientPrivateData) {

        Intent intent = new Intent(context, ResetClientBasicActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("clientbasic",  mClientPrivateData);
        intent.putExtra("data", bundle);
        context.startActivity(intent);
    }

//    private void getArgument() {
//        Bundle data = getIntent().getBundleExtra("data");
//        mClientPrivateData = (CustomersGetInfoBean) data.getSerializable("clientbasic");
//    }

    private void initView() {

//        getArgument();
        Bundle bundle = getIntent().getExtras();
        mClientPrivateData = (CustomersGetInfoBean) bundle.get("bean");
        mCustomers_button_back = findViewById(R.id.customers_button_back);
        mCustomers_edittext_name = findViewById(R.id.customers_edittext_name);
        mCustomers_spinner_sex = findViewById(R.id.customers_spinner_sex);
        mCustomers_text_birthday = findViewById(R.id.customers_text_birthday);
        mCustomers_edittext_tel = findViewById(R.id.customers_edittext_tel);
        mCustomers_edittext_card_id = findViewById(R.id.customers_edittext_card_id);
        mCustomers_edittext_address1 = findViewById(R.id.customers_edittext_address1);
        mButton_next = findViewById(R.id.button_next);
        mCustomers_button_birthday = findViewById(R.id.customers_button_birthday);

        if (mClientPrivateData != null) {
            mCustomers_edittext_name.setText(mClientPrivateData.getData().getBasic().getName());
            mCustomers_text_birthday.setText(mClientPrivateData.getData().getBasic().getBirth());
            mCustomers_edittext_tel.setText(mClientPrivateData.getData().getBasic().getTel());
            mCustomers_edittext_card_id.setText(mClientPrivateData.getData().getBasic().getCard_id());
            mCustomers_edittext_address1.setText(mClientPrivateData.getData().getBasic().getAddress());
            mClient_id = mClientPrivateData.getData().getBasic().getClient_id();
            mSex = mCustomers_spinner_sex.getSelectedItem().toString();
            mCustomers_spinner_sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String[] languages = getResources().getStringArray(R.array.性别);
                    mSex = languages[i];
                    if (mSex.equals("男")) {
                        type = 1;
                    }
                    else {
                        type = 2;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
    }

    private void initListener() {
        mCustomers_button_back.setOnClickListener(this);
        mButton_next.setOnClickListener(this);
        mCustomers_button_birthday.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customers_button_back:
                finish();
                break;

            case R.id.customers_button_birthday:

                showBirthdayPicker(mCustomers_text_birthday.getText().toString());
                break;

            case R.id.button_next:
                mName = mCustomers_edittext_name.getText().toString();
                if (TextUtils.isEmpty(mName)) {
                    Toast.makeText(this, "请输入姓名", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(mCustomers_edittext_tel.getText())) {
                    Toast.makeText(this, "联系号码不能为空1", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!InputUtil.isMobileLegal(mCustomers_edittext_tel.getText().toString())) {
                    Toast.makeText(this, "请输入正确的手机号1", Toast.LENGTH_SHORT).show();
                    return;
                }
                OkHttpUtils.post(HttpAdress.update)
                        .tag(this)
                        .params("client_id",String.valueOf(mClient_id))
                        .params("name", mName)
                        .params("sex",String.valueOf(type))
                        .params("tel", mCustomers_edittext_tel.getText().toString())
                        .params("birth", mCustomers_text_birthday.getText().toString())
                        .params("card_id", mCustomers_edittext_card_id.getText().toString())
                        .params("address", mCustomers_edittext_address1.getText().toString())
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                StringModel model = JsonUtil.jsonToEntity(s,StringModel.class);
                                if(model.getCode()==200){
                                    sendBroadcast(new Intent(AppConstants.REFRESH_CUSTOM_LIST));
                                    finish();
                                }
                                Toast.makeText(ResetClientBasicActivity.this,model.getMsg(),Toast.LENGTH_SHORT).show();
                            }
                        });

//                XutilsHttp.getInstance().postheader(AppConstants.URL + "agent/client/update", params, new XutilsHttp.XCallBack() {
//                    @Override
//                    public void onResponse(String result) {
//                        Log.d("66666666------》", result.toString());
//                        Toast.makeText(ResetClientBasicActivity.this, "修改加客户基本信息成功", Toast.LENGTH_SHORT).show();
//                        sendBroadcast(new Intent(AppConstants.REFRESH_CUSTOM_LIST));
//                    }
//
//                    @Override
//                    public void error(String message) {
//                        Toast.makeText(ResetClientBasicActivity.this, "修改客户基本信息失败:" + message, Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                CustomersXiangQingActivity.start(this,mClient_id);
//                finish();
                break;
        }


    }

    private void showBirthdayPicker(String birthdayStr) {
        Calendar selectedDate = Calendar.getInstance();
        if (!TextUtils.isEmpty(birthdayStr) && !birthdayStr.equals("无")) {
            Date birthdayDate = DateUtil.stringToDate(birthdayStr);
            selectedDate.setTime(birthdayDate);
        }

        Calendar startDate = Calendar.getInstance();
        startDate.set(1950, 0, 1);

        Calendar endDate = Calendar.getInstance();

        TimePickerView.Builder builder = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {   // 选中事件回调
                mCustomers_text_birthday.setText(DateUtil.dateToString(date));
            }
        }).setDividerColor(R.color.danlan) // 设置分割线的颜色
          .setTextColorCenter(Color.parseColor("#333333")) // 设置分割线之间的文字的颜色
          .setTextColorOut(Color.parseColor("#cccccc"))    // 设置分割线以外文字的颜色
          .setContentSize(18)   // 设置滚轮字体大小
          .setOutSideCancelable(true)   // 设置允许点击外面消失
          .isCenterLabel(false) // 是否只显示中间选中项的label文字，false则每项item全部都带有label
          .setSubmitColor(R.color.colorPrimary)  // 设置“确定”的字体颜色
          .setCancelColor(Color.parseColor("#333333"))  // 设置“取消”的字体颜色
          .setSubCalSize(16)    // 设置“确定”和“取消”的字体大小
          .setTitleBgColor(Color.parseColor("#ffffff"))// 设置标题背景色
          .setType(new boolean[] { true, true, true, false, false, false })  // 设置类型
          .setDate(selectedDate)    // 设置默认时间
          .setRangDate(startDate, endDate);  // 设置时间范围

        TimePickerView timePickerView = new TimePickerView(builder);
        timePickerView.show();
    }
}
