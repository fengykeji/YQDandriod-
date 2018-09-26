package com.ccsoft.yunqudao.ui.me;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GetCompanyProjectBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.GetCompanyProjectAdapter;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.ui.mian.LoginActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.lzy.okhttputils.request.GetRequest;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class XuanZheXiangMuActivity extends AppCompatActivity implements OnRefreshListener {

    private RecyclerView house_recyclerview_list;
    private AnimationDrawable anim;
    private ImageView yunsuan;
    private int companyId  = 0;
    private SmartRefreshLayout mCustomers_swiperefreshlayout;
    private GetCompanyProjectBean houseListBeans ;
    private GetCompanyProjectAdapter adapter;
    private List<GetCompanyProjectBean.DataBeanX.DataBean> list = new ArrayList<>();
    private ImageButton work_button_back;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_xuanzhexiangmu);
        HideIMEUtil.wrap(this);//键盘管理，点击除editText外区域收起键盘
        initView();
        initlistener();
        initData();
    }
    private void initView(){
        companyId = getIntent().getIntExtra("company_id",0);
        house_recyclerview_list = findViewById(R.id.rv_list);
        this.mCustomers_swiperefreshlayout = findViewById(R.id.customers_swiperefreshlayout);
        work_button_back =findViewById(R.id.work_button_back);
        yunsuan = findViewById(R.id.yunsuan);
        yunsuan.setImageResource(R.drawable.animation_refresh);
        anim = (AnimationDrawable) yunsuan.getDrawable();

        house_recyclerview_list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GetCompanyProjectAdapter(this,R.layout.house_list_activity, list);
        house_recyclerview_list.setAdapter(adapter);
        house_recyclerview_list.addOnScrollListener(endlessRecyclerOnScrollListener);

        work_button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    private void initData(){

        OkHttpUtils.get(AppConstants.URL+"agent/personal/getCompanyProject")
                .params("company_id",companyId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        houseListBeans = JsonUtil.jsonToEntity(s,GetCompanyProjectBean.class);
                        if(houseListBeans.getCode() == 200){
                            totalPage = houseListBeans.getData().getLast_page();
                            curPage = 2;
                            list.clear();
                            list.addAll(houseListBeans.getData().getData()) ;
                            adapter.notifyDataSetChanged();
                        }
                        else if(houseListBeans.getCode() == 401){
                            Intent intent = new Intent(XuanZheXiangMuActivity.this, LoginActivity.class);
                            startActivity(intent);
                            Toast.makeText(XuanZheXiangMuActivity.this,"token失效，请重新登陆",Toast.LENGTH_SHORT).show();
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

    int curPage;
    int totalPage=100;

    private void loadNextData() {
        GetRequest getRequest = OkHttpUtils.get(HttpAdress.HOUSELIST)
                .tag(this)
                .params("page", curPage);


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
                    houseListBeans = JsonUtil.jsonToEntity(s,GetCompanyProjectBean.class);
                    list.addAll(houseListBeans.getData().getData());
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
    private void initlistener(){
        this.mCustomers_swiperefreshlayout.setOnRefreshListener(this);
        adapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
//                Intent intent = new Intent(XuanZheXiangMuActivity.this,GongSiRenZheng1Activity.class);
//                intent.putExtra("project_id",list.get(position).getProject_id());
//                startActivity(intent);
                EventBus.getDefault().post(new SendMessage(list.get(position).getProject_id(),list.get(position).getProject_name()));
                finish();
            }
        });
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        initData();
        anim.start();
        mCustomers_swiperefreshlayout.finishRefresh(900);
    }
}
