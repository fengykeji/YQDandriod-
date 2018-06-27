package com.ccsoft.yunqudao.ui.work;

import android.content.Intent;
import android.graphics.Color;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.adapter.WorkComplainAdapter;
import com.ccsoft.yunqudao.bean.AppealBean;
import com.ccsoft.yunqudao.bean.AppealDetailBean;
import com.ccsoft.yunqudao.bean.HouseListBean;

import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.data.model.response.RecordValidData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.customers.AddCustomers2Activity;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/14 0014
 */

public class WorkReportComplainFragment extends Fragment implements View.OnClickListener {

    private View                       mView;
    private WorkReportComplainFragment mWorkReportComplainFragment;
    private RecyclerView               mWork_recyclerview_complain;
    private AppealBean appealBean;
    private List<AppealBean.DataBeanX.DataBean> datalist = new ArrayList<>();
    private SwipeRefreshLayout mSwipRefresh;
    private WorkComplainAdapter adapter;

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
                Intent intent = new Intent(getContext(),WorkComplainListActivity.class);
                intent.putExtra("appeal_id",datalist.get(position).getAppeal_id()+"");
                intent.putExtra("gone","zhengchang");
                startActivity(intent);
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
    private void loadNextData(){
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
//                                dataList.addAll(brokerWaitConfirmData.data);
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
//        OkHttpManager.getInstance().get(HttpAdress.DISABLE, new BaseCallBack() {
//            @Override
//            public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {
//                Type type = new TypeToken<AppealBean>() {}.getType();
//                appealBean = new Gson().fromJson(obj.toString(),type);
//                if(appealBean.getCode()==200&&appealBean.getData()!=null){
//                    datalist.clear();
//                    datalist.addAll(appealBean.getData().getData());
//                    curPage = 2;
//                    totalPage = appealBean.getData().getLast_page();
//                    adapter.notifyDataSetChanged();
//                    mSwipRefresh.setRefreshing(false);
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call call, Exception e) {
//
//            }
//
//            @Override
//            public void onError(Response response, int errorCode) {
//
//            }
//
//            @Override
//            public void onRequestBefore() {
//
//            }
//        });

        OkHttpUtils.get(HttpAdress.DISABLE)
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
                    mSwipRefresh.setRefreshing(false);
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

}
