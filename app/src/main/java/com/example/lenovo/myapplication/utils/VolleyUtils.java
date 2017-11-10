package com.example.lenovo.myapplication.utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lenovo.myapplication.model.CallBack;

/**
 * Created by Lenovo on 2017/11/1.
 */

public class VolleyUtils {
    private static VolleyUtils volleyUtils;
    private static RequestQueue queue;

    private VolleyUtils(Context context){
        queue = Volley.newRequestQueue(context);
    }
    public static VolleyUtils getInstance(Context context){
        if(null==volleyUtils){
            synchronized (VolleyUtils.class){
                if(null==volleyUtils){
                    volleyUtils=new VolleyUtils(context);
                }
            }
        }
        return volleyUtils;
    }

public void get(String url, Response.Listener<String> listener, Response.ErrorListener errorListener ){
    StringRequest stringRequest = new StringRequest(url, listener, errorListener);
    queue.add(stringRequest);



}
}
