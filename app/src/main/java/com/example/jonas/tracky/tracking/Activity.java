package com.example.jonas.tracky.tracking;

import android.support.annotation.ColorInt;

/**
 * Created by jonas on 29.08.17.
 */

public class Activity {
    private String name;
    private String category;
    @ColorInt
    private int color;

    public Activity (String name, String category, int color) {
        this.name = name;
        this.category = category;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getColor() {
        return color;
    }
}
