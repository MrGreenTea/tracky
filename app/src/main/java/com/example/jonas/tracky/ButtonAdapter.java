package com.example.jonas.tracky;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.example.jonas.tracky.tracking.ActivitiesDatabase;
import com.example.jonas.tracky.tracking.Activity;

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
        database.addActivity(new Activity("Test2", "Test", Color.GREEN));
        database.addActivity(new Activity("Test3", "Test", Color.RED));
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        Button button;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            button = new Button(mContext);
            button.setPadding(8, 8, 8, 8);
            button.setHeight(button.getMeasuredWidth());
        } else {
            button = (Button) convertView;
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Clicked " + position, Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
        Activity activity = activities.get(position);
        button.setBackgroundColor(activity.getColor());
        button.setText(activity.getName());
        return button;
    }

}
