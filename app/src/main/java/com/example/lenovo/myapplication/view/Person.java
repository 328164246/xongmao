package com.example.lenovo.myapplication.view;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.base.baseactivity.BaseActivity;


public class Person extends BaseActivity {


    private ImageView tb_img;
    private LinearLayout person_lishi;
    private LinearLayout person_shoucang;
    private LinearLayout person_set;
    private LinearLayout person_login;

    @Override
    protected void initLayout() {
        setShowHeader(true);
        setShowNoGroundbody(true);
    }

    @Override
    protected View getHeader() {
        return View.inflate(this, R.layout.toolbar, null);
    }

    @Override
    protected View getBody() {
        return View.inflate(this, R.layout.person, null);
    }

    @Override
    protected View getFooter() {
        return null;
    }

    @Override
    protected void initviews() {
        tb_img = (ImageView) findViewById(R.id.tb_img);
        person_lishi = (LinearLayout) findViewById(R.id.person_lishi);
        person_shoucang = (LinearLayout) findViewById(R.id.person_shoucang);
        person_set = (LinearLayout) findViewById(R.id.person_set);
        person_login = (LinearLayout) findViewById(R.id.person_login);
    }

    @Override
    protected void run() {
        tb_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Person.this, Homepage.class));
            }
        });
        person_lishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Person.this,Lishi.class));
            }
        });
    }
}
