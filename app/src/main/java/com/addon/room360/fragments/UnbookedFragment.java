package com.addon.room360.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ListView;

import com.addon.room360.AddRoomActivity;
import com.addon.room360.BookedAdapter;
import com.addon.room360.BookedClass;
import com.addon.room360.R;

import java.util.ArrayList;


/**
 * Created by chitti on 22-04-2018.
 */

public class UnbookedFragment extends Fragment {
    public UnbookedFragment() {

    }

    public static UnbookedFragment newInstanceunbooked() {
        UnbookedFragment fragment = new UnbookedFragment();

        fragment.setArguments(null);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.unbooked, container, false);
        ArrayList<BookedClass> arry = new ArrayList<BookedClass>();


        arry.add(new BookedClass(132, "AC", 3));
        arry.add(new BookedClass(133, "NON AC", 2));
        arry.add(new BookedClass(134, "AC", 3));
        arry.add(new BookedClass(135, "AC", 3));
        arry.add(new BookedClass(136, "NON AC", 2));
        arry.add(new BookedClass(137, "AC", 3));
        arry.add(new BookedClass(138, "AC", 3));
        arry.add(new BookedClass(139, "NON AC", 2));
        arry.add(new BookedClass(140, "AC", 3));
        arry.add(new BookedClass(141, "AC", 3));
        arry.add(new BookedClass(142, "NON AC", 2));
        arry.add(new BookedClass(143, "AC", 3));
        arry.add(new BookedClass(144, "AC", 3));
        arry.add(new BookedClass(145, "NON AC", 2));
        arry.add(new BookedClass(146, "AC", 3));
        BookedAdapter adapter = new BookedAdapter(getContext(), arry);
        ListView list = view.findViewById(R.id.Unbooked);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), AddRoomActivity.class);
                startActivity(i);
            }
        });


        return view;
    }

}
