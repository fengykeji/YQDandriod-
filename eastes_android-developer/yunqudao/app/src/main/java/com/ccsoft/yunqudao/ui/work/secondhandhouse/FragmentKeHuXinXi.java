package com.ccsoft.yunqudao.ui.work.secondhandhouse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccsoft.yunqudao.R;

public class FragmentKeHuXinXi extends Fragment {
    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_kehuxinxi, container, false);
//        initView();
//        initListener();
//        initData();
        return mView;
    }
}
