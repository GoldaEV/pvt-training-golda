package com.golda.app.pvttraining.dz5;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
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
    private boolean mWifiConnected;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        bindWiFiMessage();
        return myBinder;
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
        unbindWiFiMessage();
    }

    class MyBinder extends Binder{

        MyService getService() {
            return MyService.this;
        }
    }

    public void bindWiFiMessage() {
        Log.d(TAG, "bindWiFiMessage");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION);
        registerReceiver(broadcastReceiver, intentFilter);
    }

    public void unbindWiFiMessage() {
        Log.d(TAG, "unbindWiFiMessage");

        unregisterReceiver(broadcastReceiver);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            if (action.equals(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION)) {
                if (intent.getBooleanExtra(WifiManager.EXTRA_SUPPLICANT_CONNECTED, false)) {
                    sendWifiState(true);
                } else {
                    sendWifiState(false);
                }
            }
        }
    };

    public void getWifiState() {
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        mWifiConnected = mWifi.isConnected();
        sendWifiState();
    }

    public void sendWifiState() {
        sendWifiState(mWifiConnected);
    }

    public void sendWifiState(boolean state) {
        Intent intMes = new Intent(MY_ACTION);
        intMes.putExtra(EXTRA_KEY, state);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intMes);
    }
}
