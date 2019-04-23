package com.golda.app.pvttraining.content_provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "mydb", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table mytable(_id integer primary key autoincrement, message text)");
        ContentValues cv = new ContentValues();
        cv.put("message","HELLO");
        db.insert("mytable", null, cv);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
