package com.app.android.development1.y2021.y2022.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

import com.app.android.development1.y2021.y2022.constant.Constant;
import com.app.android.development1.y2021.y2022.R;
import com.app.android.development1.y2021.y2022.models.Student;
import com.google.gson.Gson;

public class SharedPreferencesActivity2 extends AppCompatActivity {

    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences2);
        seekBar = findViewById(R.id.seek_bar);


        save(Constant.FILE_NAME,Constant.TEXT1,"Test");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress
                    , boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SharedPreferencesActivity2.this,
                        "" + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
                Student student = new Student(seekBar.getProgress());
                Gson gson = new Gson();
                String studentString = gson.toJson(student);
                SharedPreferences sharedPreferences =
                        getSharedPreferences(Constant.FILE_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(Constant.STUDENT, studentString);
                editor.apply();
            }
        });


        SharedPreferences sharedPreferences =
                getSharedPreferences(Constant.FILE_NAME, MODE_PRIVATE);
        String temp = sharedPreferences.getString(Constant.STUDENT, "");
        Gson gson = new Gson();
        if (!temp.isEmpty()) {
            Student student = gson.fromJson(temp, Student.class);
            Toast.makeText(this, "" + student.getGpa(), Toast.LENGTH_SHORT).show();
            seekBar.setProgress(student.getGpa());
        }
    }

    public void save(String fileName, String key, String value) {
        SharedPreferences sharedPreferences =
                getSharedPreferences(fileName, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
}