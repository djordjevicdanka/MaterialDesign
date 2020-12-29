package com.example.materialdesign;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class Activity3 extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    SlideShowAdapter adapter;
    CircleIndicator indicator;
    Handler handler;
    Runnable runnable;
    Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);


        viewPager = (ViewPager) findViewById(R.id.viewPager_id);



        adapter = new SlideShowAdapter(this);

        viewPager.setAdapter(adapter);

        indicator = (CircleIndicator) findViewById(R.id.circleIndicator_id);

        indicator.setViewPager(viewPager);

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                int i = viewPager.getCurrentItem();

                if (i==adapter.images.length-1){

                    i=0;
                    viewPager.setCurrentItem(i, true);

                }else {

                    i++;
                    viewPager.setCurrentItem(i,true);

                }



            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(runnable);

            }
        },4000,4000);

    }
}