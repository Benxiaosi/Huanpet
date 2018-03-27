package com.example.huanpet.utils;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.util.Map;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by leon on 2018/3/26.
 */

public class OkHttpUtls {
    @SuppressLint("HandlerLeak")
    private Handler han = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage( msg );
            String str = (String) msg.obj;
            Log.e( "男神最爱小燕燕",str );

        }
    };
    private String s;
    private static final OkHttpUtls ourInstance = new OkHttpUtls();

    public static OkHttpUtls getInstance() {
        return ourInstance;
    }

    private OkHttpUtls() {

    }
    public void getOk(final String url, final Map<String,String>headMap, final Map<String,String>bodyMap){

        new Thread( new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                FormBody.Builder builder = new FormBody.Builder();

                for (String str:bodyMap.keySet()) {
                    builder.add( str,bodyMap.get( str ) );
                    Log.e( "nanann---------------",builder+"" );
                }
                FormBody build = builder.build();

                Request.Builder post = new Request.Builder().url( url ).post( build );
                for (String string : headMap.keySet()) {
                    post.addHeader( string,headMap.get( string ) );
                }
                Request build1 = post.build();
                okHttpClient.newCall( build1 ).enqueue( new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                        Log.e( "燕燕",e.toString() );
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        s = response.body().string();
                        han.obtainMessage( 100,s ).sendToTarget();
                    }
                } );
            }
        } ).start();


    }
//    public String getData(){
//        if (s != null){
//            Log.e( "楠楠",s );
//            return s;
//        }else {
//            return "";
//        }
//    }
}
