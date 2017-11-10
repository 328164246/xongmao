package com.example.lenovo.myapplication.model;

import android.content.Context;

import java.util.Map;

/**
 * Created by Lenovo on 2017/11/1.
 */

public interface Imodel<T> {
    void getData(String url, Map<String,String> map, CallBack<T> callBack);


}
