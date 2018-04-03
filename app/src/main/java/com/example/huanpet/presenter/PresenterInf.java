package com.example.huanpet.presenter;


import android.content.Context;

import com.example.huanpet.model.ILoginModel;
import com.example.huanpet.model.Model;
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
    public void login(Context con, String url, Map<String,Object> map){

    iLoginModel.Login(con,url, map, new NetWorkCallBack() {
        @Override
        public void onError(String error) {
            loginView.LoginFailure(error);
        }
        @Override
        public void onSuccess(String obj) {

            loginView.LoginSuccess(obj);
        }
    });

}





}
