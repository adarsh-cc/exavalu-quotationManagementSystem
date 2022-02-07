/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotation.dao;

import com.quotation.pojos.Product;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PRITI JANA
 */
public class ProductDaoTest {
    
    public ProductDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getAllProducts method, of class ProductDao.
     */
    @Test
    public void testGetAllProducts() throws Exception {
        System.out.println("getAllProducts");
        String category = "";
        ArrayList expResult = null;
        ArrayList result = ProductDao.getAllProducts(category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductCategory method, of class ProductDao.
     */
    @Test
    public void testGetProductCategory() throws Exception {
        System.out.println("getProductCategory");
        ArrayList expResult = null;
        ArrayList result = ProductDao.getProductCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProduct method, of class ProductDao.
     */
    @Test
    public void testAddProduct() throws Exception {
        System.out.println("addProduct");
        int productId = 0;
        String productName = "";
        Double productPrice = null;
        Double discountRate = null;
        String productMake = "";
        int productAvailability = 0;
        String category = "";
        int expResult = 0;
        int result = ProductDao.addProduct(productId, productName, productPrice, discountRate, productMake, productAvailability, category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of report method, of class ProductDao.
     */
    @Test
    public void testReport() throws Exception {
        System.out.println("report");
        ProductDao instance = new ProductDao();
        List expResult = null;
        List result = instance.report();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fetchProductDetails method, of class ProductDao.
     */
    @Test
    public void testFetchProductDetails() throws Exception {
        System.out.println("fetchProductDetails");
        int productId = 0;
        ProductDao instance = new ProductDao();
        Product expResult = null;
        Product result = instance.fetchProductDetails(productId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProductDetails method, of class ProductDao.
     */
    @Test
    public void testUpdateProductDetails() throws Exception {
        System.out.println("updateProductDetails");
        int productId = 0;
        String productName = "";
        double productPrice = 0.0;
        double discountRate = 0.0;
        String productMake = "";
        int productAvailability = 0;
        String category = "";
        ProductDao instance = new ProductDao();
        int expResult = 0;
        int result = instance.updateProductDetails(productId, productName, productPrice, discountRate, productMake, productAvailability, category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProductDetails method, of class ProductDao.
     */
    @Test
    public void testDeleteProductDetails() throws Exception {
        System.out.println("deleteProductDetails");
        int productId = 0;
        ProductDao instance = new ProductDao();
        int expResult = 0;
        int result = instance.deleteProductDetails(productId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProduct method, of class ProductDao.
     */
    @Test
    public void testGetProduct() throws Exception {
        System.out.println("getProduct");
        int productId = 0;
        Product expResult = null;
        Product result = ProductDao.getProduct(productId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
