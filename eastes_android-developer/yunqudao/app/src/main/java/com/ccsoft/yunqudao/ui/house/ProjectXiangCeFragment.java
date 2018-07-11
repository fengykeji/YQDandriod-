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
import com.ccsoft.yunqudao.bean.MessageEvent;
import com.ccsoft.yunqudao.bean.ProjectImgGetBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
    private ArrayList<ProjectImgGetBean.DataBeanX> list = new ArrayList<>();
    private int position = 0;






    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.project_item_tupian, container, false);

        Bundle bundle = this.getArguments();

        list = (ArrayList<ProjectImgGetBean.DataBeanX>) bundle.getSerializable("list");
//        ArrayList<ProjectImgGetBean.DataBeanX.DataBean> dataList = (ArrayList<ProjectImgGetBean.DataBeanX.DataBean>) bundle.getSerializable("list");

        for (ProjectImgGetBean.DataBeanX dataBeanX : list) {
           mlist.addAll(dataBeanX.getData()) ;
        }
        madapter = new Test3Adapter(getContext(),mlist);

        im_viewPager = view.findViewById(R.id.im_viewPager);

        im_viewPager.setAdapter(madapter);
        im_viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                EventBus.getDefault().post(new EvenBusSendPosition(position+1+""));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

}
