package com.ccsoft.yunqudao.ui.house;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ProjectPiPeiKeHuBean;
import com.ccsoft.yunqudao.ui.adapter.ProjectPiPeiAdapter;
import com.ccsoft.yunqudao.ui.customers.AddCustomers1Activity;
import com.ccsoft.yunqudao.utils.ActivityManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class ProjectPiPeiKeHuActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton    mHouse_button_返回;
    private RelativeLayout mHouse_button_relativelayout搜索;
    private ImageButton    mHouse_button_添加客户;
    private Button         mHouse_button_推荐1;
    private Button         mHouse_button_推荐2;
    private Button         mHouse_button_推荐3;
    private RecyclerView recyclerView;
    private ProjectPiPeiAdapter adapter;
    private List<ProjectPiPeiKeHuBean.DataBean> dataList = new ArrayList<>();

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_house_tuijiankehu);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ProjectPiPeiKeHuActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化
     */
    private void initView() {
        Bundle bundle = getIntent().getExtras();
        dataList = (List<ProjectPiPeiKeHuBean.DataBean>) bundle.get("list");

        mHouse_button_返回 = findViewById(R.id.house_button_返回);
        mHouse_button_relativelayout搜索 = findViewById(R.id.house_button_relativelayout搜索);
        mHouse_button_添加客户 = findViewById(R.id.house_button_添加客户);
        mHouse_button_推荐1 = findViewById(R.id.house_button_推荐1);
        mHouse_button_推荐2 = findViewById(R.id.house_button_推荐2);
        mHouse_button_推荐3 = findViewById(R.id.house_button_推荐3);
        recyclerView = findViewById(R.id.recyclerview_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProjectPiPeiAdapter(this,R.layout.item_project_pipei,dataList);
        recyclerView.setAdapter(adapter);

    }

    /**
     * 初始化
     */
    private void initListener() {

        mHouse_button_返回.setOnClickListener(this);
        mHouse_button_relativelayout搜索.setOnClickListener(this);
        mHouse_button_添加客户.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.house_button_返回:
                finish();
                break;

            case R.id.house_button_relativelayout搜索:

                break;

            case R.id.house_button_添加客户:
                AddCustomers1Activity.start(this);
                break;

            case R.id.house_button_推荐1:
                Toast.makeText(this, "你推荐了该项目", Toast.LENGTH_SHORT).show();
                break;
            case R.id.house_button_推荐2:
                Toast.makeText(this, "你推荐了该项目", Toast.LENGTH_SHORT).show();
                break;
            case R.id.house_button_推荐3:
                Toast.makeText(this, "你推荐了该项目", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
