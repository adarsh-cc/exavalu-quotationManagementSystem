/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotation.action;

import com.quotation.dao.ProductDao;
import com.quotation.pojos.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class ProductAction implements SessionAware{
    private int productId;
    private String productName;
    private String productMake;
    private Double productPrice;
    private Double discountRate;
    private int productAvailability;
    private String category;
    private String status;
    private SessionMap<String, Object> sessionMap;
    HttpSession session = ServletActionContext.getRequest().getSession(false);
    private ResultSet rs = null;
    private Product product = null;
    private List<Product> productList = null;
    private ProductDao products1 = new ProductDao();
    private boolean noData = false;
    private ProductDao pdao = null;
    private int ctr = 0;
    private String msg = "";
    private String submitType="";
      private ArrayList<Product> productCategorytList = null;
    
    public String executeProduct() throws Exception {
        String status1;
        int i = ProductDao.addProduct( productName, productPrice, discountRate,productMake, productAvailability, category);
        if(i>0)
        {
            System.out.println("Successfully registered");
            status1 = "Registered";
        } else {
            setMsg("User Already Exist");
            System.out.println("Can't register");
            status1 = "Failed";
        }
        return status1;
    }
    
    public String showProduct() throws Exception {
        try {
            setProductList(new ArrayList<>());
            setProductList(getProducts1().report());
            

            if (!productList.isEmpty() ) {
                setNoData(false);
                System.out.println("Products retrieve = "+getProductList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    public String updateProduct() throws Exception {
        try {
            if (submitType.equals("updatedata")) {
                Product productd = getProducts1().fetchProductDetails(productId);

                if (productd != null) {

                    productId = productd.getProductId();
                    productName = productd.getProductName();
                    productPrice = productd.getProductPrice();
                    discountRate = productd.getDiscountRate();
                    productMake = productd.getProductMake();
                    
                    productAvailability = productd.getProductAvailability();
                    category = productd.getCategory();

                }
            } else {
                setCtr(getProducts1().updateProductDetails(productId, productName,productPrice,discountRate, productMake,  productAvailability, category));
            
                if (getCtr() > 0) {
                    msg = "Record Updated Successfuly";
                } else {
                    msg = "Error Occured!";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "UPDATE";
    }
    
    public String deleteProduct() throws Exception {
        try {
            int isDeleted = getProducts1().deleteProductDetails(productId);
            if (isDeleted > 0) {
                msg = "Record deleted successfully";
            } else {
                msg = "Some Error";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "DELETE";
    }
    /**
     * @return the productList
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
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
     * @return the pdao
     */
    public ProductDao getPdao() {
        return pdao;
    }

    /**
     * @param pdao the pdao to set
     */
    public void setPdao(ProductDao pdao) {
        this.pdao = pdao;
    }

    /**
     * @return the ctr
     */
    public int getCtr() {
        return ctr;
    }

    /**
     * @param ctr the ctr to set
     */
    public void setCtr(int ctr) {
        this.ctr = ctr;
    }
    
    
       public ArrayList<Product> getProductCategorytList() {
        return productCategorytList;
    }

    /**
     * @param productCategorytList the productCategorytList to set
     */
    public void setProductCategorytList(ArrayList<Product> productCategorytList) {
        this.productCategorytList = productCategorytList;
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

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productMake
     */
    public String getProductMake() {
        return productMake;
    }

    /**
     * @param productMake the productMake to set
     */
    public void setProductMake(String productMake) {
        this.productMake = productMake;
    }

    /**
     * @return the productPrice
     */
    public Double getProductPrice() {
        return productPrice;
    }

    /**
     * @param productPrice the productPrice to set
     */
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * @return the productAvailability
     */
    public int getProductAvailability() {
        return productAvailability;
    }

    /**
     * @param productAvailability the productAvailability to set
     */
    public void setProductAvailability(int productAvailability) {
        this.productAvailability = productAvailability;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }
  public String getProductCategory() throws SQLException {
//       if (session == null || session.getAttribute("Dealer") == null ||) {
//            return "LogOut1";
//        } else {
            setProductCategorytList(new ArrayList<>());
            setProductCategorytList(ProductDao.getProductCategory());
            if (getProductCategorytList().isEmpty()) {
                setNoData(true);
                setMsg("List is empty");
            } else {
                setNoData(false);
                setMsg("list contains some data");
            }
            // Product product=(Product) getProductList().get(0);
            //System.out.println("Prodct Category: "+product.getCategory());
            return "CATEGORY";
        
    }
    
    public String getProducts() throws SQLException{
        setProductList(new ArrayList<>());
        setProductList(ProductDao.getAllProducts(category));
        if(productList.isEmpty()){
            setNoData(true);
            setMsg("List is empty");
        }else{
            setNoData(false);
            setMsg("list contains some data");
        }
        
        return "ProductList";
    }
    /**
     * @return the submitType
     */
    public String getSubmitType() {
        return submitType;
    }

    /**
     * @param submitType the submitType to set
     */
    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }

    

    /**
     * @return the products1
     */
    public ProductDao getProducts1() {
        return products1;
    }

    /**
     * @param products1 the products1 to set
     */
    public void setProducts1(ProductDao products1) {
        this.products1 = products1;
    }

    /**
     * @return the discountRate
     */
    public Double getDiscountRate() {
        return discountRate;
    }

    /**
     * @param discountRate the discountRate to set
     */
    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
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
