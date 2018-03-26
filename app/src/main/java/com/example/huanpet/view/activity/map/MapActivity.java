package com.example.huanpet.view.activity.map;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.huanpet.R;
import com.example.huanpet.base.BaseActivity;

public class MapActivity extends BaseActivity {

    @Override
    protected void initData() {

    }

    @Override
    protected void initview() {
        showBack(true);
        showTitle(true);
        setTitle("城市选择");
        showDetermine(true);
        showSouText(false);
        showMap(false);
        showUser(false);
    }

    @Override
    public int getlayoutID() {
        return R.layout.activity_map;
    }

    @Override
    protected void doDetermine() {

    }

    @Override
    protected void intentUser() {

    }
}
