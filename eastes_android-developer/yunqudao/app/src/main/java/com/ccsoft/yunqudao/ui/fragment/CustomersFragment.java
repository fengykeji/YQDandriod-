package com.ccsoft.yunqudao.ui.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
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
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.data.base.HeadHolder;
import com.ccsoft.yunqudao.data.model.response.ClientListData;
import com.ccsoft.yunqudao.data.model.viewmodel.CustomerListViewModel;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.model.ClientListModel;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.adapter.CustomersRecyclerAdapter;
import com.ccsoft.yunqudao.ui.adapter.ScoreTeamAdapter;
import com.ccsoft.yunqudao.ui.customers.AddCustomers1Activity;
import com.ccsoft.yunqudao.ui.customers.CustomersXiangQingActivity;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.ui.mian.LoginActivity;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LogUtil;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewAdapter;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewHolder;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.lzy.okhttputils.request.GetRequest;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/2 0002
 */

public class CustomersFragment extends Fragment implements View.OnClickListener, OnRefreshListener {
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
    private SmartRefreshLayout mCustomers_swiperefreshlayout;
    private RecyclerView mCustomers_recyclerview;
    private LinearLayoutManager mLinearLayoutManager;
    private CustomersRecyclerAdapter mAdapter;

    private List<CustomerListViewModel> mViewModels = new ArrayList<>();
    private List<ClientListModel.DataBeanX.DataBean> dataList = new ArrayList<>();

    private String search;
    private EditText et_search;
    private TextView content_need;
    private int property_id;
    private TextView content_intent;
    private TextView content_more;
    private int flog = 0;
    private int  flog1 = 0 ;
    private String sort_type;
    private int sort;
    private int sort1;
    private AnimationDrawable anim;
    private ImageView yunsuan;


    @Override
    public void onStart() {
        super.onStart();
        iniData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * 填充布局
         */
        regiestBroadCast();

        mView = inflater.inflate(R.layout.fragment_customers, container, false);
        HideIMEUtil.wrap(getActivity());
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
        content_intent = mView.findViewById(R.id.content_intent);
        content_more = mView.findViewById(R.id.content_more);
        content_need = mView.findViewById(R.id.content_need);
        yunsuan = mView.findViewById(R.id.yunsuan);
        yunsuan.setImageResource(R.drawable.animation_refresh);
        anim = (AnimationDrawable) yunsuan.getDrawable();
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
        this.content_need.setOnClickListener(this);
        this.content_intent.setOnClickListener(this);
        this.content_more.setOnClickListener(this);
        this.mAdapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                ClientListModel.DataBeanX.DataBean viewModel = dataList.get(position);//每一条item的数据
//                CustomersXiangQingActivity.start(getActivity(), viewModel.getClient_id());//拿id查数据
                Intent intent = new Intent(getContext(),CustomersXiangQingActivity.class);
                intent.putExtra("client_id",viewModel.getClient_id());
                intent.putExtra("name",viewModel.getName());
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
//        mCustomers_swiperefreshlayout.setEnableRefresh(true);
        GetRequest getRequest = OkHttpUtils.get(HttpAdress.clientList)
                .tag(getActivity())
                .params("page", 1);

        if (search != null) {
            getRequest.params("search", search);
        }
        if(property_id!=0){
            getRequest.params("property_id",property_id);
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
                    ClientListModel.DataBeanX clientListModel = JsonUtil.jsonToEntity(data, ClientListModel.DataBeanX.class);
                    totalPage = clientListModel.getLast_page();
                    curPage = 2;
                    dataList.clear();
                    dataList.addAll(clientListModel.getData());
                    mAdapter.notifyDataSetChanged();
                }
                else if(code == 401){
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(getContext(),"token失效，请重新登陆",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onAfter(@Nullable String s, @Nullable Exception e) {
                super.onAfter(s, e);
//                mCustomers_swiperefreshlayout.setEnableRefresh(false);
            }
        });

    }

