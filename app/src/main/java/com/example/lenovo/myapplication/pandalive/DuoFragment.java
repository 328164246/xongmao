package com.example.lenovo.myapplication.pandalive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapters.DuoAdapter;
import com.example.lenovo.myapplication.baseadapter.CommonAdapter;
import com.example.lenovo.myapplication.beans.Duo;
import com.example.lenovo.myapplication.utils.VolleyUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/11/20.
 */

public class DuoFragment extends Fragment {
    private String url;
    private RecyclerView rcv_duoitem;
   private List<Duo.ListBean> duolist=new ArrayList<>();
    public DuoFragment(String url) {
        this.url = url;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.duoitem, container, false);


        VolleyUtils.getInstance(getContext()).get(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String s = response.toString();
                Duo duo = new Gson().fromJson(s, Duo.class);
                List<Duo.ListBean> list = duo.getList();
                DuoAdapter duoAdapter = new DuoAdapter(list,getContext());
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                rcv_duoitem.setLayoutManager(staggeredGridLayoutManager);
                rcv_duoitem.setAdapter(duoAdapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        initView(inflate);
        return inflate;

    }

    private void initView(View inflate) {
        rcv_duoitem = (RecyclerView) inflate.findViewById(R.id.rcv_duoitem);
    }
}
