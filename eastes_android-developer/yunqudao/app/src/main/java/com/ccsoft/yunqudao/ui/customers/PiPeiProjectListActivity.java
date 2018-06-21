package com.ccsoft.yunqudao.ui.customers;

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
import com.ccsoft.yunqudao.bean.PipeiBean;
import com.ccsoft.yunqudao.data.model.response.MatchData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.model.ClientListModel;
import com.ccsoft.yunqudao.ui.adapter.CustomersMatchAdapter;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.lzy.okhttputils.request.GetRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class PiPeiProjectListActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton  mCstomers_button_back;
    private RecyclerView mCustomers_viewpager_match_list;
    private List<PipeiBean.DataBean.RecommendProjectBean> dataList = new ArrayList<>();
    private CustomersMatchAdapter adapter;
    private int client_id;
    private PipeiBean.DataBean.RecommendProjectBean matchData;
    private Gson gson;
    private GsonBuilder builder;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_xiangqing_pipeilist);
        initView();
        initListener();
        initData();

    }

    public static void start(Context context) {
        Intent intent = new Intent(context, PiPeiProjectListActivity.class);
        context.startActivity(intent);

    }

    /**
     * 初始化
     */
    private void initView() {
        builder=new GsonBuilder();
        gson=builder.create();

        mCstomers_button_back = findViewById(R.id.customers_button_back);
        mCustomers_viewpager_match_list = findViewById(R.id.customers_viewpager_match_list);
        mCustomers_viewpager_match_list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomersMatchAdapter(this,R.layout.activity_tuijianzhuangtai,dataList);
        mCustomers_viewpager_match_list.setAdapter(adapter);

        client_id = getIntent().getIntExtra("client_id",0);
    }

    /**
     * 初始化
     */
    private void initListener() {

        mCstomers_button_back.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customers_button_back:
                finish();
                break;
        }
    }

    private void initData(){
        GetRequest getRequest = OkHttpUtils.get(HttpAdress.PIPEI)
                .tag(this)
                .params("client_id", client_id);
        getRequest.execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                int code = 0;
                String data = null;
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    code = jsonObject.getInt("code");
                    data = jsonObject.getString("data");
                } catch (JSONException e) {
                    e.printStackTrace();
                }if (code == 200 && data != null) {
                    try {

                        PipeiBean.DataBean matchData = gson.fromJson(data, PipeiBean.DataBean.class);

                        dataList.clear();
                        dataList.addAll(matchData.getRecommend_project());
                        adapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();

                    }

                }
            }
        });





    }
}
