package com.ccsoft.yunqudao.ui.work.secondhandhouse;

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
import com.ccsoft.yunqudao.bean.DisabledListBean;
import com.ccsoft.yunqudao.bean.WaitGrabBean;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.data.model.response.BrrokerDisabledData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.adapter.DisabledListAdapter;
import com.ccsoft.yunqudao.ui.adapter.WorkRecommendDisableAdapter;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.ui.work.WorkRecommendDisableFragment;
import com.ccsoft.yunqudao.ui.work.WrokCommendDisableDetailsActivity;
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

public class WorkSecondBaoBeiDisableFragment extends Fragment implements View.OnClickListener ,OnRefreshListener {
    private View mView;
    private WorkRecommendDisableFragment mWorkRecommendDisableFragment;
    private RecyclerView mWork_recyclerview_disable;
    private DisabledListAdapter mAdapter;
    private List<DisabledListBean.DataBean> dataList = new ArrayList<>();
    private SmartRefreshLayout mSwipRefresh;
    private AnimationDrawable anim;
    private ImageView yunsuan;
    private DisabledListBean brokerWaitConfirmData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_work_second_baobei_wx, container, false);
        mWorkRecommendDisableFragment = new WorkRecommendDisableFragment();

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
        this.mWork_recyclerview_disable = mView.findViewById(R.id.work_recyclerview_disable);
        mWork_recyclerview_disable.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new DisabledListAdapter(getContext(),R.layout.item_work_value, dataList);
        mWork_recyclerview_disable.setAdapter(mAdapter);
        mWork_recyclerview_disable.addOnScrollListener(endlessRecyclerOnScrollListener);
        yunsuan = mView.findViewById(R.id.yunsuan);
        yunsuan.setImageResource(R.drawable.animation_refresh);
        anim = (AnimationDrawable) yunsuan.getDrawable();
    }

    /**
     * 初始化监听器
     */
    private void initListener() {
        mAdapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {

                Intent intent = new Intent(getActivity(),WorkSecondBaoBeiDisableDetailActivity.class);
                intent.putExtra("record_id",brokerWaitConfirmData.getData().get(position).getRecord_id());
                startActivity(intent);
            }
        });
        mSwipRefresh.setOnRefreshListener(this);


    }

    private void initData() {
        OkHttpUtils.get(HttpAdress.disabledList)
                .tag(this)
                .params("page",curPage)
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
                            brokerWaitConfirmData = JsonUtil.jsonToEntity(data1, DisabledListBean.class);

                            curPage = 2;
                            dataList.clear();
                            if(brokerWaitConfirmData.getData()!=null) {
                                dataList.addAll(brokerWaitConfirmData.getData());
                            }
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
    }


    int curPage;
    int totalPage;
    private void loadNextData() {
        OkHttpUtils.get(HttpAdress.disabledList)
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
                            curPage++;
                            DisabledListBean brokerWaitConfirmData = JsonUtil.jsonToEntity(data, DisabledListBean.class);
                            dataList.addAll(brokerWaitConfirmData.getData());
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

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        initData();
        anim.start();
        mSwipRefresh.finishRefresh(900);
    }
}
