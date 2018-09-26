package com.ccsoft.yunqudao.ui.me;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GetCompanyListBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.model.ClientListModel;
import com.ccsoft.yunqudao.ui.adapter.ChooseCompanyAdapter;
import com.ccsoft.yunqudao.ui.adapter.GongSiRenZhengLiBiaoAdapter;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.lzy.okhttputils.request.GetRequest;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/3 0003
 */

public class GongSiRenZhengActivity extends AppCompatActivity implements View.OnClickListener ,OnRefreshListener {

    private ImageButton    me_button_返回;
    private ImageView me_button_relativelayout_搜索;
    private Spinner        me_spinner_省份;
    private Spinner        me_spinner_城市;
    private Spinner        me_spinner_区域;
    private RecyclerView   me_recyclerview_公司列表;
    private GongSiRenZhengLiBiaoAdapter adapter;
    private List<GetCompanyListBean.DataBeanX.DataBean> dataList = new ArrayList<>();
    private GetCompanyListBean bean;
    private int chongxin = 0;
    private int bId = 0;
    private AnimationDrawable anim;
    private ImageView yunsuan;
    private SmartRefreshLayout mCustomers_swiperefreshlayout;
    private String search;
    private GetRequest getRequest;
    private EditText et_search;
//    private ChooseCompanyAdapter adapter;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_xuanzegongsi);
        HideIMEUtil.wrap(this);
        initView();
        initData();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, GongSiRenZhengActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         * 初始化id
         */
        et_search = findViewById(R.id.et_search);
        me_button_返回 = findViewById(R.id.me_button_返回);

        me_button_relativelayout_搜索 = findViewById(R.id.me_button_relativelayout_搜索);

        me_spinner_省份 = findViewById(R.id.me_spinner_省份);

        me_spinner_城市 = findViewById(R.id.me_spinner_城市);

        me_spinner_区域 = findViewById(R.id.me_spinner_区域);

        me_recyclerview_公司列表 = findViewById(R.id.me_recyclerview_公司列表);

        this.mCustomers_swiperefreshlayout = findViewById(R.id.customers_swiperefreshlayout);
        yunsuan = findViewById(R.id.yunsuan);
        yunsuan.setImageResource(R.drawable.animation_refresh);
        anim = (AnimationDrawable) yunsuan.getDrawable();

            chongxin = getIntent().getIntExtra("chongxin",0);
            bId = getIntent().getIntExtra("bId", 0);



        me_recyclerview_公司列表.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GongSiRenZhengLiBiaoAdapter(this,R.layout.item_me_renzheng,dataList);
//        adapter = new ChooseCompanyAdapter(this,dataList);
        me_recyclerview_公司列表.setAdapter(adapter);
        me_recyclerview_公司列表.addOnScrollListener(endlessRecyclerOnScrollListener);

        adapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {

                Intent intent = new Intent(GongSiRenZhengActivity.this,GongSiXiangQiangActivity.class);
                intent.putExtra("companyname",dataList.get(position).getCompany_name());
                intent.putExtra("address",dataList.get(position).getAbsolute_address());
                intent.putExtra("tel",dataList.get(position).getContact_tel()+"");
                intent.putExtra("name",dataList.get(position).getContact());
                intent.putExtra("comment",dataList.get(position).getComment());
                intent.putExtra("imgurl",dataList.get(position).getLogo());
                intent.putExtra("companyid",dataList.get(position).getCompany_id());
                intent.putExtra("chongxin",chongxin);
                intent.putExtra("bId", bId);
                startActivity(intent);
                finish();
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
                initData();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

//
    }

    private void initData(){

        getRequest = OkHttpUtils.get(HttpAdress.getCompanyList);
        if (search != null) {
            getRequest.params("company_name", search);
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
                        if(code == 200 && data!=null){
                            bean = JsonUtil.jsonToEntity(s,GetCompanyListBean.class);
                            dataList.clear();
                            dataList.addAll(bean.getData().getData());
                            curPage = 2;
                            totalPage = bean.getData().getLast_page();
                            adapter.notifyDataSetChanged();

                        }
                    }
                });
    }

    int curPage;
    int totalPage;

    private void loadNextData() {
        GetRequest getRequest = OkHttpUtils.get(HttpAdress.getCompanyList)
                .tag(this)
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
                    GetCompanyListBean bean = JsonUtil.jsonToEntity(s, GetCompanyListBean.class);
                    dataList.addAll(bean.getData().getData());
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

    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener() {
        @Override
        public void onLoadNextPage(View view) {
            if (adapter.footerHolder == null || adapter.footerHolder.getmState() == FooterHolder.KEY_LOADING) {
                return;
            }
            if (curPage <= totalPage) {
                adapter.footerHolder.setData(FooterHolder.KEY_LOADING);
                loadNextData();
            } else {
                adapter.footerHolder.setData(FooterHolder.KEY_END);
            }

        }
    };

    private void initListener() {
        /**
         * 初始化监听器
         */
        me_button_返回.setOnClickListener(this);
        me_button_relativelayout_搜索.setOnClickListener(this);
        this.mCustomers_swiperefreshlayout.setOnRefreshListener(this);
    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.me_button_返回:
                finish();
                break;
            case R.id.me_button_relativelayout_搜索:
                break;
        }
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        initData();
        anim.start();
        mCustomers_swiperefreshlayout.finishRefresh(900);
    }
}
