<%-- 
    Document   : blogmanagement
    Created on : Feb 22, 2023, 6:40:37 PM
    Author     : asus
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="zxx" class="no-js">

    <header>
        <base href="../${pageContext.request.contextPath}/public/">
        <%@include file="../partial/head.jsp" %>
        <link rel="stylesheet" href="post/style.css">

    </header>
    <style>
        table {
        display: block;
        }

/*        tr, td, tbody, tfoot {
        display: block;
        }*/

        thead {
        display: none;
        }

        tr {
        padding-bottom: 10px;
        }

        td {
        padding: 10px 10px 0;
        text-align: center;
        }
        td:before {
        content: attr(data-title);
        color: #7a91aa;
        text-transform: uppercase;
        font-size: 1.4rem;
        padding-right: 10px;
        display: block;
        }

        table {
        width: 100%;
        }

        th {
            
        text-align: left;
        font-weight: 700;
        }

        thead th {
        background-color: #202932;
        color: #fff;
        border: 1px solid #202932;
        }

        tfoot th {
        display: block;
        padding: 10px;
        text-align: center;
        color: #b8c4d2;
        }

        .button {
        line-height: 1;
        display: inline-block;
        font-size: 1.2rem;
        text-decoration: none;
        border-radius: 5px;
        color: #fff;
        padding: 8px;
        background-color: #4b908f;
        }le>


    </style>




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
        <!-- End Banner Area -->

        <!--================Blog Categorie Area =================-->
        <section class="blog_categorie_area">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="categories_post">
                            <img src="img/blog/cat-post/cat-post-3.jpg" alt="post">
                            <div class="categories_details">
                                <div class="categories_text">
                                    <a href="blog-details.html">
                                        <h5>Bao</h5>
                                    </a>
                                    <div class="border_line"></div>
                                    <p>Enjoy your social life together</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="categories_post">
                            <img src="img/blog/cat-post/cat-post-2.jpg" alt="post">
                            <div class="categories_details">
                                <div class="categories_text">
                                    <a href="blog-details.html">
                                        <h5>Motobike accessories</h5>
                                    </a>
                                    <div class="border_line"></div>
                                    <p>Be a part of politics</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="categories_post">
                            <img src="img/blog/cat-post/cat-post-1.jpg" alt="post">
                            <div class="categories_details">
                                <div class="categories_text">
                                    <a href="blog-details.html">
                                        <h5>Food</h5>
                                    </a>
                                    <div class="border_line"></div>
                                    <p>Let the food be finished</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <table>
            <thead>
                <tr>
                    <th>
                        Post Title
                    </th>
                    <th>
                        Post Status
                    </th>
                    
                    <th>
                        
                    </th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach var="p" items="${requestScope.list}">
                    <tr>
                        <td >
                            ${p.postTitle}
                        </td>
                        <td>
                            ${p.postStatus}
                        </td>
                        <td>
                            <a class='button' href='${pageContext.request.contextPath}/updatepost?postId=${p.postId}''>
                                Update
                            </a>
                            <a class='button' href='${pageContext.request.contextPath}/deletepost?postId=${p.postId}'>
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


        

        <%@include file="../partial/footer.jsp" %>
        <%@include file="../partial/script.jsp" %>   
    </body>
</html>
