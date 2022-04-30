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

public class CafeDetailActivity3 extends AppCompatActivity {
    Button btn_detail3;
    EditText cafe_review3;
    TextView review_txt3;
    String review3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_detil3);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        btn_detail3 = findViewById(R.id.btn_detail3);
        cafe_review3 = findViewById(R.id.cafe_review3);
        review_txt3 = findViewById(R.id.review_txt3);

        btn_detail3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                review3 = cafe_review3.getText().toString();

                if (review3 != null)
                    review_txt3.setText(review3);
                cafe_review3.setText("");
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
        if (review3 != null)
            review_txt3.setText(review3);
    }

    protected void saveState() { // 데이터를 저장한다.
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("review", review3);
        editor.commit();
    }

    protected void restoreState() {  // 데이터를 복구한다.
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ((pref != null) && (pref.contains("review"))) {
            review3 = pref.getString("review", "");
        }
    }
}