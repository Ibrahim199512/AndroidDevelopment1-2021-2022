package com.app.android.development1.y2021.y2022.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.app.android.development1.y2021.y2022.R;
import com.app.android.development1.y2021.y2022.adapter.CustomAdapter;
import com.app.android.development1.y2021.y2022.adapter.ProductAdapter;
import com.app.android.development1.y2021.y2022.database.MyDatabase;
import com.app.android.development1.y2021.y2022.models.Product;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        listView = findViewById(R.id.list_view);

        MyDatabase myDatabase = new MyDatabase(this);

        ArrayList<Product> productArrayList = myDatabase.getAllProduct();
        for (int i = 0; i < productArrayList.size(); i++) {
            Log.e("i = ", i + "");
            Product temp = productArrayList.get(i);
            Log.e("getProductId", temp.getProductId() + "");
            Log.e("getProductName", temp.getProductName() + "");
            Log.e("getProductCatgory", temp.getProductCatgory() + "");
            Log.e("getProductPrice", temp.getProductPrice() + "");
            Log.e("getShopName", temp.getShopName() + "");
            Log.e("getProductImage", temp.getProductImage() + "");
            Log.e("getCatgeoryId", temp.getCatgeoryId() + "");
        }

        ProductAdapter productAdapter = new ProductAdapter(
                this, productArrayList);
        listView.setAdapter(productAdapter);
    }
}