package com.example.worldchef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.worldchef.Activities.MainScreenActivity;

public class MainActivity extends AppCompatActivity {


    //This Is Adam

    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton = findViewById(R.id.activity_main_login_button);


        //Clicking login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Switch pages
                Intent intent = new Intent (MainActivity.this, MainScreenActivity.class);

                //Add something here when we get User ID

                startActivity(intent);

            //this is Lucas making a comment
            }
        });


    }
}
