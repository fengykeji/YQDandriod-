package com.ccsoft.yunqudao.ui.message;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
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
import com.ccsoft.yunqudao.utils.SpUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.jpush.android.api.JPushInterface;
import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/8 0008
 */

public class WorkMessageActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageButton im_back;
    private SmartRefreshLayout mSwipRefresh;
    private RecyclerView rv_worklist;
    private WorkListBean bean;
    private WorkListAdapter adapter;
    private List<WorkListBean.DataBeanX.DataBean> dataList = new ArrayList<>();
    int curPage;
    int totalPage;
    private AnimationDrawable anim;
    private ImageView yunsuan;


    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        JPushInterface.init(this);
        JPushInterface.setAlias(this,"agent_"+ SpUtil.getInt("agent_id",0),null);
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

        yunsuan = findViewById(R.id.yunsuan);
        yunsuan.setImageResource(R.drawable.animation_refresh);
        anim = (AnimationDrawable) yunsuan.getDrawable();
        rv_worklist.setLayoutManager( new LinearLayoutManager(this));
        adapter = new WorkListAdapter(this,R.layout.item_message_worklist,dataList);
        rv_worklist.setAdapter(adapter);
        rv_worklist.addOnScrollListener(endlessRecyclerOnScrollListener);
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
                    Intent intent = new Intent(WorkMessageActivity.this,MessageCommendDisableDetailsActivity.class);
                    intent.putExtra("client_id",bean.getData().getData().get(position).getClient_id());
                    intent.putExtra("message_id",bean.getData().getData().get(position).getMessage_id());
                    startActivity(intent);
                }else if(bean.getData().getData().get(position).getMessage_type()==1){
                    Intent intent = new Intent(WorkMessageActivity.this,MessageCommendVerifyDetailActivity.class);
                    intent.putExtra("client_id",bean.getData().getData().get(position).getClient_id());
                    intent.putExtra("message_id",bean.getData().getData().get(position).getMessage_id());
                    startActivity(intent);
                }else if(bean.getData().getData().get(position).getMessage_type()==2){
                    Intent intent = new Intent(WorkMessageActivity.this,MessageReportVerifyActivity.class);
                    intent.putExtra("client_id",bean.getData().getData().get(position).getClient_id());
                    intent.putExtra("message_id",bean.getData().getData().get(position).getMessage_id());
                    startActivity(intent);
                }else if(bean.getData().getData().get(position).getMessage_type()==3) {
                    Intent intent = new Intent(WorkMessageActivity.this, MessagekReportValidDeatilActivity.class);
                    intent.putExtra("client_id", bean.getData().getData().get(position).getClient_id());
                    intent.putExtra("message_id", bean.getData().getData().get(position).getMessage_id());
                    startActivity(intent);
                }else if(bean.getData().getData().get(position).getMessage_type()==4) {
                    Intent intent = new Intent(WorkMessageActivity.this, MessageChengjiaoVailddetailActivity.class);
                    intent.putExtra("client_id", bean.getData().getData().get(position).getClient_id());
                    intent.putExtra("message_id", bean.getData().getData().get(position).getMessage_id());
                    startActivity(intent);
                }else if(bean.getData().getData().get(position).getMessage_type()==5) {
                    Intent intent = new Intent(WorkMessageActivity.this, MessageReportDisableActivity.class);
                    intent.putExtra("client_id", bean.getData().getData().get(position).getClient_id());
                    intent.putExtra("message_id", bean.getData().getData().get(position).getMessage_id());
                    startActivity(intent);
                }
            }
        });

        mSwipRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                initData();
                anim.start();
                mSwipRefresh.finishRefresh(900);
            }
        } );
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
                            bean = JsonUtil.jsonToEntity(s,WorkListBean.class);
                            curPage = 2;
                            totalPage = bean.getData().getLast_page();
                            dataList.clear();
                            dataList.addAll(bean.getData().getData());
                            adapter.notifyDataSetChanged();
//                            mSwipRefresh.setRefreshing(false);
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
