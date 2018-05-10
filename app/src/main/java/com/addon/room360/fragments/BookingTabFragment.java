package com.addon.room360.fragments;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.addon.room360.R;

import java.util.Calendar;

public class BookingTabFragment extends Fragment implements View.OnClickListener {
    private static final int DATE_DIALOG_ID = 1;
    private static final int DATE_DIALOG_ID2 = 2;
    private static final int DATE_DIALOG_ID3 = 3;
    private static final int DATE_DIALOG_ID4 = 4;
    private int syear;
    int cur = 0;
    private int smonth;
    private int sday;

    public BookingTabFragment() {

    }

    TextView  checkin, checkout, bookinDate, PlannedDate,checkindate,checkoutdate;


    @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    @Nullable


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.booking_tab, container, false);
        TextView book = view.findViewById(R.id.book);
        TextView Plan = view.findViewById(R.id.plancheck);
checkindate = view.findViewById(R.id.checkindate);
        checkoutdate = view.findViewById(R.id.checkcoutdate);
        book.setOnClickListener(this);

        Plan.setOnClickListener(this) ;
        bookinDate = view.findViewById(R.id.bookcheck);

        PlannedDate = view.findViewById(R.id.PlannedCheckinDate);
        checkin = view.findViewById(R.id.checkIn);
        checkin.setOnClickListener(this);
        checkout = view.findViewById(R.id.checkOut);
        checkout.setOnClickListener(this);

        return view;


    }

    public void showdatepicker(DatePickerDialog.OnDateSetListener onDateSetListener) {

        Calendar today = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener,
                today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE));
        datePickerDialog.show();
    }

    public void showdatepicker() {
        DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                syear = year;
                smonth = month;
                sday = day;
                if (cur == DATE_DIALOG_ID) {
                    Calendar selecteddate = Calendar.getInstance();
                    new DatePickerDialog(getContext(), this,
                            selecteddate.get(Calendar.YEAR), selecteddate.get(Calendar.MONTH), selecteddate.get(Calendar.DATE));
                    bookinDate.setText(sday + "/" + smonth + "/" + syear);

                }
                if (cur == DATE_DIALOG_ID2) {
                    Calendar selecteddate2 = Calendar.getInstance();
                    new DatePickerDialog(getContext(), this,
                            selecteddate2.get(Calendar.YEAR), selecteddate2.get(Calendar.MONTH), selecteddate2.get(Calendar.DATE));

                    PlannedDate.setText(sday + "/" + smonth + "/" + syear);
                }
                if (cur== DATE_DIALOG_ID3){
                    Calendar selecteddate2 = Calendar.getInstance();
                    new DatePickerDialog(getContext(), this,
                            selecteddate2.get(Calendar.YEAR), selecteddate2.get(Calendar.MONTH), selecteddate2.get(Calendar.DATE));
                    checkindate.setText(sday + "/" + smonth + "/" + syear);

                }
                if (cur == DATE_DIALOG_ID4){
                    Calendar selecteddate2 = Calendar.getInstance();
                    new DatePickerDialog(getContext(), this,
                            selecteddate2.get(Calendar.YEAR), selecteddate2.get(Calendar.MONTH), selecteddate2.get(Calendar.DATE));
                    checkoutdate.setText(sday + "/" + smonth + "/" + syear);
                }

            }

        };
        showdatepicker(myDateListener);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.book:{
                cur = DATE_DIALOG_ID;
                showdatepicker();
                break;
            }
            case R.id.plancheck:{
                cur = DATE_DIALOG_ID2;
                showdatepicker();
                break;
            }
            case R.id.checkIn:{
                cur = DATE_DIALOG_ID3;
                showdatepicker();
                break;
            }
            case R.id.checkOut:{
                cur = DATE_DIALOG_ID4;
                showdatepicker();
                break;
            }
        }


    }
}





