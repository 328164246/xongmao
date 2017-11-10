package com.example.lenovo.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.beans.eightBean;

import java.util.List;

/**
 * Created by Lenovo on 2017/11/9.
 */

public class ListviewAdapter_eight extends BaseAdapter {


    private List<eightBean.ListBean> list;
    private Context context;

    public ListviewAdapter_eight(List<eightBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }




    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_eight, null);
            holder. eight_tv_title = convertView.findViewById(R.id.eight_tv_title);
            holder. eight_tv_time = convertView.findViewById(R.id.eight_tv_time);
            holder. eight_img = convertView.findViewById(R.id.eight_img);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
     holder.eight_tv_time.setText(list.get(position).getDaytime());
      holder.eight_tv_title.setText(list.get(position).getTitle());
       Glide.with(context).load(list.get(position).getImage()).into(holder.eight_img);


        return convertView;
    }


    class ViewHolder{
        TextView eight_tv_title ;
        TextView eight_tv_time ;
        ImageView eight_img ;

    }
}
