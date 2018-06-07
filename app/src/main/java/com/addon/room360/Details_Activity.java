package com.addon.room360;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.addon.room360.data.RoomContract;
import com.addon.room360.data.RoomDbHelper;

public class Details_Activity extends AppCompatActivity {
private RoomDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);
 mDbHelper = new RoomDbHelper(this);
displayDatabaseInfo();
        Button b;
        b= findViewById(R.id.clear);
b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        clear();
    }
});
    }





public void clear(){
    SQLiteDatabase db = mDbHelper.getWritableDatabase();

    String SQL_drop = "DROP TABLE " + RoomContract.RoomEntry.TABLE_NAME;

    db.execSQL(SQL_drop);

    String SQL_CREATE_ROOM_TABLE = "CREATE TABLE "  + RoomContract.RoomEntry.TABLE_NAME + "("
            + RoomContract.RoomEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + RoomContract.RoomEntry.COLUMN_CUSTOMER_NAME + " TEXT NOT NULL, "
            + RoomContract.RoomEntry.COLUMN_ADDRESS_1 + " TEXT NOT NULL, "
            + RoomContract.RoomEntry.COLUMN_ADDRESS_2 + " TEXT NOT NULL, "
            + RoomContract.RoomEntry.COLUMN_CITY + " TEXT NOT NULL, "
            + RoomContract.RoomEntry.COLUMN_ZIP + " INTEGER NOT NULL,"
            + RoomContract.RoomEntry.COLUMN_PROOF_TYPE + " TEXT NOT NULL, "
            + RoomContract.RoomEntry.COLUMN_MOBILE_NUM + " INTEGER NOT NULL, "
            + RoomContract.RoomEntry.COLUMN_PROOF + " TEXT NOT NULL ); " ;
    db.execSQL(SQL_CREATE_ROOM_TABLE);

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
                RoomContract.RoomEntry.COLUMN_MOBILE_NUM,
                RoomContract.RoomEntry.COLUMN_PROOF_TYPE};

        // Perform a query on the pets table
        Cursor cursor = db.query(
                RoomContract.RoomEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                   // The sort order

        TextView displayView =  findViewById(R.id.customer_details);

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
                            RoomContract.RoomEntry.COLUMN_PROOF_TYPE+
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
                String mobile = cursor.getString(mobileindexcolumn);
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
                        + proof_type
                ));
            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }


}
