package com.example.travelapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.travelapp.Domains.PopularDomain;
import com.example.travelapp.R;

public class DetailAvtivity extends AppCompatActivity {

    private TextView mytitle,locationTxt,scoreTxt,bedTxt,wifiTxt,guideTxt,descriptionTxt,priceTxt;
    private PopularDomain item;
    private ImageView img_path,backbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_avtivity);


        inpView();


    }

    private void inpView() {
        locationTxt=findViewById(R.id.locationTxt);
        scoreTxt=findViewById(R.id.scoreTxt);
        bedTxt=findViewById(R.id.bedTxt);
        wifiTxt=findViewById(R.id.wifiTxt);
        guideTxt=findViewById(R.id.guideTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        priceTxt=findViewById(R.id.priceTxt);
        img_path=findViewById(R.id.pic_path);
        backbtn=findViewById(R.id.backBtn);

        item=(PopularDomain) getIntent().getSerializableExtra("object");
        mytitle=(TextView) findViewById(R.id.title);
        mytitle.setText(item.getTitle());
        locationTxt.setText(item.getLocation());
        scoreTxt.setText(""+item.getScore());
        bedTxt.setText(item.getBed()+"Bed");

        descriptionTxt.setText(item.getDescription());
        priceTxt.setText("$"+item.getPrice());
        if(item.isWifi()){
            wifiTxt.setText("Wifi");
        }else {
            wifiTxt.setText("No Wifi");
        }
        if(item.isGuide()){
            guideTxt.setText("Guide");
        }else {
            guideTxt.setText("No Guide");
        }

        int drawableResourceId=getResources().getIdentifier(item.getPic(), "drawable",getPackageName());
        Glide.with(this).load(drawableResourceId).into(img_path);

        backbtn.setOnClickListener(v->finish());



    }


}