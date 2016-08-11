package com.wen.rfsystem;

import java.util.Date;

/**
 * Created by wen on 2016/8/6.
 *會員資料CLASS
 *
 */
public class customer {

    //建構
    public customer(
        int id,
        int sex,
        int awkward,
        String awkreason,
        int VIP,
        String name,
        String birthday,
        String address,
        String tel,
        String PS )
    {

    }




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
}
