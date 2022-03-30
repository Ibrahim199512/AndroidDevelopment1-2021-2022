package com.app.android.development1.y2021.y2022.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.android.development1.y2021.y2022.R;
import com.app.android.development1.y2021.y2022.database.MyDatabase;
import com.app.android.development1.y2021.y2022.models.Product;

import java.util.ArrayList;

public class SQLiteExmaple1Activity extends AppCompatActivity {

    Button add, read, edit, delete;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_q_lite_exmaple1);
        add = findViewById(R.id.add);
        read = findViewById(R.id.read);
        edit = findViewById(R.id.edit);
        delete = findViewById(R.id.delete);

        MyDatabase myDatabase = new MyDatabase(context);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b = myDatabase.insertProduct("name2", "catgory2"
                        , 200.5, "shop2", "image2");

                Log.e("insertProduct", b + "");
                Toast.makeText(context, "insertProduct = " + b, Toast.LENGTH_SHORT).show();
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                }
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rows = myDatabase.editProduct(2 + "");
                Log.e("editProductRows", rows + "");
                Toast.makeText(context, "editProductRows = " + rows, Toast.LENGTH_SHORT).show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rows = myDatabase.deleteProduct(1);
                Log.e("deleteProductRows", rows + "");
                Toast.makeText(context, "deleteProductRows = " + rows, Toast.LENGTH_SHORT).show();
            }
        });
    }
}