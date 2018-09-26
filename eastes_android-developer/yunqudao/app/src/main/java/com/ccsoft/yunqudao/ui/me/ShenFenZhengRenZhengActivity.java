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
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/7 0007
 */

public class ShenFenZhengRenZhengActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mMe_button_返回;
    private Button      mMe_button_完成;
    private EditText    mMe_edittext_身份证姓名;
    private EditText    mMe_edittext_身份证号码;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_shenfenzhengrenzheng);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ShenFenZhengRenZhengActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         *初始化id
         */

        mMe_button_返回 = findViewById(R.id.me_button_返回);
        mMe_button_完成 = findViewById(R.id.me_button_完成);
        mMe_edittext_身份证姓名 = findViewById(R.id.me_edittext_身份证姓名);
        mMe_edittext_身份证号码 = findViewById(R.id.me_edittext_身份证号码);
    }

    private void initListener() {
        /**
         *初始化监听器
         */
        mMe_button_返回.setOnClickListener(this);
        mMe_button_完成.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()){
            case R.id.me_button_返回:
                finish();
                break;
            case R.id.me_button_完成:
                finish();
                break;
        }

    }
}
