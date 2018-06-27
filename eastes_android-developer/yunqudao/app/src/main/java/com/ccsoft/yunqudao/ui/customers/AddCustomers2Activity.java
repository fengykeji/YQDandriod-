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


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/4 0004
 */

public class AddCustomers2Activity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener {

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
    private int floor_min;
    private int floor_max;
    private int decorate;
    private int buy_purpose;
    private int pay_type;
    private int intent;
    private int urgency;
    private String comment;
    private List<String> list = new ArrayList<>();
    private Date date;
    private int property_type;
    private ArrayList<Integer> Idlist = new ArrayList<>();
    private String need_tags = "";
//    private OptionsPickerView pvOptions ;
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_add_customers2);
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

        Idlist = getIntent().getIntegerArrayListExtra("list");

        if (Idlist != null) {
            for (int i = 0; i < Idlist.size(); i++) {
                int id = Idlist.get(i);
                if (i == 0) {
                    need_tags = String.valueOf(Idlist.get(i));
                } else {
                    need_tags = need_tags.concat("," + String.valueOf(id));
                    Log.e("needsssss", need_tags);
                }
            }
        }



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


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.leftMargin = 6;
        if (getIntent().getParcelableArrayListExtra("lists") != null) {
            list = getIntent().getStringArrayListExtra("lists");
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

//
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
                    mString3 = "";
                }
                if (mString4 == null) {
                    mString4 = "";
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
                if (et_floor_min.getText().toString().equals("")) {
                    floor_min = 0;
                } else {
                    floor_min = Integer.parseInt(et_floor_min.getText().toString());
                }
                if (et_floor_max.getText().toString().equals("")) {
                    floor_max = 0;
                } else {
                    floor_max = Integer.parseInt(et_floor_max.getText().toString());
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
                } else {
                    MainActivity.savePeizhi().getData().get_$13().getParam();
                    for (int i = 0; i < MainActivity.savePeizhi().getData().get_$13().getParam().size(); i++) {
                        if (mString8.equals(MainActivity.savePeizhi().getData().get_$13().getParam().get(0))) {
                            pay_type = 46;
                        } else if (mString8.equals(MainActivity.savePeizhi().getData().get_$13().getParam().get(1))) {
                            pay_type = 47;
                        } else if (mString8.equals(MainActivity.savePeizhi().getData().get_$13().getParam().get(2))) {
                            pay_type = 48;
                        } else if (mString8.equals(MainActivity.savePeizhi().getData().get_$13().getParam().get(3))) {
                            pay_type = 49;
                        } else if (mString8.equals(MainActivity.savePeizhi().getData().get_$13().getParam().get(4))) {
                            pay_type = 50;
                        }
                    }
                }
                if (mCustomers_text_seekbar1.getText().toString().equals("")) {
                    intent = 0;
                } else {
                    intent = Integer.parseInt(mCustomers_text_seekbar1.getText().toString());
                }
                if (mCustomers_text_seekbar2.getText().toString().equals("")) {
                    urgency = 0;
                } else {
                    urgency = Integer.parseInt(mCustomers_text_seekbar2.getText().toString());
                }

                if (et_comment.getText().toString() == null) {
                    comment = "";
                } else {
                    comment = et_comment.getText().toString();
                }


                OkHttpUtils.post(HttpAdress.addClientAndNeed)
                        .tag(this)
                        .params("name", name)
                        .params("sex", sex)
                        .params("tel", tel)
                        .params("birth", birth)
                        .params("card_id", card_id)
                        .params("address", address)
                        .params("property_type", property_type)
                        .params("total_price", mString3)
                        .params("area", mString4)
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (view.getId()) {
//            case R.id.spinner_address:
//            mString1 = (String) mSpinner_address.getSelectedItem();
//            mNeed_text_address.setText(mString1);
//            break;
            case R.id.spinner_property_type:
                mString2 = (String) adapter2.getItem(position);
//        mNeed_text_property_type.setText(mString2);
                break;
            case R.id.spinner_total_price:
                mString3 = (String) adapter3.getItem(position);
//        mNeed_text_total_price.setText(mString3);
                break;
            case R.id.spinner_area:
                mString4 = (String) adapter4.getItem(position);
//        mNeed_text_area.setText(mString4);
                break;
            case R.id.spinner_house_type:
                mString5 = (String) adapter5.getItem(position);
//        mNeed_text_house_type.setText(mString5);
                break;
            case R.id.spinner_decorated:
                mString6 = (String) adapter6.getItem(position);
//        mNeed_text_decorated.setText(mString6);
                break;
            case R.id.spinner_buy_type:
                mString7 = (String) adapter7.getItem(position);
//        mNeed_text_buy_type.setText(mString7);
                break;
            case R.id.spinner_pay_type:
                mString8 = (String) adapter8.getItem(position);
                break;
        }
//        mNeed_text_pay_type.setText(mString8);


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
        adapter2 = ArrayAdapter.createFromResource(this, R.array.物业类型,
                android.R.layout.simple_spinner_item);
        mSpinner_property_type.setAdapter(adapter2);
        mSpinner_property_type.setOnItemSelectedListener(this);

        adapter3 = ArrayAdapter.createFromResource(this, R.array.总价,
                android.R.layout.simple_spinner_item);
        mSpinner_total_price.setAdapter(adapter3);
        mSpinner_total_price.setOnItemSelectedListener(this);

        adapter4 = ArrayAdapter.createFromResource(this, R.array.面积,
                android.R.layout.simple_spinner_item);
        mSpinner_area.setAdapter(adapter4);
        mSpinner_area.setOnItemSelectedListener(this);

        adapter5 = ArrayAdapter.createFromResource(this, R.array.户型,
                android.R.layout.simple_spinner_item);
        mSpinner_house_type.setAdapter(adapter5);
        mSpinner_house_type.setOnItemSelectedListener(this);

        adapter6 = ArrayAdapter.createFromResource(this, R.array.装修类型,
                android.R.layout.simple_spinner_item);
        mSpinner_decorated.setAdapter(adapter6);
        mSpinner_decorated.setOnItemSelectedListener(this);

        adapter7 = ArrayAdapter.createFromResource(this, R.array.置业目的,
                android.R.layout.simple_spinner_item);
        mSpinner_buy_type.setAdapter(adapter7);
        mSpinner_buy_type.setOnItemSelectedListener(this);

        adapter8 = ArrayAdapter.createFromResource(this, R.array.付款方式,
                android.R.layout.simple_spinner_item);
        mSpinner_pay_type.setAdapter(adapter8);
        mSpinner_pay_type.setOnItemSelectedListener(this);
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
