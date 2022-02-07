/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotation.dao;

import com.quotation.pojos.Admin;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PRITI JANA
 */
public class AdminDaoTest {
    
    public AdminDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of login method, of class AdminDao.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        String userName = "pravat05";
        String password = "12345";
        Admin expResult = null;
        Admin result = AdminDao.login(userName, password);
        assertNotNull(result);
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of report method, of class AdminDao.
     */
    @Test
    public void testReport() throws Exception {
        System.out.println("report");
        AdminDao instance = new AdminDao();
        List expResult = null;
        List result = instance.report();
        assertNotNull(result);
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
