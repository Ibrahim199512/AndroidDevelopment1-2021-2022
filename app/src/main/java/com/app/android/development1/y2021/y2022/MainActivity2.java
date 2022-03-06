package com.app.android.development1.y2021.y2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button print, print2;
    CheckBox checkbox;
    EditText phoneNumber;
    RadioButton male, female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        print = findViewById(R.id.print);
        checkbox = findViewById(R.id.checkbox);
        phoneNumber = findViewById(R.id.phone_number);
        print2 = findViewById(R.id.print2);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkbox.isChecked()) {
                    String s = phoneNumber.getText().toString();
                    if (s.isEmpty()) {
                        Toast.makeText(MainActivity2.this,
                                "Enter Your Number", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity2.this,
                                "" + s, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity2.this,
                            "N/A", Toast.LENGTH_SHORT).show();
                }

            }
        });

        print2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (male.isChecked()) {
                    Toast.makeText(MainActivity2.this, "Male", Toast.LENGTH_SHORT).show();
                } else if (female.isChecked()) {
                    Toast.makeText(MainActivity2.this, "Female", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity2.this, "N/A", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}