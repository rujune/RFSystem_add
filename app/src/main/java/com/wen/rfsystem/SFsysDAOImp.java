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
        db.execSQL("Update customer set addr='"+

                "'name+ person.name"+
                "'address'" + person.address+
                "'tel'" + person.tel+
                "'awkward'" + person.awkward+
                "'VIP'" + person.VIP+
                "'birthday'" + person.birthday.toString()+
                "'address'" + person.address+
                "'PS'" +person.PS +
                "' Where id='" + person.id + "'" );
    }








    @Override
    public void resadd(reserve reserve) {

    }

    @Override
    public void resdel(reserve reserve) {

    }

    @Override
    public void resupdata(reserve reserve) {

    }



    @Override
    public void jasonsave() {

    }

    @Override
    public void jasonload() {

    }

    @Override
    public List getAllStudent() {
        return null;
    }


}
