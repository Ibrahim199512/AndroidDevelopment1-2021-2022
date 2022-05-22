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
import com.app.android.development1.y2021.y2022.models.Category;
import com.app.android.development1.y2021.y2022.models.Product;

import java.util.ArrayList;

public class SQLiteExmaple1Activity extends AppCompatActivity {

    Button add, read, edit, delete, addCategory, readCategory, editCategory, deleteCategory,readAll;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_q_lite_exmaple1);
        add = findViewById(R.id.add);
        read = findViewById(R.id.read);
        edit = findViewById(R.id.edit);
        delete = findViewById(R.id.delete);
        addCategory = findViewById(R.id.add_category);
        readCategory = findViewById(R.id.read_category);
        editCategory = findViewById(R.id.edit_category);
        deleteCategory = findViewById(R.id.delete_category);
        readAll = findViewById(R.id.read_all);

        MyDatabase myDatabase = new MyDatabase(context);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b = myDatabase.insertProduct("name2", 1
                        , 200.5, "shop2", "image2");

                Log.e("insertProduct", b + "");
                Toast.makeText(context, "insertProduct = " + b, Toast.LENGTH_SHORT).show();
            }
        });
        addCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b = myDatabase.insertCategory("Category2");

                Log.e("insertCategory", b + "");
                Toast.makeText(context, "insertCategory = " + b, Toast.LENGTH_SHORT).show();
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
                    Log.e("getCatgeoryId", temp.getCatgeoryId() + "");
                }
            }
        });
        readCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Category> categoryArrayList = myDatabase.getAllCategories();
                for (int i = 0; i < categoryArrayList.size(); i++) {
                    Log.e("i = ", i + "");
                    Category temp = categoryArrayList.get(i);
                    Log.e("getId", temp.getId() + "");
                    Log.e("getName", temp.getName() + "");
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
        editCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rows = myDatabase.editCategory(2 + "");
                Log.e("editCategory", rows + "");
                Toast.makeText(context, "editCategory = " + rows, Toast.LENGTH_SHORT).show();
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

        deleteCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rows = myDatabase.deleteCategory(1);
                Log.e("deleteCategory", rows + "");
                Toast.makeText(context, "deleteCategory = " + rows, Toast.LENGTH_SHORT).show();
            }
        });
        readAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabase.getAllProductsAndCategories();
            }
        });
    }
}