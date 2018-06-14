package com.ccsoft.yunqudao.ui.customers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class AddLabelActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mCustomers_button_back;
    private Button      mCustomers_button_commit;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_add_label);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, AddLabelActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化id
     */
    private void initView() {

        mCustomers_button_back = findViewById(R.id.customers_button_back);
        mCustomers_button_commit = findViewById(R.id.customers_button_commit);
    }

    /**
     * 初始化监听器
     */
    private void initListener() {

        mCustomers_button_back.setOnClickListener(this);
        mCustomers_button_commit.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customers_button_back:
                finish();
                break;
            case R.id.customers_button_commit:
                finish();
                break;
        }
    }
}
