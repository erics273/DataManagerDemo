package com.pluralsight;

import com.pluralsight.dao.ProductDao;
import com.pluralsight.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) {

        //did the user pass in the right number of arguments at runtime
        if (args.length != 2) {
            System.out.println("Application needs two arguments to run: <username> <password>");
            System.exit(1);
        }

        // Get the username and password
        String username = args[0];
        String password = args[1];

        // Create the datasource
        BasicDataSource dataSource = new BasicDataSource();
        // Configure the datasource
        dataSource.setUrl("jdbc:mysql://localhost:3306/Northwind");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        // Create the ProductDataManager

        //fire up the thing responsible for dealing with product data
        ProductDao dataManager = new ProductDao(dataSource);

        System.out.println("-----------Attempt to update products---------");

        //pause the app for a few seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        dataManager.updateAProduct();

        //pause the app for a few seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-----------Attempt to add a product but get keys created---------");

        //pause the app for a few seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        dataManager.addProductButReturnKeys();

        //pause the app for a few seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-----------Attempt to add a product---------");

        //pause the app for a few seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        dataManager.addProduct();

        //pause the app for a few seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        dataManager.deleteProducts();


        System.out.println("-----------Get ALL Products---------");

        //pause the app for a few seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Interact with the database
        List<Product> products = dataManager.getAllProducts();
        // display products

        for (Product product : products)
        {
            System.out.println("ID: " + product.getProductId());
            System.out.println("Name: " + product.getProductName());
            System.out.println("Price: $" + product.getUnitPrice());
            System.out.println("~~~~~~~~~~~~~~"); // blank line between products
        }

        System.out.println("-----------Get Products By Category---------");

        //pause the app for a few seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Interact with the database
        List<Product> productsByCat = dataManager.getProductsByCategoryId(1);
        // display products
        for (Product product : productsByCat)
        {
            System.out.println("ID: " + product.getProductId());
            System.out.println("Name: " + product.getProductName());
            System.out.println("Price: $" + product.getUnitPrice());
            System.out.println("CategoryID: " + product.getCategoryID());
            System.out.println("CategoryName: " + product.getCategoryName());
            System.out.println("~~~~~~~~~~~~~~"); // blank line between products
        }

        //close the datasource
        try {
            dataSource.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
