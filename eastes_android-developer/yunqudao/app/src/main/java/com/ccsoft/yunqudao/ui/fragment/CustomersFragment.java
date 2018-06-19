package com.ccsoft.yunqudao.ui.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.data.model.response.ClientListData;
import com.ccsoft.yunqudao.data.model.viewmodel.CustomerListViewModel;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.model.ClientListModel;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.adapter.CustomersRecyclerAdapter;
import com.ccsoft.yunqudao.ui.customers.AddCustomers1Activity;
import com.ccsoft.yunqudao.ui.customers.CustomersXiangQingActivity;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LogUtil;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewAdapter;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewHolder;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.lzy.okhttputils.request.GetRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/2 0002
 */

public class CustomersFragment extends Fragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    /**
     * 客源页面id
     */
    private View mView;

    @BindView(R.id.spinner_need)
    Spinner mSpinner_need;

    @BindView(R.id.spinner_price)
    Spinner mSpinner_price;

    @BindView(R.id.spinner_intent)
    Spinner mSpinner_intent;

    @BindView(R.id.spinner_more)
    Spinner mSpinner_more;

    private ImageButton mButton_add_customers;
    private SwipeRefreshLayout mCustomers_swiperefreshlayout;
    private RecyclerView mCustomers_recyclerview;
    private LinearLayoutManager mLinearLayoutManager;
    private CustomersRecyclerAdapter mAdapter;


    private List<CustomerListViewModel> mViewModels = new ArrayList<>();
    private List<ClientListModel.Data> dataList = new ArrayList<>();

    private String search;
    private EditText et_search;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * 填充布局
         */
        regiestBroadCast();

        mView = inflater.inflate(R.layout.fragment_customers, container, false);
        initView();
        initListener();
        iniData();
        return mView;
    }


    /**
     * 初始化id
     */
    private void initView() {
        et_search = mView.findViewById(R.id.et_search);
        this.mButton_add_customers = mView.findViewById(R.id.customers_button_add_customers);
        this.mCustomers_swiperefreshlayout = mView.findViewById(R.id.customers_swiperefreshlayout);
        this.mCustomers_recyclerview = mView.findViewById(R.id.customers_recyclerview);
        mCustomers_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new CustomersRecyclerAdapter(getContext(), R.layout.item_activity_customers, dataList);
        mCustomers_recyclerview.setAdapter(mAdapter);
        mCustomers_recyclerview.addOnScrollListener(endlessRecyclerOnScrollListener);
    }

    /**
     * 初始化监听器
     */
    private void initListener() {

        this.mButton_add_customers.setOnClickListener(this);
        this.mCustomers_swiperefreshlayout.setOnRefreshListener(this);
        this.mAdapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                ClientListModel.Data viewModel = dataList.get(position);//每一条item的数据
//                CustomersXiangQingActivity.start(getActivity(), viewModel.getClient_id());//拿id查数据
                Intent intent = new Intent(getContext(),CustomersXiangQingActivity.class);
                intent.putExtra("client_id",viewModel.getClient_id());
                startActivity(intent);
            }
        });
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(TextUtils.isEmpty(s)){
                    search = null;
                }else{
                    search = s.toString();
                }
                getData();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    /**
     * 请求数据
     */
    private void iniData() {
        getData();
    }

    public void getData() {
        mCustomers_swiperefreshlayout.setRefreshing(true);
        GetRequest getRequest = OkHttpUtils.get(HttpAdress.clientList)
                .tag(getActivity())
                .params("page", 1);

        if (search != null) {
            getRequest.params("search", search);
        }

        getRequest.execute(new StringCallback() {
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
                    ClientListModel clientListModel = JsonUtil.jsonToEntity(data, ClientListModel.class);
                    totalPage = clientListModel.getLast_page();
                    curPage = 2;
                    dataList.clear();
                    dataList.addAll(clientListModel.getData());
                    mAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onAfter(@Nullable String s, @Nullable Exception e) {
                super.onAfter(s, e);
                mCustomers_swiperefreshlayout.setRefreshing(false);
            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.customers_button_add_customers:
                AddCustomers1Activity.start(getActivity());
                break;
        }
    }

    public static void start(Context context) {

        Intent intent = new Intent(context, CustomersFragment.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        getData();
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


    int curPage;
    int totalPage;

    private void loadNextData() {
        GetRequest getRequest = OkHttpUtils.get(HttpAdress.clientList)
                .tag(getActivity())
                .params("page", curPage);

        if (search != null) {
            getRequest.params("search", search);
        }
        getRequest.execute(new StringCallback() {
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
                    ClientListModel clientListModel = JsonUtil.jsonToEntity(data, ClientListModel.class);
                    dataList.addAll(clientListModel.getData());
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

    private void regiestBroadCast(){
        IntentFilter intentFilter = new IntentFilter(AppConstants.REFRESH_CUSTOM_LIST);
        getActivity().registerReceiver(new MyReceiver(),intentFilter);
    }



    private class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            getData();
        }
    }


}
