package com.example.huanpet.view.activity.setting;

import android.widget.LinearLayout;

import com.example.huanpet.R;
import com.example.huanpet.base.BaseActivity;

public class SettingActivity extends BaseActivity {

    private LinearLayout sugges;
    private LinearLayout new_function;
    private LinearLayout gotoscore;
    private LinearLayout about_huanhuan;
    private LinearLayout WlFl_under;
    private LinearLayout pictaer_cach;
    private LinearLayout clear_cache;



    @Override
    protected void initData() {

    }

    @Override
    protected void initview() {
        //返回按钮
        showBack(true);
        showTitle(true);
        setTitle("设置");
        showDetermine(false);

        showSouText(false);
        showMap(false);
        showUser(false);
        //showDetermine
        //确定按钮
        //showDetermine();
        initView();
    }

    @Override
    public int getlayoutID() {
        return R.layout.activity_setting;
    }

    @Override
    protected void doDetermine() {

    }

    @Override
    protected void intentUser() {

    }

    private void initView() {
        sugges = (LinearLayout) findViewById(R.id.sugges);
        new_function = (LinearLayout) findViewById(R.id.new_function);
        gotoscore = (LinearLayout) findViewById(R.id.gotoscore);
        about_huanhuan = (LinearLayout) findViewById(R.id.about_huanhuan);
        WlFl_under = (LinearLayout) findViewById(R.id.wlfl_under);
        pictaer_cach = (LinearLayout) findViewById(R.id.pictaer_cach);
        clear_cache = (LinearLayout) findViewById(R.id.clear_cache);
    }
}
