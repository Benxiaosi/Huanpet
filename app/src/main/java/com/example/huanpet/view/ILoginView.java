package com.example.huanpet.view;

/**
 * Created by Administrator on 2018/3/2.
 */

public interface ILoginView {


    void LoginSuccess(Object obj);

    void LoginFailure();

   String  getUserName();

    String getPassWord();

//    登录按钮
   void login();

//    显示进度条
    void showPop();
//关闭进度条
    void dissPop();



}
