package com.example.huanpet.view.activity.home;


import android.view.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.huanpet.R;
import com.example.huanpet.base.BaseActivity;
import com.example.huanpet.utils.OkHttpUtls;
import com.example.huanpet.view.ILoginView;
import com.example.huanpet.view.activity.screen.ScreenActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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




    private RecyclerView recy_home_Page;
    private RecyclerView recy_home_Page1;


    private ListView list_home_Page;

    //附近
    private TextView nearby_homePage;
    //宠物
    private TextView animal_homePage;
    //筛选
    private TextView screen_homePage;


    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    //选择其他城市
    private ImageView choice;

    private LinearLayout shaixuan_homePage;
    private LinearLayout shaixuan_homePage1;
    private LinearLayout lin;

    private List<String> nearList;
    private List<String> animalList;
    private Boolean aBoolean = true;
    private String[] near = {"附近优先", "好评优先", "订单优先", "价格从高到低", "价格从低到高"};
    private String[] animal = {"小型犬", "中型犬", "大型犬", "猫", "小宠", "幼犬"};


    private String url = "http://123.56.150.230:8885/dog_family/users/getUsersInfoByVO.jhtml";
    private SharedPreferences share;
    private PopupWindow window;


    private View recyInflate1;
    private View listInflate;


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


        getURL();



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




        recy_home_Page = (RecyclerView) findViewById( R.id.recy_home_Page );

        nearby_homePage = (TextView) findViewById( R.id.nearby_homePage );
        animal_homePage = (TextView) findViewById( R.id.animal_homePage );
        screen_homePage = (TextView) findViewById( R.id.screen_homePage );
        img1 = (ImageView) findViewById( R.id.img1 );
        img2 = (ImageView) findViewById( R.id.img2 );
        img3 = (ImageView) findViewById( R.id.img3 );

        shaixuan_homePage = (LinearLayout) findViewById( R.id.shaixuan_homePage );
        choice = (ImageView) findViewById( R.id.choice );

        choice.setOnClickListener( this );
        nearby_homePage.setOnClickListener( this );
        animal_homePage.setOnClickListener( this );
        screen_homePage.setOnClickListener( this );
        share = getShare();
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
        super.onClick( v );

        switch (v.getId()) {

            case R.id.nearby_homePage:
                setNearby_homePageJT();
                break;
            case R.id.animal_homePage:
                animalJT();
                break;
            case R.id.screen_homePage:
                shaixuanJT();
                break;
            case R.id.choice:
                choiceJT();
                break;
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

    public void getURL() {
        Map<String, String> headMap = new HashMap<>();
        Map<String, String> bodyMap = new HashMap<>();
        headMap.put( "channel", "android" );
        headMap.put( "ip", "172.28.119.4" );
        headMap.put( "sign", "B2754A38A5D5027F49424934A8DF5752" );
        headMap.put( "token", "96F65F14C026230FD1D097C435964E0E" );

        bodyMap.put( "beginIndex", "0" );
        bodyMap.put( "endIndex", "10" );

        bodyMap.put( "orderBy", near[0] );

        bodyMap.put( "coordX", share.getString( "latitude", "39.92" ) );
        bodyMap.put( "coordY", share.getString( "longitude", "116.46" ) );

        OkHttpUtls.getInstance().getOk( url, headMap, bodyMap );



    }

    public void animalJT() {
        if (aBoolean) {
            aBoolean = false;
            View recyInflate1 = LayoutInflater.from( HomeActivity.this ).inflate( R.layout.item2_recy, null );
            listInflate = LayoutInflater.from( HomeActivity.this ).inflate( R.layout.popup_homepage1, null );
            list_home_Page = (ListView) listInflate.findViewById( R.id.list_home_Page );

            PopupWindow window = new PopupWindow( listInflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, false );
            window.setFocusable( true );
            window.setBackgroundDrawable( new BitmapDrawable() );
            window.showAsDropDown( recyInflate1, 0, 250 );

            list_home_Page.setVisibility( View.VISIBLE );
            img2.setBackgroundResource( R.mipmap.up_arrow );
            animalList = new ArrayList<>();
            for (int i = 0; i < animal.length; i++) {
                animalList.add( animal[i] );
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>( HomeActivity.this, android.R.layout.simple_expandable_list_item_1, animalList );
            list_home_Page.setAdapter( adapter );
            recy_home_Page.setBackgroundResource( R.color.istrue );

            window.setOnDismissListener( new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
//                            window.dismiss();
                    img2.setBackgroundResource( R.mipmap.down_arrow );
                    recy_home_Page.setBackgroundResource( R.color.isfalse );
                    aBoolean = true;
                }
            } );

        } else {
            window.dismiss();
            img1.setBackgroundResource( R.mipmap.down_arrow );
            recy_home_Page.setBackgroundResource( R.color.isfalse );
            aBoolean = true;
        }
    }

    public void setNearby_homePageJT() {
        if (aBoolean) {
            aBoolean = false;
            recyInflate1 = LayoutInflater.from( HomeActivity.this ).inflate( R.layout.item2_recy, null );
            listInflate = LayoutInflater.from( HomeActivity.this ).inflate( R.layout.popup_homepage1, null );
            list_home_Page = (ListView) listInflate.findViewById( R.id.list_home_Page );

            window = new PopupWindow( listInflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, false );
            window.setFocusable( true );
            window.setBackgroundDrawable( new BitmapDrawable() );
            window.showAsDropDown( recyInflate1, 0, 250 );

            list_home_Page.setVisibility( View.VISIBLE );
            img1.setBackgroundResource( R.mipmap.up_arrow );
            nearList = new ArrayList<>();
            for (int i = 0; i < near.length; i++) {
                nearList.add( near[i] );
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>( HomeActivity.this, android.R.layout.simple_expandable_list_item_1, nearList );
            list_home_Page.setAdapter( adapter );
            recy_home_Page.setBackgroundResource( R.color.istrue );

            window.setOnDismissListener( new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
//                            window.dismiss();
                    img1.setBackgroundResource( R.mipmap.down_arrow );
                    recy_home_Page.setBackgroundResource( R.color.isfalse );
                    aBoolean = true;
                }
            } );

        } else {
            window.dismiss();
            img1.setBackgroundResource( R.mipmap.down_arrow );
            recy_home_Page.setBackgroundResource( R.color.isfalse );
            aBoolean = true;
        }
    }

    public void shaixuanJT() {
        View inflate = LayoutInflater.from( HomeActivity.this ).inflate( R.layout.item2_recy, null );

        lin = (LinearLayout) inflate.findViewById( R.id.lin );
        recy_home_Page1 = (RecyclerView) inflate.findViewById( R.id.recy_home_Page );


        if (aBoolean) {
            lin.setVisibility( View.GONE );
            shaixuan_homePage.setVisibility( View.VISIBLE );
            img3.setBackgroundResource( R.mipmap.up_arrow );
            aBoolean = false;
        } else {
            lin.setVisibility( View.VISIBLE );
            shaixuan_homePage.setVisibility( View.GONE );
            img3.setBackgroundResource( R.mipmap.down_arrow );
            aBoolean = true;
        }
    }
    public void choiceJT(){
        Intent intent = new Intent( HomeActivity.this, ScreenActivity.class );
        startActivityForResult( intent,200 );
    }

           
        }
    }



}
