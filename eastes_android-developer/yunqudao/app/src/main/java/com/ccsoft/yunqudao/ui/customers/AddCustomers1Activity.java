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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.bean.ProjectFastRecommendListBean;
import com.ccsoft.yunqudao.bean.Province;
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
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.IDCardCheckUtil;
import com.ccsoft.yunqudao.utils.InputUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LocalJsonResolutionUtils;
import com.ccsoft.yunqudao.utils.wheelview.TimePickerView;
import com.ccsoft.yunqudao.utils.wheelview.listener.WheelView;
import com.lljjcoder.citypickerview.widget.CityPicker;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jaaksi.pickerview.dataset.OptionDataSet;
import org.jaaksi.pickerview.picker.BasePicker;
import org.jaaksi.pickerview.picker.OptionPicker;
import org.jaaksi.pickerview.widget.PickerView;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/4 0004
 */

public class AddCustomers1Activity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener,OptionPicker.OnOptionSelectListener {
    /**
     * 添加客户1 id
     *
     * @param savedInstanceState
     */
    private ImageButton  mCustomers_button_back;
    private EditText     mCustomers_edittext_name;
    private Spinner      mCustomers_spinner_sex;
    private TextView     mCustomers_text_barthday,mNeed_text_address2;
    private ImageButton  mCustomers_button_birthday;
    private LinearLayout mCustomers_linearlayout_tel;
    private TextView     mCustomers_edittext_tel;
    private Spinner      mCustomers_spinner_card_type;
    private EditText     mCustomers_edittext_card_id;
    private Button       mButton_next;
    private EditText     mCustomers_edittext_address;
    private TextView     mCustomers_edittext_address3;

    private static final String TAG = "MainActivity";
    private String mTelnumber1;
    private String mName;
    private String mSex;
    private int    type;
    private String fastR ="";
    private int project_id;
    private String provinceId ="", cityId =""/*= "230"*/, countyId=""/* = "234"*/;
    private OptionPicker mPicker;
    private Province province;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_add_customers1);
        HideIMEUtil.wrap(this);
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
        mNeed_text_address2 = findViewById(R.id.customers_edittext_address2);

        mCustomers_linearlayout_tel = findViewById(R.id.customers_linearlayout_tel);
        mCustomers_edittext_tel = findViewById(R.id.customers_edittext_tel);
        mCustomers_spinner_card_type = findViewById(R.id.customers_spinner_card_type);
        mCustomers_edittext_card_id = findViewById(R.id.customers_edittext_card_id);
        mCustomers_edittext_address = findViewById(R.id.customers_edittext_address1);
        mCustomers_edittext_address3 = findViewById(R.id.customers_edittext_address3);
        mButton_next = findViewById(R.id.button_next);
        mSex = mCustomers_spinner_sex.getSelectedItem().toString();
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
                    type =0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        fastR = getIntent().getStringExtra("fastR");
        project_id = getIntent().getIntExtra("project_id",0);

    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        mCustomers_button_back.setOnClickListener(this);
        //mCustomers_button_添加联系号码.setOnClickListener(this);

        mButton_next.setOnClickListener(this);
        mCustomers_button_birthday.setOnClickListener(this);
        mNeed_text_address2.setOnClickListener(this);
        mCustomers_text_barthday.setOnClickListener(this);
        mCustomers_edittext_address3.setOnClickListener(this);
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
                    Toast.makeText(this, "联系号码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!InputUtil.isMobileLegal(mCustomers_edittext_tel.getText().toString())) {
                    Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
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

            intent.putExtra("province",provinceId);
                intent.putExtra("city",cityId);
                intent.putExtra("district",countyId);
                intent.putExtra("address",mCustomers_edittext_address.getText().toString());
                intent.putExtra("fastR",fastR);
                intent.putExtra("project_id",project_id);
            startActivity(intent);
            finish();
                break;
            case R.id.customers_text_birthday:
                showBirthdayPicker(mCustomers_text_barthday.getText().toString());
                break;
                case R.id.customers_edittext_address2:
                    selectAddress();
                    break;
            case R.id.customers_edittext_address3:
                setCityPickerview();
                break;
        }
    }

    /**
     * 城市选择
     */
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
        mCustomers_edittext_address3.setText(text);

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

    private void selectAddress() {
        CityPicker cityPicker = new CityPicker.Builder(this)
                .textSize(14)
                .title("地址选择")
                .titleBackgroundColor("#FFFFFF")
//                .titleTextColor("#696969")
                .confirTextColor("#696969")
                .cancelTextColor("#696969")
                .province("四川省")
                .city("成都市")
                .district("金牛区")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .districtCyclic(false)
                .visibleItemsCount(7)
                .itemPadding(15)
                .onlyShowProvinceAndCity(false)
                .build();
        cityPicker.show();
        //监听方法，获取选择结果
        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                //省份
                String province = citySelected[0];
                //城市
                String city = citySelected[1];
                //区县（如果设定了两级联动，那么该项返回空）
                String district = citySelected[2];
                //邮编
                String code = citySelected[3];
                //为TextView赋值
                mNeed_text_address2.setText(province.trim()+ city.trim()+ district.trim());
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
