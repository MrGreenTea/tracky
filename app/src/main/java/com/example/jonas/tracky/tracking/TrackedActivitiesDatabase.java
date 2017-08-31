package com.example.jonas.tracky.tracking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 31.08.17.
 */

public class TrackedActivitiesDatabase {
    private SQLiteDatabase database;

    public TrackedActivitiesDatabase (Context context) {
        TrackedActivitiesDbHelper helper = new TrackedActivitiesDbHelper(context);
        this.database = helper.getWritableDatabase();
    }

    public List<TrackedActivity> getActivitesFromTo(int from, int to) {
        String[] projection = {
                TrackedActivitiesContract.TrackedActivities._ID,
                TrackedActivitiesContract.TrackedActivities.COLUMN_ACTIVITY,
                TrackedActivitiesContract.TrackedActivities.COLUMN_END_TIME
        };

        String selection = TrackedActivitiesContract.TrackedActivities.COLUMN_END_TIME + " BETWEEN ? AND ?";
        String[] selectionArgs = { Integer.toString(from), Integer.toString(to) };

        String sortOrder = TrackedActivitiesContract.TrackedActivities.COLUMN_END_TIME + " DESC";

        Cursor cursor = database.query(
                TrackedActivitiesContract.TrackedActivities.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
                );

        List<TrackedActivity> activities = new ArrayList<>();
        while (cursor.moveToNext()) {
            long endtime = cursor.getLong(cursor.getColumnIndexOrThrow(TrackedActivitiesContract.TrackedActivities.COLUMN_END_TIME));
            String activityName = cursor.getString(cursor.getColumnIndexOrThrow(TrackedActivitiesContract.TrackedActivities.COLUMN_ACTIVITY));
            TrackedActivity activity = new TrackedActivity(new Activity(activityName, "", 0), endtime);
            activities.add(activity);
        }

        cursor.close();
        return activities;
    }

    public void trackActivity(Activity activity, int endtime) {
        ContentValues values = new ContentValues();
        values.put(TrackedActivitiesContract.TrackedActivities.COLUMN_ACTIVITY, activity.getName());
        values.put(TrackedActivitiesContract.TrackedActivities.COLUMN_END_TIME, endtime);

        database.insert(TrackedActivitiesContract.TrackedActivities.TABLE_NAME, null, values);
    }
}
