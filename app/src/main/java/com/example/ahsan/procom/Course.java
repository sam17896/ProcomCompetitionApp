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

import com.example.ahsan.procom.Fragments.AddCourse;
import com.example.ahsan.procom.Fragments.MyDialog;
import com.example.ahsan.procom.Helper.SQLiteHelper;

import java.util.ArrayList;

public class Course extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    String item;
    public ListView lv;
    Button btn;
    public ArrayAdapter adapter;
    SQLiteHelper db;
    public ArrayList<String> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        Intent i = getIntent();
        item = i.getStringExtra("Degree Name");
        lv = (ListView) findViewById(R.id.listview);
        btn = (Button) findViewById(R.id.addCourse);
        btn.setOnClickListener(this);


        db = new SQLiteHelper(this);
        courses = db.getCourses(item);

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,courses);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AddCourse addCourse = new AddCourse(item);
        addCourse.show(getFragmentManager(),"ADD COURSE");

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = courses.get(position);

        Intent i = new Intent(this, Teacher.class);
        i.putExtra("Course Name", item);
        startActivity(i);
    }
}
