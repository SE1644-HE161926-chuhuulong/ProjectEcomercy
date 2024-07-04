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
public class Category {

    private int cateId;
    private String cateName;
    private String image;
    private int parentId;
    private int cateStatus;
    private List<Category> subCategory;

    public Category() {
    }

    public Category(int cateId, String cateName, String image, int parentId, int cateStatus, List<Category> subCategory) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.image = image;
        this.parentId = parentId;
        this.cateStatus = cateStatus;
        this.subCategory = subCategory;
    }

    public Category(int cateId, String cateName, String image, int parentId, int cateStatus) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.image = image;
        this.parentId = parentId;
        this.cateStatus = cateStatus;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getCateStatus() {
        return cateStatus;
    }

    public void setCateStatus(int cateStatus) {
        this.cateStatus = cateStatus;
    }

    public List<Category> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(List<Category> subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public String toString() {
        return "Category{" + "cateId=" + cateId + ", cateName=" + cateName + ", image=" + image + ", parentId=" + parentId + ", cateStatus=" + cateStatus + ", subCategory=" + subCategory + '}';
    }

}
