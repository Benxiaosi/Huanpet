package com.example.huanpet.view.activity.order;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.example.huanpet.R;
import com.example.huanpet.base.BaseActivity;
import com.example.huanpet.view.fragment.order.AllFragment;
import com.example.huanpet.view.fragment.order.ConfimFragment;
import com.example.huanpet.view.fragment.order.EvaluatioFragment;
import com.example.huanpet.view.fragment.order.FosteringFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends BaseActivity {



    private List<Fragment> fragments;

    private FosteringFragment fosteringFragment;
    private AllFragment allFragment;
    private EvaluatioFragment evaluatioFragment;
    private ConfimFragment confimFragment;

    private FragmentManager manager= getSupportFragmentManager();


    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fosteringFragment = new FosteringFragment();
        allFragment = new AllFragment();
        evaluatioFragment = new EvaluatioFragment();
        confimFragment = new ConfimFragment();
        fragments.add(allFragment);
        fragments.add(confimFragment);
        fragments.add(fosteringFragment);
        fragments.add(evaluatioFragment);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment,allFragment);
        transaction.commit();
    }

    @Override
    protected void initview() {
        //返回按钮
        showBack(true);
        showTitle(true);
        setTitle("我的订单");
        showDetermine(false);
        showSouText(false);
        showMap(false);
        showUser(false);
        initView();
    }

    @Override
    public int getlayoutID() {
        return R.layout.activity_order;
    }

    @Override
    protected void doDetermine() {

    }

    @Override
    protected void intentUser() {

    }

    private void initView() {
        RadioButton all =findViewById(R.id.All);
        RadioButton confim = findViewById(R.id.Confim);
        RadioButton fostering = findViewById(R.id.fostering);
        RadioButton evaluatio =  findViewById(R.id.evaluatio);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.All:
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment,allFragment);
                transaction.commit();
                break;
            case R.id.Confim:
                FragmentTransaction transaction1 = manager.beginTransaction();
                transaction1.replace(R.id.fragment,confimFragment);
                transaction1.commit();
                break;
            case R.id.fostering:
                FragmentTransaction transaction2 = manager.beginTransaction();
                transaction2.replace(R.id.fragment,fosteringFragment);
                transaction2.commit();
                break;
            case R.id.evaluatio:
                FragmentTransaction transaction3 = manager.beginTransaction();
                transaction3.replace(R.id.fragment,evaluatioFragment);
                transaction3.commit();
                break;

        }
    }
}
