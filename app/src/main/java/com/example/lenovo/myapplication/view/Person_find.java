package com.example.lenovo.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.myapplication.R;

/**
 * Created by Lenovo on 2017/11/24.
 */

public class Person_find extends AppCompatActivity implements View.OnClickListener {
    private EditText edit_phonenumber;
    private TextView hint_phonenumber;
    private EditText edit_checkimage;
    private TextView personal_reg_imgcheck;
    private TextView hint_checkimage;
    private EditText edit_checkphone;
    private Button personal_yanzhenma;
    private TextView hint_checkphone;
    private EditText et_newpssword;
    private Button btn_find;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.person_find);
        initView();


    }

    private void initView() {
        edit_phonenumber = (EditText) findViewById(R.id.edit_phonenumber);
        hint_phonenumber = (TextView) findViewById(R.id.hint_phonenumber);
        edit_checkimage = (EditText) findViewById(R.id.edit_checkimage);
        personal_reg_imgcheck = (TextView) findViewById(R.id.personal_reg_imgcheck);
        hint_checkimage = (TextView) findViewById(R.id.hint_checkimage);
        edit_checkphone = (EditText) findViewById(R.id.edit_checkphone);
        personal_yanzhenma = (Button) findViewById(R.id.personal_yanzhenma);
        hint_checkphone = (TextView) findViewById(R.id.hint_checkphone);
        et_newpssword = (EditText) findViewById(R.id.et_newpssword);
        btn_find = (Button) findViewById(R.id.btn_find);

        personal_yanzhenma.setOnClickListener(this);
        btn_find.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.personal_yanzhenma:


                break;
            case R.id.btn_find:
            startActivity(new Intent(Person_find.this,Person_set.class));
                break;
        }
    }

    private void submit() {
        // validate
        String phonenumber = edit_phonenumber.getText().toString().trim();
        if (TextUtils.isEmpty(phonenumber)) {
            Toast.makeText(this, "请输入注册的手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String checkimage = edit_checkimage.getText().toString().trim();
        if (TextUtils.isEmpty(checkimage)) {
            Toast.makeText(this, "图片验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        String checkphone = edit_checkphone.getText().toString().trim();
        if (TextUtils.isEmpty(checkphone)) {
            Toast.makeText(this, "请输入收到的验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        String newpssword = et_newpssword.getText().toString().trim();
        if (TextUtils.isEmpty(newpssword)) {
            Toast.makeText(this, "请设置新密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
