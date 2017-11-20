package com.example.lenovo.myapplication.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/11/17.
 */

public class ZhiboAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    private ArrayList<String> titlist;

    public ZhiboAdapter(FragmentManager fm, ArrayList<Fragment> list,ArrayList<String> titlist) {
        super(fm);
        this.list=list;
        this.titlist=titlist;
    }



    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titlist.get(position);
    }
}
