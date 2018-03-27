package com.example.huanpet.view.activity.animation;
/**
 * 动画界面
 */

import com.example.huanpet.R;
import com.example.huanpet.base.BaseActivity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
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
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        if (requestCode == 0){
            //由于只有一个权限 所以这边可以直接获取第一个就好了
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //被用户允许  进行下一步
                editor.putBoolean("isShow", false).commit();
                startActivity(new Intent(AnimationActivity.this, HomeActivity.class));
                finish();
            }else{
                //被用户拒绝  进行后续逻辑
                //如 打开软件设置让用户自己设置
                Intent intent = new Intent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", getPackageName(), null));
                startActivity(intent);
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
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
                    if(ActivityCompat.checkSelfPermission(AnimationActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION )
                            != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(AnimationActivity.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION },0);
                    }else{
                        //权限以获取 进行下一步
                        editor.putBoolean("isShow", false).commit();
                        startActivity(new Intent(AnimationActivity.this, HomeActivity.class));
                        finish();
                    }

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
