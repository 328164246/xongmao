package com.example.lenovo.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapters.oneadapter;
import com.example.lenovo.myapplication.beans.Bean;
import com.example.lenovo.myapplication.concat.Concat;
import com.example.lenovo.myapplication.presenter.Ipresenter;
import com.example.lenovo.myapplication.view.Iview;

/**
 * Created by Lenovo on 2017/11/5.
 */

public class ShouyeFragment extends Fragment implements Iview<Bean> {

    private RecyclerView rcv_shouye;
    private Bean.DataBean data = new Bean.DataBean();
    private com.example.lenovo.myapplication.adapters.oneadapter oneadapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Ipresenter ipresenter = new Ipresenter(this);
        ipresenter.getData(Concat.BASE_URL,null);
        View inflate = inflater.inflate(R.layout.shouye, container, false);
        rcv_shouye = inflate.findViewById(R.id.rcv_shouye);

        return inflate;
    }

    @Override
    public void succeed(Bean T) {
        data= T.getData();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        rcv_shouye.setLayoutManager(staggeredGridLayoutManager);
        oneadapter = new oneadapter(data,getActivity());
        rcv_shouye.setAdapter(oneadapter);
        oneadapter.notifyDataSetChanged();

    }

    @Override
    public void faile(Throwable e) {
        Log.e("TAG",e.toString());
    }
}
