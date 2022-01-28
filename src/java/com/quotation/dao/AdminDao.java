package com.quotation.dao;

import com.quotation.core.ConnectionManager;
import com.quotation.pojos.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    
    public static Admin login(String userName , String password) throws SQLException {
        Admin admin = new Admin();
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
                    "FROM quotationmanagementsystems.admin where userName = ? and password = ?";    
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
   
}
