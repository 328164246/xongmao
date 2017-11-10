package com.example.lenovo.myapplication.base.baseactivity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Lenovo on 2017/11/1.
 */

public  abstract  class Abstractactivity extends AppCompatActivity {

    //(设置布局显示不显示)
    protected abstract void initLayout();
    //得到头布局
    protected abstract View getHeader();
    //得到主布局
    protected abstract View getBody();
    //得到尾布局
    protected abstract View getFooter();
    //初始化子类控件(找id)
   protected abstract void initviews();
    //代码运行区域
    protected abstract void run();







}
