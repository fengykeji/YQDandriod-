package com.ccsoft.yunqudao.ui.message;

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
import com.ccsoft.yunqudao.bean.QiangDanListBean;
import com.ccsoft.yunqudao.bean.WorkListBean;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.QiangDanAdapter;
import com.ccsoft.yunqudao.ui.adapter.WorkListAdapter;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class QiangDanListActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton im_back;
    private SmartRefreshLayout mSwipRefresh;
    private RecyclerView rv_worklist;
    private QiangDanListBean bean;
    private QiangDanAdapter adapter;
    private List<QiangDanListBean.DataBeanX.DataBean> dataList = new ArrayList<>();
    int curPage;
    int totalPage;
    private AnimationDrawable anim;
    private ImageView yunsuan;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_message_workmessage);
        initView();
        initListener();
        initData();
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
        adapter = new QiangDanAdapter(this,R.layout.item_qiangdanlist,dataList);
        rv_worklist.setAdapter(adapter);
        rv_worklist.addOnScrollListener(endlessRecyclerOnScrollListener);
    }

    private void initListener(){
        im_back.setOnClickListener(this);
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
        OkHttpUtils.get(HttpAdress.qiangdanList)
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
                            bean = JsonUtil.jsonToEntity(s,QiangDanListBean.class);
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
        OkHttpUtils.get(HttpAdress.qiangdanList)
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
                            QiangDanListBean bean = JsonUtil.jsonToEntity(s,QiangDanListBean.class);
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
            if (curPage < 100) {
                adapter.footerHolder.setData(FooterHolder.KEY_LOADING);
                loadNextData();
            } else {
                adapter.footerHolder.setData(FooterHolder.KEY_END);
            }

        }
    };
}
