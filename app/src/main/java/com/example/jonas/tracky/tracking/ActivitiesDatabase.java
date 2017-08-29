package com.example.jonas.tracky.tracking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 29.08.17.
 */

public class ActivitiesDatabase {
    private SQLiteDatabase writeDatabase;
    private SQLiteDatabase readDatabase;

    public ActivitiesDatabase (Context context) {
        ActivitesDbHelper helper = new ActivitesDbHelper(context);
        this.readDatabase = helper.getReadableDatabase();
        this.writeDatabase = helper.getWritableDatabase();
    }

    public List<Activity> getAllActivities() {
        String[] projection = {
                ActivityContract.Activities.COLUMN_NAME,
                ActivityContract.Activities.COLUMN_CATEGORY,
                ActivityContract.Activities.COLUMN_COLOR
        };

        String selection = "";
        String[] selectionArgs = {};

        String sortOrder = ActivityContract.Activities.COLUMN_NAME + " DESC";

        Cursor cursor = this.readDatabase.query(
                ActivityContract.Activities.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        List<Activity> activities = new ArrayList<>();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(ActivityContract.Activities.COLUMN_NAME));
            String category = cursor.getString(cursor.getColumnIndexOrThrow(ActivityContract.Activities.COLUMN_CATEGORY));
            int color = cursor.getInt(cursor.getColumnIndexOrThrow(ActivityContract.Activities.COLUMN_COLOR));

            Activity activity = new Activity(name, category, color);
            activities.add(activity);

        }
        cursor.close();
        return activities;
    }

    public void addActivity(Activity activity) {
        ContentValues values = new ContentValues();
        values.put(ActivityContract.Activities.COLUMN_NAME, activity.name);
        values.put(ActivityContract.Activities.COLUMN_CATEGORY, activity.category);
        values.put(ActivityContract.Activities.COLUMN_COLOR, activity.color);

        writeDatabase.insert(ActivityContract.Activities.TABLE_NAME, null, values);
    }
}
