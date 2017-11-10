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

public class RecyclerAdapter_four extends RecyclerView.Adapter {
    private List<Bean.DataBean.WallliveBean.ListBeanX> list ;
    private Context context;

    public RecyclerAdapter_four(List<Bean.DataBean.WallliveBean.ListBeanX> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rc1, parent, false);
        ViewHolder holder = new ViewHolder(inflate);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).tv_two.setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getImage()).into(((ViewHolder) holder).iv_two);

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_two;
        public TextView tv_two;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_two = (ImageView) rootView.findViewById(R.id.iv_two);
            this.tv_two = (TextView) rootView.findViewById(R.id.tv_two);
        }

    }
}
