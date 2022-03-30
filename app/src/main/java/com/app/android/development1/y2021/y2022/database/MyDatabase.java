package com.app.android.development1.y2021.y2022.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.app.android.development1.y2021.y2022.models.Product;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    public static int databaseVersion = 1;
    public static String databaseName = "myDatabase";

    public static String productTable = "Product";
    public static String productId = "productId";
    public static String productName = "productName";
    public static String productPrice = "productPrice";
    public static String productCatgory = "productCatgory";
    public static String shopName = "shopName";
    public static String productImage = "productImage";

    public MyDatabase(@Nullable Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlProductTable = "create table "
                + productTable + " ("
                + productId + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + productName + " TEXT NOT NULL,"
                + productPrice + " REAL NOT NULL,"
                + productCatgory + " TEXT NOT NULL,"
                + shopName + " TEXT NOT NULL,"
                + productImage + " TEXT NOT NULL" + " )";
        db.execSQL(sqlProductTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + productTable);
        onCreate(db);
    }

    public boolean insertProduct(String name, String catgory, double price
            , String shopNameString, String productImageString) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(productName, name);
        values.put(productCatgory, catgory);
        values.put(productPrice, price);
        values.put(shopName, shopNameString);
        values.put(productImage, productImageString);
        Long id = db.insert(productTable, null, values);
        db.close();
        if (id == -1)
            return false;
        else
            return true;
    }

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> productArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] project = {productId, productName, productPrice, productCatgory, shopName, productImage};
        Cursor cursor = db.query(productTable, project, null, null, null, null, null);
        cursor.moveToFirst();
        try {
            int productIdColumnIndex = cursor.getColumnIndex(productId);
//            Log.e("productIdIndex", productIdColumnIndex + "");
            int productNameColumnIndex = cursor.getColumnIndex(productName);
            int productPriceColumnIndex = cursor.getColumnIndex(productPrice);
            int productCatgoryColumnIndex = cursor.getColumnIndex(productCatgory);
            int shopNameColumnIndex = cursor.getColumnIndex(shopName);
            int productImageColumnIndex = cursor.getColumnIndex(productImage);
            while (!cursor.isAfterLast()) {
                int temp1 = cursor.getInt(productIdColumnIndex);
                String temp2 = cursor.getString(productNameColumnIndex);
                double temp3 = cursor.getDouble(productPriceColumnIndex);
                String temp4 = cursor.getString(productCatgoryColumnIndex);
                String temp5 = cursor.getString(shopNameColumnIndex);
                String temp6 = cursor.getString(productImageColumnIndex);
                Product product = new Product(temp1, temp2, temp3, temp4, temp5, temp6);
                productArrayList.add(product);
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
            db.close();
        }
        return productArrayList;
    }

    public int deleteProduct(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] s = new String[]{id + ""};
        int rows = db.delete(productTable, "productId = ? ", s);
        db.close();
//        if (rows != 0)
//            return true;
//        else
//            return false;
        return rows;
    }

    public int editProduct(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(productName, "new value");
        values.put(productCatgory, "new value Catgory");
        int rows = db.update(productTable, values, "productId = ?", new String[]{id});
        db.close();
        return rows;
    }
}
