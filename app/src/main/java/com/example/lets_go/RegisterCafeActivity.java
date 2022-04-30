package com.example.lets_go;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class RegisterCafeActivity extends AppCompatActivity {

    private Button btn_register_all;
    private EditText restaurant_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_cafe);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        restaurant_input = findViewById(R.id.restaurant_input);
        final CheckBox cb1 = findViewById(R.id.checkbox1);
        final CheckBox cb2 = findViewById(R.id.checkbox2);
        final CheckBox cb3 = findViewById(R.id.checkbox3);
        final CheckBox cb4 = findViewById(R.id.checkbox4);
        final CheckBox cb5 = findViewById(R.id.checkbox5);
        final CheckBox cb6 = findViewById(R.id.checkbox6);
        final CheckBox cb7 = findViewById(R.id.checkbox7);
        final CheckBox cb8 = findViewById(R.id.checkbox8);
        final CheckBox cb9 = findViewById(R.id.checkbox9);
        final CheckBox cb10 = findViewById(R.id.checkbox10);
        final CheckBox cb11 = findViewById(R.id.checkbox11);

        btn_register_all = findViewById(R.id.btn_register_all);
        btn_register_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c1,c2,c3,c4,c5,c6=" ",c7,c8;
                if (cb1.isChecked()){
                    c1 = cb1.getText().toString().trim();
                }else{
                    c1 = "";
                }
                if (cb2.isChecked()){
                    c2 = cb2.getText().toString().trim();
                }
                else if(cb10.isChecked()) {
                    c2 = cb2.getText().toString().trim();
                }
                else{
                    c2 = "";
                }
                if (cb3.isChecked()){
                    c3 = cb3.getText().toString().trim();
                }
                else if(cb8.isChecked()) {
                    c3 = cb8.getText().toString().trim();
                }
                else if(cb11.isChecked()) {
                    c3 = cb11.getText().toString().trim();
                }
                else{
                    c3 = "";
                }
                if (cb4.isChecked()){
                    c4 = cb4.getText().toString().trim();
                }else{
                    c4 = "";
                }
                if (cb5.isChecked()){
                    c5 = cb5.getText().toString().trim();
                }else{
                    c5 = "";
                }
                if (cb6.isChecked()){
                    c6 = cb6.getText().toString().trim();
                }else{
                    c6 = "";
                }
                if (cb7.isChecked()){
                    c7 = cb7.getText().toString().trim();
                }else{
                    c7 = "";
                }
                if (cb9.isChecked()){
                    c8 = cb9.getText().toString().trim();
                }else{
                    c8 = "";
                }

                MyDatabaseHelper myDB = new MyDatabaseHelper((RegisterCafeActivity.this));
                myDB.addCard(restaurant_input.getText().toString().trim(),c1,c2,c3,c4,c5,c6,c7,c8);

                Intent intent = new Intent(RegisterCafeActivity.this, CafeListActivity.class);
                startActivity(intent);
            }
        });


    }
}