/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotation.dao;

import com.quotation.core.ConnectionManager;
import com.quotation.pojos.Dealer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DealerDao {
    public static Dealer login(String emailId, String password) throws SQLException {
        System.out.println("Dealer password: " + password);
        System.out.println("Dealer email: " + emailId);
        Dealer dealer = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT dealer.dealerId,\n"
                    + "    dealer.dealerUserName,\n"
                    + "    dealer.password,\n"
                    + "    dealer.dealerFirstName,\n"
                    + "    dealer.dealerLastName,\n"
                    + "    dealer.dealerAddress,\n"
                    + "    dealer.dealerEmailId,\n"
                    + "    dealer.dealerContactInfo,\n"
                    + "    dealer.zipcode\n"
                    + "FROM quotationmanagementsystem.dealer where dealerEmailId=? and password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, emailId);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                dealer = new Dealer();
                dealer.setDealerId(rs.getInt("dealerId"));
                dealer.setDealerUserName(rs.getString("dealerUserName"));
                dealer.setPassword(rs.getString("password"));
                dealer.setDealerFirstName(rs.getString("dealerFirstName"));
                dealer.setDealerLastName(rs.getString("dealerLastName"));
                dealer.setDealerAddress(rs.getString("dealerAddress"));
                dealer.setDealerEmailId(rs.getString("dealerEmailId"));
                dealer.setDealerContactInfo(rs.getString("dealerContactInfo"));
            }
        } catch (Exception ex) {
            System.out.println("Error :" + ex);
        } finally {
            if (con != null) {
                con.close();
            }
        }

        return dealer;
    }

    public static int register(String dealerUserName, String password, String dealerFirstName, String dealerLastName,
            String dealerAddress, String dealerEmailId, String dealerContactInfo, String zipcode) {

        ResultSet rs = null;
        Connection con = null;
        int i = 0;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO quotationmanagementsystem.dealer\n"
                    + "(dealerUserName,\n"
                    + "password,\n"
                    + "dealerFirstName,\n"
                    + "dealerLastName,\n"
                    + "dealerAddress,\n"
                    + "dealerEmailId,\n"
                    + "dealerContactInfo,\n"
                    + "zipcode)\n"
                    + "VALUES\n"
                    + "(?,?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dealerUserName);
            ps.setString(2, password);
            ps.setString(3, dealerFirstName);
            ps.setString(4, dealerLastName);
            ps.setString(5, dealerAddress);
            ps.setString(6, dealerEmailId);
            ps.setString(7, dealerContactInfo);
            ps.setString(8, zipcode);
            i = ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return i;
    }
}
    

