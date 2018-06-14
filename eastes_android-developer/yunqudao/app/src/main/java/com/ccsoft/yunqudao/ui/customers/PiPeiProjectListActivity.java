package com.ccsoft.yunqudao.ui.customers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class PiPeiProjectListActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton  mCstomers_button_back;
    private RecyclerView mCustomers_viewpager_match_list;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_xiangqing_pipeilist);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, PiPeiProjectListActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化
     */
    private void initView() {

        mCstomers_button_back = findViewById(R.id.customers_button_back);
        mCustomers_viewpager_match_list = findViewById(R.id.customers_viewpager_match_list);
    }

    /**
     * 初始化
     */
    private void initListener() {

        mCstomers_button_back.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customers_button_back:
                finish();
                break;
        }
    }
}
