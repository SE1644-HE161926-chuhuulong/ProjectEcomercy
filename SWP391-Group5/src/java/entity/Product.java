/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Saka289
 */
public class Product {

    private int productId;
    private Category category;
    private int brandId;
    private String productName;
    private double price;
    private double discount;
    private String description;
    private String image;
    private int quantity;
    private long buyNumber;
    private int userCreatedId;
    private int userModifiedId;
    private String dateCreated;
    private String dateModified;
    private int productStatus;

    public Product() {
    }

    public Product(int productId, Category category, int brandId, String productName, double price, double discount, String description, String image, int quantity, long buyNumber, int userCreatedId, int userModifiedId, String dateCreated, String dateModified, int productStatus) {
        this.productId = productId;
        this.category = category;
        this.brandId = brandId;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.image = image;
        this.quantity = quantity;
        this.buyNumber = buyNumber;
        this.userCreatedId = userCreatedId;
        this.userModifiedId = userModifiedId;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(long buyNumber) {
        this.buyNumber = buyNumber;
    }

    public int getUserCreatedId() {
        return userCreatedId;
    }

    public void setUserCreatedId(int userCreatedId) {
        this.userCreatedId = userCreatedId;
    }

    public int getUserModifiedId() {
        return userModifiedId;
    }

    public void setUserModifiedId(int userModifiedId) {
        this.userModifiedId = userModifiedId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", category=" + category + ", brandId=" + brandId + ", productName=" + productName + ", price=" + price + ", discount=" + discount + ", description=" + description + ", image=" + image + ", quantity=" + quantity + ", buyNumber=" + buyNumber + ", userCreatedId=" + userCreatedId + ", userModifiedId=" + userModifiedId + ", dateCreated=" + dateCreated + ", dateModified=" + dateModified + ", productStatus=" + productStatus + '}';
    }

    public String formatPrice(double amount) {
        Locale locale = new Locale("vn", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        String total = currencyFormatter.format(amount);
        return total;
    }
}
