package com.app.android.development1.y2021.y2022.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.android.development1.y2021.y2022.R;
import com.bumptech.glide.Glide;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity4 extends AppCompatActivity {

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        image = findViewById(R.id.image);

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg")
                .circleCrop()
                .into(image);


        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                Toast.makeText(MainActivity4.this, ""
//                        + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year, Toast.LENGTH_SHORT).show();

                String dateString = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date d1 = null;
                try {
                    d1 = df.parse(dateString);
//                    Toast.makeText(MainActivity4.this, "" + d1.toString(), Toast.LENGTH_SHORT).show();
                    Log.e("Test", d1.toString());

                    Date currentTime = Calendar.getInstance().getTime();
                    printDifference(d1,currentTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }

    public void printDifference(Date startDate, Date endDate) {
        //milliseconds
        long different = endDate.getTime() - startDate.getTime();
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;
        long yearsInMilli = daysInMilli * 365;
        long elapsedYears = different / yearsInMilli;
        Log.e("elapsedYears", elapsedYears + "");
    }
}