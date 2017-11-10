package com.example.lenovo.myapplication.adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.beans.Yuanchuang_hudong;

import java.util.List;

import static android.R.id.list;

/**
 * Created by Lenovo on 2017/11/5.
 */

public class Yuanchuang_listview_adapter extends BaseAdapter {
    private Context context;

    private List<Yuanchuang_hudong.InteractiveBean> yuanchuanglist;
    public Yuanchuang_listview_adapter(Context context, List<Yuanchuang_hudong.InteractiveBean> yuanchuanglist) {
        this.context = context;
        this.yuanchuanglist = yuanchuanglist;
    }
    @Override
    public int getCount() {
        return yuanchuanglist.size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.yuanchuang_listview_item, null);
            holder. tv_person = convertView.findViewById(R.id.tv_person);
            holder. iv_person = convertView.findViewById(R.id.iv_person);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_person.setText(yuanchuanglist.get(position).getTitle());
        Glide.with(context).load(yuanchuanglist.get(position).getImage()).into(holder.iv_person);



        return convertView;
    }
    class ViewHolder{
        TextView tv_person;
        ImageView iv_person;
    }
}
