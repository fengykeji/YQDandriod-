package com.ccsoft.yunqudao.ui.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.AppealBean;
import com.ccsoft.yunqudao.bean.WorkListBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.WorkListAdapter;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/8 0008
 */

public class WorkMessageActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageButton im_back;
    private SwipeRefreshLayout mSwipRefresh;
    private RecyclerView rv_worklist;
    private WorkListBean bean;
    private WorkListAdapter adapter;
    private List<WorkListBean.DataBeanX.DataBean> dataList = new ArrayList<>();
    int curPage;
    int totalPage;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_message_workmessage);
        initView();

        initListener();
        initData();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, WorkMessageActivity.class);
        context.startActivity(intent);
    }

    private void initView() {

        /**
         * 初始化id
         */
        im_back = findViewById(R.id.im_back);
        mSwipRefresh = findViewById(R.id.mSwipRefresh);
        rv_worklist =findViewById(R.id.rv_worklist);

        rv_worklist.setLayoutManager( new LinearLayoutManager(this));
        adapter = new WorkListAdapter(this,R.layout.item_message_worklist,dataList);
        rv_worklist.setAdapter(adapter);
    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        im_back.setOnClickListener(this);

        adapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                if(bean.getData().getData().get(position).getMessage_type()==0){

                }

            }
        });

        mSwipRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });
    }

    private void initData(){
        OkHttpUtils.get(HttpAdress.worklist)
                .tag(this)
                .execute(new StringCallback() {
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
                        }
                        if (code == 200 && data != null) {

                            WorkListBean bean = JsonUtil.jsonToEntity(s,WorkListBean.class);
                            curPage = 2;
                            totalPage = bean.getData().getLast_page();
                            dataList.clear();
                            dataList.addAll(bean.getData().getData());
                            adapter.notifyDataSetChanged();
                            mSwipRefresh.setRefreshing(false);
                        }
                    }


                });


    }


    private void loadNextData(){
        OkHttpUtils.get(HttpAdress.worklist)
                .tag(this)
                .params("page", curPage)
                .execute(new StringCallback() {
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
                        }
                        if (code == 200 && data != null) {
                            curPage++;
                            WorkListBean bean = JsonUtil.jsonToEntity(s,WorkListBean.class);
                            dataList.addAll(bean.getData().getData());
                            adapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onAfter(@Nullable String s, @Nullable Exception e) {
                        super.onAfter(s, e);
                        adapter.footerHolder.setData(FooterHolder.KEY_NORMAL);
                    }
                });
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.im_back:
                finish();
                break;
        }
    }

    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener() {
        @Override
        public void onLoadNextPage(View view) {
            if (adapter.footerHolder == null || adapter.footerHolder.getmState() == FooterHolder.KEY_LOADING) {
                return;
            }
            if (curPage < totalPage) {
                adapter.footerHolder.setData(FooterHolder.KEY_LOADING);
                loadNextData();
            } else {
                adapter.footerHolder.setData(FooterHolder.KEY_END);
            }

        }
    };
}
