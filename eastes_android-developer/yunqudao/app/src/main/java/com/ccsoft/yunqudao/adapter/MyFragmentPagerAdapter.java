package com.ccsoft.yunqudao.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.ccsoft.yunqudao.R;

import java.util.ArrayList;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> list;//需要显示的fragment在构造器中传入
    private ArrayList<String> mTitles;


    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> list, ArrayList<String> mTitles) {

        super(fm);

        this.list = list;
        this.mTitles = mTitles;

    }

    //返回显示的Fragment总数
    @Override

    public int getCount() {

        return list.size();

    }

    //返回要显示的Fragment的某个实例
    @Override

    public Fragment getItem(int arg0) {

        return list.get(arg0);

    }

    //返回一个自定义tab视图（用于自定义Tablayout标签，不自定义可忽略）v

//返回每个Tab的标题，当要自定义Tab的时候不应该重写该方法
@Override

public CharSequence getPageTitle(int position) {

  return mTitles.get(position);
}

}
