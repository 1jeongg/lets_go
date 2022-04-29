package com.example.lets_go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.card.MyDatabaseHelper;

import org.w3c.dom.Text;

public class RegisterCafeActivity extends AppCompatActivity {

    private Button btn_register_all;
    private EditText restaurant_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_cafe);

        restaurant_input = findViewById(R.id.restaurant_input);
        final CheckBox cb1 = (CheckBox)findViewById(R.id.checkbox1);
        final CheckBox cb2 = (CheckBox)findViewById(R.id.checkbox2);
        final CheckBox cb3 = (CheckBox)findViewById(R.id.checkbox3);
        final CheckBox cb4 = (CheckBox)findViewById(R.id.checkbox4);
        final CheckBox cb5 = (CheckBox)findViewById(R.id.checkbox5);
        final CheckBox cb6 = (CheckBox)findViewById(R.id.checkbox6);
        final CheckBox cb7 = (CheckBox)findViewById(R.id.checkbox7);
        final CheckBox cb8 = (CheckBox)findViewById(R.id.checkbox8);
        final CheckBox cb9 = (CheckBox)findViewById(R.id.checkbox9);
        final CheckBox cb10 = (CheckBox)findViewById(R.id.checkbox10);
        final CheckBox cb11 = (CheckBox)findViewById(R.id.checkbox11);

        btn_register_all = findViewById(R.id.btn_register_all);
        btn_register_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper((RegisterCafeActivity.this));
                myDB.addCard(restaurant_input.getText().toString().trim());
                if (cb1.isChecked()){

                }
                Intent intent = new Intent(RegisterCafeActivity.this, CafeListActivity.class);
                startActivity(intent);
            }
        });


    }
}