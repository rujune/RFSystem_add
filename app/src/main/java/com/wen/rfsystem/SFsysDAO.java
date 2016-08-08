package com.wen.rfsystem;

import java.util.List;

/**
 * Created by wen on 2016/8/7.
 *
 * ＤＡＯ　ＣＬＡＳＳ
 */
public interface SFsysDAO {

    public void sqladd(customer person);  //SQLite新增刪除修改
    public void sqldel(int id);
    public void sqlupdata(int id);


    public void jasonsave();              //讀寫JSON (用匯出/儲存/備分)
    public void jasonload();




    public List getAllStudent();


}
