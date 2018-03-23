package com.example.huanpet.model.net;

import android.util.Log;


import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by Administrator on 2018/3/2.
 */

public class OkHttpUtils implements IOkhttp{

    private static  OkHttpUtils okHttpUtils;

    private OkHttpClient okHttpClien;




    private OkHttpUtils(){


        okHttpClien = new OkHttpClient.Builder().build();

    }

    public static OkHttpUtils getInstance() {
        if(okHttpUtils==null){
            synchronized (OkHttpUtils.class){
                if(okHttpUtils==null){
                    okHttpUtils = new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;

    }





    @Override
    public <T> void get(String url, Map<String, String> map, final NetWorkCallBack<T> callback) {

        StringBuffer bf = new StringBuffer(url);
        bf.append("?");
        for (String str : map.keySet()){
            bf.append(str).append("=").append(map.get(str)).append("&");
        }

       url  =  bf.substring(0,bf.length()-1);

        Request request = new Request.Builder().url(url).build();

        okHttpClien.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();


                Gson gson = new Gson();
                Type   tt = ((ParameterizedType)callback.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
                T t =  gson.fromJson(result,tt);

                callback.onSuccess(t);
            }
        });
    }

    @Override
    public <T> void post(String url, Map<String, String> map, final NetWorkCallBack<T> callback) {


        FormBody.Builder body = new FormBody.Builder();
        for(String str : map.keySet()){
            body.add(str,map.get(str));
        }
//        FormBody formbody = ;
        Request request= new Request.Builder().url(url).post(body.build()).build();


        okHttpClien.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();

                Gson gson = new Gson();

                Log.e("TAG","登录返回信息===="+result);


              Type[] tt =   callback.getClass().getGenericInterfaces();

              Type[] tp =   ((ParameterizedType)tt[0]).getActualTypeArguments();
                Type t = tp[0];

              T tr =  gson.fromJson(result,t);

                callback.onSuccess(tr);

            }
        });

    }
}
