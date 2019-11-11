package com.example.worldchef.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.worldchef.Adapters.CategoryAdapter;
import com.example.worldchef.Models.Categories;
import com.example.worldchef.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.worldchef.R;

public class LearnFragment extends Fragment {

    private RecyclerView categoryRecyclerView;
    private SearchView categorySearchView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_learn_fragment, container, false);


        categoryRecyclerView = view.findViewById(R.id.learn_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        categoryRecyclerView.setLayoutManager(layoutManager);


        final CategoryAdapter categoryAdapter = new CategoryAdapter();

        //Setting search bar
        categorySearchView = view.findViewById(R.id.search_bar);
        categorySearchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        categorySearchView.setQueryHint("Search food category");

        //Prevent the keyboard from pushing up the entire layout
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

        categorySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                categoryAdapter.getFilter().filter(newText);
                return false;
            }
        });

        //Extract API

        String categoryUrl = "https://www.themealdb.com/api/json/v1/1/categories.php";

        Context context = getContext();
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                Gson gson = new Gson();


                Categories thisCategories = gson.fromJson(response, Categories.class);

                List<Categories.Category> categoryList = thisCategories.getCategories();

                //Add in data

                categoryAdapter.setData(categoryList);

                categoryRecyclerView.setAdapter(categoryAdapter);


            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse (VolleyError error) {
                System.out.println(error.toString());
            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.GET, categoryUrl, responseListener, errorListener);
        requestQueue.add(stringRequest);

        return view;
    }

}
