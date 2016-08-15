package com.wen.rfsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Created by wen on 2016/8/7.
 */
public class SFsysDAOImp implements SFsysDAO{

    SQLiteDatabase db;

    public SFsysDAOImp(Context context){

        MyDBHelp helper = new MyDBHelp(context);
        db = helper.getWritableDatabase();
    }

    @Override
    public long cusadd(customer person) {

        ContentValues cv = new ContentValues();
        cv.put("name",  person.name);
        cv.put("address", person.address);
        cv.put("tel", person.tel);
        cv.put("awkward", person.awkward);
        cv.put("VIP", person.VIP);
        cv.put("birthday", person.birthday.toString());   //DATA不能直接傳入?
        cv.put("address", person.address);
        cv.put("PS", person.PS);

        long id = db.insert("customer", null, cv);// 執行SQL 語句
        //研究一下ID資料庫自動增加怎麼寫
         return id;
    }

    @Override
    public void cusdel(customer person) {
        db.execSQL("Delete from customer where id='" + person._id + "'");
    }

    @Override
    public void cusupdata(customer person) {
        db.execSQL("Update customer set name='"+ person.name +
                "'address'" + person.address+
                "'tel'" + person.tel+
                "'awkward'" + person.awkward+
                "'VIP'" + person.VIP+
                "'birthday'" + person.birthday.toString()+
                "'address'" + person.address+
                "'PS'" +person.PS +
                "' Where id='" + person._id + "'" );
    }



//-------------------------------------------



    @Override
    public long resadd(reserve reserve) {

       int out=(reserve.checkout)? 1: 0;
       int in=(reserve.checkin)? 1:0;

        ContentValues cv = new ContentValues();
        cv.put("customer",  reserve.customer);
        cv.put("adult", reserve.adult);
        cv.put("child", reserve.child);
        cv.put("checkout",out) ;
        cv.put("checkin",in);
        cv.put("reservetime", reserve.reservetime.toString());   //DATA不能直接傳入?
        cv.put("PS", reserve.PS);
        cv.put("service", reserve.service);




        long id = db.insert("reserve", null, cv);// 執行SQL 語句
        return id;
    }


    @Override
    public void resdel(reserve reserve) {
        db.execSQL("Delete from customer where id='" + reserve._id + "'");
    }

    @Override
    public void resupdata(reserve reserve) {
        // db.execSQL("Update student set addr = '" + s.addr + "' ,tel='" + s.tel + "' Where name='" + s.name + "'");
        db.execSQL("Update customer set customer='"+reserve.customer+
                "'adult'" + reserve.adult+
                "'child'" + reserve.child+
                "'checkout'" + reserve.checkout+
                "'checkin'" + reserve.checkin+
                "'reservetime'" + reserve.reservetime.toString()+
                "'service'" + reserve.service+
                "'PS'" +reserve.PS +
                "' Where id='" + reserve._id + "'" );
    }



    @Override   //備分用  晚點再寫
    public void jasonsave() {

    }

    @Override
    public void jasonload() {

    }

    @Override
    public List getAllreserve() {
        ArrayList<reserve> mylist = new ArrayList<>();

        Cursor c = db.rawQuery("Select * from reserve", null);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*
CREATE_TABLE_SQLres = "CREATE  TABLE reserve ("+
                                           0 "_id INTEGER PRIMARY KEY  AUTOINCREMENT,"+  //UNIQUE?
                                           1 "customer INTEGER,"+    //用customer ID
                                            2"adult INTEGER,"+
                                           3 "child INTEGER, "+
                                          4  "checkout INTEGER,"+      //BOOL?
                                           5 "checkin INTEGER, "+
                                            6"reservetime  DATE,"+
                                           7 "PS VARCHAR,"+
                                          8  "service VARCHAR)";
 */

        if (c.moveToFirst())
        {
            do {
                Date dt = null;
                try {
                    dt = sdf.parse(c.getString(6));
                } catch (ParseException e) {
                    e.printStackTrace();
                    Log.d("ERR","日期轉換錯誤~");
                }
                reserve r = new reserve(c.getInt(1),c.getInt(2),c.getInt(3),
                        (c.getInt(4) == 1)? true : false,(c.getInt(5) == 1)? true : false,
                         dt,
                         c.getString(7),c.getString(8)  );
                mylist.add(r);


            } while (c.moveToNext());
        }
/*
                                             "CREATE  TABLE main.reserve ("+
                                            "id INTEGER PRIMARY KEY  NOT NULL AUTOINCREMENT   UNIQUE ,"+  //UNIQUE?
                                            "customer INTEGER,"+    //用customer ID
                                            "adult INTEGER,"+
                                            "child INTEGER, "+
                                            "checkout INTEGER,"+      //BOOL?
                                            "checkin INTEGER, "+
                                            "reserverDate DATE,"+
                                            "reservertime TIME,"+
                                            "PS VARCHAR,"+
                                            "service VARCHAR)";
 */



        return mylist;
    }


}
