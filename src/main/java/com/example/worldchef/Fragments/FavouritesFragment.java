package com.example.worldchef.Fragments;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.worldchef.Adapters.FavouriteAdapter;
import com.example.worldchef.AppDatabase;
import com.example.worldchef.Models.Favourite;
import com.example.worldchef.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.worldchef.Activities.MainScreenActivity.username;

public class FavouritesFragment extends Fragment {

    private RecyclerView favouriteRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourites, container, false);

        favouriteRecyclerView = view.findViewById(R.id.fav_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        favouriteRecyclerView.setLayoutManager(layoutManager);

        final FavouriteAdapter favouriteAdapter = new FavouriteAdapter();

        //Grab list of favourited meals based on username
        List<Favourite> favourites = AppDatabase.getInstance(view.getContext()).favouriteDao().getFavouriteListByUsername(username);
        //Convert into arraylist
        ArrayList<Favourite> favouriteArrayList = new ArrayList<Favourite>(favourites);

        favouriteAdapter.setData(favouriteArrayList);

        favouriteRecyclerView.setAdapter(favouriteAdapter);


        return view;

    }

    //Refreshing the fragment when back button is pressed
    @Override
    public void  onResume() {
        super.onResume();
        final FavouriteAdapter favouriteAdapter = new FavouriteAdapter();

        Context context = getContext();
        //Grab list of favourited meals based on username
        List<Favourite> favourites = AppDatabase.getInstance(context).favouriteDao().getFavouriteListByUsername(username);
        //Convert into arraylist
        ArrayList<Favourite> favouriteArrayList = new ArrayList<Favourite>(favourites);

        favouriteAdapter.setData(favouriteArrayList);

        favouriteRecyclerView.setAdapter(favouriteAdapter);

    }
}
