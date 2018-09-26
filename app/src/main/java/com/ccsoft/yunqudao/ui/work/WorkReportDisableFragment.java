package com.ccsoft.yunqudao.ui.work;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.data.model.response.WorkReportDisableData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.adapter.WorkReportDisableAdapter;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LogUtil;
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

/**
 * @author: Pein
 * @data: 2018/5/14 0014
 */

public class WorkReportDisableFragment extends Fragment implements View.OnClickListener ,OnRefreshListener {

    private View                      mView;
    private WorkReportDisableFragment mWorkReportDisableFragment;
    private RecyclerView              mWork_recyclerview_disable;
    private WorkReportDisableAdapter  workReportDisableAdapter;
    private List<WorkReportDisableData.DataBean> dataList = new ArrayList<>();
    private SmartRefreshLayout mSwipRefresh;
    private AnimationDrawable anim;
    private ImageView yunsuan;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_work_baobeikehu_wx, container, false);
        mWorkReportDisableFragment = new WorkReportDisableFragment();
        initView();
        initData();
        initListener();
        return mView;
    }

    /**
     * 初始化id
     */
    private void initView() {
        mSwipRefresh = mView.findViewById(R.id.mSwipRefresh);
        this.mWork_recyclerview_disable = mView.findViewById(R.id.work_recyclerview_disable);
        yunsuan = mView.findViewById(R.id.yunsuan);
        yunsuan.setImageResource(R.drawable.animation_refresh);
        anim = (AnimationDrawable) yunsuan.getDrawable();
        workReportDisableAdapter = new WorkReportDisableAdapter(getContext(),R.layout.item_work_disable, dataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        this.mWork_recyclerview_disable.setLayoutManager(layoutManager);
        this.mWork_recyclerview_disable.setAdapter(workReportDisableAdapter);
        mWork_recyclerview_disable.addOnScrollListener(endlessRecyclerOnScrollListener);
    }

    /**
     * 请求数据
     */
    private void initData() {
        ClientManager.getInstance().getRecordDisabled().compose(RxSchedulers.<WorkReportDisableData>io_main()).subscribe(new ApiSubscriber<WorkReportDisableData>(getActivity()) {
            @Override
            protected void _onNext(WorkReportDisableData workReportDisableData) {
                curPage = 2;
                totalPage = workReportDisableData.last_page;
                dataList.clear();
                dataList.addAll(workReportDisableData.data);
                workReportDisableAdapter.notifyDataSetChanged();
            }

            @Override
            protected void _onError(String message) {
                LogUtil.e(message);
            }

            @Override
            protected void _onCompleted() {
//                mSwipRefresh.setRefreshing(false);
            }
        });
    }

    /**
     * 初始化监听器
     */
    private void initListener() {
        workReportDisableAdapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                WorkReportDisableData.DataBean data = dataList.get(position);
                Intent  intent = new Intent(getActivity(),WorkReportDisableActivity.class);
                intent.putExtra("id",data.client_id);
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
        OkHttpUtils.get(HttpAdress.disabled_project)
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
                            WorkReportDisableData brokerWaitConfirmData = JsonUtil.jsonToEntity(data, WorkReportDisableData.class);
                            dataList.addAll(brokerWaitConfirmData.data);
                            workReportDisableAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onAfter(@Nullable String s, @Nullable Exception e) {
                        super.onAfter(s, e);
                        workReportDisableAdapter.footerHolder.setData(FooterHolder.KEY_NORMAL);
                    }
                });
    }

    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener() {
        @Override
        public void onLoadNextPage(View view) {
            if (workReportDisableAdapter.footerHolder == null || workReportDisableAdapter.footerHolder.getmState() == FooterHolder.KEY_LOADING) {
                return;
            }
            if (curPage < totalPage) {
                workReportDisableAdapter.footerHolder.setData(FooterHolder.KEY_LOADING);
                loadNextData();
            } else {
                workReportDisableAdapter.footerHolder.setData(FooterHolder.KEY_END);
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
