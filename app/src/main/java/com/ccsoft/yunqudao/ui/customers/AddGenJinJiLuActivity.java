package com.ccsoft.yunqudao.ui.customers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.MyStringCallBack;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.DateUtil;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LogUtil;
import com.ccsoft.yunqudao.utils.SpUtil;
import com.ccsoft.yunqudao.utils.wheelview.TimePickerView;
import com.lzy.okhttputils.OkHttpUtils;

import java.util.Calendar;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class AddGenJinJiLuActivity extends AppCompatActivity implements View.OnClickListener ,SeekBar.OnSeekBarChangeListener,AdapterView.OnItemSelectedListener{

    private ImageButton mCustomers_button_back;
    private Button  mCustomers_button_commit;
    private TextView mCustomers_text_barthday,customers_nextTime,tv_showseekbar1,tv_showseekbar2;
    private EditText et_comment;
    private ImageButton onfollow_time;
    private RelativeLayout im_customers_nextTime;
    private int                            mClienID;
    private RadioButton rb_tel,rb_qq,rb_miantan,rb_weixin,rb_qita,radioButton;
    private SeekBar sb_addGenJinLu1,sb_addGenJinLu2;
    private ArrayAdapter adapter ;
    private RadioGroup rg_follow_type;
    private String follow_type;
    private Date follow_time;
    private int intent;
    private int urgency;
    private int pay_way;
    private Spinner customers_spinner_付款方式;
    private String mString2;
    private String comment;
    private int follow_type1;
    private TextView tv_kehumingcheng,tv_genjingren;
    private String name;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_add_genjinjilu);
        HideIMEUtil.wrap(this);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, AddGenJinJiLuActivity.class);
        context.startActivity(intent);
    }



    /**
     * 初始化
     */
    private void initView() {

        mCustomers_button_back = findViewById(R.id.customers_button_back);
        mCustomers_button_commit = findViewById(R.id.customers_button_commit);
        mCustomers_text_barthday = findViewById(R.id.customers_text_birthday);
        onfollow_time = findViewById(R.id.customers_follw_time);
        im_customers_nextTime = findViewById(R.id.im_customers_nextTime);
        customers_nextTime = findViewById(R.id.customers_nextTime);
        rb_tel = findViewById(R.id.rb_tel);
        rb_qq = findViewById(R.id.rb_qq);
        rb_weixin = findViewById(R.id.rb_weixin);
        rb_miantan = findViewById(R.id.rb_miantan);
        rb_qita = findViewById(R.id.rb_qita);
        rg_follow_type = findViewById(R.id.rg_follow_type);
        sb_addGenJinLu1 = findViewById(R.id.sb_addGenJinLu1);
        sb_addGenJinLu2 = findViewById(R.id.sb_addGenJinLu2);
        tv_showseekbar1 = findViewById(R.id.tv_showseekbar1);
        tv_showseekbar2 = findViewById(R.id.tv_showseekbar2);
        customers_spinner_付款方式 = findViewById(R.id.customers_spinner_付款方式);
        et_comment = findViewById(R.id.et_comment);
        tv_kehumingcheng = findViewById(R.id.tv_kehumingcheng);
        tv_genjingren = findViewById(R.id.tv_genjingren);

        adapter = ArrayAdapter.createFromResource(this,R.array.付款方式,
                android.R.layout.simple_spinner_item);
        customers_spinner_付款方式.setAdapter(adapter);
        customers_spinner_付款方式.setOnItemSelectedListener(this );

        mClienID = getIntent().getIntExtra("client_id",0);
        name = getIntent().getStringExtra("name");

        tv_kehumingcheng.setText(name);
        getTime();
        tv_genjingren.setText(SpUtil.getString("name",""));

    }



    /**
     * 初始化
     */
    private void initListener() {

        mCustomers_button_back.setOnClickListener(this);
        mCustomers_button_commit.setOnClickListener(this);
        onfollow_time.setOnClickListener(this);
        im_customers_nextTime.setOnClickListener(this);
        sb_addGenJinLu1.setOnSeekBarChangeListener(this);
        sb_addGenJinLu2.setOnSeekBarChangeListener(this);
        rg_follow_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                radioButton = (RadioButton)findViewById(rg_follow_type.getCheckedRadioButtonId());
                follow_type = radioButton.getText().toString();
            }
        });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customers_button_back:
                Intent intent3 = new Intent(AddGenJinJiLuActivity.this,CustomersXiangQingActivity.class);
                intent3.putExtra("fid",1);
                intent3.putExtra("client_id",mClienID);
                startActivity(intent3);
                finish();
                break;
            case R.id.customers_button_commit:

                if(mCustomers_text_barthday.getText().toString().equals("")){
                    Toast.makeText(this,"请选择跟进时间",Toast.LENGTH_LONG).show();
                    return;
                }
                if(customers_nextTime.getText().toString().equals("")){
                    Toast.makeText(this,"请选择下次回访时间",Toast.LENGTH_LONG).show();
                    return;
                }

                if(follow_type==null){
                    Toast.makeText(this,"请选择跟进方式",Toast.LENGTH_LONG).show();
                    return;
                } else if(follow_type.equals("电话")){
                    follow_type1 = 86;
                }else if(follow_type.equals("QQ")){
                    follow_type1 = 87;
                }
                else if(follow_type.equals("微信")){
                    follow_type1 = 88;
                }
                else if(follow_type.equals("面谈")){
                    follow_type1 = 89;
                }
                else if(follow_type.equals("其他")){
                    follow_type1 = 90;
                }
    //                if(tv_showseekbar1.getText().toString().equals("")){
    //                    Toast.makeText(this,"请选择购房意向度",Toast.LENGTH_LONG).show();
    //                    return;
    //                }else {
    //
    //                }
                    intent = Integer.parseInt(tv_showseekbar1.getText().toString());
