package com.example.huanpet.view.activity.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.huanpet.R;
import com.example.huanpet.view.activity.home.ContenActivity;
import com.example.huanpet.view.activity.home.bean.AnimalBean;
import com.example.huanpet.view.activity.home.bean.CircleImageView;

import java.util.List;

/**
 * Created by leon on 2018/4/2.
 */

public class HomeAnimalRecyAdapter extends RecyclerView.Adapter<HomeAnimalRecyAdapter.ViewHolder> {
    private List<AnimalBean> animalList1;
    private Context con;


    public HomeAnimalRecyAdapter(List<AnimalBean> animalList1, Context con) {
        this.animalList1 = animalList1;
        this.con = con;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from( con ).inflate( R.layout.homepagerecy_item, parent, false );
        ViewHolder holder = new ViewHolder( inflate );
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.image_recycler.setImageResource( R.mipmap.d );
        holder.price_recyler.setText( animalList1.get( position ).getPetPrice() );
        holder.family_recycler.setText( animalList1.get( position ).getTypeName() );
        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( con, ContenActivity.class );
//                intent.putExtra( "touxiang",animalList1.get( position ).getPetTypeImage() );
                intent.putExtra( "name",animalList1.get( position ).getTypeName() );
                con.startActivity( intent );
            }
        } );
    }

    @Override
    public int getItemCount() {
        return animalList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView image_recycler;
        private TextView family_recycler;
        private RatingBar rating_recycler;
        private TextView address_recycler;
        private TextView price_recyler;
        public ViewHolder(View itemView) {
            super( itemView );
            image_recycler = (CircleImageView) itemView.findViewById( R.id.image_recycler );
            price_recyler = (TextView) itemView.findViewById( R.id.price_recyler );
            family_recycler = (TextView) itemView.findViewById( R.id.family_recycler );


        }
    }
}
