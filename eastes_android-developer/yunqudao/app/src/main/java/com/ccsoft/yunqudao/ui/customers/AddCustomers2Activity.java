package com.ccsoft.yunqudao.ui.customers;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GetHouseTypeDetailBean;
import com.ccsoft.yunqudao.bean.MessageEvent;

import com.ccsoft.yunqudao.bean.Province;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.model.response.OpenCityData;
import com.ccsoft.yunqudao.data.model.response.ResultData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.MyStringCallBack;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.model.StringModel;


import com.ccsoft.yunqudao.ui.home.HomeActivity;
import com.ccsoft.yunqudao.ui.house.AdvicerChooseActivity;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LocalJsonResolutionUtils;
import com.ccsoft.yunqudao.utils.LogUtil;

import com.google.gson.Gson;
import com.lljjcoder.citypickerview.widget.CityPicker;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jaaksi.pickerview.dataset.OptionDataSet;
import org.jaaksi.pickerview.picker.BasePicker;
import org.jaaksi.pickerview.picker.OptionPicker;
import org.jaaksi.pickerview.widget.PickerView;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/4 0004
 */

public class AddCustomers2Activity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener ,OptionPicker.OnOptionSelectListener{

    /**
     * 添加客户2 id
     *
     * @param savedInstanceState
     */
    private ImageButton mCustomers_button_back;
    private Button mCustomers_button_commit;
    private ImageButton mCustomers_button_add;
    private EditText mCustomers_text_seekbar1;
    private EditText mCustomers_text_seekbar2;
    private SeekBar mCustomers_seekbar1;
    private SeekBar mCustomers_seekbar2;
    private Spinner mSpinner_address, mSpinner_property_type, mSpinner_total_price, mSpinner_area, mSpinner_house_type, mSpinner_decorated, mSpinner_buy_type, mSpinner_pay_type;
    private TextView mNeed_text_address, tv_showlabel, mNeed_text_property_type, mNeed_text_total_price, mNeed_text_area, mNeed_text_house_type, mNeed_text_decorated, mNeed_text_buy_type, mNeed_text_pay_type;
    private EditText et_floor_min, et_floor_max, et_comment;
    private LinearLayout ll_showlabel;
    private String mString1;
    private String mString2;
    private String mString3;
    private String mString4;
    private String mString5;
    private String mString6;
    private String mString7;
    private String mString8;
    private String name;
    private String sex;
    private String tel;
    private String birth;
    private String card_id;
    private String address;
    private ArrayAdapter adapter1, adapter2, adapter3, adapter4, adapter5, adapter6, adapter7, adapter8;
    private int house_type;
    private String floor_min;
    private String floor_max;
    private int decorate;
    private int buy_purpose;
    private int pay_type;
    private int price;
    private int area;
    private String intent3;
    private String urgency;
    private String comment = "";
    private List<String> list = new ArrayList<>();
    private Date date;
    private int property_type;
    private int card_type = 17;
    private ArrayList<Integer> Idlist = new ArrayList<>();
    private String need_tags = "";
//    private OptionsPickerView pvOptions ;
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private String fastR ="";
    private int project_id;
    private int progress = 0;
    private boolean flag = true;
    private String provinceId ="", cityId =""/*= "230"*/, countyId=""/* = "234"*/,region = "";
    private String provinceId1 ="", cityId1 =""/*= "230"*/, countyId1=""/* = "234"*/;

    private OptionPicker mPicker;
    private Province province;
    private OpenCityData         openCityData;
    private List<OpenCityData.DataBean> mDataBeans = new ArrayList<>();
    private GetHouseTypeDetailBean  bean;





