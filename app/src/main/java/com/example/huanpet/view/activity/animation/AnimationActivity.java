package com.example.huanpet.view.activity.animation;
/**
 * 动画界面
 */

import com.example.huanpet.R;
import com.example.huanpet.base.BaseActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.huanpet.base.BaseActivity;
import com.example.huanpet.view.activity.home.HomeActivity;
import com.example.huanpet.view.adapter.PageAdapter;

import java.util.ArrayList;

public class AnimationActivity extends AppCompatActivity {


    private ViewPager vp_animation;
    private SharedPreferences share;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initData();
    }

    protected void initData() {
        if (share.getBoolean("isShow", true)) {
            ArrayList<ImageView> img = new ArrayList<>();
            ImageView view = new ImageView(this);
            view.setImageResource(R.mipmap.pager01);
            img.add(view);
            ImageView view2 = new ImageView(this);
            view2.setImageResource(R.mipmap.pager02);
            img.add(view2);
            ImageView view3 = new ImageView(this);
            view3.setImageResource(R.mipmap.pager03);
            img.add(view3);
            PageAdapter adapter = new PageAdapter(img);
            vp_animation.setAdapter(adapter);
            view3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editor.putBoolean("isShow", false).commit();
                    startActivity(new Intent(AnimationActivity.this, HomeActivity.class));
                    finish();
                }
            });
        } else {
            startActivity(new Intent(AnimationActivity.this, ShowActivity.class));
            finish();

        }
    }

    protected void initview() {
        share = getSharedPreferences("donghua", MODE_PRIVATE);
        editor = share.edit();
        vp_animation = findViewById(R.id.vp_animation);
    }


}
