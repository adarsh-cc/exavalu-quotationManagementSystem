/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotation.action;

import static com.quotation.action.AdminAction.LOGGER;
import com.quotation.dao.DealerDao;
import com.quotation.pojos.Dealer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class DealerAction implements SessionAware{

    /**
     * @return the dealer
     */
    public DealerDao getDealer() {
        return dealer;
    }

    /**
     * @param dealer the dealer to set
     */
    public void setDealer(DealerDao dealer) {
        this.dealer = dealer;
    }

    private int dealerId;
    private String dealerUserName;
    private String password;
    private String dealerFirstName;
    private String dealerLastName;
    private String dealerAddress;
    private String dealerEmailId;
    private String dealerContactInfo;
    private String zipcode;
    private int status;
    private String msg;
    
    private List<Dealer> dealerList = null;
    private boolean noData = false;
    DealerDao b = new DealerDao();
    private DealerDao dealer = new DealerDao();
    
    //for log4j
    static final Logger LOGGER = Logger.getLogger(DealerAction.class);
   private static final Logger log = Logger.getLogger(DealerAction.class);
    
    private SessionMap<String, Object> sessionMap;
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
     * @return the dealerUserName
     */
    public String getDealerUserName() {
        return dealerUserName;
    }

    /**
     * @param dealerUserName the dealerUserName to set
     */
    public void setDealerUserName(String dealerUserName) {
        this.dealerUserName = dealerUserName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the dealerFirstName
     */
    public String getDealerFirstName() {
        return dealerFirstName;
    }

    /**
     * @param dealerFirstName the dealerFirstName to set
     */
    public void setDealerFirstName(String dealerFirstName) {
        this.dealerFirstName = dealerFirstName;
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
     * @return the dealerContactInfo
     */
    public String getDealerContactInfo() {
        return dealerContactInfo;
    }

    /**
     * @param dealerContactInfo the dealerContactInfo to set
     */
    public void setDealerContactInfo(String dealerContactInfo) {
        this.dealerContactInfo = dealerContactInfo;
    }

    public String dealerLogin() throws SQLException {
        String status;
        Dealer dealer = DealerDao.login(dealerEmailId, password);
        System.out.println("Dealer object: " + dealer);
        if (dealer != null) {
            System.out.println("Successfully Logged In");
            setMsg("Successfully Logged In");
            status = "LoggedIn";
            sessionMap.put("Dealer", dealer);
        } else {
            System.out.println("Invalid userid or password");
            setMsg("Invalid userid or password");
            status = "Failed";
        }
        
        LOGGER.info("This is a logging statement from  dealer login");
        log.log(Level.INFO, "This is info from Level.INFO");
        return status;
    }
    public String dealerLogout() throws SQLException{
        String status;
        if(sessionMap !=null){
            setMsg("Successfully Logged Out");
            status = "LoggedOut";
            sessionMap.invalidate();
        }
        else{
            status = "Failed";
        }
        
        LOGGER.info("This is a logging statement from  dealer logout");
        log.log(Level.INFO, "This is info from Level.INFO");
        return status;
    }

    public String dealerRegister() {
        String status;
        int i = DealerDao.register(dealerUserName, password, dealerFirstName, dealerLastName, dealerAddress, dealerEmailId, dealerContactInfo, zipcode);
        if (i > 0) {
            System.out.println("Successfully registered");
            status = "Registered";
        } else {
            setMsg("User Already Exist");
            System.out.println("Cant register");
            status = "Failed";
        }
        return status;
    }
    
    public String showDealer() throws Exception {
        try {
            setDealerList(new ArrayList<>());
            setDealerList(b.report());

            if (!dealerList.isEmpty()) {
                setNoData(false);
                System.out.println("Dealers retrieve = " + getDealerList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "REPORT";
    }

    public String executeDealer() throws Exception {
        String status1;
        int i = DealerDao.addDealer( dealerUserName, password, dealerFirstName, dealerLastName, dealerAddress, dealerEmailId, dealerContactInfo,zipcode,status);
        if(i>0)
        {
            System.out.println("Successfully Added!!");
            status1 = "Registered";
        } else {
            setMsg("Dealer Already Exist");
            System.out.println("Can't Add");
            status1 = "Failed";
        }
        return status1;
    }
    
    public String deleteDealer() throws Exception {
        try {
            int isDeleted = getDealer().deleteDealerDetails(dealerId);
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
     * @return the dealerList
     */
    public List<Dealer> getDealerList() {
        return dealerList;
    }

    /**
     * @param dealerList the dealerList to set
     */
    public void setDealerList(List<Dealer> dealerList) {
        this.dealerList = dealerList;
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
     @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }
}
