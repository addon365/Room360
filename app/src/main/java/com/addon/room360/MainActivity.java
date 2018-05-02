package com.addon.room360;

import android.app.DatePickerDialog;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.addon.room360.fragments.BookedFragment;
import com.addon.room360.fragments.UnbookedFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BookedFragment.OnFragmentInteractionListener {
@BindView(R.id.bottom_navigation)
BottomNavigationView bottomNavigationView;
@BindView(R.id.viewpager)
ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
viewPager = findViewById(R.id.viewpager);
bottomNavigationView = findViewById(R.id.bottom_navigation);
        ImageView Date_picker_home = findViewById(R.id.Date_picker_home);
        Date_picker_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        TextView tv = findViewById(R.id.Date_Home);
        String ct = DateFormat.getDateInstance().format(new Date());
        tv.setText(ct);

        setupViewPager(viewPager);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_book:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.action_Unbooked:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.action_Cleaning:
                        viewPager.setCurrentItem(2);

                }

                return true;
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment();

        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void showDatePicker() {
        DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                try {
                    Calendar calendar = new GregorianCalendar(year, month, day);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy",
                            Locale.getAvailableLocales()[0]);
                    String date = simpleDateFormat.format(calendar.getTime());
                    TextView Date = findViewById(R.id.Date_Home);
                    Date.setText(date);

                } catch (Exception exception) {

                }
            }
        };
        showDatePicker(myDateListener);
    }

    private void showDatePicker(DatePickerDialog.OnDateSetListener onDateSetListener) {

        Calendar today = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, onDateSetListener,
                today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE));
        datePickerDialog.show();
    }
}
