package com.ccsoft.yunqudao.ui.work.secondhandhouse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;

public class ZhuanDaiGouActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_showcontent,tv_showcontent1;
    private LinearLayout ll_content,ll_content1;
    private int a = 0;
    private int b = 0;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_zhuandaigou);
        HideIMEUtil.wrap(this);
        initView();
        initListener();
    }

    private void initView(){
        tv_showcontent = findViewById(R.id.tv_showcontent);
        tv_showcontent1 = findViewById(R.id.tv_showcontent1);
        ll_content = findViewById(R.id.ll_content);
        ll_content1 = findViewById(R.id.ll_content1);
    }

    private void initListener(){
        tv_showcontent1.setOnClickListener(this);
        tv_showcontent.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_showcontent:
                if(a%2==0){
                    ll_content.setVisibility(View.VISIBLE);
                }else {
                    ll_content.setVisibility(View.GONE);
                }
                a++;
                break;
            case R.id.tv_showcontent1:
                if(b%2==0){
                    ll_content1.setVisibility(View.VISIBLE);
                }else {
                    ll_content1.setVisibility(View.GONE);
                }
                b++;
                break;
        }
    }
}
