package com.wen.rfsystem;
/**
* 訂位系統專題  博文
 *
* */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> disp = new ArrayList<>();
    ListView lv;
    ArrayAdapter<String> adapter;

    public MainActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        SFsysDAO dao = new SFsysDAOImp(MainActivity.this);
        List<reserve> mylist = dao.getAllreserve();
        for (reserve s : mylist)
        {
            disp.add(s.PS);
            Log.d("PS:",s.PS);
        }

        adapter = new ArrayAdapter<String>( MainActivity.this,
                                            android.R.layout.simple_list_item_1,
                                            disp);

        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);


     /*
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(MainActivity.this, DetailActivity.class);
                it.putExtra("pos", position);
                startActivity(it);
            }

        });

        */
    }



    @Override
    protected void onResume() {
        super.onResume();
        SFsysDAO dao = new SFsysDAOImp(MainActivity.this);
        List<reserve> mylist = dao.getAllreserve();
        disp.clear();
        for (reserve s :mylist)
        {
            disp.add(s.PS);
        }
        adapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add)
        {
            Intent it = new Intent(MainActivity.this, add.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }






}







/* 0805範例
    StudentDAO dao = new StudentDAODBImpl(MainActivity.this);
    dao.addStudent(new Student("AA", "11", "11111"));
    dao.addStudent(new Student("BB", "22", "222"));
    dao.addStudent(new Student("CC", "33", "3333"));

List<Student> mylist = dao.getAllStudent();
for (Student s : mylist)
        {
        disp.add(s.name);
        }
        adapter = new ArrayAdapter<String>(
        MainActivity.this,
        android.R.layout.simple_list_item_1,
        disp
        );
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent it = new Intent(MainActivity.this, DetailActivity.class);
        it.putExtra("pos", position);
        startActivity(it);
        }
        });
        }

@Override
protected void onResume() {
        super.onResume();
        StudentDAO dao = new StudentDAODBImpl(MainActivity.this);
        List<Student> mylist = dao.getAllStudent();
        disp.clear();
        for (Student s :mylist)
        {
        disp.add(s.name);
        }
        adapter.notifyDataSetChanged();
        }

@Override
public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        }

@Override
public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add)
        {
        Intent it = new Intent(MainActivity.this, AddActivity.class);
        startActivity(it);
        }
        return super.onOptionsItemSelected(item);
        }
 */