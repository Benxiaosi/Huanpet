package com.example.huanpet.view.activity.news;

import android.support.v7.widget.RecyclerView;

import com.example.huanpet.R;
import com.example.huanpet.base.BaseActivity;

public class NewsActivity extends BaseActivity {


    private RecyclerView news;

    @Override
    protected void initData() {

    }

    @Override
    protected void initview() {
        //返回按钮
        showBack(true);
        showTitle(true);
        setTitle("消息");
        showDetermine(false);

        showSouText(false);
        showMap(false);
        showUser(false);

        news = findViewById(R.id.rv_news);


    }

    @Override
    public int getlayoutID() {
        return R.layout.activity_news;
    }

    @Override
    protected void doDetermine() {

    }

    @Override
    protected void intentUser() {

    }
}
