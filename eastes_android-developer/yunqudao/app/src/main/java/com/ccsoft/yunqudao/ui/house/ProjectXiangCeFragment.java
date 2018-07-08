package com.ccsoft.yunqudao.ui.house;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.adapter.Test3Adapter;
import com.ccsoft.yunqudao.bean.ProjectImgGetBean;

import java.util.ArrayList;
import java.util.List;

public class ProjectXiangCeFragment extends Fragment{
    private View view;
    private ViewPager im_viewPager;
    private List<ProjectImgGetBean.DataBeanX.DataBean> mlist = new ArrayList<>();
    private Test3Adapter madapter;
    private List<String> Imgurl = new ArrayList<>();
    private TextView mHouse_text_效果图;
    private TextView    mHouse_text_全部图;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.project_item_tupian, container, false);

        Bundle bundle = this.getArguments();
        ArrayList<ProjectImgGetBean.DataBeanX> list = (ArrayList<ProjectImgGetBean.DataBeanX>) bundle.getSerializable("list");
        ArrayList<ProjectImgGetBean.DataBeanX.DataBean> dataList = (ArrayList<ProjectImgGetBean.DataBeanX.DataBean>) bundle.getSerializable("lists");

        madapter = new Test3Adapter(getContext(),dataList);

        im_viewPager = view.findViewById(R.id.im_viewPager);
        mHouse_text_效果图 = view.findViewById(R.id.house_text_效果图);
        mHouse_text_全部图 = view.findViewById(R.id.house_text_全部图);
        int s = list.get(0).getData().size()-1;
        mHouse_text_效果图.setText(list.get(0).getName()+1+"/"+
                s);
        im_viewPager.setAdapter(madapter);
        im_viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


                position = position+1;
                    mHouse_text_效果图.setText(list.get(0).getName()+position+"/"+
                    s);


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

}
