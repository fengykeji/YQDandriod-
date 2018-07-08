package com.ccsoft.yunqudao.ui.house;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.utils.ActivityManager;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class ProjectDongTaiXiangQingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mHouse_button_返回;
    private LinearLayout    mHouse_button_linearlayout_项目图册;
    private WebView webView;
    private String loadUrl;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_house_project_dongtaixiangqing);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ProjectDongTaiXiangQingActivity.class);
        context.startActivity(intent);
    }


    /**
     * 初始化id
     */
    private void initView() {
        webView = findViewById(R.id.webview);
        mHouse_button_返回 = findViewById(R.id.house_button_返回);
        mHouse_button_linearlayout_项目图册 = findViewById(R.id.house_button_linearlayout_项目图册);

        loadUrl = getIntent().getStringExtra("url");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl(AppConstants.URL+loadUrl);

    }


    /**
     * 初始化监听器
     */
    private void initListener() {

        mHouse_button_返回.setOnClickListener(this);
        mHouse_button_linearlayout_项目图册.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.house_button_返回:
                finish();
                break;
            case R.id.house_button_linearlayout_项目图册:
            ProjectXiangCeActivity.start(this);
                break;
        }
    }
}
