package com.example.jonas.tracky.tracking;

import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.support.annotation.ColorInt;

/**
 * Created by jonas on 29.08.17.
 */

public class Activity {
    public String name;
    public String category;
    @ColorInt
    public int color;

    public Activity (String name, String category, int color) {
        this.name = name;
        this.category = category;
        this.color = color;
    }
}
