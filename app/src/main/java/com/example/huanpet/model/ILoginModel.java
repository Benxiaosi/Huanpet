package com.example.huanpet.model;



import android.content.Context;

import com.example.huanpet.model.net.NetWorkCallBack;

import java.util.Map;

/**
 * Created by Administrator on 2018/3/2.
 */

public interface ILoginModel {

 void  saveUserInfo(Object userInfo);


  void   Login(Context con,String url, Map<String, Object> map, NetWorkCallBack callBack);

}
