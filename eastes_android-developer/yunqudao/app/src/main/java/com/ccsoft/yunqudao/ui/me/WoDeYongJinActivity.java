package com.ccsoft.yunqudao.ui.me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;
import org.w3c.dom.Text;

/**
 * @author: Pein
 * @data: 2018/5/3 0003
 */

public class WoDeYongJinActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mMe_button_返回;
    private ImageButton mMe_button_身份证认证;
    private ImageButton mMe_button_银行卡;
    private TextView    mMe_text_累计佣金;
    private TextView    mMe_text_未结佣金条数;
    private TextView    mMe_text_未结佣金;
    private TextView    mMe_text_已结佣金条数;
    private TextView    mMe_text_已结佣金;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_wodeyongjin);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, WoDeYongJinActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         * 初始化id
         */
        mMe_button_返回 = findViewById(R.id.me_button_返回);
        mMe_button_身份证认证 = findViewById(R.id.me_button_身份证认证);
        mMe_button_银行卡 = findViewById(R.id.me_button_银行卡);
        mMe_text_累计佣金 = findViewById(R.id.me_text_累计佣金);
        mMe_text_未结佣金条数 = findViewById(R.id.me_text_未结佣金条数);
        mMe_text_未结佣金 = findViewById(R.id.me_text_未结佣金);
        mMe_text_已结佣金条数 = findViewById(R.id.me_text_已结佣金条数);
        mMe_text_已结佣金 = findViewById(R.id.me_text_已结佣金);
    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        mMe_button_返回.setOnClickListener(this);
        mMe_button_身份证认证.setOnClickListener(this);
        mMe_button_银行卡.setOnClickListener(this);
        mMe_text_未结佣金条数.setOnClickListener(this);
        mMe_text_已结佣金条数.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.me_button_返回:
                finish();
                break;
            case R.id.me_button_身份证认证:
                ShenFenZhengRenZhengActivity.start(this);
                break;
            case R.id.me_button_银行卡:
                YinHangKaActivity.start(this);
                break;
            case R.id.me_text_未结佣金条数:
                WeiJieListActivity.start(this);
                break;
            case R.id.me_text_已结佣金条数:
                YiJieListActivity.start(this);
                break;
        }
    }
}
