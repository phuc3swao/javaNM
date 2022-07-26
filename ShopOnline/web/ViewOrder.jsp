<%-- 
    Document   : ManagerPro
    Created on : Mar 8, 2022, 2:53:42 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Quản lý đơn hàng</title>
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
                        <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Cart</span></p>
                        <h1 class="mb-0 bread">Đơn hàng của bạn</h1>
                    </div>
                </div>
            </div>
        </div>

        <section class="ftco-section ftco-cart">           
            <div class="container">
                <div >
                    <form action="orderview" method="post">                                     
                        <div class="col-md-12">                        
                            Từ ngày   : <input name="bdate" type="date" value="2000-01-01">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            Đến ngày  :<input name="edate" type="date" value="2050-01-01">
                            <button type="submit" value="Đồng ý">Đồng ý</button>
                        </div>                                                                                                               
                    </form>
                    <br>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <c:if test="${requestScope.bdate != null && requestScope.edate != null}">
                        <p style="font-size: 25px; color: magenta">Đơn hàng của bạn từ ngày : ${requestScope.bdate} đến ${requestScope.edate}</p>
                    </c:if>
                </div>
                <div class="row">                  
                    <div class="col-md-12 ftco-animate">
                        <div class="cart-list">
                            <table class="table">
                                <thead class="thead-primary">
                                    <tr class="text-center">
                                        <th>Tên sản phẩm</th>
                                        <th>Hình ảnh</th>
                                        <th>Số lượng</th>
                                        <th>Giá</th>
                                        <th>Ngày đặt</th>
                                        <th>Trạng thái</th>
                                        <th>####</th>


                                    </tr>
                                </thead>
                                <c:forEach items="${requestScope.listO}" var="x">
                                    <c:forEach items="${requestScope.listP}" var="p">  
                                        <c:if test="${x.pid == p.id}">
                                            <tbody >
                                                <tr>
                                                    <td>${p.nameSP}</td>
                                                    <td><img class="img-fluid" src="${p.image}" alt="Colorlib Template" style="width: 210px; height: 280px; margin-left: auto; margin-right: auto"></td>
                                                    <td>${x.quantity}</td>
                                                    <td>${x.price}</td>
                                                    <td>${x.date}</td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${x.status == 'Bán thành công'}">
                                                                Đã mua hàng thành công
                                                            </c:when>
                                                            <c:when test="${x.status == 'Bán thất bại'}">
                                                                Đã hủy đơn
                                                            </c:when>
                                                            <c:when test="${x.status == 'Đang giao hàng'}">
                                                                Hàng đang được giao
                                                            </c:when>
                                                            <c:otherwise>
                                                                ${x.status}
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <c:choose>
                                                        <c:when test="${x.status == 'Bán thành công' && x.feedback == false }">
                                                            <td><a href="feedback?oid=${x.oid}&pid=${x.pid}">Feedback</a></td>
                                                        </c:when>
                                                        <c:when test="${x.status != 'Bán thành công' && x.status != 'Bán thất bại'}">
                                                            <td><a href="cancelorder?oid=${x.oid}">Hủy đơn</a></td>
                                                        </c:when>
                                                    </c:choose>
                                                </tr>
                                            </tbody>
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>

                            </table>
                        </div>
                    </div>
                </div>

            </div>
        </section>


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
