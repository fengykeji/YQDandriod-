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
import com.ccsoft.yunqudao.bean.GuanZhuBean;
import com.ccsoft.yunqudao.bean.HouseListBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.GuanZhuAdapter;
import com.ccsoft.yunqudao.ui.adapter.HouseListAdapter;
import com.ccsoft.yunqudao.ui.house.ProjectXiangQingActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/3 0003
 */

public class WoDeGuanZhuActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton  me_button_返回;
    private RecyclerView me_recyclerview_关注列表;
    private GuanZhuAdapter adapter;
    private List<GuanZhuBean.DataBean> list = new ArrayList<>();

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_guanzhu);
        initView();
        initData();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, WoDeGuanZhuActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         * 初始化id
         */
        me_button_返回 = findViewById(R.id.me_button_返回);
        me_recyclerview_关注列表 = findViewById(R.id.me_recyclerview_关注列表);
    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        me_button_返回.setOnClickListener(this);
    }

    private void initData(){
//
        OkHttpManager.getInstance().get(HttpAdress.getFocusProjectList, new BaseCallBack() {
            @Override
            public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {

                Type type = new TypeToken<GuanZhuBean>() {}.getType();
                GuanZhuBean  bean = new Gson().fromJson(obj.toString(),type);
                list.clear();
                list.addAll(bean.getData());

                        me_recyclerview_关注列表.setLayoutManager(new LinearLayoutManager(WoDeGuanZhuActivity.this));
                        adapter = new GuanZhuAdapter(WoDeGuanZhuActivity.this,R.layout.house_list_activity, list);
                        me_recyclerview_关注列表.setAdapter(adapter);
                        adapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
                            @Override
                            public void onItemClickListner(View v, int position) {
                                Intent intent = new Intent(WoDeGuanZhuActivity.this,ProjectXiangQingActivity.class);
                                intent.putExtra("project_id",bean.getData().get(position).getProject_id());
                                startActivity(intent);
                            }
                        });
                    }

            @Override
            public void onFailure(Call call, Exception e) {

            }

            @Override
            public void onError(Response response, int errorCode) {

            }

            @Override
            public void onRequestBefore() {

            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.me_button_返回:
                finish();
                break;
        }
    }
}
