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
import com.ccsoft.yunqudao.bean.ProjectHuXingXiangQingBean;
import com.ccsoft.yunqudao.bean.ProjectImgGetBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.ui.house.ProjectXiangCeActivity;
import com.ccsoft.yunqudao.ui.house.ProjectXiangCeVebViewActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class Test3Adapter extends PagerAdapter {
    private List<String> mPaths;
    private List<String> mPaths1;

    private Context mContext;

    public Test3Adapter(Context context, List<String> paths) {
        mContext = context;
        this.mPaths = paths;
    }

    public Test3Adapter(Context context, List<String> paths ,List<String> mPaths1) {
        mContext = context;
        this.mPaths = paths;
        this.mPaths1 = mPaths1;
    }



    public void change(List<String> paths) {
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

        PhotoView iv = new PhotoView(mContext);
        iv.setEnabled(true);
            Picasso.with(mContext).load(AppConstants.URL+mPaths.get(position))
                    .error(R.drawable.default_3)
                    .into(iv);//载入bitmap

        if(mPaths1!=null) {
            iv.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
                @Override
                public void onPhotoTap(View view, float x, float y) {

                    if (!mPaths1.get(position).equals("")) {
                        Intent intent = new Intent(mContext, ProjectXiangCeVebViewActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("url", mPaths1.get(position));
                        mContext.startActivity(intent);
                    }
                }

                @Override
                public void onOutsidePhotoTap() {

                }

            });
        }
        ((ViewPager)container).addView(iv, 0);
        return iv;
    }

    @Override
    public void destroyItem (ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }


}
