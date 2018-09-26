package com.ccsoft.yunqudao.ui.house.secondhandhouse;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.SecondHouseListBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.SecondHouseListAdapter;
import com.ccsoft.yunqudao.ui.home.HomeActivity;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.ui.mian.LoginActivity;
import com.ccsoft.yunqudao.utils.ItemsDialogFragment;
import com.ccsoft.yunqudao.utils.JsonUtil;
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

import okhttp3.Call;
import okhttp3.Response;

public class SecondHouseListActivity extends Fragment implements View.OnClickListener,OnRefreshListener {

    private View                     mView;
    private TextView house_text_housetype;
    private TextView tv_xiaoqufangyuan;
    private SmartRefreshLayout mCustomers_swiperefreshlayout;
    private RecyclerView house_recyclerview_list;
    private GetRequest getRequest;
    private String city_code = "510100";
    private String search;
    private EditText et_search;
    private AnimationDrawable anim;
    private ImageView yunsuan;
    private SecondHouseListBean bean;
    private List<SecondHouseListBean.DataBeanX.DataBean> datalist = new ArrayList<>();
    private SecondHouseListAdapter adapter;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SDKInitializer.initialize(getContext().getApplicationContext());
        mView = inflater.inflate(R.layout.activity_xiaoquhouse, container, false);
        initView();
        initData();
        initListener();
        return mView;
    }

    private void initView(){

        if( getActivity().getIntent().getStringExtra("city_name")!=null) {
            city_code = getActivity().getIntent().getStringExtra("city_code");
        }
        this.mCustomers_swiperefreshlayout = mView.findViewById(R.id.customers_swiperefreshlayout);
        house_text_housetype = mView.findViewById(R.id.house_text_housetype);
        house_recyclerview_list = mView.findViewById(R.id.rv_list);
        et_search = mView.findViewById(R.id.et_search);
        tv_xiaoqufangyuan = mView.findViewById(R.id.tv_xiaoqu_resource);
        yunsuan = mView.findViewById(R.id.yunsuan);
        yunsuan.setImageResource(R.drawable.animation_refresh);
        anim = (AnimationDrawable) yunsuan.getDrawable();

        house_recyclerview_list.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new SecondHouseListAdapter(getContext(),R.layout.activityseconghouselist,datalist);
        house_recyclerview_list.setAdapter(adapter);
        house_recyclerview_list.addOnScrollListener(endlessRecyclerOnScrollListener);
    }

    private void initListener(){
        this.mCustomers_swiperefreshlayout.setOnRefreshListener(this);
        house_text_housetype.setOnClickListener(this);
        tv_xiaoqufangyuan.setOnClickListener(this);

        adapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                Intent intent = new Intent(getContext(),SecondHouseXiangQingActivity.class);
                intent.putExtra("house_id",bean.getData().getData().get(position).getHouse_id());
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
                initData();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initData(){
        getRequest = OkHttpUtils.get(HttpAdress.secondHouseList)
                .tag(this)
                .params("city",city_code)
                .params("page", 1);

        if (search != null) {
            getRequest.params("search_content", search);
        }
        getRequest.execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                 bean = JsonUtil.jsonToEntity(s,SecondHouseListBean.class);
                if(bean.getCode() == 200){
                    totalPage = bean.getData().getData().size();
                    curPage = 2;
                    datalist.clear();
                    datalist.addAll(bean.getData().getData()) ;
                    adapter.notifyDataSetChanged();
                }
                else if(bean.getCode() == 401){
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(getContext(),"token失效，请重新登陆",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.house_text_housetype:
                showItemsDialogFragment();
                break;
            case R.id.tv_xiaoqu_resource:
                Intent intent = new Intent(getContext(),XiaoQuhouseActivity.class);
                intent.putExtra("city_code",city_code);
                startActivity(intent);
                break;
        }
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
        GetRequest getRequest = OkHttpUtils.get(HttpAdress.secondHouseList)
                .tag(this)
                .params("page", curPage);

        if (search != null) {
            getRequest.params("search_content", search);
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
                    SecondHouseListBean bean = JsonUtil.jsonToEntity(s,SecondHouseListBean.class);
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

    public void showItemsDialogFragment() {
        ItemsDialogFragment itemsDialogFragment = new ItemsDialogFragment();
        String[] items = {"新房", "二手房","租房","取消" };
        itemsDialogFragment.show("", items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        Intent intent1 = new Intent(getContext(), HomeActivity.class);
                        intent1.putExtra("fid",1);
                        startActivity(intent1);

                        break;
                    case 1:
                        break;
                    case 2:

                        break;
                    case 3:
                        itemsDialogFragment.dismiss();
                        break;

                }
            }
        }, getFragmentManager());
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        initData();
        anim.start();
        mCustomers_swiperefreshlayout.finishRefresh(900);
    }
}
