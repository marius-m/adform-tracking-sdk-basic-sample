package com.adform.trackingsdk;

import android.app.Application;

import com.adform.adformtrackingsdk.AdformTrackingSdk;

public class DemoApp extends Application {

    public static final String TAG = "DemoApp";

    @Override
    public void onCreate() {
        super.onCreate();
        AdformTrackingSdk.startTracking(this, Constants.TRACK_POINT_ID);
    }
}
