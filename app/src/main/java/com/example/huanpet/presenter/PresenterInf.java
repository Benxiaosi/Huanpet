package com.example.huanpet.presenter;

import android.util.Log;


import com.example.huanpet.model.ILoginModel;
import com.example.huanpet.model.Model;
import com.example.huanpet.model.bean.UserInfo;
import com.example.huanpet.model.net.NetWorkCallBack;
import com.example.huanpet.view.ILoginView;

import java.util.Map;

/**
 * Created by Administrator on 2018/3/2.
 */
public class PresenterInf implements Persenter{
//    P层需要持有View层和Model层的对象接口

   private ILoginView loginView;

    private ILoginModel iLoginModel;

    public PresenterInf(ILoginView loginView){

        this.loginView = loginView;

        iLoginModel = new Model();
    }
    @Override
    public void login(String url, Map<String,String> map){

    iLoginModel.Login(url, map, new NetWorkCallBack<UserInfo>() {
        @Override
        public void onError(String error) {
            loginView.LoginFailure();
        }
        @Override
        public void onSuccess(UserInfo userInfo) {

            Log.e("TAG","登录请求结果解析====="+userInfo.toString());

            loginView.LoginSuccess();
        }
    });

}





}
