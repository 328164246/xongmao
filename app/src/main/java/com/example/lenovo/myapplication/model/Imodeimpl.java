package com.example.lenovo.myapplication.model;

import com.example.lenovo.myapplication.Apiservice.Apiservice;
import com.example.lenovo.myapplication.Factory.Factory;
import com.example.lenovo.myapplication.Factory.FactoryImpl;
import com.example.lenovo.myapplication.Proudct.Proudct;
import com.example.lenovo.myapplication.Proudct.ProudctImpl;
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
 * Created by Lenovo on 2017/11/2.
 */

public class Imodeimpl<T> implements Imodel<T> {

    public void getData(String url, Map<String, String> map, final CallBack<T> callBack) {
        FactoryImpl factory = new FactoryImpl();
        Proudct proudct = factory.create(ProudctImpl.class);
        proudct.post(url,map,callBack);
        /*Apiservice apiservice = RetrofitSetting.getInstance().create(Apiservice.class);
        Observable<ResponseBody> post = apiservice.sendPost(url, map);
        post.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
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
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = actualTypeArguments[0];
                            Gson gson = new Gson();
                            Object o = gson.fromJson(string, type);
                            callBack.succeed((T) o);


                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                });
*/



    }


}
