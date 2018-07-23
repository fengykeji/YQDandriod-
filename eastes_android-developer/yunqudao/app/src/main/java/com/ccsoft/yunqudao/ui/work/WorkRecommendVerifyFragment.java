package com.ccsoft.yunqudao.ui.work;

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
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.data.model.response.BrokerWaitConfirmData;
import com.ccsoft.yunqudao.data.model.response.ConfirmDetailData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.adapter.WorkRecommendVerifyAdapter;
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

public class WorkRecommendVerifyFragment extends Fragment implements View.OnClickListener ,OnRefreshListener{

    private View mView;
    private WorkRecommendVerifyFragment mWorkRecommendVerifyFragment;
    private RecyclerView mWork_recyclerview_verify;
    private WorkRecommendVerifyAdapter mAdapter;
    private SmartRefreshLayout mSwipRefresh;
    private List<BrokerWaitConfirmData.WaitConfirmData> dataList = new ArrayList<>();
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

        mView = inflater.inflate(R.layout.fragment_work_tuijian_qrz, container, false);
        mWorkRecommendVerifyFragment = new WorkRecommendVerifyFragment();
        initView();
        initListener();
        initData();
        return mView;
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
        mWork_recyclerview_verify.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new WorkRecommendVerifyAdapter(getActivity(), R.layout.item_work_recom, dataList);
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
                int id = dataList.get(position).client_id;
                WorkCommendVerifyDetailActivity.start(getActivity(), id);
            }
        });
        mSwipRefresh.setOnRefreshListener(this);
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


        OkHttpUtils.get(HttpAdress.workwaitConfirm)
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
                            BrokerWaitConfirmData brokerWaitConfirmData = JsonUtil.jsonToEntity(data1, BrokerWaitConfirmData.class);
                            totalPage = brokerWaitConfirmData.last_page;
                            curPage = 2;
                            dataList.clear();
                            dataList.addAll(brokerWaitConfirmData.data);
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                    @Override
                    public void onAfter(@Nullable String s, @Nullable Exception e) {
                        super.onAfter(s, e);

                    }
                });

//        ClientManager.getInstance().getBrokerWait().compose(RxSchedulers.<BrokerWaitConfirmData>io_main()).subscribe(new ApiSubscriber<BrokerWaitConfirmData>(getActivity()) {
//            @Override
//            protected void _onNext(BrokerWaitConfirmData brokerWaitConfirmData) {
//
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
    }

    @Override
    public void onClick(View v) {

    }

    int curPage;
    int totalPage;
    private void loadNextData() {
        OkHttpUtils.get(HttpAdress.waitConfirm)
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
                            BrokerWaitConfirmData brokerWaitConfirmData = JsonUtil.jsonToEntity(data, BrokerWaitConfirmData.class);
                            dataList.addAll(brokerWaitConfirmData.data);
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
