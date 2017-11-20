package com.example.lenovo.myapplication.adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.baseadapter.CommonAdapter;
import com.example.lenovo.myapplication.baseadapter.CommonViewHolder;

import java.util.List;

/**
 * Created by Lenovo on 2017/11/20.
 */

public class ZhibofuAdapter extends CommonAdapter<com.example.lenovo.myapplication.beans.zhibojincai.VideoBean> {
    public ZhibofuAdapter(Context context, List listData, int layoutId) {
        super(context, listData, layoutId);
    }

    @Override
    protected void fillData(CommonViewHolder holder, int position) {
        ImageView eight_img = holder.getView(R.id.eight_img);
        TextView eight_tv_time = holder.getView(R.id.eight_tv_time);
        TextView eight_tv_title = holder.getView(R.id.eight_tv_title);
        Glide.with(context).load(listData.get(position).getImg()).into(eight_img);
        eight_tv_time.setText(listData.get(position).getPtime());
      eight_tv_title.setText(listData.get(position).getT());

    }
}
