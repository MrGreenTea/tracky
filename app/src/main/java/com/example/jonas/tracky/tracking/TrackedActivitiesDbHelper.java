package com.example.jonas.tracky.tracking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jonas on 31.08.17.
 */

public class TrackedActivitiesDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TrackedActivities.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TrackedActivitiesContract.TrackedActivities.TABLE_NAME + " (" +
                    TrackedActivitiesContract.TrackedActivities._ID + " INTEGER PRIMARY KEY, " +
                    TrackedActivitiesContract.TrackedActivities.COLUMN_ACTIVITY+ " TEXT, " +
                    TrackedActivitiesContract.TrackedActivities.COLUMN_END_TIME + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ActivitiesContract.Activities.TABLE_NAME;

    public TrackedActivitiesDbHelper(Context context) {
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
