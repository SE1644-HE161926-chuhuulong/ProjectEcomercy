<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Utilities.ENV"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

    <head>
        <base href="../${pageContext.request.contextPath}/public/">
        <%@include file="../partial/head.jsp" %>
        <link href="css/register.css" rel="stylesheet" media="all">
    </head>

    <body>

        <%@include file="../partial/header.jsp" %>
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
                <div class="login_form_inner">
                    <h3>Register account</h3>
                    <c:if test="${requestScope.registerStatus eq false}"> <p style="color:red; text-align: center;margin: 1px;font-size: 15px;"> Username is existed. Please enter another username. </p></c:if>
                    <form class="row login_form" action="${pageContext.request.contextPath}/register" method="post" id="contactForm" novalidate="novalidate"                         
                          oninput="repassword.setCustomValidity(repassword.value !== password.value ? 'Confirm password does not match': '')" autocomplete="false">
                        <div class="col-md-12 form-group">
                            <input type="text" class="form-control"  name="username" required="" placeholder="Username" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Username'" autocomplete="false">
                        </div>
                        <div class="col-md-12 form-group ms-auto">
                            <input type="password" class="form-control" name="password" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'" required pattern="\S{8,}" >
                        </div>
                        <div class="col-md-12 form-group">
                            <input type="password" class="form-control" name="repassword" required="" placeholder="Re Enter Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Re Enter Password'" >
                        </div>

                        <div class="g-recaptcha d-flex justify-content-center m-4"
                             data-sitekey="<%= ENV.GOOGLE_RECAPTCHA_SITE_KEY%>"></div>
                        <div class="col-md-12 form-group">
                            <button type="submit" value="submit" class="primary-btn">Create Account</button>
                            <a href="${pageContext.request.contextPath}/login">Having Account. Back to Login?</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <!--================End Login Box Area =================-->


    <%@include file="../partial/footer.jsp" %>
    <%@include file="../partial/script.jsp" %>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.1.0/mdb.min.js"></script>
</body>

</html>