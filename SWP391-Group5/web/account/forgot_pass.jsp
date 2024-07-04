<%-- 
    Document   : forgot_pass
    Created on : Jan 23, 2023, 4:51:51 PM
    Author     : black
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Utilities.ENV"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="../${pageContext.request.contextPath}/public/">
        <%@include file="../partial/head.jsp" %>


    </head>
    <body>
        <%@include file="../partial/header.jsp" %>

        <hr class="forgotpass-hr">
        <section class="forgotpass-body login_box_area section_gap">
            <div class="forgotpass-responsive-form">
                <div class="container">
                    <div class="card text-black" style="border-radius: 25px;">
                        <div class="card-body p-md-5">
                            <div class="row justify-content-center">
                                <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Forgot Password</p>

                                    <form class="mx-1 mx-md-4" method="post" action="${pageContext.request.contextPath}/forgot_pass">

                                        <div class="d-flex flex-row align-items-center mb-4">

                                            <div class="form-outline flex-fill mb-0">
                                                <input type="text" id="username" class="form-control" name="username"
                                                       autocomplete="off"  required />
                                                <label class="form-label" for="username" data-error="Your Text"
                                                       data-success="right">Username</label>
                                                <i class="fas fa-user fa-lg me-3 fa-fw trailing"></i>
                                            </div>
                                        </div>

                                        <div class="g-recaptcha d-flex justify-content-center m-4"
                                             data-sitekey="<%= ENV.GOOGLE_RECAPTCHA_SITE_KEY%>"></div>

                                        <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                            <button type="submit" class="btn btn-primary btn-lg">SEND EMAIL</button>
                                        </div>

                                    </form>
                                </div>
                                <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                                    <img src="img/sh.jpg" class="img-fluid rounded">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <%@include file="../partial/footer.jsp" %>
        <%@include file="../partial/script.jsp" %>
    </body>
</html>
