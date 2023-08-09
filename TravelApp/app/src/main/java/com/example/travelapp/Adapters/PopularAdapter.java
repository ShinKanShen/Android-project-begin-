package com.example.travelapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.TintableCheckedTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.travelapp.Activities.DetailAvtivity;
import com.example.travelapp.Activities.MainActivity;
import com.example.travelapp.Domains.PopularDomain;
import com.example.travelapp.R;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.viewholder> {

    Context context;

    ArrayList<PopularDomain> items;
    public PopularAdapter(ArrayList<PopularDomain> items) {
        this.items = items;

    }


    @NonNull
    @Override
    public PopularAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        context = parent.getContext();
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.viewholder holder, int position) {

        holder.titleTxt.setText(items.get(position).getTitle());
        holder.locationTxt.setText(items.get(position).getLocation());
        holder.scoreTxt.setText(""+items.get(position).getScore());
        int drawableResourceId=holder.itemView.getResources().getIdentifier(items.get(position).getPic(),
                "drawable",holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResourceId)
                .transform(new CenterCrop(),new GranularRoundedCorners(40,40,40,40))
                .into(holder.pic_path);

        holder.itemView.setOnClickListener(v-> {

                Intent intent=new Intent(holder.itemView.getContext(), DetailAvtivity.class);
                intent.putExtra("object",items.get(position));
                holder.itemView.getContext().startActivity(intent);
            } );

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView titleTxt,locationTxt,scoreTxt;
        ImageView pic_path;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            titleTxt=itemView.findViewById(R.id.polTitleTxt);
            locationTxt=itemView.findViewById(R.id.polLocalTxt);
            scoreTxt=itemView.findViewById(R.id.polScoreTxt);
            pic_path=itemView.findViewById(R.id.polImg);

        }
    }
}
