package com.example.lenovo.myapplication.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.beans.Bean;

import java.util.List;

/**
 * Created by Lenovo on 2017/11/7.
 */

public class RecyclerinAdapter extends RecyclerView.Adapter {
    private List<Bean.DataBean.AreaBean.ListscrollBean> list;

    private Context context;

    public RecyclerinAdapter(List<Bean.DataBean.AreaBean.ListscrollBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recycler_in, parent, false);
        ViewHolder holder = new ViewHolder(inflate);


        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).in_tv.setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getImage()).into(((ViewHolder) holder).in_img);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView in_img;
        public TextView in_tv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.in_img = (ImageView) rootView.findViewById(R.id.in_img);
            this.in_tv = (TextView) rootView.findViewById(R.id.in_tv);
        }

    }
}
