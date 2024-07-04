/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author asus
 */
public class PostComment {
    private int commentId;
    private User userId;
    private Post postId;
    private String content;
    private Date datePosted;

    public PostComment() {
    }

    public PostComment(int commentId, User userId, Post postId, String content, Date datePosted) {
        this.commentId = commentId;
        this.userId = userId;
        this.postId = postId;
        this.content = content;
        this.datePosted = datePosted;
    }

    public int getCommentId() {
        return commentId;
    }

    public User getUserId() {
        return userId;
    }

    public Post getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    @Override
    public String toString() {
        return "PostComment{" + "commentId=" + commentId + ", userId=" + userId + ", postId=" + postId + ", content=" + content + ", datePosted=" + datePosted + '}';
    }
    
}
