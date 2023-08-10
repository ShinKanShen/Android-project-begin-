package com.example.travelapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.travelapp.Adapters.CategoryAdapter;
import com.example.travelapp.Adapters.PopularAdapter;
import com.example.travelapp.Domains.CategoryDomain;
import com.example.travelapp.Domains.PopularDomain;
import com.example.travelapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterPopular,adapterCat;
    private RecyclerView recyclerPopular,recyclerCat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inpRecyclerView();
    }

    private void inpRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Mar caible, avendia lago","Miami","The room was great size.. amazing mattress, \npillows and so soft bed sheets!!!!"
               ,2,true,4.5,"pic1",true,1030));
        items.add(new PopularDomain("Holiday Inn Resort Ho Tram","Vung Tau","The room was great size.. amazing mattress, \npillows and so soft bed sheets!!!!",3,false,4,"pic2",true,930));
        items.add(new PopularDomain("Vias Hotel Vung Tau","Vung Tau","The room was great size.. amazing mattress, \npillows and so soft bed sheets!!!!",4,true,4.5,"pic3",true,10000));

        recyclerPopular=findViewById(R.id.popularRecyclerView);
        recyclerPopular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterPopular=new PopularAdapter(items);

        recyclerPopular.setAdapter(adapterPopular);

        // category
        ArrayList<CategoryDomain> catItems=new ArrayList<>();
        catItems.add(new CategoryDomain("Beaches","cat1"));
        catItems.add(new CategoryDomain("Camps","cat2"));
        catItems.add(new CategoryDomain("Forest","cat3"));
        catItems.add(new CategoryDomain("Desert","cat4"));
        catItems.add(new CategoryDomain("Mountain","cat5"));

        recyclerCat=findViewById(R.id.categoryRecyclerView);
        recyclerCat.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterCat=new CategoryAdapter(catItems);
        recyclerCat.setAdapter(adapterCat);


    }
}