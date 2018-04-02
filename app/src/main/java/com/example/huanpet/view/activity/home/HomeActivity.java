package com.example.huanpet.view.activity.home;


import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.huanpet.R;
import com.example.huanpet.app.MyAppAlication;
import com.example.huanpet.base.BaseActivity;
import com.example.huanpet.utils.jsonurluntils.CJSON;
import com.example.huanpet.view.activity.home.adapter.HomeAnimalRecyAdapter;
import com.example.huanpet.view.activity.home.adapter.HomeListAdapter;
import com.example.huanpet.view.activity.home.adapter.HomePageRecyAdapter;
import com.example.huanpet.view.activity.home.bean.AnimalBean;
import com.example.huanpet.view.activity.home.bean.MyBean;

import com.example.huanpet.model.greendao.UserDao;
import com.example.huanpet.utils.OkHttpUtls;
import com.example.huanpet.view.ILoginView;

import com.example.huanpet.view.activity.screen.ScreenActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.support.v4.widget.DrawerLayout;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.huanpet.view.activity.login.LoginActivity;
import com.example.huanpet.view.activity.need.NeedActivity;
import com.example.huanpet.view.activity.news.NewsActivity;
import com.example.huanpet.view.activity.order.OrderActivity;
import com.example.huanpet.view.activity.pet.PetActivity;
import com.example.huanpet.view.activity.setting.SettingActivity;
import com.example.huanpet.view.activity.user.UserActivity;
import com.example.huanpet.view.activity.wallet.WalletActivity;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * 首页
 */
public class HomeActivity extends BaseActivity {


    private RecyclerView recy_home_Page;


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

    private LinearLayout shaixuan_homePage;

    private LinearLayout lin;

    private List<String> nearList;
    private List<String> animalList;
    private Boolean aBoolean = true;
    private Boolean aBoolean1 = true;
    private Boolean aBoolean2 = true;
    private String[] near = {"附近优先", "好评优先", "订单优先", "价格从高到低", "价格从低到高"};
    private String[] animal = {"小型犬", "中型犬", "大型犬", "猫", "小宠", "幼犬"};
    private String[] indexNear = {"distance asc", "score desc", "orderCount desc", "price asc", "price desc"};
    private String url = "http://123.56.150.230:8885/dog_family/users/getUsersInfoByVO.jhtml";
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
    private TextView city;
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
    private TextView choice;
    private PopupWindow window1;
    private List<UserDao> daos;

