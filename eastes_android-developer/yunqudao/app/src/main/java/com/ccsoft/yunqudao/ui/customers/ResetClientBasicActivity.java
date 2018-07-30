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
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.CustomersGetInfoBean;
import com.ccsoft.yunqudao.bean.Province;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.model.response.ClientPrivateData;
import com.ccsoft.yunqudao.data.model.response.ResultData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.DateUtil;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.InputUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LocalJsonResolutionUtils;
import com.ccsoft.yunqudao.utils.wheelview.TimePickerView;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.jaaksi.pickerview.dataset.OptionDataSet;
import org.jaaksi.pickerview.picker.BasePicker;
import org.jaaksi.pickerview.picker.OptionPicker;
import org.jaaksi.pickerview.widget.PickerView;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/28 0028
 */

public class ResetClientBasicActivity extends AppCompatActivity implements View.OnClickListener ,OptionPicker.OnOptionSelectListener{

    private TextView          mCustomers_edittext_name;
    private TextView customers_edittext_address3;
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
    private String provinceId ="", cityId =""/*= "230"*/, countyId=""/* = "234"*/;
    private OptionPicker mPicker;
    private Province province;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_add_customers1);
        HideIMEUtil.wrap(this);
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
        customers_edittext_address3 = findViewById(R.id.customers_edittext_address3);

        if (mClientPrivateData != null) {
            mCustomers_edittext_name.setText(mClientPrivateData.getData().getBasic().getName());
            mCustomers_text_birthday.setText(mClientPrivateData.getData().getBasic().getBirth());
            mCustomers_edittext_tel.setText(mClientPrivateData.getData().getBasic().getTel());
            mCustomers_edittext_card_id.setText(mClientPrivateData.getData().getBasic().getCard_id());
            mCustomers_edittext_address1.setText(mClientPrivateData.getData().getBasic().getAddress());
            mClient_id = mClientPrivateData.getData().getBasic().getClient_id();
            provinceId = mClientPrivateData.getData().getBasic().getProvince();
            cityId = mClientPrivateData.getData().getBasic().getCity();
            countyId = mClientPrivateData.getData().getBasic().getDistrict();
            mSex = mClientPrivateData.getData().getBasic().getSex()+"";
            if (mSex.equals(0+"")){
                mSex = "";
            }else if(mSex.equals("1")){
                mSex = "男";
            }else if(mSex.equals("2")){
                mSex = "女";
            }
            if(mClientPrivateData.getData().getBasic().getProvince_name()!=null) {
                customers_edittext_address3.setText(mClientPrivateData.getData().getBasic().getProvince_name()
                        + "-" + mClientPrivateData.getData().getBasic().getCity_name() + "-" +
                        mClientPrivateData.getData().getBasic().getDistrict_name());
            }
            setSpinnerItemSelectedByValue(mCustomers_spinner_sex,mSex);
            mCustomers_spinner_sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String[] languages = getResources().getStringArray(R.array.性别);
                    mSex = languages[i];
                    if (mSex.equals("男")) {
                        type = 1;
                    }
                    else if(mSex.equals("女")){
                        type = 2;
                    }else if(mSex.equals("")){
                        type = 0;
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
        mCustomers_text_birthday.setOnClickListener(this);
        customers_edittext_address3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customers_button_back:
                finish();
                break;

            case R.id.customers_text_birthday:

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

                if(provinceId.equals("null")&&cityId.equals("null")){
                    provinceId = "";
                    cityId = "";
                    countyId = "";
                }

                String birth = null;
                if (mCustomers_text_birthday.getText().toString().equals("0000-00-00")) {
                    OkHttpUtils.post(HttpAdress.update)
                            .tag(this)
                            .params("client_id", String.valueOf(mClient_id))
                            .params("name", mName)
                            .params("sex", String.valueOf(type))
                            .params("tel", mCustomers_edittext_tel.getText().toString())
                            .params("card_id", mCustomers_edittext_card_id.getText().toString())
                            .params("province",provinceId)
                            .params("city",cityId)
                            .params("district",countyId)
                            .params("address", mCustomers_edittext_address1.getText().toString())
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    StringModel model = JsonUtil.jsonToEntity(s, StringModel.class);
                                    if (model.getCode() == 200) {
                                        sendBroadcast(new Intent(AppConstants.REFRESH_CUSTOM_LIST));
                                        finish();
                                    }
                                    Toast.makeText(ResetClientBasicActivity.this, model.getMsg(), Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            });
                } else {

                    birth = mCustomers_text_birthday.getText().toString();


                    OkHttpUtils.post(HttpAdress.update)
                            .tag(this)
                            .params("client_id", String.valueOf(mClient_id))
                            .params("name", mName)
                            .params("sex", String.valueOf(type))
                            .params("tel", mCustomers_edittext_tel.getText().toString())
                            .params("birth", birth)
                            .params("card_id", mCustomers_edittext_card_id.getText().toString())
                            .params("province",provinceId)
                            .params("city",cityId)
                            .params("district",countyId)
                            .params("address", mCustomers_edittext_address1.getText().toString())
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    StringModel model = JsonUtil.jsonToEntity(s, StringModel.class);

                                    if (model.getCode() == 200) {
                                        sendBroadcast(new Intent(AppConstants.REFRESH_CUSTOM_LIST));
                                        finish();
                                    }
                                    Toast.makeText(ResetClientBasicActivity.this, model.getMsg(), Toast.LENGTH_SHORT).show();


                                }
                            });
                }
                break;
            case R.id.customers_edittext_address3:
                setCityPickerview();
                break;
        }
    }


    private void setCityPickerview(){

        String fileName = "region.json";
        String foodJson = LocalJsonResolutionUtils.getJson(this, fileName);
        province = LocalJsonResolutionUtils.JsonToObject(foodJson, Province.class);

        mPicker = new OptionPicker.Builder(this, 3, this)
                .setInterceptor(new BasePicker.Interceptor() {
                    @Override
                    public void intercept(PickerView pickerView) {
                        int color = getResources().getColor(R.color.gray);
                        pickerView.setTextSize(16,18);
                        pickerView.setColor(0xFF000000,color);
                    }
                })
                .create();
        mPicker.getTopBar().getTitleView().setText("请选择城市");
        mPicker.getTopBar().getTopBarView().setBackgroundColor(0xFF666666);
        mPicker.getTopBar().getTitleView().setBackgroundColor(0xFF666666);

        List<Province.DynamicBean> data = province.getDynamic();
        mPicker.setDataWithValues(data);
        mPicker.setSelectedWithValues(provinceId, cityId, countyId);
        mPicker.show();


    }
    @Override
    public void onOptionSelect(OptionPicker picker, int[] selectedPosition, OptionDataSet[] selectedOptions) {
        String text;
        Province.DynamicBean province = (Province.DynamicBean) selectedOptions[0];
        provinceId = province.getCode();
        Province.DynamicBean.CityBean city = (Province.DynamicBean.CityBean) selectedOptions[1];
        Province.DynamicBean.CityBean.DistrictBean county = (Province.DynamicBean.CityBean.DistrictBean) selectedOptions[2];
        if (city == null) {
            cityId = "";
            countyId = "";
            text = province.getName();
        } else {
            cityId = city.getCode();
            if (county == null) {
                countyId = "";
                text = city.getName();
            } else {
                cityId = city.getCode();
                countyId = county.getCode();
                text = province.getName()+"/"+city.getName()+"/"+county.getName();
            }
        }
        customers_edittext_address3.setText(text);

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

    /**
     * 设置spinner的值
     * @param spinner
     * @param value
     */

    public  void setSpinnerItemSelectedByValue(Spinner spinner,String value) {
        SpinnerAdapter apsAdapter = spinner.getAdapter(); //得到SpinnerAdapter对象
        int k = apsAdapter.getCount();
        for (int i = 0; i < k; i++) {
            if (value.equals(apsAdapter.getItem(i).toString())) {
//                spinner.setSelection(i,true);// 默认选中项
                spinner.setSelection(i);// 默认选中项

                break;
            }
        }
    }
}
