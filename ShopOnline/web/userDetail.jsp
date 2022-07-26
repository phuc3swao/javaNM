<%-- 
    Document   : userDetail
    Created on : May 22, 2022, 7:41:50 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
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
        <!-- userDetails style -->
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/userDetailStyle.css" type="text/css"/>
        <title>User Detail</title>
    </head>
    <body>
        <!-- nav -->
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
                        <li class="nav-item"><a href="#" class="nav-link">Blog</a></li>
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
                            <li class="nav-item"><a href="userList" class="nav-link">User Management</a></li>
                            </c:if>

                        <c:choose>

                            <c:when test = "${sessionScope.acc == null}">
                                <li class="nav-item"><a href="Login.jsp" class="nav-link">Login</a></li>
                                </c:when>

                            <c:when test = "${sessionScope.acc != null}">
                                <li class="nav-item"><a href="userDetail?user=${sessionScope.acc.user}&flag=1" class="nav-link">Profile</a></li>
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
                <div class="view-account">
                    <section class="module">
                        <div class="module-inner">
                            <div class="side-bar">
                                <div class="user-info">
                                    <img class="img-profile img-circle img-responsive center-block" src="images/user.png" alt="Default User">
                                    <ul class="meta list list-unstyled">
                                        <li class="name">${userProfile.userName}
                                            <!--                                            <label class="label label-info">UX Designer</label>-->
                                        </li>
                                    </ul>
                                </div>
                                <nav class="side-menu">
                                    <ul class="nav">
                                        <li class="active"><a href="#"><span class="fa fa-user"></span> Profile</a></li>
                                    </ul>
                                </nav>
                            </div>
                            <div class="content-panel">
                                <h2 class="title">Profile<span class="pro-label label label-warning">PRO</span></h2>
                                <form class="form-horizontal" action="userDetail" method="post">
                                    <c:choose>
                                        <c:when test="${empty param.flag}">
                                            <fieldset class="fieldset">
                                                <h3 class="fieldset-title">Personal Info</h3>
                                                <!--                                        <div class="form-group avatar">
                                                                                            <figure class="figure col-md-2 col-sm-3 col-xs-12">
                                                                                                <img class="img-rounded img-responsive" src="images/user.png" alt="Default User">
                                                                                            </figure>
                                                                                            <div class="form-inline col-md-10 col-sm-9 col-xs-12">
                                                                                                <input type="file" class="file-uploader pull-left">
                                                                                                <button type="submit" class="btn btn-sm btn-default-alt pull-left">Update Image</button>
                                                                                            </div>
                                                                                        </div>-->
                                                <div class="form-group">
                                                    <label class="col-md-2 col-sm-3 col-xs-12 control-label">User Name</label>
                                                    <div class="col-md-10 col-sm-9 col-xs-12">
                                                        <input type="text" class="form-control" value="${param.user}" disabled="true">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-md-2 col-sm-3 col-xs-12 control-label">Full Name</label>
                                                    <div class="col-md-10 col-sm-9 col-xs-12">
                                                        <input type="text" class="form-control" value="${userProfile.fullName}" disabled="true">
                                                    </div>
                                                </div>
                                            </fieldset>
                                            <fieldset class="fieldset">
                                                <h3 class="fieldset-title">Contact Info</h3>
                                                <div class="form-group">
                                                    <label class="col-md-2  col-sm-3 col-xs-12 control-label">Email</label>
                                                    <div class="col-md-10 col-sm-9 col-xs-12">
                                                        <input type="email" class="form-control" value="${userProfile.email}" disabled="true">
                                                        <p class="help-block"></p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-2  col-sm-3 col-xs-12 control-label">Address</label>
                                                    <div class="col-md-10 col-sm-9 col-xs-12">
                                                        <input type="text" class="form-control" value="${userProfile.address}" disabled="true">
                                                        <p class="help-block"></p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-2  col-sm-3 col-xs-12 control-label">Phone</label>
                                                    <div class="col-md-10 col-sm-9 col-xs-12">
                                                        <input type="text" class="form-control" value="${userProfile.phone}" disabled="true">
                                                        <p class="help-block"></p>
                                                    </div>
                                                </div>
                                            </fieldset>
                                        </c:when>
                                        <c:otherwise>
                                            <fieldset class="fieldset">
                                                <h3 class="fieldset-title">Personal Info</h3>
                                                <!--                                        <div class="form-group avatar">
                                                                                            <figure class="figure col-md-2 col-sm-3 col-xs-12">
                                                                                                <img class="img-rounded img-responsive" src="images/user.png" alt="Default User">
                                                                                            </figure>
                                                                                            <div class="form-inline col-md-10 col-sm-9 col-xs-12">
                                                                                                <input type="file" class="file-uploader pull-left">
                                                                                                <button type="submit" class="btn btn-sm btn-default-alt pull-left">Update Image</button>
                                                                                            </div>
                                                                                        </div>-->
                                                <div class="form-group">
                                                    <label class="col-md-2 col-sm-3 col-xs-12 control-label">User Name</label>
                                                    <div class="col-md-10 col-sm-9 col-xs-12">
                                                        <input type="text" class="form-control" name="username" value="${param.user}" readonly>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-md-2 col-sm-3 col-xs-12 control-label">Full Name</label>
                                                    <div class="col-md-10 col-sm-9 col-xs-12">
                                                        <input type="text" class="form-control" name="name" value="${userProfile.fullName}">
                                                    </div>
                                                </div>
                                            </fieldset>
                                            <fieldset class="fieldset">
                                                <h3 class="fieldset-title">Contact Info</h3>
                                                <div class="form-group">
                                                    <label class="col-md-2  col-sm-3 col-xs-12 control-label">Email</label>
                                                    <div class="col-md-10 col-sm-9 col-xs-12">
                                                        <input type="email" class="form-control" name="email" value="${userProfile.email}">
                                                        <p class="help-block"></p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-2  col-sm-3 col-xs-12 control-label">Address</label>
                                                    <div class="col-md-10 col-sm-9 col-xs-12">
                                                        <input type="text" class="form-control" name="address" value="${userProfile.address}">
                                                        <p class="help-block"></p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-2  col-sm-3 col-xs-12 control-label">Phone</label>
                                                    <div class="col-md-10 col-sm-9 col-xs-12">
                                                        <input type="text" class="form-control" name="phone" value="${userProfile.phone}">
                                                        <p class="help-block"></p>
                                                    </div>
                                                </div>
                                            </fieldset>
                                        </c:otherwise>
                                    </c:choose>
                                    <hr>
                                    <div class="form-group">
                                        <c:choose>
                                            <c:when test="${empty param.flag}">
                                                <div class="col-md-10 col-sm-9 col-xs-12 col-md-push-2 col-sm-push-3 col-xs-push-0">
                                                    <input class="btn btn-primary" type="button" value="Return" onclick="location.href = 'userList'">
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="col-md-10 col-sm-9 col-xs-12 col-md-push-2 col-sm-push-3 col-xs-push-0">
                                                    <input class="btn btn-primary" type="submit" value="Save changes">
                                                    <input class="btn btn-primary" type="button" value="Cancel" onclick="location.href = 'home'">
                                                    <input class="btn btn-primary" type="button" value="Change Password" onclick="location.href = 'changepass'">
                                                    <!-- onclick="location.href = 'userDetail?user=${userProfile.userName}&flag=1'" -->
                                                </div>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </section> <!-- .section -->

        <script type="text/javascript"></script>


        <!--footer-->
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
