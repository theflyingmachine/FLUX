package com.ericabraham.flux.flux;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by EK055891 on 25-Aug-18.
 */

public class Splash  extends AppCompatActivity {



    private static final String TAG = "Splash";
    private static int SPLASH_TIME_OUT = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hide titlebar
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar

        //hide notificationbar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
              WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_splash);

        //wait for 1 sec
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //call async
                new checkServer(getApplicationContext()).execute();
            }
        }, SPLASH_TIME_OUT);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                finish();
                //Toast.makeText(Splash.this, "Splash Killed", Toast.LENGTH_SHORT).show();
            }
        }, 10000);
       }

}
