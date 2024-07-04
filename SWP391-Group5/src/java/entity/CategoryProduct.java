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
public class CategoryProduct {

    private int cateId;
    private String cateName;
    private String image;
    private int parentId;
    private int cateStatus;
    private List<Product> listProduct;

    public CategoryProduct() {
    }

    public CategoryProduct(int cateId, String cateName, String image, int parentId, int cateStatus, List<Product> listProduct) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.image = image;
        this.parentId = parentId;
        this.cateStatus = cateStatus;
        this.listProduct = listProduct;
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

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public String toString() {
        return "CategoryProduct{" + "cateId=" + cateId + ", cateName=" + cateName + ", image=" + image + ", parentId=" + parentId + ", cateStatus=" + cateStatus + ", listProduct=" + listProduct + '}';
    }

}
