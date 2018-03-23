package com.example.huanpet.app;

import android.app.Application;

import com.example.administrator.mvp.utils.LogUtil;
import com.orhanobut.logger.BuildConfig;

/**
 * Created by Administrator on 2018/3/2.
 */

public class MyAppAlication extends Application{

//全局异常捕获
//    应用报错了额，    退出了  ，
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.init(BuildConfig.DEBUG);
    }
}
