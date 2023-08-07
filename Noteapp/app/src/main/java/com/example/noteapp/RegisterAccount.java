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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class RegisterAccount extends AppCompatActivity {


    EditText editemail,editpass,editconfirmpass;
    Button btn_regis;
    ProgressBar progessbar;
    TextView login_textV; //login if have account
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_account);
        editemail=findViewById(R.id.email_regis);
        editpass=findViewById(R.id.pass_regis);
        editconfirmpass=findViewById(R.id.confirm_pass_regis);
        btn_regis=findViewById(R.id.btn_regis);
        progessbar=findViewById(R.id.progress);
        login_textV =findViewById(R.id.login_ready);
        btn_regis.setOnClickListener(v->Regisaccount());
        login_textV.setOnClickListener((v)->startActivity(new Intent(RegisterAccount.this,LoginAccount.class)));

    }

    void Regisaccount(){
        String email=editemail.getText().toString();
        String pass=editpass.getText().toString();
        String cofimpass = editconfirmpass.getText().toString();
        boolean check_input=check(email,pass,cofimpass);
        if(!check_input){
            return;
        }
        createInfirebase(email,pass);



    }


    void createInfirebase(String email,String pass){
        changprogress(true);
        FirebaseAuth firbase=FirebaseAuth.getInstance();
        firbase.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(RegisterAccount.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    changprogress(false);
                    toastmess.showtoast(RegisterAccount.this,"Create Account Sucessully");

                    firbase.getCurrentUser().sendEmailVerification();

                    firbase.signOut();
                    finish();

                }
                else {
                    toastmess.showtoast(RegisterAccount.this,task.getException().getLocalizedMessage());


                }


            }
        });

    }
    void changprogress(boolean progess){
        if(progess){
            progessbar.setVisibility(View.VISIBLE);
            btn_regis.setVisibility(View.GONE);
        }else{
            progessbar.setVisibility(View.GONE);
            btn_regis.setVisibility(View.VISIBLE);
        }
    }
    boolean check(String email, String pass, String confimpass){
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editemail.setError("Email is invalid");
            return false;

        }
        if(pass.length()<6){
            editpass.setError("Passeord length is bigger than 6");
            return false;
        }
        if(!pass.equals(confimpass)){
            editconfirmpass.setError("Confrirm password not match!");
            return false;

        }
        return true;

    }

}