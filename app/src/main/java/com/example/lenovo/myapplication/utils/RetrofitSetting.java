package com.example.lenovo.myapplication.utils;

import android.os.Environment;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lenovo on 2017/10/31.
 */

public class RetrofitSetting {
    private static RetrofitSetting retrofitSetting;
    private final Retrofit retrofit;
    private final OkHttpClient client;

    public RetrofitSetting(){
        File file=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/xongmao");
        if(!file.exists()){
            file.mkdir();
        }

        Cache cache = new Cache(file, 20 * 1024 * 1024);
        client = new OkHttpClient.Builder().cache(cache).build();



        retrofit = new Retrofit.Builder().baseUrl("http://www.baidu.com").addConverterFactory(GsonConverterFactory.create())
                .client(client)

                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
    }
    public static RetrofitSetting getInstance(){
        if(null==retrofitSetting){
            synchronized (RetrofitSetting.class){
                if(null==retrofitSetting){
                    retrofitSetting=new RetrofitSetting();
                }
            }
        }
        return retrofitSetting;
    }

    public <T> T create(Class<T> clz){
        return retrofit.create(clz);
    }

}
