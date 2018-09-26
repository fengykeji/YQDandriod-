package com.ccsoft.yunqudao.ui.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/8 0008
 */

public class SystemMessageActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton  mMessage_button_返回;
    private RecyclerView mMessage_recyclerview_系统消息列表;
    private LinearLayout mMessage_item_linearlayout_审核通过;
    private LinearLayout mMessage_item_linearlayout_审核未通过;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_message_systemmessage);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, SystemMessageActivity.class);
        context.startActivity(intent);
    }

    private void initView() {

        /**
         * 初始化id
         */
        mMessage_button_返回 = findViewById(R.id.message_button_返回);
        mMessage_recyclerview_系统消息列表 = findViewById(R.id.message_recyclerview_系统消息列表);
        mMessage_item_linearlayout_审核通过 = findViewById(R.id.message_item_linearlayout_审核通过);
        mMessage_item_linearlayout_审核未通过 = findViewById(R.id.message_item_linearlayout_审核未通过);
    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        mMessage_button_返回.setOnClickListener(this);
        mMessage_item_linearlayout_审核通过.setOnClickListener(this);
        mMessage_item_linearlayout_审核未通过.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.message_button_返回:
                finish();
                break;
            case R.id.message_item_linearlayout_审核通过:
                ShenHeTongGuoActivity.start(this);
                break;
            case R.id.message_item_linearlayout_审核未通过:
                ShenHeWeiTongGuoActivity.start(this);
                break;
        }
    }
}
