package com.wen.rfsystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Student on 2016/8/8.
 *
 *
 * 照搬080802的git 範例    (未完成!)
 *
 */
public class MyDBHelp extends SQLiteOpenHelper {

    final static String DB_Name = "customer.sqlite";
    final static int VERSION = 1;
    final static String CREATE_TABLE_SQL = "CREATE  TABLE main.student (_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , name VARCHAR,addr VARCHAR, tel VARCHAR)";


    public MyDBHelp(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DB", "This is onCreate");
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
