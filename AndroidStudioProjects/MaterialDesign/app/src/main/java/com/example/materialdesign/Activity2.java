package com.example.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

public class Activity2 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    AlertDialog alertDialog;
    AlertDialog.Builder builder;
    Snackbar snackbar;
    BottomNavigationView bottomNavigationView;
    TextView txt;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                openActivity3();
            }
        });

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation_id);
        txt = (TextView) findViewById(R.id.text_id);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id= item.getItemId();
        switch (id){

            case R.id.recents_id:

                txt.setText(getResources().getText(R.string.recents));

                return true;

            case R.id.favorites_id:

                txt.setText(getResources().getText(R.string.favorites));

                return true;

            case R.id.nearby_id:

                txt.setText(getResources().getText(R.string.near_by));

                return  true;

        }

        return false;
    }


    public void openActivity3(){

        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
}