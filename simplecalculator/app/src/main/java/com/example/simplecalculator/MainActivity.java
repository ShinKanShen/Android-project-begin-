package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    Button btnsum,btnsub,btnmul,btndiv,btnpow,btnmod;
    TextView t1;
    EditText ed1,ed2;
    int num1,num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsum=findViewById(R.id.sum);
        btnsub=findViewById(R.id.sub);
        btndiv=findViewById(R.id.div);
        btnmul=findViewById(R.id.mul);
        btnpow=findViewById(R.id.pow);
        btnmod=findViewById(R.id.mod);
        ed1=findViewById(R.id.num1);
        ed2=findViewById(R.id.num2);
        t1=findViewById(R.id.ketqua);

        btnmod.setOnClickListener(this);
        btnpow.setOnClickListener(this);
       btnmul.setOnClickListener(this);
       btndiv.setOnClickListener(this);
       btnsum.setOnClickListener(this);
       btnsub.setOnClickListener(this);





    }
    public  int getnumber(EditText editText) {
        if (editText.getText().toString().equals("") || editText.getText().toString() == null) {
           // hien thi thong bao tren man hinh
            Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return Integer.parseInt(editText.getText().toString());
        }
    }
    @Override
    public void onClick(View view) {
        num1=getnumber(ed1);
        num2=getnumber(ed2);
        DecimalFormat dcm = new DecimalFormat("#.####");
        int id=view.getId();
        if(id==R.id.sum){
            t1.setText("Answer is "+(num2+num1));
        } else if (id==R.id.sub) {
            t1.setText("Answer is "+(num1-num2));

        } else if (id==R.id.mul) {
            t1.setText("Answer is "+ num1*num2);
        } else if (id==R.id.div) {
            t1.setText("Answer is "+dcm.format(((float) num1)/ num2));
        }else if (id==R.id.pow){
            t1.setText("Answer is "+ Math.pow(num1,num2));

        }else if(id==R.id.mod){
            t1.setText("Answer is "+dcm.format(num1%num2));
        }
    }
}