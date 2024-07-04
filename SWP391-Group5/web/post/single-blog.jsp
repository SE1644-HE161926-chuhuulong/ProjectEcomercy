<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zxx" class="no-js">

    <head>
        <base href="../${pageContext.request.contextPath}/public/">
        <%@include file="../partial/head.jsp" %>

    </head>

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

        <!--================Blog Area =================-->



        <section class="blog_area single-post-area section_gap">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 posts-list">



                        <div class="single-post row">
                            <c:set var="post" value="${requestScope.post}" />


                            <jsp:useBean id="postModel" class="model.PostModel"/>

                            <div class="col-lg-12">

                                <div class="feature-img">
                                    <img class="img-fluid" src="${post.imageBanner}" alt="">
                                </div>
                            </div>
                            <div class="col-lg-3  col-md-3">
                                <div class="blog_info text-right">
                                    <div class="post_tag">
                                        <a href="#">Motorcycle insurance</a>
                                        <a href="#">Motobike accessories</a>
                                    </div>
                                    <ul class="blog_meta list">

                                        <li><a href="#">${post.dateCreated}<i class="lnr lnr-calendar-full"></i></a></li>
                                        <li><a href="#">${post.viewNumber}<i class="lnr lnr-eye"></i></a></li>
                                        <li><a href="#">${postModel.getAllPostComment(post.postId).size()}<i class="lnr lnr-bubble"></i></a></li>
                                    </ul>
                                    <ul class="social-links">
                                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                        <li><a href="#"><i class="fa fa-github"></i></a></li>
                                        <li><a href="#"><i class="fa fa-behance"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-9 col-md-9 blog_details">
                                <h2>${post.postTitle}</h2>
                                <p class="excert">
                                    ${post.seoContent}
                                </p>

                            </div>
                            <div class="col-lg-12">

                                <div class="row">
                                    <c:forEach items="${requestScope.listPostImage}" var="postImage" >
                                        <div class="col-6">
                                            <img class="img-fluid" src="${postImage.image}" alt="">
                                        </div>
                                    </c:forEach>


                                </div>
                            </div>
                                <div class="col-lg-12 col-md-12 blog_details">
                                
                                <p class="excert">
                                    ${post.postContent}
                                </p>

                            </div>
                                
                        </div>

                        <div class="navigation-area">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-12 nav-left flex-row d-flex justify-content-start align-items-center">
                                    <div class="thumb">
                                        <a href="#"><img class="img-fluid" src="img/blog/prev.jpg" alt=""></a>
                                    </div>
                                    <div class="arrow">
                                        <a href="#"><span class="lnr text-white lnr-arrow-left"></span></a>
                                    </div>
                                    <div class="detials">
                                        <p>Prev Post</p>
                                        <a href="#">
                                            <h4>Space The Final Frontier</h4>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-12 nav-right flex-row d-flex justify-content-end align-items-center">
                                    <div class="detials">
                                        <p>Next Post</p>
                                        <a href="#">
                                            <h4>Telescopes 101</h4>
                                        </a>
                                    </div>
                                    <div class="arrow">
                                        <a href="#"><span class="lnr text-white lnr-arrow-right"></span></a>
                                    </div>
                                    <div class="thumb">
                                        <a href="#"><img class="img-fluid" src="img/blog/next.jpg" alt=""></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="comments-area">
                            <h4>${postModel.getAllPostComment(post.postId).size()}</h4>


                            <c:forEach var="postComment" items="${postModel.getAllPostComment(post.postId)}" > 
                                <div class="comment-list left-padding">
                                    <div class="single-comment justify-content-between d-flex">
                                        <div class="user justify-content-between d-flex">
                                            <div class="thumb">
                                                <img src="${postComment.getUserId().getAvatar()}" alt="">
                                            </div>
                                            <div class="desc">
                                                <h5><a href="#">${postComment.getUserId().fullName}</a></h5>
                                                <p class="date">${postComment.getDatePosted()} </p>
                                                <p class="comment">
                                                    ${postComment.content}
                                                </p>
                                            </div>
                                        </div>
                                        <div class="reply-btn">
                                            <a href="" class="btn-reply text-uppercase">reply</a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>
                        <div class="comment-form">
                            <h4>Leave a Reply</h4>
                            <form action="${pageContext.request.contextPath}/comment?id=${post.postId}" method="post">
                                <!--                                <div class="form-group form-inline">
                                                                    <div class="form-group col-lg-6 col-md-6 name">
                                                                        <input type="text" class="form-control" id="name" placeholder="Enter Name" onfocus="this.placeholder = ''"
                                                                               onblur="this.placeholder = 'Enter Name'">
                                                                    </div>
                                                                    <div class="form-group col-lg-6 col-md-6 email">
                                                                        <input type="email" class="form-control" id="email" placeholder="Enter email address"
                                                                               onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email address'">
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <input type="text" class="form-control" id="subject" placeholder="Subject" onfocus="this.placeholder = ''"
                                                                           onblur="this.placeholder = 'Subject'">
                                                                </div>-->
                                <div class="form-group">
                                    <textarea class="form-control mb-10" rows="5" name="message" placeholder="Messege"
                                              onfocus="this.placeholder = ''" onblur="this.placeholder = 'Messege'" required=""></textarea>
                                </div>
                                <input type="submit" class="primary-btn submit_btn" value="Post Comment" name="submit"/>
                            </form>
                            ${requestScope.msg}
                        </div>
                    </div>
                    <div class="col-lg-4">
                         <c:set var="user" value="${requestScope.user}"/>
                        <div class="blog_right_sidebar">
                            <aside class="single_sidebar_widget search_widget">
                                
                                <div class="input-group">
                                    <form action="${pageContext.request.contextPath}/searchpost" method="post">
                                        <input type="text" class="form-control" placeholder="Search Posts" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Search Posts'" name="search">
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="button"><i class="lnr lnr-magnifier"></i></button>
                                    </span>
                                    </form>
                                </div><!-- /input-group -->
                                <div class="br"></div>
                            </aside>
                            <aside class="single_sidebar_widget author_widget">
                                <img class="author_img rounded-circle" src="${user.avatar}" alt="">
                                <h4>${user.fullName}</h4>
                                <p>${user.email}</p>
                                <div class="social_icon">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-github"></i></a>
                                    <a href="#"><i class="fa fa-behance"></i></a>
                                </div>
                                
                                <div class="br"></div>
                            </aside>
                            <aside class="single_sidebar_widget popular_post_widget">
                                <h3 class="widget_title">Popular Posts</h3>
                                <c:forEach var="pp" items="${requestScope.listPopular}" >
                                <div class="media post_item">
                                    <img src="${pp.imageBanner}" alt="post" style="width: 100px;height:60px ">
                                    <div class="media-body">
                                        <a href="${pageContext.request.contextPath}/single-blog?id=${pp.postId}">
                                            <h3>${pp.postTitle}</h3>
                                        </a>
                                        <p>${pp.dateCreated}</p>
                                    </div>
                                </div>
                                </c:forEach>
                                
                                <div class="br"></div>
                            </aside>
                            <aside class="single_sidebar_widget ads_widget">
                                <a href="#"><img class="img-fluid" src="img/blog/add.jpg" alt=""></a>
                                <div class="br"></div>
                            </aside>
                            <aside class="single_sidebar_widget post_category_widget">
                                <h4 class="widget_title">Post Catgories</h4>
                                <ul class="list cat-list">
                                    <li>
                                        <a href="#" class="d-flex justify-content-between">
                                            <p>Technology</p>
                                            <p>37</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex justify-content-between">
                                            <p>Lifestyle</p>
                                            <p>24</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex justify-content-between">
                                            <p>Fashion</p>
                                            <p>59</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex justify-content-between">
                                            <p>Art</p>
                                            <p>29</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex justify-content-between">
                                            <p>Food</p>
                                            <p>15</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex justify-content-between">
                                            <p>Architecture</p>
                                            <p>09</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" class="d-flex justify-content-between">
                                            <p>Adventure</p>
                                            <p>44</p>
                                        </a>
                                    </li>
                                </ul>
                                <div class="br"></div>
                            </aside>
                            <aside class="single-sidebar-widget newsletter_widget">
                                <h4 class="widget_title">Newsletter</h4>
                                <p>
                                    Here, I focus on a range of items and features that we use in life without
                                    giving them a second thought.
                                </p>
                                <div class="form-group d-flex flex-row">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text"><i class="fa fa-envelope" aria-hidden="true"></i></div>
                                        </div>
                                        <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="Enter email"
                                               onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter email'">
                                    </div>
                                    <a href="#" class="bbtns">Subcribe</a>
                                </div>
                                <p class="text-bottom">You can unsubscribe at any time</p>
                                <div class="br"></div>
                            </aside>
                            <aside class="single-sidebar-widget tag_cloud_widget">
                                <h4 class="widget_title">Tag Clouds</h4>
                                <ul class="list">
                                    <li><a href="#">Technology</a></li>
                                    <li><a href="#">Fashion</a></li>
                                    <li><a href="#">Architecture</a></li>
                                    <li><a href="#">Fashion</a></li>
                                    <li><a href="#">Food</a></li>
                                    <li><a href="#">Technology</a></li>
                                    <li><a href="#">Lifestyle</a></li>
                                    <li><a href="#">Art</a></li>
                                    <li><a href="#">Adventure</a></li>
                                    <li><a href="#">Food</a></li>
                                    <li><a href="#">Lifestyle</a></li>
                                    <li><a href="#">Adventure</a></li>
                                </ul>
                            </aside>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================Blog Area =================-->

        <%@include file="../partial/footer.jsp" %>
        <%@include file="../partial/script.jsp" %>
    </body>

</html>