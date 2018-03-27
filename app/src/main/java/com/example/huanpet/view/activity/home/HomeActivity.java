package com.example.huanpet.view.activity.home;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.huanpet.R;
import com.example.huanpet.base.BaseActivity;
import com.example.huanpet.view.activity.login.LoginActivity;
import com.example.huanpet.view.activity.need.NeedActivity;
import com.example.huanpet.view.activity.news.NewsActivity;
import com.example.huanpet.view.activity.order.OrderActivity;
import com.example.huanpet.view.activity.pet.PetActivity;
import com.example.huanpet.view.activity.setting.SettingActivity;
import com.example.huanpet.view.activity.user.UserActivity;
import com.example.huanpet.view.activity.wallet.WalletActivity;

/**
 * 首页
 */
public class HomeActivity extends BaseActivity {


    private FrameLayout v4_drawerlayout_frame;
    private LinearLayout v4_listview;
    private DrawerLayout dra;
    private LinearLayout liner2;
    private SharedPreferences.Editor editor;
    private SharedPreferences share;
    private ImageView user_img;
    private TextView user_name;
    private TextView user_phone;
    private TextView user_enter;
    private LinearLayout login;
    private LinearLayout news;
    private LinearLayout pet;
    private LinearLayout order;
    private LinearLayout wallet;
    private LinearLayout need;
    private LinearLayout setting;
    private Button is_sure;

    @Override
    protected void initData() {
        liner2.setVisibility(View.GONE);
        dra.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                showTitleText(false);
                liner2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                showTitleText(true);
                liner2.setVisibility(View.GONE);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    protected void initview() {
        v4_drawerlayout_frame = findViewById(R.id.v4_drawerlayout_frame);
        v4_listview = findViewById(R.id.v4_listview);
        dra = findViewById(R.id.drawer);
        liner2 = findViewById(R.id.liner2);
        editor = getEditor();
        share = getShare();
        user_img = findViewById(R.id.user_img);
        user_name = findViewById(R.id.user_name);
        user_img = findViewById(R.id.user_img);
        user_phone = findViewById(R.id.user_phone);
        user_enter = findViewById(R.id.user_enter);
        login = findViewById(R.id.login);
        news = findViewById(R.id.news);
        pet = findViewById(R.id.pet);
        order = findViewById(R.id.order);
        wallet = findViewById(R.id.wallet);
        need = findViewById(R.id.need);
        setting = findViewById(R.id.setting);
        is_sure = findViewById(R.id.is_sure);
        login.setOnClickListener(this);
        pet.setOnClickListener(this);
        wallet.setOnClickListener(this);
        need.setOnClickListener(this);
        setting.setOnClickListener(this);
        is_sure.setOnClickListener(this);
        news.setOnClickListener(this);
        order.setOnClickListener(this);



    }

    @Override
    public int getlayoutID() {
        return R.layout.activity_home;
    }

    @Override
    protected void doDetermine() {

    }

    @Override
    protected void intentUser() {
        dra.openDrawer(Gravity.LEFT);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.login:
                if (share.getBoolean("isLogin",false)){
                    startActivity(new Intent(this, UserActivity.class));
                }else {
                    startActivity(new Intent(this, LoginActivity.class));
                }

                break;
            case R.id.news:
                startActivity(new Intent(this, NewsActivity.class));
                break;
            case R.id.pet:
                startActivity(new Intent(this, PetActivity.class));
                break;
            case R.id.order:
                startActivity(new Intent(this, OrderActivity.class));
                break;
            case R.id.wallet:
                startActivity(new Intent(this, WalletActivity.class));
                break;
            case R.id.need:
                startActivity(new Intent(this, NeedActivity.class));
                break;
            case R.id.setting:
                startActivity(new Intent(this, SettingActivity.class));
                break;
            case R.id.is_sure:
                break;
        }
    }


}
