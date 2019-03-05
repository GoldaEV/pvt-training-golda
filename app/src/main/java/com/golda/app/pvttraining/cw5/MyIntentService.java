package com.golda.app.pvttraining.cw5;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {
    public static final String TASK_EXTRA = "TASK_EXTRA";
    private static final String TAG = "MyIntentService";

    public MyIntentService() {
        super("MyNameService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String task = intent.getStringExtra(TASK_EXTRA);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.e(TAG, "onHandleIntent: " + task);
    }
}
