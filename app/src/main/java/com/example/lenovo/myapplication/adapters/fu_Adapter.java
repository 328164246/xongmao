package com.example.lenovo.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.beans.Hangshan;

import java.util.List;

/**
 * Created by Lenovo on 2017/11/14.
 */

public class fu_Adapter extends BaseAdapter {
    private List<Hangshan.LiveBean> list ;
    private Context context;
    private static boolean flag=true;
    public fu_Adapter(List<Hangshan.LiveBean> list, Context context) {
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
        final ViewHolder holder;
        if (null == convertView) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.chongfubuju, null);
            holder.fu_headimg = convertView.findViewById(R.id.fu_headimg);
            holder.fu_iv_xia = convertView.findViewById(R.id.fu_iv_xia);
            holder.fu_iv_shang = convertView.findViewById(R.id.fu_iv_shang);
            holder.fu_tv_content = convertView.findViewById(R.id.fu_tv_content);
            holder.fu_tv_title = convertView.findViewById(R.id.fu_tv_title);
            holder. ll_jianjie = convertView.findViewById(R.id.ll_jianjie);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.fu_tv_content.setText(list.get(position).getBrief());
        holder.fu_tv_title.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.fu_headimg);
       holder.ll_jianjie.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(flag){
                   holder.fu_tv_content.setVisibility(View.VISIBLE);
                   holder.fu_iv_xia.setVisibility(View.VISIBLE);
                   holder.fu_iv_shang.setVisibility(View.GONE);
                   flag=false;

               }else{
                   holder.fu_tv_content.setVisibility(View.GONE);
                   holder.fu_iv_xia.setVisibility(View.GONE);
                   holder.fu_iv_shang.setVisibility(View.VISIBLE);
                   flag=true;
               }
           }
       });


        return convertView;
    }
    class ViewHolder{
        ImageView fu_headimg;
        TextView fu_tv_content;
        TextView fu_tv_title;
        LinearLayout ll_jianjie;
        ImageView fu_iv_xia ;
        ImageView fu_iv_shang;
    }

}
