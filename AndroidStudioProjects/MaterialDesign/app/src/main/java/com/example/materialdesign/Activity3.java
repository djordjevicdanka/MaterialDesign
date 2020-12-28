package com.example.materialdesign;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toolbar;

public class Activity3 extends AppCompatActivity {

    ViewPager viewPager;
    SlideShowAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        viewPager = (ViewPager) findViewById(R.id.viewPager_id);

        adapter = new SlideShowAdapter(this);

        viewPager.setAdapter(adapter);

    }
}