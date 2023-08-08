package com.example.travelapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.travelapp.Domains.CategoryDomain;
import com.example.travelapp.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewholder> {

    Context context;
    ArrayList<CategoryDomain> items;

    public CategoryAdapter(ArrayList<CategoryDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_catagory,parent,false);
        context = parent.getContext();
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.viewholder holder, int position) {
        holder.catTitleTxt.setText(items.get(position).getTitle());
        int drawableResourceId=holder.itemView.getResources().getIdentifier(
                items.get(position).getPic_path(),"drawable",holder.itemView.getContext().getPackageName()
        );
        Glide.with(context).load(drawableResourceId).into(holder.catImg);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView catTitleTxt;
        ImageView catImg;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            catTitleTxt=itemView.findViewById(R.id.catItemTxt);
            catImg=itemView.findViewById(R.id.catItemImg);

        }
    }
}
