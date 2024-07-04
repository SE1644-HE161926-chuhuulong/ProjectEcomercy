/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.ProductComment;
import entity.ProductCommentListImage;
import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Saka289
 */
public class ProductCommentModel extends DBContext {

    public List<ProductComment> getProductCommentByProductId(int productIdInput) {
        List<ProductComment> list = new ArrayList<ProductComment>();
        String sql = "select * from [Product Comment] where productId = " + productIdInput;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int commentId = rs.getInt("commentId");
                UserModel userModel = new UserModel();
                User user = userModel.getUserById(rs.getInt("userId"));
                int productId = rs.getInt("productId");
                String content = rs.getString("content");
                int rating = rs.getInt("rating");
                List<ProductCommentListImage> subListImage = new ArrayList<>();
                String sql1 = "select * from [Product comment List Image] \n"
                        + "where commentId = " + commentId;
                PreparedStatement st1 = connection.prepareStatement(sql1);
                ResultSet rs1 = st1.executeQuery();
                while (rs1.next()) {
                    ProductCommentListImage productCommentListImage = new ProductCommentListImage();
                    productCommentListImage.setId(rs1.getInt("id"));
                    productCommentListImage.setImage(rs1.getString("image"));
                    productCommentListImage.setCommentId(rs1.getInt("commentId"));
                    subListImage.add(productCommentListImage);
                }
                ProductComment productComment = new ProductComment(commentId, user, productId, content, rating, subListImage);
                list.add(productComment);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<ProductComment> getAllProductComment() {
        List<ProductComment> list = new ArrayList<>();
        String sql = "select * from [Product Comment]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductComment productComment = new ProductComment();
                productComment.setCommentId(rs.getInt("commentid"));
                UserModel userModel = new UserModel();
                User user = userModel.getUserById(rs.getInt("userId"));
                productComment.setUser(user);
                productComment.setProductId(rs.getInt("productId"));
                productComment.setContent(rs.getString("content"));
                productComment.setRating(rs.getInt("rating"));
                list.add(productComment);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Boolean insertProductComment(User user, int productId, String content, int rating, ArrayList<String> listImage) {
        String sql = "INSERT INTO [Product Comment] VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, user.getId());
            st.setInt(2, productId);
            st.setString(3, content);
            st.setInt(4, rating);
            st.executeUpdate();
            String sql1 = "select top 1 commentId from [Product Comment]\n"
                    + "order by commentId desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();
            if (rs.next()) {
                int commentId = rs.getInt(1);
                for (String image : listImage) {
                    String sql2 = "insert into [Product comment List Image] values (?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setString(1, image.trim());
                    st2.setInt(2, commentId);
                    st2.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public Boolean updateProductComment(int commentId, ProductComment comment) {
        String sql = "UPDATE [Product Comment] SET userId = ?, productId = ?, content = ?, rating = ? WHERE commentId = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, comment.getUser().getId());
            st.setInt(2, comment.getProductId());
            st.setString(3, comment.getContent());
            st.setInt(4, comment.getRating());
            st.setInt(5, commentId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
