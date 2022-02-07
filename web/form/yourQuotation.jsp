<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>


<!doctype html>
<html>
    <head>
        <meta charset='utf-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <title>Snippet - BBBootstrap</title>
        <link href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css' rel='stylesheet'>
        <link href='' rel='stylesheet'>
        <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <style>body {
                background-color: #000
            }

            .padding {
                padding: 2rem !important
            }

            .card {
                margin-bottom: 30px;
                border: none;
                -webkit-box-shadow: 0px 1px 2px 1px rgba(154, 154, 204, 0.22);
                -moz-box-shadow: 0px 1px 2px 1px rgba(154, 154, 204, 0.22);
                box-shadow: 0px 1px 2px 1px rgba(154, 154, 204, 0.22)
            }

            .card-header {
                background-color: #fff;
                border-bottom: 1px solid #e6e6f2
            }

            h3 {
                font-size: 20px
            }

            h5 {
                font-size: 15px;
                line-height: 26px;
                color: #3d405c;
                margin: 0px 0px 15px 0px;
                font-family: 'Circular Std Medium'
            }

            .text-dark {
                color: #3d405c !important
            }</style>
        
        <script>
            function onAccepted(){
                alert("Quotation Accepted");
//                $.ajax({
//                    url: 'acceptQuotation',
//                    method: 'post'
//                    
//                });
            }
        </script>
    </head>
    <body oncontextmenu='return false' class='snippet-body'>
        <div class="offset-xl-2 col-xl-8 col-lg-12 col-md-12 col-sm-12 col-12 padding">
            <div class="card">
                <div class="card-header p-4">
<!--                    <a class="pt-2 d-inline-block" href="index.html" data-abc="true"></a>-->
                    <div class="float-right">
                        <h3 class="mb-0">Invoice </h3>
                        Date: <s:property value="date"/>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row mb-4">
                        <div class="col-sm-6">
                            <h5 class="mb-3">To:</h5>
                            <h3 class="text-dark mb-1"><s:property value="name"/></h3>
                            <div><s:property value="dealerAddress"/></div>
                            <div><s:property value="zipcode"/></div>
                            <div>Email:<s:property value="dealerEmailId"/></div>
                            <div>Phone: <s:property value="contactInfo"/></div>
                        </div>
                        <!--                 <div class="col-sm-6 ">
                                             <h5 class="mb-3">To:</h5>
                                             <h3 class="text-dark mb-1">Akshay Singh</h3>
                                             <div>478, Nai Sadak</div>
                                             <div>Chandni chowk, New delhi, 110006</div>
                                             <div>Email: info@tikon.com</div>
                                             <div>Phone: +91 9895 398 009</div>
                                         </div>-->
                    </div>
                    <div class="table-responsive-sm">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Item</th>
                                    <th>Make</th>
                                    <th class="right">Price</th>
                                    <th class="center">Qty</th>
                                    <th class="right">Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="productList">
                                    <tr>
                                        <td><s:property value="productName"/></td>
                                        <td><s:property value="productMake"/></td>
                                        <td><s:property value="productPrice"/></td>
                                        <td><s:property value="qty"/></td>
                                        <td><s:property value="total"/></td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="col-lg-4 col-sm-5">
                        </div>
                        <div class="col-lg-4 col-sm-5 ml-auto">
                            <table class="table table-clear">
                                <tbody>
                                    <tr>
                                        <td class="left">
                                            <strong class="text-dark">Subtotal</strong>
                                        </td>
                                        <td class="right"><s:property value="subTotal"/></td>
                                    </tr>
                                    <tr>
                                        <td class="left">
                                            <strong class="text-dark">Discount</strong>
                                        </td>
                                        <td class="right"><s:property value="discount"/></td>
                                    </tr>
                                    <tr>
                                        <td class="left">
                                            <strong class="text-dark">SGST</strong>
                                        </td>
                                        <td class="right"><s:property value="sgst"/>%</td>
                                    </tr>
                                    <tr>
                                        <td class="left">
                                            <strong class="text-dark">CGST</strong>
                                        </td>
                                        <td class="right"><s:property value="cgst"/>%</td>
                                    </tr>
                                    <tr>
                                        <td class="left">
                                            <strong class="text-dark">Final Amount</strong> </td>
                                        <td class="right">
                                            <strong class="text-dark"><s:property value="finalAmount"/></strong>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <a href="acceptQuotation.action"><input type="button" value="Accept"></a>
                            <a href="declinedQuotation.action"><input type="button" value="Decline"></a>
                        </div>
                        <h2>Your Estimated delivery Date is:<s:property value="deliveryDate"/></h2>
                    </div>
                </div>
                <div class="card-footer bg-white">
<!--                    <p class="mb-0">Brand Name To Be Entered</p>-->
                </div>
            </div>
        </div>
        <script type='text/javascript' src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js'></script>
        <script type='text/javascript' src=''></script>
        <script type='text/javascript' src=''></script>
        <script type='text/Javascript'></script>
    </body>
</html>