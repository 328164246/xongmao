package com.example.lenovo.myapplication.adapters;

import android.content.Context;
import android.widget.TextView;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.baseadapter.CommonAdapter;
import com.example.lenovo.myapplication.baseadapter.CommonViewHolder;
import com.example.lenovo.myapplication.beans.Biankan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by Lenovo on 2017/11/20.
 */

public class BiankanAdapter extends CommonAdapter<Biankan.DataBean.ContentBean> {

    public BiankanAdapter(Context context, List<Biankan.DataBean.ContentBean> listData, int layoutId) {
        super(context, listData, layoutId);
    }

    @Override
    protected void fillData(CommonViewHolder holder, int position) {
        TextView biankan_content = holder.getView(R.id.biankan_content);
        TextView biankan_louceng = holder.getView(R.id.biankan_louceng);
        TextView biankan_riqi = holder.getView(R.id.biankan_riqi);
        TextView biankan_wangyou = holder.getView(R.id.biankan_wangyou);

        biankan_content.setText(listData.get(position).getMessage());
        biankan_louceng.setText(listData.get(position).getAuthorid()+"楼");
        String dateline = listData.get(position).getDateline();
        long l = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Long valueOf = Long.valueOf(dateline);
        Date date = new Date(l-valueOf);
        String format = simpleDateFormat.format(date);
        biankan_riqi.setText(format);

        biankan_wangyou.setText(listData.get(position).getAuthor());



    }
}
