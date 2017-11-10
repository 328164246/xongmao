package com.example.lenovo.myapplication.view;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.base.baseactivity.BaseActivity;

public class StartPage extends BaseActivity {


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    startActivity(new Intent(StartPage.this, Homepage.class));
                    break;

            }
        }
    };
    private ImageView iv_sec;
    private View inflate1;

    @Override
    protected void initLayout() {
        setShowNoGroundbody(true);
    }

    @Override
    protected View getHeader() {
        return null;
    }

    @Override
    protected View getBody() {
        inflate1 = View.inflate(this, R.layout.startpage_img, null);
        return inflate1;
    }

    @Override
    protected View getFooter() {
        return null;
    }

    @Override
    protected void initviews() {
        iv_sec = inflate1.findViewById(R.id.iv_sec);
    }

    @Override
    protected void run() {
        Message message = handler.obtainMessage();

        handler.sendEmptyMessageDelayed(1, 200);

    }
}
