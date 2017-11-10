package com.example.lenovo.myapplication.base.basefragments;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Lenovo on 2017/11/1.
 */

public  abstract  class AbstractFragment extends Fragment {

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
