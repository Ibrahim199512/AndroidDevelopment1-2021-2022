package com.app.android.development1.y2021.y2022.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.android.development1.y2021.y2022.R;

public class DialogsActivity extends AppCompatActivity {
    Button showAlertDialog, showCustomDialog;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
        showAlertDialog = findViewById(R.id.show_alert_dialog);
        showCustomDialog = findViewById(R.id.show_custom_dialog);
        showAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                        DialogsActivity.this, R.style.CustomDialogTheme);
                alertDialog.setTitle("Confirm Delete...");
                alertDialog.setMessage("Are you sure you want delete this file?");
                alertDialog.setIcon(R.drawable.ic_baseline_phone_enabled_24);
                alertDialog.setPositiveButton("YES Delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setNegativeButton("NO Don't Delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                alertDialog.show();
            }
        });
        showCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.custom_dialog);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Button done = dialog.findViewById(R.id.done);
                EditText price = dialog.findViewById(R.id.price);
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(DialogsActivity.this,
                                "" + price.getText().toString(), Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}