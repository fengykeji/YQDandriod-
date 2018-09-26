package com.ccsoft.yunqudao.ui.work.secondhandhouse;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GetHouseTypeDetailBean;
import com.ccsoft.yunqudao.bean.HouseListBean;
import com.ccsoft.yunqudao.bean.QuickRecommendBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.data.model.response.QuickRecommendData;
import com.ccsoft.yunqudao.data.model.response.ResultData;
import com.ccsoft.yunqudao.data.model.viewmodel.QuickRecommendViewModel;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.ui.adapter.HouseListAdapter;
import com.ccsoft.yunqudao.ui.adapter.QuickRecommendAdapter;
import com.ccsoft.yunqudao.ui.customers.OpenCityActivity;
import com.ccsoft.yunqudao.ui.customers.QuickRecommendActivity;
import com.ccsoft.yunqudao.ui.house.AdvicerChooseActivity;
import com.ccsoft.yunqudao.ui.house.ProjectLouDongXiangQingActivity;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.ui.mian.LoginActivity;
import com.ccsoft.yunqudao.ui.work.AddWorkActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.ccsoft.yunqudao.utils.SpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

public class AddBaoBeiActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton mCustomers_button_back;
    private RelativeLayout mQuick_recommend_search;
    private Button mCustomers_quick_recommend;
    private RecyclerView mQuick_recommend_list;
    private List<HouseListBean.DataBean> dataList = new ArrayList<>();
    private QuickRecommendAdapter mAdapter;
    private HouseListAdapter adapter;
    private int                   mId;
    private int                   id;
    private int                   mClienId;
    private SwipeRefreshLayout mSwipRefresh;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_quick_recommend);
        HideIMEUtil.wrap(this);
        initView();
        initListener();
    }

    public static void start(Context context, int id, int mClienId) {
        Intent intent = new Intent(context, QuickRecommendActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        bundle.putInt("mClienId", mClienId);
        intent.putExtra("data", bundle);
        context.startActivity(intent);
    }

    /**
     * 初始化id
     */
    private void initView() {
        getArgment();
        initData(city,1);
        mSwipRefresh = findViewById(R.id.mSwipRefresh);
        mCustomers_button_back = findViewById(R.id.customers_button_back);
        mQuick_recommend_search = findViewById(R.id.quick_recommend_search);
        mCustomers_quick_recommend = findViewById(R.id.customers_quick_recommend);
        mQuick_recommend_list = findViewById(R.id.quick_recommend_list);
        mQuick_recommend_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new HouseListAdapter(this,R.layout.item_activity_house_type2, dataList);
        mQuick_recommend_list.setAdapter(adapter);

    }

    private void getArgment() {
//        Bundle data = getIntent().getBundleExtra("data");
//        id = data.getInt("id");
//        mClienId = data.getInt("mClienId");

        id = getIntent().getIntExtra("id",0);
        mClienId = getIntent().getIntExtra("mClienID",0);

    }

    /**
     * 实设置监听
     */
    private void initListener() {
        mCustomers_button_back.setOnClickListener(this);
        mQuick_recommend_search.setOnClickListener(this);
        mCustomers_quick_recommend.setOnClickListener(this);
        adapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                Intent intent = new Intent(AddBaoBeiActivity.this,ProjectLouDongXiangQingActivity.class);
                intent.putExtra("project_id",dataList.get(position).getProject_id());
                Log.e("ccccc",dataList.get(position).getProject_id()+"");
                startActivity(intent);
            }
        });
        mSwipRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData(city,1);
            }
        });
    }



    /**
     * 点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customers_button_back:
                finish();
                break;
            case R.id.quick_recommend_search:
                Toast.makeText(this, "点击了搜索", Toast.LENGTH_LONG).show();
                break;
            case R.id.customers_quick_recommend:
                OpenCityActivity.start(this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            city = data.getStringExtra("city");
            initData(city,1);
        }
    }

    /**
     * 获取数据
     */

    private void initData(String city,int curPage) {//QuickRecommendData


        int agent_id = SpUtil.getInt("agent_id", 0);
        Map<String, String> params = new HashMap();
        params.put("page", String.valueOf(curPage));
        params.put("agent_id", String.valueOf(agent_id));
        params.put("city", city);
        Log.e("ccccc",city+"");
        XutilsHttp.getInstance().gethesder(AppConstants.URL + "user/project/list", params, new XutilsHttp.XCallBack() {
            @Override
            public void onResponse(String result) {
                mSwipRefresh.setRefreshing(false);
                QuickRecommendData recommendData = JsonUtil.jsonToEntity(result, QuickRecommendData.class);
                HouseListBean houseListBeans = JsonUtil.jsonToEntity(result,HouseListBean.class);
//                if(recommendData.code==200){
//                    if(curPage == 1) {
//                        dataList.clear();
//                    }
//                    for (QuickRecommendData.QuickData data : recommendData.data) {
//                        if(data.property_tags!=null) {
//                            viewModel = new QuickRecommendViewModel();
//                            viewModel.img_url = data.img_url;
//                            viewModel.absolute_address = data.absolute_address;
//                            viewModel.brokerSortCompare = data.brokerSortCompare;
//                            viewModel.deposit = data.deposit;
//                            viewModel.city = data.city;
//                            viewModel.cycle = data.cycle;
//                            viewModel.guarantee_brokerage = data.guarantee_brokerage;
//                            viewModel.sort = data.sort;
//                            viewModel.sale_state = data.sale_state;
//                            viewModel.province = data.province;
//                            viewModel.district = data.district;
//                            viewModel.project_id = data.project_id;
//                            viewModel.project_name = data.project_name;
//                            viewModel.project_tags = data.project_tags;
//                            viewModel.property_tags = new ArrayList<>();
//                            viewModel.property_tags = data.property_tags;
//                            dataList.add(viewModel);
//                        }
//                    }
//                    mAdapter.notifyDataSetChanged();
//                    AddBaoBeiActivity.this.curPage++;
//                }

                if(houseListBeans.getCode() == 200){
                    totalPage = houseListBeans.getData().size();
                    dataList.clear();
                    dataList.addAll(houseListBeans.getData()) ;
                    adapter.notifyDataSetChanged();
                }
                else if(houseListBeans.getCode() == 401){
                    Intent intent = new Intent(AddBaoBeiActivity.this, LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(AddBaoBeiActivity.this,"token失效，请重新登陆",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void error(String message) {
                mSwipRefresh.setRefreshing(false);
            }
        });
    }

    int curPage;
    int totalPage = 1;
    String city;
    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener() {
        @Override
        public void onLoadNextPage(View view) {
            if (adapter.footerHolder == null || adapter.footerHolder.getmState() == FooterHolder.KEY_LOADING) {
                return;
            }
            if (curPage < totalPage) {
                adapter.footerHolder.setData(FooterHolder.KEY_LOADING);
                initData(city,curPage);
            } else {
                adapter.footerHolder.setData(FooterHolder.KEY_END);
            }

        }
    };
}
