package com.example.lenovo.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.myapplication.R;

/**
 * Created by Lenovo on 2017/11/22.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView weixin_login;
    private TextView qq_login;
    private TextView weibo_login;
    private LinearLayout ll_three;
    private EditText phone_login;
    private EditText password_login;
    private TextView find_login;
    private Button btn_login;
    private ImageView login_fanhui;
    private TextView login_zhuce;
    private TextView find_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginitem);
        initView();
    }

    private void initView() {
        weixin_login = (TextView) findViewById(R.id.weixin_login);
        qq_login = (TextView) findViewById(R.id.qq_login);
        weibo_login = (TextView) findViewById(R.id.weibo_login);
        ll_three = (LinearLayout) findViewById(R.id.ll_three);
        phone_login = (EditText) findViewById(R.id.phone_login);
        password_login = (EditText) findViewById(R.id.password_login);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        login_fanhui = (ImageView) findViewById(R.id.login_fanhui);
        login_fanhui.setOnClickListener(this);
        login_zhuce = (TextView) findViewById(R.id.login_zhuce);
        login_zhuce.setOnClickListener(this);
        find_password = (TextView) findViewById(R.id.find_password);
        find_password.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {



            case R.id.login_fanhui:
                startActivity(new Intent(LoginActivity.this, Homepage.class));
                break;

            case R.id.login_zhuce:
                startActivity(new Intent(LoginActivity.this,Person_zhuceActivity.class));
                break;
            case R.id.find_password:
                startActivity(new Intent(LoginActivity.this,Person_find.class));
                break;
        }
    }

    private void submit() {
        // validate
        String login = phone_login.getText().toString().trim();
        if (TextUtils.isEmpty(login)) {
            Toast.makeText(this, "请输入邮箱或手机号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = password_login.getText().toString().trim();
        if (TextUtils.isEmpty(login)) {
            Toast.makeText(this, "请输入密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
