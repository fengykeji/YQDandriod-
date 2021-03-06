package com.ccsoft.yunqudao.ui.house;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.adapter.Test2Adapter;
import com.ccsoft.yunqudao.bean.ProjectHuXingXiangQingBean;

import java.util.ArrayList;
import java.util.List;

public class ProjectTu3DFragment extends Fragment {
    private View view;
    private ViewPager im_viewPager;
    private List<ProjectHuXingXiangQingBean.DataBean.ImgInfoBean.listbean> mlist = new ArrayList<>();
    private Test2Adapter madapter;
    private List<String> Imgurl = new ArrayList<>();
    private ImageView imageView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.project_item_tupian, container, false);

        imageView = view.findViewById(R.id.a3D);
        Bundle bundle = this.getArguments();
        List<ProjectHuXingXiangQingBean.DataBean.ImgInfoBean> list = (List<ProjectHuXingXiangQingBean.DataBean.ImgInfoBean>) bundle.getSerializable("list");

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getType().equals("3D图")){
                mlist = list.get(i).getList();
//                imageView.setVisibility(View.VISIBLE);
            }
        }
        madapter = new Test2Adapter(getContext(),mlist,list);

        im_viewPager = view.findViewById(R.id.im_viewPager);
        im_viewPager.setAdapter(madapter);
        return view;
    }


}
