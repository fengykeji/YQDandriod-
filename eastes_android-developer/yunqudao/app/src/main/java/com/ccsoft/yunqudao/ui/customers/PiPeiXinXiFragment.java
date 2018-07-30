package com.ccsoft.yunqudao.ui.customers;

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
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.HouseListBean;
import com.ccsoft.yunqudao.bean.PipeiBean;
import com.ccsoft.yunqudao.data.model.response.MatchData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.PipeiliebiaoAdapter;
import com.ccsoft.yunqudao.ui.adapter.QuickRecommendAdapter;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.lzy.okhttputils.request.GetRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
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

public class PiPeiXinXiFragment extends Fragment implements View.OnClickListener{

    private View               mView;
    private PiPeiXinXiFragment mPiPeiXinXiFragment;
    private RelativeLayout mCustomers_button_look_all;
    private int client_id;
    private RecyclerView customers_recyclerview_项目列表;
    private ArrayList<PipeiBean.DataBean.ListBean> dataList = new ArrayList<>();
    private PipeiBean.DataBean.ListBean data = new PipeiBean.DataBean.ListBean();
    private PipeiliebiaoAdapter adapter;
    private TextView tv_num;



    /**
     * 创建Fragment实体
     * @return
     */

    public static PiPeiXinXiFragment newInstance() {
        PiPeiXinXiFragment fragment = new PiPeiXinXiFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_customers_xiangqing_pipei, container, false);

        initView();
        initListener();
        initData();
        return mView;
    }

    /**
     *
     * 初始化id
     */
    private void initView() {
        client_id = getActivity().getIntent().getIntExtra("client_id",0);
        this.mCustomers_button_look_all = mView.findViewById(R.id.customers_button_look_all);
        customers_recyclerview_项目列表 = mView.findViewById(R.id.customers_recyclerview_项目列表);
        tv_num = mView.findViewById(R.id.tv_num);
        customers_recyclerview_项目列表.setLayoutManager(new LinearLayoutManager(getContext()));


            adapter = new PipeiliebiaoAdapter(getContext(), R.layout.activity_pipeiliebiao, dataList);

            customers_recyclerview_项目列表.setAdapter(adapter);




    }
    /**
     *
     * 初始化监听器
     */
    private void initListener() {

        this.mCustomers_button_look_all.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.customers_button_look_all:

                Intent intent = new Intent(getContext(),PiPeiProjectListActivity.class);
                intent.putExtra("client_id",client_id);
                startActivity(intent);
        }
    }

    private void initData(){


        GetRequest getRequest = OkHttpUtils.get(HttpAdress.PIPEI)
                .tag(this)
                .params("client_id", client_id);
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
                    PipeiBean matchData = JsonUtil.jsonToEntity(s, PipeiBean.class);
                    if(matchData.getData()!=null&&matchData.getData().getRecommend_project().size()==0) {
                        tv_num.setText("0");
                    } else {
                        tv_num.setText("（"+matchData.getData().getRecommend_project().size()+"）");
                        dataList.clear();
                        dataList.addAll(matchData.getData().getList());
                        adapter.notifyDataSetChanged();
                    }


                }
            }
        });

    }
}
