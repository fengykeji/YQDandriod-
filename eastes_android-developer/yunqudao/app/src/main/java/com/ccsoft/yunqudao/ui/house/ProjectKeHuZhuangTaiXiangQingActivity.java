package com.ccsoft.yunqudao.ui.house;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class ProjectKeHuZhuangTaiXiangQingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mHouse_button_返回;
    private TextView    mHouse_text_客户联系电话;
    private Button      mHouse_button_忽略;
    private Button      mHouse_button_联系客户;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_house_kehuxiangqing);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ProjectKeHuZhuangTaiXiangQingActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化
     */
    private void initView() {

        mHouse_button_返回 = findViewById(R.id.house_button_返回);
        mHouse_text_客户联系电话 = findViewById(R.id.house_text_客户联系电话);
        mHouse_button_忽略 = findViewById(R.id.house_button_忽略);
        mHouse_button_联系客户 = findViewById(R.id.house_button_联系客户);
    }

    /**
     * 初始化
     */
    private void initListener() {

        mHouse_button_返回.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.me_button_返回:
                finish();
                break;
            case R.id.house_button_忽略:
                finish();
                break;
            case R.id.house_button_联系客户:
                String number = mHouse_text_客户联系电话.getText().toString();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+number));
                startActivity(intent);
                break;
        }
    }
}
