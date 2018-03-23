package com.example.huanpet.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2018/3/2.
 */

public abstract  class BaseActivity extends AppCompatActivity{

//    模板模式

//都会有一些相同的操作     findviewbyid
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getlayoutID());

        initview();

        initData();

    }

    protected abstract void initData();

    protected abstract void initview();


    public abstract int getlayoutID();

}
