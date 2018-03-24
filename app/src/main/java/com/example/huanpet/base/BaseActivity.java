package com.example.huanpet.base;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.huanpet.R;

/**
 * Created by Administrator on 2018/3/2.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private TextView user;
    private TextView back;
    private TextView title;
    private LinearLayout sou;
    private TextView determine;
    private TextView map;
    private FrameLayout layout_content;

//    模板模式

    //都会有一些相同的操作     findviewbyid
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置标题栏
        setUpView();

        setContentView(getlayoutID());


        //设置屏幕适配
        setScreenAdaptation();


        initview();

        initData();

    }

    protected void setUpView() {
        super.setContentView(R.layout.activity_base);
        user = (TextView) findViewById(R.id.user);
        back = (TextView) findViewById(R.id.back);
        title = (TextView) findViewById(R.id.title);
        sou = (LinearLayout) findViewById(R.id.sou);
        determine = (TextView) findViewById(R.id.determine);
        map = (TextView) findViewById(R.id.map);
        layout_content = (FrameLayout) findViewById(R.id.layout_content);
    }

    //是否显示个人图标
    protected void showUser(boolean show) {
        if (user != null) {
            if (show) {
                user.setVisibility(View.VISIBLE);
            } else {
                user.setVisibility(View.GONE);
            }
        } // else ignored
    }

    //是否显示搜索框
    protected void showSouText(boolean show) {
        if (sou != null) {
            if (show) {
                sou.setVisibility(View.VISIBLE);
            } else {
                sou.setVisibility(View.GONE);
            }
        } // else ignored
    }

    //是否显示返回键
    protected void showBack(boolean show) {
        if (back != null) {
            if (show) {
                back.setVisibility(View.VISIBLE);
            } else {
                back.setVisibility(View.GONE);
            }
        } // else ignored
    }

    //是否显示地图键
    protected void showMap(boolean show) {
        if (map != null) {
            if (show) {
                map.setVisibility(View.VISIBLE);
            } else {
                map.setVisibility(View.GONE);
            }
        } // else ignored
    }

    //是否显示标题
    protected void showTitle(boolean show) {
        if (title != null) {
            if (show) {
                title.setVisibility(View.VISIBLE);
            } else {
                title.setVisibility(View.GONE);
            }
        } // else ignored
    }

    //设置标题内容
    public void setTitle(int titleId) {
        title.setText(titleId);
    }

    public void setTitle(String str) {
        title.setText(str);
    }
    //是否显示按钮
    protected void showDetermine(boolean show) {
        if (determine != null) {
            if (show) {
                determine.setVisibility(View.VISIBLE);
            } else {
                determine.setVisibility(View.GONE);
            }
        } // else ignored
    }

    //屏幕适配
    protected void setScreenAdaptation() {
        //获取封装当前手机屏幕信息对象，用于存放宽高值
        View view = LayoutInflater.from(this).inflate(getlayoutID(), null);

        DisplayMetrics metrics = new DisplayMetrics();

        //给当前屏幕设置宽高
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        //获取高度
        int heightPixels = metrics.heightPixels;

        //获取宽度
        int widthPixels = metrics.widthPixels;

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                (int) (widthPixels * 0.5 + 0.5),
                (int) (heightPixels * 0.5 + 0.5));

        view.setLayoutParams(layoutParams);


    }

    //获取SharedPreferences对象
    public SharedPreferences getShare() {
        return getSharedPreferences("huanpet", MODE_PRIVATE);
    }

    //获取Editor对象
    public SharedPreferences.Editor getEditor() {
        return getShare().edit();

    }

    protected abstract void initData();

    protected abstract void initview();


    public abstract int getlayoutID();

}
