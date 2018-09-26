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
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ProspectFinishBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class HouseInfoFragment extends Fragment implements View.OnClickListener{
    private View mView;
    private TextView tv_xiangmufenxi,tv_maidian,tv_zhuangxiu;
    private RecyclerView recyclerview;
    private List<ProspectFinishBean.DataBean.InfoBean> datalist = new ArrayList<>();

    private int house_id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_houseinfo , container, false);
        initView();
        initListener();
        initData();
        return mView;
    }

    private void initView(){
        house_id = getActivity().getIntent().getIntExtra("house_id",0);

        tv_xiangmufenxi = mView.findViewById(R.id.tv_xiangmufenxi);
        tv_maidian = mView.findViewById(R.id.tv_maidian);
        tv_zhuangxiu = mView.findViewById(R.id.tv_zhuangxiu);
        recyclerview = mView.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerview.setLayoutManager(layoutManager);

    }

    private void initListener(){
        tv_xiangmufenxi.setOnClickListener(this);
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
                            tv_maidian.setText(bean.getData().getInfo().getCore_selling());
                            tv_zhuangxiu.setText(bean.getData().getInfo().getDecoration_standard());
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_xiangmufenxi:
                Intent intent = new Intent(getContext(),ModificatyProjectFenXiActivity.class);
                startActivity(intent);
                break;
        }
    }
}
