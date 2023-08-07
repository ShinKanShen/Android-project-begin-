package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        // change it to the first activity in mainfest
        // when running app
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
                if(user==null){ //neu chua dawng nhap den trang login
                    startActivity(new Intent(SplashActivity.this, LoginAccount.class));

                }else {
                    // neu dang nhap roi thi den trang chu
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));

                }finish();

            }
        },1000);

    }
}