package com.example.noteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginAccount extends AppCompatActivity {


    EditText logemail,logpass;
    TextView regisTextview;
    Button login;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_account);
        logemail=findViewById(R.id.email_login);
        logpass=findViewById(R.id.pass_login);
        login=findViewById(R.id.btn_login);
        regisTextview=findViewById(R.id.regis_ready);
        progressBar = findViewById(R.id.progress);

        login.setOnClickListener(v ->Loginaccount());
        regisTextview.setOnClickListener((v)->startActivity(new Intent(LoginAccount.this, RegisterAccount.class)));
    }

    private void Loginaccount() {

        String email=logemail.getText().toString();
        String pass=logpass.getText().toString();

        boolean check_input=check(email,pass);
        if(!check_input){
            return;
        }
        LoginAccountFirebase(email,pass);

    }
    void LoginAccountFirebase(String email, String password){
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        changprogress(true);
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                changprogress(false);
                if(task.isSuccessful()){
                    if(firebaseAuth.getCurrentUser().isEmailVerified()){
                        startActivity(new Intent(LoginAccount.this, MainActivity.class));
                    }else {
                        toastmess.showtoast(LoginAccount.this,"Email not verified.");
                    }
                }else {
                    toastmess.showtoast(LoginAccount.this,task.getException().getLocalizedMessage());

                }
            }
        });
    }

    void changprogress(boolean progess){
        if(progess){
            progressBar.setVisibility(View.VISIBLE);
            login.setVisibility(View.GONE);
        }else{
            progressBar.setVisibility(View.GONE);
            login.setVisibility(View.VISIBLE);
        }
    }
    boolean check(String email, String pass){
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            logemail.setError("Email is invalid");
            return false;

        }
        if(pass.length()<6){
            logpass.setError("Passeord length is bigger than 6");
            return false;
        }

        return true;

    }
}









