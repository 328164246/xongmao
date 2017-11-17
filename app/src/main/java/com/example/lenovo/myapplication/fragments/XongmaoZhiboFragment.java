package com.example.lenovo.myapplication.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapters.ZhiboAdapter;
import com.example.lenovo.myapplication.zhibochinafragments.Zhibo;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/11/3.
 */

public class XongmaoZhiboFragment extends Fragment {

    private ViewPager zhiboxunmao_vp;
    private TabLayout zhiboxunmao_tab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.zhiboxunmao, container, false);
        zhiboxunmao_tab = inflate.findViewById(R.id.zhiboxunmao_tab);
        zhiboxunmao_vp = inflate.findViewById(R.id.zhiboxunmao_vp);
        ArrayList<Fragment> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Zhibo());
        }
        for (int i = 0; i < 10; i++) {
            zhiboxunmao_tab.addTab(zhiboxunmao_tab.newTab());
        }

        ZhiboAdapter zhiboAdapter = new ZhiboAdapter(getFragmentManager(),list);
        zhiboxunmao_vp.setAdapter(zhiboAdapter);
        zhiboxunmao_tab.setupWithViewPager(zhiboxunmao_vp);
        for (int i = 0; i < 10; i++) {
            zhiboxunmao_tab.getTabAt(i).setText(i+"1");
        }




        return inflate;
    }
}
