package com.app.android.development1.y2021.y2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    EditText firstName, lastName, email, phoneNumber, salary;
    RadioButton house, apartment, studio, under500, from501To1000, from1001To2000, above2001;
    Button save;
    TextView text3;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        phoneNumber = findViewById(R.id.phone_number);
        salary = findViewById(R.id.salary);
        house = findViewById(R.id.house);
        apartment = findViewById(R.id.apartment);
        studio = findViewById(R.id.studio);
        under500 = findViewById(R.id.under_500);
        from501To1000 = findViewById(R.id.from_501_to_1000);
        from1001To2000 = findViewById(R.id.from_1001_to_2000);
        above2001 = findViewById(R.id.above_2001);
        save = findViewById(R.id.save);
        text3 = findViewById(R.id.text3);
        scrollView = findViewById(R.id.scroll_view);

        Bundle bundle = getIntent().getExtras();
        String s = bundle.getString("text1555");
        Log.e("QuizActivityTest", "hhhhh" + s);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //First Solution
//                if (!firstName.getText().toString().isEmpty()) {
//                    if (!lastName.getText().toString().isEmpty()) {
//                        if (!email.getText().toString().isEmpty()) {
//                            if (!phoneNumber.getText().toString().isEmpty()) {
//                                if (house.isChecked() || apartment.isChecked() || studio.isChecked()) {
//                                    if (under500.isChecked() || from501To1000.isChecked() || from1001To2000.isChecked() || above2001.isChecked()) {
//                                        if (!salary.getText().toString().isEmpty()) {
//                                            double salaryDouble = Double.parseDouble(salary.getText().toString());
//                                            if (under500.isChecked() && salaryDouble < 500) {
//                                                Toast.makeText(QuizActivity.this, "Done", Toast.LENGTH_SHORT).show();
//                                                scrollView.setVisibility(View.GONE);
//                                                text3.setVisibility(View.VISIBLE);
//                                            } else if (from501To1000.isChecked() && salaryDouble > 500 && salaryDouble < 1001) {
//                                                Toast.makeText(QuizActivity.this, "Done", Toast.LENGTH_SHORT).show();
//                                                scrollView.setVisibility(View.GONE);
//                                                text3.setVisibility(View.VISIBLE);
//                                            } else if (from1001To2000.isChecked() && salaryDouble > 1000 && salaryDouble < 2001) {
//                                                Toast.makeText(QuizActivity.this, "Done", Toast.LENGTH_SHORT).show();
//                                                scrollView.setVisibility(View.GONE);
//                                                text3.setVisibility(View.VISIBLE);
//                                            } else if (above2001.isChecked() && salaryDouble > 2001) {
//                                                Toast.makeText(QuizActivity.this, "Done", Toast.LENGTH_SHORT).show();
//                                                scrollView.setVisibility(View.GONE);
//                                                text3.setVisibility(View.VISIBLE);
//                                            } else {
//                                                Toast.makeText(QuizActivity.this, "Ckeck your salary range ", Toast.LENGTH_SHORT).show();
//                                            }
//                                        } else {
//                                            Toast.makeText(QuizActivity.this, "Enter salary  ", Toast.LENGTH_SHORT).show();
//                                        }
//                                    } else {
//                                        Toast.makeText(QuizActivity.this, "Enter salary range ", Toast.LENGTH_SHORT).show();
//                                    }
//                                } else {
//                                    Toast.makeText(QuizActivity.this, "Enter Where you live ", Toast.LENGTH_SHORT).show();
//                                }
//                            } else {
//                                Toast.makeText(QuizActivity.this, "Enter phone Number", Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            Toast.makeText(QuizActivity.this, "Enter email Name", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Toast.makeText(QuizActivity.this, "Enter last Name", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(QuizActivity.this, "Enter First Name", Toast.LENGTH_SHORT).show();
//                }

                //second solution
                String temp = validation();
                if (temp.isEmpty()) {
                    scrollView.setVisibility(View.GONE);
                    text3.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(QuizActivity.this, "" + temp, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    public String validation() {
//        String result = "";
        if (firstName.getText().toString().isEmpty()) {
            return "Enter First Name";
        } else if (lastName.getText().toString().isEmpty()) {
            return "Enter last Name";
        } else if (email.getText().toString().isEmpty()) {
            return "Enter email Name";
        } else if (phoneNumber.getText().toString().isEmpty()) {
            return "Enter phone Number";
        } else if (!house.isChecked() && !apartment.isChecked() && !studio.isChecked()) {
            return "Enter Where you live ";
        } else if (!under500.isChecked() && !from501To1000.isChecked() && !from1001To2000.isChecked() && !above2001.isChecked()) {
            return "Enter salary range";
        } else if (salary.getText().toString().isEmpty()) {
            return "Enter salary";
        } else if (under500.isChecked() && Double.parseDouble(salary.getText().toString()) > 500) {
            return "Ckeck your salary range";
        } else if (from501To1000.isChecked()
                && (Double.parseDouble(salary.getText().toString()) < 500
                || Double.parseDouble(salary.getText().toString()) > 1001)) {
            return "Ckeck your salary range";
        } else if (from1001To2000.isChecked()
                && (Double.parseDouble(salary.getText().toString()) < 1000
                || Double.parseDouble(salary.getText().toString()) > 2001)) {
            return "Ckeck your salary range";
        } else if (above2001.isChecked() && Double.parseDouble(salary.getText().toString()) < 2001) {
            return "Ckeck your salary range";
        }
        return "";
    }


}