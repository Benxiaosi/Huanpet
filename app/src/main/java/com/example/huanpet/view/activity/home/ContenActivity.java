package com.example.huanpet.view.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    private int[] arr = {R.mipmap.x, R.mipmap.y, R.mipmap.z};
    private ImageView contact_content;
    private TextView jianjie_content;

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
            @Override
            public void onClick(View v) {
                Intent Intent =  new Intent( android.content.Intent.ACTION_CALL_BUTTON );//跳转到拨号界面
                startActivity(Intent);
            }
        } );
    }

    private void initData() {

        roll_content.setPlayDelay( 3000 );
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

        Glide.with( ContenActivity.this ).load( touxiang ).into( headportrait );
        netName_content.setText( name );
        briefintroduction_content.setText( address );
        rating_content.setRating( score );
        jianjie_content.setText( address );

    }

    private void initView() {
        roll_content = (RollPagerView) findViewById( R.id.roll_content );
        headportrait = (CircleImageView) findViewById( R.id.headportrait );
        netName_content = (TextView) findViewById( R.id.netName_content );
        rating_content = (RatingBar) findViewById( R.id.rating_content );
        briefintroduction_content = (TextView) findViewById( R.id.briefintroduction_content );
        contact_content = (ImageView) findViewById( R.id.contact_content );
        jianjie_content = (TextView) findViewById( R.id.jianjie_content );
    }
}
