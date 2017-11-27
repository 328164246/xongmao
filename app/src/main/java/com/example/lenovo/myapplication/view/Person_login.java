package com.example.lenovo.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.myapplication.R;

public class Person_login extends AppCompatActivity  {

    private ImageView tb_img;
    private TextView tb_text;
    private ImageView imageView;
    private LinearLayout person_login;
    private LinearLayout person_lishi;
    private LinearLayout person_shoucang;
    private LinearLayout person_set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_total);
        initView();
        initData();
    }

    private void initData() {
        tb_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        person_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Person_login.this,LoginActivity.class));
            }
        });
        person_lishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Person_login.this,Lishi.class));
            }
        });
        person_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Person_login.this,Person_set.class));
            }
        });
        person_shoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Person_login.this,Person_shoucang.class));
            }
        });

    }

    private void initView() {
        tb_img = (ImageView) findViewById(R.id.tb_img);
        tb_text = (TextView) findViewById(R.id.tb_text);
        imageView = (ImageView) findViewById(R.id.imageView);
        person_login = (LinearLayout) findViewById(R.id.person_login);
        person_lishi = (LinearLayout) findViewById(R.id.person_lishi);
        person_shoucang = (LinearLayout) findViewById(R.id.person_shoucang);
        person_set = (LinearLayout) findViewById(R.id.person_set);
    }
}
