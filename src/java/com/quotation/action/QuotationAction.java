/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotation.action;

import com.quotation.dao.OrderDao;
import com.quotation.dao.ProductDao;
import com.quotation.dao.QuotationDao;
import com.quotation.pojos.Dealer;
import com.quotation.pojos.Order;
import com.quotation.pojos.Product;
import com.quotation.pojos.Quotation;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.time.format.DateTimeFormatter;
//import java.time.LocalDateTime;
import java.time.LocalDateTime;

/**
 *
 * @author Lenovo
 */
public class QuotationAction implements SessionAware {

    private int quotationId;
    private int dealerId;
    private String productCategory;
    private LocalDate date;
    private int units;
    private double gst;
    private double raisedAmount;
    private double discountOffers;
    private double fnalAmount;
    private String status;

    private double subTotal;
    private double sgst;
    private double cgst;
    private double discount;
    private double finalAmount;
    private boolean noData;
    private String msg;
    private LocalDate deliveryDate;

    HttpSession session = ServletActionContext.getRequest().getSession(false);

    private ArrayList<Quotation> loggedInQuotation = null;
    private Dealer dealer = null;
    private ArrayList cart = null;
    private SessionMap<String, Object> sessionMap;
    private ArrayList productList = null;
    private int id;
    private String name;
    private String dealerLastName;
    private String dealerAddress;
    private String dealerEmailId;
    private String contactInfo;
    private String zipcode;

    /**
     * @return the cart
     */
    public ArrayList getCart() {
        return cart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(ArrayList cart) {
        this.cart = cart;
    }

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
        setSessionMap((SessionMap<String, Object>) (SessionMap) map);
    }

