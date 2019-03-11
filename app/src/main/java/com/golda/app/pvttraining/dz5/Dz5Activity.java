package com.golda.app.pvttraining.dz5;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.TextView;

import com.golda.app.pvttraining.R;

public class Dz5Activity extends Activity {
    private TextView textView;
    private MyService myService;
    private boolean bound;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dz5);

        textView = findViewById(R.id.textView);
        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bound) {
                    myService.getWifiState();
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE);

        IntentFilter intentFilter = new IntentFilter(MyService.MY_ACTION);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    boolean booleanExtra = intent.getBooleanExtra(MyService.EXTRA_KEY, false);
                    textView.setText("WiFi state: " + booleanExtra);

                }
            }
        };

        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        unbindService(serviceConnection);
    }


    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myService = ((MyService.MyBinder) iBinder).getService();
            bound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            bound = false;
        }
    };
}
