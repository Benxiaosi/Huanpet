package com.example.huanpet.view.activity.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.huanpet.R;
import com.example.huanpet.view.activity.home.ContenActivity;
import com.example.huanpet.view.activity.home.bean.MyBean;

import java.util.List;

/**
 * Created by leon on 2018/3/30.
 */

public class HomePageRecyAdapter extends RecyclerView.Adapter<HomePageRecyAdapter.Holder> {
    private List<MyBean> beanList;
    private Context con;


    public HomePageRecyAdapter(List<MyBean> beanList, Context con) {
        this.beanList = beanList;
        this.con = con;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from( con ).inflate( R.layout.homepagerecy_item, parent, false );
        Holder holder = new Holder( inflate );
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {


        if (beanList.get( position ).getUserImage().equals( "" )) {
            holder.image_recycler.setImageResource( R.mipmap.nan );
        } else {
            Glide.with( con ).load( beanList.get( position ).getUserImage() ).into( holder.image_recycler );
        }
        holder.address_recycler.setText( beanList.get( position ).getAddress() );
        holder.family_recycler.setText( beanList.get( position ).getFamily() );
        holder.price_recyler.setText( beanList.get( position ).getPrice() + "起" );
        holder.rating_recycler.setRating( beanList.get( position ).getScore() );
        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( con, ContenActivity.class );
                intent.putExtra( "touxiang",beanList.get( position ).getUserImage() );
                intent.putExtra( "name",beanList.get( position ).getFamily() );
                intent.putExtra( "address",beanList.get( position ).getAddress() );
                intent.putExtra( "score",beanList.get( position ).getScore() );
                con.startActivity( intent );
            }
        } );
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView image_recycler;
        private TextView address_recycler;
        private TextView family_recycler;


        private RatingBar rating_recycler;
        private TextView price_recyler;

        public Holder(View itemView) {
            super( itemView );
            image_recycler = itemView.findViewById( R.id.image_recycler );
            address_recycler = itemView.findViewById( R.id.address_recycler );
            family_recycler = itemView.findViewById( R.id.family_recycler );
            rating_recycler = itemView.findViewById( R.id.rating_recycler );
            price_recyler = itemView.findViewById( R.id.price_recyler );
        }
    }
}
