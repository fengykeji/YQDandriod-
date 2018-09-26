package com.ccsoft.yunqudao.ui.me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.Province;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LocalJsonResolutionUtils;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.jaaksi.pickerview.dataset.OptionDataSet;
import org.jaaksi.pickerview.picker.BasePicker;
import org.jaaksi.pickerview.picker.OptionPicker;
import org.jaaksi.pickerview.widget.PickerView;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/8 0008
 */

public class ResetDiZhiActivity extends AppCompatActivity implements View.OnClickListener,OptionPicker.OnOptionSelectListener {

    private ImageButton mMe_button_返回;
    private Button      mMe_button_保存;
    private TextView    mMe_text_地区;
    private ImageButton mMe_button_地区选择器;
    private EditText    mMe_edittext_详细地址;
    private String provinceId ="", cityId =""/*= "230"*/, countyId=""/* = "234"*/,
            provincename = "",cityname = "",countyname = "";
    private OptionPicker mPicker;
    private Province province;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_reset_dizhi);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ResetDiZhiActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         * 初始化id
         */
        mMe_button_返回 = findViewById(R.id.me_button_返回);
        mMe_button_保存 = findViewById(R.id.me_button_保存);
        mMe_text_地区 = findViewById(R.id.me_text_地区);
        mMe_button_地区选择器 = findViewById(R.id.me_button_地区选择器);
        mMe_edittext_详细地址 = findViewById(R.id.me_edittext_详细地址);
    }

    private void initListener() {
        /**
         *初始化监听器
         */
        mMe_button_返回.setOnClickListener(this);
        mMe_button_保存.setOnClickListener(this);
        mMe_button_地区选择器.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.me_button_返回:
                finish();
                break;
            case R.id.me_button_保存:
                updata(provincename,cityname,countyname,mMe_edittext_详细地址.getText().toString());
                break;
            case R.id.me_button_地区选择器:
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
                provincename = province.getName();
                cityname = city.getName();
                countyname = county.getName();
            }
        }
        mMe_text_地区.setText(text);

    }

    /**
     * 修改个人信息
     */
    public void updata(String province,String city, String district,String absolute_address){
        OkHttpUtils.post(HttpAdress.meupdate)
                .params("province",province)
                .params("city",city)
                .params("district",district)
                .params("absolute_address",absolute_address)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        StringModel model = JsonUtil.jsonToEntity(s,StringModel.class);
                        if(model.getCode() == 200){
                            finish();
                        }
                        Toast.makeText(ResetDiZhiActivity.this,model.getMsg(),Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
