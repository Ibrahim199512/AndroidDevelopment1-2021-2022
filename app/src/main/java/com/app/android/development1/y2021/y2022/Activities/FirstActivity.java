package com.app.android.development1.y2021.y2022.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.android.development1.y2021.y2022.R;
import com.app.android.development1.y2021.y2022.constant.Constant;

public class FirstActivity extends AppCompatActivity {


    Button openThirdActivity, openSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        openThirdActivity = findViewById(R.id.open_third_activity);
        openSecondActivity = findViewById(R.id.open_second_activity);

        openSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
        openThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, ThirdActivity.class);
                startActivity(intent);
                finish();
            }
        });

        SharedPreferences sharedPreferences =
                getSharedPreferences(Constant.FILE_NAME2, MODE_PRIVATE);
        int i = sharedPreferences.getInt("lastActivity", 0);
        if (i == 0) {
            Toast.makeText(this, "First Time", Toast.LENGTH_SHORT).show();
        } else if (i == 2) {
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            startActivity(intent);
            finish();
        } else if (i == 3) {
            Intent intent = new Intent(FirstActivity.this, ThirdActivity.class);
            startActivity(intent);
            finish();
        }
    }
}