package com.ccsoft.yunqudao.ui.customers;

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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.QuickRecommendBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.data.model.response.OpenCityData;
import com.ccsoft.yunqudao.data.model.response.QuickRecommendData;
import com.ccsoft.yunqudao.data.model.response.ResultData;
import com.ccsoft.yunqudao.data.model.viewmodel.QuickRecommendViewModel;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.model.ClientListModel;
import com.ccsoft.yunqudao.ui.adapter.QuickRecommendAdapter;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.ui.work.AddWorkActivity;
import com.ccsoft.yunqudao.ui.work.WrokCommendDisableDetailsActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LogUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.ccsoft.yunqudao.utils.SpUtil;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewAdapter;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.lzy.okhttputils.request.GetRequest;
import com.yyydjk.library.DropDownMenu;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/25 0025
 */

public class QuickRecommendActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton    mCustomers_button_back;
    private RelativeLayout mQuick_recommend_search;
    private Button         mCustomers_quick_recommend;
    private RecyclerView   mQuick_recommend_list;
    private List<QuickRecommendViewModel> dataList = new ArrayList<>();
    private QuickRecommendAdapter mAdapter;
    private int                   mId;
    private int                   id;
    private int                   mClienId;
    private SwipeRefreshLayout mSwipRefresh;
    private QuickRecommendBean quickRecommendBean;
    private String  mName,mCustomers_tel,mCustomers_id,mCustomers_barthday,mCustomers_address;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_quick_recommend);
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
        mAdapter = new QuickRecommendAdapter(this,R.layout.item_activity_house_type2, dataList);
        mQuick_recommend_list.setAdapter(mAdapter);

        mName = getIntent().getStringExtra("name");
        mCustomers_tel = getIntent().getStringExtra("tel");
        mCustomers_id = getIntent().getStringExtra("id");
        mCustomers_barthday = getIntent().getStringExtra("barthday");
        mCustomers_address  = getIntent().getStringExtra("address");


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
        mAdapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                    if(id!=0&&mClienId!=0) {
                        QuickRecommendViewModel data = dataList.get(position);
                        int project_id = data.project_id;
                        Map<String, String> map = new HashMap<>();
                        map.put("project_id", String.valueOf(project_id));
                        map.put("client_need_id", String.valueOf(id));
                        map.put("client_id", String.valueOf(mClienId));
                        XutilsHttp.getInstance().postheader(AppConstants.URL + "agent/client/recommend", map, new XutilsHttp.XCallBack() {
                            @Override
                            public void onResponse(String result) {
                                Gson gson = new Gson();
                                ResultData resultData = gson.fromJson(result, ResultData.class);
                                if (resultData.code == 200) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(QuickRecommendActivity.this);
                                    builder.setTitle("推荐成功");
                                    builder.setMessage(resultData.msg);
                                    builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            finish();
                                        }
                                    });
                                    AlertDialog dialog = builder.create();
                                    dialog.show();


                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(QuickRecommendActivity.this);
                                    builder.setTitle("推荐失败");
                                    builder.setMessage(resultData.msg);
                                    builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                        }
                                    });
                                    AlertDialog dialog = builder.create();
                                    dialog.show();
                                }
                            }

                            @Override
                            public void error(String message) {
                                Log.d("666666------》", message);
                            }
                        });
                    }else if(id==0&&mClienId==0) {
                        Intent intent = new Intent(QuickRecommendActivity.this,AddWorkActivity.class);
                        intent.putExtra("project_name",dataList.get(position).project_name);
                        intent.putExtra("project_id",dataList.get(position).project_id);

                        intent.putExtra("name",mName);
                        intent.putExtra("tel",mCustomers_tel);
                        intent.putExtra("id",mCustomers_id);
                        intent.putExtra("barthday",mCustomers_barthday);
                        intent.putExtra("address",mCustomers_address);
                        startActivity(intent);
                    }
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

        OkHttpManager.getInstance().get(AppConstants.URL + "user/project/list" + city, new BaseCallBack() {
            @Override
            public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {
                Type type = new TypeToken<QuickRecommendBean>() {}.getType();
                quickRecommendBean = new Gson().fromJson(obj.toString(),type);
            }

            @Override
            public void onFailure(Call call, Exception e) {

            }

            @Override
            public void onError(Response response, int errorCode) {

            }

            @Override
            public void onRequestBefore() {

            }
        });


        int agent_id = SpUtil.getInt("agent_id", 0);
        Map<String, String> params = new HashMap();
        params.put("page", String.valueOf(curPage));
        params.put("agent_id", String.valueOf(agent_id));
        params.put("city", city);
        XutilsHttp.getInstance().gethesder(AppConstants.URL + "user/project/list", params, new XutilsHttp.XCallBack() {
            @Override
            public void onResponse(String result) {
                mSwipRefresh.setRefreshing(false);
                QuickRecommendData recommendData = JsonUtil.jsonToEntity(result, QuickRecommendData.class);
                if(recommendData.code==200){
                    if(curPage==1){
                        dataList.clear();
                    }

//                    for(int i =0 ;i<recommendData.data.size();i++){
//                        data  = recommendData.data.get(i);
//
                    for (QuickRecommendData.QuickData data : recommendData.data) {
                        if(data.property_tags!=null) {
                            QuickRecommendViewModel viewModel = new QuickRecommendViewModel();

                            viewModel.img_url = data.img_url;
                            viewModel.absolute_address = data.absolute_address;
                            viewModel.brokerSortCompare = data.brokerSortCompare;
                            viewModel.deposit = data.deposit;
                            viewModel.city = data.city;
                            viewModel.cycle = data.cycle;
                            viewModel.guarantee_brokerage = data.guarantee_brokerage;
                            viewModel.sort = data.sort;
                            viewModel.sale_state = data.sale_state;
                            viewModel.province = data.province;
                            viewModel.district = data.district;
                            viewModel.project_id = data.project_id;
                            viewModel.project_name = data.project_name;
                            viewModel.project_tags = data.project_tags;
                            viewModel.property_tags = new ArrayList<>();
                            viewModel.property_tags = data.property_tags;
                            dataList.add(viewModel);
                        }
                    }
                    mAdapter.notifyDataSetChanged();
                    QuickRecommendActivity.this.curPage++;
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
            if (mAdapter.footerHolder == null || mAdapter.footerHolder.getmState() == FooterHolder.KEY_LOADING) {
                return;
            }
            if (curPage < totalPage) {
                mAdapter.footerHolder.setData(FooterHolder.KEY_LOADING);
                initData(city,curPage);
            } else {
                mAdapter.footerHolder.setData(FooterHolder.KEY_END);
            }

        }
    };



}
