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
                r._id=c.getInt(0);
                mylist.add(r);
            } while (c.moveToNext());
        }
        return mylist;
    }

    @Override
    public List getAllcuserve() {
        ArrayList<customer> mylist = new ArrayList<>();
        Cursor c = db.rawQuery("Select * from customer", null);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

                customer person = new customer(
                                            c.getInt(2),
                                            c.getInt(3) ,
                                            c.getString(4) ,
                                            c.getInt(5) ,
                                            c.getString(1) ,
                                            dt ,
                                            c.getString(7) ,
                                            c.getString(8),
                                            c.getString(9)

                );

                person._id=c.getInt(0);
                mylist.add(person);
            } while (c.moveToNext());
        }
        return mylist;
    }

/*
                                            0"_id INTEGER PRIMARY KEY  AUTOINCREMENT ,"+
                                            1"name VARCHAR,"+
                                            2"sex INTEGER,"+
                                            3"awkward INTEGER,"+
                                            4"awkreason VARCHAR,"+
                                            5"VIP INTEGER,"+
                                            6"birthday DATE,"+
                                            7"address VARCHAR,"+
                                            8"tel VARCHAR,"+
                                            9"PS VARCHAR)";


  int awkward,
                    String awkreason,
                    int VIP,
                    String name,
                    Date birthday,
                    String address,
                    String tel,
                    String PS )
 */
}
