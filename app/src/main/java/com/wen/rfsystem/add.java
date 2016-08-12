package com.wen.rfsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);





    }

    public void click_add(View v)
    {
        /*
        int id;            //會員編號.SQLite的Key值
        int sex;           //性別
        int awkward;       //黑名單
        String awkreason;  //黑名單理由
        int VIP;           //VIP等級
        String name;       //姓名 生日 地址 電話 備註
        Date birthday;
        String address;
        String tel;
        String PS;

            int resid;   //訂位編號
        int customer;  //顧客資料   int customerID
        int adult;   //幾大幾小
        int child;
        boolean checkout;   //入場.出場
        boolean checkin;
        Date reservetime;  //訂位日期訂位時間
        String resPS;         //備註
        String service;    //訂位人員



         */
        EditText nameed = (EditText) findViewById(R.id.nameEDText);
       //EditText awkward = (EditText) findViewById(R.id.);
       // EditText awkreason = (EditText) findViewById(R.id.);
        //EditText VIP = (EditText) findViewById(R.id.);
        //EditText birthday = (EditText) findViewById(R.id.);
       //EditText address = (EditText) findViewById(R.id.);
        EditText tel = (EditText) findViewById(R.id.telEDText);
        EditText PS = (EditText) findViewById(R.id.PSEDText);

        String n = ed.getText().toString();



        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dt = null;
        try {
            dt = sdf.parse("2016-08-22 12:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
            Log.d("ERR","日期轉換錯誤~");
        }



        SFsysDAO dao = new SFsysDAOImp(add.this);
        dao.cusadd(new customer(1,
                                0,
                                "",
                                0,
                                nameed.getText().toString(),
                                dt,
                                "",
                                tel.getText().toString(),
                                PS.getText().toString())
                    );

        dao.resadd(new reserve(0,

                "",
                0,
                nameed.getText().toString(),
                dt,
                "",
                tel.getText().toString(),
                PS.getText().toString())
        );


    }








}

