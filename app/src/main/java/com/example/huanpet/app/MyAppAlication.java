package com.example.huanpet.app;

import android.app.Application;

import com.example.huanpet.model.bean.DaoMaster;
import com.example.huanpet.model.bean.DaoSession;


/**
 * Created by Administrator on 2018/3/2.
 */

public class MyAppAlication extends Application{

//全局异常捕获
//    应用报错了额，    退出了  ，
private static MyAppAlication mApp;
    private DaoSession mDaoSession;

    public static MyAppAlication getMyApp() {
        return mApp;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
//        AbAppConfig.UI_WIDTH = 1080;
//        AbAppConfig.UI_HEIGHT = 700;
        createDataBase();
    }

    /**
     * 1、DevOpenHelper：创建SQLite数据库的SQLiteOpenHelper的具体实现。
     2、DaoMaster：GreenDao的顶级对象，作为数据库对象、用于创建表和删除表。
     3、DaoSession：管理所有的Dao对象，Dao对象中存在着增删改查等API。
     */
    private void createDataBase(){
        //创建数据库
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(mApp,"stu");
        //用数据库框架进行包装
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
        //提供一个Session
        mDaoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession(){
        return mDaoSession;
    }
}
