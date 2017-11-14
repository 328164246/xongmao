package com.example.lenovo.myapplication.adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.baseadapter.CommonAdapter;
import com.example.lenovo.myapplication.baseadapter.CommonViewHolder;
import com.example.lenovo.myapplication.beans.Bakalin;
import com.example.lenovo.myapplication.zhibochinafragments.Badalin;

import java.util.List;

/**
 * Created by Lenovo on 2017/11/8.
 */

public class Myadapter extends CommonAdapter<Bakalin.LiveBean> {
    public Myadapter(Context context, List listData, int layoutId) {
        super(context, listData, layoutId);
    }

    @Override
    protected void fillData(CommonViewHolder holder, int position) {
        ImageView jicai_img = holder.getView(R.id.jicai_img);
        TextView jicai_title = holder.getView(R.id.jicai_title);
        jicai_title.setText("[真在直播]"+listData.get(position).getTitle());
        Glide.with(context).load(listData.get(position).getImage()).into(jicai_img);
    }
}
