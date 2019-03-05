package com.golda.app.pvttraining.cw5;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
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


        /// Local Receiver

//        LocalBroadcastManager.getInstance(this).registerReceiver("""");

        /// Service

//        startService(new Intent(this, MyService.class));
//
//         // Sevice через Bind
//        bindService(new Intent(this, MyService.class), myServiceConnection, Context.BIND_AUTO_CREATE);

        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra(MyIntentService.TASK_EXTRA, "Hello Service1");
        startService(intent);

        Intent intent1 = new Intent(this, MyIntentService.class);
        intent1.putExtra(MyIntentService.TASK_EXTRA, "Hello Service2");
        startService(intent1);

        Intent intent2 = new Intent(this, MyIntentService.class);
        intent2.putExtra(MyIntentService.TASK_EXTRA, "Hello Service3");
        startService(intent2);

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

//        stopService(new Intent(this, MyService.class));
        unbindService(myServiceConnection);
    }

    private BroadcastReceiver wifiReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e(TAG, "Change WiFi state");
        }
    };

    private ServiceConnection myServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };


    private BroadcastReceiver myAction = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e(TAG, "My Action");
        }
    };

}
