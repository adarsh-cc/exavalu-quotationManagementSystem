/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quotation.action;

import com.quotation.dao.CompanyDao;
import com.quotation.pojos.Company;
import java.util.ArrayList;
import java.util.List;

public class CompanyAction {
    
   private  String companyName;
   private  String companyAddress;
   private  String estblYear;
   private  String contactInfo;
   private  String emailId;
   private  String companyGrades;
   private  String zipcode;
    
    private List<Company> companyList = null;
    private boolean noData = false;
    private CompanyDao a = new CompanyDao();
    private String msg;
    private String submitType = "";
    private int ctr = 0;
    
    public String executeCompany() throws Exception {
        String status;
        int i = CompanyDao.addCompany(getCompanyName(), getEstblYear(), getContactInfo(), getEmailId(), getCompanyGrades(), getZipcode(), getCompanyAddress());
        if(i>0)
        {
            System.out.println("Successfully registered");
            status = "Registered";
        } else {
            setMsg("User Already Exist");
            System.out.println("Can;t register");
            status = "Failed";
        }
        return status;
    }

    public String showCompany() throws Exception {
        try {
            setCompanyList(new ArrayList<>());
            setCompanyList(getA().report());

            if (!companyList.isEmpty()) {
                setNoData(false);
                System.out.println("Users retrieve = " + getCompanyList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "REPORT";
    }

    public String updateCompany() throws Exception {
        try {
            if (getSubmitType().equals("updatedata")) {
                Company company1 = getA().fetchCompanyDetails(companyName);

                if (company1 != null) {

                    companyName = company1.getCompanyName();
                    estblYear = company1.getEstblYear();
                    emailId = company1.getEmailId();
                    companyGrades = company1.getCompanyGrades();
                    
                    zipcode = company1.getZipcode();
                    companyAddress = company1.getCompanyAddress();

                }
            } else {
                setCtr(getA().updateCompanyDetails(companyName,estblYear, emailId,companyGrades, contactInfo, zipcode, companyAddress));
            
                if (getCtr() > 0) {
                    msg = "Record Updated Successfuly";
                } else {
                    msg = "Error";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "UPDATE";
    }
    
    public String deleteCompany() throws Exception {
        try {
            int isDeleted = getA().deleteCompanyDetails(companyName);
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
     * @return the companyList
     */
    public List<Company> getCompanyList() {
        return companyList;
    }

    /**
     * @param companyList the companyList to set
     */
    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
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
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the companyAddress
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * @param companyAddress the companyAddress to set
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /**
     * @return the estblYear
     */
    public String getEstblYear() {
        return estblYear;
    }

    /**
     * @param estblYear the estblYear to set
     */
    public void setEstblYear(String estblYear) {
        this.estblYear = estblYear;
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
     * @return the companyGrades
     */
    public String getCompanyGrades() {
        return companyGrades;
    }

    /**
     * @param companyGrades the companyGrades to set
     */
    public void setCompanyGrades(String companyGrades) {
        this.companyGrades = companyGrades;
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
     * @return the a
     */
    public CompanyDao getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(CompanyDao a) {
        this.a = a;
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
    
}
