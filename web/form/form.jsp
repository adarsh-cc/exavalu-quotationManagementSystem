<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!doctype html>
<html>
    <head>
        <meta charset='utf-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <title>Snippet - BBBootstrap</title>
        <link href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' rel='stylesheet'>
        <link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css' rel='stylesheet'>
        <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <style>body {
                color: #000;
                overflow-x: hidden;
                height: 100%;
                background-image: url("https://i.imgur.com/GMmCQHC.png");
                background-repeat: no-repeat;
                background-size: 100% 100%
            }

            .card {
                padding: 30px 40px;
                margin-top: 60px;
                margin-bottom: 60px;
                border: none !important;
                box-shadow: 0 6px 12px 0 rgba(0, 0, 0, 0.2)
            }

            .blue-text {
                color: #00BCD4
            }

            .form-control-label {
                margin-bottom: 0
            }

            input,
            textarea,
            button {
                padding: 8px 15px;
                border-radius: 5px !important;
                margin: 5px 0px;
                box-sizing: border-box;
                border: 1px solid #ccc;
                font-size: 18px !important;
                font-weight: 300
            }

            input:focus,
            textarea:focus {
                -moz-box-shadow: none !important;
                -webkit-box-shadow: none !important;
                box-shadow: none !important;
                border: 1px solid #00BCD4;
                outline-width: 0;
                font-weight: 400
            }

            .btn-block {
                text-transform: uppercase;
                font-size: 15px !important;
                font-weight: 400;
                height: 43px;
                cursor: pointer
            }

            .btn-block:hover {
                color: #fff !important
            }

            button:focus {
                -moz-box-shadow: none !important;
                -webkit-box-shadow: none !important;
                box-shadow: none !important;
                outline-width: 0
            }</style>
    </head>
    <body oncontextmenu='return false' class='snippet-body'>
        <div class="container-fluid px-1 py-5 mx-auto">
            <div class="row d-flex justify-content-center">
                <div class="col-xl-7 col-lg-8 col-md-9 col-11 text-center">
                    <h3>SELECT PRODUCT CATEGORY</h3>
                    <p class="blue-text">JUST CHOOSE YOUR CATEGORY</p>
                    <div class="card">
                        <h5 class="text-center mb-4">POWERING BY M2D COMPANY</h5>
                        <form action="productMake.action" method="post" class="form-card">
                            <select class="form-select" aria-label="Default select example" name="category">
                                <option selected>Select Category</option>
                                <s:iterator value="productCategorytList">
                                    <option value='<s:property value="category"/>'><s:property value="category"/></option>
                                </s:iterator>
                            </select>
                            
<!--                            <select class="form-select" aria-label="Default select example">
                                <option selected>Select Company Name</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>-->
                            <div class="row justify-content-end">
                                <div class="form-group col-sm-6"> <button type="submit" class="btn-block btn-primary">Next</button> </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script type='text/javascript' src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js'></script>
        <script type='text/javascript' src=''></script>
        <script type='text/javascript' src=''></script>
        <script type='text/Javascript'>function validate(val) {
            v1 = document.getElementById("fname");
            v2 = document.getElementById("lname");
            v3 = document.getElementById("email");
            v4 = document.getElementById("mob");
            v5 = document.getElementById("job");
            v6 = document.getElementById("ans");

            flag1 = true;
            flag2 = true;
            flag3 = true;
            flag4 = true;
            flag5 = true;
            flag6 = true;

            if(val>=1 || val==0) {
            if(v1.value == "") {
            v1.style.borderColor = "red";
            flag1 = false;
            }
            else {
            v1.style.borderColor = "green";
            flag1 = true;
            }
            }

            if(val>=2 || val==0) {
            if(v2.value == "") {
            v2.style.borderColor = "red";
            flag2 = false;
            }
            else {
            v2.style.borderColor = "green";
            flag2 = true;
            }
            }
            if(val>=3 || val==0) {
            if(v3.value == "") {
            v3.style.borderColor = "red";
            flag3 = false;
            }
            else {
            v3.style.borderColor = "green";
            flag3 = true;
            }
            }
            if(val>=4 || val==0) {
            if(v4.value == "") {
            v4.style.borderColor = "red";
            flag4 = false;
            }
            else {
            v4.style.borderColor = "green";
            flag4 = true;
            }
            }
            if(val>=5 || val==0) {
            if(v5.value == "") {
            v5.style.borderColor = "red";
            flag5 = false;
            }
            else {
            v5.style.borderColor = "green";
            flag5 = true;
            }
            }
            if(val>=6 || val==0) {
            if(v6.value == "") {
            v6.style.borderColor = "red";
            flag6 = false;
            }
            else {
            v6.style.borderColor = "green";
            flag6 = true;
            }
            }

            flag = flag1 && flag2 && flag3 && flag4 && flag5 && flag6;

            return flag;
            }</script>
    </body>
</html>