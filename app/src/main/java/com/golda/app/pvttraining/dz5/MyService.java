package com.golda.app.pvttraining.dz5;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class MyService extends Service {
    private MyBinder myBinder = new MyBinder();
    public static final String MY_ACTION = "com.golda.app.pvttraining.dz5.MY_ACTION";
    public static final String EXTRA_KEY = "EXTRA_KEY";

    private static final String TAG = "MyService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return myBinder;
    }

    class MyBinder extends Binder{

        MyService getService() {
            return MyService.this;
        }
    }

    public void bindWiFiMessage() {
        Log.d(TAG, "bindWiFiMessage");
        IntentFilter filters = new IntentFilter(Intent.ACTION_TIME_TICK);
        registerReceiver(timeReceiver, filters);
    }

    public void unbindWiFiMessage() {
        Log.d(TAG, "unbindWiFiMessage");
        unregisterReceiver(timeReceiver);
    }

    private BroadcastReceiver timeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Intent intMes = new Intent();
            intent.putExtra(EXTRA_KEY, "Time Changed");
            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intMes);
        }
    };
}
