package com.wen.rfsystem;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wen on 2016/8/7.
 */
public class SFsysDAOImp implements SFsysDAO{

    SQLiteDatabase db;


    @Override
    public void cusadd(customer person) {

        ContentValues cv = new ContentValues();
        cv.put("name",  person.name);
        cv.put("addr", person.address);
        cv.put("tel", person.tel);
        long id = db.insert("student", null, cv);// 執行SQL 語句
    }

    @Override
    public void cusdel(int id) {
        db.execSQL("Delete from student where name='" + id + "'");
    }

    @Override
    public void cusupdata(int id) {
        db.execSQL("Update student set addr = '" + id + "' ,tel='" + id + "' Where name='" + id + "'");
    }

    @Override
    public void resadd(reserve reserve) {

    }

    @Override
    public void resdel(int id) {

    }

    @Override
    public void resupdata(int id) {

    }

    @Override
    public void jasonsave() {

    }

    @Override
    public void jasonload() {

    }

    @Override
    public List getAllcustomer() {
        ArrayList<customer> mylist = new ArrayList<>();

        Cursor c = db.rawQuery("Select * from student", null);
        if (c.moveToFirst())
        {
            do {
                customer t = new customer();
                mylist.add(t);
            } while (c.moveToNext());
        }

        return mylist;
    }

    @Override
    public List getreserve(String day) {
        return null;
    }


}
