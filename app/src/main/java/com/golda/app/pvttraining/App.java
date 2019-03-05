package com.golda.app.pvttraining;

import android.app.Application;

public class App extends Application {
    private static App inst;
   
    @Override
    public void onCreate() {
        super.onCreate();
        inst = this;
    }

    public static App getInstance() {
        return  inst;
    }
    
}
