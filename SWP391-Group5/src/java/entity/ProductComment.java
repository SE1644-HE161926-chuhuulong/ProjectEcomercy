/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;

/**
 *
 * @author Saka289
 */
public class ProductComment {

    private int commentId;
    private User user;
    private int productId;
    private String content;
    private int rating;
    List<ProductCommentListImage> listImage;

    public ProductComment() {
    }

    public ProductComment(int commentId, User user, int productId, String content, int rating) {
        this.commentId = commentId;
        this.user = user;
        this.productId = productId;
        this.content = content;
        this.rating = rating;
    }

    public ProductComment(int commentId, User user, int productId, String content, int rating, List<ProductCommentListImage> listImage) {
        this.commentId = commentId;
        this.user = user;
        this.productId = productId;
        this.content = content;
        this.rating = rating;
        this.listImage = listImage;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<ProductCommentListImage> getListImage() {
        return listImage;
    }

    public void setListImage(List<ProductCommentListImage> listImage) {
        this.listImage = listImage;
    }

    @Override
    public String toString() {
        return "ProductComment{" + "commentId=" + commentId + ", user=" + user + ", productId=" + productId + ", content=" + content + ", rating=" + rating + ", listImage=" + listImage + '}';
    }

}
