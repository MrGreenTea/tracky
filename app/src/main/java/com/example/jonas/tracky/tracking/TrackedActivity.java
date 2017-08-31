package com.example.jonas.tracky.tracking;

/**
 * Created by jonas on 31.08.17.
 */

public class TrackedActivity {
    private Activity activity;
    private long endtime;

    public TrackedActivity (Activity activity, long endtime) {
        this.activity = activity;
        this.endtime = endtime;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public long getEndtime() {
        return this.endtime;
    }
}
