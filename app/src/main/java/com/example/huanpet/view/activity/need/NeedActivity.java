package com.example.huanpet.view.activity.need;

import android.support.v7.widget.RecyclerView;

import com.example.huanpet.R;
import com.example.huanpet.base.BaseActivity;

public class NeedActivity extends BaseActivity {


    private RecyclerView need;

    @Override
    protected void initData() {
    }
    @Override
    protected void initview() {
        //返回按钮
        showBack(true);
        showTitle(true);
        setTitle("需知");
        showDetermine(false);
        showSouText(false);
        showMap(false);
        showUser(false);
        need = findViewById(R.id.rv_need);

    }

    @Override
    public int getlayoutID() {
        return R.layout.activity_need;
    }

    @Override
    protected void doDetermine() {

    }

    @Override
    protected void intentUser() {

    }
}
