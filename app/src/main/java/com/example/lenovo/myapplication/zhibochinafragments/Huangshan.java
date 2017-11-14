package com.example.lenovo.myapplication.zhibochinafragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapters.fu_Adapter;
import com.example.lenovo.myapplication.beans.Hangshan;
import com.example.lenovo.myapplication.eventbus.Mes;
import com.example.lenovo.myapplication.utils.VolleyUtils;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/11/9.
 */

public class Huangshan extends Fragment {


    private ListView lv_listview;

    private List<Hangshan.LiveBean> list = new ArrayList<>();
    private fu_Adapter fu_adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        View inflate = inflater.inflate(R.layout.listview, container, false);
        lv_listview = inflate.findViewById(R.id.lv_listview);
        fu_adapter = new fu_Adapter(list, getActivity());
        lv_listview.setAdapter(fu_adapter);
        return inflate;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void get(Mes s) {
        String sy = s.getSy();
        VolleyUtils.getInstance(getActivity()).get(sy, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String s1 = response.toString();
                Hangshan hangshan = new Gson().fromJson(s1, Hangshan.class);
                List<Hangshan.LiveBean> live = hangshan.getLive();
                list.addAll(live);
                fu_adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.toString());
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }
}


