package com.golda.app.pvttraining.dz5;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyService extends Service {
    MyBinder myBinder = new MyBinder();

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
