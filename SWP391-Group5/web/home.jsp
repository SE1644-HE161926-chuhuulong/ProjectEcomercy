<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zxx" class="no-js">

    <head>
        <base href="public/">
        <%@include file="partial/head.jsp" %>
    </head>

    <body>

        <%@include file="partial/header.jsp" %>

        <!-- start banner Area -->
        <section style="height: 700px" class="banner-area">
            <div class="container">
                <div style="transform: translateY(-100px)" class="row fullscreen align-items-center justify-content-start">
                    <div class="col-lg-3">
                        <div class="sidebar-categories">
                            <div class="head">Browse Categories</div>
                            <ul style="padding: 0;" id="main-categories" class="main-categories">
                                <c:forEach items="${requestScope.listC}" var="c">
                                    <li class="main-nav-list dropdown side-dropdown open">
                                        <a style="position: relative; line-height: 70px" href="${pageContext.request.contextPath}/productshopdetail?listCateId=${c.cateId}" class="border-bottom-1">${c.cateName} <i class="fa fa-angle-right"></i></a>
                                            <c:if test="${c.subCategory.size() != 0}">
                                            <div class="custom-menu">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <ul class="list-links">
                                                            <li>
                                                                <h3 class="list-links-title">${c.cateName}</h3>
                                                            </li>
                                                            <c:if test="${c.subCategory.size() >= 5}">
                                                                <c:forEach items="${c.subCategory.subList(0,5)}" var="c1">
                                                                    <li><a href="${pageContext.request.contextPath}/productshopdetail?cateId=${c1.cateId}">${c1.cateName}</a></li>
                                                                    </c:forEach>
                                                                </c:if>
                                                                <c:if test="${c.subCategory.size() < 5}">
                                                                    <c:forEach items="${c.subCategory.subList(0,c.subCategory.size())}" var="c1">
                                                                    <li><a href="${pageContext.request.contextPath}/productshopdetail?cateId=${c1.cateId}">${c1.cateName}</a></li>
                                                                    </c:forEach>
                                                                </c:if>
                                                        </ul>
                                                    </div>
                                                    <c:if test="${c.subCategory.size() > 5}">
                                                        <div class="col-md-4">
                                                            <ul class="list-links">
                                                                <li>
                                                                    <h3 class="list-links-title">${c.cateName}</h3>
                                                                </li>
                                                                <c:if test="${c.subCategory.size() >= 10}">
                                                                    <c:forEach items="${c.subCategory.subList(5,10)}" var="c2">
                                                                        <li><a href="${pageContext.request.contextPath}/productshopdetail?cateId=${c2.cateId}">${c2.cateName}</a></li>
                                                                        </c:forEach>
                                                                    </c:if>
                                                                    <c:if test="${c.subCategory.size() < 10}">
                                                                        <c:forEach items="${c.subCategory.subList(5,c.subCategory.size())}" var="c2">
                                                                        <li><a href="${pageContext.request.contextPath}/productshopdetail?cateId=${c2.cateId}">${c2.cateName}</a></li>
                                                                        </c:forEach>
                                                                    </c:if>
                                                            </ul>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${c.subCategory.size() > 10}">
                                                        <div class="col-md-4">
                                                            <ul class="list-links">
                                                                <li>
                                                                    <h3 class="list-links-title">${c.cateName}</h3>
                                                                </li>
                                                                <c:forEach items="${c.subCategory.subList(10,c.subCategory.size())}" var="c3">
                                                                    <li><a href="${pageContext.request.contextPath}/productshopdetail?cateId=${c3.cateId}">${c3.cateName}</a></li>
                                                                    </c:forEach>
                                                            </ul>
                                                        </div>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </c:if>
                                    </li>
                                </c:forEach>

                                <!--                                <li class="main-nav-list dropdown side-dropdown open">
                                                                    <a style="position: relative; line-height: 70px" href="#" class="border-bottom-1">Item 2<i class="fa fa-angle-right"></i></a>
                                                                    <div class="custom-menu">
                                                                        <div class="row">
                                                                            <div class="col-md-4">
                                                                                <ul class="list-links">
                                                                                    <li>
                                                                                        <h3 class="list-links-title">Categories</h3>
                                                                                    </li>
                                                                                    <li><a href="#">Women’s Clothing</a></li>
                                                                                    <li><a href="#">Men’s Clothing</a></li>
                                                                                    <li><a href="#">Phones & Accessories</a></li>
                                                                                    <li><a href="#">Jewelry & Watches</a></li>
                                                                                    <li><a href="#">Bags & Shoes</a></li>
                                                                                </ul>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <ul class="list-links">
                                                                                    <li>
                                                                                        <h3 class="list-links-title">Categories</h3>
                                                                                    </li>
                                                                                    <li><a href="#">Women’s Clothing</a></li>
                                                                                    <li><a href="#">Men’s Clothing</a></li>
                                                                                    <li><a href="#">Phones & Accessories</a></li>
                                                                                    <li><a href="#">Jewelry & Watches</a></li>
                                                                                    <li><a href="#">Bags & Shoes</a></li>
                                                                                </ul>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <ul class="list-links">
                                                                                    <li>
                                                                                        <h3 class="list-links-title">Categories</h3>
                                                                                    </li>
                                                                                    <li><a href="#">Women’s Clothing</a></li>
                                                                                    <li><a href="#">Men’s Clothing</a></li>
                                                                                    <li><a href="#">Phones & Accessories</a></li>
                                                                                    <li><a href="#">Jewelry & Watches</a></li>
                                                                                    <li><a href="#">Bags & Shoes</a></li>
                                                                                </ul>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                                <li class="main-nav-list dropdown side-dropdown open">
                                                                    <a style="position: relative; line-height: 70px" href="#" class="border-bottom-1">Item 3<i class="fa fa-angle-right"></i></a>
                                                                    <div class="custom-menu">
                                                                        <div class="row">
                                                                            <div class="col-md-4">
                                                                                <ul class="list-links">
                                                                                    <li>
                                                                                        <h3 class="list-links-title">Categories</h3>
                                                                                    </li>
                                                                                    <li><a href="#">Women’s Clothing</a></li>
                                                                                    <li><a href="#">Men’s Clothing</a></li>
                                                                                    <li><a href="#">Phones & Accessories</a></li>
                                                                                    <li><a href="#">Jewelry & Watches</a></li>
                                                                                    <li><a href="#">Bags & Shoes</a></li>
                                                                                </ul>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <ul class="list-links">
                                                                                    <li>
                                                                                        <h3 class="list-links-title">Categories</h3>
                                                                                    </li>
                                                                                    <li><a href="#">Women’s Clothing</a></li>
                                                                                    <li><a href="#">Men’s Clothing</a></li>
                                                                                    <li><a href="#">Phones & Accessories</a></li>
                                                                                    <li><a href="#">Jewelry & Watches</a></li>
                                                                                    <li><a href="#">Bags & Shoes</a></li>
                                                                                </ul>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <ul class="list-links">
                                                                                    <li>
                                                                                        <h3 class="list-links-title">Categories</h3>
                                                                                    </li>
                                                                                    <li><a href="#">Women’s Clothing</a></li>
                                                                                    <li><a href="#">Men’s Clothing</a></li>
                                                                                    <li><a href="#">Phones & Accessories</a></li>
                                                                                    <li><a href="#">Jewelry & Watches</a></li>
                                                                                    <li><a href="#">Bags & Shoes</a></li>
                                                                                </ul>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </li>-->
                                <li class="main-nav-list dropdown side-dropdown open">
                                    <a style="position: relative;line-height: 70px" href="#" class="border-bottom-1">Item 4<i class="fa fa-angle-right"></i></a>
                                </li>
                                <li class="main-nav-list dropdown side-dropdown open">
                                    <a style="position: relative;line-height: 70px" href="#" class="border-bottom-1">Item 5<i class="fa fa-angle-right"></i></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="row fullscreen align-items-center justify-content-start">
                            <div class="col-lg-12">
                                <div class="active-banner-slider owl-carousel">
                                    <!-- single-slide -->
                                    <div class="row single-slide align-items-center d-flex">
                                        <div class="col-lg-5 col-md-6">
                                            <div class="banner-content">
                                                <h1>Nike New <br>Collection!</h1>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                                                    dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
                                                <div class="add-bag d-flex align-items-center">
                                                    <a class="add-btn" href=""><span class="lnr lnr-cross"></span></a>
                                                    <span class="add-text text-uppercase">Add to Bag</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-7">
                                            <div class="banner-img">
                                                <img class="img-fluid" src="img/banner/banner-img.png" alt="">
                                            </div>
                                        </div>
                                    </div>
                                    <!-- single-slide -->
                                    <div class="row single-slide">
                                        <div class="col-lg-5">
                                            <div class="banner-content">
                                                <h1>Nike New <br>Collection!</h1>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                                                    dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
                                                <div class="add-bag d-flex align-items-center">
                                                    <a class="add-btn" href=""><span class="lnr lnr-cross"></span></a>
                                                    <span class="add-text text-uppercase">Add to Bag</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-7">
                                            <div class="banner-img">
                                                <img class="img-fluid" src="img/banner/banner-img.png" alt="">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End banner Area -->

        <!-- start features Area -->
        <section class="features-area section_gap">
            <div class="container">
                <div class="row features-inner">
                    <!-- single features -->
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-features">
                            <div class="f-icon">
                                <img src="img/features/f-icon1.png" alt="">
                            </div>
                            <h6>Free Delivery</h6>
                            <p>Free Shipping on all order</p>
                        </div>
                    </div>
                    <!-- single features -->
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-features">
                            <div class="f-icon">
                                <img src="img/features/f-icon2.png" alt="">
                            </div>
                            <h6>Return Policy</h6>
                            <p>Free Shipping on all order</p>
                        </div>
                    </div>
                    <!-- single features -->


                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <a href="skype:phamthang?call">
                            <div class="single-features">
                                <div class="f-icon">
                                    <img src="img/features/f-icon3.png" alt="">
                                </div>
                                <h6>24/7 Support</h6>
                                <p>Free Shipping on all order</p>
                            </div>
                        </a>

                    </div>
                    <!-- single features -->
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-features">
                            <div class="f-icon">
                                <img src="img/features/f-icon4.png" alt="">
                            </div>
                            <h6>Secure Payment</h6>
                            <p>Free Shipping on all order</p>
                        </div>
                    </div>


                </div>
            </div>
        </section>
        <!-- end features Area -->

        <!-- Start category Area -->
        <section class="category-area">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-8 col-md-12">
                        <div class="row">
                            <div class="col-lg-8 col-md-8">
                                <div class="single-deal">
                                    <div class="overlay"></div>
                                    <img class="img-fluid w-100" src="img/category/c1.jpg" alt="">
                                    <a href="img/category/c1.jpg" class="img-pop-up" target="_blank">
                                        <div class="deal-details">
                                            <h6 class="deal-title">Sneaker for Sports</h6>
                                        </div>
                                    </a>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4">
                                <div class="single-deal">
                                    <div class="overlay"></div>
                                    <img class="img-fluid w-100" src="img/category/c2.jpg" alt="">
                                    <a href="img/category/c2.jpg" class="img-pop-up" target="_blank">
                                        <div class="deal-details">
                                            <h6 class="deal-title">Sneaker for Sports</h6>
                                        </div>
                                    </a>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4">
                                <div class="single-deal">
                                    <div class="overlay"></div>
                                    <img class="img-fluid w-100" src="img/category/c3.jpg" alt="">
                                    <a href="img/category/c3.jpg" class="img-pop-up" target="_blank">
                                        <div class="deal-details">
                                            <h6 class="deal-title">Product for Couple</h6>
                                        </div>
                                    </a>
                                </div>
                            </div>
                            <div class="col-lg-8 col-md-8">
                                <div class="single-deal">
                                    <div class="overlay"></div>
                                    <img class="img-fluid w-100" src="img/category/c4.jpg" alt="">
                                    <a href="img/category/c4.jpg" class="img-pop-up" target="_blank">
                                        <div class="deal-details">
                                            <h6 class="deal-title">Sneaker for Sports</h6>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="single-deal">
                            <div class="overlay"></div>
                            <img class="img-fluid w-100" src="img/category/c5.jpg" alt="">
                            <a href="img/category/c5.jpg" class="img-pop-up" target="_blank">
                                <div class="deal-details">
                                    <h6 class="deal-title">Sneaker for Sports</h6>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End category Area -->

        <!-- start product Area -->
        <section class="owl-carousel active-product-area section_gap">
            <!-- single product slide -->
            <c:forEach items="${requestScope.listP}" var="p">
                <div class="single-product-slider">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-6 text-center">
                                <div class="section-title">
                                    <h1 style="font-family: monospace">${p.cateName}</h1>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                                        dolore
                                        magna aliqua.</p>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <c:forEach items="${p.listProduct}" var="p1">
                                <!-- single product -->
                                <div class="col-lg-3 col-md-6">
                                    <div class="single-product">
                                        <div class="img-product">
                                            <a href="${pageContext.request.contextPath}/productDetail?productId=${p1.productId}">
                                                <img style="height: 100%" class="img-fluid" src="${p1.image}" alt="Error">
                                            </a>
                                        </div>
                                        <div class="product-details">
                                            <a href="${pageContext.request.contextPath}/productDetail?productId=${p1.productId}"><h6 style="font-family: monospace;height: 40px"">${p1.productName}</h6></a>
                                            <div class="price">
                                                <h6>${p1.formatPrice(Double.parseDouble(p1.price))}</h6>
                                                <!--<h6 class="l-through">$210.00</h6>-->
                                            </div>
                                            <div class="prd-bottom">

                                                <a href="" class="social-info">
                                                    <span class="ti-bag"></span>
                                                    <p class="hover-text">add to bag</p>
                                                </a>
                                                <a href="" class="social-info">
                                                    <span class="lnr lnr-heart"></span>
                                                    <p class="hover-text">Wishlist</p>
                                                </a>
                                                <a href="" class="social-info">
                                                    <span class="lnr lnr-sync"></span>
                                                    <p class="hover-text">compare</p>
                                                </a>
                                                <a href="${pageContext.request.contextPath}/productDetail?productId=${p1.productId}" class="social-info">
                                                    <span class="lnr lnr-move"></span>
                                                    <p class="hover-text">view more</p>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            <!-- single product -->
                        </div>
                    </div>
                </div>
            </c:forEach>
            <!-- single product slide -->
        </section>
        <!-- end product Area -->

        <!-- Start exclusive deal Area -->
        <section class="exclusive-deal-area">
            <div class="container-fluid">
                <div class="row justify-content-center align-items-center">
                    <div class="col-lg-6 no-padding exclusive-left">
                        <div class="row clock_sec clockdiv" id="clockdiv">
                            <div class="col-lg-12">
                                <h1>Exclusive Hot Deal Ends Soon!</h1>
                                <p>Who are in extremely love with eco friendly system.</p>
                            </div>
                            <div class="col-lg-12">
                                <div class="row clock-wrap">
                                    <div class="col clockinner1 clockinner">
                                        <h1 class="days">150</h1>
                                        <span class="smalltext">Days</span>
                                    </div>
                                    <div class="col clockinner clockinner1">
                                        <h1 class="hours">23</h1>
                                        <span class="smalltext">Hours</span>
                                    </div>
                                    <div class="col clockinner clockinner1">
                                        <h1 class="minutes">47</h1>
                                        <span class="smalltext">Mins</span>
                                    </div>
                                    <div class="col clockinner clockinner1">
                                        <h1 class="seconds">59</h1>
                                        <span class="smalltext">Secs</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a href="" class="primary-btn">Shop Now</a>
                    </div>
                    <div class="col-lg-6 no-padding exclusive-right">
                        <div class="active-exclusive-product-slider">
                            <!-- single exclusive carousel -->
                            <div class="single-exclusive-slider">
                                <img class="img-fluid" src="img/product/e-p1.png" alt="">
                                <div class="product-details">
                                    <div class="price">
                                        <h6>$150.00</h6>
                                        <h6 class="l-through">$210.00</h6>
                                    </div>
                                    <h4>addidas New Hammer sole
                                        for Sports person</h4>
                                    <div class="add-bag d-flex align-items-center justify-content-center">
                                        <a class="add-btn" href=""><span class="ti-bag"></span></a>
                                        <span class="add-text text-uppercase">Add to Bag</span>
                                    </div>
                                </div>
                            </div>
                            <!-- single exclusive carousel -->
                            <div class="single-exclusive-slider">
                                <img class="img-fluid" src="img/product/e-p1.png" alt="">
                                <div class="product-details">
                                    <div class="price">
                                        <h6>$150.00</h6>
                                        <h6 class="l-through">$210.00</h6>
                                    </div>
                                    <h4>addidas New Hammer sole
                                        for Sports person</h4>
                                    <div class="add-bag d-flex align-items-center justify-content-center">
                                        <a class="add-btn" href=""><span class="ti-bag"></span></a>
                                        <span class="add-text text-uppercase">Add to Bag</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End exclusive deal Area -->

        <!-- Start brand Area -->
        <section class="brand-area section_gap">
            <div class="container">
                <div class="row">
                    <a class="col single-img" href="#">
                        <img class="img-fluid d-block mx-auto" src="img/brand/1.png" alt="">
                    </a>
                    <a class="col single-img" href="#">
                        <img class="img-fluid d-block mx-auto" src="img/brand/2.png" alt="">
                    </a>
                    <a class="col single-img" href="#">
                        <img class="img-fluid d-block mx-auto" src="img/brand/3.png" alt="">
                    </a>
                    <a class="col single-img" href="#">
                        <img class="img-fluid d-block mx-auto" src="img/brand/4.png" alt="">
                    </a>
                    <a class="col single-img" href="#">
                        <img class="img-fluid d-block mx-auto" src="img/brand/5.png" alt="">
                    </a>
                </div>
            </div>
        </section>
        <!-- End brand Area -->

        <!-- Start related-product Area -->
        <section class="related-product-area section_gap_bottom">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-6 text-center">
                        <div class="section-title">
                            <h1>Deals of the Week</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore
                                magna aliqua.</p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-9">
                        <div class="row">
                            <div class="col-lg-4 col-md-4 col-sm-6 mb-20">
                                <div class="single-related-product d-flex">
                                    <a href="#"><img src="img/r1.jpg" alt=""></a>
                                    <div class="desc">
                                        <a href="#" class="title">Black lace Heels</a>
                                        <div class="price">
                                            <h6>$189.00</h6>
                                            <h6 class="l-through">$210.00</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-6 mb-20">
                                <div class="single-related-product d-flex">
                                    <a href="#"><img src="img/r2.jpg" alt=""></a>
                                    <div class="desc">
                                        <a href="#" class="title">Black lace Heels</a>
                                        <div class="price">
                                            <h6>$189.00</h6>
                                            <h6 class="l-through">$210.00</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-6 mb-20">
                                <div class="single-related-product d-flex">
                                    <a href="#"><img src="img/r3.jpg" alt=""></a>
                                    <div class="desc">
                                        <a href="#" class="title">Black lace Heels</a>
                                        <div class="price">
                                            <h6>$189.00</h6>
                                            <h6 class="l-through">$210.00</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-6 mb-20">
                                <div class="single-related-product d-flex">
                                    <a href="#"><img src="img/r5.jpg" alt=""></a>
                                    <div class="desc">
                                        <a href="#" class="title">Black lace Heels</a>
                                        <div class="price">
                                            <h6>$189.00</h6>
                                            <h6 class="l-through">$210.00</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-6 mb-20">
                                <div class="single-related-product d-flex">
                                    <a href="#"><img src="img/r6.jpg" alt=""></a>
                                    <div class="desc">
                                        <a href="#" class="title">Black lace Heels</a>
                                        <div class="price">
                                            <h6>$189.00</h6>
                                            <h6 class="l-through">$210.00</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-6 mb-20">
                                <div class="single-related-product d-flex">
                                    <a href="#"><img src="img/r7.jpg" alt=""></a>
                                    <div class="desc">
                                        <a href="#" class="title">Black lace Heels</a>
                                        <div class="price">
                                            <h6>$189.00</h6>
                                            <h6 class="l-through">$210.00</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-6">
                                <div class="single-related-product d-flex">
                                    <a href="#"><img src="img/r9.jpg" alt=""></a>
                                    <div class="desc">
                                        <a href="#" class="title">Black lace Heels</a>
                                        <div class="price">
                                            <h6>$189.00</h6>
                                            <h6 class="l-through">$210.00</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-6">
                                <div class="single-related-product d-flex">
                                    <a href="#"><img src="img/r10.jpg" alt=""></a>
                                    <div class="desc">
                                        <a href="#" class="title">Black lace Heels</a>
                                        <div class="price">
                                            <h6>$189.00</h6>
                                            <h6 class="l-through">$210.00</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-6">
                                <div class="single-related-product d-flex">
                                    <a href="#"><img src="img/r11.jpg" alt=""></a>
                                    <div class="desc">
                                        <a href="#" class="title">Black lace Heels</a>
                                        <div class="price">
                                            <h6>$189.00</h6>
                                            <h6 class="l-through">$210.00</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ctg-right">
                            <a href="#" target="_blank">
                                <img class="img-fluid d-block mx-auto" src="img/category/c5.jpg" alt="">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End related-product Area -->


        <%@include file="partial/footer.jsp" %>
        <%@include file="partial/script.jsp" %>
    </body>

</html>