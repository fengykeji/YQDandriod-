package com.ccsoft.yunqudao.ui.house;

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
import com.ccsoft.yunqudao.bean.AppealBean;
import com.ccsoft.yunqudao.bean.GetHouseTypeDetailBean;
import com.ccsoft.yunqudao.bean.PipeiBean;
import com.ccsoft.yunqudao.bean.ProjectFastRecommendListBean;
import com.ccsoft.yunqudao.bean.ProjectPiPeiKeHuBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.data.model.response.ResultData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.ui.adapter.ProjectFastAdapter;
import com.ccsoft.yunqudao.ui.adapter.ProjectPiPeiAdapter;
import com.ccsoft.yunqudao.ui.customers.AddCustomers1Activity;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class ProjectPiPeiKeHuActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton    mHouse_button_返回;
    private RelativeLayout mHouse_button_relativelayout搜索;
    private ImageButton    mHouse_button_添加客户;
    private Button         mHouse_button_推荐1;
    private Button         mHouse_button_推荐2;
    private Button         mHouse_button_推荐3;
    private SwipeRefreshLayout mSwipRefresh;
    private RecyclerView recyclerView;
    private ProjectPiPeiAdapter adapter;
    private ProjectFastAdapter adapter1;
    private List<ProjectPiPeiKeHuBean.DataBean> dataList = new ArrayList<>();
    private List<ProjectFastRecommendListBean.DataBeanX.DataBean> dataList1 = new ArrayList<>();
    private int project_id = 0;
    private Bundle bundle;
    private GetHouseTypeDetailBean bean;

    private int client_id;
    private int need_id;
    private String name="";
    private String tel="";
    private String project_name = "";

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_house_tuijiankehu);
        initView();
        initListener();
        initData();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ProjectPiPeiKeHuActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化
     */
    private void initView() {
        bundle = getIntent().getExtras();
        mHouse_button_添加客户 = findViewById(R.id.house_button_添加客户);
        if(bundle.size()==2) {
            dataList = (List<ProjectPiPeiKeHuBean.DataBean>) bundle.get("list");
            mHouse_button_添加客户.setVisibility(View.GONE);
        }

        project_id = (int) bundle.get("project_id");

        mSwipRefresh = findViewById(R.id.mSwipRefresh);
        mHouse_button_返回 = findViewById(R.id.house_button_返回);
        mHouse_button_relativelayout搜索 = findViewById(R.id.house_button_relativelayout搜索);
        mHouse_button_添加客户 = findViewById(R.id.house_button_添加客户);
        mHouse_button_推荐1 = findViewById(R.id.house_button_推荐1);
        mHouse_button_推荐2 = findViewById(R.id.house_button_推荐2);
        mHouse_button_推荐3 = findViewById(R.id.house_button_推荐3);
        recyclerView = findViewById(R.id.recyclerview_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProjectPiPeiAdapter(this,R.layout.item_project_pipei,dataList,project_id);

        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(endlessRecyclerOnScrollListener);

        if(bundle.size()==1) {
//            initData();

            adapter1 = new ProjectFastAdapter(this,R.layout.item_project_pipei,dataList1,project_id,dataList1);
            recyclerView.setAdapter(adapter1);
            recyclerView.addOnScrollListener(endlessRecyclerOnScrollListener);

            adapter1.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
                @Override
                public void onItemClickListner(View v, int position) {

                    need_id = dataList1.get(position).getNeed_id();
                    client_id = dataList1.get(position).getClient_id();
                    name = dataList1.get(position).getName();
                    tel = dataList1.get(position).getTel();

//                    getHouseTypeDatil();

//                    Button button = v.findViewById(R.id.house_button_推荐1);
//                    button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//
//                        }
//                    });
                }
            });
        }

    }

    /**
     * 获取置业顾问
     */
    private void getHouseTypeDatil(){
        Log.e("ccccc",project_id+"");

        OkHttpUtils.get(AppConstants.URL+"agent/project/advicer")
                .tag(this)
                .params("project_id",project_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        bean = JsonUtil.jsonToEntity(s,GetHouseTypeDetailBean.class);
                        Log.e("ccccw",bean.getCode()+"s"+bean.getMsg());
                        if (bean.getCode() == 200) {
                            if (bean.getData().getAdvicer_select() == 0) {
                                getRecommend(project_id, need_id, client_id);
                            } else if(bean.getData().getAdvicer_select() == 1){
                                showPopupwindow();
                            }else{
                                if (bean.getData().getTotal().equals("0")) {
                                    getRecommend(project_id, need_id, client_id);
                                } else {
                                    showPopupwindow();
                                }
                            }
                        }else {
                            Toast.makeText(ProjectPiPeiKeHuActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    /**
     * 选择置业顾问
     */
    private void showPopupwindow(){
        Bundle bundle = new Bundle();
        bundle.putSerializable("list", (Serializable) bean.getData().getRows());
        Intent intent = new Intent(ProjectPiPeiKeHuActivity.this, AdvicerChooseActivity.class);
        intent.putExtra("project_id",project_id);
        intent.putExtra("client_need_id",need_id);
        intent.putExtra("client_id",client_id);
        intent.putExtra("advicer_selected",bean.getData().getAdvicer_select());
        intent.putExtra("tel_complete_state",bean.getData().getTel_complete_state());
        intent.putExtra("project_name",bean.getData().getProject_name());
        intent.putExtra("name",name);
        intent.putExtra("tel",tel);
        Log.e("cccccw",name+" "+tel+" "+project_name);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    private void getRecommend(int project_id,int id,int mClienId ){
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(ProjectPiPeiKeHuActivity.this);
                    builder.setTitle("推荐成功");
                    builder.setMessage(resultData.msg);
                    builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();


                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ProjectPiPeiKeHuActivity.this);
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
    }

    /**
     * 初始化
     */
    private void initListener() {

        mHouse_button_返回.setOnClickListener(this);
        mHouse_button_relativelayout搜索.setOnClickListener(this);
        mHouse_button_添加客户.setOnClickListener(this);

        mSwipRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(bundle.size()==2) {
                    adapter = new ProjectPiPeiAdapter(ProjectPiPeiKeHuActivity.this, R.layout.item_project_pipei, dataList, project_id);
                    recyclerView.setAdapter(adapter);
                    recyclerView.addOnScrollListener(endlessRecyclerOnScrollListener);
                    mSwipRefresh.setRefreshing(false);
                }else {
                    initData();
//                    adapter1 = new ProjectFastAdapter(ProjectPiPeiKeHuActivity.this,R.layout.item_project_pipei,dataList1,project_id,dataList1);
//                    recyclerView.setAdapter(adapter1);
//                    recyclerView.addOnScrollListener(endlessRecyclerOnScrollListener);
                }
            }
        });
    }

    private void initData(){
        OkHttpUtils.get(HttpAdress.fastRecommendList)
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
//                            ProjectPiPeiKeHuBean bean = JsonUtil.jsonToEntity(s,ProjectPiPeiKeHuBean.class);
                            ProjectFastRecommendListBean bean = JsonUtil.jsonToEntity(s,ProjectFastRecommendListBean.class);
                            curPage = 2;
                            totalPage = bean.getData().getLast_page();
                            dataList1.clear();
                            dataList1.addAll(bean.getData().getData());
                            adapter1.notifyDataSetChanged();
                            mSwipRefresh.setRefreshing(false);
                        }
                    }
                });


    }

    int curPage;
    int totalPage;
    private void loadNextData(){
        OkHttpUtils.get(HttpAdress.fastRecommendList)
                .tag(this)
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
                            ProjectFastRecommendListBean bean = JsonUtil.jsonToEntity(s,ProjectFastRecommendListBean.class);
                            dataList1.addAll(bean.getData().getData());
                            adapter1.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onAfter(@Nullable String s, @Nullable Exception e) {
                        super.onAfter(s, e);
                        adapter1.footerHolder.setData(FooterHolder.KEY_NORMAL);
                    }
                });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.house_button_返回:
                finish();
                break;

            case R.id.house_button_relativelayout搜索:

                break;

            case R.id.house_button_添加客户:
                Intent intent = new Intent(this,AddCustomers1Activity.class);
                intent.putExtra("fastR","fastR");
                intent.putExtra("project_id",project_id);
                startActivity(intent);
                break;

            case R.id.house_button_推荐1:
                Toast.makeText(this, "你推荐了该项目", Toast.LENGTH_SHORT).show();
                break;
            case R.id.house_button_推荐2:
                Toast.makeText(this, "你推荐了该项目", Toast.LENGTH_SHORT).show();
                break;
            case R.id.house_button_推荐3:
                Toast.makeText(this, "你推荐了该项目", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener() {
        @Override
        public void onLoadNextPage(View view) {
            if (adapter1.footerHolder == null || adapter1.footerHolder.getmState() == FooterHolder.KEY_LOADING) {
                return;
            }
            if (curPage < totalPage) {
                adapter1.footerHolder.setData(FooterHolder.KEY_LOADING);
                loadNextData();
            } else {
                adapter1.footerHolder.setData(FooterHolder.KEY_END);
            }

        }
    };
}
