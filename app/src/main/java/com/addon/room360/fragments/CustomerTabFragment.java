package com.addon.room360.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;

import com.addon.room360.R;

public class CustomerTabFragment extends android.support.v4.app.Fragment {

    public CustomerTabFragment (){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.customer_tab, container, false);


    }

}

