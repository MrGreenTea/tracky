package com.example.jonas.tracky.tracking;

import android.provider.BaseColumns;

/**
 * Created by jonas on 29.08.17.
 */

public final class ActivitiesContract {
    private ActivitiesContract() {}

    public static class Activities implements BaseColumns {
        public static final String TABLE_NAME = "activities";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_COLOR = "color";
    }
}

