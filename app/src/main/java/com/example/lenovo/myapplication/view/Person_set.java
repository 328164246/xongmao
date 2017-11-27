package com.example.lenovo.myapplication.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.myapplication.R;

public class Person_set extends AppCompatActivity {

    private ImageView pe_set_push_view;
    private ImageView pe_set_play_view;
    private TextView set_cache_size_tv;
    private RelativeLayout personal_set_delete_cache_layout;
    private RelativeLayout personal_set_fankui_layout;
    private RelativeLayout personal_set_udpate_layout;
    private RelativeLayout personal_set_ping_layout;
    private RelativeLayout personal_set_about_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setitem);
        initView();
    }

    private void initView() {
        pe_set_push_view = (ImageView) findViewById(R.id.pe_set_push_view);
        pe_set_play_view = (ImageView) findViewById(R.id.pe_set_play_view);
        set_cache_size_tv = (TextView) findViewById(R.id.set_cache_size_tv);
        personal_set_delete_cache_layout = (RelativeLayout) findViewById(R.id.personal_set_delete_cache_layout);
        personal_set_fankui_layout = (RelativeLayout) findViewById(R.id.personal_set_fankui_layout);
        personal_set_udpate_layout = (RelativeLayout) findViewById(R.id.personal_set_udpate_layout);
        personal_set_ping_layout = (RelativeLayout) findViewById(R.id.personal_set_ping_layout);
        personal_set_about_layout = (RelativeLayout) findViewById(R.id.personal_set_about_layout);
    }
}
