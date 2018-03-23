package com.example.huanpet.model.net;

import java.util.Map;

/**
 * Created by Administrator on 2018/3/2.
 */

public interface  IOkhttp {


   <T> void get(String url, Map<String, String> map, NetWorkCallBack<T> callback);

    <T> void post(String url, Map<String, String> map, NetWorkCallBack<T> callback);

}
