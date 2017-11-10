package com.example.lenovo.myapplication.presenter;

import com.example.lenovo.myapplication.concat.Concat;
import com.example.lenovo.myapplication.model.Imodeimpl;
import com.example.lenovo.myapplication.model.Imodel;
import com.example.lenovo.myapplication.view.Iview;
import com.example.lenovo.myapplication.view.Homepage;

import java.util.Map;

/**
 * Created by Lenovo on 2017/11/2.
 */

public class Ipresenter {
    Imodel imodel;
    Iview iview;
    public Ipresenter(Iview iview){
        this.iview=iview;
        imodel=new Imodeimpl();
    }
    public void getData(String url,Map<String,String> map){
      imodel.getData(url,map,iview);




    }







}
