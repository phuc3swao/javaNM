<%-- 
    Document   : UpdatePro
    Created on : Mar 8, 2022, 8:00:09 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Thêm sản phẩm</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">

        <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="css/animate.css">

        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/ionicons.min.css">

        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">


        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/icomoon.css">
        <link rel="stylesheet" href="css/style.css">
        <style>
            input{
                width: 100%;
                border: 2px solid #aaa;
                border-radius: 4px;
                margin: 8px 0;
                outline: none;
                padding: 8px;
                box-sizing: border-box;
            }
        </style>
    </head>
    <body class="goto-here">
        <div class="py-1 bg-black">
            <div class="container">
                <div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
                    <div class="col-lg-12 d-block">
                        <div class="row d-flex">
                            <div class="col-md pr-4 d-flex topper align-items-center">
                                <div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-phone2"></span></div>
                                <span class="text">+ 1235 2355 98</span>
                            </div>
                            <div class="col-md pr-4 d-flex topper align-items-center">
                                <div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-paper-plane"></span></div>
                                <span class="text">youremail@email.com</span>
                            </div>
                            <div class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right">
                                <span class="text">3-5 Business days delivery &amp; Free Returns</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
            <div class="container">
                <a class="navbar-brand" href="index.html">Minishop</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="oi oi-menu"></span> Menu
                </button>

                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active"><a href="home" class="nav-link">Home</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Shop</a>
                            <div class="dropdown-menu" aria-labelledby="dropdown04">
                                <a class="dropdown-item" href="shop">Shop</a>                                
                                <a class="dropdown-item" href="cart">Cart</a>
                            </div>
                        </li>
                        <li class="nav-item"><a href="#" class="nav-link">About</a></li>
                        <li class="nav-item"><a href="userprofile" class="nav-link">Profile</a></li>
                            <c:if test="${sessionScope.acc.info == 'Staff'}">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Wokrs</a>
                                <div class="dropdown-menu" aria-labelledby="dropdown04">
                                    <c:if test="${sessionScope.staff == null}">
                                        <a class="dropdown-item" href="Staff_add.jsp">Info</a>
                                    </c:if>

                                    <a class="dropdown-item" href="work">Your Work</a>

                                </div>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.acc.info == 'Manager'}">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Manage</a>
                                <div class="dropdown-menu" aria-labelledby="dropdown04">
                                    <a class="dropdown-item" href="manageproduct">Product</a>                                
                                    <a class="dropdown-item" href="order_all">Order</a>
                                    <a class="dropdown-item" href="managerCategory">Category</a>
                                    <a class="dropdown-item" href="statistic">Statistic</a>
                                </div> 
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.acc.info == 'Admin'}">
                            <li class="nav-item"><a href="edit_acc" class="nav-link">Edit User</a></li>
                            </c:if>

                        <c:choose>

                            <c:when test = "${sessionScope.acc == null}">
                                <li class="nav-item"><a href="Login.jsp" class="nav-link">Login</a></li>
                                </c:when>

                            <c:when test = "${sessionScope.acc != null}">
                                <li class="nav-item"><a href="logout" class="nav-link">Logout</a></li>
                                </c:when>

                        </c:choose>     

                        <li class="nav-item cta cta-colored"><a href="cart" class="nav-link"><span class="icon-shopping_cart"></span>[0]</a></li>

                    </ul>
                </div>
            </div>
        </nav>
        <!-- END nav -->

        <div class="hero-wrap hero-bread" style="background-image: url('images/bg_6.jpg');">
            <div class="container">
                <div class="row no-gutters slider-text align-items-center justify-content-center">
                    <div class="col-md-9 ftco-animate text-center">
                        <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Checkout</span></p>
                        <h1 class="mb-0 bread">Checkout</h1>
                    </div>
                </div>
            </div>
        </div>

        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xl-10 ftco-animate">
                        <form action="add_p" method="post" class="billing-form">
                            <h3 class="mb-4 billing-heading">Thêm sản phẩm</h3>
                            <p style="color: red">${requestScope.existP}</p>
                            <p style="color: green">${requestScope.success}</p>
                            <div class="row align-items-end">                               
                            </div>                               
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="country" >ID sản phẩm : <input type="text" name="id" placeholder="Nhập id (Số)"/></label><br>
                                    <label for="country" >Tên sản phẩm:</label><br>                                      
                                    <input type="text" name="nameSP" placeholder="Nhập Tên">
                                    <label for="country">Hình ảnh:</label><br>                                      
                                    <input type="text" name="image" placeholder="Link hình ảnh">
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="streetaddress">Giá tiền:</label>
                                    <input type="text"  name="price" placeholder="Theo VND" ><br>
                                    <label for="streetaddress">Màu:</label>
                                    <input type="text"  name="color" placeholder="Nhập màu" >
                                </div>
                            </div>


                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="towncity">Title</label>
                                    <input type="text" name="title" placeholder="Loại" >
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="postcodezip">Mô tả</label>
                                    <textarea  name="description" rows="4" cols="20" placeholder="Thêm mô tả" style="width: 100%">
                                    </textarea>
                                </div>
                            </div>
                            <div class="w-100"></div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="phone">ID loại sản phẩm</label>
                                    <select name="cateid">
                                        <c:forEach items="${listC}" var="c">
                                            <option value="${c.cid}">${c.nameCate}</option>   
                                        </c:forEach>                                                                            
                                    </select>                                   
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="emailaddress">Giới tính</label>
                                    <select name="gender">
                                        <option value="1">Nam</option>
                                        <option value="0">Nữ</option>
                                        <option value="null" >Cho Nam và Nữ</option>
                                    </select>
                                </div>
                            </div>
                            <input class="btn btn-primary py-3 px-4" type="submit" value="Thêm" style="width: 30%"/>
                        </form><!-- END -->




                    </div> <!-- .col-md-8 -->
                </div>
            </div>
        </section> <!-- .section -->


        <footer class="ftco-footer ftco-section">
            <div class="container">
                <div class="row">
                    <div class="mouse">
                        <a href="#" class="mouse-icon">
                            <div class="mouse-wheel"><span class="ion-ios-arrow-up"></span></div>
                        </a>
                    </div>
                </div>
                <div class="row mb-5">
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Minishop</h2>
                            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>
                            <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-4 ml-md-5">
                            <h2 class="ftco-heading-2">Menu</h2>
                            <ul class="list-unstyled">
                                <li><a href="#" class="py-2 d-block">Shop</a></li>
                                <li><a href="#" class="py-2 d-block">About</a></li>
                                <li><a href="#" class="py-2 d-block">Journal</a></li>
                                <li><a href="#" class="py-2 d-block">Contact Us</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Help</h2>
                            <div class="d-flex">
                                <ul class="list-unstyled mr-l-5 pr-l-3 mr-4">
                                    <li><a href="#" class="py-2 d-block">Shipping Information</a></li>
                                    <li><a href="#" class="py-2 d-block">Returns &amp; Exchange</a></li>
                                    <li><a href="#" class="py-2 d-block">Terms &amp; Conditions</a></li>
                                    <li><a href="#" class="py-2 d-block">Privacy Policy</a></li>
                                </ul>
                                <ul class="list-unstyled">
                                    <li><a href="#" class="py-2 d-block">FAQs</a></li>
                                    <li><a href="#" class="py-2 d-block">Contact</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Have a Questions?</h2>
                            <div class="block-23 mb-3">
                                <ul>
                                    <li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span></li>
                                    <li><a href="#"><span class="icon icon-phone"></span><span class="text">+2 392 3929 210</span></a></li>
                                    <li><a href="#"><span class="icon icon-envelope"></span><span class="text">info@yourdomain.com</span></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 text-center">

                        <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart color-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        </p>
                    </div>
                </div>
            </div>
        </footer>



        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/jquery.animateNumber.min.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/scrollax.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="js/google-map.js"></script>
        <script src="js/main.js"></script>

        <script>
                                $(document).ready(function () {

                                    var quantitiy = 0;
                                    $('.quantity-right-plus').click(function (e) {

                                        // Stop acting like a button
                                        e.preventDefault();
                                        // Get the field name
                                        var quantity = parseInt($('#quantity').val());

                                        // If is not undefined

                                        $('#quantity').val(quantity + 1);


                                        // Increment

                                    });

                                    $('.quantity-left-minus').click(function (e) {
                                        // Stop acting like a button
                                        e.preventDefault();
                                        // Get the field name
                                        var quantity = parseInt($('#quantity').val());

                                        // If is not undefined

                                        // Increment
                                        if (quantity > 0) {
                                            $('#quantity').val(quantity - 1);
                                        }
                                    });

                                });
        </script>

    </body>
</html>