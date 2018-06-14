package com.ccsoft.yunqudao.ui.Guide;

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

public class GuideFragment4 extends Fragment{

    private View           mView;
    private GuideFragment4 mGuideFragment4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.guide4_welcome, container, false);
        mGuideFragment4 = new GuideFragment4();
        return mView;
    }


}
