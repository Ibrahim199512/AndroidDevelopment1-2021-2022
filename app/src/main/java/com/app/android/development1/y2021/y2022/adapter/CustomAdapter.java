package com.app.android.development1.y2021.y2022.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.app.android.development1.y2021.y2022.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {
    ArrayList<String> strings;

    public CustomAdapter(@NonNull Context context, ArrayList<String> strings) {
        super(context, 0, strings);
        this.strings = strings;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.listview_item, parent, false);
        }

        TextView numbersImage = convertView.findViewById(R.id.text);
        numbersImage.setText(strings.get(position) + " position = " + position);
        return convertView;
    }
}
