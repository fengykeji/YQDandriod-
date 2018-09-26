package com.ccsoft.yunqudao.ui.Guide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.ui.home.HomeActivity;
import com.ccsoft.yunqudao.ui.mian.LoginActivity;
import com.ccsoft.yunqudao.utils.SpUtil;

/**
 * @author: Pein
 * @data: 2018/5/14 0014
 */

public class GuideFragment5 extends Fragment implements View.OnClickListener {

    private View           mView;
    private GuideFragment5 mGuideFragment5;
    private Button         mGuide_next;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.guide5_welcome, container, false);
        mGuide_next = mView.findViewById(R.id.guide_next);
        mGuide_next.setOnClickListener(this);
        mGuideFragment5 = new GuideFragment5();
        return mView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.guide_next:
                LoginActivity.start(getActivity());
                SpUtil.setBoolean(AppConstants.SP.IS_SHOW_GUIDE,true);
                getActivity().finish();
        }
    }
}
