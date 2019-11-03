package com.example.worldchef.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.worldchef.Fragments.LearnFragment;
import com.example.worldchef.Fragments.NavigationFragment;
import com.example.worldchef.R;

public class MainScreenActivity extends AppCompatActivity {

    //This is the main screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        //Have learning fragment from the start
        Fragment fragmentLearn= new LearnFragment();
        swapFragmentA(fragmentLearn);

        //Have the nav bar
        Fragment fragmentNav = new NavigationFragment();
        swapFragmentB(fragmentNav);

    }

    //Swap fragment A out
    private void swapFragmentA (Fragment newFragment) {
        getSupportFragmentManager().beginTransaction().replace
                (R.id.mainscreen_fragmentA, newFragment).commit();
    }
    //Swap fragment B out
    private void swapFragmentB (Fragment newFragment) {
        getSupportFragmentManager().beginTransaction().replace
                (R.id.mainscreen_fragmentB, newFragment).commit();
    }

}
