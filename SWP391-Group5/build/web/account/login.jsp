<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="Utilities.ENV"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

    <head>
        <base href="../${pageContext.request.contextPath}/public/">
        <%@include file="../partial/head.jsp" %>
        <link href='https://css.gg/google.css' rel='stylesheet'>
        <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    </head>

    <body>

        <%@include file="../partial/header.jsp" %>
        <style>
            .login100-form-social-item {
                width: 36px;
                height: 36px;
                font-size: 18px;
                color: #fff;
                border-radius: 50%;
            }

            .login100-form-social-item:hover {
                background: #333333;
                color: #fff;
            }
        </style>
        <!-- Start Banner Area -->
        <section class="banner-area organic-breadcrumb">
            <div class="container">
                <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                    <div class="col-first">
                        <h1>Login/Register</h1>
                        <nav class="d-flex align-items-center">
                            <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                            <a href="category.html">Login/Register</a>
                        </nav>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Banner Area -->

        <!--================Login Box Area =================-->
        <section class="login_box_area section_gap">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="login_box_img">
                            <img class="img-fluid" src="img/login.jpg" alt="">
                            <div class="hover">
                                <h4>New to our website?</h4>
                                <p>There are advances being made in science and technology everyday, and a good example of this is the</p>
                                <a class="primary-btn" href="${pageContext.request.contextPath}/register">Create an Account</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="login_form_inner">
                            <h3>Log in to enter</h3>
                            <form class="row login_form" action="${pageContext.request.contextPath}/login" method="post" id="contactForm" novalidate="novalidate">
                                <div class="col-md-12 form-group">
                                    <input type="text" class="form-control" id="name" name="username" required="" placeholder="Username" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Username'">
                                </div>
                                <div class="col-md-12 form-group">
                                    <input type="password" class="form-control" id="name" name="password" required="" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'">
                                </div>
                                <div class="col-md-12 form-group">
                                    <div class="creat_account">
                                        <!--<input type="checkbox" id="f-option2" name="selector">-->
                                        <!--<label for="f-option2">Keep me logged in</label>-->
                                    </div>
                                </div>
                                <c:if test="${requestScope.loginResult eq false}">
                                    <p style="color:red; text-align: center;margin: 1px;font-size: 15px;"> Login Failed. Please try again. </p>
                                </c:if>
                                <div class="col-md-12 form-group">
                                    <button type="submit" value="submit" class="primary-btn">Log In</button>
                                    <a href="${pageContext.request.contextPath}/forgot_pass">Forgot Password?</a>
                                    <div class="col-md-12 form-group">
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <p>Or singup with</p>
                                        <a style="display: flex;justify-content: center" href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=<%= ENV.GOOGLE_REDIRECT_URI %>&response_type=code
                                           &client_id=<%=ENV.GOOGLE_CLIENT_ID %>&approval_prompt=force"><i class="gg-google"></i></a>
                                    </div>
                                </div>
                            </form>   
                        </div>
                    </div>
                </div>
        </section>
        <!--================End Login Box Area =================-->


        <%@include file="../partial/footer.jsp" %>
        <%@include file="../partial/script.jsp" %>

    </body>

</html>
