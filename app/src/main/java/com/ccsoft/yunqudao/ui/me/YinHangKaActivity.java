package com.ccsoft.yunqudao.ui.me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;

/**
 * @author: Pein
 * @data: 2018/5/7 0007
 */

public class YinHangKaActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mMe_button_返回;
    private Button      mMe_button_解绑;
    private FrameLayout mMe_framelayout_银行图;
    private ImageView   mMe_icon_银行;
    private TextView    mMe_text_银行;
    private TextView    mMe_text_银行卡号;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_bankcard);
        HideIMEUtil.wrap(this);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, YinHangKaActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         * 初始化id
         */
        mMe_button_返回 = findViewById(R.id.me_button_返回);
        mMe_button_解绑 = findViewById(R.id.me_button_解绑);
        mMe_framelayout_银行图 = findViewById(R.id.me_framelayout_银行图);
        mMe_icon_银行 = findViewById(R.id.me_icon_银行);
        mMe_text_银行 = findViewById(R.id.me_text_银行);
        mMe_text_银行卡号 = findViewById(R.id.me_text_银行卡号);
    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        mMe_button_返回.setOnClickListener(this);
        mMe_button_解绑.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.me_button_返回:
                finish();
                break;
            case R.id.me_button_解绑:
                Toast.makeText(this,"解绑银行卡",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
