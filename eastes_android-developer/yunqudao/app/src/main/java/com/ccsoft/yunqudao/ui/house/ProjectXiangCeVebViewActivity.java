package com.ccsoft.yunqudao.ui.house;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.utils.ActivityManager;

import org.greenrobot.eventbus.EventBus;

public class ProjectXiangCeVebViewActivity extends AppCompatActivity {

    private WebView webView;
    private String url;
    private ImageButton mHouse_button_返回;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_huxing3d_webview);

        initView();

    }

    private void initView(){
        webView = findViewById(R.id.webview);
        mHouse_button_返回 = findViewById(R.id.house_button_返回);
        url = getIntent().getStringExtra("url");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(AppConstants.URL+url);

        mHouse_button_返回.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
