package com.pluralsight.dao;

import com.pluralsight.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NorthwindDataManager {

    //create our BasicDataSource
    private BasicDataSource dataSource;

    //our constructor that does the sets up the BasicDataSource passed in
    public NorthwindDataManager(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> getAllProducts() {

        //create an array list to hold the products we will be returning
        List<Product> products = new ArrayList<>();

        //start our query for our prepared statement
        String sql = "SELECT ProductID " +
                " , ProductName " +
                " , UnitPrice " +
                "FROM products;";

        //try with resources to handle closing our resources properly
        try (
                //generate the connection from the datasource for this query
                Connection conn = dataSource.getConnection();
                //create our prepared statement
                PreparedStatement statement = conn.prepareStatement(sql);
                //execute our statement to get the results
                ResultSet results = statement.executeQuery(sql);
        ) {

            //loop over the results and create product objects and add the to the array list
            while (results.next()) {
                int id = results.getInt("ProductID");
                String name = results.getString("ProductName");
                double price = results.getDouble("UnitPrice");
                Product product = new Product(id, name, price);
                products.add(product);
            }

            //return the ArrayList of Products
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
