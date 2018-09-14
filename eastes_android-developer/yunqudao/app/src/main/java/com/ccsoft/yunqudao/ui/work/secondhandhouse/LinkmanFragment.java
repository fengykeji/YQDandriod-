package com.ccsoft.yunqudao.ui.work.secondhandhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ProspectFinishBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.LinkManAdapter;
import com.ccsoft.yunqudao.ui.work.WorkRecommendComplainFragment;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class LinkmanFragment extends Fragment implements View.OnClickListener{

    private View mView;
    private TextView tv_chakanquanbu,tv_chakanquanbu2;
    private LinearLayout ll_addlianxiren;
    private RecyclerView recyclerview;
    private LinkManAdapter adapter;
    private List<ProspectFinishBean.DataBean.ContactBean> datalist = new ArrayList<>();
    private int house_id;

    @Override
    public void onStart() {
        super.onStart();
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_linkman, container, false);
        initView();
        initListener();
        initData();
        return mView;
    }

    private void initView(){
        house_id = getActivity().getIntent().getIntExtra("house_id",0);

        tv_chakanquanbu = mView.findViewById(R.id.tv_chakanquanbu);
        tv_chakanquanbu2 = mView.findViewById(R.id.tv_chakanquanbu2);
        ll_addlianxiren = mView.findViewById(R.id.ll_addlianxiren);
        recyclerview = mView.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new LinkManAdapter(getContext(),R.layout.item_linkman,datalist);
        recyclerview.setAdapter(adapter);
    }

    private void initListener(){
        tv_chakanquanbu.setOnClickListener(this);
        tv_chakanquanbu2.setOnClickListener(this);
        ll_addlianxiren.setOnClickListener(this);
    }


    private void initData(){
        OkHttpUtils.get(HttpAdress.houseSurveyDetail)
                .tag(this)
                .params("house_id",house_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        ProspectFinishBean bean = JsonUtil.jsonToEntity(s,ProspectFinishBean.class);
                        if(bean.getCode() == 200){
                            datalist.clear();
                            datalist.addAll(bean.getData().getContact());
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_chakanquanbu:
                Intent intent = new Intent(getContext(),YeZhuInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_chakanquanbu2:
                Intent intent1 = new Intent(getContext(),YeZhuInfoActivity.class);
                startActivity(intent1);
                break;
            case R.id.ll_addlianxiren:
                Intent intent2 = new Intent(getContext(),AddLianXiRenActivity.class);
                intent2.putExtra("house_id",house_id);
                startActivity(intent2);
                break;
        }
    }
}
