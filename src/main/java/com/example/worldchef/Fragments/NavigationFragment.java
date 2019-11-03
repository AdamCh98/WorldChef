package com.example.worldchef.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.worldchef.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);

        BottomNavigationView bottomNav = view.findViewById(R.id.navigation_bar);
        return view;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.bottom_navigation_learn:
                            selectedFragment = new LearnFragment();
                            break;
                        case R.id.bottom_navigation_social:
                            selectedFragment = new LearnFragment();
                            break;
                        case R.id.bottom_navigation_recipe:
                            selectedFragment = new LearnFragment();
                            break;
                    }

                    //Change Fragment A with whatever is clicked
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainscreen_fragmentA,
                            selectedFragment).commit();

                    return true;


                }

            };



}



