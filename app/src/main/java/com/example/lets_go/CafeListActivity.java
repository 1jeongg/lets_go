package com.example.lets_go;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lets_go.CustomAdapter;

import java.util.ArrayList;

public class CafeListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyDatabaseHelper myDB;
    private ArrayList<String> card_id, card_name, checkbox1,checkbox2,checkbox3,checkbox4,checkbox5,checkbox6,checkbox7,checkbox8;
    private RelativeLayout layout1, layout2, mainLayout;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_list);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        recyclerView = findViewById(R.id.recyclerView);
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        mainLayout = findViewById(R.id.mainLayout);
        myDB = new MyDatabaseHelper(CafeListActivity.this);
        card_id = new ArrayList<>();
        card_name = new ArrayList<>();
        checkbox1 = new ArrayList<>();
        checkbox2 = new ArrayList<>();
        checkbox3 = new ArrayList<>();
        checkbox4 = new ArrayList<>();
        checkbox5 = new ArrayList<>();
        checkbox6 = new ArrayList<>();
        checkbox7 = new ArrayList<>();
        checkbox8 = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(CafeListActivity.this, CafeListActivity.this, card_id, card_name, checkbox1, checkbox2,checkbox3,checkbox4,checkbox5,checkbox6,checkbox7,checkbox8);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(CafeListActivity.this));

        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CafeListActivity.this, CafeDetailActivity2.class);
                startActivity(intent);
            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CafeListActivity.this, CafeDetailActivity3.class);
                startActivity(intent);
            }
        });

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
                checkbox1.add(cursor.getString(2));
                checkbox2.add(cursor.getString(3));
                checkbox3.add(cursor.getString(4));
                checkbox4.add(cursor.getString(5));
                checkbox5.add(cursor.getString(6));
                checkbox6.add(cursor.getString(7));
                checkbox7.add(cursor.getString(8));
                checkbox8.add(cursor.getString(9));

            }
        }
    }


}
