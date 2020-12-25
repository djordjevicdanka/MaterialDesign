package com.example.materialdesign;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Activity2 extends AppCompatActivity {

    AlertDialog alertDialog;
    AlertDialog.Builder builder;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        View view= findViewById(R.id.activity2);
        snackbar = Snackbar.make(view, "Hello Snackbar!", Snackbar.LENGTH_INDEFINITE);
        snackbar.setDuration(10000);
        snackbar.setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                snackbar.dismiss();
            }
        });

        View v = snackbar.getView();
        v.setBackgroundColor(getResources().getColor(R.color.colorSnackbarBackground));


        snackbar.show();
        //snackbar.dismiss();



        builder = new AlertDialog.Builder(Activity2.this);
        builder.setMessage("Discard draft?");

        builder.setPositiveButton("DISCARD", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                System.out.println("discard");
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                System.out.println("cancel");
            }
        });

        alertDialog= builder.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorAlertDialog));
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.colorAlertDialog));
    }
}