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
import com.ccsoft.yunqudao.bean.ProjectHuXingXiangQingBean;

import java.util.ArrayList;
import java.util.List;

public class ProjectTuShiJingFragment extends Fragment {
    private View view;
    private ViewPager im_viewPager;
    private List<ProjectHuXingXiangQingBean.DataBean.ImgInfoBean.listbean> mlist = new ArrayList<>();
    private Test2Adapter madapter;
    private List<String> Imgurl = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.project_item_tupian, container, false);
        Bundle bundle = this.getArguments();
        List<ProjectHuXingXiangQingBean.DataBean.ImgInfoBean> list = (List<ProjectHuXingXiangQingBean.DataBean.ImgInfoBean>) bundle.getSerializable("list");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType().equals("实景图")) {
                mlist = list.get(i).getList();
            }
        }
        madapter = new Test2Adapter(getContext(), mlist);

        im_viewPager = view.findViewById(R.id.im_viewPager);
        im_viewPager.setAdapter(madapter);
        return view;
    }
}
