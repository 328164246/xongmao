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
import com.example.lenovo.myapplication.beans.Bakalin;

import java.util.List;

/**
 * Created by Lenovo on 2017/11/9.
 */

public class ListviewAdapter_Badalin extends BaseAdapter {


    private List<Bakalin.LiveBean> list;
    private Context context;

    public ListviewAdapter_Badalin(List<Bakalin.LiveBean> list, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.jincaiitem, null);
            holder.jicai_title = convertView.findViewById(R.id.jicai_title);
            holder.jicai_img = convertView.findViewById(R.id.jicai_img);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.jicai_title.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.jicai_img);


        return convertView;
    }


    class ViewHolder {
        TextView jicai_title;
        ImageView jicai_img;

    }
}
