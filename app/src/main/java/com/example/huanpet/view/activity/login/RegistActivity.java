package com.example.huanpet.view.activity.login;

import android.os.Handler;
import android.os.Message;
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
import com.example.huanpet.utils.MyCountDownTimer;
import com.example.huanpet.utils.jsonurluntils.CJSON;
import com.example.huanpet.utils.jsonurluntils.Md5Encrypt;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class RegistActivity extends BaseActivity {

    private EditText regist_phoneNum;
    private TextView regist_verification;
    private EditText regist_phone_code;
    private EditText regist_password;
    private EditText regist_sixPass;
    private Button bt_regist;
    private LinearLayout regist_QQ;
    private LinearLayout regist_Chat;
    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            String data = (String) msg.obj;
            try {
                JSONObject object = new JSONObject(data);
                Log.e( "handleMessage: ", data);
                if (object.getBoolean("ret")) {
                    Toast.makeText(RegistActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
//                    getEditor().putBoolean("isLogin", true).commit();
                    finish();
                } else {
                    Toast.makeText(RegistActivity.this, object.getString("desc"), Toast.LENGTH_SHORT).show();
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
        regist_verification.setOnClickListener(this);
        bt_regist.setOnClickListener(this);
        regist_Chat.setOnClickListener(this);
        regist_QQ.setOnClickListener(this);

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
                setRegist();
                break;
            case R.id.regist_verification:
                getVerification();
                break;
            case R.id.regist_Chat:
                loginChat();
                break;
            case R.id.regist_QQ:
                loginChat();
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

    //获取用户名
    public String getUserName() {
        return regist_password.getText().toString();
    }

    //获取用户密码
    public String getUserPassword() {
        return regist_sixPass.getText().toString();
    }

    //获取验证码
    public String getYanData() {
        return regist_verification.getText().toString();
    }

    public void getVerification() {
        String phone = getPhone();
        if (phone.isEmpty()) {
            Toast.makeText(RegistActivity.this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!phone.matches("^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$")) {
            Toast.makeText(RegistActivity.this, "手机号码不合法", Toast.LENGTH_SHORT).show();
            return;
        }
        MyCountDownTimer downTimer = new MyCountDownTimer(60000, 1000, regist_verification);
        downTimer.start();
    }

    public void setRegist() {
        String phone = getPhone();
        if (phone.isEmpty()) {
            Toast.makeText(RegistActivity.this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!phone.matches("^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$")) {
            Toast.makeText(RegistActivity.this, "手机号码不合法", Toast.LENGTH_SHORT).show();
            return;
        }
        if (getUserPassword().isEmpty()) {
            Toast.makeText(RegistActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (getUserName().isEmpty()) {
            Toast.makeText(RegistActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!getUserPassword().matches("[a_z_A_Z_0-9]{6}$")) {
            Toast.makeText(RegistActivity.this, "密码格式不合法", Toast.LENGTH_SHORT).show();
            return;
        }

        Map<String, Object> param = new HashMap<>();
        param.put("userPhone", getPhone());
        param.put("userName", getUserName());
        param.put("password", Md5Encrypt.md5(getUserPassword() + "1", "UTF-8"));
        CJSON.getData(this, "user/register.jhtml", param, mHandler);
    }

    public void loginChat() {
        String phone = getPhone();
        if (phone.isEmpty()) {
            Toast.makeText(RegistActivity.this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!phone.matches("^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$")) {
            Toast.makeText(RegistActivity.this, "手机号码不合法", Toast.LENGTH_SHORT).show();
            return;
        }
        if (getUserPassword().isEmpty()) {
            Toast.makeText(RegistActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (getUserName().isEmpty()) {
            Toast.makeText(RegistActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!getUserPassword().matches("[a_zA_Z0-9]{6}$")) {
            Toast.makeText(RegistActivity.this, "密码格式不合法", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String, Object> param = new HashMap<>();
        param.put("userPhone", getPhone());
        param.put("userName", getUserName());
        param.put("password", Md5Encrypt.md5(getUserPassword() + "1", "UTF-8"));
        param.put("userImage", "http://q.qlogo.cn/qqapp/100371282/B368CC7246CC4A360C4305F64FE9173A/40");
        param.put("threeId", Md5Encrypt.md5(964099827 + "1", "UTF-8"));
        CJSON.getData(this, "user/register.jhtml", param, mHandler);
    }
}
