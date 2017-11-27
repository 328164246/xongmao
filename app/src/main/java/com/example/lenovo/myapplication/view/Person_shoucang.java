package com.example.lenovo.myapplication.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.lenovo.myapplication.R;

public class Person_shoucang extends AppCompatActivity {

    private ListView lv_shoucang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_shoucang);
        initView();
    }

    private void initView() {
        lv_shoucang = (ListView) findViewById(R.id.lv_shoucang);
    }
}
