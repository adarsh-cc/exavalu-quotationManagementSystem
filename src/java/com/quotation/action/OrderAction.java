/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotation.action;

import com.quotation.dao.OrderDao;
import com.quotation.pojos.Order;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderAction {
    
    private List<Order> orderList = null;
    private boolean noData = false;
    OrderDao b = new OrderDao();
    
    public String showOrder() throws Exception {
        try {
            setOrderList(new ArrayList<>());
            setOrderList(b.report());

            if (!orderList.isEmpty()) {
                setNoData(false);
                System.out.println("Orders retrieve = " + getOrderList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "REPORT";
    }
    
    

    /**
     * @return the orderList
     */
    public List<Order> getOrderList() {
        return orderList;
    }

    /**
     * @param orderList the orderList to set
     */
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
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
    
}
