package com.example.lenovo.myapplication.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.base.baseactivity.BaseActivity;

public class PersonalActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout person_login;
    private LinearLayout person_lishi;
    private LinearLayout person_shoucang;
    private LinearLayout person_set;
    private ImageView tb_img;

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
        return View.inflate(this, R.layout.layout_person, null);
    }

    @Override
    protected View getFooter() {
        return null;
    }


    @Override
    protected void initviews() {
        tb_img = (ImageView) findViewById(R.id.tb_img);
        person_login = (LinearLayout) findViewById(R.id.person_login);
        person_login.setOnClickListener(this);
        person_lishi = (LinearLayout) findViewById(R.id.person_lishi);
        person_lishi.setOnClickListener(this);
        person_shoucang = (LinearLayout) findViewById(R.id.person_shoucang);
        person_shoucang.setOnClickListener(this);
        person_set = (LinearLayout) findViewById(R.id.person_set);
        person_set.setOnClickListener(this);


    }


    @Override
    protected void run() {


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tb_img:
                finish();
                break;
            case R.id.person_login:
                startActivity(new Intent(PersonalActivity.this, LoginActivity.class));
                break;
            case R.id.person_lishi:
                startActivity(new Intent(PersonalActivity.this,Lishi.class));

                break;


        }
    }
}
