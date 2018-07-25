package com.ccsoft.yunqudao.ui.customers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.bean.Province;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.model.response.OpenCityData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.MyStringCallBack;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LocalJsonResolutionUtils;
import com.ccsoft.yunqudao.utils.LogUtil;
import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jaaksi.pickerview.dataset.OptionDataSet;
import org.jaaksi.pickerview.picker.OptionPicker;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

import static com.ccsoft.yunqudao.ui.mian.MainActivity.savePeizhi;

/**
 * @author: Pein
 * @data: 2018/5/28 0028
 */

public class ResetClientNeedActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener ,OptionPicker.OnOptionSelectListener{

    private TextView    mCustomers_text_seekbar1;
    private TextView    mCustomers_text_seekbar2;
    private SeekBar     mCustomers_seekbar1;
    private SeekBar     mCustomers_seekbar2;
    private ImageButton mCustomers_button_back;
    private Button      mCustomers_button_commit;
    private ImageButton mCustomers_button_add;
    private Spinner     mSpinner_address, mSpinner_property_type, mSpinner_total_price, mSpinner_area, mSpinner_house_type, mSpinner_decorated, mSpinner_buy_type, mSpinner_pay_type;
    private TextView mNeed_text_address, tv_showlabel,mNeed_text_property_type, mNeed_text_total_price, mNeed_text_area, mNeed_text_house_type, mNeed_text_decorated, mNeed_text_buy_type, mNeed_text_pay_type;
    private EditText et_floor_min,et_floor_max,et_comment;
    private String mString1;
    private String mString2;
    private String mString3;
    private String mString4;
    private String mString5;
    private String mString6;
    private String mString7;
    private String mString8;
    private int house_type;
    private String floor_min;
    private String floor_max;
    private int decorate;
    private int buy_purpose;
    private int pay_type;
    private int price;
    private int area;
    private String intent;
    private String urgency;
    private String comment;
    private ArrayAdapter adapter1,adapter2,adapter3,adapter4,adapter5,adapter6,adapter7,adapter8 ;
    private String need_id;
    private int property_type;
    private ArrayList<Integer> Idlist = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    private String need_tags = "";
    private LinearLayout ll_showlabel;
    private int propertyType = 0;//住宅类型
    private int totalPrice   = 0;//总价类型
    private int foor_min = 0;
    private int foor_max = 0;
    private int intents = 0;
    private String provinceId ="", cityId =""/*= "230"*/, countyId=""/* = "234"*/,region = "";
    private OptionPicker mPicker;
    private Province province;
    private OpenCityData         openCityData;
    private List<OpenCityData.DataBean> mDataBeans = new ArrayList<>();
    private String textregion = "";




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
        layoutParams.leftMargin = 6;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                TextView textView = new TextView(ResetClientNeedActivity.this);
                textView.setText(list.get(i));
                textView.setBackgroundResource(R.drawable.shape_addlabel);
                textView.setPadding(14, 14, 14, 14);
                textView.setTextSize(14);
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
        mCustomers_text_seekbar1 = findViewById(R.id.customers_text_seekbar1);
        mCustomers_text_seekbar2 = findViewById(R.id.customers_text_seekbar2);
        mCustomers_seekbar1 = findViewById(R.id.customers_seekbar1);
        mCustomers_seekbar2 = findViewById(R.id.customers_seekbar2);
        mCustomers_button_commit = findViewById(R.id.customers_button_commit);
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
//        mNeed_text_property_type = findViewById(R.id.need_text_property_type);
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

        need_id = getIntent().getStringExtra("need_id");
        textregion = getIntent().getStringExtra("textregion");
        property_type = getIntent().getIntExtra("propertyType",0);
        totalPrice = getIntent().getIntExtra("totalPrice",0);
        area = getIntent().getIntExtra("area",0);
        decorate = getIntent().getIntExtra("decorate",0);
        buy_purpose = getIntent().getIntExtra("buy_purpose",0);
        pay_type = getIntent().getIntExtra("pay_type",0);
        house_type = getIntent().getIntExtra("houseType",0);
        need_tags = getIntent().getStringExtra("need_tags");
        foor_min = getIntent().getIntExtra("foor_min",0);
        foor_max = getIntent().getIntExtra("foor_max",0);
        intents = getIntent().getIntExtra("intents",0);
        urgency = String.valueOf(getIntent().getIntExtra("urgency",0));
        comment = getIntent().getStringExtra("comment");


        et_floor_min.setText(foor_min+"");
        et_floor_max.setText(foor_max+"");
        if(comment==null){
            et_comment.setText("");
        }else {
            et_comment.setText(comment + "");
        }
        mCustomers_text_seekbar1.setText(intents+"");
        mCustomers_text_seekbar2.setText(urgency+"");
        mNeed_text_address.setText(textregion);



        if(need_tags!=null){
            String[] b = need_tags.split(",");
            PeizhiBean peizhiBean = savePeizhi();
            for (PeizhiBean.DataBean._$15Bean.ParamBeanXXXXXXXXXXXXXX bean : peizhiBean.getData().get_$15().getParam()) {
                for (String s : b) {
                    if(!s.equals("")) {
                        if (bean.getId() == Integer.parseInt(s)) {
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            layoutParams.leftMargin = 6;
                            TextView textView = new TextView(ResetClientNeedActivity.this);
                            textView.setText(bean.getParam());
                            textView.setBackgroundResource(R.drawable.shape_addlabel);
                            textView.setPadding(14, 14, 14, 14);
                            textView.setTextSize(16);
                            textView.setTextColor(0x7f06004c);
                            textView.setSingleLine();
                            textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                            textView.setMaxEms(4);
                            ll_showlabel.addView(textView, layoutParams);
                            tv_showlabel.setVisibility(View.GONE);

                        }
                    }
                }
            }
        }

