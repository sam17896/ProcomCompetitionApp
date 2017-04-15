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
import com.example.ahsan.procom.R;


public class MyDialog extends DialogFragment implements View.OnClickListener {

    LayoutInflater inflater;
    EditText password;
    Button btn;
    String item;

    public MyDialog(String item) {
        this.item = item;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.mydialog,null);

        password = (EditText) view.findViewById(R.id.password);
        btn = (Button) view.findViewById(R.id.btn);

        btn.setOnClickListener(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);

        return builder.create();



    }

    @Override
    public void onClick(View v) {
        String text = password.getText().toString().trim();

        switch (item){
            case "BS-CS":

                if(text.equals("Computer Science")){
                    Toast.makeText(getActivity(), item, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getActivity(), Course.class);
                    i.putExtra("Degree Name", item);
                    startActivity(i);
                    dismiss();
                }else{
                    Toast.makeText(getActivity(), "Incorrect Passoword", Toast.LENGTH_SHORT).show();
                }

                break;
            case "BS-EE":

                if(text.equals("Electrical Engineering")){
                    Toast.makeText(getActivity(), item, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getActivity(), Course.class);
                    i.putExtra("Degree Name", item);
                    startActivity(i);
                    dismiss();
                }else{
                    Toast.makeText(getActivity(), "Incorrect Passoword", Toast.LENGTH_SHORT).show();
                }

                break;
            case "BBA":

                if(text.equals("Business")){
                    Toast.makeText(getActivity(), item, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getActivity(), Course.class);
                    i.putExtra("Degree Name", item);
                    startActivity(i);
                    dismiss();
                }else{
                    Toast.makeText(getActivity(), "Incorrect Passoword", Toast.LENGTH_SHORT).show();
                }

                break;

        }




    }
}
