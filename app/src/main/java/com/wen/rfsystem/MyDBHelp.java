package com.wen.rfsystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Date;

/**
 * Created by Student on 2016/8/8.
 * 搬080802的git 範例
  http://www.phperz.com/article/16/0409/195720.html
 */
public class MyDBHelp extends SQLiteOpenHelper {

    final static String DB_Name = "SFSdb.sqlite";
    final static int VERSION = 1;

    //CREATE customer SQL
    final static String CREATE_TABLE_SQLcus = " CREATE  TABLE main.customer ("+
                                            "id INTEGER PRIMARY KEY  NOT NULL ,"+
                                            "name VARCHAR,"+
                                            "sex INTEGER,"+
                                            "awkward INTEGER,"+
                                            "awkreason VARCHAR,"+
                                            "VIP INTEGER,"+
                                            "birthday DATETIME,"+
                                            "address VARCHAR,"+
                                            "tel VARCHAR,"+
                                            "PS VARCHAR)";

    //CREATE reserve SQL
    final static String CREATE_TABLE_SQLres = "CREATE  TABLE main.reserve ("+
                                            "id INTEGER PRIMARY KEY  NOT NULL  UNIQUE ,"+  //UNIQUE?
                                            "customer INTEGER,"+    //用customer ID
                                            "adult INTEGER,"+
                                            "child INTEGER, "+
                                            "checkout BOOL,"+      //BOOL?
                                            "checkin BOOL, "+
                                            "reservertime DATETIME,"+
                                            "PS VARCHAR,"+
                                            "service VARCHAR)";


//建構方法
   public MyDBHelp(Context context) {
        super(context,"customer", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DB", "cusDB is onCreate");
        db.execSQL(CREATE_TABLE_SQLcus);
        Log.d("DB", "resDB is onCreate");
        db.execSQL(CREATE_TABLE_SQLres);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


/*   範例
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