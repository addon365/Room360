package com.addon.room360;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chitti on 22-04-2018.
 */

public class BookedAdapter extends ArrayAdapter<BookedClass> {

    public BookedAdapter(Context context, ArrayList<BookedClass> arry){
        super(context,R.layout.listview,arry);


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        BookedClass arry = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview, parent, false);
        TextView book = convertView.findViewById(R.id.roomText);
        book.setText(arry.roomNumber);
        TextView AC= convertView.findViewById(R.id.ACtext);
        book.setText(arry.ACNonAC);
        TextView cap = convertView.findViewById(R.id.captext);
        book.setText(arry.capacity);
return convertView;
    }
}
