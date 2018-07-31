package com.ccsoft.yunqudao.ui.me;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.UnPlayListBean;
import com.ccsoft.yunqudao.bean.WorkListBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.UnPlayListAdapter;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

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

public class WeiJieListActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton  mMe_button_返回;
    private RecyclerView mMe_recyclerview_未结列表;
    private SmartRefreshLayout mSwipRefresh;
    private AnimationDrawable anim;
    private ImageView yunsuan;
    private List<UnPlayListBean.DataBeanX.DataBean> dataList = new ArrayList<>();
    private UnPlayListAdapter adapter;
    private UnPlayListBean bean;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_weijieliebiao);
        initView();
        initData();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, WeiJieListActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         * 初始化id
         */
        mMe_button_返回 = findViewById(R.id.me_button_返回);
        mMe_recyclerview_未结列表 = findViewById(R.id.me_recyclerview_未结列表);
        mSwipRefresh = findViewById(R.id.mSwipRefresh);
        yunsuan = findViewById(R.id.yunsuan);
        yunsuan.setImageResource(R.drawable.animation_refresh);
        anim = (AnimationDrawable) yunsuan.getDrawable();

        mMe_recyclerview_未结列表.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UnPlayListAdapter(this,R.layout.item_me_weijieyongjin,dataList);
        mMe_recyclerview_未结列表.setAdapter(adapter);
        mMe_recyclerview_未结列表.addOnScrollListener(endlessRecyclerOnScrollListener);

    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        mMe_button_返回.setOnClickListener(this);
        mSwipRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                initData();
                anim.start();
                mSwipRefresh.finishRefresh(900);
            }
        } );

        adapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                Intent intent = new Intent(WeiJieListActivity.this,WeiJieYongJinXiangQingActivity.class);
                intent.putExtra("id",bean.getData().getData().get(position).getBroker_id());
                startActivity(intent);
            }
        });
    }

    private void initData(){
        OkHttpUtils.get(HttpAdress.unPayList)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                         bean = JsonUtil.jsonToEntity(s,UnPlayListBean.class);
                        if(bean.getCode() == 200){
                            curPage = 2;
                            totalPage = bean.getData().getLast_page();
                            dataList.clear();
                            dataList.addAll(bean.getData().getData());
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
        OkHttpManager.getInstance().get(HttpAdress.unPayList, new BaseCallBack() {
            @Override
            public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {
                Type type = new TypeToken<UnPlayListBean>(){}.getType();
                UnPlayListBean bean = new Gson().fromJson(obj.toString(),type);

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

    int curPage;
    int totalPage;

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
                            UnPlayListBean bean = JsonUtil.jsonToEntity(s,UnPlayListBean.class);
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
