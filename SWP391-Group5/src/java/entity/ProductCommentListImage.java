/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Saka289
 */
public class ProductCommentListImage {

    private int id;
    private String image;
    private int commentId;

    public ProductCommentListImage() {
    }

    public ProductCommentListImage(int id, String image, int commentId) {
        this.id = id;
        this.image = image;
        this.commentId = commentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Override
    public String toString() {
        return "ProductCommentListImage{" + "id=" + id + ", image=" + image + ", commentId=" + commentId + '}';
    }

}
