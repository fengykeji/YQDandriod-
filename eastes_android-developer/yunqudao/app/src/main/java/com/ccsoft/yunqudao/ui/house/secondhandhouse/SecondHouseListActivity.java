package com.ccsoft.yunqudao.ui.house.secondhandhouse;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.ItemsDialogFragment;

public class SecondHouseListActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView house_text_housetype;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_seconghouselist);
        initView();
//        initData();
        initListener();

    }
    private void initView(){
        house_text_housetype = findViewById(R.id.house_text_housetype);
    }

    private void initListener(){
        house_text_housetype.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.house_text_housetype:
                showItemsDialogFragment();
                break;
        }
    }

    public void showItemsDialogFragment() {
        ItemsDialogFragment itemsDialogFragment = new ItemsDialogFragment();
        String[] items = {"新房", "二手房","租房","取消" };
        itemsDialogFragment.show("", items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:

                        break;
                    case 1:
                        Intent intent = new Intent(SecondHouseListActivity.this, SecondHouseListActivity.class);
                        startActivity(intent);
                        break;
                    case 2:

                        break;
                    case 3:
                        itemsDialogFragment.dismiss();
                        break;

                }
            }
        }, getSupportFragmentManager());
    }
}
