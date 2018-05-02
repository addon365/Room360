package com.addon.room360.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.addon.room360.AddRoomActivity;
import com.addon.room360.BookedAdapter;
import com.addon.room360.BookedClass;
import com.addon.room360.R;

import java.util.ArrayList;

public class PendingForcleaningFragment extends Fragment {

    public PendingForcleaningFragment() {

    }

    public static PendingForcleaningFragment newInstance() {
        PendingForcleaningFragment fragment = new PendingForcleaningFragment();

        fragment.setArguments(null);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pending_for_cleaning, container, false);
        ArrayList<BookedClass> arry = new ArrayList<>();


        arry.add(new BookedClass(117, "AC", 3));
        arry.add(new BookedClass(118, "NON AC", 2));
        arry.add(new BookedClass(119, "AC", 3));
        arry.add(new BookedClass(120, "AC", 3));
        arry.add(new BookedClass(121, "NON AC", 2));
        arry.add(new BookedClass(122, "AC", 3));
        arry.add(new BookedClass(123, "AC", 3));
        arry.add(new BookedClass(124, "NON AC", 2));
        arry.add(new BookedClass(125, "AC", 3));
        arry.add(new BookedClass(126, "AC", 3));
        arry.add(new BookedClass(127, "NON AC", 2));
        arry.add(new BookedClass(128, "AC", 3));
        arry.add(new BookedClass(129, "AC", 3));
        arry.add(new BookedClass(130, "NON AC", 2));
        arry.add(new BookedClass(131, "AC", 3));
        BookedAdapter adapter = new BookedAdapter(getContext(), arry);
        ListView list = view.findViewById(R.id.pending);
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


