package com.example.lenovo.myapplication.Proudct;


import android.content.Context;

import com.example.lenovo.myapplication.model.CallBack;

import java.util.Map;

/**
 * Created by Lenovo on 2017/10/31.
 */

public abstract class Proudct {
    //产品的共有属性
    public abstract void get(String url, CallBack callBack);
    public abstract void post(String url, Map<String,String> map, CallBack callBack);
}
