package com.ccsoft.yunqudao.ui.work.secondhandhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ccsoft.yunqudao.R;

public class GenJinFragment extends Fragment implements View.OnClickListener{

    private View mView;
    private LinearLayout customers_button_add_follow;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_genjin, container, false);
        initView();
        initListener();
//        initData();
        return mView;
    }

    private void initView(){
        customers_button_add_follow = mView.findViewById(R.id.customers_button_add_follow);
    }

    private void initListener(){
        customers_button_add_follow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.customers_button_add_follow:
                Intent intent = new Intent(getContext(),GenJinJiLuActivity.class);
                startActivity(intent);
                break;
        }
    }
}
