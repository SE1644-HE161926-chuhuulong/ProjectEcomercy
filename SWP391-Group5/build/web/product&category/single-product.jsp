<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zxx" class="no-js">

    <head>
        <base href="../${pageContext.request.contextPath}/public/">
        <%@include file="../partial/head.jsp" %>
        <link  href="https://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet">
    </head>

    <body>

        <%@include file="../partial/header.jsp" %>

        <!-- Start Banner Area -->
        <section class="banner-area organic-breadcrumb">
            <div class="container">
                <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                    <div class="col-first">
                        <h1>Product Details Page</h1>
                        <nav class="d-flex align-items-center">
                            <a href="${pageContext.request.contextPath}/home">Home<span class="lnr lnr-arrow-right"></span></a>
                            <a href="#">Shop<span class="lnr lnr-arrow-right"></span></a>
                            <a href="single-product.html">product-details</a>
                        </nav>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Banner Area -->

        <!--================Single Product Area =================-->
        <c:set value="${requestScope.detailP}" var="d"/>
        <div class="container">
            <div class="row s_product_inner">
                <div class="col-lg-6">
                    <div class="fotorama showimage" data-width="100%" data-autoplay="2000" data-thumbwidth="100%" data-nav="thumbs">
                        <img src="${d.image}" alt="">
                        <c:forEach items="${requestScope.ListPLI}" var="pli">
                            <img src="${pli.image}" alt="">
                        </c:forEach>
                    </div>
                    <div > </div>   
                </div>
                <div class="col-lg-5 offset-lg-1">
                    <form action="${pageContext.request.contextPath}/buy" method="post">
                        <div class="s_product_text">
                            <h3>${d.productName}</h3>
                            <h2>${d.price}</h2>
                            <ul class="list">
                                <li><a class="active" href="#"><span>Category</span> : Household</a></li>
                                    <c:if test="${d.productStatus == 1}">
                                    <li><a href="#"><span>Status</span> : In Stock</a></li>
                                    </c:if>
                                    <c:if test="${d.productStatus != 1}">
                                    <li><a href="#"><span>Status</span> : Out Of Stock</a></li>
                                    </c:if>
                                <li><a href="#"><span>Quantity</span> : ${d.quantity} cái</a></li>
                            </ul>
                            <p>${d.description}</p>
                            <div class="product_count">
                                <label for="num">Quantity:</label>
                                <input type="text" name="num" id="sst" maxlength="12" value="1" title="Quantity:" class="input-text qty">
                                <button onclick="var result = document.getElementById('sst');
                                        var sst = result.value;
                                        if (!isNaN(sst) && sst < ${d.quantity})
                                            result.value++;
                                        return false;"
                                        class="increase items-count" type="button"><i class="lnr lnr-chevron-up"></i></button>
                                <button onclick="var result = document.getElementById('sst');
                                        var sst = result.value;
                                        if (!isNaN(sst) && sst > 1)
                                            result.value--;
                                        return false;"
                                        class="reduced items-count" type="button"><i class="lnr lnr-chevron-down"></i></button>
                            </div>
                            <div class="card_area d-flex align-items-center">
                                <button class="primary-btn" type="submit">Add to Cart</button>
                                <a class="icon_btn" href="#"><i class="lnr lnr lnr-diamond"></i></a>
                                <a class="icon_btn" href="#"><i class="lnr lnr lnr-heart"></i></a>
                            </div>
                            <input hidden="" name="id" value="${d.productId}">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!--================End Single Product Area =================-->

    <!--================Product Description Area =================-->
    <section class="product_description_area">
        <div class="container">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Description</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact" role="tab" aria-controls="contact"
                       aria-selected="false">Comments</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" id="review-tab" data-toggle="tab" href="#review" role="tab" aria-controls="review"
                       aria-selected="false">Reviews</a>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <p>${d.description}</p>
                </div>
                <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="comment_list">
                                <div class="review_item">
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="img/product/review-1.png" alt="">
                                        </div>
                                        <div class="media-body">
                                            <h4>Blake Ruiz</h4>
                                            <h5>12th Feb, 2018 at 05:56 pm</h5>
                                            <a class="reply_btn" href="#">Reply</a>
                                        </div>
                                    </div>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                                        dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                                        commodo</p>
                                </div>
                                <div class="review_item reply">
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="img/product/review-2.png" alt="">
                                        </div>
                                        <div class="media-body">
                                            <h4>Blake Ruiz</h4>
                                            <h5>12th Feb, 2018 at 05:56 pm</h5>
                                            <a class="reply_btn" href="#">Reply</a>
                                        </div>
                                    </div>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                                        dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                                        commodo</p>
                                </div>
                                <div class="review_item">
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="img/product/review-3.png" alt="">
                                        </div>
                                        <div class="media-body">
                                            <h4>Blake Ruiz</h4>
                                            <h5>12th Feb, 2018 at 05:56 pm</h5>
                                            <a class="reply_btn" href="#">Reply</a>
                                        </div>
                                    </div>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                                        dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                                        commodo</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="review_box">
                                <h4>Post a comment</h4>
                                <form class="row contact_form" action="contact_process.php" method="post" id="contactForm" novalidate="novalidate">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="name" name="name" placeholder="Your Full name">
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <input type="email" class="form-control" id="email" name="email" placeholder="Email Address">
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="number" name="number" placeholder="Phone Number">
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <textarea class="form-control" name="message" id="message" rows="1" placeholder="Message"></textarea>
                                        </div>
                                    </div>
                                    <div class="col-md-12 text-right">
                                        <button type="submit" value="submit" class="btn primary-btn">Submit Now</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <c:set value="${requestScope.totalRating}" var="totalrating"/>
                <c:set value="${requestScope.numberReview}" var="numberreview"/>
                <div class="tab-pane fade show active" id="review" role="tabpanel" aria-labelledby="review-tab">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="row total_rate">
                                <div class="col-6">
                                    <div class="box_total">
                                        <h5>Overall</h5>
                                        <c:if test="${totalrating == null}">
                                            <h4>0.0</h4>
                                        </c:if>
                                        <c:if test="${totalrating != null}">
                                            <h4>${totalrating}</h4>
                                        </c:if>
                                        <c:if test="${numberreview != 0}">
                                            <h6>(0${numberreview} Reviews)</h6>
                                        </c:if>
                                        <c:if test="${numberreview == 0}">
                                            <h6>(0 Reviews)</h6>
                                        </c:if>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="rating_list">
                                        <h3>Based on ${numberreview} Reviews</h3>
                                        <c:forEach begin="0" end="${listRating.size()-1}" step="1" var="i">
                                            <ul class="list">
                                                <li><a>${i+1} Star <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                                                            class="fa fa-star"></i><i class="fa fa-star"></i> ${listRating.get(i)}</a></li>
                                            </ul>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div id="reviewData" class="review_list">
                                <c:forEach items="${requestScope.listPC}" var="pc">
                                    <div class="review_item">
                                        <div class="media">
                                            <div class="d-flex">
                                                <img src="${pc.user.avatar}" alt="">
                                            </div>
                                            <div class="media-body">
                                                <h4>${pc.user.username}</h4>
                                                <c:forEach begin="1" end="${pc.rating}">
                                                    <i class="fa fa-star"></i>
                                                </c:forEach>
                                                <c:forEach begin="${pc.rating}" end="4">
                                                    <i style="font-family: FontAwesome;" class="fa fa-star-o"></i>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <p>${pc.content}</p>
                                        <c:if test="${pc.listImage.size() != null}">
                                            <div class="review-comment">
                                                <div class="row-review">
                                                    <c:forEach items="${pc.listImage}" var="pc1">
                                                        <div class="column-review">
                                                            <img src="${pc1.image}" alt=""  onclick="myFunction(this, '${pc1.id}');">
                                                        </div>
                                                    </c:forEach>
                                                </div>
                                                <c:forEach items="${pc.listImage}" var="pc2">
                                                    <div class="container-review">
                                                        <span onclick="this.parentElement.style.display = 'none'" class="closebtn-review">&times;</span>
                                                        <img id="expandedImg${pc2.id}" style="width:80%">
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </c:if>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <form action="${pageContext.request.contextPath}/productcomment" method="post" enctype="multipart/form-data" id="my-form">
                                <input name="productId" type="hidden" value="${d.productId}">
                                <div class="review_box">
                                    <h4>Add a Review</h4>
                                    <span>Upload image: </span>
                                    <div class="multiple-uploader" id="multiple-uploader">
                                        <div class="mup-msg">
                                            <span class="mup-main-msg">Click to upload images.</span>
                                            <span class="mup-msg" id="max-upload-number">Upload up to 10 images</span>
                                        </div>
                                    </div>
                                    <div class="input-rating">
                                        <span>Your Rating: </span>
                                        <div class="stars">
                                            <input id="star5" name="rating" required="" value="5" type="radio"><label
                                                for="star5"></label>
                                            <input id="star4" name="rating" required="" value="4" type="radio"><label
                                                for="star4"></label>
                                            <input id="star3" name="rating" required="" value="3" type="radio"><label
                                                for="star3"></label>
                                            <input id="star2" name="rating" required="" value="2" type="radio"><label
                                                for="star2"></label>
                                            <input id="star1" name="rating" required="" value="1" type="radio"><label
                                                for="star1"></label>
                                        </div>
                                        <p>Outstanding</p>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <textarea id="editor1" required="" name="review"  placeholder="Review"></textarea>
                                        </div>
                                    </div>
                                    <div class="col-md-12 text-right">
                                        <button type="submit" onclick="loadData(${d.productId})" class="primary-btn">Submit Now</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================End Product Description Area =================-->

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

    <%@include file="../partial/footer.jsp" %>
    <%@include file="../partial/script.jsp" %>
    <script>
        // Replace the <textarea id="editor1"> with a CKEditor 4
        // instance, using default configuration.
        CKEDITOR.replace('editor1');
    </script>
    <script src="../public/js/multiple-uploader.js"></script>
    <script>
        let multipleUploader = new MultipleUploader('#multiple-uploader').init({
            maxUpload: 5, // maximum number of uploaded images
            maxSize: 5, // in size in mb
            filesInpName: 'images', // input name sent to backend
            formSelector: '#my-form', // form selector
        });
    </script>
    <script>
        function loadData(productid) {
            $.ajax({
                url: "/SWP391-Group5/productcommentAsync",
                type: 'GET',
                data: {
                    Id: productid
                },
                success: function (data) {
                    var reviewData = document.getElementById("reviewData");
                    reviewData.innerHTML += data;
                },
                error: function (jqXHR) {
                    cosole.log(jqXHR);
                }
            });
        }
        function loadPost() {

            $.ajax({
                url: "SWP391-Group5/productcomment",
                type: "POST",

                success: function (data) {

                },
                error: function (jqXHR) {
                    console.log(jqXHR);
                }

            });
        }
    </script>
</body>

</html>