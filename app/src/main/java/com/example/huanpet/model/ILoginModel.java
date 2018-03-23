package com.example.huanpet.model;



import com.example.huanpet.model.bean.UserInfo;
import com.example.huanpet.model.net.NetWorkCallBack;

import java.util.Map;

/**
 * Created by Administrator on 2018/3/2.
 */

public interface ILoginModel {

 void  saveUserInfo(UserInfo userInfo);


 <T> void   Login(String url, Map<String, String> map, NetWorkCallBack<T> callBack);

}
