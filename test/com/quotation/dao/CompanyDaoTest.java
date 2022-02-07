/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotation.dao;

import com.quotation.pojos.Company;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PRITI JANA
 */
public class CompanyDaoTest {
    
    public CompanyDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of report method, of class CompanyDao.
     */
    @Test
    public void testReport() throws Exception {
        System.out.println("report");
        CompanyDao instance = new CompanyDao();
        List expResult = null;
        List result = instance.report();
        assertNotNull(result);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of addCompany method, of class CompanyDao.
     */
//    @Test
//    public void testAddCompany() throws Exception {
//        System.out.println("addCompany");
//        String companyName = "M2d";
//        String estblYear = "2022";
//        String contactInfo = "3773-3883";
//        String emailId = "nehi@gmail.com";
//        String companyGrades = "Weekly";
//        String zipcode = "700016";
//        String companyAddress = "Kolkata, Salt Lake, Sector 5";
//        int expResult = 1;
//        int result = CompanyDao.addCompany(companyName, estblYear, contactInfo, emailId, companyGrades, zipcode, companyAddress);
//        assertEquals(expResult, result);
//        
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    //}

    /**
     * Test of fetchCompanyDetails method, of class CompanyDao.
     */
    @Test
    public void testFetchCompanyDetails() throws Exception {
        System.out.println("fetchCompanyDetails");
        String companyName = "";
        CompanyDao instance = new CompanyDao();
        Company expResult = null;
        Company result = instance.fetchCompanyDetails(companyName);
         assertNotNull(result);
      //  assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of updateCompanyDetails method, of class CompanyDao.
     */
    @Test
    public void testUpdateCompanyDetails() throws Exception {
        System.out.println("updateCompanyDetails");
        String companyName = "Amazon";
        String estblYear = "1900";
        String emailId = "nehitha@gmail.com";
        String companyGrades = "Yearly";
        String contactInfo = "7633-222";
        String zipcode = "700014";
        String companyAddress = "chennai,tamilnadu";
        CompanyDao instance = new CompanyDao();
        int expResult = 1;
        int result = instance.updateCompanyDetails(companyName, estblYear, emailId, companyGrades, contactInfo, zipcode, companyAddress);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCompanyDetails method, of class CompanyDao.
     */
    @Test
    public void testDeleteCompanyDetails() throws Exception {
        System.out.println("deleteCompanyDetails");
        String companyName = "Amazon";
        CompanyDao instance = new CompanyDao();
        int expResult = 1;
        int result = instance.deleteCompanyDetails(companyName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
