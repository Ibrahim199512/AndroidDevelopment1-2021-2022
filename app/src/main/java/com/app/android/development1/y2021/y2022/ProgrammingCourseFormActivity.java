package com.app.android.development1.y2021.y2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class ProgrammingCourseFormActivity extends AppCompatActivity {

    EditText name;
    RadioButton age1, age2, age3, male, female;
    CheckBox java, c;
    Button save;
    ConstraintLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming_course_form);
        name = findViewById(R.id.name);
        age1 = findViewById(R.id.age1);
        age2 = findViewById(R.id.age2);
        age3 = findViewById(R.id.age3);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        java = findViewById(R.id.java);
        c = findViewById(R.id.c);
        save = findViewById(R.id.save);
        parent = findViewById(R.id.parent);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().isEmpty()) {
                    if (age1.isChecked()
                            || age2.isChecked()
                            || age3.isChecked()) {
                        if (male.isChecked()
                                || female.isChecked()) {
                            if (java.isChecked()
                                    || c.isChecked()) {
                                parent.setBackgroundColor(getColor(R.color.green));
                            }
                        }
                    }
                }

            }
        });
    }
}