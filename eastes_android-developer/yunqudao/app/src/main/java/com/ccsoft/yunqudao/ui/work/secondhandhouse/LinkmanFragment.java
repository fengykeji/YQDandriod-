package com.ccsoft.yunqudao.ui.work.secondhandhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.ui.work.WorkRecommendComplainFragment;

public class LinkmanFragment extends Fragment implements View.OnClickListener{

    private View mView;
    private TextView tv_chakanquanbu,tv_chakanquanbu2;
    private LinearLayout ll_addlianxiren;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_linkman, container, false);
        initView();
        initListener();
//        initData();
        return mView;
    }

    private void initView(){
        tv_chakanquanbu = mView.findViewById(R.id.tv_chakanquanbu);
        tv_chakanquanbu2 = mView.findViewById(R.id.tv_chakanquanbu2);
        ll_addlianxiren = mView.findViewById(R.id.ll_addlianxiren);
    }

    private void initListener(){
        tv_chakanquanbu.setOnClickListener(this);
        tv_chakanquanbu2.setOnClickListener(this);
        ll_addlianxiren.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_chakanquanbu:
                Intent intent = new Intent(getContext(),YeZhuInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_chakanquanbu2:
                Intent intent1 = new Intent(getContext(),YeZhuInfoActivity.class);
                startActivity(intent1);
                break;
            case R.id.ll_addlianxiren:
                Intent intent2 = new Intent(getContext(),AddLianXiRenActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
