package com.example.lenovo.myapplication.zhibochinafragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lenovo.myapplication.R;

/**
 * Created by Lenovo on 2017/11/9.
 */

public class Jincai extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.jincaiitem, container, false);
        ImageView jicai_img = inflate.findViewById(R.id.jicai_img);


        return inflate;
    }
}
