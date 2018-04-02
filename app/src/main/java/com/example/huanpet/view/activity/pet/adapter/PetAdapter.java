package com.example.huanpet.view.activity.pet.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.huanpet.R;

import java.util.List;


public class PetAdapter extends RecyclerView.Adapter<PetAdapter.Myaaa> {
    List<String> stringList;
    Context context;


    public PetAdapter(List<String> stringList, Context context) {
        this.stringList = stringList;
        this.context = context;
    }

    @Override
    public Myaaa onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_pet_one, null);
        Myaaa myaaa = new Myaaa(view);
        return myaaa;
    }

    @Override
    public void onBindViewHolder(Myaaa holder, int position) {
        holder.petTextone.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    private void initView() {

    }

    public class Myaaa extends RecyclerView.ViewHolder {
        private TextView petTextone;
        private TextView petTexttwo;
        public Myaaa(View itemView) {
            super(itemView);

            petTextone = itemView.findViewById(R.id.text);
            petTexttwo = itemView.findViewById(R.id.text2);
        }
    }
}
