/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotation.dao;

import com.quotation.pojos.Dealer;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PRITI JANA
 */
public class DealerDaoTest {
    
    public DealerDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of login method, of class DealerDao.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        String emailId = "priti@gmail.com";
        String password = "56788";
        Dealer expResult = null;
        Dealer result = DealerDao.login(emailId, password);
        assertNotNull(result);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of register method, of class DealerDao.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        String dealerUserName = "bingo12";
        String password = "b123425";
        String dealerFirstName = "bingo";
        String dealerLastName = "lays";
        String dealerAddress = "Shop";
        String dealerEmailId = "eat@gmail.com";
        String dealerContactInfo = "1010101";
        String zipcode = "292992";
        int expResult = 1;
        int result = DealerDao.register(dealerUserName, password, dealerFirstName, dealerLastName, dealerAddress, dealerEmailId, dealerContactInfo, zipcode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of report method, of class DealerDao.
     */
    @Test
    public void testReport() throws Exception {
        System.out.println("report");
        DealerDao instance = new DealerDao();
        List expResult = null;
        List result = instance.report();
         assertNotNull(result);
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addDealer method, of class DealerDao.
     */
    @Test
    public void testAddDealer() throws Exception {
        System.out.println("addDealer");
        int dealerId = 25;
        String dealerUserName = "house111";
        String password = "627621";
        String dealerFirstName = "classi1cal";
        String dealerLastName = "home1";
        String dealerAddress = "kolkata1";
        String dealerEmailId = "home@gmail1.com";
        String dealerContactInfo = "7887982212";
        String zipcode = "231982";
        int status = 1;
        int expResult = 1;
        int result = DealerDao.addDealer(dealerId, dealerUserName, password, dealerFirstName, dealerLastName, dealerAddress, dealerEmailId, dealerContactInfo, zipcode, status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteDealerDetails method, of class DealerDao.
     */
    @Test
    public void testDeleteDealerDetails() throws Exception {
        System.out.println("deleteDealerDetails");
        int dealerId = 1;
        DealerDao instance = new DealerDao();
        int expResult = 1;
        int result = instance.deleteDealerDetails(dealerId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
