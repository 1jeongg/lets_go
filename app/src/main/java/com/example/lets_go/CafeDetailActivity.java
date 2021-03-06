package com.example.lets_go;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CafeDetailActivity extends AppCompatActivity {
    Button btn_detail;
    EditText cafe_review;
    TextView review_txt;
    String review;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_detail);

         btn_detail = findViewById(R.id.btn_detail);
         cafe_review = findViewById(R.id.cafe_review);
         review_txt = findViewById(R.id.review_txt);

         ActionBar actionBar = getSupportActionBar();
         actionBar.hide();

         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                 WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent intent = getIntent();

        String text = intent.getStringExtra("text");
        TextView name_detail = findViewById(R.id.name_detail);
        name_detail.setText(text);

         btn_detail.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 review = cafe_review.getText().toString();

                 if(review != null)
                     review_txt.setText(review);
                 cafe_review.setText("");
             }
         });


    }
    @Override
    protected void onPause() { // Activity가 보이지 않을때 값을 저장한다.
        super.onPause();
        saveState();
    }

    @Override
    protected void onStart() {  // Activity가 보이기 시작할때 값을 저장한다.
        super.onStart();
        restoreState();
        if(review != null)
            review_txt.setText(review);
    }

    protected void saveState(){ // 데이터를 저장한다.
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("review", review);
        editor.commit();
    }
    protected void restoreState(){  // 데이터를 복구한다.
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if((pref!=null) && (pref.contains("review"))){
            review = pref.getString("review", "");
        }

    }
    protected void clearPref(){  // sharedpreference에 쓰여진 데이터 지우기
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        review = null;
        editor.commit();
    }


}