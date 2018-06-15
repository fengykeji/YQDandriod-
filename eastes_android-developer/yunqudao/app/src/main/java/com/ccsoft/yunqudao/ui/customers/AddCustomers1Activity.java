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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.MessageEvent;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.MyStringCallBack;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.ui.mian.RegisterActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.DateUtil;
import com.ccsoft.yunqudao.utils.IDCardCheckUtil;
import com.ccsoft.yunqudao.utils.InputUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.wheelview.TimePickerView;
import com.lzy.okhttputils.OkHttpUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/4 0004
 */

public class AddCustomers1Activity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 添加客户1 id
     *
     * @param savedInstanceState
     */
    private ImageButton  mCustomers_button_back;
    private EditText     mCustomers_edittext_name;
    private Spinner      mCustomers_spinner_sex;
    private TextView     mCustomers_text_barthday;
    private ImageButton  mCustomers_button_birthday;
    private LinearLayout mCustomers_linearlayout_tel;
    private TextView     mCustomers_edittext_tel;
    private Spinner      mCustomers_spinner_card_type;
    private EditText     mCustomers_edittext_card_id;
    private Button       mButton_next;
    private EditText     mCustomers_edittext_address;

    private static final String TAG = "MainActivity";
    private String mTelnumber1;
    private String mName;
    private String mSex;
    private int    type;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_add_customers1);
        EventBus.getDefault().register(this);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, AddCustomers1Activity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         * 初始化id
         */
        mCustomers_button_back = findViewById(R.id.customers_button_back);
        mCustomers_edittext_name = findViewById(R.id.customers_edittext_name);
        mCustomers_spinner_sex = findViewById(R.id.customers_spinner_sex);
        mCustomers_text_barthday = findViewById(R.id.customers_text_birthday);
        mCustomers_button_birthday = findViewById(R.id.customers_button_birthday);

        mCustomers_linearlayout_tel = findViewById(R.id.customers_linearlayout_tel);
        mCustomers_edittext_tel = findViewById(R.id.customers_edittext_tel);
        mCustomers_spinner_card_type = findViewById(R.id.customers_spinner_card_type);
        mCustomers_edittext_card_id = findViewById(R.id.customers_edittext_card_id);
        mCustomers_edittext_address = findViewById(R.id.customers_edittext_address1);
        mButton_next = findViewById(R.id.button_next);
        mSex = mCustomers_spinner_sex.getSelectedItem().toString();
        Log.e("spinner1",mSex);
        if (mSex.equals("男")) {
            type = 1;
        }
        else {
            type = 2;
        }
    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        mCustomers_button_back.setOnClickListener(this);
        //mCustomers_button_添加联系号码.setOnClickListener(this);

        mButton_next.setOnClickListener(this);
        mCustomers_button_birthday.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.customers_button_back:
                finish();
                break;

            case R.id.button_next:
//                AddCustomers2Activity.start(AddCustomers1Activity.this);
                mName = mCustomers_edittext_name.getText().toString();
                if (TextUtils.isEmpty(mCustomers_edittext_name.getText())) {
                    Toast.makeText(this, "请输入姓名", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(mCustomers_edittext_tel.getText().toString())) {
                    Toast.makeText(this, "联系号码不能为空1", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!InputUtil.isMobileLegal(mCustomers_edittext_tel.getText().toString())) {
                    Toast.makeText(this, "请输入正确的手机号1", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(AddCustomers1Activity.this,AddCustomers2Activity.class);
                intent.putExtra("name", mName);
                if (type!=1&&type!=2){
                    String s= String.valueOf(type);
                    s="";
                    intent.putExtra("sex", String.valueOf(s));
                }else {
                    intent.putExtra("sex", String.valueOf(type));
                }
                intent.putExtra("tel", mCustomers_edittext_tel.getText().toString());
                if(mCustomers_text_barthday.getText().toString()==null){
                    intent.putExtra("birth", "");
                }else {
                    intent.putExtra("birth", mCustomers_text_barthday.getText().toString());
                }if(mCustomers_edittext_card_id.getText().toString()==null){
                intent.putExtra("card_id","");
            }else {
                intent.putExtra("card_id", mCustomers_edittext_card_id.getText().toString());
            }if(mCustomers_edittext_address.getText().toString()==null){
                    intent.putExtra("address","");
            }
                intent.putExtra("address",mCustomers_edittext_address.getText().toString());
            startActivity(intent);

//                OkHttpUtils.post(HttpAdress.addClientAndNeed)
//                        .tag(this)
//                        .params("name", mName)
//                        .params("sex", String.valueOf(type))
//                        .params("tel", mCustomers_edittext_tel.getText().toString())
//                        .params("birth", mCustomers_text_barthday.getText().toString())
//                        .params("card_id",mCustomers_edittext_card_id.getText().toString())
//                        .params("address",mCustomers_edittext_address.getText().toString())
//                        .execute(new MyStringCallBack() {
//                            @Override
//                            public void onSuccess(String s, Call call, Response response) {
//                                super.onSuccess(s, call, response);
//                                StringModel model = JsonUtil.jsonToEntity(s,StringModel.class);
//                                if(model.getCode()==200){
//                                    Toast.makeText(AddCustomers1Activity.this, ":添加客户基本信息成功", Toast.LENGTH_SHORT).show();
//                                    sendBroadcast(new Intent(AppConstants.REFRESH_CUSTOM_LIST));
//                                    AddCustomers2Activity.start(AddCustomers1Activity.this);
//                                }
//                                Toast.makeText(AddCustomers1Activity.this,model.getMsg(),Toast.LENGTH_SHORT).show();
//                            }
//                        });

                break;
            case R.id.customers_button_birthday:
                showBirthdayPicker(mCustomers_text_barthday.getText().toString());
                break;
        }
    }

    /**
     * 显示生日时间选择器
     *
     * @param birthdayStr
     */
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
                mCustomers_text_barthday.setText(DateUtil.dateToString(date));
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    protected void Event(MessageEvent messageEvent) {
        Log.e(TAG, "Event----->" + messageEvent.getMessage());
        if (messageEvent.getMessage().equals(AppConstants.EVENTBUS.FINISH_ADD_CUSTOMERS)) {
            Log.e(TAG, "添加客户1 已被关闭");
            finish();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageEvent messageEvent) {

    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
