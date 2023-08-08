package com.example.weather_app.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weather_app.Adpaters.FutureAdapter;
import com.example.weather_app.Domains.weatherCard;
import com.example.weather_app.R;

import java.util.ArrayList;

public class FutureWeatherActivity extends AppCompatActivity {

    private RecyclerView.Adapter futureAdapter;
    public RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future_weather);
        ConstraintLayout backBtn=findViewById(R.id.backBtn);

        backBtn.setOnClickListener(v->startActivity(new Intent(FutureWeatherActivity.this,MainActivity.class)));
        inputRecyclerViewCard();


    }

    private void inputRecyclerViewCard() {
        ArrayList<weatherCard> items= new ArrayList<>();
        items.add(new weatherCard("Sat","storm","Storm",10,25));
        items.add(new weatherCard("Sun","cloudy","Cloudy",22,29));
        items.add(new weatherCard("Mon","windy","Windy",25,32));
        items.add(new weatherCard("Tue","cloudy_sunny","Cloudy sunny",26,30));
        items.add(new weatherCard("Wen","sunny","Sunny",25,33));
        items.add(new weatherCard("Thu","rainy","Rainy",20,25));
        items.add(new weatherCard("Fri","cloudy","Rainy",20,25));

        recyclerView=findViewById(R.id.card_weather_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        futureAdapter=new FutureAdapter(items);
        recyclerView.setAdapter(futureAdapter);


    }
}