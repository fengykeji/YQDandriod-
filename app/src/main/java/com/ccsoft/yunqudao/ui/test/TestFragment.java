package com.ccsoft.yunqudao.ui.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ccsoft.yunqudao.R;

/**
 * @author: Pein
 * @data: 2018/5/14 0014
 */

public class TestFragment extends Fragment implements View.OnClickListener {

    private View         mView;
    private TestFragment mTestFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.textlayout, container, false);
        mTestFragment = new TestFragment();
        initView();
        initListener();
        return mView;
    }

    /**
     * 初始化id
     */
    private void initView() {

    }

    /**
     * 初始化监听器
     */
    private void initListener() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}
