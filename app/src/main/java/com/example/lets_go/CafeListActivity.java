package com.example.lets_go;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lets_go.CustomAdapter;

import java.util.ArrayList;

public class CafeListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private com.example.card.MyDatabaseHelper myDB;
    private ArrayList<String> card_id, card_name;

    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_list);

        recyclerView = findViewById(R.id.recyclerView);
        myDB = new com.example.card.MyDatabaseHelper(CafeListActivity.this);
        card_id = new ArrayList<>();
        card_name = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(CafeListActivity.this, CafeListActivity.this, card_id, card_name);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(CafeListActivity.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()) {
                card_id.add(cursor.getString(0));
                card_name.add(cursor.getString(1));
            }
        }
    }


}
