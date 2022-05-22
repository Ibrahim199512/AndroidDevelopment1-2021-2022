package com.app.android.development1.y2021.y2022.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.app.android.development1.y2021.y2022.R;
import com.app.android.development1.y2021.y2022.activities.ListViewActivity;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {
    ArrayList<String> strings;
    Context context;

    public CustomAdapter(@NonNull Context context, ArrayList<String> strings) {
        super(context, 0, strings);
        this.strings = strings;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.listview_item, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.text);
        textView.setText(strings.get(position) + " position = " + position);
        if (position % 2 == 0) {
            //even
            textView.setTextColor(context.getColor(R.color.blue));
        } else {
            //odd
            textView.setTextColor(context.getColor(R.color.green));
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "textView", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    public void addItem(String title) {
        strings.add(title);
        notifyDataSetChanged();
    }

    public void editItem(int index, String title) {
        if (index < strings.size()) {
            strings.set(index, title);
        } else {
            Toast.makeText(context, "No Item", Toast.LENGTH_SHORT).show();
        }
        notifyDataSetChanged();
    }

    public void deleteItem(int index) {
        if (index < strings.size()) {
            strings.remove(index);
        } else {
            Toast.makeText(context, "No Item", Toast.LENGTH_SHORT).show();
        }
        notifyDataSetChanged();
    }

}
