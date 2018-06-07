package com.addon.room360.fragments;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.addon.room360.AddCusomer;
import com.addon.room360.R;
import com.addon.room360.data.RoomContract;
import com.addon.room360.data.RoomDbHelper;

public class CustomerTabFragment extends Fragment {
    private RoomDbHelper roomDbHelper;
    EditText searchtext;
    TextView resultview;
    Button searchresult, newcustomer;

    public CustomerTabFragment (){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.customer_tab, container, false);
        searchtext = view.findViewById(R.id.search_text);
        resultview = view.findViewById(R.id.result_view);
        searchresult = view.findViewById(R.id.search);
        roomDbHelper = new RoomDbHelper(getContext());
        newcustomer = view.findViewById(R.id.Add_new);

        newcustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AddCusomer.class);
                startActivity(i);
            }
        });
        searchresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });        return view;


    }
    public void search () {

        String[] projection = {
                RoomContract.RoomEntry.COLUMN_CUSTOMER_NAME, RoomContract.RoomEntry.COLUMN_CITY

        };
        String  selection = RoomContract.RoomEntry.COLUMN_MOBILE_NUM + "=?"  ;
        String[] selectionArgs = {searchtext.getText().toString()};
        SQLiteDatabase db = roomDbHelper.getReadableDatabase();

        Cursor result= db.query(RoomContract.RoomEntry.TABLE_NAME,projection,selection,selectionArgs,null, null, null);


        resultview.setText( "Customer Name  -  Customer Location \n");

        int customernameindex =  result.getColumnIndex(RoomContract.RoomEntry.COLUMN_CUSTOMER_NAME);
        int customercityindex = result.getColumnIndex(RoomContract.RoomEntry.COLUMN_CITY);

        while (result.moveToNext()){

            String cust_name = result.getString(customernameindex);
            String cust_city = result.getString(customercityindex);

            resultview.append("\n" + cust_name + " - " + cust_city);
        }
        result.close();


    }



}

