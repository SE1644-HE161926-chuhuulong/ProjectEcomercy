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

                                    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Reset Password</p>

                                    <form class="mx-1 mx-md-4" method="post" action="${pageContext.request.contextPath}/reset_password"
                                          oninput="repassword.setCustomValidity(repassword.value !== password.value ? 'Confirm password does not match': '')">

                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="password" id="password" class="form-control" name="password"
                                                       required pattern="\S{8,}"/>
                                                <label class="form-label" for="password">Password</label>
                                            </div>
                                        </div>

                                        <div class="d-flex flex-row align-items-center mb-4">
                                            <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="password" id="repassword" class="form-control" required />
                                                <label class="form-label" for="repassword">Repeat your
                                                    password</label>
                                            </div>
                                        </div>

                                        <input type="hidden" name="token" value="<%= request.getParameter("token")%>"/>

                                        <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                            <button type="submit" class="btn btn-primary btn-lg">CHANGE PASSWORD</button>
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
