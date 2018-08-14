package com.ccsoft.yunqudao.ui.house.secondhandhouse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.ui.house.ProjectYongJinFragment;

public class SecondHouseYongJinFragment extends Fragment {
    private View mView;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_house_xiangmuxiangqing_yongjin,container,false);
//        initView();
//        initDta();
        return mView;

    }
}
