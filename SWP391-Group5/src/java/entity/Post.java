/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author asus
 */
public class Post {
    private int postId;
    private String postTitle;
    private String postContent;
    private User userCreated;
    private Date  dateCreated;
    private Date  dateModified;
    private int viewNumber;
    private int postStatus;
    private String imageBanner;
    private String seoContent;

    public Post(int postId, String postTitle, String postContent, User userCreated, Date dateCreated, Date dateModified, int viewNumber, int postStatus, String imageBanner, String seoContent) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.userCreated = userCreated;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.viewNumber = viewNumber;
        this.postStatus = postStatus;
        this.imageBanner = imageBanner;
        this.seoContent = seoContent;
    }
    
    

    public Post() {
    }

    

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public User getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(User userCreated) {
        this.userCreated = userCreated;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public int getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(int viewNumber) {
        this.viewNumber = viewNumber;
    }

    public int getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(int postStatus) {
        this.postStatus = postStatus;
    }

    

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    @Override
    public String toString() {
        return "Post{" + "postId=" + postId + ", postTitle=" + postTitle + ", postContent=" + postContent + ", userCreated=" + userCreated + ", dateCreated=" + dateCreated + ", dateModified=" + dateModified + ", viewNumber=" + viewNumber + ", postStatus=" + postStatus + '}';
    }

    public String getImageBanner() {
        return imageBanner;
    }

    public void setImageBanner(String imageBanner) {
        this.imageBanner = imageBanner;
    }

    public String getSeoContent() {
        return seoContent;
    }

    public void setSeoContent(String seoContent) {
        this.seoContent = seoContent;
    }
    
    
    
    
}
