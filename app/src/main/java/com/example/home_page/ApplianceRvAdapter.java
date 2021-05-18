package com.example.home_page;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ApplianceRvAdapter extends RecyclerView.Adapter<ApplianceRvAdapter.ApplianceRecyclerViewHolder> {

    private ArrayList<ApplianceRvModel> item;
    int row_index =-1;

    public ApplianceRvAdapter(ArrayList<ApplianceRvModel> item) {
        this.item = item;
    }


    @NonNull
    @Override
    public ApplianceRvAdapter.ApplianceRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.appliance_rv_item, parent,false);
        ApplianceRecyclerViewHolder avh = new ApplianceRecyclerViewHolder(v);
        return avh;
    }

    @Override
    public void onBindViewHolder(@NonNull ApplianceRvAdapter.ApplianceRecyclerViewHolder holder, int position) {

        ApplianceRvModel currentItem = item.get(position);
        holder.image_2.setImageResource(currentItem.getImage_2());
        holder.text_1.setText(currentItem.getText_1());

        holder.constraintLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index = position;
                notifyDataSetChanged();

                }
        });

        if (row_index == position){
            holder.constraintLayout1.setBackgroundResource(R.drawable.res_bg);
        }
        else {
            holder.constraintLayout1.setBackgroundResource(R.drawable.static_rv_bg);
        }

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ApplianceRecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView text_1;
        ImageView image_2;
        ConstraintLayout constraintLayout1;

        public ApplianceRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            image_2 = itemView.findViewById(R.id.image_2);
            text_1 = itemView.findViewById(R.id.text_1);
            constraintLayout1 = itemView.findViewById(R.id.appliance_layout);
        }


    }


}
