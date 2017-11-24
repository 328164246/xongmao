package com.example.lenovo.myapplication.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapters.Yuanchuang_listview_adapter;
import com.example.lenovo.myapplication.base.baseactivity.BaseActivity;
import com.example.lenovo.myapplication.beans.Yuanchuang_hudong;
import com.example.lenovo.myapplication.concat.Concat;
import com.example.lenovo.myapplication.presenter.Ipresenter;

import java.util.ArrayList;
import java.util.List;

public class Person_yuanchuang extends BaseActivity implements Iview<Yuanchuang_hudong> {


    private List<Yuanchuang_hudong.InteractiveBean> yuanchuanglist = new ArrayList<>();
    private Yuanchuang_listview_adapter yuanchuang_listview_adapter;
    private ImageView person_yuanchuang_img;
    private ListView lv_listview;

    @Override
    protected void initLayout() {
        setShowHeader(true);



        //可滚动的布局
        setShowRefreshbody(true);
        setShowFooter(false);

    }

    @Override
    protected View getHeader() {
        //互动页面头布局
        return View.inflate(this, R.layout.activity_person_header, null);
    }

    @Override
    protected View getBody() {
        //互动页面主布局
        View inflate = View.inflate(this, R.layout.listview, null);
        return inflate;
    }

    @Override
    protected View getFooter() {
        return null;
    }

    @Override
    protected void initviews() {
        person_yuanchuang_img = (ImageView) findViewById(R.id.person_yuanchuang_img);
        lv_listview = (ListView) findViewById(R.id.lv_listview);
    }


    @Override
    protected void run() {
        Ipresenter ipresenter = new Ipresenter(this);
        ipresenter.getData(Concat.HUDONG_URL, null);
        yuanchuang_listview_adapter = new Yuanchuang_listview_adapter(this, yuanchuanglist);
        lv_listview.setAdapter(yuanchuang_listview_adapter);
        person_yuanchuang_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Person_yuanchuang.this, Homepage.class));
            }
        });

    }

    @Override
    public void succeed(Yuanchuang_hudong T) {
        List<Yuanchuang_hudong.InteractiveBean> yuanchuang = T.getInteractive();
        yuanchuanglist.addAll(yuanchuang);
        yuanchuang_listview_adapter.notifyDataSetChanged();

    }

    @Override
    public void faile(Throwable e) {
        Log.e("TAG", e.toString());
    }
}