        setSpinnerData();
        setSpinnerAdapter();
    }

    private void initListener() {
        mCustomers_button_back.setOnClickListener(this);
        mCustomers_button_add.setOnClickListener(this);
        mCustomers_button_commit.setOnClickListener(this);
        mCustomers_text_seekbar1.setOnClickListener(this);
        mCustomers_text_seekbar2.setOnClickListener(this);
        mCustomers_seekbar1.setOnSeekBarChangeListener(this);
        mCustomers_seekbar2.setOnSeekBarChangeListener(this);
        mNeed_text_address.setOnClickListener(this);
    }

    public static void start(Context context) {

        Intent intent = new Intent(context, ResetClientNeedActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customers_button_back:
                finish();
                break;
            case R.id.customers_button_add:
                AddLabelActivity.start(this);
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
                    intent = "";
                } else {
                    intent = mCustomers_text_seekbar1.getText().toString();
                }
                if (mCustomers_text_seekbar2.getText()==null) {
                    urgency = "";
                } else {
                    urgency = mCustomers_text_seekbar2.getText().toString();
                }

                if (et_comment.getText() .toString()==null) {
                    comment = "";
                } else {
                    comment = et_comment.getText().toString();
                }

                OkHttpUtils.post(HttpAdress.UPDATANEED)
                        .tag(this)
                        .params("need_id",need_id)
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
                        .params("intent", intent)
                        .params("urgency", urgency)
                        .params("need_tags", need_tags)
                        .params("comment", comment)
                        .execute(new MyStringCallBack() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                super.onSuccess(s, call, response);
                                StringModel model = JsonUtil.jsonToEntity(s,StringModel.class);
                                if(model.getCode()==200){
                                    sendBroadcast(new Intent(AppConstants.REFRESH_CUSTOM_LIST));
//                                    Intent intent = new Intent(ResetClientNeedActivity.this,CustomersXiangQingActivity.class);
//                                    intent.putExtra("fid",0);
//                                    startActivity(intent);
                                    finish();
                                }
                                Toast.makeText(ResetClientNeedActivity.this,model.getMsg(),Toast.LENGTH_LONG).show();

                            }
                        });
                break;
            case R.id.need_text_address:
                setCityPickerview();
                break;
        }
    }

    /**
     * 条件选择器
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

        mPicker = new OptionPicker.Builder(this, 2, this).create();
        mPicker.getTopBar().getTitleView().setText("请选择城市");
        int color = getResources().getColor(R.color.gray);
        int color1 = getResources().getColor(R.color.liji_material_blue_500);
        mPicker.getTopBar().getTopBarView().setBackgroundColor(color);

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
        mPicker.setSelectedWithValues( provinceId, cityId, countyId);
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
            cityId = "";
            countyId = "";
//            text = province.getName();
        } else {
            cityId = city.getCode();
            if (county == null) {
                countyId = "";
                text = city.getName();
            } else {
                cityId = city.getCode();
                countyId = county.getCode();
                text = "四川省"+"/"+city.getName()+"/"+county.getName();
            }
        }
        region = 510000+"-"+cityId+"-"+countyId;
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



    /**
     * 设置spinner适配器监听
     */
    private void setSpinnerAdapter(){
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

    private void setSpinnerData(){
        PeizhiBean peizhiBean = savePeizhi();
        for (PeizhiBean.DataBean._$16Bean.ParamBeanXXXXXXXXXXXXXXX bean1 : peizhiBean.getData().get_$16().getParam()) {
            if (bean1.getId() == property_type) {
                setSpinnerItemSelectedByValue(mSpinner_property_type,bean1.getParam());
            }
        }

        for (PeizhiBean.DataBean._$25Bean.ParamBeanXXXXXXXXXXXXXXXXXXXXXXX bean1 : peizhiBean.getData().get_$25().getParam()) {
            if (bean1.getId() == totalPrice) {
                setSpinnerItemSelectedByValue(mSpinner_total_price,bean1.getParam());
            }
        }

        for (PeizhiBean.DataBean._$26Bean.ParamBeanXXXXXXXXXXXXXXXXXXXXXXXXX bean1 : peizhiBean.getData().get_$26().getParam()) {
            if (bean1.getId() == area) {
                setSpinnerItemSelectedByValue(mSpinner_area,bean1.getParam());
            }
        }

        for (PeizhiBean.DataBean._$21Bean.ParamBeanXXXXXXXXXXXXXXXXXXXX bean1 : peizhiBean.getData().get_$21().getParam()) {
            if (bean1.getId() == decorate) {
                setSpinnerItemSelectedByValue(mSpinner_decorated,bean1.getParam());
            }
        }

        for (PeizhiBean.DataBean._$9Bean.ParamBeanXXXXXXXX bean1 : peizhiBean.getData().get_$9().getParam()) {
            if (bean1.getId() == house_type) {
                setSpinnerItemSelectedByValue( mSpinner_house_type,bean1.getParam());
            }
        }

        for (PeizhiBean.DataBean._$12Bean.ParamBeanXXXXXXXXXXX bean1 : peizhiBean.getData().get_$12().getParam()) {
            if (bean1.getId() == buy_purpose) {
                setSpinnerItemSelectedByValue( mSpinner_buy_type,bean1.getParam());
            }
        }

        for (PeizhiBean.DataBean._$13Bean.ParamBeanXXXXXXXXXXXX bean1 : peizhiBean.getData().get_$13().getParam()) {
            if (bean1.getId() == pay_type) {
                setSpinnerItemSelectedByValue( mSpinner_pay_type,bean1.getParam());
            }
        }
    }


}