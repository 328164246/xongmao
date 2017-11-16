package com.example.lenovo.myapplication.view;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.base.baseactivity.BaseActivity;

import static com.example.lenovo.myapplication.R.layout.listview;

public class Lishi extends BaseActivity {


    private TextView tb_text;
    private ListView lv_listview;

    @Override
    protected void initLayout() {
        setShowHeader(true);
        setShowNoGroundbody(true);
    }

    @Override
    protected View getHeader() {
        return View.inflate(this, R.layout.lishiitem, null);
    }

    @Override
    protected View getBody() {
        return View.inflate(this, listview,null);
    }

    @Override
    protected View getFooter() {
        return null;
    }

    @Override
    protected void initviews() {
        tb_text = (TextView) findViewById(R.id.tb_text);
        lv_listview = (ListView) findViewById(R.id.lv_listview);



    }

    @Override
    protected void run() {
        tb_text.setText("历史");




    }
}
