package com.ccsoft.yunqudao.ui.work.duijierentuijian;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ButterWaitConfirmbean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.data.model.response.BrokerWaitConfirmData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.WorkDuiJieRecommendVerifyAdapter;
import com.ccsoft.yunqudao.ui.adapter.WorkRecommendVerifyAdapter;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.ui.work.WorkCommendVerifyDetailActivity;
import com.ccsoft.yunqudao.ui.work.WorkRecommendVerifyFragment;
import com.ccsoft.yunqudao.utils.ItemsDialogFragment;
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

public class WorkDuiJieRecommendVerifyFragment extends Fragment implements View.OnClickListener ,OnRefreshListener {


    private View mView;
    private WorkRecommendVerifyFragment mWorkRecommendVerifyFragment;
    private RecyclerView mWork_recyclerview_verify;
    private WorkDuiJieRecommendVerifyAdapter mAdapter;
    private SmartRefreshLayout mSwipRefresh;
    private List<ButterWaitConfirmbean.DataBeanX.DataBean> dataList = new ArrayList<>();
    private AnimationDrawable anim;
    private ImageView yunsuan;
    private FragmentManager fragmentManager;
    private int project_id, client_id;
    private String client_name,client_tel;

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
        fragmentManager = getFragmentManager();
        mWork_recyclerview_verify.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new WorkDuiJieRecommendVerifyAdapter(getActivity(), R.layout.item_work_duijie_recom, dataList);
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
                client_id = dataList.get(position).getClient_id();

                project_id = dataList.get(position).getProject_id();
                client_name = dataList.get(position).getName();
                 client_tel = dataList.get(position).getTel();
//                WorkDuiJieCommendVerifyDetailActivity.start(getActivity(), id);
                Intent intent = new Intent(getContext(),WorkDuiJieCommendVerifyDetailActivity.class);
                intent.putExtra("project_id",project_id);
                intent.putExtra("client_name",client_name);
                intent.putExtra("client_tel",client_tel);
                intent.putExtra("client_id",client_id);
                startActivity(intent);

                TextView textView = v.findViewById(R.id.tv_sure);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showItemsDialogFragment();
                    }
                });
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
        OkHttpUtils.get(HttpAdress.butterWaitConfirm)
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
                            ButterWaitConfirmbean.DataBeanX brokerWaitConfirmData = JsonUtil.jsonToEntity(data1, ButterWaitConfirmbean.DataBeanX.class);
                            totalPage = brokerWaitConfirmData.getLast_page();
                            curPage = 2;
                            dataList.clear();
                            dataList.addAll(brokerWaitConfirmData.getData());
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
        OkHttpUtils.get(HttpAdress.butterWaitConfirm)
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
                            ButterWaitConfirmbean.DataBeanX brokerWaitConfirmData = JsonUtil.jsonToEntity(data, ButterWaitConfirmbean.DataBeanX.class);
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

    public void showItemsDialogFragment() {
        ItemsDialogFragment itemsDialogFragment = new ItemsDialogFragment();
        String[] items = {"已到访", "未到访","取消" };
        itemsDialogFragment.show("", items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        Intent intent = new Intent(getContext(),DuiJieQueRenActivity.class);
                        intent.putExtra("project_id",project_id);
                        intent.putExtra("client_name",client_name);
                        intent.putExtra("client_tel",client_tel);
                        intent.putExtra("client_id",client_id);
                        intent.putExtra("daofangid",3);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getContext(),WeiDaoFangActivity.class);
                        intent1.putExtra("client_id",client_id);
                        intent1.putExtra("daofangid",4);
                        startActivity(intent1);
                        break;
                    case 2:
                        itemsDialogFragment.dismiss();
                        break;

                }
            }
        }, getFragmentManager());
    }


}
