package com.addon.room360.fragments;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.addon.room360.R;

public class BookingTabFragment extends android.support.v4.app.Fragment {
public BookingTabFragment(){

}

    Button booking, planChecking, checkin, checkout ;

    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.booking_tab, container, false);
        booking = view.findViewById(R.id.book);
        planChecking = view.findViewById(R.id.plancheck);
        checkin = view.findViewById(R.id.checkIn);
        checkout= view.findViewById(R.id.checkOut);


        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent date = getActivity().getIntent();
                String d = date.getStringExtra("Date");
                Log.d("DATE", d);
                TextView t = (TextView )view.findViewById(R.id.bookcheck);
                t.setText(d);
            }
        });


        return view;
    }

    }