    @SuppressLint("HandlerLeak")
    private Handler han = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage( msg );
            Log.e( "yanyan", (String) msg.obj );
            jsonData( (String) msg.obj );


        }
    };
    @SuppressLint("HandlerLeak")
    private Handler mhan = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage( msg );
            Log.e( "yanyan", (String) msg.obj );

            animalJsonData( (String) msg.obj );

        }
    };


    private List<MyBean> beanList;
    private String address;
    private String family;
    private String userImage;
    private String price;
    private int score;
    private List<AnimalBean> animalList1;


    @Override
    protected void initData() {
        liner2.setVisibility( View.GONE );
        dra.setDrawerListener( new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                showTitleText( false );
                liner2.setVisibility( View.VISIBLE );
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }


            @Override
            public void onDrawerClosed(View drawerView) {
                showTitleText( true );
                liner2.setVisibility( View.GONE );
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        } );

        getURL( indexNear[0] );


    }

    @Override
    protected void initview() {
        v4_drawerlayout_frame = findViewById( R.id.v4_drawerlayout_frame );
        v4_listview = findViewById( R.id.v4_listview );
        dra = findViewById( R.id.drawer );
        liner2 = findViewById( R.id.liner2 );
        editor = getEditor();
        share = getShare();
        user_img = findViewById( R.id.user_img );
        user_name = findViewById( R.id.user_name );
        user_img = findViewById( R.id.user_img );
        user_phone = findViewById( R.id.user_phone );
        user_enter = findViewById( R.id.user_enter );
        login = findViewById( R.id.login );
        news = findViewById( R.id.news );
        pet = findViewById( R.id.pet );
        order = findViewById( R.id.order );
        wallet = findViewById( R.id.wallet );
        need = findViewById( R.id.need );
        setting = findViewById( R.id.setting );
        is_sure = findViewById( R.id.is_sure );
        login.setOnClickListener( this );
        pet.setOnClickListener( this );
        wallet.setOnClickListener( this );
        need.setOnClickListener( this );
        setting.setOnClickListener( this );
        is_sure.setOnClickListener( this );
        news.setOnClickListener( this );
        order.setOnClickListener( this );
        city = findViewById( R.id.location );

        recy_home_Page = (RecyclerView) findViewById( R.id.recy_home_Page );

        nearby_homePage = (TextView) findViewById( R.id.nearby_homePage );
        animal_homePage = (TextView) findViewById( R.id.animal_homePage );
        screen_homePage = (TextView) findViewById( R.id.screen_homePage );
        img1 = (ImageView) findViewById( R.id.img1 );
        img2 = (ImageView) findViewById( R.id.img2 );
        img3 = (ImageView) findViewById( R.id.img3 );

        shaixuan_homePage = (LinearLayout) findViewById( R.id.shaixuan_homePage );
        choice = (TextView) findViewById( R.id.choice );

        choice.setOnClickListener( this );
        nearby_homePage.setOnClickListener( this );
        animal_homePage.setOnClickListener( this );
        screen_homePage.setOnClickListener( this );
        user_img = findViewById(R.id.user_img);
        user_name = findViewById(R.id.user_name);
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
        city = findViewById(R.id.location);


        recy_home_Page = (RecyclerView) findViewById(R.id.recy_home_Page);

        nearby_homePage = (TextView) findViewById(R.id.nearby_homePage);
        animal_homePage = (TextView) findViewById(R.id.animal_homePage);
        screen_homePage = (TextView) findViewById(R.id.screen_homePage);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);

        shaixuan_homePage = (LinearLayout) findViewById(R.id.shaixuan_homePage);
        choice = (TextView) findViewById(R.id.choice);

        choice.setOnClickListener(this);
        nearby_homePage.setOnClickListener(this);
        animal_homePage.setOnClickListener(this);
        screen_homePage.setOnClickListener(this);

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
        dra.openDrawer( Gravity.LEFT );
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
                if (share.getBoolean( "isLogin", false )) {
                    startActivity( new Intent( this, UserActivity.class ) );
                } else {
                    startActivity( new Intent( this, LoginActivity.class ) );
                }
                break;
            case R.id.news:
                startActivity( new Intent( this, NewsActivity.class ) );
                break;
            case R.id.pet:
                startActivity( new Intent( this, PetActivity.class ) );
                break;
            case R.id.order:
                startActivity( new Intent( this, OrderActivity.class ) );
                break;
            case R.id.wallet:
                startActivity( new Intent( this, WalletActivity.class ) );
                break;
            case R.id.need:
                startActivity( new Intent( this, NeedActivity.class ) );
                break;
            case R.id.setting:
                startActivity( new Intent( this, SettingActivity.class ) );
                break;
            case R.id.is_sure:
                break;

        }
    }


    public void getURL(String nan) {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put( "beginIndex", "0" );
        bodyMap.put( "coordX", share.getString( "latitude", "39.92" ) );
        bodyMap.put( "coordY", share.getString( "longitude", "116.46" ) );
        bodyMap.put( "endIndex", "10" );
        bodyMap.put( "orderBy", nan );
        CJSON.getData( HomeActivity.this, "users/getUsersInfoByVO.jhtml", bodyMap, han );
    }

    public void getAnimalUrl(String yan) {
        Map<String, Object> bodaMap = new HashMap<>();
        bodaMap.put( "beginIndex", 0 );
        bodaMap.put( "endIndex", 10 );
        bodaMap.put( "petTypeCode", yan );

        CJSON.getData( HomeActivity.this, "petType/getPetTypesByVO.jhtml", bodaMap, mhan );
    }

    public void jsonData(String data) {

        beanList = new ArrayList<>();
        try {
            JSONObject object = new JSONObject( data );
            JSONArray desc = object.getJSONArray( "desc" );
            for (int i = 0; i < desc.length(); i++) {
                JSONObject jsonObject = desc.getJSONObject( i );
                address = jsonObject.optString( "address" );
                family = jsonObject.optString( "family" );
                userImage = jsonObject.optString( "userImage" );
                score = jsonObject.optInt( "score" );
                price = jsonObject.optString( "price" );
                beanList.add( new MyBean( address, family, userImage, score,price ) );
            }
            HomePageRecyAdapter homePageRecyAdapter = new HomePageRecyAdapter( beanList, HomeActivity.this );
            LinearLayoutManager manager = new LinearLayoutManager( HomeActivity.this, LinearLayoutManager.VERTICAL, false );
            recy_home_Page.setAdapter( homePageRecyAdapter );
            recy_home_Page.setLayoutManager( manager );
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    public void animalJsonData(String data){
        animalList1 = new ArrayList<>(  );
        try {
            JSONObject object = new JSONObject( data );
            JSONArray desc = object.getJSONArray( "desc" );
            for (int i = 0; i < desc.length(); i++) {
                JSONObject jsonObject = desc.getJSONObject( i );
                String petPrice = jsonObject.optString( "petPrice" );
                String petTypeImage = jsonObject.optString( "petTypeImage" );
                String typeName = jsonObject.optString( "typeName" );
                animalList1.add( new AnimalBean( petPrice,petTypeImage,typeName ) );
            }
            HomeAnimalRecyAdapter homeAnimalRecyAdapter = new HomeAnimalRecyAdapter( animalList1, HomeActivity.this );
            LinearLayoutManager manager = new LinearLayoutManager( HomeActivity.this, LinearLayoutManager.VERTICAL, false );
            recy_home_Page.setAdapter( homeAnimalRecyAdapter );
            recy_home_Page.setLayoutManager( manager );
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void animalJT() {
        if (window != null) {
            window.dismiss();
        }
        if (shaixuan_homePage != null) {
            shaixuan_homePage.setVisibility( View.GONE );
            aBoolean2 = true;
            img3.setBackgroundResource( R.mipmap.down_arrow );
        }
        if (aBoolean) {
            aBoolean = false;
            View recyInflate1 = LayoutInflater.from( HomeActivity.this ).inflate( R.layout.item2_recy, null );
            listInflate = LayoutInflater.from( HomeActivity.this ).inflate( R.layout.popup_homepage1, null );
            list_home_Page = (ListView) listInflate.findViewById( R.id.list_home_Page );

            window1 = new PopupWindow( listInflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, false );
            window1.setFocusable( true );
            window1.setBackgroundDrawable( new BitmapDrawable() );
            window1.showAsDropDown( recyInflate1, 0, 320 );

            list_home_Page.setVisibility( View.VISIBLE );
            img2.setBackgroundResource( R.mipmap.up_arrow );
            animalList = new ArrayList<>();
            for (int i = 0; i < animal.length; i++) {
                animalList.add( animal[i] );
            }

            HomeListAdapter adapter = new HomeListAdapter( animalList, HomeActivity.this );
            list_home_Page.setAdapter( adapter );
            adapter.setDefSelect( 0 );
            list_home_Page.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    window1.dismiss();
                    getAnimalUrl( animal[position] );
                }
            } );
            recy_home_Page.setBackgroundResource( R.color.istrue );

            window1.setOnDismissListener( new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    img2.setBackgroundResource( R.mipmap.down_arrow );
                    recy_home_Page.setBackgroundResource( R.color.isfalse );
                    aBoolean = true;
                }
            } );

        } else {
            window1.dismiss();
            img1.setBackgroundResource( R.mipmap.down_arrow );
            recy_home_Page.setBackgroundResource( R.color.isfalse );
            aBoolean = true;
        }
    }

    public void setNearby_homePageJT() {
        if (aBoolean1) {
            if (window1 != null) {
                window1.dismiss();
            }
            if (shaixuan_homePage != null) {
                shaixuan_homePage.setVisibility( View.GONE );
                img3.setBackgroundResource( R.mipmap.down_arrow );
                aBoolean2 = true;
            }

            aBoolean1 = false;
            recyInflate1 = LayoutInflater.from( HomeActivity.this ).inflate( R.layout.item2_recy, null );
            listInflate = LayoutInflater.from( HomeActivity.this ).inflate( R.layout.popup_homepage1, null );
            list_home_Page = (ListView) listInflate.findViewById( R.id.list_home_Page );

            window = new PopupWindow( listInflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, false );
            window.setFocusable( true );
            window.setBackgroundDrawable( new BitmapDrawable() );
            window.showAsDropDown( recyInflate1, 0, 320 );

            list_home_Page.setVisibility( View.VISIBLE );
            img1.setBackgroundResource( R.mipmap.up_arrow );
            nearList = new ArrayList<>();
            for (int i = 0; i < near.length; i++) {
                nearList.add( near[i] );
            }

            final HomeListAdapter adapter = new HomeListAdapter( nearList, HomeActivity.this );
            list_home_Page.setAdapter( adapter );
            adapter.setDefSelect( 0 );//设置默认选中第一项

            list_home_Page.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    adapter.setDefSelect( position );
                    window.dismiss();
                    getURL( indexNear[position] );
                }
            } );

            recy_home_Page.setBackgroundResource( R.color.istrue );


            window.setOnDismissListener( new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    img1.setBackgroundResource( R.mipmap.down_arrow );
                    recy_home_Page.setBackgroundResource( R.color.isfalse );
                    aBoolean1 = true;
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
        lin = (LinearLayout) inflate.findViewById(R.id.lin);
        recy_home_Page1 = (RecyclerView) inflate.findViewById(R.id.recy_home_Page);
        city.setText(share.getString("city", "北京"));
        if (window != null) {
            window.dismiss();
        }
        if (window1 != null) {
            window1.dismiss();
        }
        if (aBoolean2) {
            lin.setVisibility( View.GONE );
            shaixuan_homePage.setVisibility( View.VISIBLE );
            img3.setBackgroundResource( R.mipmap.up_arrow );
            aBoolean2 = false;
        } else {
            lin.setVisibility( View.VISIBLE );
            shaixuan_homePage.setVisibility( View.GONE );
            img3.setBackgroundResource( R.mipmap.down_arrow );
            aBoolean2 = true;
        }
    }

    public void choiceJT() {
        Intent intent = new Intent( HomeActivity.this, ScreenActivity.class );
        startActivityForResult( intent, 200 );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (requestCode == 200 && resultCode == 100) {
            city.setText(data.getStringExtra("city"));
            editor.putString("city", data.getStringExtra("city")).commit();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (share.getBoolean("isLogin", false)) {
            daos = MyAppAlication.getMyApp().getDaoSession().getUserDaoDao().loadAll();
            UserDao dao = daos.get(0);
            String img = dao.getImg();
            String usernumber = dao.getUsernumber();
            Log.e("onStart: ", img+"----------------");
            Log.e("onStart: ", usernumber+"---------");
            if (img == null && usernumber != null) {
                Picasso.with(this).load(new File(usernumber)).into(user_img);
            } else if (img != null && usernumber == null) {
                Picasso.with(this).load(Uri.parse(img)).into(user_img);
            } else if (img == null && usernumber == null){
                user_img.setImageResource(R.mipmap.login_qq);
            }
            user_name.setText(dao.getUsername());
            user_phone.setVisibility(View.VISIBLE);
            user_phone.setText(dao.getPhone());
        } else {
            user_name.setText("点击登录");
            user_phone.setVisibility(View.GONE);
            user_img.setImageResource(R.mipmap.ic_launcher);
        }
    }
}

