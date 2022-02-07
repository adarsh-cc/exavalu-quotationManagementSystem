/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotation.dao;

import com.quotation.core.ConnectionManager;
import com.quotation.pojos.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public static ArrayList getAllProducts(String category) throws SQLException {
        Product product = null;
        ResultSet rs = null;
        Connection con = null;
        ArrayList pro = new ArrayList();
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT product.productId,\n"
                    + "    product.productName,\n"
                    + "    product.productPrice,\n"
                    + "    product.productMake,\n"
                    + "    product.productAvailability,\n"
                    + "    product.category\n"
                    + "FROM quotationmanagementsystem.product where category=? and status=1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category);
            rs = ps.executeQuery();
            while (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductMake(rs.getString("productMake"));
                product.setProductPrice(rs.getDouble("productPrice"));
                product.setProductAvailability(rs.getInt("productAvailability"));
                product.setCategory(rs.getString("category"));
                pro.add(product);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

        return pro;
    }

    public static ArrayList getProductCategory() throws SQLException {
        Product product = null;
        ResultSet rs = null;
        Connection con = null;
        ArrayList pro = new ArrayList();
        try {

            con = ConnectionManager.getConnection();
            String sql = "SELECT product.category\n"
                    + "FROM quotationmanagementsystem.product";
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                product = new Product();
                product.setCategory(rs.getString("category"));
                pro.add(product);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return pro;
    }

    public static int addProduct(String productName, Double productPrice, Double discountRate, String productMake,
            int productAvailability, String category) throws Exception {
        int i = 0;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO quotationmanagementsystem.product\n"
                    + "(productName,\n"
                    + "productPrice,\n"
                    + "productMake,\n"
                    + "productAvailability,\n"
                    + "category,\n"
                    + "status,\n"
                    + "discountRate)\n"
                    + "VALUES\n"
                    + "(?,?,?,?,?,?,?)";
//            String sql = "INSERT INTO quotationmanagementsystem.product\n"
//                    + "(productId,\n"
//                    + "productName,\n"
//                    + "productPrice,\n"
//                    + "discountRate, \n"
//                    + "productMake,\n"
//                    + "productAvailability,\n"
//                    + "category, \n"
//                    + "status)\n"
//                    + "VALUES\n"
//                    + "(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
           // ps.setInt(1, productId);
            ps.setString(1, productName);
            ps.setDouble(2, productPrice);
            ps.setString(3, productMake);
            ps.setInt(4, productAvailability);
            ps.setString(5, category);
            ps.setInt(6, 1);
            ps.setDouble(7, discountRate);

            System.out.println("SQL for insert=" + ps);
            i = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (con != null) {
                con.close();
            }
        }
        return i;
    }

    public List report() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Product> productList = new ArrayList<>();
        try {
            String sql = "SELECT product.productId,\n"
                    + "    product.productName,\n"
                    + "    product.productPrice,\n"
                    + "    product.productMake,\n"
                    + "    product.discountRate,\n"
                    + "    product.productAvailability,\n"
                    + "    product.category\n"
                    + "FROM quotationmanagementsystem.product where status=1";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductMake(rs.getString("productMake"));
                product.setProductPrice(rs.getDouble("productPrice"));
                product.setDiscountRate(rs.getDouble("discountRate"));
                product.setProductAvailability(rs.getInt("productAvailability"));
                product.setCategory(rs.getString("category"));

                productList.add(product);
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public Product fetchProductDetails(int productId) throws SQLException {
        Product product = new Product();
        ResultSet rs = null;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM product WHERE productId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("productId = " + productId);
            ps.setInt(1, productId);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {

                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductPrice(rs.getDouble("productPrice"));
                product.setDiscountRate(rs.getDouble("discountRate"));
                product.setProductMake(rs.getString("productMake"));
                product.setProductAvailability(rs.getInt("productAvailability"));
                product.setCategory(rs.getString("category"));

            }
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public int updateProductDetails(int productId, String productName, double productPrice, double discountRate, String productMake,
            int productAvailability, String category) throws SQLException {
        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE product SET productName =?,productPrice = ?,discountRate=?,productMake=?,productAvailability = ?, category=? WHERE productId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, productName);
            ps.setDouble(2, productPrice);
            ps.setDouble(3, discountRate);
            ps.setString(4, productMake);
            ps.setInt(5, productAvailability);
            ps.setString(6, category);

            ps.setInt(7, productId);
            System.out.println("Select SQL = " + ps);
            i = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return i;
    }

    public int deleteProductDetails(int productId) throws SQLException, Exception {
        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE product SET status = 0 WHERE productId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productId);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public static Product getProduct(int productId) throws SQLException {
        Product product = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT product.productId,\n"
                    + "    product.productName,\n"
                    + "    product.productPrice,\n"
                    + "    product.productMake,\n"
                    + "    product.productAvailability,\n"
                    + "    product.category,\n"
                    + "    product.discountRate\n"
                    + "FROM quotationmanagementsystem.product where productId=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductMake(rs.getString("productMake"));
                product.setProductPrice(rs.getDouble("productPrice"));
                product.setCategory(rs.getString("category"));
                product.setDiscountRate(rs.getDouble("discountRate"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return product;
    }
}
