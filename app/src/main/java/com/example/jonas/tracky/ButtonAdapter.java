package com.example.jonas.tracky;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.jonas.tracky.tracking.ActivitesDbHelper;
import com.example.jonas.tracky.tracking.ActivitiesDatabase;
import com.example.jonas.tracky.tracking.Activity;
import com.example.jonas.tracky.tracking.ActivityContract;

import java.util.List;

/**
 * Created by jonas on 29.08.17.
 */

public class ButtonAdapter extends BaseAdapter {
    private Context mContext;
    private ActivitiesDatabase database;
    private List<Activity> activities;

    public ButtonAdapter(Context c) {
        mContext = c;
        database = new ActivitiesDatabase(mContext);
        database.addActivity(new Activity("Test1", "Test", Color.BLUE));
        database.addActivity(new Activity("Test2", "Test", Color.RED));
        database.addActivity(new Activity("Test3", "Test", Color.GREEN));
        activities = database.getAllActivities();
    }

    public int getCount() {
        return activities.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            button = new Button(mContext);
            button.setLayoutParams(new GridView.LayoutParams(85, 85));
            button.setPadding(8, 8, 8, 8);
        } else {
            button = (Button) convertView;
        }

        Activity activity = activities.get(position);
        button.setBackgroundColor(activity.color);
        button.setText(activity.name);
        return button;
    }

}
