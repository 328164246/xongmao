package com.example.lenovo.myapplication.adapters;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.beans.GuanchaClass;

import java.util.List;

/**
 * Created by Lenovo on 2017/11/8.
 */

public class WenhualistivewAdapter extends BaseAdapter {
    private Context context;
    private List<GuanchaClass.ListBean> list;

    public WenhualistivewAdapter(List<GuanchaClass.ListBean> list, Context activity) {
        this.list=list;
        this.context=activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
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
            convertView = LayoutInflater.from(context).inflate(R.layout.wenhuaitem, null);
            holder.iv_img = convertView.findViewById(R.id.wenhua_img);
            holder.tv_content = convertView.findViewById(R.id.wenhua_tv_content);
            holder.tv_title = convertView.findViewById(R.id.wenhua_tv_title);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_title.setText(list.get(position).getTitle());
        holder.tv_content.setText(list.get(position).getBrief());
        Glide.with(context).load(list.get(position).getImage()).into(holder.iv_img);


        return convertView;
    }

    class ViewHolder {
        ImageView iv_img;
        TextView tv_title;
        TextView tv_content;
    }
}
