package com.example.lets_go;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CafeDetailActivity2 extends AppCompatActivity {
    Button btn_detail2;
    EditText cafe_review2;
    TextView review_txt2;
    String review2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_detail2);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        btn_detail2 = findViewById(R.id.btn_detail2);
        cafe_review2 = findViewById(R.id.cafe_review2);
        review_txt2 = findViewById(R.id.review_txt2);

        btn_detail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                review2 = cafe_review2.getText().toString();

                if(review2 != null)
                    review_txt2.setText(review2);
                cafe_review2.setText("");
            }
        });

        actionBar.hide();
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
        if(review2 != null)
            review_txt2.setText(review2);
    }

    protected void saveState(){ // 데이터를 저장한다.
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("review", review2);
        editor.commit();
    }
    protected void restoreState(){  // 데이터를 복구한다.
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if((pref!=null) && (pref.contains("review"))){
            review2 = pref.getString("review", "");
        }

    }
    protected void clearPref(){  // sharedpreference에 쓰여진 데이터 지우기
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        review2 = null;
        editor.commit();
    }

}