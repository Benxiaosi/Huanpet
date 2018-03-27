package com.example.huanpet.view.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.huanpet.R;
import com.example.huanpet.base.BaseActivity;

public class LoginActivity extends BaseActivity {
    private EditText unser_number;
    private EditText user_password;
    private TextView user_format;
    private Button bt_login;
    private LinearLayout login_QQ;
    private LinearLayout login_Chat;


    @Override
    protected void initData() {

    }

    @Override
    protected void initview() {
        showBack(true);
        showMap(false);

        setDetermine("注册");
        showSouText(false);
        showUser(false);
        showDetermine(true);
        setTitle("");
        showTitle(true);
        setBackGround(R.mipmap.voip_bg);
        unser_number = (EditText) findViewById(R.id.unser_number);
        user_password = (EditText) findViewById(R.id.user_password);
        user_format = (TextView) findViewById(R.id.user_format);
        bt_login = (Button) findViewById(R.id.bt_login);
        login_QQ = (LinearLayout) findViewById(R.id.login_QQ);
        login_Chat = (LinearLayout) findViewById(R.id.login_Chat);
        bt_login.setOnClickListener(this);
    }

    @Override
    public int getlayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void doDetermine() {

        startActivity(new Intent(LoginActivity.this,RegistActivity.class));
    }

    @Override
    protected void intentUser() {

    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.bt_login:


                break;
            case R.id.login_QQ:

                break;
            case R.id.login_Chat:

                break;
            case R.id.user_format:

                break;
        }
    }

    private void submit() {
        // validate
        String number = unser_number.getText().toString().trim();
        if (TextUtils.isEmpty(number)) {
            Toast.makeText(this, "请输入手机号码", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = user_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }



    }
}
