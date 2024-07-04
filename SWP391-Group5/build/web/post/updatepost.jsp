<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zxx" class="no-js">

    <head>
        <base href="../${pageContext.request.contextPath}/public/">
        <%@include file="../partial/head.jsp" %>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE2w+3UksdQRVvoxMfooAo" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+qZQbl" crossorigin="anonymous"></script>
        <script src="//cdn.ckeditor.com/4.20.2/full/ckeditor.js"></script>

        <link rel="stylesheet" href="jodit/app.css" />
        <link rel="stylesheet" href="jodit/jodit.min.css" />
        <script src="jodit/jodit.js"></script>
    </head>

    <body>

        <%@include file="../partial/header.jsp" %>

        <!-- Start Banner Area -->
        <section class="banner-area organic-breadcrumb">
            <div class="container">
                <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                    <div class="col-first">
                        <h1>Update Post</h1>
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
                    <div class="container my-5">
                        <h1 class="mb-4">Update Post</h1>
                        <c:set var="post" value="${requestScope.post}"/>
                        <!--                        <form method="post" enctype="multipart/form-data" id="my-form" action="/createpost">-->
                        <form method="post" action="${pageContext.request.contextPath}/updatepost?postId=${post.postId}" enctype="multipart/form-data">

<!--                            <input type="text"  value="${post.postId}"  name="postId"/>-->

                            <div class="form-group">
                                <label for="post-title">Title</label>
                                <input type="text" class="form-control" id="post-title" name="post-title" placeholder="Enter post title" value="${post.postTitle}">
                            </div>

                            <!--                            <span>Upload image Banner of Post: </span>-->

                            <!--                            <div class="multiple-uploader" id="multiple-uploader">
                                                            <div class="mup-msg">
                                                                <span class="mup-main-msg">Click to upload images.</span>
                                                                <span class="mup-msg" id="max-upload-number">Upload up to 10 images</span>
                                                            </div>
                                                        </div>-->
                            <!--                            <input type="file" id="file" name="file" />-->
                            <div class="form-group">
                                <label for="image-Banner">Image Banner:</label>
                                <image style="width: 200px; height: auto;" src="${post.imageBanner}" />

                            </div>
                            <label for="image-Banner">Choose another image banner:</label> 
                            <div class="form-group">
                                <input type="file" id="files" name="files[]" multiple value="C:/prj301/SWP391/swp391-se1637-group5/Source/SWP391-Group5/web/public/"+${post.imageBanner}/>

                                <output id="list" >


                                </output>
                            </div>


                            <div class="form-group">
                                <label for="seo-content">SEO Content</label>
                                <textarea class="form-control" id="seo-content" name="seo-content" rows="5" value="">${post.seoContent}</textarea>

                            </div>
<!--                            <div class="form-group">
                                <label for="post-content">Content</label>
                                <textarea class="form-control" id="post-content" name="post-content" rows="100"  value="">${post.postContent}</textarea>
                            </div>-->
                            





                            <style>
                                #box {
                                    padding: 0px;
                                    margin-bottom:200px;
                                    position: relative;
                                    height: 500px;
                                }

                                @media (max-width: 480px) {
                                    #box {
                                        padding: 0;
                                    }
                                }
                            </style>
                            <div id="box">
                                Content
                                <textarea id="editorjodit" name="post-content-jodit">
				${post.postContent}
                                </textarea>
                            </div>
                            <script>
                                const editor = Jodit.make('#editorjodit', {
                                    uploader: {
                                        url: 'https://xdsoft.net/jodit/finder/?action=fileUpload'
                                    },
                                    filebrowser: {
                                        ajax: {
                                            url: 'https://xdsoft.net/jodit/finder/'
                                        }
                                    }
                                });
                            </script>
                            
                            
                            
                            
                            
                            <button type="submit" class="btn btn-primary" value="updatepost">Update</button>

                        </form>
                    </div>


                </div>
            </div>
        </section>
        <!--================Blog Area =================-->
        <style>
            .thumb {
                height: 75px;
                border: 1px solid #000;
                margin: 10px 5px 0 0;
            }
        </style>
        <script>
            CKEDITOR.replace('post-content');

        </script>
        <script src="../public/js/multiple-uploader.js"></script>
        <script>
            let multipleUploader = new MultipleUploader('#multiple-uploader').init({
                maxUpload: 1, // maximum number of uploaded images
                maxSize: 1, // in size in mb
                filesInpName: 'images', // input name sent to backend
                formSelector: '#my-form', // form selector
            });
        </script>
        <script>
            function handleFileSelect(evt) {
                var files = evt.target.files; // FileList object

                // Loop through the FileList and render image files as thumbnails.
                for (var i = 0, f; f = files[i]; i++) {

                    // Only process image files.
                    if (!f.type.match('image.*')) {
                        continue;
                    }

                    var reader = new FileReader();

                    // Closure to capture the file information.
                    reader.onload = (function (theFile) {
                        return function (e) {
                            // Render thumbnail.
                            var span = document.createElement('span');
                            span.innerHTML = ['<img class="thumb" src="', e.target.result,
                                '" title="', escape(theFile.name), '"/>'].join('');
                            document.getElementById('list').insertBefore(span, null);
                        };
                    })(f);

                    // Read in the image file as a data URL.
                    reader.readAsDataURL(f);
                }
            }

            document.getElementById('files').addEventListener('change', handleFileSelect, false);

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
        <%@include file="../partial/footer.jsp" %>
        <%@include file="../partial/script.jsp" %>
    </body>

</html>