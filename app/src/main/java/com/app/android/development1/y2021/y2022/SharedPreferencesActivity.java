package com.app.android.development1.y2021.y2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPreferencesActivity extends AppCompatActivity {

    EditText email;
    Button save, retriev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        email = findViewById(R.id.email);
        save = findViewById(R.id.save);
        retriev = findViewById(R.id.retriev);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences =
                        getSharedPreferences(Constant.FILE_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email", email.getText().toString());
                editor.apply();
            }
        });
        retriev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences =
                        getSharedPreferences(Constant.FILE_NAME, MODE_PRIVATE);
                String s = sharedPreferences.getString("email", "No Value");
                email.setText(s);
                Toast.makeText(SharedPreferencesActivity.this, "" + s, Toast.LENGTH_SHORT).show();
            }
        });

    }
}