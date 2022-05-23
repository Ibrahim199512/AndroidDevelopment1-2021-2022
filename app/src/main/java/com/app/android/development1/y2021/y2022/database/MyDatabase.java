package com.app.android.development1.y2021.y2022.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.app.android.development1.y2021.y2022.models.Category;
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

    public static String categoryTable = "categoryTable";
    public static String categoryId = "categoryId";
    public static String categoryName = "categoryName";

    public static String bookTable = "bookTable";
    public static String bookId = "bookId";
    public static String bookTitle = "categoryName";
    public static String bookDescription = "bookDescription";
    public static String bookAuthor = "bookAuthor";

    public MyDatabase(@Nullable Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("Test", "onCreate");
        String sqlCategoryTable = "create table " + categoryTable
                + " (" + categoryId + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + categoryName + " TEXT NOT NULL" + " )";
        db.execSQL(sqlCategoryTable);

        String sqlProductTable = "create table " + productTable + " ("
                + productId + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + productName + " TEXT NOT NULL,"
                + productPrice + " REAL NOT NULL,"
                + shopName + " TEXT NOT NULL,"
                + productImage + " TEXT NOT NULL,"
                + categoryId + " INTEGER,"
                + " FOREIGN KEY (" + categoryId + ") " + "REFERENCES " + categoryTable
                + " (" + categoryId + ") )";
        db.execSQL(sqlProductTable);

        String sqlBookTable = "create table " + bookTable
                + " (" + bookId + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + bookTitle + " TEXT NOT NULL,"
                + bookAuthor + " TEXT NOT NULL,"
                + bookDescription + " TEXT NOT NULL"
                + " )";
        db.execSQL(sqlBookTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + productTable);
        db.execSQL("DROP TABLE IF EXISTS " + categoryTable);
        db.execSQL("DROP TABLE IF EXISTS " + bookTable);
        onCreate(db);
    }

    public boolean insertBook(String bookTitleString
            , String bookDescriptionString, String bookAuthorString) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(bookTitle, bookTitleString);
        values.put(bookDescription, bookDescriptionString);
        values.put(bookAuthor, bookAuthorString);
        Long id = db.insert(bookTable, null, values);
        db.close();
        if (id == -1) return false;
        else return true;
    }

    public void getAllBooks() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] project = {bookId, bookTitle, bookDescription, bookAuthor};
        Cursor cursor = db.query(bookTable, project, null
                , null, null, null, null);
        cursor.moveToFirst();
        try {
            int bookIdColumnIndex = cursor.getColumnIndex(bookId);
            int bookTitleColumnIndex = cursor.getColumnIndex(bookTitle);
            int bookDescriptionColumnIndex = cursor.getColumnIndex(bookDescription);
            int bookAuthorColumnIndex = cursor.getColumnIndex(bookAuthor);
            while (!cursor.isAfterLast()) {
                int temp1 = cursor.getInt(bookIdColumnIndex);
                String temp2 = cursor.getString(bookTitleColumnIndex);
                String temp3 = cursor.getString(bookDescriptionColumnIndex);
                String temp4 = cursor.getString(bookAuthorColumnIndex);
                Log.e("Reading", "id = " + temp1 + " " + "title " + temp2
                        + " Description " + temp3 + " Author " + temp4);
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
            db.close();
        }
    }

    public int editBook(int bookId, String bookAuthorString) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(bookAuthor, bookAuthorString);
        int rows = db.update(bookTable, values, "bookId = ?"
                , new String[]{String.valueOf(bookId)});
        db.close();
        return rows;
    }

    public int deleteBook(int bookIdNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] s = new String[]{bookIdNumber + ""};
        int rows = db.delete(bookTable, bookId+" = ? ", s);
        db.close();
//        if (rows != 0)
//            return true;
//        else
//            return false;
        return rows;
    }

    public boolean insertCategory(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(categoryName, name);
        Long id = db.insert(categoryTable, null, values);
        db.close();
        if (id == -1) return false;
        else return true;
    }

    public boolean insertProduct(String name, int catgoryId, double price
            , String shopNameString, String productImageString) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(productName, name);
