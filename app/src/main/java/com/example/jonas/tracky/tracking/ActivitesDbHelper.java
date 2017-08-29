package com.example.jonas.tracky.tracking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jonas on 29.08.17.
 */



public class ActivitesDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Activities.db";


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ActivityContract.Activities.TABLE_NAME + " (" +
                    ActivityContract.Activities.COLUMN_NAME + " TEXT PRIMARY KEY, " +
                    ActivityContract.Activities.COLUMN_CATEGORY + " TEXT, " +
                    ActivityContract.Activities.COLUMN_COLOR + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ActivityContract.Activities.TABLE_NAME;

    public ActivitesDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}