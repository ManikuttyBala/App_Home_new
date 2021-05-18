package com.example.home_page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;

public class Appliance_page extends AppCompatActivity  {

    private RecyclerView recyclerView1;
    private ApplianceRvAdapter applianceRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_appliance_page);


        ArrayList<ApplianceRvModel> item = new ArrayList<>();
        item.add(new ApplianceRvModel(R.drawable.light, "Lights"));
        item.add(new ApplianceRvModel(R.drawable.lamp, "Lamp"));
        item.add(new ApplianceRvModel(R.drawable.fan, "Fan"));

        recyclerView1 = findViewById(R.id.rv_res);
        applianceRvAdapter = new ApplianceRvAdapter(item);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView1.setAdapter(applianceRvAdapter);
    }

}