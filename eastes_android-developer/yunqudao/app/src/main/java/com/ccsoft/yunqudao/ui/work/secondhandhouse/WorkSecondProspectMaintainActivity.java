package com.ccsoft.yunqudao.ui.work.secondhandhouse;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.SurveyListBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.data.model.response.BrokerWaitConfirmData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.WorkRecommendVerifyAdapter;
import com.ccsoft.yunqudao.ui.adapter.WorkSecondprospectMaintainAdapter;
import com.ccsoft.yunqudao.ui.home.HomeActivity;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.ui.work.AddWorkActivity;
import com.ccsoft.yunqudao.ui.work.WorkCommendVerifyDetailActivity;
import com.ccsoft.yunqudao.ui.work.WorkRecommendVerifyFragment;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
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

public class WorkSecondProspectMaintainActivity extends AppCompatActivity implements View.OnClickListener ,OnRefreshListener {

    private ImageButton mWork_button_back,work_button_add_recommend;

    private RecyclerView mWork_recyclerview_verify;
    private WorkSecondprospectMaintainAdapter mAdapter;
    private SmartRefreshLayout mSwipRefresh;
    private List<SurveyListBean.DataBeanX.DataBean> dataList = new ArrayList<>();
    private AnimationDrawable anim;
    private ImageView yunsuan;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_work_second_maintain);
        HideIMEUtil.wrap(this);
        initView();
        initData();
        initListener();
    }

    /**
     * 初始化id
     */
    private void initView() {
        work_button_add_recommend = findViewById(R.id.work_button_add_recommend);
        mWork_button_back = findViewById(R.id.work_button_back);
        mSwipRefresh = findViewById(R.id.mSwipRefresh);
        this.mWork_recyclerview_verify = findViewById(R.id.work_recyclerview_verify);
        yunsuan = findViewById(R.id.yunsuan);
        yunsuan.setImageResource(R.drawable.animation_refresh);
        anim = (AnimationDrawable) yunsuan.getDrawable();
        mWork_recyclerview_verify.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mAdapter = new WorkSecondprospectMaintainAdapter(this, R.layout.item_work_recom, dataList);
        mWork_recyclerview_verify.setAdapter(mAdapter);
        mWork_recyclerview_verify.addOnScrollListener(endlessRecyclerOnScrollListener);
    }

    /**
     * 初始化监听器
     */
    private void initListener() {
        mAdapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                int id = dataList.get(position).getHouse_id();
//                Intent intent = new Intent(WorkSecondProspectMaintainActivity.this,WorkSecondProspectMaintainDetailActivity.class);
                Intent intent = new Intent(WorkSecondProspectMaintainActivity.this,WorkSecondProspectFinishDetailActivity.class);
                intent.putExtra("house_id",id);
                startActivity(intent);
            }
        });
        mSwipRefresh.setOnRefreshListener(this);
        work_button_add_recommend.setOnClickListener(this);
        mWork_button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkSecondProspectMaintainActivity.this, HomeActivity.class);
                intent.putExtra("fid",3);
                startActivity(intent);
                finish();
            }
        });
    }

    /**
     * 下拉刷新
     */

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        initData();
        anim.start();
        mSwipRefresh.finishRefresh(900);
    }
    private void initData() {
        OkHttpUtils.get(HttpAdress.surveyList)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        int code = 0;
                        String data1 = null;
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            code = jsonObject.getInt("code");
                            data1 = jsonObject.getString("data");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (code == 200 && data1 != null) {
                            SurveyListBean brokerWaitConfirmData = JsonUtil.jsonToEntity(s, SurveyListBean.class);
                            totalPage = brokerWaitConfirmData.getData().getLast_page();
                            curPage = 2;
                            dataList.clear();
                            dataList.addAll(brokerWaitConfirmData.getData().getData());
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                    @Override
                    public void onAfter(@Nullable String s, @Nullable Exception e) {
                        super.onAfter(s, e);

                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.work_button_add_recommend:
                Intent intent = new Intent(this,AddWorkActivity.class);
                startActivity(intent);
                break;
        }
    }

    int curPage;
    int totalPage;
    private void loadNextData() {
        OkHttpUtils.get(HttpAdress.waitConfirm)
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
                            SurveyListBean brokerWaitConfirmData = JsonUtil.jsonToEntity(s, SurveyListBean.class);
                            dataList.addAll(brokerWaitConfirmData.getData().getData());
                            mAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onAfter(@Nullable String s, @Nullable Exception e) {
                        super.onAfter(s, e);
                        mAdapter.footerHolder.setData(FooterHolder.KEY_NORMAL);
                    }
                });
    }

    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener() {
        @Override
        public void onLoadNextPage(View view) {
            if (mAdapter.footerHolder == null || mAdapter.footerHolder.getmState() == FooterHolder.KEY_LOADING) {
                return;
            }
            if (curPage < totalPage) {
                mAdapter.footerHolder.setData(FooterHolder.KEY_LOADING);
                loadNextData();
            } else {
                mAdapter.footerHolder.setData(FooterHolder.KEY_END);
            }

        }
    };
}
