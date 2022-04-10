package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<MenuModel> menuList = new ArrayList<>();
    private MenuAdapter adapter;

    private LinearLayout menuModalAdd;
    private Button btnSubmit, btnBack;
    private TextView add;
    private EditText etMenu, etDetail, etPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        add = findViewById(R.id.tv_add);
        menuModalAdd = findViewById(R.id.layout_add);

        etMenu = findViewById(R.id.et_menu);
        etDetail = findViewById(R.id.et_detail);
        etPrice = findViewById(R.id.et_price);
        btnSubmit = findViewById(R.id.btn_submit);
        btnBack = findViewById(R.id.btn_back);

        add.setOnClickListener(view -> {
            if (recyclerView.getVisibility() == View.VISIBLE){
                recyclerView.setVisibility(View.GONE);
                menuModalAdd.setVisibility(View.VISIBLE);
            }
        });

        btnSubmit.setOnClickListener(view -> {
            if (etMenu.getText().toString().equals("") ||
                etDetail.getText().toString().equals("") ||
                etPrice.getText().toString().equals("")){
                Toast.makeText(this,"Fill the entire form", Toast.LENGTH_SHORT).show();
            }else{
                menuList.add(new MenuModel(etMenu.getText().toString(),
                                           etDetail.getText().toString(),
                                           etPrice.getText().toString()));
                adapter = new MenuAdapter(this, menuList);
                recyclerView.setAdapter(adapter);
                recyclerView.setVisibility(View.VISIBLE);
                menuModalAdd.setVisibility(View.GONE);
                clearInputs();
            }
        });

        btnBack.setOnClickListener(view -> {
            recyclerView.setVisibility(View.VISIBLE);
            menuModalAdd.setVisibility(View.GONE);
        });
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

    public void clearInputs(){
        etMenu.setText("");
        etDetail.setText("");
        etPrice.setText("");
    }
}