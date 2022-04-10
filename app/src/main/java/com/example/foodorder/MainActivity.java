package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<MenuModel> menuList = new ArrayList<>();
    private MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    public void initView(){
        recyclerView = findViewById(R.id.recycle_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        menuList = new ArrayList<>();
        adapter = new MenuAdapter(this,menuList);
        recyclerView.setAdapter(adapter);
        createList();
    }

    private void createList(){
        menuList.add(new MenuModel("Chicken Salted Egg", "Nasi Ayam Telur Asin Saus Keju", "25.000"));
        menuList.add(new MenuModel("Chicken Cordon Bleu", "Daging dengan Keju dilapisi Tepung Roti", "45.000"));
        menuList.add(new MenuModel("Chicken Salted Egg", "Nasi Ayam Telur Asin Saus Keju", "25.000"));
        menuList.add(new MenuModel("Chicken Cordon Bleu", "Daging dengan Keju dilapisi Tepung Roti", "45.000"));
        menuList.add(new MenuModel("Chicken Salted Egg", "Nasi Ayam Telur Asin Saus Keju", "25.000"));
        menuList.add(new MenuModel("Chicken Cordon Bleu", "Daging dengan Keju dilapisi Tepung Roti", "45.000"));
        menuList.add(new MenuModel("Chicken Salted Egg", "Nasi Ayam Telur Asin Saus Keju", "25.000"));
        menuList.add(new MenuModel("Chicken Cordon Bleu", "Daging dengan Keju dilapisi Tepung Roti", "45.000"));
    }
}