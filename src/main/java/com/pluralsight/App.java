package com.pluralsight;

import com.pluralsight.dao.NorthwindDataManager;
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
        // Create the NorthwindDataManager
        NorthwindDataManager dataManager = new NorthwindDataManager(dataSource);

        // Interact with the database
        List<Product> products = dataManager.getAllProducts();
        // display products
        products.forEach(System.out::println);

        //close the datasource
        try {
            dataSource.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