    @Subscribe(threadMode = ThreadMode.MAIN)
    public void doThis(IntentServiceResult intentServiceResult) {
        Idlist = intentServiceResult.getList();
        list = intentServiceResult.getLists();

        if (Idlist != null) {
            for (int i = 0; i < Idlist.size(); i++) {
                int id = Idlist.get(i);
                if (i == 0) {
                    need_tags = String.valueOf(Idlist.get(i));
                } else {
                    need_tags = need_tags.concat("," + String.valueOf(id));
                }
            }
        }

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.leftMargin =10;
        if (list != null) {
//            list = getIntent().getStringArrayListExtra("lists");
            for (int i = 0; i < list.size(); i++) {
                TextView textView = new TextView(AddCustomers2Activity.this);
                textView.setText(list.get(i));
                textView.setBackgroundResource(R.drawable.shape_addlabel);
                textView.setPadding(14, 14, 14, 14);
                textView.setTextSize(16);
//                int c = getColor(R.color.b)
                textView.setTextColor(0x7f06004c);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                textView.setMaxEms(4);
                ll_showlabel.addView(textView, layoutParams);
                tv_showlabel.setVisibility(View.GONE);
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_add_customers2);
        HideIMEUtil.wrap(this);
        EventBus.getDefault().register(this);
        initView();
        initData();
        initListener();
    }

    private void initView() {
        /**
         * 初始化id
         */
        mCustomers_button_back = findViewById(R.id.customers_button_back);
        mCustomers_button_add = findViewById(R.id.customers_button_add);
        mCustomers_button_commit = findViewById(R.id.customers_button_commit);
        mCustomers_text_seekbar1 = findViewById(R.id.customers_text_seekbar1);
        mCustomers_text_seekbar2 = findViewById(R.id.customers_text_seekbar2);
        mCustomers_seekbar1 = findViewById(R.id.customers_seekbar1);
        mCustomers_seekbar2 = findViewById(R.id.customers_seekbar2);
//        mSpinner_address = findViewById(R.id.spinner_address);
        mSpinner_property_type = findViewById(R.id.spinner_property_type);
        mSpinner_total_price = findViewById(R.id.spinner_total_price);
        mSpinner_area = findViewById(R.id.spinner_area);
        mSpinner_house_type = findViewById(R.id.spinner_house_type);
        mSpinner_decorated = findViewById(R.id.spinner_decorated);
        mSpinner_buy_type = findViewById(R.id.spinner_buy_type);
        mSpinner_pay_type = findViewById(R.id.spinner_pay_type);
        mNeed_text_address = findViewById(R.id.need_text_address);
        et_floor_min = findViewById(R.id.tv_floor_min);
        et_floor_max = findViewById(R.id.tv_floor_max);
        et_comment = findViewById(R.id.ed_comment);
        tv_showlabel = findViewById(R.id.tv_showlabel);
        ll_showlabel = findViewById(R.id.ll_showlabel);

        mNeed_text_property_type = findViewById(R.id.need_text_property_type);
//        mNeed_text_total_price = findViewById(R.id.need_text_total_price);
//        mNeed_text_area = findViewById(R.id.need_text_area);
//        mNeed_text_house_type = findViewById(R.id.need_text_house_type);
//        mNeed_text_decorated = findViewById(R.id.need_text_decorated);
//        mNeed_text_buy_type = findViewById(R.id.need_text_buy_type);
//        mNeed_text_pay_type = findViewById(R.id.need_text_pay_type);
//        mString1 = (String) mSpinner_address.getSelectedItem();
        mString2 = (String) mSpinner_property_type.getSelectedItem();
        mString3 = (String) mSpinner_total_price.getSelectedItem();
        mString4 = (String) mSpinner_area.getSelectedItem();
        mString5 = (String) mSpinner_house_type.getSelectedItem();
        mString6 = (String) mSpinner_decorated.getSelectedItem();
        mString7 = (String) mSpinner_buy_type.getSelectedItem();
        mString8 = (String) mSpinner_pay_type.getSelectedItem();

        mCustomers_text_seekbar1.addTextChangedListener(new textChange(mCustomers_text_seekbar1));
        mCustomers_text_seekbar2.addTextChangedListener(new textChange1(mCustomers_text_seekbar2));

        Submit();

        fastR = getIntent().getStringExtra("fastR");
        project_id = getIntent().getIntExtra("project_id",0);



        setSpinnerAdapter();


    }

    private void initListener() {
        /**
         * 初始化监听器
         */


        mCustomers_button_back.setOnClickListener(this);
        mCustomers_button_add.setOnClickListener(this);
        mCustomers_button_commit.setOnClickListener(this);
        mCustomers_text_seekbar1.setOnClickListener(this);
        mCustomers_text_seekbar2.setOnClickListener(this);
        mCustomers_seekbar1.setOnSeekBarChangeListener(this);
        mCustomers_seekbar2.setOnSeekBarChangeListener(this);
        mNeed_text_address.setOnClickListener(this);







    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.customers_button_back:
                finish();
                break;
            case R.id.customers_button_add:
//                AddLabelActivity.start(this);
                Intent intent1 = new Intent(AddCustomers2Activity.this,AddLabelActivity.class);
                intent1.putExtra("name",name);
                intent1.putExtra("sex",sex);
                intent1.putExtra("tel",tel);
                intent1.putExtra("birth",birth);
                intent1.putExtra("card_id",card_id);
                intent1.putExtra("address",address);

                startActivity(intent1);
                break;
            case R.id.need_text_address:
                setCityPickerview();
                break;
            case R.id.customers_button_commit:


                if (mString2 == null) {
                    property_type = 0;
                } else if (mString2.equals("住宅")) {
                    property_type = 59;
                } else if (mString2.equals("公寓")) {
                    property_type = 60;
                } else if (mString2.equals("别墅")) {
                    property_type = 61;
                } else if (mString2.equals("商铺")) {
                    property_type = 62;
                } else if (mString2.equals("写字楼")) {
                    property_type = 63;
                }
                if (mString3 == null) {
                    price = 0;
                }else if(mString3.equals("50")){
                    price = 91;
                }else if(mString3.equals("50-80")){
                    price = 92;
                }else if(mString3.equals("80-120")){
                    price = 93;
                }else if(mString3.equals("120-200")){
                    price = 94;
                }else if(mString3.equals("200")){
                    price = 95;
                }

                if (mString4 == null) {
                    area = 0;
                }else if(mString4.equals("50")){
                    area=96;
                }else if(mString4.equals("50-90")){
                    area=97;
                }else if(mString4.equals("90-130")){
                    area=98;
                }else if(mString4.equals("130-150")){
                    area=99;
                }else if(mString4.equals("150")){
                    area=100;
                }

                if (mString5 == null) {
                    house_type = 0;
                } else if (mString5.equals("3室2厅2卫")) {
                    house_type = 32;
                } else if (mString5.equals("1室1厅2卫")) {
                    house_type = 33;
                } else if (mString5.equals("1室1厅1卫")) {
                    house_type = 106;
                }
                if (et_floor_min.getText()==null) {
                    floor_min = "";
                } else {
                    floor_min = et_floor_min.getText().toString();
                }
                if (et_floor_max.getText()==null) {
                    floor_max = "";
                } else {
                    floor_max = et_floor_max.getText().toString();
                }
                if (mString6 == null) {
                    decorate = 0;
                } else if (mString6.equals("毛坯")) {
                    decorate = 80;
                } else if (mString6.equals("简装")) {
                    decorate = 81;
                } else if (mString6.equals("精装")) {
                    decorate = 82;
                }
                if (mString7 == null) {
                    buy_purpose = 0;
                }
                if (mString7.equals("投资")) {
                    buy_purpose = 43;
                } else if (mString7.equals("自住")) {
                    buy_purpose = 44;
                } else if (mString7.equals("投资兼自住")) {
                    buy_purpose = 45;
                }
                if (mString8 == null) {
                    pay_type = 0;
                } else if (mString8.equals("一次性付款")) {
                            pay_type = 46;
                        } else if (mString8.equals("公积金贷款")){
                            pay_type = 47;
                        } else if (mString8.equals("综合贷款")) {
                            pay_type = 48;
                        } else if (mString8.equals("银行按揭贷款")) {
                            pay_type = 49;
                        } else if (mString8.equals("分期付款")) {
                            pay_type = 50;
                        }

                if (mCustomers_text_seekbar1.getText()==null) {
                    intent3 = "";
                } else {
                    intent3 = mCustomers_text_seekbar1.getText().toString();
                }
                if (mCustomers_text_seekbar2.getText()==null) {
                    urgency = "";
                } else {
                    urgency = mCustomers_text_seekbar2.getText().toString();
                }

                if (et_comment.getText() == null) {
                    comment = "";
                } else {
                    comment = et_comment.getText().toString();
                }

                if(provinceId.equals("null")&&cityId.equals("null")){
                    provinceId = "";
                    cityId ="";
                    countyId ="";
                }

                if(cityId1.equals("null")&&countyId1.equals("null")){
                    region="";
                }


                Log.e("cccccw",name+"name "+sex+"sex  "+tel+"tel  "+birth+"bir  "+
                card_id+"card  "+address+"address  "+property_type+"pro  "+price+"m3  "+
                area+"m4  "+house_type+" house "+floor_min+"min  "+floor_max+"max  "+
                decorate+"dec  "+buy_purpose+"buy  "+pay_type+"pay  "+intent3+"int  "+
                urgency+"urg  "+need_tags+"need "+comment+"comment"+provinceId+"provinceId"
                +cityId +"cityId"+countyId+"countyId"+"region"+region);

                if(fastR!=null&&fastR.equals("fastR")){

                    getHouseTypeDatil(project_id);

                    return;
                }


                OkHttpUtils.post(HttpAdress.addClientAndNeed)
                        .tag(this)
                        .params("name", name)
                        .params("sex", sex)
                        .params("tel", tel)
                        .params("birth", birth)
                        .params("card_type",card_type)
                        .params("card_id", card_id)
                        .params("province",provinceId)
                        .params("city",cityId)
                        .params("district",countyId)
                        .params("address", address)
                        .params("region",region)
                        .params("property_type", property_type)
                        .params("total_price", price)
                        .params("area", area)
                        .params("house_type", house_type)
                        .params("floor_min", floor_min)
                        .params("floor_max", floor_max)
                        .params("decorate", decorate)
                        .params("buy_purpose", buy_purpose)
                        .params("pay_type", pay_type)
                        .params("intent", intent3)
                        .params("urgency", urgency)
                        .params("need_tags", need_tags)
                        .params("comment", comment)
                        .execute(new MyStringCallBack() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                super.onSuccess(s, call, response);
                                StringModel model = JsonUtil.jsonToEntity(s, StringModel.class);
                                if (model.getCode() == 200) {
                                }
                                Toast.makeText(AddCustomers2Activity.this, model.getMsg(), Toast.LENGTH_SHORT).show();

                            }
                        });

