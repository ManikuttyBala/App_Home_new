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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class DynamicRvAdapter extends RecyclerView.Adapter<DynamicRvAdapter.DynamicRecyclerViewHolder> {

    public ArrayList<DynamicRvModel> dynamicRvModels;
    private OnItemClickListener aListener;

    public interface OnItemClickListener{
        void onItemClickListener(int position);
    }

    public void setOnItemClickListener(OnItemClickListener aListener) {
        this.aListener = aListener;
    }

    public DynamicRvAdapter(ArrayList<DynamicRvModel> dynamicRvModels){
        this.dynamicRvModels = dynamicRvModels;
    }

    public class DynamicRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView textView, textView_1;
        ImageView imageView;
        ConstraintLayout constraintLayout;

        public DynamicRecyclerViewHolder(@NonNull View itemView, final OnItemClickListener aListener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.room_pic);
            textView = itemView.findViewById(R.id.room);
            textView_1 = itemView.findViewById(R.id.devices);
            constraintLayout = itemView.findViewById(R.id.room_layout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (aListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            aListener.onItemClickListener(position);
                        }


                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public DynamicRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dynamic_rv_item_layout,parent,false);
        DynamicRecyclerViewHolder dynamicRecyclerViewHolder = new DynamicRecyclerViewHolder(view, aListener);
        return dynamicRecyclerViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull DynamicRvAdapter.DynamicRecyclerViewHolder holder, int position) {

        DynamicRvModel currentItem = dynamicRvModels.get(position);
        holder.imageView.setImageResource(currentItem.getRoom_pic());
        holder.textView.setText(currentItem.getRoom());
        holder.textView_1.setText(currentItem.getDevices());
    }

    @Override
    public int getItemCount() {
        return dynamicRvModels.size();
    }

}
