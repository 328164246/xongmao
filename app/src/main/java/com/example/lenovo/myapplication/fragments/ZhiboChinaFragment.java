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

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapters.Shouye_Adapter;
import com.example.lenovo.myapplication.beans.ZhiboChina;
import com.example.lenovo.myapplication.concat.Concat;
import com.example.lenovo.myapplication.eventbus.Mes;
import com.example.lenovo.myapplication.presenter.Ipresenter;
import com.example.lenovo.myapplication.utils.VolleyUtils;
import com.example.lenovo.myapplication.view.Iview;
import com.example.lenovo.myapplication.zhibochinafragments.Badalin;
import com.example.lenovo.myapplication.zhibochinafragments.Emeishan;
import com.example.lenovo.myapplication.zhibochinafragments.Fenthuangguchen;
import com.example.lenovo.myapplication.zhibochinafragments.Huangshan;
import com.example.lenovo.myapplication.zhibochinafragments.Jincai;
import com.example.lenovo.myapplication.zhibochinafragments.Taishan;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Lenovo on 2017/11/3.
 */

public class ZhiboChinaFragment extends Fragment implements Iview<ZhiboChina> {

    private TabLayout zhibo_tab;
    private ViewPager zhibo_vp;
    private List<ZhiboChina.TablistBean> tablist;
    private String order;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Ipresenter ipresenter = new Ipresenter(this);
        ipresenter.getData(Concat.ZHIBOCHINA_URL, null);
        View inflate = inflater.inflate(R.layout.zhibochinaview, container, false);
        zhibo_tab = inflate.findViewById(R.id.zhibo_tab);
        zhibo_vp = inflate.findViewById(R.id.zhibo_vp);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new Jincai());
        list.add(new Badalin());
        list.add(new Taishan());
        list.add(new Huangshan());
        list.add(new Fenthuangguchen());
        list.add(new Emeishan());
        zhibo_tab.addTab(zhibo_tab.newTab());
        zhibo_tab.addTab(zhibo_tab.newTab());
        zhibo_tab.addTab(zhibo_tab.newTab());
        zhibo_tab.addTab(zhibo_tab.newTab());
        zhibo_tab.addTab(zhibo_tab.newTab());
        zhibo_tab.addTab(zhibo_tab.newTab());
        Shouye_Adapter shouye_adapter = new Shouye_Adapter(getFragmentManager(), list);
        zhibo_vp.setAdapter(shouye_adapter);
        zhibo_tab.setupWithViewPager(zhibo_vp);
        return inflate;
    }

    @Override
    public void succeed(ZhiboChina T) {
        tablist = T.getTablist();
        for (int i = 0; i < tablist.size(); i++) {
            zhibo_tab.getTabAt(i).setText(tablist.get(i).getTitle());



        }

        String url2 = tablist.get(2).getUrl();
        String url3= tablist.get(3).getUrl();
        String url4 = tablist.get(4).getUrl();
        String url5 = tablist.get(5).getUrl();
        zhibo_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        String url1 = tablist.get(1).getUrl();
                        EventBus.getDefault().post(new Mes(url1));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });





        EventBus.getDefault().post(new Mes(url2));
        EventBus.getDefault().post(new Mes(url3));
        EventBus.getDefault().post(new Mes(url4));
        EventBus.getDefault().post(new Mes(url5));

   }

    @Override
    public void faile(Throwable e) {
        Log.e("TAG",e.toString());
    }
}
