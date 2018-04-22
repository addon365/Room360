package com.addon.room360;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;;

import com.addon.room360.Booked;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements Booked.OnFragmentInteractionListener{
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
        ArrayList<BookedClass> arry = new ArrayList<BookedClass>();

        arry.add(new BookedClass(101, "AC", 3 ));
        arry.add(new BookedClass(102, "NON AC", 2 ));
        arry.add(new BookedClass(101, "AC", 3 ));
        BookedAdapter adapter = new BookedAdapter(this,arry);
        ListView list = findViewById(R.id.bookedlist);
        list.setAdapter(adapter);

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
                }

                return true;
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(Booked.newInstance());
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
