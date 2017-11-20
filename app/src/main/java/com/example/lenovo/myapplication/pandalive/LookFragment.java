package com.example.lenovo.myapplication.pandalive;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapters.BiankanAdapter;
import com.example.lenovo.myapplication.beans.Biankan;
import com.example.lenovo.myapplication.concat.Concat;
import com.example.lenovo.myapplication.utils.VolleyUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/11/20.
 */

public class LookFragment extends Fragment implements  AbsListView.OnScrollListener {


    private int num = 1;
    private ListView bian_lv1;
    private int lastindex;
    private BiankanAdapter biankanAdapter;
    private ProgressBar pb_progressbar;
    private Handler handler = new Handler();
    private List<Biankan.DataBean.ContentBean> list=new ArrayList<>();
    private View footer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.biankanitem, container, false);
        bian_lv1 = inflate.findViewById(R.id.bian_lv);
        biankanAdapter = new BiankanAdapter(getActivity(), list, R.layout.biankanlistviewitem);
        bian_lv1.setAdapter(biankanAdapter);
        bian_lv1.setOnScrollListener(this);

        footer = LayoutInflater.from(getContext()).inflate(R.layout.footeritem, null);
        bian_lv1.addFooterView(footer);
        pb_progressbar = footer.findViewById(R.id.pb_progressbar);

        getdata(num);


        return inflate;
    }

    private void getdata(int num) {
        VolleyUtils.getInstance(getActivity()).get(Concat.LOOK_URL + this.num, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                String s = response.toString();
                Biankan biankan = new Gson().fromJson(s, Biankan.class);
                List<Biankan.DataBean.ContentBean> content = biankan.getData().getContent();
                list.addAll(content);
                biankanAdapter.notifyDataSetChanged();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }



    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == SCROLL_STATE_IDLE && lastindex == biankanAdapter.getCount()) {
    pb_progressbar.setVisibility(View.VISIBLE);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    getdata(num++);
                    pb_progressbar.setVisibility(View.GONE);
                }
            }, 1200);
            biankanAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
        lastindex = i + i1 - 1;
        if (i2 == list.size() ) {
            bian_lv1.removeFooterView(footer);
            Toast.makeText(getContext(), "上拉加载更多", Toast.LENGTH_SHORT).show();
        }


    }
}
