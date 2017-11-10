package com.example.lenovo.myapplication.Apiservice;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;


/**
 * Created by Lenovo on 2017/10/31.
 */

public interface Apiservice {
    @GET
    Observable<ResponseBody> sendGet(@Url String url);




    @POST
    @FormUrlEncoded
    Observable<ResponseBody> sendPost(@Url String url,@FieldMap Map<String,String> map);

}
