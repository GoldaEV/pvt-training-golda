package com.golda.app.myapplication;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String URI = "content://com.golda.pvtTraining.provider/mytable";
    private ArrayList<String> message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = new ArrayList<>();

        findViewById(R.id.btnGet).setOnClickListener(view -> {
            showContent();
            if (!message.isEmpty()) {
                Toast.makeText(this, message.get(0), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showContent() {

        Uri uri = Uri.parse(URI);
        ContentResolver resolver = getContentResolver();
        Cursor cursor = null;
        try {
            cursor = resolver.query(uri, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String n1 = cursor.getString(1);
                    message.add(n1);
                }
            }
        }finally {
            if (cursor != null) {
                cursor.close();
            }
        }

    }
}
