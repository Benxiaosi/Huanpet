package com.example.huanpet.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.huanpet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(getFragmentId(), container, false);
        initView(view);
        initData();
        return view;
    }
    abstract void initView(View vi);
    abstract void initData();
    public abstract  int getFragmentId() ;
}
