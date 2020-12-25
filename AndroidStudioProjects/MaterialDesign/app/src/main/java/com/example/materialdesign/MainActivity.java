package com.example.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    AppCompatButton raisedButton;
    AppCompatButton flatButton;
    SwitchCompat switchCompat;
    AppCompatEditText user;
    AppCompatEditText pass;
    TextInputLayout userLayout;
    TextInputLayout passLayout;
    FloatingActionButton fab;
    AppCompatCheckBox appCompatCheckBox;
    RadioGroup radioGroup;
    ProgressBar progressBar;
    Handler handler;
    Runnable runnable;
    Timer timer;
    AlertDialog dialog;
    AlertDialog.Builder builder;
    String[] items = {"Easy" , "Medium" , "Hard" , "Very hard"};
    String result = "";
    private Button button;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Progress dialog");
        progressDialog.setMessage("Please wait..");
        progressDialog.show();
        //progressDialog.cancel();

        builder = new AlertDialog.Builder(MainActivity.this,R.style.ConfirmationDialog);
        builder.setTitle("Select the difficulty level");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int i) {

                result = items[i];
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        dialog= builder.create();
        dialog.show();


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                openActivity2();
            }
        });


        progressBar = (ProgressBar) findViewById(R.id.progressBar_id);
        progressBar.setVisibility(View.VISIBLE);

        handler = new Handler();
        runnable = new Runnable() {

            @Override
            public void run() {

                timer.cancel();
                progressBar.setVisibility(View.GONE);
            }
        };



        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(runnable);
            }
        },8000,1000);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        raisedButton = (AppCompatButton) findViewById(R.id.raised_btn);
        flatButton = (AppCompatButton) findViewById(R.id.flat_btn);
        fab = (FloatingActionButton) findViewById(R.id.fab_btn);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_id);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int i) {

                switch (i){

                    case R.id.RadioButton1_id:

                        Toast.makeText(getApplicationContext(), "RadioButton 1", Toast.LENGTH_LONG).show();

                        break;

                    case R.id.RadioButton2_id:

                        Toast.makeText(getApplicationContext(), "RadioButton 2", Toast.LENGTH_LONG).show();

                        break;
                }

            }
        });

        raisedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Raised Button", Toast.LENGTH_SHORT).show();
            }
        });

        flatButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Flat Button", Toast.LENGTH_SHORT).show();

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Floating Action Button", Toast.LENGTH_SHORT).show();
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

        appCompatCheckBox = (AppCompatCheckBox) findViewById(R.id.checkbox_id);
        appCompatCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {

                if (b){

                    Toast.makeText(getApplicationContext(), "CheckBox is Enable", Toast.LENGTH_LONG).show();


                }else {

                    Toast.makeText(getApplicationContext(), "CheckBox is Disable", Toast.LENGTH_LONG).show();

                }
            }
        });

        user = (AppCompatEditText) findViewById(R.id.username_TextField);
        userLayout = (TextInputLayout) findViewById(R.id.username_TextInputLayout);
        pass = (AppCompatEditText) findViewById(R.id.password_TextField);
        passLayout = (TextInputLayout) findViewById(R.id.password_TextInputLayout);

        user.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (user.getText().toString().isEmpty()){

                    userLayout.setErrorEnabled(true);
                    userLayout.setError("please enter your username!");

                }else {

                    userLayout.setErrorEnabled(false);

                }
            }
        });





        user.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if (user.getText().toString().isEmpty()){

                    userLayout.setErrorEnabled(true);
                    userLayout.setError("please enter your username!");

                }else {

                    userLayout.setErrorEnabled(false);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });


        passLayout.setCounterEnabled(true);
        passLayout.setCounterMaxLength(8);


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

    public void openActivity2(){

        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

}