package com.example.lenovo.myapplication.Factory;

import android.content.Context;

import com.example.lenovo.myapplication.Proudct.Proudct;

/**
 * Created by Lenovo on 2017/10/31.
 */

public  abstract class Factory {
    //返回的产品类
    public abstract <T extends Proudct> Proudct create(Class<T> clz);
    //返回的也是产品类,为了扩展有上下文的网络请求
    public abstract <T extends Proudct> Proudct create(Context context,Class<T> clz);

}
