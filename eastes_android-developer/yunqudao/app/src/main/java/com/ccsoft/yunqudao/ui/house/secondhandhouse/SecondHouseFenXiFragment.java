package com.ccsoft.yunqudao.ui.house.secondhandhouse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.ui.house.ProjectFenXiFragment;

public class SecondHouseFenXiFragment extends Fragment {
    private View mView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_house_xiangmuxiangqing_fenxi, container, false);

//        this.initView();
//        this.initListener();

        return mView;
    }
}
