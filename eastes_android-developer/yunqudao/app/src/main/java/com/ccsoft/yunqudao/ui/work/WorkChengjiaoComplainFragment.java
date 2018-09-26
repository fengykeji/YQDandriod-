package com.ccsoft.yunqudao.ui.work;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.adapter.WorkComplainAdapter;
import com.ccsoft.yunqudao.bean.AppealBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.data.model.response.RecordValidData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
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

public class WorkChengjiaoComplainFragment extends Fragment implements View.OnClickListener ,OnRefreshListener {
    private View                       mView;
    private WorkReportComplainFragment mWorkReportComplainFragment;
    private RecyclerView mWork_recyclerview_complain;
    private AppealBean appealBean;
    private List<AppealBean.DataBeanX.DataBean> datalist = new ArrayList<>();
    private SmartRefreshLayout mSwipRefresh;
    private WorkComplainAdapter adapter;
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

        mView = inflater.inflate(R.layout.fragment_work_baobeikehu_ss, container, false);
        mWorkReportComplainFragment = new WorkReportComplainFragment();
        initView();
        initListener();
        initData();
        return mView;
    }

    /**
     * 初始化id
     */
    private void initView() {
        this.mWork_recyclerview_complain = mView.findViewById(R.id.work_recyclerview_complain);
        mSwipRefresh = mView.findViewById(R.id.mSwipRefresh);
        yunsuan = mView.findViewById(R.id.yunsuan);
        yunsuan.setImageResource(R.drawable.animation_refresh);
        anim = (AnimationDrawable) yunsuan.getDrawable();
        mWork_recyclerview_complain.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter = new WorkComplainAdapter(getContext(),R.layout.item_work_complain,datalist);
        mWork_recyclerview_complain.setAdapter(adapter);
        mWork_recyclerview_complain.addOnScrollListener(endlessRecyclerOnScrollListener);

    }

    /**
     * 初始化监听器
     */
    private void initListener() {
        adapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                Intent intent = new Intent(getContext(), WorkComplainListActivity.class);
                intent.putExtra("appeal_id", datalist.get(position).getAppeal_id() + "");
                intent.putExtra("gone", "show");
                startActivity(intent);
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
    private void loadNextData(){
        OkHttpUtils.get(HttpAdress.DEALAPPEALAINLIST)
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
                            AppealBean bean = JsonUtil.jsonToEntity(s,AppealBean.class);
                                datalist.addAll(bean.getData().getData());
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

    private void initData(){


        OkHttpUtils.get(HttpAdress.DEALAPPEALAINLIST)
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
                            AppealBean bean = JsonUtil.jsonToEntity(s,AppealBean.class);
                            curPage = 2;
                            totalPage = bean.getData().getLast_page();
                            datalist.clear();
                            datalist.addAll(bean.getData().getData());
                            adapter.notifyDataSetChanged();
//                            mSwipRefresh.setRefreshing(false);
                        }
                    }
                });



    }

    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener() {
        @Override
        public void onLoadNextPage(View view) {
            if (adapter.footerHolder == null || adapter.footerHolder.getmState() == FooterHolder.KEY_LOADING) {
                return;
            }
            if (curPage < totalPage) {
                adapter.footerHolder.setData(FooterHolder.KEY_LOADING);
                loadNextData();
            } else {
                adapter.footerHolder.setData(FooterHolder.KEY_END);
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
