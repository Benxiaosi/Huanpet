package com.example.huanpet.view.activity.user;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.huanpet.R;
public class UserActivity extends AppCompatActivity {
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.huanpet.R;
import com.example.huanpet.app.MyAppAlication;
import com.example.huanpet.base.BaseActivity;
import com.example.huanpet.model.bean.UserDaoDao;
import com.example.huanpet.model.greendao.UserDao;
import com.example.huanpet.view.activity.home.been.CircleImageView;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class UserActivity extends BaseActivity {

    private TextView user_name;
    private CircleImageView user_img;
    private TextView user_enter;
    private LinearLayout login;
    private LinearLayout touxiang;
    private TextView username;
    private LinearLayout nicheng;
    private TextView exit;
    private PopupWindow window;
    private Button bt_qu;
    private Button bt_xiang;
    private Button bt_pai;
    private String path;
    private String path1;
    private UserDaoDao dao;
    private int i;
    private List<UserDao> daos;

    @Override
    protected void initData() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTouXiang();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("isLogin", false).commit();
                dao.deleteAll();
                finish();
            }
        });
    }

    @Override
    protected void initview() {
        showBack(true);
        showTitle(true);
        setTitle("个人信息");
        showSouText(false);
        showMap(false);
        showUser(false);
        showDetermine(false);
        i = 1;
        user_name = (TextView) findViewById(R.id.user_name);
        user_img = (CircleImageView) findViewById(R.id.user_img);
        user_enter = (TextView) findViewById(R.id.user_enter);
        login = (LinearLayout) findViewById(R.id.login);
        dao = MyAppAlication.getMyApp().getDaoSession().getUserDaoDao();
        exit = findViewById(R.id.exit);
    }

    @Override
    public int getlayoutID() {
        return R.layout.activity_user;
    }

    @Override
    protected void doDetermine() {

    }

    @Override
    protected void intentUser() {

    }

    private void setData(View v) {
        bt_pai = v.findViewById(R.id.bt_pai);
        bt_qu = v.findViewById(R.id.bt_qu);
        bt_xiang = v.findViewById(R.id.bt_xiang);

    }

    public void setTouXiang() {
        View inflate = LayoutInflater.from(UserActivity.this).inflate(R.layout.item3, null);
        window = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setOutsideTouchable(true);
        window.setBackgroundDrawable(new BitmapDrawable());
        window.showAtLocation(inflate, Gravity.BOTTOM, 0, 0);
        setData(inflate);
        setLiener();
    }

    private void setLiener() {
        bt_pai.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                i++;
                path = getExternalCacheDir().getAbsolutePath() + File.separator + "img" + i + ".png";
                Intent intent3 = new Intent();
                intent3.setType("image/*");
                intent3.setAction(Intent.ACTION_GET_CONTENT);
                intent3.putExtra(Intent.EXTRA_PHONE_NUMBER, Uri.fromFile(new File(path)));
                startActivityForResult(intent3, 200);
                window.dismiss();
            }
        });
        bt_qu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
            }
        });
        bt_xiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                path1 = getExternalCacheDir().getAbsolutePath() + File.separator + "imga" + i + ".png";
                Intent intent2 = new Intent();
                intent2.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
//                向意图对象当中，传入指定的路径
                intent2.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(path1)));
                startActivityForResult(intent2, 300);
                window.dismiss();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        daos = dao.loadAll();
        UserDao load = daos.get(0);
        if (requestCode == 300 && resultCode == Activity.RESULT_OK) {

//            发现图片在ImageView上无法显示，原因是图片过大导致的，所以要对于图片进行处理。
//            二次采样   对于图片的宽度和高度进行处理，对于图片的质量进行处理

//            1.获取用于设置图片属性的参数
            BitmapFactory.Options options = new BitmapFactory.Options();
//            2.对于属性进行设置，需要解锁边缘
            options.inJustDecodeBounds = true;
//            3.对于图片进行编码处理
            BitmapFactory.decodeFile(path, options);
//            4.获取原来图片的宽度和高度
            int outHeight = options.outHeight;
            int outWidth = options.outWidth;
//            5.200,200  获得要压缩的比例
            int sampleHeight = outHeight / 200;  //2
            int sampleWidth = outWidth / 200;    //1.5
//            6.获取较大的比例
            int size = Math.max(sampleHeight, sampleWidth);
//            7.设置图片压缩的比例
            options.inSampleSize = size;
            /**图片的质量   1个字节是8位
             * ARGB_8888  32位     4字节   100*100*4 = 40000 个字节
             * ARGB_4444  16位     2字节   100*100*2 = 20000 个字节
             * RGB_565    16位      2字节  100*100*2 = 20000 个字节
             * Alpha_8    8位       1字节  100*100*1 = 10000 个字节
             *
             * 100px*100px  的图片
             * */
            options.inPreferredConfig = Bitmap.Config.RGB_565;   //设置图片的质量类型
//            8.锁定边缘
            options.inJustDecodeBounds = false;
            Bitmap bitmap = BitmapFactory.decodeFile(path1, options);
//            user_img.setBackgroundResource(R.color.isfalse);
            Picasso.with(this).load(new File(path1)).into(user_img);
//            img.setImageBitmap(bitmap);
            if (load != null) {
                load.setUsernumber(path1);
                load.setImg(null);
                dao.update(load);
            }


        } else if (requestCode == 200 && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
//            user_img.setImageResource(R.color.isfalse);
            Picasso.with(this).load(uri).into(user_img);
            if (load != null) {
                load.setImg(uri.toString());
                load.setUsernumber(null);
                dao.update(load);
            }

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<UserDao> daos = dao.loadAll();
        UserDao dao = daos.get(0);
        String img = dao.getImg();
        String usernumber = dao.getUsernumber();
        if (img == null && usernumber != null) {
            Picasso.with(this).load(new File(usernumber)).into(user_img);
        } else if (img != null && usernumber == null) {
            Picasso.with(this).load(Uri.parse(img)).into(user_img);
        } else if (img == null && usernumber == null) {
            user_img.setImageResource(R.mipmap.login_qq);
        }

    }
}
