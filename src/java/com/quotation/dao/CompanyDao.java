/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotation.dao;

import com.quotation.core.ConnectionManager;
import com.quotation.pojos.Company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao {
    
    public List report() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Company> companyList = new ArrayList<>();
        try {
            String sql = "SELECT company.companyName,\n"
                    + "    company.companyAddress,\n"
                    + "    company.estblYear,\n"
                    + "    company.contactInfo,\n"
                    + "    company.emailId,\n"
                    + "    company.companyGrades,\n"
                    + "    company.zipcode\n"
                    + "FROM quotationmanagementsystem.company";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                Company company = new Company();
                company.setCompanyName(rs.getString("companyName"));
                company.setCompanyAddress(rs.getString("companyAddress"));
                company.setEstblYear(rs.getString("estblYear"));
                company.setContactInfo(rs.getString("contactInfo"));
                company.setEmailId(rs.getString("emailId"));
                company.setCompanyGrades(rs.getString("companyGrades"));
                company.setZipcode(rs.getString("zipcode"));

                companyList.add(company);
            }
            return companyList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
   public static int addCompany(String companyName,String estblYear,String contactInfo, String emailId,
            String companyGrades,String zipcode, String companyAddress) throws Exception {
        int i = 0;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO quotationmanagementsystem.company\n" +
                            "(companyName,\n" +
                            "companyAddress,\n" +
                            "estblYear,\n" +
                            "contactInfo,\n" +
                            "emailId,\n" +
                            "companyGrades,\n" +
                            "zipcode, \n" +
                            "status)\n" +
                            "VALUES\n" +
                            "(?,?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, companyName);
            ps.setString(2, companyAddress);
            ps.setString(3, estblYear);
            ps.setString(4, contactInfo);
            ps.setString(5, emailId);
            ps.setString(6, companyGrades);
            ps.setString(7,zipcode);
            ps.setInt(8,1);
            System.out.println("SQL for insert="+ps);
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
   public Company fetchCompanyDetails(String companyName) throws SQLException {
        Company company = new Company();
        ResultSet rs = null;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM company WHERE companyName=?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("companyName = " + companyName);
            ps.setString(1, companyName);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {

                company.setCompanyName(rs.getString("companyName"));
                company.setEstblYear(rs.getString("estblYear"));
                 company.setCompanyAddress(rs.getString("companyAddress"));
                company.setEmailId(rs.getString("emailId"));
                company.setCompanyGrades(rs.getString("companyGrades"));
                company.setContactInfo(rs.getString("contactInfo"));
                company.setZipcode(rs.getString("zipcode"));

            }
            return company;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public int updateCompanyDetails(String companyName, String estblYear, String emailId,String companyGrades, 
             String contactInfo, String zipcode, String companyAddress ) throws SQLException {
        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE company SET estblYear =?,emailId = ?,companyGrades=?,contactInfo = ?, zipcode=? ,companyAddress=? WHERE companyName =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, estblYear);
            ps.setString(2, emailId);
            ps.setString(3, companyGrades);
            ps.setString(4, contactInfo);
            ps.setString(5, zipcode);
            ps.setString(6,companyAddress);
             ps.setString(7,companyName);
            
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

        public int deleteCompanyDetails(String companyName) throws SQLException, Exception {
        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE company SET status = 0 WHERE companyName = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, companyName);
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
    
}
