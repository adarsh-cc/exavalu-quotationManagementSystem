<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Update Records For Company</title>

    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="../addproductform/css/main.css" rel="stylesheet" media="all">
    
</head>

<body>
    <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">UPDATE PRODUCT FORM</h2>
                </div>
                <div class="card-body">
                    <form action=updatecompanydetails method="POST">
                        
                        <div class="form-row">
                            <div class="name">Enter Company Name</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="companyName" value='<s:property value="companyName"/>' readonly="readonly">
                                </div>
                            </div>
                        </div>
                         <div class="form-row">
                            <div class="name">Enter Company Address</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="companyAddress" value='<s:property value="companyAddress"/>'>
                                </div>
                            </div>
                        </div>
                        
                          
                        <div class="form-row">
                            <div class="name">Enter Establishment Year</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="estblYear" value='<s:property value="estblYear"/>'>
                                </div>
                            </div>
                        </div>
                      
                        <div class="form-row">
                            <div class="name">Enter Contact Information</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="contactInfo" value='<s:property value="contactInfo"/>'>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Enter Company Mail</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="emailId" value='<s:property value="emailId"/>'>
                                </div>
                            </div>
                        </div>
                         <div class="form-row">
                            <div class="name">Enter Company Grade</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="companyGrades" value='<s:property value="companyGrades"/>'>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Enter Company Zipcode</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="zipcode" value='<s:property value="zipcode"/>'>
                                </div>
                            </div>
                        </div>      
                        <div>
                            <button class="btn btn--radius-2 btn--red" type="submit">Update Company</button>
                            
                            <button><a href="companyRecord.action" class="btn btn--radius-2 btn--green">Back To Dashboard</a> </button> 
                        </div>
                    </form>
            <s:if test="ctr>0">
            <span style="color: #973b26;"><s:property value="msg" /></span>
        </s:if>
        <s:else>
            <span style="color: red;"><s:property value="msg" /></span>
        </s:else>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->