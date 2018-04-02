package com.example.huanpet.view.activity.home;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.huanpet.R;
import com.example.huanpet.view.activity.home.bean.CircleImageView;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

public class ContenActivity extends AppCompatActivity {

    private RollPagerView roll_content;
    private CircleImageView headportrait;
    private TextView netName_content;
    private RatingBar rating_content;
    private TextView briefintroduction_content;
    private int[] arr = {R.mipmap.agree, R.mipmap.amap_bus, R.mipmap.amap_bus};
    private ImageView contact_content;
    private TextView jianjie_content;
    private TextView jiyangComment;
    private PopupWindow window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_conten );
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        contact_content.setOnClickListener( new View.OnClickListener() {
            private TextView quxiao;
            private TextView sendMessage;
            private TextView takePhone;

            @Override
            public void onClick(View v) {

                View inflate = LayoutInflater.from( ContenActivity.this ).inflate( R.layout.contentpopup_item, null );
                quxiao = (TextView) inflate.findViewById( R.id.quxiao );
                sendMessage = (TextView) inflate.findViewById( R.id.sendMessage );
                takePhone = (TextView) inflate.findViewById( R.id.takePhone );
                window = new PopupWindow( inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, false );
                window.setFocusable( true );
                window.setBackgroundDrawable( new BitmapDrawable(  ) );
                window.showAtLocation( inflate, Gravity.BOTTOM,0,0 );
                Log.e( " ==============","----------------------" );
                takePhone.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent();
                        intent.setAction(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:10086"));
                        startActivity(intent);
                        window.dismiss();
                    }
                } );
                sendMessage.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_SENDTO);
                        intent.setData( Uri.parse("smsto:10086"));
                        startActivity(intent);
                        window.dismiss();
                    }
                } );
                quxiao.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        window.dismiss();
                    }
                } );
            }
        } );

        jiyangComment.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity( new Intent( ContenActivity.this, CommentActivity.class ) );
            }
        } );
    }

    private void initData() {

        roll_content.setPlayDelay( 1000 );
        roll_content.setAdapter( new StaticPagerAdapter() {
            @Override
            public View getView(ViewGroup container, int position) {
                ImageView imageView = new ImageView( ContenActivity.this );
                imageView.setImageResource( arr[position] );
                return imageView;
            }

            @Override
            public int getCount() {
                return arr.length;
            }
        } );


        Intent intent = getIntent();
        String touxiang = intent.getStringExtra( "touxiang" );
        String name = intent.getStringExtra( "name" );
        String address = intent.getStringExtra( "address" );
        int score = intent.getIntExtra( "score", 0 );

        //附近筛选
        Glide.with( ContenActivity.this ).load( touxiang ).into( headportrait );
        netName_content.setText( name );
        briefintroduction_content.setText( address );
        rating_content.setRating( score );
        jianjie_content.setText( address );


        //宠物筛选
//        Intent intent1 = getIntent();
//        String name1 = intent1.getStringExtra( "name1" );
//        int touxiang1 = intent1.getIntExtra( "touxiang1",0 );
//        headportrait.setImageResource( touxiang1 );
//        netName_content.setText( name1 );


    }

    private void initView() {
        roll_content = (RollPagerView) findViewById( R.id.roll_content );
        headportrait = (CircleImageView) findViewById( R.id.headportrait );
        netName_content = (TextView) findViewById( R.id.netName_content );
        rating_content = (RatingBar) findViewById( R.id.rating_content );
        briefintroduction_content = (TextView) findViewById( R.id.briefintroduction_content );
        contact_content = (ImageView) findViewById( R.id.contact_content );
        jianjie_content = (TextView) findViewById( R.id.jianjie_content );
        jiyangComment = (TextView) findViewById( R.id.jiyangComment );

    }
}
