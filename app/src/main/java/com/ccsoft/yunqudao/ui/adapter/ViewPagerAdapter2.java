package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter2 extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private Context mContext;

    public ViewPagerAdapter2(List<Fragment> fragments, FragmentManager fm, Context context) {
        super(fm);
        this.mFragments = fragments;
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return this.mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title;
        switch (position) {
            case 0:
                title = "客户信息";
                break;
            case 1:
                title = "经办人信息";
                break;
            case 2:
                title = "房源信息";
                break;

            default:
                title = "break;";
                break;
        }
        return title;
    }
}
