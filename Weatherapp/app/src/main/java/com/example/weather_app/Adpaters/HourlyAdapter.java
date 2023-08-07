package com.example.weather_app.Adpaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weather_app.Domains.Hourly;
import com.example.weather_app.R;

import java.util.ArrayList;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.viewholder> {

    ArrayList<Hourly> items;
    Context context;

    public HourlyAdapter(ArrayList<Hourly> items) {
        this.items = items;
    }

    // create view holder to load layout display items in recycler view
    @NonNull
    @Override
    public HourlyAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.hourly_viewholder,parent,false);
        context = parent.getContext();
        return new viewholder(inflate);
    }

//    convert data to view holder to
    @Override
    public void onBindViewHolder(@NonNull HourlyAdapter.viewholder holder, int position) {

        holder.hourtxt.setText(items.get(position).getHour());
        holder.temptxt.setText(items.get(position).getTemp()+"°");
        int drawableresourcesid = holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicPath(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context).load(drawableresourcesid)
                .into(holder.pic);

    }

//    return number ò items in recycler view
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView hourtxt,temptxt;
        ImageView pic;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            hourtxt=itemView.findViewById(R.id.hourlyTxt);
            temptxt=itemView.findViewById(R.id.tempTxt);
            pic=itemView.findViewById(R.id.img_card);



        }
    }
}
