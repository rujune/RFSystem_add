package com.wen.rfsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

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
    public void cusadd(customer person) {

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
        //研究一下ID到底是資料庫自動增加還是要程式端判斷與寫入

    }

    @Override
    public void cusdel(customer person) {

        db.execSQL("Delete from customer where id='" + person.id + "'");

    }

    @Override
    public void cusupdata(customer person) {

        // db.execSQL("Update student set addr = '" + s.addr + "' ,tel='" + s.tel + "' Where name='" + s.name + "'");
        db.execSQL("Update customer set name='"+ person.name +
                "'address'" + person.address+
                "'tel'" + person.tel+
                "'awkward'" + person.awkward+
                "'VIP'" + person.VIP+
                "'birthday'" + person.birthday.toString()+
                "'address'" + person.address+
                "'PS'" +person.PS +
                "' Where id='" + person.id + "'" );
    }




//-------------------------------------------



    @Override
    public void resadd(reserve reserve) {

        ContentValues cv = new ContentValues();

        //cv.put("id",  reserve.id);
        cv.put("customer",  reserve.customer);
        cv.put("adult", reserve.adult);
        cv.put("child", reserve.child);
        cv.put("checkout", reserve.checkout);
        cv.put("checkin", reserve.checkin);
        cv.put("reservetime", reserve.reservetime.toString());   //DATA不能直接傳入?
        cv.put("service", reserve.service);
        cv.put("PS", reserve.PS);

        long id = db.insert("reserve", null, cv);// 執行SQL 語句
    }

    @Override
    public void resdel(reserve reserve) {
        db.execSQL("Delete from customer where id='" + reserve.id + "'");
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
                "' Where id='" + reserve.id + "'" );
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
        if (c.moveToFirst())
        {
            do {
                reserve r = new reserve(c.getInt(0),c.getInt(1),c.getInt(2), c.getInt(3),
                        c.getBlob(4).,c.getBlob(5),
                        c.getString(6),
                        c.getString(7),c.getString(8), c.getString(9));
                mylist.add(r);
                //45   bool->int?
                //6    String->Date

            } while (c.moveToNext());
        }
/*
                                            "id INTEGER PRIMARY KEY  NOT NULL  UNIQUE ,"+  //UNIQUE?
                                            "customer INTEGER,"+    //用customer ID
                                            "adult INTEGER,"+
                                            "child INTEGER, "+
                                            "checkout BOOL,"+      //BOOL?
                                            "checkin BOOL, "+
                                            "reservertime DATETIME,"+
                                            "PS VARCHAR,"+
                                            "service VARCHAR)";

 */



        return mylist;
    }


}
