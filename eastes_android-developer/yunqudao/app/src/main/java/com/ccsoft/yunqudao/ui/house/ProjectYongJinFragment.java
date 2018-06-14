package com.ccsoft.yunqudao.ui.house;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ccsoft.yunqudao.R;

/**
 * @author: Pein
 * @data: 2018/5/10 0010
 */

public class ProjectYongJinFragment extends Fragment {

    private View mView;
    private ProjectYongJinFragment mProjectYongJinFragment;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_house_xiangmuxiangqing_yongjin,container,false);
        mProjectYongJinFragment = new ProjectYongJinFragment();
        return mView;

    }
}
