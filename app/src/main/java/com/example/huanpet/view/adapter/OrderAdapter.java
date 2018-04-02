package com.example.huanpet.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dell on 2018/3/30.
 */

public class OrderAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public OrderAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String []name ={"全部","待确定","寄养中","待评价"};
        return name[position];
    }
}
