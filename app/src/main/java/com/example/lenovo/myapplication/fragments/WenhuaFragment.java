package com.example.lenovo.myapplication.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapters.WenhualistivewAdapter;
import com.example.lenovo.myapplication.beans.Wenhua;
import com.example.lenovo.myapplication.concat.Concat;
import com.example.lenovo.myapplication.presenter.Ipresenter;
import com.example.lenovo.myapplication.view.ClickVideoActivity;
import com.example.lenovo.myapplication.view.Iview;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by Lenovo on 2017/11/3.
 */

public class WenhuaFragment extends Fragment implements Iview<Wenhua> {

    private ListView wenhua_listview;
    private FlyBanner wenhua_flybanner;
    private List<Wenhua.ListBean> list1=new ArrayList<>();
    private List<Wenhua.BigImgBean> bigImg;
    private WenhualistivewAdapter wenhualistivewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Ipresenter ipresenter = new Ipresenter(this);
        ipresenter.getData(Concat.WENHUA_URL,null);

        View inflate = inflater.inflate(R.layout.wenhualayout, container, false);
        wenhua_flybanner = inflate.findViewById(R.id.wenhua_flybanner);
        wenhua_listview = inflate.findViewById(R.id.wenhua_listview);

        wenhualistivewAdapter = new WenhualistivewAdapter(list1,getContext());
        wenhua_listview.setAdapter(wenhualistivewAdapter);
        return inflate;
    }

    @Override
    public void succeed(Wenhua T) {
        List<Wenhua.ListBean> list = T.getList();
        list1.addAll(list);
        bigImg = T.getBigImg();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < bigImg.size(); i++) {
            strings.add(bigImg.get(i).getImage());
        }
        wenhua_flybanner.setImagesUrl(strings);
       wenhualistivewAdapter.notifyDataSetChanged();
        wenhua_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ClickVideoActivity.class);

                intent.putExtra("idthree",list1.get(i).getId());
                startActivity(intent);



            }
        });




    }

    @Override
    public void faile(Throwable e) {
        Log.e("TAG",e.toString());
    }
}
