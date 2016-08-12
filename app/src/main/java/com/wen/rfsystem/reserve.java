package com.wen.rfsystem;

import java.util.Date;

/**
 *
 * Created by Student on 2016/8/8.
 * 訂位資料ＣＬＡＳＳ
 *
 */
public class reserve {





//建構
    public reserve(

            int customer,
            int adult,
            int child,
            boolean checkout,
            boolean checkin,
            Date reservetime,
            String PS,
            String service
    ){

        this.customer=customer;
        this.adult=adult;
        this.child=child;
        this.checkout=checkout;
        this.checkin=checkin;
        this.reservetime=reservetime;
        this.PS=PS;
        this.service=service;
    }




    int id;   //訂位編號
    int customer;  //顧客資料   int customerID
    int adult;   //幾大幾小
    int child;
    boolean checkout;   //入場.出場
    boolean checkin;
    Date reservetime;  //訂位日期訂位時間
    String PS;         //備註
    String service;    //訂位人員

}