package com.ccsoft.yunqudao.ui.me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/3 0003
 */

public class GongSiRenZhengActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton    me_button_返回;
    private RelativeLayout me_button_relativelayout_搜索;
    private Spinner        me_spinner_省份;
    private Spinner        me_spinner_城市;
    private Spinner        me_spinner_区域;
    private RecyclerView   me_recyclerview_公司列表;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_xuanzegongsi);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, GongSiRenZhengActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         * 初始化id
         */
        me_button_返回 = findViewById(R.id.me_button_返回);

        me_button_relativelayout_搜索 = findViewById(R.id.me_button_relativelayout_搜索);

        me_spinner_省份 = findViewById(R.id.me_spinner_省份);

        me_spinner_城市 = findViewById(R.id.me_spinner_城市);

        me_spinner_区域 = findViewById(R.id.me_spinner_区域);

        me_recyclerview_公司列表 = findViewById(R.id.me_recyclerview_公司列表);
    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        me_button_返回.setOnClickListener(this);
        me_button_relativelayout_搜索.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.me_button_返回:
                finish();
                break;
            case R.id.me_button_relativelayout_搜索:
                Toast.makeText(this, "你点击了搜索", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
