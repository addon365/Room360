package com.addon.room360;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.addon.room360.R;
import com.addon.room360.data.RoomContract;
import com.addon.room360.data.RoomDbHelper;
import com.addon.room360.fragments.BookingTabFragment;
import com.addon.room360.fragments.CustomerTabFragment;


public class CustomerBookingActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_booking);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        TabPager adapter = new TabPager(getSupportFragmentManager());

        // Add Fragments to adapter one by one

        adapter.addFragment(new CustomerTabFragment(), "Customer");
        adapter.addFragment(new BookingTabFragment(), "Booking");
        viewPager.setAdapter(adapter);
        TextView room = findViewById(R.id.Room_customer);
        TabLayout tabLayout =  findViewById(R.id.tabLayout1);
        tabLayout.setupWithViewPager(viewPager);
        Intent i = getIntent();
        String roomno = i.getStringExtra("Room");
        room.setText(roomno);





    }


}
