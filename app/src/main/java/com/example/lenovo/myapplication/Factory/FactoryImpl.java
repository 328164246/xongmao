package com.example.lenovo.myapplication.Factory;

import android.content.Context;

import com.example.lenovo.myapplication.Proudct.Proudct;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Lenovo on 2017/10/31.
 */

public class FactoryImpl extends Factory {
    @Override
    public <T extends Proudct> Proudct create(Class<T> clz) {
        try {
            //利用反射 获取实例
            Proudct o = (Proudct) Class.forName(clz.getName()).newInstance();
            return o;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }



    }

    @Override
    public <T extends Proudct> Proudct create(Context context, Class<T> clz) {

        try {
            Class<?> aClass = Class.forName(clz.getName());
            //TODO
            Constructor<?> constructor = aClass.getConstructor(Context.class);
            //TODO
            Proudct o = (Proudct) constructor.newInstance(context);
            return o;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }


    }
}
