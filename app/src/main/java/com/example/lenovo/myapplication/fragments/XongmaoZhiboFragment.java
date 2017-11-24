package com.example.lenovo.myapplication.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapters.ZhiboAdapter;
import com.example.lenovo.myapplication.beans.xongmaofragmentBean;
import com.example.lenovo.myapplication.concat.Concat;
import com.example.lenovo.myapplication.presenter.Ipresenter;
import com.example.lenovo.myapplication.view.Iview;
import com.example.lenovo.myapplication.xunmaozhibofragments.zhibo_twofragment;
import com.example.lenovo.myapplication.xunmaozhibofragments.zhibofragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Lenovo on 2017/11/3.
 */

public class XongmaoZhiboFragment extends Fragment implements Iview<xongmaofragmentBean> {

    private ViewPager vp_xongmaofragment;
    private TabLayout tl_xongmaofragment;
    private ArrayList<Fragment> list = new ArrayList<>();
    private ArrayList<String> titlist = new ArrayList<>();
    private ZhiboAdapter zhiboAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Ipresenter ipresenter = new Ipresenter(this);
        ipresenter.getData(Concat.ZHIBOPANADA, null);
        View inflate = inflater.inflate(R.layout.xongmaofragmentitem, container, false);
        tl_xongmaofragment = inflate.findViewById(R.id.tl_xongmaofragment);
        vp_xongmaofragment = inflate.findViewById(R.id.vp_xongmaofragment);
        zhiboAdapter = new ZhiboAdapter(getChildFragmentManager(), list, titlist);
        vp_xongmaofragment.setAdapter(zhiboAdapter);
        tl_xongmaofragment.setupWithViewPager(vp_xongmaofragment);

        return inflate;
    }


    @Override
    public void succeed(xongmaofragmentBean T) {
        List<xongmaofragmentBean.TablistBean> tablist = T.getTablist();
        for (int i = 0; i < tablist.size(); i++) {
            titlist.add(tablist.get(i).getTitle());
            if (i == 0) {
                list.add(new zhibofragment(tablist.get(i).getUrl()));
            } else {
                list.add(new zhibo_twofragment(tablist.get(i).getId()));
            }
        }

        zhiboAdapter.notifyDataSetChanged();


    }

    @Override
    public void faile(Throwable e) {
        Log.e("TAG", e.toString());
    }
}
