<%-- 
    Document   : shop
    Created on : Feb 27, 2022, 9:26:11 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Cửa háng / Shop</title>
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
                                <span class="text">+ 0980 xxx xxxx</span>
                            </div>
                            <div class="col-md pr-4 d-flex topper align-items-center">
                                <div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-paper-plane"></span></div>
                                <span class="text">Group 3</span>
                            </div>
                            <div class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right">
                                <span class="text">3-5 Giao hàng trong ngày làm việc; Trả hàng miễn phí</span>
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
        <form  action="search" class="card card-sm">
            <div class="hero-wrap hero-bread" style="background-image: url('images/bg_6.jpg');">
                <div class="container">
                    <div class="row no-gutters slider-text align-items-center justify-content-center">
                        <div class="col-md-9 ftco-animate text-center">
                            <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Shop</span></p>
                            <h1 class="mb-0 bread">Shop</h1>
                        </div>                   
                    </div>  

                    <div class="card-body row no-gutters align-items-center">
                        <!--end of col-->
                        <div class="col">
                            <input name="txtSearch" class="form-control form-control-lg form-control-borderless" type="search" placeholder="Tìm kiểu áo/quần" value="${aaa}">
                        </div>
                        <!--end of col-->
                        <div class="col-auto">
                            <button class="btn btn-lg btn-success" type="submit">Search</button>
                        </div>
                        <!--end of col-->
                    </div>

                </div>

            </div>

            <section class="ftco-section bg-light">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 col-lg-10 order-md-last">
                            <div class="row">
                                <c:forEach items="${listP}" var="o">
                                    <div class="col-sm-12 col-md-12 col-lg-4 ftco-animate d-flex">
                                        <div class="product d-flex flex-column">
                                            <a href="product?pid=${o.id}" class="img-prod"><img class="img-fluid" src="${o.image}" alt="Colorlib Template" style="width: 200px; height: 250px">
                                                <div class="overlay"></div>
                                            </a>
                                            <div class="text py-3 pb-4 px-3">
                                                <div class="d-flex">
                                                    <div class="cat">
                                                        <span>Lifestyle</span>
                                                    </div>
                                                    <div class="rating">
                                                        <p class="text-right mb-0">
                                                            <a href="#"><span class="ion-ios-star-outline"></span></a>
                                                            <a href="#"><span class="ion-ios-star-outline"></span></a>
                                                            <a href="#"><span class="ion-ios-star-outline"></span></a>
                                                            <a href="#"><span class="ion-ios-star-outline"></span></a>
                                                            <a href="#"><span class="ion-ios-star-outline"></span></a>
                                                        </p>
                                                    </div>
                                                </div>
                                                <h3><a href="#">${o.nameSP}</a></h3>
                                                <div class="pricing">
                                                    <p class="price"><span>${o.price}VND</span></p>
                                                </div>
                                                <p class="bottom-area d-flex px-3">
                                                    <a href="cart_add?id=${o.id}&quantity=${1}" class="add-to-cart text-center py-2 mr-1"><span>Add to cart <i class="ion-ios-add ml-1"></i></span></a>
                                                    <a href="cart_buy?id=${o.id}&quantity=${1}" class="buy-now text-center py-2">Buy now<span><i class="ion-ios-cart ml-1"></i></span></a>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>


                            </div>
                            <div class="row mt-5">
                                <div class="col text-center">
                                    <div class="block-27">
                                        <nav style="margin: 20px auto; width: 500px" aria-label="...">              
                                            <ul class="pagination pagination-lg">
                                                <c:forEach begin="1" end="${totalPage}" var="i">
                                                    <li class="page-item ${indexPage == i?"active":""}"><a class="page-link" href="shop?page=${i}">${i}</a></li>
                                                </c:forEach>
                                            </ul>
                                        </nav>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4 col-lg-2">
                            <div class="sidebar">
                                <!--<form action="search" method="post" class="colorlib-form-2">-->
                                <div class="sidebar-box-2">
                                    <h2 class="heading">Categories</h2>
                                    <div class="fancy-collapse-panel">
                                        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                                            <div class="panel panel-default">
                                                <c:forEach items="${sessionScope.listC}" var="c">
                                                    <div class="panel-heading" role="tab" id="headingOne">
                                                        <h4 class="panel-title">
                                                            <a data-toggle="collapse" data-parent="#accordion" href="#C${c.cid}" aria-expanded="true" aria-controls="C${c.cid}">
                                                                ${c.nameCate}
                                                            </a>
                                                        </h4>
                                                    </div>
                                                    <div id="C${c.cid}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                                                        <div class="panel-body">
                                                            <c:forEach items="${sessionScope.listP_t}" var="t">
                                                                <c:if test="${c.cid == t.cateid}">
                                                                    <ul>
                                                                        <li><a href="searchtitle?title=${t.title}">${t.title}</a></li>                                                          
                                                                    </ul>
                                                                </c:if>

                                                            </c:forEach>

                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>                                 
                                        </div>
                                    </div>
                                </div>
                                <div class="sidebar-box-2">

                                    <h2 class="heading">Giới tính</h2>
                                    <div class="form-field">
                                        <select name="gender">
                                            <option value="null">Chọn giới tính</option>
                                            <c:choose>
                                                <c:when test="${sex == 'true'}">
                                                    <option value="true" selected="">Nam</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="true">Nam</option>
                                                </c:otherwise>
                                            </c:choose>
                                            <c:choose>
                                                <c:when test="${sex == 'false'}">
                                                    <option value="false" selected="">Nữ</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="false">Nữ</option>
                                                </c:otherwise>
                                            </c:choose>
                                            <c:choose>
                                                <c:when test="${sex == 'both'}">
                                                    <option value="both" selected="">Cho Nam và Nữ</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="both" >Cho Nam và Nữ</option>
                                                </c:otherwise>
                                            </c:choose>


                                        </select>
                                    </div>
                                    <h2 class="heading">Màu sắc</h2>
                                    <div class="form-field">
                                        <c:forEach items="${sessionScope.lcolor}" var="cl">
                                            <input type="checkbox" name="mau" value="${cl}" />&nbsp;&nbsp;${cl}<br/>

                                        </c:forEach>
                                    </div>
                                    <h2 class="heading">Giá</h2>                            
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label for="guests">Từ:</label>
                                                <div class="form-field">
                                                    <i class="icon icon-arrow-down3"></i>
                                                    <input type="text" name="priceMin"  placeholder="Nhỏ nhất" value="${ppmin}" style="width: 100%"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label for="guests">Đến:</label>
                                                <div class="form-field">
                                                    <i class="icon icon-arrow-down3"></i>
                                                    <input type="text" name="priceMax"  placeholder="Cao nhất" value="${ppmax}" style="width: 100%"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <div class="form-field">
                                                    <input type="submit" value="Đồng ý " style="border-color: blue;
                                                           color: springgreen;
                                                           box-shadow: 0px 0px 40px 40px blue, inset, 0 0 0 0 blue;
                                                           transition: all 150ms ease-in-out;
                                                           border-radius: 8px"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                </div>
                                <!--</form>-->

                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
        <section class="ftco-gallery">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-8 heading-section text-center mb-4 ftco-animate">
                        <h2 class="mb-4">Follow Us On Instagram</h2>
                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in</p>
                    </div>
                </div>
            </div>
            <div class="container-fluid px-0">
                <div class="row no-gutters">
                    <div class="col-md-4 col-lg-2 ftco-animate">
                        <a href="images/gallery-1.jpg" class="gallery image-popup img d-flex align-items-center" style="background-image: url(images/gallery-1.jpg);">
                            <div class="icon mb-4 d-flex align-items-center justify-content-center">
                                <span class="icon-instagram"></span>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-4 col-lg-2 ftco-animate">
                        <a href="images/gallery-2.jpg" class="gallery image-popup img d-flex align-items-center" style="background-image: url(images/gallery-2.jpg);">
                            <div class="icon mb-4 d-flex align-items-center justify-content-center">
                                <span class="icon-instagram"></span>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-4 col-lg-2 ftco-animate">
                        <a href="images/gallery-3.jpg" class="gallery image-popup img d-flex align-items-center" style="background-image: url(images/gallery-3.jpg);">
                            <div class="icon mb-4 d-flex align-items-center justify-content-center">
                                <span class="icon-instagram"></span>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-4 col-lg-2 ftco-animate">
                        <a href="images/gallery-4.jpg" class="gallery image-popup img d-flex align-items-center" style="background-image: url(images/gallery-4.jpg);">
                            <div class="icon mb-4 d-flex align-items-center justify-content-center">
                                <span class="icon-instagram"></span>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-4 col-lg-2 ftco-animate">
                        <a href="images/gallery-5.jpg" class="gallery image-popup img d-flex align-items-center" style="background-image: url(images/gallery-5.jpg);">
                            <div class="icon mb-4 d-flex align-items-center justify-content-center">
                                <span class="icon-instagram"></span>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-4 col-lg-2 ftco-animate">
                        <a href="images/gallery-6.jpg" class="gallery image-popup img d-flex align-items-center" style="background-image: url(images/gallery-6.jpg);">
                            <div class="icon mb-4 d-flex align-items-center justify-content-center">
                                <span class="icon-instagram"></span>
                            </div>
                        </a>
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

    </body>
</html>
