package com.example.worldchef.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.worldchef.MainActivity;
import com.example.worldchef.R;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //grab data
        Intent getIntent = getIntent();

        final String username = getIntent.getStringExtra("username");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this,MainScreenActivity.class);
                intent.putExtra("username", username);
                SplashScreenActivity.this.startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);




}
};
