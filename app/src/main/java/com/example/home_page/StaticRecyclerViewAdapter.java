package com.example.home_page;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StaticRecyclerViewAdapter extends RecyclerView.Adapter<StaticRecyclerViewAdapter.StaticRecyclerViewHolder>{

    private ArrayList<StaticRecyclerViewModel> items;
    int row_index = -1;

    UpdateRecyclerView updateRecyclerView;
    Activity activity;
    boolean check = true;
    boolean select = true;

    public StaticRecyclerViewAdapter(ArrayList<StaticRecyclerViewModel> items, Activity activity, UpdateRecyclerView updateRecyclerView) {
        this.items = items;
        this.activity = activity;
        this.updateRecyclerView = updateRecyclerView;
    }

    @NonNull
    @Override
    public StaticRecyclerViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv_item,parent,false);
        StaticRecyclerViewHolder staticRecyclerViewHolder = new StaticRecyclerViewHolder(view);
        return staticRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaticRecyclerViewAdapter.StaticRecyclerViewHolder holder, int position) {

        StaticRecyclerViewModel currentItem = items.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.textView.setText(currentItem.getText());

        if (check){

            ArrayList<DynamicRvModel> items = new ArrayList<DynamicRvModel>();
            items.add(new DynamicRvModel(R.drawable.l2,0,"Living Room", "Devices"));
            items.add(new DynamicRvModel(R.drawable.kitchen_1, 0, "Kitchen", "Devices"));
            items.add(new DynamicRvModel(R.drawable.bedroom_1, 0, "Bedroom","Devices"));

            updateRecyclerView.callback(position, items);

            check = false;
        }


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();

                if(position == 0){

                    ArrayList<DynamicRvModel> items = new ArrayList<DynamicRvModel>();
                    items.add(new DynamicRvModel(R.drawable.l2, 0 ,"Living Room", "Devices"));
                    items.add(new DynamicRvModel(R.drawable.kitchen_1, 0, "Kitchen", "Devices"));
                    items.add(new DynamicRvModel(R.drawable.bedroom_1, 0, "Bedroom", "Devices"));

                    updateRecyclerView.callback(position, items);


                }

                else if (position ==  1){
                    ArrayList<DynamicRvModel> items = new ArrayList<DynamicRvModel>();
                    items.add(new DynamicRvModel(R.drawable.l2, 1 ,"Living Room", "Devices"));
                    items.add(new DynamicRvModel(R.drawable.kitchen_1, 1, "Kitchen", "Devices"));
                    items.add(new DynamicRvModel(R.drawable.bedroom_1, 1, "Bedroom", "Devices"));

                    updateRecyclerView.callback(position, items);

                }

                else if (position ==  2){
                    ArrayList<DynamicRvModel> items = new ArrayList<DynamicRvModel>();
                    items.add(new DynamicRvModel(R.drawable.l2, 2, "Living Room", "Devices"));
                    items.add(new DynamicRvModel(R.drawable.kitchen_1, 2 ,"Kitchen", "Devices"));
                    items.add(new DynamicRvModel(R.drawable.bedroom_1, 2, "Bedroom", "Devices"));

                    updateRecyclerView.callback(position, items);

                }

            }
        });

        if (select){
            if (position == 0){
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected_bg);
                select = false;
            }
            else{
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv_bg);

            }

        }

        if (row_index == position){
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_bg);
        }
        else{
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected_bg);
        }

    }

    @Override
    public int getItemCount() {

        return items.size();
    }


    public static class StaticRecyclerViewHolder extends RecyclerView.ViewHolder{

       TextView textView;
       ImageView imageView;
       LinearLayout linearLayout;

        public StaticRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text);
            linearLayout = itemView.findViewById(R.id.linearlayout);

        }
    }

}
