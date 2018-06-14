package com.ccsoft.yunqudao.ui.work;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.data.model.response.BrrokerDisabledData;
import com.ccsoft.yunqudao.data.model.response.BrrokerValueData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.adapter.OnCallListener;
import com.ccsoft.yunqudao.ui.adapter.WorkRecommendDisableAdapter;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LogUtil;
import com.ccsoft.yunqudao.utils.RxPermissionUtil;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewAdapter;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewHolder;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;
import rx.functions.Action1;

/**
 * @author: Pein
 * @data: 2018/5/14 0014
 */

public class WorkRecommendDisableFragment extends Fragment implements View.OnClickListener {

    private View                         mView;
    private WorkRecommendDisableFragment mWorkRecommendDisableFragment;
    private RecyclerView                 mWork_recyclerview_disable;
    private WorkRecommendDisableAdapter  mAdapter;
    private List<BrrokerDisabledData.DisabledData> dataList = new ArrayList<>();
    private SwipeRefreshLayout mSwipRefresh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_work_tuijian_wx, container, false);
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
        mAdapter = new WorkRecommendDisableAdapter(getContext(),R.layout.item_work_value, dataList);
        mWork_recyclerview_disable.setAdapter(mAdapter);
        mWork_recyclerview_disable.addOnScrollListener(endlessRecyclerOnScrollListener);
    }

    /**
     * 初始化监听器
     */
    private void initListener() {
        mAdapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                BrrokerDisabledData.DisabledData data = dataList.get(position);
                Intent intent = new Intent(getActivity(),WrokCommendDisableDetailsActivity.class);
                intent.putExtra("id",data.client_id);
                startActivity(intent);
            }
        });
        mSwipRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });

    }

    private void initData() {
        ClientManager.getInstance().getBrokerDisabled().compose(RxSchedulers.<BrrokerDisabledData>io_main()).subscribe(new ApiSubscriber<BrrokerDisabledData>(getActivity()) {
            @Override
            protected void _onNext(BrrokerDisabledData brokerWaitConfirmData) {
                curPage = 2;
                totalPage = brokerWaitConfirmData.last_page;
                dataList.clear();
                dataList.addAll(brokerWaitConfirmData.data);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            protected void _onError(String message) {
                LogUtil.e(message);
            }

            @Override
            protected void _onCompleted() {
                mSwipRefresh.setRefreshing(false);
            }
        });
    }

    @Override
    public void onClick(View v) {
    }


    int curPage;
    int totalPage;
    private void loadNextData() {
        OkHttpUtils.get(HttpAdress.disabled)
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
                            BrrokerDisabledData brokerWaitConfirmData = JsonUtil.jsonToEntity(data, BrrokerDisabledData.class);
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
