package com.app.android.development1.y2021.y2022.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.app.android.development1.y2021.y2022.R;
import com.app.android.development1.y2021.y2022.constant.Constant;

public class SharedPreferencesActivity3 extends AppCompatActivity {
    CheckBox rememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences3);
        rememberMe = findViewById(R.id.remember_me);

        SharedPreferences sharedPreferences =
                getSharedPreferences(Constant.FILE_NAME, MODE_PRIVATE);
        boolean b = sharedPreferences.getBoolean("remmberMe", false);
        if (b) {
            startActivity(new Intent(SharedPreferencesActivity3.this, QuizActivity.class));
        }
//        else{
//            startActivity(new Intent(SharedPreferencesActivity3.this,MainActivity.class));
//        }
        Toast.makeText(SharedPreferencesActivity3.this, "" + b, Toast.LENGTH_SHORT).show();


        rememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(SharedPreferencesActivity3.this, "" + b, Toast.LENGTH_SHORT).show();

                SharedPreferences sharedPreferences =
                        getSharedPreferences(Constant.FILE_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("remmberMe", b);
                editor.apply();
            }
        });
    }
}