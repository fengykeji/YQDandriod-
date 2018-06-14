package com.ccsoft.yunqudao.ui.customers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.ccsoft.yunqudao.R;

/**
 * @author: Pein
 * @data: 2018/5/14 0014
 */

public class PiPeiXinXiFragment extends Fragment implements View.OnClickListener{

    private View               mView;
    private PiPeiXinXiFragment mPiPeiXinXiFragment;
    private Button  mCustomers_button_look_all;

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
        mPiPeiXinXiFragment = new PiPeiXinXiFragment();
        initView();
        initListener();
        return mView;
    }

    /**
     *
     * 初始化id
     */
    private void initView() {

//        this.mCustomers_button_look_all = mView.findViewById(R.id.customers_button_look_all);
    }
    /**
     *
     * 初始化监听器
     */
    private void initListener() {

//        this.mCustomers_button_look_all.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

//            case R.id.customers_button_look_all:
//
//                PiPeiProjectListActivity.start(getActivity());
        }
    }
}
