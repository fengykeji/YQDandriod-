package com.ccsoft.yunqudao.ui.work;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.HouseListBean;
import com.ccsoft.yunqudao.bean.WorkDealBean;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.data.model.response.RecordAffirmBaseData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.adapter.WorkChengjiaoListAdapter;
import com.ccsoft.yunqudao.ui.adapter.WorkReportVerifyAdapter;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LogUtil;
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

public class WorkChengjiaoVerifyFragment extends Fragment implements View.OnClickListener ,OnRefreshListener {

    private View                     mView;
    private WorkChengjiaoVerifyFragment workChengJiaoKeHuActivity;
    private RecyclerView mWork_recyclerview_verify;
    private WorkChengjiaoListAdapter workReportVerifyAdapter;
    private List<WorkDealBean.DataBeanX.DataBean> dataList = new ArrayList<>();
    private SmartRefreshLayout mSwipRefresh;
    private WorkDealBean dealBean;
    private AnimationDrawable anim;
    private ImageView yunsuan;


    @Override
    public void onStart() {
        super.onStart();
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_work_baobeikehu_dqr, container, false);
        workChengJiaoKeHuActivity = new WorkChengjiaoVerifyFragment();
        initView();
        initListener();
        initData();
        return mView;
    }

    /**
     * 请求数据
     */
    private void initData() {
//        ClientManager.getInstance().getRecordAffirm().compose(RxSchedulers.<RecordAffirmBaseData>io_main()).subscribe(new ApiSubscriber<RecordAffirmBaseData>(getActivity()) {
//
//            @Override
//            protected void _onNext(RecordAffirmBaseData recordAffirmBaseData) {
//                curPage = 2;
//                totalPage = recordAffirmBaseData.last_page;
//                dataList.clear();
//                dataList.addAll(recordAffirmBaseData.data);
//                workReportVerifyAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            protected void _onError(String message) {
//                LogUtil.e(message);
//            }
//
//            @Override
//            protected void _onCompleted() {
//                mSwipRefresh.setRefreshing(false);
//            }
//        });

        OkHttpUtils.get(HttpAdress.DEALLIST)
                .tag(getActivity())
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
                            WorkDealBean workDealBean = JsonUtil.jsonToEntity(s,WorkDealBean.class);
                            curPage = 2;
                            totalPage = workDealBean.getData().getLast_page();
                            dataList.clear();
                            dataList.addAll(workDealBean.getData().getData());
                            workReportVerifyAdapter.notifyDataSetChanged();
//                            mSwipRefresh.setRefreshing(false);

                        }
                    }
                });

    }

    /**
     * 初始化id
     */
    private void initView() {
        mSwipRefresh = mView.findViewById(R.id.mSwipRefresh);
        this.mWork_recyclerview_verify = mView.findViewById(R.id.work_recyclerview_verify);
        yunsuan = mView.findViewById(R.id.yunsuan);
        yunsuan.setImageResource(R.drawable.animation_refresh);
        anim = (AnimationDrawable) yunsuan.getDrawable();
        workReportVerifyAdapter = new WorkChengjiaoListAdapter(getContext(),R.layout.item_work_nodeal, dataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        this.mWork_recyclerview_verify.setLayoutManager(layoutManager);
        this.mWork_recyclerview_verify.setAdapter(workReportVerifyAdapter);
        mWork_recyclerview_verify.addOnScrollListener(endlessRecyclerOnScrollListener);
    }

    /**
     * 初始化监听器
     */
    private void initListener() {
        workReportVerifyAdapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                WorkDealBean.DataBeanX.DataBean data = dataList.get(position);
                int client_id = data.getClient_id();
                Intent intent = new Intent(getActivity(),WorkDealVerifydetailActivity.class);
                intent.putExtra("id",client_id);
                getActivity().startActivity(intent);
            }
        });
        mSwipRefresh.setOnRefreshListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

    int curPage;
    int totalPage;
    private void loadNextData() {
        OkHttpUtils.get(HttpAdress.waitConfirm_project)
                .tag(getActivity())
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
                            RecordAffirmBaseData brokerWaitConfirmData = JsonUtil.jsonToEntity(data, RecordAffirmBaseData.class);
//                            dataList.addAll(brokerWaitConfirmData.data);
                            workReportVerifyAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onAfter(@Nullable String s, @Nullable Exception e) {
                        super.onAfter(s, e);
                        workReportVerifyAdapter.footerHolder.setData(FooterHolder.KEY_NORMAL);
                    }
                });
    }

    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener() {
        @Override
        public void onLoadNextPage(View view) {
            if (workReportVerifyAdapter.footerHolder == null || workReportVerifyAdapter.footerHolder.getmState() == FooterHolder.KEY_LOADING) {
                return;
            }
            if (curPage < totalPage) {
                workReportVerifyAdapter.footerHolder.setData(FooterHolder.KEY_LOADING);
                loadNextData();
            } else {
                workReportVerifyAdapter.footerHolder.setData(FooterHolder.KEY_END);
            }

        }
    };

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        initData();
        anim.start();
        mSwipRefresh.finishRefresh(900);
    }
}
