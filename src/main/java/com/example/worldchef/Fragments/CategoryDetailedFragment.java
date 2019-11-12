package com.example.worldchef.Fragments;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldchef.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CategoryDetailedFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_category_detailed_fragment, container, false);

//        recyclerView = view.findViewById(R.id.search_rv);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
//        recyclerView.setLayoutManager(layoutManager);


        return view;
    }
}
