package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.quizzapp.Activities.SetQuestionActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout history,science,geography,math;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        history=findViewById(R.id.history_btn);
        science=findViewById(R.id.science_btn);
        math=findViewById(R.id.math_btn);
        geography=findViewById(R.id.geography_btn);

        history.setOnClickListener(v->startActivity(new Intent(MainActivity.this, SetQuestionActivity.class)));
        geography.setOnClickListener(v->startActivity(new Intent(MainActivity.this, SetQuestionActivity.class)));
        math.setOnClickListener(v->startActivity(new Intent(MainActivity.this, SetQuestionActivity.class)));
        science.setOnClickListener(v->startActivity(new Intent(MainActivity.this, SetQuestionActivity.class)));

    }
}