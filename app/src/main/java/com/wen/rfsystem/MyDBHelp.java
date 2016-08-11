package com.wen.rfsystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Student on 2016/8/8.
 * 照搬080802的git 範例    (未完成!)
看起來老師是參考  http://www.phperz.com/article/16/0409/195720.html
 */
public class MyDBHelp extends SQLiteOpenHelper {

    final static String DB_Name = "customer.sqlite";
    final static int VERSION = 1;
    final static String CREATE_TABLE_SQL =
            "CREATE  TABLE main.student (_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL ," +
                                              " name VARCHAR,addr VARCHAR," +
                                              " tel VARCHAR)";

//建構方法
    public MyDBHelp(Context context) {
        super(context,"customer", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DB", "DB is onCreate");
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
/*   高效入門範例
     private static MyDBHelper instance = null;
     public static MyDBHelper getInstance(Context ctx){
        if (instance==null){
            instance = new MyDBHelper(ctx, "expense.db", null, 1);
        }
        return instance;
    }

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE  TABLE main.exp " +
                "(_id INTEGER PRIMARY KEY  NOT NULL , " +
                "cdate DATETIME NOT NULL , " +
                "info VARCHAR, " +
                "amount INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

 */