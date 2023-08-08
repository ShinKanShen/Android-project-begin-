package com.example.travelapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;

import com.example.travelapp.R;

public class Intro_activities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_activities);

        ConstraintLayout introLayout = findViewById(R.id.introBtn);

        introLayout.setOnClickListener(v-> startActivity(new Intent(Intro_activities.this, MainActivity.class)) );



    }
}