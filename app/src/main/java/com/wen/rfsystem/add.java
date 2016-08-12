package com.wen.rfsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

    }

    public void click_add(View v)
    {
         EditText nameed = (EditText) findViewById(R.id.nameEDText);
       //EditText awkward = (EditText) findViewById(R.id.);
       //EditText awkreason = (EditText) findViewById(R.id.);
       //EditText VIP = (EditText) findViewById(R.id.);
         EditText adultEDText = (EditText) findViewById(R.id.adultEDText);
         EditText childEDText = (EditText) findViewById(R.id.childEDText);
         EditText tel = (EditText) findViewById(R.id.telEDText);
         EditText PS = (EditText) findViewById(R.id.PSEDText);

         //String n = ed.getText().toString();



        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dt = null;
        try {
            dt = sdf.parse("2016-08-22 12:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
            Log.d("ERR","日期轉換錯誤~");
        }


        SFsysDAO dao = new SFsysDAOImp(add.this);
        long cusid=dao.cusadd(new customer(1,
                                0,
                                "",
                                0,
                                nameed.getText().toString(),
                                dt,
                                "",
                                tel.getText().toString(),
                                PS.getText().toString())
                    );



        dao.resadd(new reserve(
                                cusid,
                                parseInt( adultEDText.getText().toString()),
                                parseInt( childEDText.getText().toString()) ,
                                false,
                                false,
                                dt,
                                "",
                                PS.getText().toString()
                                )
                  );
    }








}

