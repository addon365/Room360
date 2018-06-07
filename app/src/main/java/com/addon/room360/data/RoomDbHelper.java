package com.addon.room360.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RoomDbHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME="room.db";


    private static final int DATABASE_VERSION=1;

    public RoomDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
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

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
