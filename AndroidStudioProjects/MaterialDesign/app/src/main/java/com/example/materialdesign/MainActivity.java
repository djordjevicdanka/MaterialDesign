package com.example.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    AppCompatButton raisedButton;
    SwitchCompat switchCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        raisedButton = (AppCompatButton) findViewById(R.id.raised_btn);
        raisedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Raised Button", Toast.LENGTH_SHORT).show();
            }
        });

        switchCompat= (SwitchCompat) findViewById(R.id.switch_id);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (b){

                    Toast.makeText(getApplicationContext(), "Switch is ON", Toast.LENGTH_LONG).show();

                }else {

                    Toast.makeText(getApplicationContext(), "Switch is OFF", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id= item.getItemId();

        if (id==R.id.item1_id){

            Toast.makeText(getApplicationContext(), "item1 is selected", Toast.LENGTH_SHORT).show();

        }else if (id==R.id.item2_id){

            Toast.makeText(getApplicationContext(), "item2 is selected", Toast.LENGTH_SHORT).show();

        }else if (id==R.id.item3_id){

            Toast.makeText(getApplicationContext(), "item3 is selected", Toast.LENGTH_SHORT).show();

        }else if (id==R.id.search_id){

            Toast.makeText(getApplicationContext(), "search", Toast.LENGTH_SHORT).show();

        }else if (id==R.id.cart_id){

            Toast.makeText(getApplicationContext(), "cart", Toast.LENGTH_SHORT).show();

        }else if (id==android.R.id.home){

            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}