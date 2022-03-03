package com.app.android.development1.y2021.y2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("onCreate", "Done");

        Button myButton = findViewById(R.id.my_button);
        Button myButton2 = findViewById(R.id.my_button2);
        myButton.setOnClickListener(this);
        myButton2.setOnClickListener(this);
//        myButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this
//                        , "Test1", Toast.LENGTH_SHORT).show();
//            }
//        });
//        myButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this
//                        , "Test2", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart", "Done");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume", "Done");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause", "Done");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop", "Done");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy", "Done");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.my_button) {
            Toast.makeText(this, "myButton", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "myButton2", Toast.LENGTH_SHORT).show();
        }

    }
}