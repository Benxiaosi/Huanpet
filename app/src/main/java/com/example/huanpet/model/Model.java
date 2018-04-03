package com.example.huanpet.model;



import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.example.huanpet.model.net.NetWorkCallBack;
import com.example.huanpet.utils.jsonurluntils.CJSON;
import com.example.huanpet.view.activity.login.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by Administrator on 2018/3/2.
 */

public class Model implements ILoginModel{
    private NetWorkCallBack netWorkCallBack;
    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            String data = (String) msg.obj;
            try {
                JSONObject object = new JSONObject(data);
                Log.e("handleMessage: ", data);
                if (object.getBoolean("ret")) {
                    netWorkCallBack.onSuccess("666");
                } else {
                  netWorkCallBack.onError(object.getString("desc"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }
    });
    @Override
    public void saveUserInfo(Object userInfo) {


//        s


    }

    @Override
    public  void Login(Context con,String url, Map<String,Object> map , NetWorkCallBack callBack) {
    //执行网络请求
        netWorkCallBack = callBack;
        CJSON.getData(con, "user/login.jhtml", map, mHandler);

    }






}
