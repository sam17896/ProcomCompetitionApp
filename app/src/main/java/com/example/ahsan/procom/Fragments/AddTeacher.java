package com.example.ahsan.procom.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ahsan.procom.Course;
import com.example.ahsan.procom.Helper.SQLiteHelper;
import com.example.ahsan.procom.R;
import com.example.ahsan.procom.Teacher;


public class AddTeacher extends DialogFragment implements View.OnClickListener {

    LayoutInflater inflater;
    EditText course;
    Button btn;
    String item;
    SQLiteHelper db;

    public AddTeacher(String item) {
        this.item = item;
        db = new SQLiteHelper(getActivity());
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.addteacher,null);

        course = (EditText) view.findViewById(R.id.password);
        btn = (Button) view.findViewById(R.id.btn);
        btn.setText("Add");

        db = new SQLiteHelper(getActivity());


        btn.setOnClickListener(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);

        return builder.create();



    }

    @Override
    public void onClick(View v) {
        String text = course.getText().toString().trim();
        db.insertTeacher(item,text);
        Teacher callingActivity = (Teacher) getActivity();
        callingActivity.teachers.add(text);
        callingActivity.adapter.notifyDataSetChanged();
        dismiss();
    }
}
