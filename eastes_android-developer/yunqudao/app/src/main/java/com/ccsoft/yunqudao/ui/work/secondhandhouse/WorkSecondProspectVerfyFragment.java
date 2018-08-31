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
import com.ccsoft.yunqudao.bean.SurveyWaitConfirm;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.data.model.response.BrrokerValueData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.adapter.WorkRecommendValidAdapter;
import com.ccsoft.yunqudao.ui.adapter.WorkSecondProspectVerfyAdapter;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.ui.work.WorkRecommendValidFragment;
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

public class WorkSecondProspectVerfyFragment extends Fragment implements View.OnClickListener , OnRefreshListener {

    private View mView;
    private WorkRecommendValidFragment mWorkRecommendValidFragment;
    private RecyclerView mWork_recyclerview_Valid;
    private SmartRefreshLayout mSwipRefresh;
    private WorkSecondProspectVerfyAdapter mAdapter;

    private List<SurveyWaitConfirm.DataBean> dataList = new ArrayList<>();
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

        mView = inflater.inflate(R.layout.fragment_work_second_propect_dqr, container, false);
        mWorkRecommendValidFragment = new WorkRecommendValidFragment();
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
        this.mWork_recyclerview_Valid = mView.findViewById(R.id.work_recyclerview_valid);
        mWork_recyclerview_Valid.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new WorkSecondProspectVerfyAdapter(getContext(),R.layout.item_work_value, dataList);
        mWork_recyclerview_Valid.setAdapter(mAdapter);
        mWork_recyclerview_Valid.addOnScrollListener(endlessRecyclerOnScrollListener);
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
                Intent intent = new Intent(getContext(),WorkSecondProspectVerfyDetailActivity.class);
                intent.putExtra("survey_id",dataList.get(position).getSurvey_id());
                startActivity(intent);
            }
        });
        mSwipRefresh.setOnRefreshListener(this) ;

    }

    private void initData() {

        OkHttpUtils.get(HttpAdress.surveyWaitConfirm)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        SurveyWaitConfirm bean = JsonUtil.jsonToEntity(s,SurveyWaitConfirm.class);
                        if(bean.getCode() == 200) {
                            dataList.clear();
                            dataList.addAll(bean.getData());
                            curPage = 2;
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {

    }

    int curPage;
    int totalPage;
    private void loadNextData() {
        OkHttpUtils.get(HttpAdress.surveyWaitConfirm)
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
                            SurveyWaitConfirm brokerWaitConfirmData = JsonUtil.jsonToEntity(data, SurveyWaitConfirm.class);
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
