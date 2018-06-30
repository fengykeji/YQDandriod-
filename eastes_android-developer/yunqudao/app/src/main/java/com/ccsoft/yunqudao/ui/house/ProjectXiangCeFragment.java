package com.ccsoft.yunqudao.ui.house;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.adapter.Test2Adapter;
import com.ccsoft.yunqudao.adapter.Test3Adapter;
import com.ccsoft.yunqudao.bean.ProjectHuXingXiangQingBean;
import com.ccsoft.yunqudao.bean.ProjectImgGetBean;

import java.util.ArrayList;
import java.util.List;

public class ProjectXiangCeFragment extends Fragment{
    private View view;
    private ViewPager im_viewPager;
    private List<ProjectImgGetBean.DataBeanX.DataBean> mlist = new ArrayList<>();
    private Test3Adapter madapter;
    private List<String> Imgurl = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.project_item_tupian, container, false);

        Bundle bundle = this.getArguments();
        List<ProjectImgGetBean.DataBeanX.DataBean> list = (List<ProjectImgGetBean.DataBeanX.DataBean>) bundle.getSerializable("list");


        madapter = new Test3Adapter(getContext(),list);

        im_viewPager = view.findViewById(R.id.im_viewPager);
        im_viewPager.setAdapter(madapter);
        return view;
    }

}
