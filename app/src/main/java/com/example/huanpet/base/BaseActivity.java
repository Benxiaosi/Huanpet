package com.example.huanpet.base;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.example.huanpet.R;
import com.example.huanpet.utils.mapdemo.ToastUtil;
import com.example.huanpet.view.activity.map.MapActivity;


/**
 * Created by Administrator on 2018/3/2.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView user;
    private TextView back;
    private TextView title;
    private LinearLayout sou;
    private TextView determine;
    private TextView map;
    private FrameLayout layout_content;
    private EditText ed_sou;
    private LatLonPoint mEndLat;
    private GeocodeSearch mEnd;
    private LinearLayout liner;
    private LinearLayout base_lin;
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

        setInvasion();

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
        ed_sou = (EditText) findViewById(R.id.ed_sou);
        user.setOnClickListener(this);
        back.setOnClickListener(this);
        determine.setOnClickListener(this);
        sou.setOnClickListener(this);
        map.setOnClickListener(this);
        liner = (LinearLayout) findViewById(R.id.liner);
        base_lin = (LinearLayout) findViewById(R.id.base_lin);
        layout_content = (FrameLayout) findViewById(R.id.layout_content);
        mEnd = new GeocodeSearch(this);
        ed_sou.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = getText();
                setTitleToShare(text);
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
    }

    //通过地名获取经纬度，保存在Share
    public void setTitleToShare(String title) {
        GeocodeQuery query = new GeocodeQuery(title, null);
        mEnd.getFromLocationNameAsyn(query);
        mEnd.setOnGeocodeSearchListener(new GeocodeSearch.OnGeocodeSearchListener() {
            @Override
            public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {

            }

            @Override
            public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
                GeocodeAddress geocodeAddress = geocodeResult.getGeocodeAddressList().get(0);
                mEndLat = geocodeAddress.getLatLonPoint();

                Log.e("看看结尾经纬度", "经度是：" + mEndLat.getLongitude() + ",纬度是：" + mEndLat.getLatitude());
                //精度
                getEditor().putString("longitude", mEndLat.getLongitude() + "").commit();
                //纬度
                getEditor().putString("latitude", mEndLat.getLatitude() + "").commit();


            }
        });
    }

    //获取EditText输入内容
    public String getText() {
        String s = ed_sou.getText().toString();
        if (TextUtils.isEmpty(s)) {
            Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
            return "";
        } else {
            return s;
        }
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

    //是否显示标题框
    protected void showTitleText(boolean show) {
        if (liner != null) {
            if (show) {
                liner.setVisibility(View.VISIBLE);
            } else {
                liner.setVisibility(View.GONE);
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

    //
    public void setTitle(String str) {
        title.setText(str);
    }

    //设置确认按钮内容
    public void setDetermine(int titleId) {
        determine.setText(titleId);
    }

    public void setDetermine(String str) {
        determine.setText(str);
    }

    //是否显示确认按钮
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

    //取出FrameLayout并调用父类removeAllViews()方法
    @Override
    public void setContentView(int layoutResID) {
        layout_content.removeAllViews();
        View.inflate(this, layoutResID, layout_content);
        onContentChanged();
    }

    @Override
    public void setContentView(View view) {
        layout_content.removeAllViews();
        layout_content.addView(view);
        onContentChanged();
    }

    /* (non-Javadoc)
     * @see android.app.Activity#setContentView(android.view.View, android.view.ViewGroup.LayoutParams)
     */
    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        layout_content.removeAllViews();
        layout_content.addView(view, params);
        onContentChanged();
    }

    //嵌入状态栏
    private void setInvasion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    //点击监听
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //点击跳转地图Activity
            case R.id.map:
                intentMap();
                break;
            //点击弹出侧滑菜单
            case R.id.user:
                intentUser();
                break;
            //返回按钮
            case R.id.back:
                finish();
                break;
            //确定按钮
            case R.id.determine:
                doDetermine();
                break;

        }

    }

    //确定方法
    protected abstract void doDetermine();

    //跳转地图Activity方法
    protected void intentMap() {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }


    //弹出侧滑菜单方法
    protected abstract void intentUser();

    //设置背景颜色
    public void setBackGround(int drawable) {
        base_lin.setBackgroundResource(drawable);
    }

    protected void onDestroy() {
        super.onDestroy();
        //用完回调要注销掉，否则可能会出现内存泄露

    }


}
