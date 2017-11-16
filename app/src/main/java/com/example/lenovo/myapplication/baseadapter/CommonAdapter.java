package com.example.lenovo.myapplication.baseadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;



import java.util.List;

/**
 * Created by Lenovo on 2017/11/10.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {
    public Context context;
    public List<T> listData;
    private int layoutId;

    public CommonAdapter(Context context, List<T> listData, int layoutId) {
        super();
        this.context = context;
        this.listData = listData;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return this.listData == null ? 0 : this.listData.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CommonViewHolder holder = CommonViewHolder.getViewHolder(this.context, convertView, parent, this.layoutId);
        this.fillData(holder, position);
        return holder.getMConvertView();
    }


    protected abstract void fillData(CommonViewHolder holder, int position);

}
