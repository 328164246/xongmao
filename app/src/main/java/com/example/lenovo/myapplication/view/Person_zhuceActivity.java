package com.example.lenovo.myapplication.view;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.zhucefragment.mail_fragment;
import com.example.lenovo.myapplication.zhucefragment.phone_fragment;

public class Person_zhuceActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_zhuce_left;
    private TextView tv_add_title;
    private TextView tv_phone;
    private TextView tv_mailbox;
    private LinearLayout ll_add;
    private FrameLayout vp_person_frame;


    private mail_fragment mailFragment;
    private phone_fragment phoneFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_zhuce);
        initView();
        initData();


    }

    private void initData() {


        tv_mailbox.setOnClickListener(this);
        mailFragment = new mail_fragment();
        phoneFragment = new phone_fragment();


    }

    private void initView() {
        iv_zhuce_left = (ImageView) findViewById(R.id.iv_zhuce_left);
        tv_add_title = (TextView) findViewById(R.id.tv_add_title);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_mailbox = (TextView) findViewById(R.id.tv_mailbox);
        ll_add = (LinearLayout) findViewById(R.id.ll_add);
        vp_person_frame = (FrameLayout) findViewById(R.id.vp_person_frame);
        iv_zhuce_left.setOnClickListener(this);
        tv_mailbox.setOnClickListener(this);
        tv_phone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = getFragmentManager();  //fragmentManager不能全局变量会报非法状态异常
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (view.getId()) {

            case R.id.tv_mailbox:
                transaction.replace(R.id.vp_person_frame, mailFragment);//getSupportManager是管理v4包的




                break;
            case R.id.tv_phone:
                transaction.replace(R.id.vp_person_frame, phoneFragment);

                break;
            case R.id.iv_zhuce_left:
                startActivity(new Intent(Person_zhuceActivity.this, LoginActivity.class));

                break;


        }
        transaction.commit();
    }
}
