package com.example.huanpet.view.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.huanpet.R;
import com.example.huanpet.app.MyAppAlication;
import com.example.huanpet.base.BaseActivity;
import com.example.huanpet.model.greendao.UserDao;
import com.example.huanpet.utils.jsonurluntils.CJSON;
import com.example.huanpet.utils.jsonurluntils.Md5Encrypt;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity {
    private EditText unser_number;
    private EditText user_password;
    private TextView user_format;
    private Button bt_login;
    private LinearLayout login_QQ;
    private LinearLayout login_Chat;
    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            String data = (String) msg.obj;
            try {
                JSONObject object = new JSONObject(data);
                Log.e("handleMessage: ", data);
                if (object.getBoolean("ret")) {
                    UserDao dao = new UserDao();
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    dao.setUsername("李二狗子");
                    dao.setPhone(getUserName());
                    MyAppAlication.getMyApp().getDaoSession().getUserDaoDao().insert(dao);
                    getEditor().putBoolean("isLogin", true).commit();
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, object.getString("desc"), Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }
    });

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

        startActivity(new Intent(LoginActivity.this, RegistActivity.class));
    }

    @Override
    protected void intentUser() {

    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.bt_login:
                login();
                break;
            case R.id.login_QQ:

                break;
            case R.id.login_Chat:

                break;
            case R.id.user_format:

                break;
        }
    }

    //获取用户名
    public String getUserName() {
        return unser_number.getText().toString();
    }

    //获取用户密码
    public String getUserPassword() {
        return user_password.getText().toString();
    }
//            JSONObject result = object.getJSONObject("result");
//            dao.setUsername(result.getString("userName"));
//            dao.setPhone(result.getString("userPhone"));
//            dao.setUsernumber(result.getString("userId"));

    public void login() {

        if (getUserPassword().isEmpty()) {
            Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (getUserName().isEmpty()) {
            Toast.makeText(LoginActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String, Object> param = new HashMap<>();
        param.put("userName", getUserName());
        param.put("password", Md5Encrypt.md5(getUserPassword() + "1", "UTF-8"));
        CJSON.getData(this, "user/login.jhtml", param, mHandler);
    }


}
