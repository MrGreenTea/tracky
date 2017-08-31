package com.example.jonas.tracky.tracking;

import android.provider.BaseColumns;

/**
 * Created by jonas on 31.08.17.
 */

public final class TrackedActivitiesContract {
    private TrackedActivitiesContract() {}

    public static final class TrackedActivities implements BaseColumns {
        public static final String TABLE_NAME = "tracked_activities";
        public static final String COLUMN_ACTIVITY = "activity";
        public static final String COLUMN_END_TIME = "endtime";
    }
}
