package com.example.lenovo.myapplication.utils;

import okhttp3.OkHttpClient;

/**
 * Created by Lenovo on 2017/11/2.
 */

public class OkhttpUtils {
private static OkhttpUtils okhttpUtils;
    private final OkHttpClient client;

    private OkhttpUtils(){
        client = new OkHttpClient.Builder().build();
    }
    public static OkhttpUtils getInstance(){
        if(null==okhttpUtils){
            synchronized (OkhttpUtils.class){
                if(null==okhttpUtils){
                    okhttpUtils=new OkhttpUtils();
                }
            }
        }
        return okhttpUtils;
    }




}
