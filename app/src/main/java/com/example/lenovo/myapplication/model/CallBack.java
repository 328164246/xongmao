package com.example.lenovo.myapplication.model;

/**
 * Created by Lenovo on 2017/10/31.
 */

public interface CallBack<T> {
    void succeed(T T);
    void faile(Throwable e);



}
