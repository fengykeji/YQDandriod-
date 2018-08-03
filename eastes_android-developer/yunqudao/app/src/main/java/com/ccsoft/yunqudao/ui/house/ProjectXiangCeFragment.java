package com.ccsoft.yunqudao.ui.house;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.adapter.Test3Adapter;
import com.ccsoft.yunqudao.bean.MessageEvent;
import com.ccsoft.yunqudao.bean.ProjectHuXingXiangQingBean;
import com.ccsoft.yunqudao.bean.ProjectImgGetBean;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class ProjectXiangCeFragment extends Fragment{
    private View view;
    private ViewPager im_viewPager;
    private List<String> mlist = new ArrayList<>();
    private List<String> mlist1 = new ArrayList<>();
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

        ProjectImgGetBean.DataBeanX dataBeanX1 = (ProjectImgGetBean.DataBeanX) bundle.getSerializable("list");

        if(dataBeanX1!=null) {

            for (ProjectImgGetBean.DataBeanX.DataBean dataBean : dataBeanX1.getData()) {

                mlist.add(dataBean.getImg_url()) ;
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
        }else {
            ProjectHuXingXiangQingBean.DataBean.ImgInfoBean infoBean = (ProjectHuXingXiangQingBean.DataBean.ImgInfoBean) bundle.getSerializable("list1");
            for (ProjectHuXingXiangQingBean.DataBean.ImgInfoBean.listbean listbean : infoBean.getList()) {
                mlist.add(listbean.getImg_url());
                if(listbean.getImg_url_3d()!=null){
                    mlist1.add(listbean.getImg_url_3d());
                }
            }

            madapter = new Test3Adapter(getContext(),mlist,mlist1);

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
        }




        return view;
    }

}
