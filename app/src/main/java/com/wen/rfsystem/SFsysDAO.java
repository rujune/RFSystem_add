package com.wen.rfsystem;

import java.util.List;

/**
 * Created by wen on 2016/8/7.
 *
 * ＤＡＯ　ＣＬＡＳＳ
 */
public interface SFsysDAO {

    public long cusadd(customer person);  //顧客資料SQLite新增刪除修改
    public void cusdel(customer person);
    public void cusupdata(customer person);

    public long resadd(reserve reserve);  //訂位資料SQLite新增刪除修改
    public void resdel(reserve reserve);
    public void resupdata(reserve reserve);


    public void jasonsave();              //讀寫JSON (用匯出/儲存/備分)
    public void jasonload();




    public List getAllreserve();
    public List getAllcuserve();


}
