package com.example.worldchef.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.worldchef.Models.Categories;
import com.example.worldchef.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> implements Filterable {

    //List of countries
    public List<Categories.Category> categories;

    private List<Categories.Category> categoryListFull;



    public void setData(List<Categories.Category> categoriesToAdapt) {
        this.categories = categoriesToAdapt;
        categoryListFull = new ArrayList<>(categoriesToAdapt);
    }

    //Creating viewholder
    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView mCategoryName;
        public ImageView mCategoryImage;

        public CategoryViewHolder(View v) {
            super(v);

            mCategoryImage = v.findViewById(R.id.category_cardimage);
            mCategoryName = v.findViewById(R.id.category_name);


        }
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category, parent, false);

        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryViewHolder holder, final int position) {

        final Categories.Category currentCategory = categories.get(position);

        holder.mCategoryName.setText(currentCategory.getStrCategory());
        String imageUrl = currentCategory.getStrCategoryThumb();
        Glide.with(holder.mCategoryName.getContext()).load(imageUrl).into(holder.mCategoryImage);
    }

    @Override
    public int getItemCount() { return categories.size();}

    @Override
    public Filter getFilter() { return categoryFilter;}

    //creating filter
    private Filter categoryFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            //return filtered results
            List<Categories.Category> filteredCategoryList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                //show all the results
                filteredCategoryList.addAll(categoryListFull);
            } else {

                //Show filtered result

                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Categories.Category categoryFilters : categoryListFull) {

                    //Removing case sensitivity and seeing if there is a match

                    if (categoryFilters.getStrCategory().toLowerCase().contains(filterPattern)) {
                        filteredCategoryList.add(categoryFilters);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredCategoryList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            categories.clear();
            categories.addAll((ArrayList) results.values);

            //Refresh Adapter
            notifyDataSetChanged();;


        }
    };
}
