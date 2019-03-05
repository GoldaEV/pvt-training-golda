package com.golda.app.pvttraining.cw5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.golda.app.pvttraining.R;

public class Cw5Activity extends AppCompatActivity {
    private static final String TAG = "Cw5Activity";

    private static final String MY_ACTION = "com.golda.app.pvttraining.cw5.MY_ACTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cw5);




    }



    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(wifiReceiver, intentFilter);

        IntentFilter myIntentFilter1 = new IntentFilter();
        myIntentFilter1.addAction(MY_ACTION);
        registerReceiver(myAction, myIntentFilter1);

    }


    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = new Intent();
        intent.setAction(MY_ACTION);
        sendBroadcast(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiReceiver);
        unregisterReceiver(myAction);
    }

    private BroadcastReceiver wifiReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e(TAG, "Change WiFi state");
        }
    };


    private BroadcastReceiver myAction = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e(TAG, "My Action");
        }
    };

}
