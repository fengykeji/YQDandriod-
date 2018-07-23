package com.ccsoft.yunqudao.ui.work;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
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
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.data.model.response.RecordAffirmBaseData;
import com.ccsoft.yunqudao.data.model.response.RecordValidData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.adapter.OnCallListener;
import com.ccsoft.yunqudao.ui.adapter.RecordValidAdapter;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LogUtil;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewAdapter;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewHolder;
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

public class WorkReportVaildFragment extends Fragment implements View.OnClickListener ,OnRefreshListener {

    private View                    mView;
    private WorkReportVaildFragment mWorkReportVaild;
    private RecyclerView            mWork_recyclerview_valid;
    private RecordValidAdapter   recordValidAdapter;
    private List<RecordValidData.DataBean> dataList = new ArrayList<>();
    private SmartRefreshLayout mSwipRefresh;
    private AnimationDrawable anim;
    private ImageView yunsuan;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_work_baobeikehu_yx, container, false);
        mWorkReportVaild = new WorkReportVaildFragment();
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
        this.mWork_recyclerview_valid = mView.findViewById(R.id.work_recyclerview_valid);
        yunsuan = mView.findViewById(R.id.yunsuan);
        yunsuan.setImageResource(R.drawable.animation_refresh);
        anim = (AnimationDrawable) yunsuan.getDrawable();
        recordValidAdapter = new RecordValidAdapter(getContext(),R.layout.item_work_valid,dataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        this.mWork_recyclerview_valid.setLayoutManager(layoutManager);
        this.mWork_recyclerview_valid.setAdapter(recordValidAdapter);
        mWork_recyclerview_valid.addOnScrollListener(endlessRecyclerOnScrollListener);
    }

    /**
     * 请求数据
     */
    private void initData() {
        ClientManager.getInstance().getRecordValid().compose(RxSchedulers.<RecordValidData>io_main()).subscribe(new ApiSubscriber<RecordValidData>(getActivity()) {
            @Override
            protected void _onNext(RecordValidData recordValidData) {
                dataList.clear();
                dataList.addAll(recordValidData.data);
                curPage = 2;
                totalPage = recordValidData.last_page;
                recordValidAdapter.notifyDataSetChanged();
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
        recordValidAdapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                RecordValidData.DataBean data = dataList.get(position);
                WorkReportValidDeatilActivity.start(getContext(),data.client_id);
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
        OkHttpUtils.get(HttpAdress.value_project)
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
                            RecordValidData brokerWaitConfirmData = JsonUtil.jsonToEntity(data, RecordValidData.class);
                            dataList.addAll(brokerWaitConfirmData.data);
                            recordValidAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onAfter(@Nullable String s, @Nullable Exception e) {
                        super.onAfter(s, e);
                        recordValidAdapter.footerHolder.setData(FooterHolder.KEY_NORMAL);
                    }
                });
    }

    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener() {
        @Override
        public void onLoadNextPage(View view) {
            if (recordValidAdapter.footerHolder == null || recordValidAdapter.footerHolder.getmState() == FooterHolder.KEY_LOADING) {
                return;
            }
            if (curPage < totalPage) {
                recordValidAdapter.footerHolder.setData(FooterHolder.KEY_LOADING);
                loadNextData();
            } else {
                recordValidAdapter.footerHolder.setData(FooterHolder.KEY_END);
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
