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
    private ArrayList card_id, card_name, checkbox1,checkbox2,checkbox3,checkbox4,checkbox5,checkbox6,checkbox7,checkbox8;

    CustomAdapter(Activity activity, Context context,
                  ArrayList card_id,
                  ArrayList card_name,
                  ArrayList checkbox1,
                  ArrayList checkbox2,
                  ArrayList checkbox3,
                  ArrayList checkbox4,
                  ArrayList checkbox5,
                  ArrayList checkbox6,
                  ArrayList checkbox7,
                  ArrayList checkbox8){
        this.activity = activity;
        this.context = context;
        this.card_id = card_id;
        this.card_name = card_name;
        this.checkbox1 = checkbox1;
        this.checkbox2 = checkbox2;
        this.checkbox3 = checkbox3;
        this.checkbox4 = checkbox4;
        this.checkbox5 = checkbox5;
        this.checkbox6 = checkbox6;
        this.checkbox7 = checkbox7;
        this.checkbox8 = checkbox8;

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
        holder.restaurant_tag_txt1.setText(String.valueOf(checkbox1.get(position)));
        holder.restaurant_tag_txt2.setText(String.valueOf(checkbox2.get(position)));
        holder.restaurant_tag_txt3.setText(String.valueOf(checkbox3.get(position)));
        holder.restaurant_tag_txt4.setText(String.valueOf(checkbox4.get(position)));
        holder.restaurant_tag_txt5.setText(String.valueOf(checkbox5.get(position)));
        holder.restaurant_tag_txt6.setText(String.valueOf(checkbox6.get(position)));
        holder.restaurant_tag_txt7.setText(String.valueOf(checkbox7.get(position)));
        holder.restaurant_tag_txt8.setText(String.valueOf(checkbox8.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = String.valueOf(card_name);
                Intent intent = new Intent(context, CafeDetailActivity.class);
                intent.putExtra("text", input);

                activity.startActivityForResult(intent, 1);

            }
        });
    }

    @Override
    public int getItemCount() {
        return card_id.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView card_id_txt, restaurant_name_txt, restaurant_tag_txt1, restaurant_tag_txt2, restaurant_tag_txt3, restaurant_tag_txt4, restaurant_tag_txt5;
        TextView restaurant_tag_txt6, restaurant_tag_txt7, restaurant_tag_txt8;
        RelativeLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            card_id_txt = itemView.findViewById(R.id.card_id_txt);
            restaurant_name_txt = itemView.findViewById(R.id.restaurant_name_txt);
            restaurant_tag_txt1 = itemView.findViewById(R.id.restaurant_tag_txt1);
            restaurant_tag_txt2 = itemView.findViewById(R.id.restaurant_tag_txt2);
            restaurant_tag_txt3 = itemView.findViewById(R.id.restaurant_tag_txt3);
            restaurant_tag_txt4 = itemView.findViewById(R.id.restaurant_tag_txt4);
            restaurant_tag_txt5 = itemView.findViewById(R.id.restaurant_tag_txt5);
            restaurant_tag_txt6 = itemView.findViewById(R.id.restaurant_tag_txt6);
            restaurant_tag_txt7 = itemView.findViewById(R.id.restaurant_tag_txt7);
            restaurant_tag_txt8 = itemView.findViewById(R.id.restaurant_tag_txt8);

            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}

