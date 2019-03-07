package com.golda.app.pvttraining.dz5;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyService extends Service {
    private MyBinder myBinder = new MyBinder();
    public static final String MY_ACTION = "com.golda.app.pvttraining.dz5.MY_ACTION";

    private static final String TAG = "MyService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class MyBinder extends Binder{
        MyService getService() {
            return MyService.this;
        }
    }

    public void bindWiFiMessage() {

    }

    public void unbindWiFiMessage() {

    }
}
