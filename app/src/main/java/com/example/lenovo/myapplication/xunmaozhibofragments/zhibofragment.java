package com.example.lenovo.myapplication.xunmaozhibofragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.adapters.ZhiboAdapter;
import com.example.lenovo.myapplication.beans.Zhibo_content;
import com.example.lenovo.myapplication.pandalive.DuoFragment;
import com.example.lenovo.myapplication.pandalive.LookFragment;
import com.example.lenovo.myapplication.utils.VolleyUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/11/19.
 */

public class zhibofragment extends Fragment {

    private String url;
    private VideoView vv_video;
    private TextView tv_xongmao_title;
    private ImageView iv_shang;
    private ImageView iv_xia;
    private LinearLayout ll_jianjie;
    private TextView fu_tv_content;
    private TabLayout tb_xongmaozhibo;
    private ViewPager vp_xongmaozhibo;
     private int i=1;
    public zhibofragment(String url) {
        this.url = url;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.xongmaozhibo_one, container, false);

        VolleyUtils.getInstance(getContext()).get(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String s = response.toString();
                Zhibo_content zhibo_content = new Gson().fromJson(s, Zhibo_content.class);
                List<Zhibo_content.LiveBean> live = zhibo_content.getLive();

                tv_xongmao_title.setText(live.get(0).getTitle());
                fu_tv_content.setText(live.get(0).getBrief());
                ll_jianjie.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(i%2==1){
                            iv_shang.setVisibility(View.GONE);
                            iv_xia.setVisibility(View.VISIBLE);
                            fu_tv_content.setVisibility(View.VISIBLE);
                            i++;
                        }else {
                            iv_shang.setVisibility(View.VISIBLE);
                            iv_xia.setVisibility(View.GONE);
                            fu_tv_content.setVisibility(View.GONE);
                            i++;
                        }
                    }
                });
                //多视角直播
                List<Zhibo_content.BookmarkBean.MultipleBean> multiple = zhibo_content.getBookmark().getMultiple();
                //边看边聊
                List<Zhibo_content.BookmarkBean.WatchTalkBean> watchTalk = zhibo_content.getBookmark().getWatchTalk();

                String url = multiple.get(0).getUrl();
                ArrayList<Fragment> list = new ArrayList<>();
                list.add(new DuoFragment(multiple.get(0).getUrl()));
                list.add(new LookFragment());
                ArrayList<String> titlelist = new ArrayList<>();
                titlelist.add(multiple.get(0).getTitle());
                titlelist.add(watchTalk.get(0).getTitle());
                ZhiboAdapter zhiboAdapter = new ZhiboAdapter(getChildFragmentManager(), list, titlelist);
                vp_xongmaozhibo.setAdapter(zhiboAdapter);
                tb_xongmaozhibo.setupWithViewPager(vp_xongmaozhibo);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        initView(inflate);
        return inflate;
    }


    private void initView(View inflate) {
        vv_video = (VideoView) inflate.findViewById(R.id.vv_video);
        tv_xongmao_title = (TextView) inflate.findViewById(R.id.tv_xongmao_title);
        iv_shang = (ImageView) inflate.findViewById(R.id.iv_shang);
        iv_xia = (ImageView) inflate.findViewById(R.id.iv_xia);
        ll_jianjie = (LinearLayout) inflate.findViewById(R.id.ll_jianjie);
        fu_tv_content = (TextView) inflate.findViewById(R.id.fu_tv_content);
        tb_xongmaozhibo = (TabLayout) inflate.findViewById(R.id.tb_xongmaozhibo);
        vp_xongmaozhibo = (ViewPager) inflate.findViewById(R.id.vp_xongmaozhibo);
    }
}
