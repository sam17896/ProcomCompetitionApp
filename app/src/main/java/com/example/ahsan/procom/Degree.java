package com.example.ahsan.procom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ahsan.procom.Fragments.MyDialog;

import java.util.ArrayList;

public class Degree extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView lv;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degree);
        lv = (ListView) findViewById(R.id.listview);
        arrayList = new ArrayList<>();
        arrayList.add("BS-CS");
        arrayList.add("BS-EE");
        arrayList.add("BBA");

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = arrayList.get(position);


        MyDialog dialog = new MyDialog(item);
        dialog.show(getFragmentManager(),"DIALOG");

    }
}
