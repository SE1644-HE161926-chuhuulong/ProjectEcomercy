/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Category;
import entity.CategoryProduct;
import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 *
 * @author Saka289
 */
public class CategoryModel extends DBContext {

    public List<Category> getCategory(int parentIdInput) {
        List<Category> list = new ArrayList<Category>();
        String sql = "select * from Category where parentId = ? and cateStatus = 1";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, parentIdInput);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int cateId = rs.getInt(1);
                String cateName = rs.getString(2);
                String image = rs.getString(3);
                int parentId = rs.getInt(4);
                int cateStatus = rs.getInt(5);
                Category p = new Category(cateId, cateName, image, parentId, cateStatus);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("Get list category error: " + e.getMessage());
        }
        return list;
    }

    public List<Category> getCategoryByName(String inputName) {
        List<Category> list = new ArrayList<Category>();
        String sql = "select * from Category where cateName like ? and cateStatus = 1";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + inputName + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int cateId = rs.getInt(1);
                String cateName = rs.getString(2);
                String image = rs.getString(3);
                int parentId = rs.getInt(4);
                int cateStatus = rs.getInt(5);
                Category p = new Category(cateId, cateName, image, parentId, cateStatus);
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("Get list category error: " + e.getMessage());
        }
        return list;
    }

    public Category getCategoryById(int categoryId) {
        String sql = "select * from Category\n"
                + "where cateId = " + categoryId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int cateId = rs.getInt(1);
                String cateName = rs.getString(2);
                String image = rs.getString(3);
                int parentId = rs.getInt(4);
                int cateStatus = rs.getInt(5);
                Category c = new Category(cateId, cateName, image, parentId, cateStatus);
                return c;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Boolean insertCategory(Category category) {
        String sql = "INSERT INTO Category VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, category.getCateName());
            st.setString(2, category.getImage());
            st.setInt(3, category.getParentId());
            st.setInt(4, category.getCateStatus());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public Boolean updateCategory(int categoryId, Category category) {
        String sql = "UPDATE Category SET cateName = ?, image = ?, parentId = ?, cateStatus = ? WHERE cateId = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, category.getCateName());
            st.setString(2, category.getImage());
            st.setInt(3, category.getParentId());
            st.setInt(4, category.getCateStatus());
            st.setInt(5, categoryId);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Category\n"
                + "where parentId = 0";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int cateId = rs.getInt(1);
                String cateName = rs.getString(2);
                String image = rs.getString(3);
                int parentId = rs.getInt(4);
                int cateStatus = rs.getInt(5);
                List<Category> sublist = new ArrayList<>();
                String sql1 = "select * from Category\n"
                        + "where parentId = " + cateId;
                PreparedStatement st1 = connection.prepareStatement(sql1);
                ResultSet rs1 = st1.executeQuery();
                while (rs1.next()) {
                    Category subcategory = new Category();
                    subcategory.setCateId(rs1.getInt(("cateId")));
                    subcategory.setCateName(rs1.getString("cateName"));
                    subcategory.setImage(rs1.getString("image"));
                    subcategory.setParentId(rs1.getInt("parentId"));
                    subcategory.setCateStatus(rs1.getInt("cateStatus"));
                    sublist.add(subcategory);
                }
                Category c = new Category(cateId, cateName, image, parentId, cateStatus, sublist);
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
     public List<Category> getAllCategoryExcept(int id) {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Category\n"
                + "where parentId = 0 and cateId != " + id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int cateId = rs.getInt(1);
                String cateName = rs.getString(2);
                String image = rs.getString(3);
                int parentId = rs.getInt(4);
                int cateStatus = rs.getInt(5);
                List<Category> sublist = new ArrayList<>();
                String sql1 = "select * from Category\n"
                        + "where parentId = " + cateId;
                PreparedStatement st1 = connection.prepareStatement(sql1);
                ResultSet rs1 = st1.executeQuery();
                while (rs1.next()) {
                    Category subcategory = new Category();
                    subcategory.setCateId(rs1.getInt(("cateId")));
                    subcategory.setCateName(rs1.getString("cateName"));
                    subcategory.setImage(rs1.getString("image"));
                    subcategory.setParentId(rs1.getInt("parentId"));
                    subcategory.setCateStatus(rs1.getInt("cateStatus"));
                    sublist.add(subcategory);
                }
                Category c = new Category(cateId, cateName, image, parentId, cateStatus, sublist);
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }


    public List<CategoryProduct> CategoryFollowProduct() {
        List<CategoryProduct> list = new ArrayList<>();
        String sql = "select * from Category\n"
                + "where parentId = 0";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int cateId = rs.getInt(1);
                String cateName = rs.getString(2);
                String image = rs.getString(3);
                int parentId = rs.getInt(4);
                int cateStatus = rs.getInt(5);
                List<Product> subList = new ArrayList<>();
                String sql1 = "select top 8 p.productId,p.cateId,p.brandId,p.productName,\n"
                        + "p.price,p.discount,p.description,p.image,p.quantity,p.buyNumber,\n"
                        + "p.userCreatedId,p.userModifiedId,p.dateCreated,p.dateModified,p.productStatus\n"
                        + "from Product p join Category c\n"
                        + "on p.cateId = c.cateId\n"
                        + "where parentId = " + cateId
                        + "\norder by newid()";
                PreparedStatement st1 = connection.prepareStatement(sql1);
                ResultSet rs1 = st1.executeQuery();
                while (rs1.next()) {
                    Product product = new Product();
                    product.setProductId(rs1.getInt("productId"));
                    CategoryModel categoryModel = new CategoryModel();
                    Category c = categoryModel.getCategoryById(rs.getInt("cateId"));
                    product.setCategory(c);
                    product.setBrandId(rs1.getInt("brandId"));
                    product.setProductName(rs1.getString("productName"));
                    product.setPrice(rs1.getDouble("price"));
                    product.setDiscount(rs1.getDouble("discount"));
                    product.setDescription(rs1.getString("description"));
                    product.setImage(rs1.getString("image"));
                    product.setQuantity(rs1.getInt("quantity"));
                    product.setBuyNumber(rs1.getLong("buyNumber"));
                    product.setUserCreatedId(rs1.getInt("userCreatedId"));
                    product.setUserModifiedId(rs1.getInt("userModifiedId"));
                    product.setDateCreated(rs1.getString("dateCreated"));
                    product.setDateModified(rs1.getString("dateModified"));
                    product.setProductStatus(rs1.getInt("productStatus"));
                    subList.add(product);
                }
                CategoryProduct c = new CategoryProduct(cateId, cateName, image, parentId, cateStatus, subList);
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}  

