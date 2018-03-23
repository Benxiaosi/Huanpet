package com.example.huanpet.model;



import com.example.huanpet.model.bean.UserInfo;
import com.example.huanpet.model.net.NetWorkCallBack;
import com.example.huanpet.model.net.OkHttpUtils;

import java.util.Map;

/**
 * Created by Administrator on 2018/3/2.
 */

public class Model implements ILoginModel{

    @Override
    public void saveUserInfo(UserInfo userInfo) {


//        s


    }

    @Override
    public <T> void Login(String url, Map<String,String> map , NetWorkCallBack<T> callBack) {
    //执行网络请求
        OkHttpUtils.getInstance().post(url,map,callBack);

    }






}
