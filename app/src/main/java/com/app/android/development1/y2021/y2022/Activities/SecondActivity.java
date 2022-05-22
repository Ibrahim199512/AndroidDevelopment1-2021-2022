package com.app.android.development1.y2021.y2022.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.android.development1.y2021.y2022.R;
import com.app.android.development1.y2021.y2022.constant.Constant;

public class SecondActivity extends AppCompatActivity {
    TextView counter;
    Button openFirstActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        counter = findViewById(R.id.counter);

        openFirstActivity = findViewById(R.id.open_first_activity);
        openFirstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                startActivity(intent);
                finish();
            }
        });
        SharedPreferences sharedPreferences =
                getSharedPreferences(Constant.FILE_NAME2, MODE_PRIVATE);
        int i = sharedPreferences.getInt("counterSecondActivity", 0);
        counter.setText(i + "");

        i++;

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("counterSecondActivity", i);
        editor.apply();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences =
                getSharedPreferences(Constant.FILE_NAME2, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("lastActivity", 2);
        editor.apply();
    }
}