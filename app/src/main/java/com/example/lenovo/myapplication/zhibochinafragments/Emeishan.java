package com.example.lenovo.myapplication.zhibochinafragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class Emeishan extends Fragment implements Iview<com.example.lenovo.myapplication.beans.Emeishan>{
    private Ipresenter ipresenter;
    private String sy;
    private  List<com.example.lenovo.myapplication.beans.Emeishan.LiveBean>  list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        EventBus.getDefault().register(this);

        return null;
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
    public void succeed(com.example.lenovo.myapplication.beans.Emeishan T) {
        List<com.example.lenovo.myapplication.beans.Emeishan.LiveBean> live = T.getLive();

    }

    @Override
    public void faile(Throwable e) {

    }



}
