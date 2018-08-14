package com.ccsoft.yunqudao.ui.house.secondhandhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.mapapi.SDKInitializer;
import com.ccsoft.yunqudao.R;

public class SecondHouseXiangQingFragment extends Fragment implements View.OnClickListener{

    private View                     mView;
    private TextView tv_fangyuanxinxi;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SDKInitializer.initialize(getContext().getApplicationContext());
        mView = inflater.inflate(R.layout.activity_secondhousexiangqiang, container, false);

        initView();
//        initData();
        initListener();
        return mView;
    }

    private void initView(){
        tv_fangyuanxinxi = mView.findViewById(R.id.tv_fangyuanxinxi);

    }

    private void initListener(){
        tv_fangyuanxinxi.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_fangyuanxinxi:
                Intent intent = new Intent(getContext(),SencondHouseFangYuanInfoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
