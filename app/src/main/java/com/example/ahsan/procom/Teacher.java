package com.example.ahsan.procom;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ahsan.procom.Fragments.AddCourse;
import com.example.ahsan.procom.Fragments.AddTeacher;
import com.example.ahsan.procom.Fragments.MyDialog;
import com.example.ahsan.procom.Helper.SQLiteHelper;

import java.util.ArrayList;

public class Teacher extends AppCompatActivity implements View.OnClickListener {

    String item;
    public ListView lv;
    Button btn;
    public ArrayAdapter adapter;
    SQLiteHelper db;
    public ArrayList<String> teachers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        Intent i = getIntent();
        item = i.getStringExtra("Course Name");
        lv = (ListView) findViewById(R.id.listview);
        btn = (Button) findViewById(R.id.addCourse);
        btn.setOnClickListener(this);


        db = new SQLiteHelper(this);
        teachers = db.getTeachers(item);

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,teachers);
        lv.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if(teachers.size() < 3) {
            AddTeacher addTeacher = new AddTeacher(item);
            addTeacher.show(getFragmentManager(), "ADD TEACHER");
        }else{
            Toast.makeText(this, "You cannot add more then three teachers", Toast.LENGTH_SHORT).show();
        }
    }

}
