package com.addon.room360;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.addon.room360.fragments.BookedFragment;
import com.addon.room360.fragments.PendingForcleaningFragment;
import com.addon.room360.fragments.UnbookedFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chitti on 22-04-2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment() {
        mFragmentList.add(new BookedFragment());
        mFragmentList.add(new UnbookedFragment());
        mFragmentList.add(new PendingForcleaningFragment());
    }


}
