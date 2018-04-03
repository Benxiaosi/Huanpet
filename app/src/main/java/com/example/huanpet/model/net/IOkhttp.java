package com.example.huanpet.model.net;

import java.util.Map;

/**
 * Created by Administrator on 2018/3/2.
 */

public interface  IOkhttp {


    void get(String url, Map<String, String> map, NetWorkCallBack callback);

     void post(String url, Map<String, String> map, NetWorkCallBack callback);

}
