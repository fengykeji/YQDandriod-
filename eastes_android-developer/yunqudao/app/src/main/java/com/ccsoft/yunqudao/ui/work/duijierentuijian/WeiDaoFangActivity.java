package com.ccsoft.yunqudao.ui.work.duijierentuijian;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.bean.StringBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.ui.message.WorkMessageActivity;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.DateUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.wheelview.TimePickerView;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.Calendar;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Response;

public class WeiDaoFangActivity extends Activity {

    private TextView customers_edittext_zhiye;
    private ImageView im_back;
    private int client_id,disabled_state = 0;
    private String disabled;
    private Spinner customers_spinner_card_type;
    private EditText et_comment;
    private Button button_next;
    private int daofangid;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay();//为获取屏幕宽、高
        WindowManager.LayoutParams p = getWindow().getAttributes();//获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 0.7);//高度设置为屏幕的1.0
        p.width = (int) (d.getWidth() * 0.7); //宽度设置为屏幕的1.0
//        p.alpha = 1.0f;//设置本身透明度
        p.dimAmount = 0.8f; //设置黑暗度
        getWindow().setAttributes(p);//设置生效
        setContentView(R.layout.activity_weidaofang);
        initView();
        initData();

    }

    private void initView(){
        daofangid = getIntent().getIntExtra("daofangid",0);
        client_id = getIntent().getIntExtra("client_id",0);
        customers_edittext_zhiye = findViewById(R.id.customers_edittext_zhiye);
        im_back = findViewById(R.id.im_back);
        customers_spinner_card_type = findViewById(R.id.customers_spinner_card_type);
        et_comment = findViewById(R.id.et_comment);
        button_next = findViewById(R.id.button_next);



        customers_edittext_zhiye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBirthdayPicker(customers_edittext_zhiye.getText().toString());
            }
        });

        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        customers_spinner_card_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] data = getResources().getStringArray(R.array.用户失效类型);
                disabled = data[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });
    }


    private void initData(){

        PeizhiBean peizhiBean = MainActivity.savePeizhi();
        if(peizhiBean.getData()!=null){
            for (PeizhiBean.DataBean._$18Bean.ParamBeanXXXXXXXXXXXXXXXXX data : peizhiBean.getData().get_$18().getParam()) {
                if(data.getParam().equals(disabled)){
                    disabled_state = data.getId();
                    OkHttpUtils.post(AppConstants.URL+"agent/client/confirmDisabled")
                            .params("client_id",client_id)
                            .params("visit_time",customers_edittext_zhiye.getText().toString())
                            .params("disabled_state",disabled_state)
                            .params("comment",et_comment.getText().toString())
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    StringBean bean = JsonUtil.jsonToEntity(s,StringBean.class);
                                    if(bean.getCode() == 200){
                                        if(daofangid == 2){
                                            Intent intent = new Intent(WeiDaoFangActivity.this, WorkMessageActivity.class);
                                            startActivity(intent);
                                        }else if(daofangid ==4){
                                            Intent intent = new Intent(WeiDaoFangActivity.this,WorkDuiJieRecommendActivity.class);
                                            startActivity(intent);
                                        }
                                        finish();
                                    }
                                    Toast.makeText(WeiDaoFangActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
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
        endDate.set(2050,12,31);

        TimePickerView.Builder builder = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {   // 选中事件回调
                customers_edittext_zhiye.setText(DateUtil.dateToString(date));
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
