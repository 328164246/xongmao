package com.example.lenovo.myapplication.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapters.GuanchaAdapter;
import com.example.lenovo.myapplication.beans.Guancha;
import com.example.lenovo.myapplication.concat.Concat;
import com.example.lenovo.myapplication.presenter.Ipresenter;
import com.example.lenovo.myapplication.view.Iview;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/11/3.
 */

public class GuanchaFragment extends Fragment implements Iview<Guancha> {

    private FlyBanner guancha_fly;
    private ListView guancha_lv;
    private List<Guancha.ListBean> guanchalist = new ArrayList<>();
    private GuanchaAdapter guanchaAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Ipresenter ipresenter = new Ipresenter(this);
        ipresenter.getData(Concat.GUANCHAPANADA,null);
        View inflate = inflater.inflate(R.layout.guanchaitem, container, false);
        guancha_lv = inflate.findViewById(R.id.guancha_lv);
        guanchaAdapter = new GuanchaAdapter(getContext(), guanchalist, R.layout.guancha_listview_item);
        guancha_lv.setAdapter(guanchaAdapter);
        return inflate;
    }


    @Override
    public void succeed(Guancha T) {
        List<Guancha.ListBean> list = T.getList();

        guanchalist.addAll(list);
        guanchaAdapter.notifyDataSetChanged();
    }

    @Override
    public void faile(Throwable e) {
        Log.e("TAG", e.toString());
    }
}
