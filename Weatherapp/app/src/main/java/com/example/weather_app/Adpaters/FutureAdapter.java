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
import com.example.weather_app.Domains.weatherCard;
import com.example.weather_app.R;

import java.util.ArrayList;

public class FutureAdapter extends RecyclerView.Adapter<FutureAdapter.viewholder> {


    ArrayList<weatherCard> items;
    Context context;

    public FutureAdapter(ArrayList<weatherCard> items) {
        this.items = items;
    }

    // create view holder to load layout display items in recycler view
    @NonNull
    @Override
    public FutureAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_weather,parent,false);
        context = parent.getContext();
        return new viewholder(inflate);
    }

    //    convert data to view holder to
    @Override
    public void onBindViewHolder(@NonNull FutureAdapter.viewholder holder, int position) {

        holder.dayTxt.setText(items.get(position).getDay());
        holder.statusTxt.setText(items.get(position).getStatus());
        holder.lowTempTxt.setText(items.get(position).getLowTemp()+"°");
        holder.highTempTxt.setText(items.get(position).getHighTemp()+"°");
        int drawableresourcesid = holder.itemView.getResources()
                .getIdentifier(items.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context).load(drawableresourcesid)
                .into(holder.pic);

    }

    //    return number ò items in recycler view
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView dayTxt,statusTxt,lowTempTxt,highTempTxt;
        ImageView pic;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            dayTxt=itemView.findViewById(R.id.dayTxt);
            statusTxt=itemView.findViewById(R.id.statusTxt);
            lowTempTxt=itemView.findViewById(R.id.lowTempTxt);
            highTempTxt=itemView.findViewById(R.id.highTempTxt);
            pic=itemView.findViewById(R.id.pic);



        }
    }
}
