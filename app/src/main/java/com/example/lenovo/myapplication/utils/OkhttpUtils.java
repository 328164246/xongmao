package com.example.lenovo.myapplication.utils;

import android.os.Handler;

import com.example.lenovo.myapplication.model.CallBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
