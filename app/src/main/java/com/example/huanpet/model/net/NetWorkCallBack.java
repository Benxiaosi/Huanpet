package com.example.huanpet.model.net;

/**
 * Created by Administrator on 2018/3/2.
 */

public interface NetWorkCallBack<T>{


    void onError(String error);


    void onSuccess(T t);


}