                EventBus.getDefault().post(new MessageEvent("finish"));
                Intent intent = new Intent(AddCustomers2Activity.this, HomeActivity.class);
                intent.putExtra("fid",2);
                startActivity(intent);
//                CustomersFragment.start(getBaseContext());

                break;
        }
    }


    /**
     * 获取置业顾问
     */
    private void getHouseTypeDatil(int project_id){
        OkHttpUtils.get(AppConstants.URL+"user/project/advicer")
                .tag(this)
                .params("project_id",project_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        bean = JsonUtil.jsonToEntity(s,GetHouseTypeDetailBean.class);
                        if (bean.getCode() == 200){
                            if(bean.getData().getTotal().equals("0")){
                                getRecommend(project_id);
                            }else {
                                showPopupwindow(project_id);
                            }
                        }
                    }
                });
    }

    /**
     * 选择置业顾问
     * @param project_id
     */
    private void showPopupwindow(int project_id){
        Bundle bundle = new Bundle();
        bundle.putSerializable("list", (Serializable) bean.getData().getRows());
        Intent intent = new Intent(AddCustomers2Activity
                .this, AdvicerChooseActivity.class);
        intent.putExtra("project_id",project_id);

        intent.putExtra("name",name);
        intent.putExtra("sex",sex);
        intent.putExtra("tel",tel);
        intent.putExtra("barthday",birth);
        intent.putExtra("card_type",card_type);
        intent.putExtra("card_id",card_id);
        intent.putExtra("address",address);
        intent.putExtra("property_type",property_type);
        intent.putExtra("price",price);
        intent.putExtra("area",area);
        intent.putExtra("house_type",house_type);
        intent.putExtra("floor_min",floor_min);
        intent.putExtra("floor_max",floor_max);
        intent.putExtra("decorate",decorate);
        intent.putExtra("buy_purpose",buy_purpose);
        intent.putExtra("pay_type",pay_type);
        intent.putExtra("intent",intent3);
        intent.putExtra("urgency",urgency);
        intent.putExtra("need_tags",need_tags);
        intent.putExtra("comment",comment);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    /**
     * 推荐
     * @param project_id
     */
    private void getRecommend(int project_id ){
        OkHttpUtils.post(HttpAdress.addAndRecommend)
                .tag(this)
                .params("project_id",project_id)
                .params("name", name)
                .params("sex", sex)
                .params("tel", tel)
                .params("birth", birth)
                .params("card_type",card_type)
                .params("card_id", card_id)
                .params("address", address)
                .params("property_type", property_type)
                .params("total_price", price)
                .params("area", area)
                .params("house_type", house_type)
                .params("floor_min", floor_min)
                .params("floor_max", floor_max)
                .params("decorate", decorate)
                .params("buy_purpose", buy_purpose)
                .params("pay_type", pay_type)
                .params("intent", intent3)
                .params("urgency", urgency)
                .params("need_tags", need_tags)
                .params("comment", comment)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        ResultData resultData = JsonUtil.jsonToEntity(s, ResultData.class);
                        if (resultData.code == 200) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(AddCustomers2Activity.this);
                            builder.setTitle("推荐成功");
                            builder.setMessage(resultData.msg);
                            builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();


                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(AddCustomers2Activity.this);
                            builder.setTitle("推荐失败");
                            builder.setMessage(resultData.msg);
                            builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }

                    }
                });
    }

    public static void start(Context context) {

        Intent intent = new Intent(context, AddCustomers2Activity.class);
        context.startActivity(intent);
    }

    /**
     * 获取开放城市数据
     */
    private void initData() {
        XutilsHttp.getInstance().gethesder(AppConstants.URL + "/user/project/openCity", null, new XutilsHttp.XCallBack() {
            @Override
            public void onResponse(String result) {
                Gson gson = new Gson();
                openCityData = gson.fromJson(result, OpenCityData.class);
                mDataBeans = openCityData.getData();

            }

            @Override
            public void error(String message) {
                Log.i("msg=========", openCityData.getMsg());
            }
        });
    }

    /**
     *  区域选择器
     */
    private void setCityPickerview(){
        String fileName = "region.json";
        String foodJson = LocalJsonResolutionUtils.getJson(this, fileName);
        province = LocalJsonResolutionUtils.JsonToObject(foodJson, Province.class);

        mPicker = new OptionPicker.Builder(this, 2, this)
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
        List<Province.DynamicBean.CityBean> data1 = new ArrayList<>() ;
        Province.DynamicBean s;
        for (Province.DynamicBean dynamicBean : province.getDynamic()) {
            if(dynamicBean.getName().equals("四川省")){
                 s = dynamicBean;
                for (Province.DynamicBean.CityBean cityBean : s.getCity()) {
                    for (OpenCityData.DataBean mDataBean : mDataBeans) {
                        if(cityBean.getCode().equals(mDataBean.getCity_code())){
                            data1.add(cityBean);
                        }
                    }
                }
            }
        }

        mPicker.setDataWithValues(data1);
        mPicker.setSelectedWithValues( provinceId1, cityId1, countyId1);
        mPicker.show();

    }
    @Override
    public void onOptionSelect(OptionPicker picker, int[] selectedPosition, OptionDataSet[] selectedOptions) {
        String text = "";
//        Province.DynamicBean province = (Province.DynamicBean) selectedOptions[0];
//        provinceId = province.getCode();
        Province.DynamicBean.CityBean city = (Province.DynamicBean.CityBean) selectedOptions[0];
        Province.DynamicBean.CityBean.DistrictBean county = (Province.DynamicBean.CityBean.DistrictBean) selectedOptions[1];
        if (city == null) {
            cityId1 = "";
            countyId1 = "";
//            text = province.getName();
        } else {
            cityId1 = city.getCode();
            if (county == null) {
                countyId1 = "";
                text = city.getName();
            } else {
                cityId1 = city.getCode();
                countyId1 = county.getCode();
                text = "四川省"+"/"+city.getName()+"/"+county.getName();
            }
        }
        region = 510000+"-"+cityId1+"-"+countyId1;
        mNeed_text_address.setText(text);

    }

    /**
     * 滑动中
     *
     * @param seekBar
     * @param progress
     * @param fromUser
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        switch (seekBar.getId()) {

            case R.id.customers_seekbar1:

                mCustomers_text_seekbar1.setText(String.valueOf(seekBar.getProgress()));
                LogUtil.i(String.valueOf(seekBar.getProgress()));
                break;

            case R.id.customers_seekbar2:

                mCustomers_text_seekbar2.setText(String.valueOf(seekBar.getProgress()));
                LogUtil.i(String.valueOf(seekBar.getProgress()));
                break;
        }
    }

    /**
     * 开始滑动
     *
     * @param seekBar
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    /**
     * 停止滑动
     *
     * @param seekBar
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    private void Submit() {
        name = getIntent().getStringExtra("name");
        sex = getIntent().getStringExtra("sex");
        if (sex == null) {
            sex = "";
        } else if (sex.equals(2)) {
            sex = "女";
        } else if (sex.equals(1)) {
            sex = "男";
        }
        tel = getIntent().getStringExtra("tel");

        birth = getIntent().getStringExtra("birth");
        card_id = getIntent().getStringExtra("card_id");
        address = getIntent().getStringExtra("address");
        provinceId = getIntent().getStringExtra("province");
        cityId = getIntent().getStringExtra("city");
        countyId = getIntent().getStringExtra("district");
    }

    /**
     * 设置spinner适配器监听
     */
    private void setSpinnerAdapter() {


        mSpinner_property_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] data = getResources().getStringArray(R.array.物业类型);
                mString2 = data[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mSpinner_total_price.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] data = getResources().getStringArray(R.array.总价);
                mString3 = data[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mSpinner_area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] data = getResources().getStringArray(R.array.面积);
                mString4 = data[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mSpinner_house_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] data = getResources().getStringArray(R.array.户型);
                mString5 = data[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mSpinner_decorated.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] data = getResources().getStringArray(R.array.装修类型);
                mString6 = data[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mSpinner_buy_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] data = getResources().getStringArray(R.array.置业目的);
                mString7 = data[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mSpinner_pay_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] data = getResources().getStringArray(R.array.付款方式);
                mString8 = data[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }







    class textChange implements TextWatcher {

        private EditText text;
        public textChange(EditText editText){
            this.text = editText;
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {


            if(!mCustomers_text_seekbar1.getText().toString().equals("")) {
                mCustomers_seekbar1.setProgress(Integer.parseInt(text.getText().toString()));
            }

        }
    }

    class textChange1 implements TextWatcher {

        private EditText text;
        public textChange1(EditText editText){
            this.text = editText;
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {


            if(!mCustomers_text_seekbar2.getText().toString().equals("")) {
                mCustomers_seekbar2.setProgress(Integer.parseInt(text.getText().toString()));
            }
        }
    }
}
