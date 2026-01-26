package com.product.dao;

import com.product.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/shop_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Longbao.123";

    private static final String SELECT_ALL = "SELECT * FROM products";
    private static final String SELECT_BY_ID = "SELECT * FROM products WHERE id = ?";
    private static final String INSERT = "INSERT INTO products (name, price, url_image) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE products SET name = ?, price = ?, url_image = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM products WHERE id = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Product> selectAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String urlImage = rs.getString("url_image");
                products.add(new Product(id, name, price, urlImage));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product selectProduct(int id) {
        Product product = null;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String urlImage = rs.getString("url_image");
                product = new Product(id, name, price, urlImage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public void insertProduct(Product product) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT)) {
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getUrlImage());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getUrlImage());
            ps.setInt(4, product.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}