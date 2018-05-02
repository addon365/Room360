package com.addon.room360;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class AddCusomer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cusomer);

        Spinner spinner = (Spinner) findViewById(R.id.proof);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Proof, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button btn = (Button) findViewById(R.id.Add_cust);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddCusomer.this, CustomerBookingActivity.class);
                startActivity(i);
            }
        });
    }
}
