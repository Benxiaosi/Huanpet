package com.example.huanpet.view.activity.pet;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.huanpet.R;
import com.example.huanpet.base.BaseActivity;
import com.example.huanpet.view.activity.pet.adapter.PetAdapter;

import java.util.ArrayList;
import java.util.List;

public class PetActivity extends BaseActivity {
    private List<String> stringList;

    private RecyclerView recyclerViewPet;
    String[] strings = {"狗子", "肉包", "老虎"};


    @Override
    protected void initview() {


        recyclerViewPet = (RecyclerView) findViewById(R.id.recyclerView_pet);

    }

    @Override
    protected void initData() {
        showSouText(false);
        showMap(false);
        showUser(false);
        showBack(true);
        showTitle(true);

        showDetermine(true);
        setDetermine("添加");
        setTitle("寵物列表");

        stringList = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            stringList.add(strings[i]);
        }
        PetAdapter petAdapter = new PetAdapter(stringList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewPet.setLayoutManager(linearLayoutManager);
        recyclerViewPet.setAdapter(petAdapter);


    }

    @Override
    public int getlayoutID() {
        return R.layout.activity_pet;
    }

    @Override
    protected void doDetermine() {

        Log.e("=============", "123456789");
        Intent intent = new Intent(PetActivity.this, PetActivity.class);
        startActivity(intent);
    }

    @Override
    protected void intentUser() {

    }
}
