package com.example.lenovo.myapplication.view;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapters.Shouye_Adapter;
import com.example.lenovo.myapplication.base.baseactivity.BaseActivity;
import com.example.lenovo.myapplication.fragments.GuanchaFragment;
import com.example.lenovo.myapplication.fragments.ShouyeFragment;
import com.example.lenovo.myapplication.fragments.WenhuaFragment;
import com.example.lenovo.myapplication.fragments.XongmaoZhiboFragment;
import com.example.lenovo.myapplication.fragments.ZhiboChinaFragment;

import java.util.ArrayList;


public class Homepage extends BaseActivity {


    private ImageView home_iv_yuanchuang;
    private View header;
    private View footer;

    private View body;
    private ViewPager vp_body;
    private TabLayout tb_footer;
    private ImageView home_iv_denglu;
    private TextView logo_tv_title;
    private ImageView logo_img;

    @Override
    protected void initLayout() {
        setShowHeader(true);
        setShowRefreshbody(true);
        setShowFooter(true);
    }

    @Override
    protected View getHeader() {

        header = View.inflate(this, R.layout.home_header, null);
        return header;
    }

    @Override
    protected View getBody() {
        body = View.inflate(this, R.layout.home_body, null);
        return body;
    }

    @Override
    protected View getFooter() {

        footer = View.inflate(this, R.layout.home_footer, null);
        return footer;
    }

    @Override
    protected void initviews() {

        home_iv_denglu = (ImageView) findViewById(R.id.home_iv_denglu);
        home_iv_yuanchuang = (ImageView) findViewById(R.id.home_iv_yuanchuang);
        logo_img = (ImageView) findViewById(R.id.logo_img);
        vp_body = (ViewPager) findViewById(R.id.vp_body);
        logo_tv_title = (TextView) findViewById(R.id.logo_tv_title);

        tb_footer = (TabLayout) findViewById(R.id.tb_footer);

    }


    @Override
    protected void run() {


        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new ShouyeFragment());
        list.add(new GuanchaFragment());
        list.add(new WenhuaFragment());
        list.add(new XongmaoZhiboFragment());
        list.add(new ZhiboChinaFragment());
        tb_footer.addTab(tb_footer.newTab());
        tb_footer.addTab(tb_footer.newTab());
        tb_footer.addTab(tb_footer.newTab());
        tb_footer.addTab(tb_footer.newTab());
        tb_footer.addTab(tb_footer.newTab());
        Shouye_Adapter shouye_adapter = new Shouye_Adapter(getSupportFragmentManager(), list);
        vp_body.setAdapter(shouye_adapter);
        tb_footer.setupWithViewPager(vp_body);
        final ArrayList<String> titlelist = new ArrayList<>();
        titlelist.add("首页");
        titlelist.add("熊猫观察");
        titlelist.add("熊猫文化");
        titlelist.add("熊猫直播");
        titlelist.add("直播中国");


        tb_footer.getTabAt(0).setIcon(R.mipmap.tab_home_normal).setText(titlelist.get(0));
        tb_footer.getTabAt(1).setIcon(R.mipmap.tab_panda_eye_normal).setText(titlelist.get(1));
        tb_footer.getTabAt(2).setIcon(R.mipmap.tab_live_china_pressed).setText(titlelist.get(2));
        tb_footer.getTabAt(3).setIcon(R.mipmap.tab_panda_live_normal).setText(titlelist.get(3));
        tb_footer.getTabAt(4).setIcon(R.mipmap.tab_live_china_pressed).setText(titlelist.get(4));

        home_iv_denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this, Person.class));
            }
        });
        home_iv_yuanchuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this, Person_yuanchuang.class));
            }
        });

        //tablayout的点击事件,tab获取文字

       tb_footer.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               if(tab.getText().equals("首页")){
                   logo_tv_title.setVisibility(View.VISIBLE);
                   logo_img.setVisibility(View.VISIBLE);
                   home_iv_yuanchuang.setVisibility(View.VISIBLE);
                   logo_tv_title.setText(tab.getText());
               }else {
                   logo_tv_title.setVisibility(View.VISIBLE);
                   logo_img.setVisibility(View.GONE);
                   home_iv_yuanchuang.setVisibility(View.GONE);
                   logo_tv_title.setText(tab.getText());
               }
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });
        home_iv_yuanchuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         startActivity(new Intent(Homepage.this,Person_yuanchuang.class));
            }
        });


    }


}
