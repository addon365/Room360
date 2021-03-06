package com.addon.room360;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.addon.room360.data.RoomContract;
import com.addon.room360.data.RoomDbHelper;

import java.text.NumberFormat;

public class AddCusomer extends AppCompatActivity {

    EditText Add_Cust_Name, Add_Cust_Add1, Add_Cust_Add2, Add_City, Add_Zip, Add_Mobile_Num, Add_Proof;
    Spinner Add_proof_type;
    private RoomDbHelper mDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cusomer);

        Spinner spinner = (Spinner) findViewById(R.id.proof);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Proof, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button btn = (Button) findViewById(R.id.Add_cust);
        mDbHelper = new RoomDbHelper(AddCusomer.this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(AddCusomer.this,    CustomerBookingActivity.class);

                SQLiteDatabase db = mDbHelper.getWritableDatabase();
                //startActivity(i);
                insertNewCustomer();

                finish();
            }
        });
        Add_Cust_Name= findViewById(R.id.Add_customer_name);
        Add_Cust_Add1= findViewById(R.id.Add_Address_Line1);
        Add_Cust_Add2= findViewById(R.id.Add_Add_Line2);
        Add_City = findViewById(R.id.Add_City);
        Add_Zip = findViewById(R.id.Add_Pin_Code);
        Add_Mobile_Num= findViewById(R.id.Add_Mobile);
        Add_Proof = findViewById(R.id.Add_proof);
        Add_proof_type = spinner;

    }


    private void displayDatabaseInfo() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                RoomContract.RoomEntry._ID,
                RoomContract.RoomEntry.COLUMN_CUSTOMER_NAME,
                RoomContract.RoomEntry.COLUMN_ADDRESS_1,
                RoomContract.RoomEntry.COLUMN_ADDRESS_2,
                RoomContract.RoomEntry.COLUMN_CITY,
                RoomContract.RoomEntry.COLUMN_PROOF,
                RoomContract.RoomEntry.COLUMN_ZIP,
                RoomContract.RoomEntry.COLUMN_MOBILE_NUM };

        // Perform a query on the pets table
        Cursor cursor = db.query(
                RoomContract.RoomEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                   // The sort order

        TextView displayView = (TextView) findViewById(R.id.customer_details);

        try {
            // Create a header in the Text View that looks like this:
            //
            // The pets table contains <number of rows in Cursor> pets.
            // _id - name - breed - gender - weight
            //
            // In the while loop below, iterate through the rows of the cursor and display
            // the information from each column in this order.
            displayView.setText("The Customerinfo table contains " + cursor.getCount() + " pets.\n\n");
            displayView.append(RoomContract.RoomEntry._ID + " - " +
                    RoomContract.RoomEntry.COLUMN_CUSTOMER_NAME+ " - " +
                    RoomContract.RoomEntry.COLUMN_ADDRESS_1 + " - " +
                    RoomContract.RoomEntry.COLUMN_ADDRESS_2 + " - " +
                    RoomContract.RoomEntry.COLUMN_CITY+ " - " +
                    RoomContract.RoomEntry.COLUMN_ZIP + " - " +
                    RoomContract.RoomEntry.COLUMN_PROOF + " - " +
                    RoomContract.RoomEntry.COLUMN_MOBILE_NUM +
                    "\n");

            // Figure out the index of each column
            int idColumnIndex = cursor.getColumnIndex(RoomContract.RoomEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(RoomContract.RoomEntry.COLUMN_CUSTOMER_NAME);
            int Addcolumnindex = cursor.getColumnIndex(RoomContract.RoomEntry.COLUMN_ADDRESS_1);
            int Add2columnindex = cursor.getColumnIndex(RoomContract.RoomEntry.COLUMN_ADDRESS_2);
            int cityindexcolumn= cursor.getColumnIndex(RoomContract.RoomEntry.COLUMN_CITY);
            int zipcolumn = cursor.getColumnIndex(RoomContract.RoomEntry.COLUMN_ZIP);
            int mobileindexcolumn= cursor.getColumnIndex(RoomContract.RoomEntry.COLUMN_MOBILE_NUM);
            int proofcolumn = cursor.getColumnIndex(RoomContract.RoomEntry.COLUMN_PROOF);
            int prooftype = cursor.getColumnIndex(RoomContract.RoomEntry.COLUMN_PROOF_TYPE);

            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentAdd1 = cursor.getString(Addcolumnindex);
                String currentAdd2 = cursor.getString(Add2columnindex);
                String CITY = cursor.getString(cityindexcolumn);
                int zip = cursor.getInt(zipcolumn);
                int mobile = cursor.getInt(mobileindexcolumn);
                String proof = cursor.getString(proofcolumn);
                String proof_type =cursor.getString(prooftype);
                // Display the values from each column of the current row in the cursor in the TextView
                displayView.append(("\n" + currentID + " - " +
                        currentName + " - " +
                        currentAdd1 + " - " +
                        currentAdd2 + " - " +
                        CITY + " - " +
                        mobile + " - " +
                        zip + " - " +
                        proof+ " - "
                + proof_type ));
            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }

    private void insertNewCustomer() {
        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(RoomContract.RoomEntry.COLUMN_CUSTOMER_NAME, Add_Cust_Name.getText().toString() );
        values.put(RoomContract.RoomEntry.COLUMN_ADDRESS_1, Add_Cust_Add1.getText().toString());
        values.put(RoomContract.RoomEntry.COLUMN_ADDRESS_2, Add_Cust_Add2.getText().toString());
        values.put(RoomContract.RoomEntry.COLUMN_CITY, Add_City.getText().toString());
        values.put(RoomContract.RoomEntry.COLUMN_ZIP, Add_Zip.getText().toString());
        values.put(RoomContract.RoomEntry.COLUMN_MOBILE_NUM, Add_Mobile_Num.getText().toString());
        values.put(RoomContract.RoomEntry.COLUMN_PROOF, Add_Proof.getText().toString());
        values.put(RoomContract.RoomEntry.COLUMN_PROOF_TYPE, Add_proof_type.getSelectedItem().toString());

        // Insert a new row for Toto in the database, returning the ID of that new row.

        long newRowId = db.insert(RoomContract.RoomEntry.TABLE_NAME, null, values);
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving customer", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Customer Add " + newRowId, Toast.LENGTH_SHORT).show();
        }

    }


}
