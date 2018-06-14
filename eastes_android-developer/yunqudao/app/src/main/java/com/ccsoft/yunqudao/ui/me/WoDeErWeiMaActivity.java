package com.ccsoft.yunqudao.ui.me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/3 0003
 */

public class WoDeErWeiMaActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton  mMe_button_返回;
    private Button mMe_button_二维码分享;
    private ImageView mMe_icon_二维码头像;
    private TextView mMe_text_二维码内名字;
    private ImageView mMe_image_二维码;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_erweima);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, WoDeErWeiMaActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         * 初始化id
         */
        mMe_button_返回 = findViewById(R.id.me_button_返回);
        mMe_button_二维码分享 = findViewById(R.id.me_button_二维码分享);
        mMe_icon_二维码头像 = findViewById(R.id.me_icon_二维码头像);
        mMe_text_二维码内名字 = findViewById(R.id.me_text_二维码内名字);
        mMe_image_二维码 = findViewById(R.id.me_image_二维码);
    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        mMe_button_返回.setOnClickListener(this);
        mMe_button_二维码分享.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.me_button_返回:
                finish();
                break;
            case R.id.me_button_二维码分享:
                Toast.makeText(this,"你点击了分享",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
