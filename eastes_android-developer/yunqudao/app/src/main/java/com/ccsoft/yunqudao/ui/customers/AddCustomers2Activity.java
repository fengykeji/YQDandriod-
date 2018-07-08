package com.ccsoft.yunqudao.ui.customers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
import com.ccsoft.yunqudao.bean.MessageEvent;

import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.MyStringCallBack;
import com.ccsoft.yunqudao.model.StringModel;


import com.ccsoft.yunqudao.ui.home.HomeActivity;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LogUtil;

import com.lljjcoder.citypickerview.widget.CityPicker;
import com.lzy.okhttputils.OkHttpUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/4 0004
 */

public class AddCustomers2Activity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    /**
     * 添加客户2 id
     *
     * @param savedInstanceState
     */
    private ImageButton mCustomers_button_back;
    private Button mCustomers_button_commit;
    private ImageButton mCustomers_button_add;
    private TextView mCustomers_text_seekbar1;
    private TextView mCustomers_text_seekbar2;
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
    private String intent;
    private String urgency;
    private String comment;
    private List<String> list = new ArrayList<>();
    private Date date;
    private int property_type;
    private int card_type = 17;
    private ArrayList<Integer> Idlist = new ArrayList<>();
    private String need_tags = "";
//    private OptionsPickerView pvOptions ;
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();


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
                textView.setTextSize(19);
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
        EventBus.getDefault().register(this);
        initView();
        initListener();
        initData();
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

        Submit();

//        Idlist = getIntent().getIntegerArrayListExtra("list");





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

    private void initData() {

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

                selectAddress();
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

                if (et_comment.getText() == null) {
                    comment = "";
                } else {
                    comment = et_comment.getText().toString();
                }

                Log.e("cccccw",name+"name "+sex+"sex  "+tel+"tel  "+birth+"bir  "+
                card_id+"card  "+address+"address  "+property_type+"pro  "+price+"m3  "+
                area+"m4  "+house_type+" house "+floor_min+"min  "+floor_max+"max  "+
                decorate+"dec  "+buy_purpose+"buy  "+pay_type+"pay  "+intent+"int  "+
                urgency+"urg  "+need_tags+"need "+comment+"comment ");


                OkHttpUtils.post(HttpAdress.addClientAndNeed)
                        .tag(this)
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
                        .params("intent", intent)
                        .params("urgency", urgency)
                        .params("need_tags", need_tags)
                        .params("comment", comment)
                        .execute(new MyStringCallBack() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                super.onSuccess(s, call, response);
                                StringModel model = JsonUtil.jsonToEntity(s, StringModel.class);
                                if (model.getCode() == 200) {
                                    Toast.makeText(AddCustomers2Activity.this, ":添加客户基本信息成功", Toast.LENGTH_SHORT).show();

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

    public static void start(Context context) {

        Intent intent = new Intent(context, AddCustomers2Activity.class);
        context.startActivity(intent);
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
                mNeed_text_address.setText(province.trim()+ city.trim()+ district.trim());
            }
        });
    }
}
