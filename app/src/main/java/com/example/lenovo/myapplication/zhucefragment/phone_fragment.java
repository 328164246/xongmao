package com.example.lenovo.myapplication.zhucefragment;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.utils.CodeUtils;
import com.example.lenovo.myapplication.utils.Regular;
import com.example.lenovo.myapplication.view.LoginActivity;

/**
 * Created by Lenovo on 2017/11/27.
 */

public class phone_fragment extends Fragment implements View.OnClickListener {
    private EditText et_phone_name;
    private TextView tv_add_name_prompt;
    private EditText et_phone_img;
    private ImageView tv_img;
    private TextView tv_add_img_prompt;
    private EditText et_phone_yanzhenma;
    private Button bt_phone_yan;
    private TextView tv_add_ma_prompt;
    private EditText et_phone_paw;
    private TextView tv_add_paw_prompt;
    private CheckBox checkBox;
    private Button bt_phone_add;
    private Button bt_phone_login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.phone_zhuceitem, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        et_phone_name = (EditText) inflate.findViewById(R.id.et_phone_name);
        tv_add_name_prompt = (TextView) inflate.findViewById(R.id.tv_add_name_prompt);
        et_phone_img = (EditText) inflate.findViewById(R.id.et_phone_img);
        tv_img = (ImageView) inflate.findViewById(R.id.tv_img);
        tv_add_img_prompt = (TextView) inflate.findViewById(R.id.tv_add_img_prompt);
        et_phone_yanzhenma = (EditText) inflate.findViewById(R.id.et_phone_yanzhenma);
        bt_phone_yan = (Button) inflate.findViewById(R.id.bt_phone_yan);
        tv_add_ma_prompt = (TextView) inflate.findViewById(R.id.tv_add_ma_prompt);
        et_phone_paw = (EditText) inflate.findViewById(R.id.et_phone_paw);
        tv_add_paw_prompt = (TextView) inflate.findViewById(R.id.tv_add_paw_prompt);
        checkBox = (CheckBox) inflate.findViewById(R.id.checkBox);

        bt_phone_yan.setOnClickListener(this);
        tv_img.setOnClickListener(this);
        bt_phone_login = (Button) inflate.findViewById(R.id.bt_phone_login);
        bt_phone_login.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_img:
                Bitmap bitmap = CodeUtils.getInstance().createBitmap();//codeUtils的图片验证
                tv_img.setImageBitmap(bitmap);
                break;
            case R.id.bt_phone_yan:

                break;


            case R.id.bt_phone_login:
                submit();

            break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void submit() {
        String code = CodeUtils.code;

        String phone_imgcode = et_phone_img.getText().toString();
        String phone_name = et_phone_name.getText().toString();
        String phone_yanzhenma = et_phone_yanzhenma.getText().toString();
        String phone_password = et_phone_paw.getText().toString();
        if (phone_name.equals("")) {
            Toast.makeText(getActivity(), "账号不能为空", Toast.LENGTH_SHORT).show();
        } else {
            if (!Regular.getInstance().isMobileNO(phone_name)) {
                Toast.makeText(getActivity(), "账号不符合格式", Toast.LENGTH_SHORT).show();
                if (phone_yanzhenma.equals("")) {
                    Toast.makeText(getActivity(), "验证码不能为空", Toast.LENGTH_SHORT).show();
                } else if (!phone_yanzhenma.equals(code)) {
                    Toast.makeText(getActivity(), "验证码不对", Toast.LENGTH_SHORT).show();
                } else {

                   // et_phone_yanzhenma.setText("");
                    if (phone_password.equals("")) {
                        Toast.makeText(getActivity(), "密码不能为空", Toast.LENGTH_SHORT).show();
                    } else if (phone_password.length() < 6 || phone_password.length() > 12) {
                        Toast.makeText(getActivity(), "密码不符合", Toast.LENGTH_SHORT).show();
                    } else {
                        et_phone_paw.setText("");
                        Toast.makeText(getActivity(), "注册成功", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getActivity(),LoginActivity.class));
                    }
                }

            }
        }

    }
}
