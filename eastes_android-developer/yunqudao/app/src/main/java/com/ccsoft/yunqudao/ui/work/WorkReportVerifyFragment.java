package com.ccsoft.yunqudao.ui.work;

import android.content.Intent;
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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.data.model.response.BrokerWaitConfirmData;
import com.ccsoft.yunqudao.data.model.response.ClientPrivateData;
import com.ccsoft.yunqudao.data.model.response.RecordAffirmBaseData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.adapter.OnCallListener;
import com.ccsoft.yunqudao.ui.adapter.WorkReportVerifyAdapter;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LogUtil;
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

/**
 * @author: Pein
 * @data: 2018/5/14 0014
 */

public class WorkReportVerifyFragment extends Fragment implements View.OnClickListener{

    private View                     mView;
    private WorkReportVerifyFragment mWorkReportVerifyFragment;
    private RecyclerView             mWork_recyclerview_verify;
    private WorkReportVerifyAdapter  workReportVerifyAdapter;
    private List<RecordAffirmBaseData.DataBean> dataList = new ArrayList<>();
    private SwipeRefreshLayout mSwipRefresh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_work_baobeikehu_dqr, container, false);
        mWorkReportVerifyFragment = new WorkReportVerifyFragment();
        initView();
        initListener();
        initData();
        return mView;
    }

    /**
     * 请求数据
     */
    private void initData() {
        ClientManager.getInstance().getRecordAffirm().compose(RxSchedulers.<RecordAffirmBaseData>io_main()).subscribe(new ApiSubscriber<RecordAffirmBaseData>(getActivity()) {

            @Override
            protected void _onNext(RecordAffirmBaseData recordAffirmBaseData) {
                curPage = 2;
                totalPage = recordAffirmBaseData.last_page;
                dataList.clear();
                dataList.addAll(recordAffirmBaseData.data);
                workReportVerifyAdapter.notifyDataSetChanged();
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

    /**
     * 初始化id
     */
    private void initView() {
        mSwipRefresh = mView.findViewById(R.id.mSwipRefresh);
        this.mWork_recyclerview_verify = mView.findViewById(R.id.work_recyclerview_verify);
        workReportVerifyAdapter = new WorkReportVerifyAdapter(getContext(),R.layout.item_work_report, dataList);
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
                RecordAffirmBaseData.DataBean data = dataList.get(position);
                int client_id = data.client_id;
                Intent  intent = new Intent(getActivity(),WorkReportVerifyActivity.class);
                intent.putExtra("id",client_id);
                getActivity().startActivity(intent);
            }
        });
        mSwipRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });

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
                            dataList.addAll(brokerWaitConfirmData.data);
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

}
