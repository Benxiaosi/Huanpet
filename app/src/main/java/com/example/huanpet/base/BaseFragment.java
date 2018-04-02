package com.example.huanpet.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 何启明 on 2018/4/2.
 */

public abstract class BaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View inflate = inflater.inflate(getview(), container, false);

        initView(inflate);

        initData();
        return inflate;


    }

    protected abstract void initData();

    protected abstract void initView(View view);

    public abstract int getview();
}
