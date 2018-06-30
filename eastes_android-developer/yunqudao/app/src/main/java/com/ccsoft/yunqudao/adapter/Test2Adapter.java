package com.ccsoft.yunqudao.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.HouseDetailBean;
import com.ccsoft.yunqudao.bean.ProjectHuXingXiangQingBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.ui.house.ProjectXiangCeActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Test2Adapter extends PagerAdapter {
    private List<ProjectHuXingXiangQingBean.DataBean.ImgInfoBean.listbean> mPaths;

    private Context mContext;

    public Test2Adapter(Context context, List<ProjectHuXingXiangQingBean.DataBean.ImgInfoBean.listbean> paths) {
        mContext = context;
        this.mPaths = paths;
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

        ImageView iv = new ImageView(mContext);
            Picasso.with(mContext).load(AppConstants.URL+mPaths.get(position).getImg_url())
                    .error(R.drawable.ic_launcher_background)
                    .into(iv);//载入bitmap

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,ProjectXiangCeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
        ((ViewPager)container).addView(iv, 0);
        return iv;
    }

    @Override
    public void destroyItem (ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }


}
