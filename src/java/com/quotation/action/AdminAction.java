/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotation.action;

import com.quotation.dao.AdminDao;
import com.quotation.pojos.Admin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Level;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class AdminAction implements SessionAware{
    private int userID;
    private String userName;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private String phoneNumber;
    private String msg;
    
    private ResultSet rs = null;
    private Admin admin = null;
    private List<Admin> adminList = null;
    private boolean noData = false;
    AdminDao dao= new AdminDao();
    private String submitType;
    
    // For log4j
    static final Logger LOGGER = Logger.getLogger(AdminAction.class);
    private static final Logger log = Logger.getLogger(AdminAction.class);
    
    private SessionMap<String, Object> sessionMap;

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * @param emailId the emailId to set
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
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
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
    
    public String adminLogin() throws SQLException {
        String status;
        Admin admin = AdminDao.login(userName, password);
        if(admin!=null)
        {
            msg = "Successfully Logged In!!";
            status = "Loggedin";
            sessionMap.put("Admin", admin);
        }
        else
            
        {
           msg = "Incorrect Credentials!!";
          status = "failed";
        }
        
        // this code use for log4j
        LOGGER.info("This is a logging statement from admin");
        log.log(Level.INFO, "This is info from Level.INFO");
        return status;
    }
    
    public String adminLogout() throws SQLException{
        String status;
        if(sessionMap !=null){
            setMsg("Successfully Logged Out");
            status = "LoggedOut";
            sessionMap.invalidate();
        }
        else{
            status = "Failed";
        }
          LOGGER.info("This is a loggedout statement from admin");
        log.log(Level.INFO, "This is info from Level.INFO");
        return status;
    }
    public String reportUser() throws Exception {
        //Admin admin = new Admin();
        try {
            setAdminList(new ArrayList<>());
            setAdminList(dao.report());
            

            if (!adminList.isEmpty() ) {
                setNoData(false);
                System.out.println("Users retrieve = "+getAdminList().size());
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
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    /**
     * @return the adminList
     */
    public List<Admin> getAdminList() {
        return adminList;
    }

    /**
     * @param adminList the adminList to set
     */
    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
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

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }
}
