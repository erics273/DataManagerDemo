package com.pluralsight.models;

public class Product
{
    private int productId;
    private String productName;
    private double unitPrice;
    private int categoryID;
    private String categoryName;

    // Constructor
    public Product(int productId, String productName, double unitPrice, int categoryID, String categoryName)
    {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    // Constructor
    public Product(int productId, String productName, double unitPrice)
    {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
    }

    // Getters and Setters
    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public double getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

}
