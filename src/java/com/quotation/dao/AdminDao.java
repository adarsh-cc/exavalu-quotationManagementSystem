package com.quotation.dao;

import com.quotation.core.ConnectionManager;
import com.quotation.pojos.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
    
    public static Admin login(String userName , String password) throws SQLException {
        Admin admin =null;
        ResultSet rs = null;
        Connection con = null;
        try
        {
        con = ConnectionManager.getConnection();
        String sql = "SELECT admin.userID,\n" +
                    "admin.userName,\n" +
                    "admin.password,\n" +
                    "admin.firstName,\n" +
                    "admin.lastName,\n" +
                    "admin.emailId,\n" +
                    "admin.phoneNumber\n" +
                    "FROM quotationmanagementsystem.admin where userName = ? and password = ?";    
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1 ,userName);
        ps.setString(2 ,password);
        rs = ps.executeQuery();
        while(rs.next())
        {
            admin = new Admin();
            admin.setUserID(rs.getInt("userID"));
            admin.setUserName(rs.getString("userName"));
            admin.setFirstName(rs.getString("firstName"));
            admin.setLastName(rs.getString("lastName"));
            admin.setEmailId(rs.getString("emailId"));
            admin.setPassword(rs.getString("password"));
            admin.setPhoneNumber(rs.getString("phoneNumber"));
        }
        } catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally {
            if(con!=null)
                con.close();
            }
        return admin;
    }
    public List report() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Admin> adminList = new ArrayList<>();
        try {
            String sql = "SELECT admin.userID,\n" +
                        "    admin.userName,\n" +
                        "    admin.password,\n" +
                        "    admin.firstName,\n" +
                        "    admin.lastName,\n" +
                        "    admin.emailId,\n" +
                        "    admin.phoneNumber\n" +
                        "FROM quotationmanagementsystem.admin";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                Admin admin = new Admin();
                admin.setUserID(rs.getInt("userID"));
                admin.setUserName(rs.getString("userName"));
                admin.setPassword(rs.getString("password"));
                admin.setFirstName(rs.getString("firstName"));
                admin.setLastName(rs.getString("lastName"));
                admin.setEmailId(rs.getString("emailId"));
                admin.setPhoneNumber(rs.getString("phoneNumber"));

                adminList.add(admin);
            }
            return adminList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
   
}
}
