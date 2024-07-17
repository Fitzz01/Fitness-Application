package com.example.personalizedfitnessapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.window.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splashScreen.this, LoginActivity.class));
                finish();
            }
        }, 2000);

    }
}
