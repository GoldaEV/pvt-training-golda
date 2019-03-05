package com.golda.app.pvttraining;

import android.app.Application;
import android.util.Log;

public class App extends Application {
    private static App inst;
    private static final String TAG = "App";

    @Override
    public void onCreate() {
        super.onCreate();
        inst = this;

        Log.e(TAG, "onCreate");
    }

    public static App getInstance() {
        return  inst;
    }
    
}
