package com.example.huanpet.view.activity.login;

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

public class RegistActivity extends BaseActivity {

    private EditText regist_phoneNum;
    private TextView regist_verification;
    private EditText regist_phone_code;
    private EditText regist_password;
    private EditText regist_sixPass;
    private Button bt_regist;
    private LinearLayout regist_QQ;
    private LinearLayout regist_Chat;


    @Override
    protected void initData() {

    }

    @Override
    protected void initview() {
        showBack(true);
        showSouText(false);
        showMap(false);
        showUser(false);
        setTitle("注册账号");
        showTitle(true);
        regist_phoneNum = (EditText) findViewById(R.id.regist_phoneNum);
        regist_verification = (TextView) findViewById(R.id.regist_verification);
        regist_phone_code = (EditText) findViewById(R.id.regist_phone_code);
        regist_password = (EditText) findViewById(R.id.regist_password);
        regist_sixPass = (EditText) findViewById(R.id.regist_sixPass);
        bt_regist = (Button) findViewById(R.id.bt_regist);
        regist_QQ = (LinearLayout) findViewById(R.id.regist_QQ);
        regist_Chat = (LinearLayout) findViewById(R.id.regist_Chat);
    }

    @Override
    public int getlayoutID() {
        return R.layout.activity_regist;
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.bt_regist:

                break;
            case R.id.regist_verification:

                break;
            case R.id.regist_Chat:
getPhone();
                break;
            case R.id.regist_QQ:

                break;
        }
    }


    @Override
    protected void doDetermine() {

    }

    @Override
    protected void intentUser() {

    }

//获取手机号
    public String getPhone() {
        return regist_phoneNum.getText().toString();
    }
}
