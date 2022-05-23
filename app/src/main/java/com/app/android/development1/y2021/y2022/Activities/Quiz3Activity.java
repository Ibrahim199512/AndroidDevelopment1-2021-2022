package com.app.android.development1.y2021.y2022.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.android.development1.y2021.y2022.R;
import com.app.android.development1.y2021.y2022.database.MyDatabase;

public class Quiz3Activity extends AppCompatActivity {
    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);


        myDatabase = new MyDatabase(this);
//        boolean b = myDatabase.insertBook("title", "Dec"
//                , "Author");
//
//        Log.e("insertBook", b + "");
//        Toast.makeText(this, "insertBook = " + b, Toast.LENGTH_SHORT).show();

        myDatabase.getAllBooks();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_options_menu2, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        final Dialog dialog = new Dialog(Quiz3Activity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.custom_dialog2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        EditText bookId = dialog.findViewById(R.id.book_id);
        EditText bookAuthor = dialog.findViewById(R.id.book_author);
        Button edit = dialog.findViewById(R.id.edit);
        Button delete = dialog.findViewById(R.id.delete);


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bookId.getText().toString().isEmpty()) {
                    Toast.makeText(Quiz3Activity.this, "Enter book Id", Toast.LENGTH_SHORT).show();
                } else if (bookAuthor.getText().toString().isEmpty()) {
                    Toast.makeText(Quiz3Activity.this, "Enter Author Id", Toast.LENGTH_SHORT).show();
                } else {
                    int i = myDatabase.editBook(Integer.parseInt(bookId.getText().toString())
                            , bookAuthor.getText().toString());
                    Toast.makeText(Quiz3Activity.this, i + "", Toast.LENGTH_SHORT).show();

                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bookId.getText().toString().isEmpty()) {
                    Toast.makeText(Quiz3Activity.this, "Enter book Id", Toast.LENGTH_SHORT).show();
                } else {
                    int i = myDatabase.deleteBook(Integer.parseInt(bookId.getText().toString()));
                    if (i == 0) {
                        Toast.makeText(Quiz3Activity.this, "Not Done", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Quiz3Activity.this, "Done", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        dialog.show();
        return true;
    }
}