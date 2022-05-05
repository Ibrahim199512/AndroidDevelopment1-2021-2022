package com.app.android.development1.y2021.y2022.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.android.development1.y2021.y2022.R;

public class OptionsMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_options_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.about:
//                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.help:
//                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
//                return true;
//            default:
//                Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
//                return true;
//        }

        if (item.getItemId() == R.id.about) {
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.help) {
            Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}