package com.example.lets_go;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    private Context context;
    Activity activity;
    private ArrayList card_id, card_name;

    CustomAdapter(Activity activity, Context context,
                  ArrayList card_id,
                  ArrayList card_name){
        this.activity = activity;
        this.context = context;
        this.card_id = card_id;
        this.card_name = card_name;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.card_id_txt.setText(String.valueOf(card_id.get(position)));
        holder.restaurant_name_txt.setText(String.valueOf(card_name.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RegisterCafeActivity.class);
                intent.putExtra("id", String.valueOf(card_id.get(holder.getAdapterPosition())));
                intent.putExtra("name", String.valueOf(card_name.get(holder.getAdapterPosition())));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return card_id.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView card_id_txt, restaurant_name_txt;
        RelativeLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            card_id_txt = itemView.findViewById(R.id.card_id_txt);
            restaurant_name_txt = itemView.findViewById(R.id.restaurant_name_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}

