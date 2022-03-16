package com.app.android.development1.y2021.y2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {

    Button open1, finishActivity, sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        open1 = findViewById(R.id.open1);
        finishActivity = findViewById(R.id.finish_activity);
        sendEmail = findViewById(R.id.send_email);
        open1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity3.this, QuizActivity.class);
//                intent.putExtra(Constant.TEXT1, "Test String");
//                intent.putExtra("number", 5);
//                intent.putExtra("boolean", true);
                User user = new User();
                user.age = 19;
                user.idNumber = "12346789";
                user.name = "name";
                intent.putExtra(Constant.USER, user);
                startActivity(intent);
//                finish();
            }
        });
        finishActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("vnd.android.cursor.item/email");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"abc@xyz.com"});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My Email Subject");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "My email content");
                startActivity(Intent.createChooser(emailIntent, "Send mail using..."));
            }
        });
    }
}