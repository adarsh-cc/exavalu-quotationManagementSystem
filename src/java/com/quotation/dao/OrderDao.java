/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotation.dao;

import com.quotation.core.ConnectionManager;
import com.quotation.pojos.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    public List report() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Order> orderList = new ArrayList<>();
        try {
            String sql = "SELECT order.orderId,\n"
                    + "    order.orderDate,\n"
                    + "    order.orderValue,\n"
                    + "    order.category,\n"
                    + "    order.dealerId,\n"
                    + "    order.taxAmount,\n"
                    + "    order.destinationAddress\n"
                    + "FROM quotationmanagementsystem.order;";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                Order order = new Order();
                order.setOrderId(rs.getInt("orderId"));
                LocalDate localDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("orderDate")));
                order.setOrderDate(localDate);
                order.setOrderValue(rs.getDouble("orderValue"));
                order.setCategory(rs.getString("category"));
                order.setDealerId(rs.getInt("dealerId"));
                order.setTaxAmount(rs.getDouble("taxAmount"));
                order.setDestinationAddress(rs.getString("destinationAddress"));

                orderList.add(order);
            }
            return orderList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public static int saveOrder(Order order) throws SQLException {
        ResultSet rs = null;
        Connection con = null;
        int i = 0;
        Date date = java.sql.Date.valueOf(order.getOrderDate());
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO quotationmanagementsystem.order\n"
                    + "(\n"
                    + "orderDate,\n"
                    + "orderValue,\n"
                    + "category,\n"
                    + "dealerId,\n"
                    + "taxAmount,\n"
                    + "destinationAddress)\n"
                    + "VALUES\n"
                    + "(?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, date);
            ps.setDouble(2, order.getOrderValue());
            ps.setString(3, order.getCategory());
            ps.setInt(4, order.getDealerId());
            ps.setDouble(5, order.getTaxAmount());
            ps.setString(6, order.getDestinationAddress());
            i = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }

        return i;
    }

}
