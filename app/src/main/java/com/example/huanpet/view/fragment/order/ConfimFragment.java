package com.example.huanpet.view.fragment.order;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.huanpet.R;

/**
 * A simple {@link Fragment} subclass.
 * 待确认页面
 */
public class ConfimFragment extends Fragment {


    public ConfimFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confim, container, false);
    }

}