    public void getData1() {
//        mCustomers_swiperefreshlayout.setEnableRefresh(true);
        GetRequest getRequest = OkHttpUtils.get(HttpAdress.clientList)
                .tag(getActivity())
                .params("page", 1);

        if (search != null) {
            getRequest.params("search", search);
        }
        if(property_id!=0){
            getRequest.params("property_id",property_id);
        }

       if(sort1==1){
            getRequest.params("sort_type","urgency");
            getRequest.params("sort","asc");
        }else if(sort1 ==0) {
            getRequest.params("sort_type","urgency");
            getRequest.params("sort","desc");
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
                    ClientListModel.DataBeanX clientListModel = JsonUtil.jsonToEntity(data, ClientListModel.DataBeanX.class);
                    totalPage = clientListModel.getLast_page();
                    curPage = 2;
                    dataList.clear();
                    dataList.addAll(clientListModel.getData());
                    mAdapter.notifyDataSetChanged();
                }
                else if(code == 401){
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onAfter(@Nullable String s, @Nullable Exception e) {
                super.onAfter(s, e);
//                mCustomers_swiperefreshlayout.setEnableRefresh(false);
            }
        });

    }

    public void getData2() {
//        mCustomers_swiperefreshlayout.setEnableRefresh(true);
        GetRequest getRequest = OkHttpUtils.get(HttpAdress.clientList)
                .tag(getActivity())
                .params("page", 1);

        if (search != null) {
            getRequest.params("search", search);
        }
        if(property_id!=0){
            getRequest.params("property_id",property_id);
        }
        if(sort == 1){
            getRequest.params("sort_type","intent");
            getRequest.params("sort","asc");
        }else if(sort == 0) {
            getRequest.params("sort_type","intent");
            getRequest.params("sort","desc");
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
                    ClientListModel.DataBeanX clientListModel = JsonUtil.jsonToEntity(data, ClientListModel.DataBeanX.class);
                    totalPage = clientListModel.getLast_page();
                    curPage = 2;
                    dataList.clear();
                    dataList.addAll(clientListModel.getData());
                    mAdapter.notifyDataSetChanged();
                }
                else if(code == 401){
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(getContext(),"token失效，请重新登陆",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onAfter(@Nullable String s, @Nullable Exception e) {
                super.onAfter(s, e);
//                mCustomers_swiperefreshlayout.setEnableRefresh(false);
            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.customers_button_add_customers:
                AddCustomers1Activity.start(getActivity());
                break;
            case R.id.content_need:
                showPopupWindow();
                break;
            case R.id.content_intent:
                flog++;
                sort = flog%2;
                getData2();
                break;
            case R.id.content_more:
                flog1++;
                sort1 = flog1%2;
                getData1();
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
    public void onRefresh(RefreshLayout refreshlayout) {
        getData();
        anim.start();
        mCustomers_swiperefreshlayout.finishRefresh(900);
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
        if(property_id!=0){
            getRequest.params("property_id",property_id);
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
                    ClientListModel.DataBeanX clientListModel = JsonUtil.jsonToEntity(data, ClientListModel.DataBeanX.class);
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

    private void showPopupWindow() {
        PeizhiBean peizhiBean = MainActivity.savePeizhi();
        List<PeizhiBean.DataBean._$16Bean.ParamBeanXXXXXXXXXXXXXXX> datalist = new ArrayList<>();

        View view = LayoutInflater.from(getContext()).inflate(R.layout.popupwindow,null);
        TextView textView = view.findViewById(R.id.tv_fist);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.select);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        ScoreTeamAdapter scoreTeamAdapter = new ScoreTeamAdapter(getContext(),R.layout.item_woye_activity,peizhiBean.getData().get_$16().getParam());
        recyclerView.setAdapter(scoreTeamAdapter);
        PopupWindow popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, 600);
        popupWindow.setContentView(view);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(content_need);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content_need.setText("不限");
                 property_id = 0;
                popupWindow.dismiss();
                getData();
            }
        });

        scoreTeamAdapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                content_need.setText(peizhiBean.getData().get_$16().getParam().get(position).getParam());
                 property_id = peizhiBean.getData().get_$16().getParam().get(position).getId();
                popupWindow.dismiss();
                getData();
            }
        });
    }


}
