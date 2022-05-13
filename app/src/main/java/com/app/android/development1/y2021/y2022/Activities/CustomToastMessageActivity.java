package com.app.android.development1.y2021.y2022.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.android.development1.y2021.y2022.R;

public class CustomToastMessageActivity extends AppCompatActivity {
    Button showSuccessToast, showFailToast, showToast, showToast2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast_message);
        showSuccessToast = findViewById(R.id.show_success_toast);
        showFailToast = findViewById(R.id.show_fail_toast);
        showToast = findViewById(R.id.show_toast);
        showToast2 = findViewById(R.id.show_toast2);
//        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        showSuccessToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                LayoutInflater layoutInflater = getLayoutInflater();
//                View layout = layoutInflater.inflate(R.layout.success_custom_toast
//                        , (ViewGroup) findViewById(R.id.custom_toast_layout));
//                Toast toast = new Toast(getApplicationContext());
//                toast.setDuration(Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.BOTTOM, 0, 50);
//                toast.setView(layout);
//                toast.show();
                createToastMessage(R.layout.success_custom_toast);
            }
        });
        showFailToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                LayoutInflater layoutInflater = getLayoutInflater();
//                View layout = layoutInflater.inflate(R.layout.fail_custom_toast
//                        , (ViewGroup) findViewById(R.id.custom_toast_layout));
//                Toast toast = new Toast(getApplicationContext());
//                toast.setDuration(Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.BOTTOM, 0, 50);
//                toast.setView(layout);
//                toast.show();
                createToastMessage(R.layout.fail_custom_toast);
            }
        });
        showToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createToastMessage(true);
            }
        });
        showToast2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createToastMessage(false);
            }
        });

    }

    private void createToastMessage(int layoutRes) {
        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(layoutRes
                , (ViewGroup) findViewById(R.id.custom_toast_layout));
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 50);
        toast.setView(layout);
        toast.show();
    }

    private void createToastMessage(boolean isSeccess) {
        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.custom_toast
                , (ViewGroup) findViewById(R.id.custom_toast_layout));
        ImageView customToastImage = layout.findViewById(R.id.custom_toast_image);
        TextView customToastMessage = layout.findViewById(R.id.custom_toast_message);
        if (isSeccess) {
            layout.setBackground(getDrawable(R.drawable.shape5));
            customToastImage.setImageDrawable(getDrawable(R.drawable.ic_baseline_phone_enabled_24));
            customToastMessage.setTextColor(getColor(R.color.black));
        } else {
            layout.setBackground(getDrawable(R.drawable.shape6));
            customToastImage.setImageDrawable(getDrawable(R.drawable.ic_baseline_phone_disabled_24));
            customToastMessage.setTextColor(getColor(R.color.white));
        }

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 50);
        toast.setView(layout);
        toast.show();
    }

}