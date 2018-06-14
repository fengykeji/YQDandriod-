package com.ccsoft.yunqudao.ui.work;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;

/**
 * @author: Pein
 * @data: 2018/5/14 0014
 */

public class WorkRecommendComplainFragment extends Fragment implements View.OnClickListener {

    private View                          mView;
    private WorkRecommendComplainFragment mWorkXinFangTuiJianShenSuFragment;
    private RecyclerView                  mWork_recyclerview_complain;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_work_tuijian_ss, container, false);
        mWorkXinFangTuiJianShenSuFragment = new WorkRecommendComplainFragment();
        initView();
        initListener();
        return mView;
    }

    /**
     * 初始化id
     */
    private void initView() {
        this.mWork_recyclerview_complain = mView.findViewById(R.id.work_recyclerview_complain);
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
