package com.ccsoft.yunqudao.ui.me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GongZuoJingLiBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.GongZuoJingLiAdapter;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/3 0003
 */

public class GongZuoJingLiActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton me_button_返回;
    private RecyclerView me_recyclerview_工作列表;
    private GongZuoJingLiAdapter adapter;
    private List<GongZuoJingLiBean.DataBean> dataList = new ArrayList<>();

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_gongzuojingli);
        initView();
        initData();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, GongZuoJingLiActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         * 初始化id
         */
        me_button_返回 = findViewById(R.id.me_button_返回);
        me_recyclerview_工作列表 = findViewById(R.id.me_recyclerview_工作列表);
        me_recyclerview_工作列表.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GongZuoJingLiAdapter(this,R.layout.item_me_workjingli,dataList);
        me_recyclerview_工作列表.setAdapter(adapter);
    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        me_button_返回.setOnClickListener(this);
    }

    private void initData(){
        OkHttpUtils.get(HttpAdress.WorkHis)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        GongZuoJingLiBean bean = JsonUtil.jsonToEntity(s,GongZuoJingLiBean.class);
                        dataList.clear();
                        dataList.addAll(bean.getData());
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id. me_button_返回:
            finish();
                break;
        }
    }
}
