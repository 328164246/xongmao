package com.example.lenovo.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.beans.Video;
import com.example.lenovo.myapplication.utils.VolleyUtils;
import com.google.gson.Gson;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class ClickVideoActivity extends AppCompatActivity {


    private JCVideoPlayerStandard jiecao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_video);
        initView();
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String idthree = intent.getStringExtra("idthree");
       // mp4(idthree);
        mp4(id);
    }

    private void mp4(String id) {
        VolleyUtils.getInstance(this).get("http://vdn.apps.cntv.cn/api/getVideoInfoForCBox.do?pid=" + id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String s = response.toString();

                Video video = new Gson().fromJson(s, Video.class);
                jiecao.setUp(video.getVideo().getChapters().get(0).getUrl(), JCVideoPlayer.SCREEN_LAYOUT_LIST, "");


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.toString());
            }
        });
    }

    private void initView() {


        jiecao = (JCVideoPlayerStandard) findViewById(R.id.jiecao);

    }
}
