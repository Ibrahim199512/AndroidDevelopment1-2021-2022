package com.app.android.development1.y2021.y2022.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.app.android.development1.y2021.y2022.R;
import com.app.android.development1.y2021.y2022.adapter.CustomAdapter;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.list_view);

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
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("A");
        arrayList.add("Z");
        CustomAdapter arrayAdapter = new CustomAdapter(
                this, arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, "position = " + i+" "+arrayList.get(i) , Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, "on Long position = " + i, Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }
}