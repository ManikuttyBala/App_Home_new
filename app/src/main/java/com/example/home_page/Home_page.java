package com.example.home_page;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Home_page extends AppCompatActivity implements UpdateRecyclerView {

    private RecyclerView recyclerView, recyclerView2;
    private StaticRecyclerViewAdapter staticRecyclerViewAdapter;
    private DynamicRvAdapter dynamicRvAdapter;
    int pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ArrayList<StaticRecyclerViewModel> item = new ArrayList<>();
        item.add(new StaticRecyclerViewModel(R.drawable.morn_icon, "Morning"));
        item.add(new StaticRecyclerViewModel(R.drawable.dim, "Night"));
        item.add(new StaticRecyclerViewModel(R.drawable.home, "Going Out"));

        recyclerView = findViewById(R.id.rv_1);
        staticRecyclerViewAdapter = new StaticRecyclerViewAdapter(item, this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(staticRecyclerViewAdapter);

        ArrayList<DynamicRvModel> items = new ArrayList<>();
        items.add(new DynamicRvModel(R.drawable.l2, 0,"Living Room", "Devices"));
        items.add(new DynamicRvModel(R.drawable.kitchen_1, 0,"Kitchen", "Devices"));
        items.add(new DynamicRvModel(R.drawable.bedroom_1, 0,"Bedroom", "Devices"));

        recyclerView2 = findViewById(R.id.rv_2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        dynamicRvAdapter = new DynamicRvAdapter(items);
        recyclerView2.setAdapter(dynamicRvAdapter);

    }

    @Override
    public void callback(int position, ArrayList<DynamicRvModel> items) {

        dynamicRvAdapter = new DynamicRvAdapter(items);
        dynamicRvAdapter.notifyDataSetChanged();
        recyclerView2.setAdapter(dynamicRvAdapter);

        dynamicRvAdapter.setOnItemClickListener(new DynamicRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {
                pos = items.get(position).getPos();
                Intent intent = new Intent(Home_page.this, Appliance_page.class);
                intent.putExtra("pos", pos);
                startActivity(intent);
            }
        });

    }
}