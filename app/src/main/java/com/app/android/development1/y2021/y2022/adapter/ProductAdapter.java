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
import com.app.android.development1.y2021.y2022.models.Product;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {
    ArrayList<Product> list;
    Context context;

    public ProductAdapter(@NonNull Context context, ArrayList<Product> list) {
        super(context, 0, list);
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.product_item, parent, false);
        }

        TextView name = convertView.findViewById(R.id.name);
        TextView price = convertView.findViewById(R.id.price);
        TextView shopName = convertView.findViewById(R.id.shop_name);
        name.setText(list.get(position).getProductName() + " id = "
                + list.get(position).getProductId());
        price.setText(list.get(position).getProductPrice() + "");
        shopName.setText(list.get(position).getShopName());

//        if (position % 2 == 0) {
//            //even
//            textView.setTextColor(context.getColor(R.color.blue));
//        } else {
//            //odd
//            textView.setTextColor(context.getColor(R.color.green));
//        }
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "" + list.get(position).getProductName(), Toast.LENGTH_SHORT).show();
            }
        });
        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "" + list.get(position).getProductPrice(), Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

//    public void addItem(String title) {
//        strings.add(title);
//        notifyDataSetChanged();
//    }
//
//    public void editItem(int index, String title) {
//        if (index < strings.size()) {
//            strings.set(index, title);
//        } else {
//            Toast.makeText(context, "No Item", Toast.LENGTH_SHORT).show();
//        }
//        notifyDataSetChanged();
//    }
//
//    public void deleteItem(int index) {
//        if (index < strings.size()) {
//            strings.remove(index);
//        } else {
//            Toast.makeText(context, "No Item", Toast.LENGTH_SHORT).show();
//        }
//        notifyDataSetChanged();
//    }

}
