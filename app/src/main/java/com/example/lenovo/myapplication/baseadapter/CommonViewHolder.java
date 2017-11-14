package com.example.lenovo.myapplication.baseadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Lenovo on 2017/11/10.
 */

public class CommonViewHolder {
    private SparseArray<View> mViews;
    private View mConvertView;

    public CommonViewHolder(Context context, ViewGroup parent, int layoutId) {
        mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    public static CommonViewHolder getViewHolder(Context context, View convertView, ViewGroup parent, int layoutId) {
        if (convertView == null)
            return new CommonViewHolder(context, parent, layoutId);
        return (CommonViewHolder) convertView.getTag();
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {
        View item = mViews.get(viewId);
        if (item == null) {
            item = mConvertView.findViewById(viewId);
            mViews.put(viewId, item);
        }
        return (T) item;
    }

    public View getMConvertView() {
        return mConvertView;
    }
}
