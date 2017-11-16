package com.example.lenovo.myapplication.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.baseadapter.CommonAdapter;
import com.example.lenovo.myapplication.baseadapter.CommonViewHolder;
import com.example.lenovo.myapplication.beans.Guancha;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Lenovo on 2017/11/14.
 */

public class GuanchaAdapter extends CommonAdapter<Guancha.ListBean> {

    public GuanchaAdapter(Context context, List<Guancha.ListBean> listData, int layoutId) {
        super(context, listData, layoutId);
    }

    @Override
    protected void fillData(CommonViewHolder holder, int position) {
        ImageView guancha_listview_img = holder.getView(R.id.guancha_listview_img);
        ImageView guancha_header_img = holder.getView(R.id.guancha_header_img);
        TextView guancha_tv_length = holder.getView(R.id.guancha_tv_length);
        TextView guancha_listview_tv_title = holder.getView(R.id.guancha_listview_tv_title);
        TextView guancha_listview_tv_time = holder.getView(R.id.guancha_listview_tv_time);
        Glide.with(context).load(listData.get(position).getPicurl()).into(guancha_listview_img);
        guancha_listview_tv_title.setText(listData.get(position).getTitle());
        guancha_tv_length.setText(listData.get(position).getVideolength());
        Date date = new Date(listData.get(position).getFocus_date());
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //这里的这个是一个毫秒值
        guancha_listview_tv_time.setText(sd.format(date));


    }
}
