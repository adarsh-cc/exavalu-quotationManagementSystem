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
        <title>Product Add</title>

        <!-- Icons font CSS-->
        <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
        <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
        <!-- Font special for pages-->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

        <!-- Vendor CSS-->
        <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
        <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

        <!-- Main CSS-->
        <link href="css/main.css" rel="stylesheet" media="all">
    </head>

    <body>
        <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
            <div class="wrapper wrapper--w790">
                <div class="card card-5">
                    <div class="card-heading">
                        <h2 class="title">ADD PRODUCT FORM</h2>
                    </div>
                    <div class="card-body">
                        <form action="registerproduct.action" method="POST">
<!--
                            <div class="form-row">
                                <div class="name">Enter Product Id</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="text" name="productId">
                                    </div>
                                </div>
                            </div>-->
                            <div class="form-row">
                                <div class="name">Enter Product Name</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="text" name="productName">
                                    </div>
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="name">Enter Product Price</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="text" name="productPrice">
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Enter Discount Rate</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="text" name="discountRate">
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Enter Product Make</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="text" name="productMake">
                                    </div>
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="name">Enter Availability</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="number" name="productAvailability">
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                 <div class="name">Enter Category</div>
                                <select class="input--style-5" aria-label="Default select example" name="category">
                                    
                                    <option selected>Select Category</option>
                                    <s:iterator value="productCategorytList">
                                        <option value='<s:property value="category"/>'><s:property value="category"/></option>
                                    </s:iterator>
                                </select>
                                <!--                                                        <div class="name">Enter Category</div>
                                                                                        <div class="value">
                                                                                            <div class="input-group">
                                                                                                <input class="input--style-5" type="text" name="category">
                                                                                            </div>
                                                                                        </div>-->
                            </div>


                            <div>
                                <button class="btn btn--radius-2 btn--red" type="submit">Add  New Product</button>
                            </div>
                        </form>
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