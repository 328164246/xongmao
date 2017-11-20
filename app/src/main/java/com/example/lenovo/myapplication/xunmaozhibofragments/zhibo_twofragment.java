package com.example.lenovo.myapplication.xunmaozhibofragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapters.ZhibofuAdapter;
import com.example.lenovo.myapplication.beans.zhibojincai;
import com.example.lenovo.myapplication.utils.VolleyUtils;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Lenovo on 2017/11/19.
 */

public class zhibo_twofragment extends Fragment {


    private ListView lv_zhibotwofragment;
    private int num = 1;
    private String id;

    public zhibo_twofragment(String id) {
        this.id = id;
    }

    //http://api.cntv.cn/video/videolistById?vsid=VSET100167216881&n=7&serviceId=panda&o=desc&of=time&p=2
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.zhibotwofragmentitem, container, false);
        lv_zhibotwofragment = inflate.findViewById(R.id.lv_zhibotwofragment);
        String str = "http://api.cntv.cn/video/videolistById?vsid=" + id + "&n=7&serviceId=panda&o=desc&of=time&p=" + num;
        VolleyUtils.getInstance(getContext()).get(str, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String s = response.toString();
                zhibojincai zhibojincai = new Gson().fromJson(s, zhibojincai.class);
                List<com.example.lenovo.myapplication.beans.zhibojincai.VideoBean> video = zhibojincai.getVideo();

                ZhibofuAdapter zhibofuAdapter = new ZhibofuAdapter(getContext(), video, R.layout.item_eight);
                lv_zhibotwofragment.setAdapter(zhibofuAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        return inflate;
    }
}
