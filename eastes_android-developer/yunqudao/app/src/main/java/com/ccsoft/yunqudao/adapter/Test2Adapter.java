package com.ccsoft.yunqudao.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.HouseDetailBean;
import com.ccsoft.yunqudao.bean.ProjectHuXingXiangQingBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.ui.house.ProjectXiangCeActivity;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Test2Adapter extends PagerAdapter {
    private List<ProjectHuXingXiangQingBean.DataBean.ImgInfoBean.listbean> mPaths;
    private List<ProjectHuXingXiangQingBean.DataBean.ImgInfoBean> list = new ArrayList<>();

    private Context mContext;

    public Test2Adapter(Context context, List<ProjectHuXingXiangQingBean.DataBean.ImgInfoBean.listbean> paths
    ,List<ProjectHuXingXiangQingBean.DataBean.ImgInfoBean> list) {
        mContext = context;
        this.mPaths = paths;
        this.list = list;
    }



    public void change(List<ProjectHuXingXiangQingBean.DataBean.ImgInfoBean.listbean> paths) {
        this.mPaths = paths;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mPaths.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        // TODO Auto-generated method stub
        return view == (View) obj;
    }

    @Override
    public Object instantiateItem (ViewGroup container, int position) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_xiangce_imageview,container,false);

        ImageView iv ;
        ImageView iv2 ;

        iv = view.findViewById(R.id.iv);
        iv2 = view.findViewById(R.id.iv2);

            Picasso.with(mContext).load(AppConstants.URL+mPaths.get(position).getImg_url())
                    .fit()
                    .error(R.drawable.default_3)
                    .into(iv);//载入bitmap

        if(!mPaths.get(position).getImg_url_3d().equals("")){
            iv2.setVisibility(View.VISIBLE);
        }

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,ProjectXiangCeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("list1", (Serializable) list);
                mContext.startActivity(intent);
            }
        });
        ((ViewPager)container).addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem (ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }


}
