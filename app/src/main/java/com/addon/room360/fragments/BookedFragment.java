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

import com.addon.room360.AddCusomer;
import com.addon.room360.AddRoomActivity;
import com.addon.room360.BookedAdapter;
import com.addon.room360.BookedClass;
import com.addon.room360.MainActivity;
import com.addon.room360.R;

import java.util.ArrayList;

/**
 * Created by chitti on 22-04-2018.
 */

public class BookedFragment extends Fragment {

    // TODO: Rename and change types and number of parameters
    public static BookedFragment newInstance() {
        BookedFragment fragment = new BookedFragment();

        fragment.setArguments(null);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.booked, container, false);
        final ArrayList<BookedClass> arry = new ArrayList<BookedClass>();

        arry.add(new BookedClass(101, "AC", 3));
        arry.add(new BookedClass(102, "NON AC", 2));
        arry.add(new BookedClass(103, "AC", 3));
        arry.add(new BookedClass(101, "AC", 3));
        arry.add(new BookedClass(102, "NON AC", 2));
        arry.add(new BookedClass(103, "AC", 3));
        arry.add(new BookedClass(104, "AC", 3));
        arry.add(new BookedClass(105, "NON AC", 2));
        arry.add(new BookedClass(106, "AC", 3));
        arry.add(new BookedClass(107, "AC", 3));
        arry.add(new BookedClass(108, "NON AC", 2));
        arry.add(new BookedClass(110, "AC", 3));
        arry.add(new BookedClass(111, "AC", 3));
        arry.add(new BookedClass(112, "NON AC", 2));
        arry.add(new BookedClass(113, "AC", 3));
        arry.add(new BookedClass(114, "AC", 3));
        arry.add(new BookedClass(115, "NON AC", 2));
        arry.add(new BookedClass(116, "AC", 3));
        BookedAdapter adapter = new BookedAdapter(getContext(), arry);
        ListView list = view.findViewById(R.id.bookedlist);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity().getBaseContext(),AddRoomActivity.class);
        intent.putExtra("Room", arry.get(position).getRoomNumber());
        startActivity(intent);
            }
        });
        return view;


    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
