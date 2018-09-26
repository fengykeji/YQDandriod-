package com.ccsoft.yunqudao.ui.work.secondhandhouse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ccsoft.yunqudao.R;

public class WanChengKanChaActivity extends AppCompatActivity implements View.OnClickListener{

    private Button customers_button_commit;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wanchengkancha);
        initView();
//        initData();
        initListener();
    }
    private void initView(){
        customers_button_commit = findViewById(R.id.customers_button_commit);
    }
    private void initListener(){
        customers_button_commit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.customers_button_commit:

                break;
        }
    }
}
