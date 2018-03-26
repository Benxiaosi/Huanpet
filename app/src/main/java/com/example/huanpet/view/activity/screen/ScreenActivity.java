package com.example.huanpet.view.activity.screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.huanpet.R;
import com.example.huanpet.base.BaseActivity;
/**
 * 筛选Activity
 */
public class ScreenActivity extends BaseActivity {

    @Override
    protected void initData() {

    }

    @Override
    protected void initview() {
        showBack(true);
        showTitle(true);
        setTitle("城市筛选");
        showDetermine(true);
        showSouText(false);
        showMap(false);
        showUser(false);

    }

    @Override
    public int getlayoutID() {
        return R.layout.activity_screen;
    }

    @Override
    protected void doDetermine() {

    }

    @Override
    protected void intentUser() {

    }
}
