package com.ccsoft.yunqudao.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/14 0014
 */

public class CustomersXiangQingPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;

    public CustomersXiangQingPagerAdapter(FragmentManager fragmentManager, List<Fragment> fragmentList) {
        super(fragmentManager);
        mFragmentList = fragmentList;
    }

    /**
     * 返回显示的fm
     */
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    /**
     * 获取fm个数
     */

    public int getCount() {
        return mFragmentList.size();
    }
}
