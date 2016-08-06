package com.wen.rfsystem;

import java.util.List;

/**
 * Created by wen on 2016/8/7.
 */
public interface SFsysDAO {

    public void sqladd(customer person);
    public void sqldel(int id);
    public void sqlupdata(int id);


    public void jasonsave();
    public void jasonload();




    public List getAllStudent();


}
