package com.example.lenovo.myapplication.fragments;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapters.Shouye_Adapter;
import com.example.lenovo.myapplication.beans.ZhiboChina;
import com.example.lenovo.myapplication.concat.Concat;
import com.example.lenovo.myapplication.eventbus.Mes;
import com.example.lenovo.myapplication.presenter.Ipresenter;
import com.example.lenovo.myapplication.view.Iview;
import com.example.lenovo.myapplication.zhibochinafragments.Huangshan;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/11/3.
 */

public class ZhiboChinaFragment extends Fragment implements Iview<ZhiboChina> {

    private TabLayout zhibo_tab;
    private ViewPager zhibo_vp;
    private List<ZhiboChina.TablistBean> tablist;
    private String order;
    private String url1;
    private String url3;
    private String url0;
    private String url2;
    private String url4;
    private String url5;
    private ImageButton btn_add;
    private View inflate;
    private Button btn_quite;
    private View popwindow;
    private PopupWindow pop;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Ipresenter ipresenter = new Ipresenter(this);
        ipresenter.getData(Concat.ZHIBOCHINA_URL, null);
        inflate = inflater.inflate(R.layout.zhibochinaview, container, false);
        zhibo_tab = inflate.findViewById(R.id.zhibo_tab);
        zhibo_vp = inflate.findViewById(R.id.zhibo_vp);
        btn_add = inflate.findViewById(R.id.btn_add);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new Huangshan());
        list.add(new Huangshan());
        list.add(new Huangshan());
        list.add(new Huangshan());
        list.add(new Huangshan());
        list.add(new Huangshan());
        zhibo_tab.addTab(zhibo_tab.newTab());
        Shouye_Adapter shouye_adapter = new Shouye_Adapter(getFragmentManager(), list);
        zhibo_vp.setAdapter(shouye_adapter);
        zhibo_tab.setupWithViewPager(zhibo_vp);
        popwindow = LayoutInflater.from(getContext())
                .inflate(R.layout.pop, null);
        btn_quite = popwindow.findViewById(R.id.btn_quite);
        btn_add.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                pop = new PopupWindow(popwindow, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                pop.setBackgroundDrawable(new ColorDrawable(0x00000000));
                pop.showAtLocation(inflate, Gravity.NO_GRAVITY, 0, 0);
                btn_quite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pop.dismiss();
                    }
                });


            }
        });

        zhibo_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:

                        EventBus.getDefault().post(new Mes(url0));
                        break;
                    case 1:
                        EventBus.getDefault().post(new Mes(url1));
                        break;
                    case 2:
                        EventBus.getDefault().post(new Mes(url2));
                        break;
                    case 3:
                        EventBus.getDefault().post(new Mes(url3));
                        break;
                    case 4:
                        EventBus.getDefault().post(new Mes(url4));
                        break;
                    case 5:
                        EventBus.getDefault().post(new Mes(url5));
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

        return inflate;
    }

    @Override
    public void succeed(ZhiboChina T) {
        tablist = T.getTablist();
        for (int i = 0; i < tablist.size(); i++) {
            zhibo_tab.getTabAt(i).setText(tablist.get(i).getTitle());
        }
        url0 = tablist.get(0).getUrl();


        url1 = tablist.get(1).getUrl();
        url2 = tablist.get(2).getUrl();
        url3 = tablist.get(3).getUrl();

        url4 = tablist.get(4).getUrl();

        url5 = tablist.get(5).getUrl();
        //设置默认是显示哪个,并用还要把值传过去,fragmnet中接收值取消注册在pause里面写
        zhibo_vp.setCurrentItem(0);
        EventBus.getDefault().post(new Mes(url0));
        //为了防止隔一个切换不出来数据问题
        zhibo_vp.setOffscreenPageLimit(9);


    }

    @Override
    public void faile(Throwable e) {
        Log.e("TAG", e.toString());
    }
}
