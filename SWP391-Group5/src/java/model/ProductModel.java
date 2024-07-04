/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import entity.Category;
import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Saka289
 */
public class ProductModel extends DBContext {

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                CategoryModel categoryModel = new CategoryModel();
                Category c = categoryModel.getCategoryById(rs.getInt("cateId"));
                product.setCategory(c);
                product.setBrandId(rs.getInt("brandId"));
                product.setProductName(rs.getString("productName"));
                product.setPrice(rs.getDouble("price"));
                product.setDiscount(rs.getDouble("discount"));
                product.setDescription(rs.getString("description"));
                product.setImage(rs.getString("image"));
                product.setQuantity(rs.getInt("quantity"));
                product.setBuyNumber(rs.getLong("buyNumber"));
                product.setUserCreatedId(rs.getInt("userCreatedId"));
                product.setUserModifiedId(rs.getInt("userModifiedId"));
                product.setDateCreated(rs.getString("dateCreated"));
                product.setDateModified(rs.getString("dateModified"));
                product.setProductStatus(rs.getInt("productStatus"));
                list.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Product getProductDetail(int productId) {
        String sql = "select * from Product\n"
                + "where productId = " + productId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                CategoryModel categoryModel = new CategoryModel();
                Category c = categoryModel.getCategoryById(rs.getInt("cateId"));
                product.setCategory(c);
                product.setBrandId(rs.getInt("brandId"));
                product.setProductName(rs.getString("productName"));
                product.setPrice(rs.getDouble("price"));
                product.setDiscount(rs.getDouble("discount"));
                product.setDescription(rs.getString("description"));
                product.setImage(rs.getString("image"));
                product.setQuantity(rs.getInt("quantity"));
                product.setBuyNumber(rs.getLong("buyNumber"));
                product.setUserCreatedId(rs.getInt("userCreatedId"));
                product.setUserModifiedId(rs.getInt("userModifiedId"));
                product.setDateCreated(rs.getString("dateCreated"));
                product.setDateModified(rs.getString("dateModified"));
                product.setProductStatus(rs.getInt("productStatus"));
                return product;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Product> getProductByCategory(int cateId) {
        List<Product> list = new ArrayList<>();
        String sql = "select productId,cateId,brandId,productName,price,discount,description,image,\n"
                + "quantity,buyNumber,userCreatedId,userModifiedId,\n"
                + "dateCreated,dateModified,productStatus from Product \n"
                + "where cateid = " + cateId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                CategoryModel categoryModel = new CategoryModel();
                Category c = categoryModel.getCategoryById(rs.getInt("cateId"));
                product.setCategory(c);
                product.setBrandId(rs.getInt("brandId"));
                product.setProductName(rs.getString("productName"));
                product.setPrice(rs.getDouble("price"));
                product.setDiscount(rs.getDouble("discount"));
                product.setDescription(rs.getString("description"));
                product.setImage(rs.getString("image"));
                product.setQuantity(rs.getInt("quantity"));
                product.setBuyNumber(rs.getLong("buyNumber"));
                product.setUserCreatedId(rs.getInt("userCreatedId"));
                product.setUserModifiedId(rs.getInt("userModifiedId"));
                product.setDateCreated(rs.getString("dateCreated"));
                product.setDateModified(rs.getString("dateModified"));
                product.setProductStatus(rs.getInt("productStatus"));
                list.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProductByAllCategory(int parentId) {
        List<Product> list = new ArrayList<>();
        String sql = "select p.productId,p.cateId,p.brandId,p.productName,p.price,p.discount,p.description,p.image,p.quantity,p.buyNumber,\n"
                + "p.userCreatedId,p.userModifiedId,p.dateCreated,p.dateModified,p.productStatus\n"
                + "from Product p join Category c\n"
                + "on p.cateId = c.cateId \n"
                + "where c.parentId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, parentId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                CategoryModel categoryModel = new CategoryModel();
                Category c = categoryModel.getCategoryById(rs.getInt("cateId"));
                product.setCategory(c);
                product.setBrandId(rs.getInt("brandId"));
                product.setProductName(rs.getString("productName"));
                product.setPrice(rs.getDouble("price"));
                product.setDiscount(rs.getDouble("discount"));
                product.setDescription(rs.getString("description"));
                product.setImage(rs.getString("image"));
                product.setQuantity(rs.getInt("quantity"));
                product.setBuyNumber(rs.getLong("buyNumber"));
                product.setUserCreatedId(rs.getInt("userCreatedId"));
                product.setUserModifiedId(rs.getInt("userModifiedId"));
                product.setDateCreated(rs.getString("dateCreated"));
                product.setDateModified(rs.getString("dateModified"));
                product.setProductStatus(rs.getInt("productStatus"));
                list.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void insertProduct(int cateId, int brandId, String name, double price,
            double discount, String des, String image, int quantity, int userCreated, int userModified, String dateCreated, String dateModified, int status) {
        String sql = "INSERT INTO [dbo].[Product]\n"
                + "           ([cateId]\n"
                + "           ,[brandId]\n"
                + "           ,[productName]\n"
                + "           ,[price]\n"
                + "           ,[discount]\n"
                + "           ,[description]\n"
                + "           ,[image]\n"
                + "           ,[quantity]\n"
                + "           ,[userCreatedId]\n"
                + "           ,[userModifiedId]\n"
                + "           ,[dateCreated]\n"
                + "           ,[dateModified]\n"
                + "           ,[productStatus]) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cateId);
            st.setInt(2, brandId);
            st.setString(3, name);
            st.setDouble(4, price);
            st.setDouble(5, discount);
            st.setString(6, des);
            st.setString(7, image);
            st.setInt(8, quantity);
            st.setInt(9, userCreated);
            st.setInt(10, userModified);
            st.setString(11, dateCreated);
            st.setString(12, dateModified);
            st.setInt(13, status);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateProduct(int productId, int cateId, int brandId, String name, double price,
            double discount, String des, String image, int quantity, int userCreated, int userModified, String dateCreated, String dateModified, int status) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [cateId] = ?\n"
                + "      ,[brandId] = ?\n"
                + "      ,[productName] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[discount] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[image] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[userCreatedId] = ?\n"
                + "      ,[userModifiedId] = ?\n"
                + "      ,[dateCreated] = ?\n"
                + "      ,[dateModified] = ?\n"
                + "      ,[productStatus] = ?\n"
                + " WHERE productId = " + productId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cateId);
            st.setInt(2, brandId);
            st.setString(3, name);
            st.setDouble(4, price);
            st.setDouble(5, discount);
            st.setString(6, des);
            st.setString(7, image);
            st.setInt(8, quantity);
            st.setInt(9, userCreated);
            st.setInt(10, userModified);
            st.setString(11, dateCreated);
            st.setString(12, dateModified);
            st.setInt(13, status);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteProduct(int productId) {
        String sql = "delete from Product\n"
                + "where productId = " + productId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ProductModel p = new ProductModel();
        List<Product> list = p.getProductByAllCategory(1);
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }
}
