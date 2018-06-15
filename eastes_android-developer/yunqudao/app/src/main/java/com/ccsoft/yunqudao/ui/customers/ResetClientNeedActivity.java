package com.ccsoft.yunqudao.ui.customers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.LogUtil;

/**
 * @author: Pein
 * @data: 2018/5/28 0028
 */

public class ResetClientNeedActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener,AdapterView.OnItemSelectedListener {

    private TextView    mCustomers_text_seekbar1;
    private TextView    mCustomers_text_seekbar2;
    private SeekBar     mCustomers_seekbar1;
    private SeekBar     mCustomers_seekbar2;
    private ImageButton mCustomers_button_back;
    private Button      mCustomers_button_commit;
    private ImageButton mCustomers_button_add;
    private Spinner     mSpinner_address, mSpinner_property_type, mSpinner_total_price, mSpinner_area, mSpinner_house_type, mSpinner_decorated, mSpinner_buy_type, mSpinner_pay_type;
    private TextView mNeed_text_address, mNeed_text_property_type, mNeed_text_total_price, mNeed_text_area, mNeed_text_house_type, mNeed_text_decorated, mNeed_text_buy_type, mNeed_text_pay_type;
    private String mString1;
    private String mString2;
    private String mString3;
    private String mString4;
    private String mString5;
    private String mString6;
    private String mString7;
    private String mString8;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_add_customers2);
        initView();
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
        mSpinner_address = findViewById(R.id.spinner_address);
        mSpinner_property_type = findViewById(R.id.spinner_property_type);
        mSpinner_total_price = findViewById(R.id.spinner_total_price);
        mSpinner_area = findViewById(R.id.spinner_area);
        mSpinner_house_type = findViewById(R.id.spinner_house_type);
        mSpinner_decorated = findViewById(R.id.spinner_decorated);
        mSpinner_buy_type = findViewById(R.id.spinner_buy_type);
        mSpinner_pay_type = findViewById(R.id.spinner_pay_type);
        mNeed_text_address = findViewById(R.id.need_text_address);
//        mNeed_text_property_type = findViewById(R.id.need_text_property_type);
//        mNeed_text_total_price = findViewById(R.id.need_text_total_price);
//        mNeed_text_area = findViewById(R.id.need_text_area);
//        mNeed_text_house_type = findViewById(R.id.need_text_house_type);
//        mNeed_text_decorated = findViewById(R.id.need_text_decorated);
//        mNeed_text_buy_type = findViewById(R.id.need_text_buy_type);
//        mNeed_text_pay_type = findViewById(R.id.need_text_pay_type);
        mString1 = (String) mSpinner_address.getSelectedItem();
        mString2 = (String) mSpinner_property_type.getSelectedItem();
        mString3 = (String) mSpinner_total_price.getSelectedItem();
        mString4 = (String) mSpinner_area.getSelectedItem();
        mString5 = (String) mSpinner_house_type.getSelectedItem();
        mString6 = (String) mSpinner_decorated.getSelectedItem();
        mString7 = (String) mSpinner_buy_type.getSelectedItem();
        mString8 = (String) mSpinner_pay_type.getSelectedItem();
    }

    private void initListener() {
        mCustomers_button_back.setOnClickListener(this);
        mCustomers_button_add.setOnClickListener(this);
        mCustomers_button_commit.setOnClickListener(this);
        mCustomers_text_seekbar1.setOnClickListener(this);
        mCustomers_text_seekbar2.setOnClickListener(this);
        mCustomers_seekbar1.setOnSeekBarChangeListener(this);
        mCustomers_seekbar2.setOnSeekBarChangeListener(this);
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
                finish();
                break;
        }
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

        mString1 = (String) mSpinner_address.getSelectedItem();
        mNeed_text_address.setText(mString1);

        mString2 = (String) mSpinner_property_type.getSelectedItem();
        mNeed_text_property_type.setText(mString2);

        mString3 = (String) mSpinner_total_price.getSelectedItem();

        mNeed_text_total_price.setText(mString3);
        mString4 = (String) mSpinner_area.getSelectedItem();
        mNeed_text_area.setText(mString4);

        mString5 = (String) mSpinner_decorated.getSelectedItem();
        mNeed_text_house_type.setText(mString5);

        mString6 = (String) mSpinner_buy_type.getSelectedItem();
        mNeed_text_decorated.setText(mString6);

        mString7 = (String) mSpinner_pay_type.getSelectedItem();
        mNeed_text_buy_type.setText(mString7);

        mString8 = (String) mSpinner_pay_type.getSelectedItem();
        mNeed_text_pay_type.setText(mString8);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}