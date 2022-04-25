package com.app.android.development1.y2021.y2022.models;

public class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private String productCatgory;
    private String shopName;
    private String productImage;
    private int catgeoryId;

    public Product(int productId, String productName, double productPrice, String productCatgory, String shopName, String productImage, int catgeoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCatgory = productCatgory;
        this.shopName = shopName;
        this.productImage = productImage;
        this.catgeoryId = catgeoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCatgory() {
        return productCatgory;
    }

    public void setProductCatgory(String productCatgory) {
        this.productCatgory = productCatgory;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getCatgeoryId() {
        return catgeoryId;
    }

    public void setCatgeoryId(int catgeoryId) {
        this.catgeoryId = catgeoryId;
    }
}
