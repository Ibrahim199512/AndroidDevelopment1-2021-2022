package com.app.android.development1.y2021.y2022.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.app.android.development1.y2021.y2022.R;
import com.app.android.development1.y2021.y2022.adapter.CustomAdapter;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.list_view);
        button = findViewById(R.id.button);

//        //First
//        String[] strings = {"A", "AA", "AAA", "AAAA", "AAAAA",
//                "A", "AA", "AAA", "AAAA", "AAAAA",
//                "A", "AA", "AAA", "AAAA", "AAAAA",
//                "A", "AA", "AAA", "AAAA", "AAAAA",
//                "A", "AA", "AAA", "AAAA", "AAAAA",
//                "A", "AA", "AAA", "AAAA", "AAAAA",
//                "A", "AA", "AAA", "AAAA", "AAAAA"};
//        ArrayAdapter<String> arrayAdapter =
//                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings);
//        listView.setAdapter(arrayAdapter);

        //Second
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("F");
        arrayList.add("G");
        arrayList.add("Z");
        CustomAdapter arrayAdapter = new CustomAdapter(
                this, arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, "position = " + i + " " + arrayList.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, "on Long position = " + i, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Add From Activity
//                arrayList.add("FFFF");
//                arrayAdapter.notifyDataSetChanged();
                //Add From Adapter
//                arrayAdapter.addItem("GGGG");

//****************************************************************************

                //Edit From Activity
//                int i = 6;
//                if (i < arrayList.size()) {
//                    arrayList.set(i, "KKKKKKK");
//                    arrayAdapter.notifyDataSetChanged();
//                } else {
//                    Toast.makeText(ListViewActivity.this, "No Item", Toast.LENGTH_SHORT).show();
//                }
                //Edit From Adapter
//                arrayAdapter.editItem(8, "KKKKKKK");

//****************************************************************************

                //Delete From Activity
//                int i = 0;
//                if (i < arrayList.size()) {
//                    arrayList.remove(i);
//                    arrayAdapter.notifyDataSetChanged();
//                } else {
//                    Toast.makeText(ListViewActivity.this, "No Item", Toast.LENGTH_SHORT).show();
//                }
                //Delete From Adapter
                arrayAdapter.deleteItem(0);
            }
        });
    }
}