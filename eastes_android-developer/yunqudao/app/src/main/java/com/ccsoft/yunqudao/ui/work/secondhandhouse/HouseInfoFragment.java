package com.ccsoft.yunqudao.ui.work.secondhandhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;

public class HouseInfoFragment extends Fragment implements View.OnClickListener{
    private View mView;
    private TextView tv_xiangmufenxi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_houseinfo , container, false);
        initView();
        initListener();
//        initData();
        return mView;
    }

    private void initView(){
        tv_xiangmufenxi = mView.findViewById(R.id.tv_xiangmufenxi);
    }

    private void initListener(){
        tv_xiangmufenxi.setOnClickListener(this);
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
