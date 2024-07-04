<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="zxx" class="no-js">

    <header>
        <base href="../${pageContext.request.contextPath}/public/">
        <%@include file="../partial/head.jsp" %>
        <link rel="icon" type="image/png" href="contact/images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="contact/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="contact/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="contact/vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="contact/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="contact/vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="contact/css/util.css">
        <link rel="stylesheet" type="text/css" href="contact/css/maincontact.css">
    </header>

    <body>

        <%@include file="../partial/header.jsp" %>


        <!-- Start Banner Area -->
        <section class="banner-area organic-breadcrumb">
            <div class="container">
                <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                    <div class="col-first">
                        <h1>Blog Page</h1>
                        <nav class="d-flex align-items-center">
                            <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                            <a href="category.html">Blog</a>
                        </nav>
                    </div>
                </div>
            </div>
        </section>

        <div class="contact1" style="background: orange !important;">
            <div class="container-contact1">
                <div class="contact1-pic js-tilt" data-tilt>
                    <img src="contact/images/img-01.png" alt="IMG">
                </div>

                <form class="contact1-form validate-form" action="${pageContext.request.contextPath}/contact" method="post">
                    <span class="contact1-form-title">
                        Get in touch
                    </span>

                    <div class="wrap-input1 validate-input" data-validate = "Name is required">
                        <input class="input1" type="text" name="name" placeholder="Name">
                        <span class="shadow-input1"></span>
                    </div>

                    <div class="wrap-input1 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
                        <input class="input1" type="text" name="email" placeholder="Email">
                        <span class="shadow-input1"></span>
                    </div>

                    <div class="wrap-input1 validate-input" data-validate = "Subject is required">
                        <input class="input1" type="text" name="subject" placeholder="Subject">
                        <span class="shadow-input1"></span>
                    </div>

                    <div class="wrap-input1 validate-input" data-validate = "Message is required">
                        <textarea class="input1" name="message" placeholder="Message"></textarea>
                        <span class="shadow-input1"></span>
                    </div>

                    <div class="container-contact1-form-btn">
                        <button class="contact1-form-btn">
                            <span>
                                Send Email
                                <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                            </span>
                        </button>
                    </div>
                </form>
            </div>
        </div>




        <!--===============================================================================================-->
        <script src="contact/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="contact/vendor/bootstrap/js/popper.js"></script>
        <script src="contact/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="contact/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="contact/vendor/tilt/tilt.jquery.min.js"></script>
        <script >
            $('.js-tilt').tilt({
                scale: 1.1
            })
        </script>

        <!-- Global site tag (gtag.js) - Google Analytics -->
        <script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
        <script>
                    window.dataLayer = window.dataLayer || [];
                    function gtag() {
                        dataLayer.push(arguments);
                    }
                    gtag('js', new Date());

                    gtag('config', 'UA-23581568-13');
        </script>

        <!--===============================================================================================-->
        <script src="contact/js/main.js"></script>

        
        <!--================Blog Area =================-->

        <%@include file="../partial/footer.jsp" %>
        <%@include file="../partial/script.jsp" %>
    </body>

</html>