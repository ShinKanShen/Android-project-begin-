package com.example.weather_app.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.weather_app.Adpaters.HourlyAdapter;
import com.example.weather_app.Domains.Hourly;
import com.example.weather_app.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView.Adapter adapterHourly;
    private  RecyclerView recyclerView;
    private TextView next7day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next7day=findViewById(R.id.next_7day);
        next7day.setOnClickListener(v->startActivity(new Intent(MainActivity.this, FutureWeatherActivity.class)));
        inputRecyclerView();


    }

    private void inputRecyclerView() {

        ArrayList<Hourly> items=new ArrayList<>();
        items.add(new Hourly("9 pm",28,"cloudy"));
        items.add(new Hourly("11 pm",29,"sunny"));
        items.add(new Hourly("12 pm",30,"wind"));
        items.add(new Hourly("1 am",29,"rainy"));
        items.add(new Hourly("2 am",27,"storm"));

        recyclerView=findViewById(R.id.recyclerViewCardMain);
        recyclerView.setLayoutManager( new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        adapterHourly = new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHourly);



    }
}