package com.ccsoft.yunqudao.adapter;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import java.io.FileNotFoundException;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.HouseDetailBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.ui.house.ProjectXiangCeActivity;
import com.squareup.picasso.Picasso;

public class TestAdapter extends PagerAdapter {
    private List<HouseDetailBean.DataBean.ProjectImgBean.UrlBean> mPaths;

    private Context mContext;
    private int project_id;

    public TestAdapter(Context cx,List<HouseDetailBean.DataBean.ProjectImgBean.UrlBean> paths,
                       int project_id) {
        mContext = cx.getApplicationContext();
        this.mPaths = paths;
        this.project_id = project_id;
    }



    public void change(List<HouseDetailBean.DataBean.ProjectImgBean.UrlBean> paths) {
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
                    .fit()
                    .error(R.drawable.default_2)
                    .into(iv);//载入bitmap

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,ProjectXiangCeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("project_id",project_id);
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
