package com.ccsoft.yunqudao.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.adapter.HouseList_RecyclerViewAdapter;
import com.ccsoft.yunqudao.bean.HouseListBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.house.ProjectXiangQingActivity;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/2 0002
 */

public class HouseFragment extends Fragment implements View.OnClickListener ,HouseList_RecyclerViewAdapter.OnItemClickListener {
    /**
     * 房源页面id
     */
    private View           mView;
    private HouseFragment mHouseFragment;
    private RelativeLayout mHouse_button_relativelayout搜索;
    private RecyclerView   recyclerView;
    private String area = "510100";
    private HouseListBean houseListBeans ;
    private HouseList_RecyclerViewAdapter adapter;
    private OkHttpManager okHttpManager = OkHttpManager.getInstance();
    private List list;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * 填充布局
         */
        mView = inflater.inflate(R.layout.fragment_house, container, false);

        mHouseFragment = new HouseFragment();
        Fresco.initialize(getContext());
        this.initView();
        this.initListener();
        loadFangyuanList();
        return mView;
    }

    private void initView() {
        /**
         * 初始化控件
         */
        this.mHouse_button_relativelayout搜索 = mView.findViewById(R.id.house_button_relativelayout搜索);
        recyclerView = mView.findViewById(R.id.house_recyclerview_list);
    }

    private void initListener() {

        this.mHouse_button_relativelayout搜索.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.house_button_relativelayout搜索:
                Toast.makeText(getActivity(), "你点击了搜索", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void loadFangyuanList(){
        OkHttpManager.getInstance().get(HttpAdress.HOUSELIST, new BaseCallBack() {
            @Override
            public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {

                Type type = new TypeToken<HouseListBean>() {}.getType();
                houseListBeans = new Gson().fromJson(obj.toString(),type);
                Log.e("houseListBeans",houseListBeans.getMsg());

                list = houseListBeans.getData();
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter = new HouseList_RecyclerViewAdapter(getContext(), list);
                recyclerView.setAdapter(adapter);
                adapter.setOnItemClickListener( HouseFragment.this);
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

    }

    @Override
    public void setItemClick(View view, int position) {
        Intent intent = new Intent(getContext(),ProjectXiangQingActivity.class);
        intent.putExtra("project_id",houseListBeans.getData().get(position).getProject_id());
        startActivity(intent);
    }
}