    public String getQuote() throws SQLException {

        Order order = new Order();

        HttpSession session = ServletActionContext.getRequest().getSession(false);
        ArrayList ob = (ArrayList) session.getAttribute("cart");
        setCart(new ArrayList<>());
        setCart(ob);
        int i = 0;
        ArrayList pro = new ArrayList();
        Product pr = null;
        Product pObj = null;
        double sTotal = 0;
        double discountRate = 0;
        String productCategory = "";
        int totalqty = 0;
        while (i < getCart().size()) {
            pr = (Product) getCart().get(i);
            int id = pr.getProductId();
            Product p = ProductDao.getProduct(id);
            String productName = p.getProductName();
            String productMake = p.getProductMake();
            productCategory = p.getCategory();
            int qty = pr.getQty();
            totalqty = totalqty + qty;
            double price = p.getProductPrice();
            double total = qty * price;
            sTotal = sTotal + total;
            discountRate = discountRate + (p.getDiscountRate() + (qty / 100));
            pObj = new Product();
            pObj.setProductName(productName);
            pObj.setProductMake(productMake);
            pObj.setProductPrice(price);
            pObj.setQty(qty);
            pObj.setTotal(total);
            pro.add(pObj);
            i++;
        }
        double discountAmount = 0;
        setSubTotal(sTotal);
        if (discountRate <= 40) {
            discountAmount = sTotal * (discountRate / 100);
        } else {
            discountAmount = sTotal * (40 / 100);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        setDiscount(Double.parseDouble(df.format(discountAmount)));
        //setDiscount(discountAmount);
        setSgst(9);
        setCgst(9);
        double amountAfterDiscount = sTotal - discountAmount;
        double finalAmount = amountAfterDiscount + (amountAfterDiscount * ((getSgst() + getCgst())) / 100);
        double taxAmount = amountAfterDiscount * ((getSgst() + getCgst())) / 100;
        setFinalAmount(Double.parseDouble(df.format(finalAmount)));
        //setFinalAmount(finalAmount);
        setProductList(new ArrayList<>());
        setProductList(pro);
        setDealer(new Dealer());
        setDealer((Dealer) session.getAttribute("Dealer"));
        setId(getDealer().getDealerId());
        setName(getDealer().getDealerFirstName() + getDealer().getDealerLastName());
        setDealerAddress(getDealer().getDealerAddress());
        setDealerEmailId(getDealer().getDealerEmailId());
        setContactInfo(getDealer().getDealerContactInfo());
        setZipcode(getDealer().getZipcode());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        setDate(java.time.LocalDate.now());
        Quotation quotation = new Quotation();
        quotation.setDate(getDate());
        quotation.setDealerId(getId());
        quotation.setProductCategory(productCategory);
        quotation.setRaisedAmount(getSubTotal());
        quotation.setDiscountOffers(getDiscount());
        quotation.setFianlAmount(getFinalAmount());
        quotation.setUnits(totalqty);
        quotation.setCgst(getCgst());
        quotation.setSgst(getSgst());
        sessionMap.put("Quotation", quotation);
        LocalDate d = java.time.LocalDate.now().plusDays(7);
        System.out.println("Delivery Date: " + d);
        setDeliveryDate(d);
        order.setDealerId(getDealer().getDealerId());
        order.setOrderValue(finalAmount);
        order.setCategory(productCategory);
        order.setOrderDate(getDate());
        order.setTaxAmount(taxAmount);
        order.setDestinationAddress(getDealer().getDealerAddress());
        sessionMap.put("Order", order);
        return "AddedProducts";
    }

    public String quotationAccepted() throws SQLException {
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        Quotation quotation = (Quotation) session.getAttribute("Quotation");
        quotation.setStatus("Accepted");
        QuotationDao.saveQuotation(quotation);
        Order order = (Order) session.getAttribute("Order");
        int i = OrderDao.saveOrder(order);
        System.out.println("Affected rows: " + i);
        quotation = (Quotation) session.getAttribute("Quotation");
        quotation = null;
        sessionMap.put("Quotation", quotation);
        ArrayList cart = (ArrayList) session.getAttribute("cart");
        cart = null;
        sessionMap.put("cart", cart);
        System.out.println("Session Quotation: " + (Quotation) session.getAttribute("Quotation"));
        System.out.println("Session Quotation: " + (ArrayList) session.getAttribute("cart"));
        return "Accepted";
    }

    public String quotationDeclined() {
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        Quotation quotation = (Quotation) session.getAttribute("Quotation");
        quotation.setStatus("Declined");
        QuotationDao.saveQuotation(quotation);
        quotation = (Quotation) session.getAttribute("Quotation");
        quotation = null;
        sessionMap.put("Quotation", quotation);
        ArrayList cart = (ArrayList) session.getAttribute("cart");
        cart = null;
        sessionMap.put("cart", cart);
        return "Declined";
    }

    public String showQuotationForLoggedinDealer() throws SQLException {
        if (session == null || session.getAttribute("Dealer") == null) {
            return "LogOut1";
        } else {

            Dealer loggedDealer = (Dealer) session.getAttribute("Dealer");
            int dealerId = loggedDealer.getDealerId();
            System.out.println("Dealer Logged In Id: " + dealerId);
            setLoggedInQuotation(new ArrayList<>());
            setLoggedInQuotation(QuotationDao.getQuotation(dealerId));
            if (getLoggedInQuotation().isEmpty()) {
                setNoData(true);
                setMsg("No Data Found");
                System.out.println("No Data");
            } else {
                setNoData(false);
                System.out.println("Data found");
            }
            return "Show";
        }
    }

    /**
     * @return the dealer
     */
    public Dealer getDealer() {
        return dealer;
    }

    /**
     * @param dealer the dealer to set
     */
    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the quotationId
     */
    public int getQuotationId() {
        return quotationId;
    }

    /**
     * @param quotationId the quotationId to set
     */
    public void setQuotationId(int quotationId) {
        this.quotationId = quotationId;
    }

    /**
     * @return the dealerId
     */
    public int getDealerId() {
        return dealerId;
    }

    /**
     * @param dealerId the dealerId to set
     */
    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    /**
     * @return the productCategory
     */
    public String getProductCategory() {
        return productCategory;
    }

    /**
     * @param productCategory the productCategory to set
     */
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    /**
     * @return the units
     */
    public int getUnits() {
        return units;
    }

    /**
     * @param units the units to set
     */
    public void setUnits(int units) {
        this.units = units;
    }

    /**
     * @return the gst
     */
    public double getGst() {
        return gst;
    }

    /**
     * @param gst the gst to set
     */
    public void setGst(double gst) {
        this.gst = gst;
    }

    /**
     * @return the raisedAmount
     */
    public double getRaisedAmount() {
        return raisedAmount;
    }

    /**
     * @param raisedAmount the raisedAmount to set
     */
    public void setRaisedAmount(double raisedAmount) {
        this.raisedAmount = raisedAmount;
    }

    /**
     * @return the discountOffers
     */
    public double getDiscountOffers() {
        return discountOffers;
    }

    /**
     * @param discountOffers the discountOffers to set
     */
    public void setDiscountOffers(double discountOffers) {
        this.discountOffers = discountOffers;
    }

    /**
     * @return the fnalAmount
     */
    public double getFnalAmount() {
        return fnalAmount;
    }

    /**
     * @param fnalAmount the fnalAmount to set
     */
    public void setFnalAmount(double fnalAmount) {
        this.fnalAmount = fnalAmount;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the productList
     */
    public ArrayList getProductList() {
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(ArrayList productList) {
        this.productList = productList;
    }

    /**
     * @return the dealerLastName
     */
    public String getDealerLastName() {
        return dealerLastName;
    }

    /**
     * @param dealerLastName the dealerLastName to set
     */
    public void setDealerLastName(String dealerLastName) {
        this.dealerLastName = dealerLastName;
    }

    /**
     * @return the dealerAddress
     */
    public String getDealerAddress() {
        return dealerAddress;
    }

    /**
     * @param dealerAddress the dealerAddress to set
     */
    public void setDealerAddress(String dealerAddress) {
        this.dealerAddress = dealerAddress;
    }

    /**
     * @return the dealerEmailId
     */
    public String getDealerEmailId() {
        return dealerEmailId;
    }

    /**
     * @param dealerEmailId the dealerEmailId to set
     */
    public void setDealerEmailId(String dealerEmailId) {
        this.dealerEmailId = dealerEmailId;
    }

    /**
     * @return the contactInfo
     */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
     * @param contactInfo the contactInfo to set
     */
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    /**
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * @return the subTotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * @return the sgst
     */
    public double getSgst() {
        return sgst;
    }

    /**
     * @param sgst the sgst to set
     */
    public void setSgst(double sgst) {
        this.sgst = sgst;
    }

    /**
     * @return the cgst
     */
    public double getCgst() {
        return cgst;
    }

    /**
     * @param cgst the cgst to set
     */
    public void setCgst(double cgst) {
        this.cgst = cgst;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * @return the finalAmount
     */
    public double getFinalAmount() {
        return finalAmount;
    }

    /**
     * @param finalAmount the finalAmount to set
     */
    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

    /**
     * @return the deliveryDate
     */
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param deliveryDate the deliveryDate to set
     */
    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @return the loggedInQuotation
     */
    public ArrayList<Quotation> getLoggedInQuotation() {
        return loggedInQuotation;
    }

    /**
     * @param loggedInQuotation the loggedInQuotation to set
     */
    public void setLoggedInQuotation(ArrayList<Quotation> loggedInQuotation) {
        this.loggedInQuotation = loggedInQuotation;
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
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
