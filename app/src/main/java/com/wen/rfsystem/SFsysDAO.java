package com.wen.rfsystem;

import java.util.List;

/**
 * Created by wen on 2016/8/7.
 *
 * ＤＡＯ　ＣＬＡＳＳ
 */
public interface SFsysDAO {

    public void cusadd(customer person);  //顧客資料SQLite新增刪除修改
    public void cusdel(int id);
    public void cusupdata(int id);

    public void resadd(reserve reserve);  //訂位資料SQLite新增刪除修改
    public void resdel(int id);
    public void resupdata(int id);


    public void jasonsave();              //讀寫JSON (用匯出/儲存/備分)
    public void jasonload();




    public List getAllStudent();


}