//        values.put(productCatgory, catgory);
        values.put(productPrice, price);
        values.put(shopName, shopNameString);
        values.put(productImage, productImageString);
        values.put(categoryId, catgoryId);
        Long id = db.insert(productTable, null, values);
        db.close();
        if (id == -1)
            return false;
        else
            return true;
    }

    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> productArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] project = {categoryId, categoryName};
        Cursor cursor = db.query(categoryTable, project, null, null, null, null, null);
        cursor.moveToFirst();
        try {
            int productIdColumnIndex = cursor.getColumnIndex(categoryId);
            int productNameColumnIndex = cursor.getColumnIndex(categoryName);
            while (!cursor.isAfterLast()) {
                int temp1 = cursor.getInt(productIdColumnIndex);
                String temp2 = cursor.getString(productNameColumnIndex);
                Category category = new Category(temp1, temp2);
                productArrayList.add(category);
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
            db.close();
        }
        return productArrayList;
    }

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> productArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] project = {productId, categoryId, productName, productPrice, shopName, productImage};
        Cursor cursor = db.query(productTable, project, null, null, null, null, null);
        cursor.moveToFirst();
        try {
            int productIdColumnIndex = cursor.getColumnIndex(productId);
//            Log.e("productIdIndex", productIdColumnIndex + "");
            int productNameColumnIndex = cursor.getColumnIndex(productName);
            int productPriceColumnIndex = cursor.getColumnIndex(productPrice);
            int productCategoryIdColumnIndex = cursor.getColumnIndex(categoryId);
            int shopNameColumnIndex = cursor.getColumnIndex(shopName);
            int productImageColumnIndex = cursor.getColumnIndex(productImage);
            while (!cursor.isAfterLast()) {
                int temp1 = cursor.getInt(productIdColumnIndex);
                String temp2 = cursor.getString(productNameColumnIndex);
                double temp3 = cursor.getDouble(productPriceColumnIndex);
                int temp4 = cursor.getInt(productCategoryIdColumnIndex);
                String temp5 = cursor.getString(shopNameColumnIndex);
                String temp6 = cursor.getString(productImageColumnIndex);
                Product product = new Product(temp1, temp2, temp3, "", temp5, temp6, temp4);
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

    public int deleteCategory(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] s = new String[]{id + ""};
        int rows = db.delete(categoryTable, "categoryId = ? ", s);
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


    public int editCategory(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(categoryName, "new value");
        int rows = db.update(categoryTable, values, "categoryId = ?", new String[]{id});
        db.close();
        return rows;
    }

    public void getAllProductsAndCategories() {
        String query = "SELECT * FROM Product a"
                + " INNER JOIN categoryTable b "
                + "ON a.categoryId=b.categoryId ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        try {
            int productIdColumnIndex = cursor.getColumnIndex(productId);
            int productNameColumnIndex = cursor.getColumnIndex(productName);
            int productPriceColumnIndex = cursor.getColumnIndex(productPrice);
//            int productCatgoryColumnIndex = cursor.getColumnIndex(productCatgory);
            int shopNameColumnIndex = cursor.getColumnIndex(shopName);
            int productImageColumnIndex = cursor.getColumnIndex(productImage);
            int categoryIdColumnIndex = cursor.getColumnIndex(categoryId);
            int categoryNameColumnIndex = cursor.getColumnIndex(categoryName);
            while (!cursor.isAfterLast()) {
                int temp1 = cursor.getInt(productIdColumnIndex);
                String temp2 = cursor.getString(productNameColumnIndex);
                double temp3 = cursor.getDouble(productPriceColumnIndex);
//                String temp4 = cursor.getString(productCatgoryColumnIndex);
                String temp5 = cursor.getString(shopNameColumnIndex);
                String temp6 = cursor.getString(productImageColumnIndex);
                int temp7 = cursor.getInt(categoryIdColumnIndex);
                String temp8 = cursor.getString(categoryNameColumnIndex);

                Log.e("getProductId", temp1 + "");
                Log.e("getProductName", temp2 + "");
                Log.e("getProductCatgory", temp8 + "");
                Log.e("getProductPrice", temp3 + "");
                Log.e("getShopName", temp5 + "");
                Log.e("getProductImage", temp6 + "");
                Log.e("getCatgeoryId", temp7 + "");
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
            db.close();
        }
    }
}
