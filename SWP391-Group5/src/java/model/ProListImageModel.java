/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.ProListImage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Saka289
 */
public class ProListImageModel extends DBContext {

    public List<ProListImage> getProListImage(int productId) {
        List<ProListImage> list = new ArrayList<>();
        String sql = "select * from [Pro list image]\n"
                + "where productId = " + productId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProListImage proListImage = new ProListImage();
                proListImage.setId(rs.getInt("id"));
                proListImage.setImage(rs.getString("image"));
                proListImage.setProductId(rs.getInt("productId"));
                list.add(proListImage);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public static void main(String[] args) {
        ProListImageModel p = new ProListImageModel();
        List<ProListImage> p1 = p.getProListImage(1);
        for (ProListImage proListImage : p1) {
            System.out.println(proListImage.toString());
        }
    }
}
