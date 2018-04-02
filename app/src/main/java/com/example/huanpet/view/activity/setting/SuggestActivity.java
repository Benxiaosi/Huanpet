package com.example.huanpet.view.activity.setting;

import com.example.huanpet.R;
import com.example.huanpet.base.BaseActivity;

public class SuggestActivity extends BaseActivity {


    @Override
    protected void initData() {

    }

    @Override
    protected void initview() {
        //返回按钮
        showBack(true);
        showTitle(true);
        setTitle("产品建议");
        showDetermine(false);

        showSouText(false);
        showMap(false);
        showUser(false);
        //showDetermine
        //确定按钮
        //showDetermine();
    }

    @Override
    public int getlayoutID() {
        return R.layout.activity_suggest;
    }

    @Override
    protected void doDetermine() {

    }

    @Override
    protected void intentUser() {

    }
}
