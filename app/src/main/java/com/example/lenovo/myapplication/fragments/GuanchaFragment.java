package com.example.lenovo.myapplication.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapters.GuanchaAdapter;
import com.example.lenovo.myapplication.beans.Guancha;
import com.example.lenovo.myapplication.beans.TotalGuancha;
import com.example.lenovo.myapplication.concat.Concat;
import com.example.lenovo.myapplication.presenter.Ipresenter;
import com.example.lenovo.myapplication.utils.VolleyUtils;
import com.example.lenovo.myapplication.view.ClickVideoActivity;
import com.example.lenovo.myapplication.view.Iview;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/11/3.
 */

public class GuanchaFragment extends Fragment implements Iview<Guancha> {

    private ListView guancha_lv;
    private List<Guancha.ListBean> guanchalist = new ArrayList<>();
    private GuanchaAdapter guanchaAdapter;
    private ImageView guancha_header_img;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //网络请求
        Ipresenter ipresenter = new Ipresenter(this);
        ipresenter.getData(Concat.GUANCHAPANADA, null);
        //添加布局
        View inflate = inflater.inflate(R.layout.guanchaitem, container, false);
        guancha_header_img = inflate.findViewById(R.id.guancha_header_img);//网络请求
        VolleyUtils.getInstance(getContext()).get(Concat.TOTALTITLE, new Response.Listener<String>() {
            @Override


            public void onResponse(String response) {
                String s = response.toString();
                TotalGuancha totalGuancha = new Gson().fromJson(s, TotalGuancha.class);
                String image = totalGuancha.getTab().get(1).getImage();
                Glide.with(getContext()).load(image).into(guancha_header_img);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.toString());
            }
        });
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
        guancha_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String guid = guanchalist.get(i).getGuid();
                Intent intent = new Intent(getActivity(), ClickVideoActivity.class);
                intent.putExtra("id", guid);
                startActivity(intent);
            }
        });
    }


    @Override
    public void faile(Throwable e) {
        Log.e("TAG", e.toString());
    }
}
