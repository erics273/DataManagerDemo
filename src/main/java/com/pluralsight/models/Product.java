package com.pluralsight.models;

public class Product
{
    private int productId;
    private String productName;
    private double unitPrice;

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

    // toString for easy printing
    @Override
    public String toString()
    {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
