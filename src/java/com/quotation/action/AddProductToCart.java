/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotation.action;

import com.quotation.pojos.Product;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Lenovo
 */
public class AddProductToCart implements SessionAware {

    private int quantity;
    private int productId;

    private boolean noData;

    private SessionMap<String, Object> sessionMap;

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String AddToCart() {
        setNoData(false);

        System.out.println("Added product Id: " + getProductId());
        System.out.println("Added product qty: " + getQuantity());
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        if (session == null || session.getAttribute("cart") == null) {
            ArrayList cart = new ArrayList();
            Product product = new Product();
            product.setProductId(productId);
            product.setQty(quantity);
            cart.add(product);
            sessionMap.put("cart", cart);
        } else {
            ArrayList cart = (ArrayList) session.getAttribute("cart");
            Product product = new Product();
            product.setProductId(productId);
            product.setQty(quantity);
            cart.add(product);
            sessionMap.put("cart", cart);
        }
        ArrayList cart = (ArrayList) session.getAttribute("cart");
        System.out.println("Cart size: "+cart.size());
        return "ADDED";
    }

    /**
     * @return the noData
     */
    public boolean isNoData() {
        return noData;
    }

    /**
     * @param noData the noData to set
     */
    public void setNoData(boolean noData) {
        this.noData = noData;
    }

    /**
     * @return the sessionMap
     */
    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    /**
     * @param sessionMap the sessionMap to set
     */
    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }

}
