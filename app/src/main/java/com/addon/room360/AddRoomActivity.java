package com.addon.room360;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class AddRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);
        final TextView roomno = findViewById(R.id.Room_no);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Button btn = (Button) findViewById(R.id.btn);
Intent inte = getIntent();
String room = Integer.valueOf(inte.getIntExtra("Room", 0)).toString();
roomno.setText(room);
//String room = bundle.getString("Room_No");

//roomno.setText(room);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddRoomActivity.this, CustomerBookingActivity.class);
                i.putExtra("Room", roomno.getText() );

                startActivity(i);
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Room, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    // Menu icons are inflated just as they were with actionbar


    /**
     * Created by ShabnamRafi on 3/29/2018.
     */


}



