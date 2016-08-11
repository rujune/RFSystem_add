package com.wen.rfsystem;

import java.util.Date;

/**
 *
 * Created by Student on 2016/8/8.
 * 訂位資料ＣＬＡＳＳ
 *
 */
public class reserve {

    customer customer;  //顧客資料

    int adult;   //幾大幾小
    int child;

    boolean checkout;   //入場.出場
    boolean checkin;

    Date reservetime;  //訂位日期訂位時間
    String PS;           //備註
    String service;    //訂位人員

}
