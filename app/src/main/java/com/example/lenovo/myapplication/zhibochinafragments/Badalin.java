package com.example.lenovo.myapplication.zhibochinafragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapters.ListviewAdapter_Badalin;
import com.example.lenovo.myapplication.adapters.Myadapter;
import com.example.lenovo.myapplication.beans.Bakalin;
import com.example.lenovo.myapplication.eventbus.Mes;
import com.example.lenovo.myapplication.presenter.Ipresenter;
import com.example.lenovo.myapplication.view.Iview;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Lenovo on 2017/11/9.
 */

public class Badalin extends Fragment implements Iview<Bakalin> {

    private ListView lv_listview;
    private Ipresenter ipresenter;
    private String sy;
    private List<Bakalin.LiveBean> list = new ArrayList<>();
    private Myadapter myadapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        EventBus.getDefault().register(this);

        View inflate = inflater.inflate(R.layout.listview, container, false);
        lv_listview = inflate.findViewById(R.id.lv_listview);
        myadapter = new Myadapter(getContext(), list, R.layout.jincaiitem);
        lv_listview.setAdapter(myadapter);

        return inflate;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)

    public void get(Mes s) {
        sy = s.getSy();
        ipresenter = new Ipresenter(this);
        ipresenter.getData(sy, null);

    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);


    }

    @Override
    public void succeed(Bakalin T) {
        List<Bakalin.LiveBean> live = T.getLive();
        list.addAll(live);
        myadapter.notifyDataSetChanged();

    }

    @Override
    public void faile(Throwable e) {

    }
}