//                if(tv_showseekbar2.getText().toString().equals("")){
//                    Toast.makeText(this,"请选择购房紧迫度",Toast.LENGTH_LONG).show();
//                }else {
//
//                }
                    urgency = Integer.parseInt(tv_showseekbar2.getText().toString());

                if(mString2 .equals("")) {
                    Toast.makeText(this,"请选择付款方式",Toast.LENGTH_LONG).show();
                    return;
                }else {
                    MainActivity.savePeizhi().getData().get_$13().getParam();
                    for(int i=0;i<MainActivity.savePeizhi().getData().get_$13().getParam().size();i++){
                        if(mString2.equals(MainActivity.savePeizhi().getData().get_$13().getParam().get(0))){
                            pay_way = 46;
                        }else if(mString2.equals(MainActivity.savePeizhi().getData().get_$13().getParam().get(1))){
                            pay_way =47;
                        }
                        else if(mString2.equals(MainActivity.savePeizhi().getData().get_$13().getParam().get(2))){
                            pay_way = 48;
                        }else if(mString2.equals(MainActivity.savePeizhi().getData().get_$13().getParam().get(3))){
                            pay_way = 49;
                        }else if(mString2.equals(MainActivity.savePeizhi().getData().get_$13().getParam().get(4))){
                            pay_way = 50;
                        }
                    }
                }
                if(et_comment.getText().toString().equals("")){
                    Toast.makeText(this,"请输入跟进内容",Toast.LENGTH_LONG).show();
                    return;
                }else {
                    comment = et_comment.getText().toString();
                }



                OkHttpUtils.post(HttpAdress.ADDFOLLOW)
                        .tag(this)
                        .params("client_id",mClienID)
                        .params("follow_type",follow_type1)
                        .params("follow_time",mCustomers_text_barthday.getText().toString())
                        .params("intent",intent)
                        .params("urgency",urgency)
                        .params("pay_way",pay_way)
                        .params("next_follow_time",customers_nextTime.getText().toString())
                        .params("comment",comment)
                        .execute(new MyStringCallBack() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                super.onSuccess(s, call, response);
                                StringModel model = JsonUtil.jsonToEntity(s,StringModel.class);
                                if(model.getCode()==200){
                                    Toast.makeText(AddGenJinJiLuActivity.this,"提交了跟进记录",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(AddGenJinJiLuActivity.this,CustomersXiangQingActivity.class);
                                    intent.putExtra("fid",1);
                                    intent.putExtra("client_id",mClienID);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
                break;
            case R.id.customers_follw_time:

                break;
            case R.id.im_customers_nextTime:
                showBirthdayPickerNextTime(customers_nextTime.getText().toString());
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

        Calendar endDate = Calendar.getInstance();
        endDate.set(2050, 12, 30);

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

    private void showBirthdayPickerNextTime(String birthdayStr) {
        Calendar selectedDate = Calendar.getInstance();
        if (!TextUtils.isEmpty(birthdayStr) && !birthdayStr.equals("无")) {
            Date birthdayDate = DateUtil.stringToDate(birthdayStr);
            selectedDate.setTime(birthdayDate);
        }

        Calendar startDate = Calendar.getInstance();

        Calendar endDate = Calendar.getInstance();
        endDate.set(2050, 12, 30);

        TimePickerView.Builder builder = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {   // 选中事件回调
                customers_nextTime.setText(DateUtil.dateToString(date));
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
     * 获取系统当前时间
     */

    private void getTime(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        mCustomers_text_barthday.setText(year+"-"+month+"-"+day);

    }

    /**
     * seek bar获取值
     * @param seekBar
     * @param i
     * @param b
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()) {

            case R.id.sb_addGenJinLu1:

                tv_showseekbar1.setText(String.valueOf(seekBar.getProgress()));
                LogUtil.i(String.valueOf(seekBar.getProgress()));
                break;

            case R.id.sb_addGenJinLu2:

                tv_showseekbar2.setText(String.valueOf(seekBar.getProgress()));
                LogUtil.i(String.valueOf(seekBar.getProgress()));
                break;

        }


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    /**
     * spinner获取值
     * @param adapterView
     * @param view
     * @param i
     * @param l
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mString2 = (String) adapter.getItem(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
