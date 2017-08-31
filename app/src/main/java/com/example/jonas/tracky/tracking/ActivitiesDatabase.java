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
    private SQLiteDatabase database;

    public ActivitiesDatabase (Context context) {
        ActivitesDbHelper helper = new ActivitesDbHelper(context);
        this.database = helper.getWritableDatabase();
    }

    public List<Activity> getAllActivities() {
        String[] projection = {
                ActivitiesContract.Activities.COLUMN_NAME,
                ActivitiesContract.Activities.COLUMN_CATEGORY,
                ActivitiesContract.Activities.COLUMN_COLOR
        };

        String selection = "";
        String[] selectionArgs = {};

        String sortOrder = ActivitiesContract.Activities.COLUMN_NAME + " DESC";

        Cursor cursor = this.database.query(
                ActivitiesContract.Activities.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        List<Activity> activities = new ArrayList<>();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(ActivitiesContract.Activities.COLUMN_NAME));
            String category = cursor.getString(cursor.getColumnIndexOrThrow(ActivitiesContract.Activities.COLUMN_CATEGORY));
            int color = cursor.getInt(cursor.getColumnIndexOrThrow(ActivitiesContract.Activities.COLUMN_COLOR));

            Activity activity = new Activity(name, category, color);
            activities.add(activity);

        }
        cursor.close();
        return activities;
    }

    public void addActivity(Activity activity) {
        ContentValues values = new ContentValues();
        values.put(ActivitiesContract.Activities.COLUMN_NAME, activity.getName());
        values.put(ActivitiesContract.Activities.COLUMN_CATEGORY, activity.getCategory());
        values.put(ActivitiesContract.Activities.COLUMN_COLOR, activity.getColor());

        database.insert(ActivitiesContract.Activities.TABLE_NAME, null, values);
    }
}
