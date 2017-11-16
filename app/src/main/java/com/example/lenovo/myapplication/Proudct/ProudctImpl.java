package com.example.lenovo.myapplication.Proudct;

import android.util.Log;

import com.example.lenovo.myapplication.Apiservice.Apiservice;
import com.example.lenovo.myapplication.model.CallBack;
import com.example.lenovo.myapplication.utils.RetrofitSetting;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Lenovo on 2017/10/31.
 */

public class ProudctImpl extends Proudct {
    @Override
    public void get(String url, CallBack callBack) {

    }

    @Override
    public void post(String url, Map<String, String> map, final CallBack callBack) {

     //Apiservice为retrofit接口注解
        Apiservice apiservice = RetrofitSetting.getInstance().create(Apiservice.class);
        Observable<ResponseBody> post = apiservice.sendPost(url, map);
        post.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.faile(e);
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            //反射获取接口
                            Log.e("TAG",string);
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = actualTypeArguments[0];
                            Gson gson = new Gson();

                            Object o = gson.fromJson(string, type);
                            callBack.succeed(o);


                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                });


    }
}
