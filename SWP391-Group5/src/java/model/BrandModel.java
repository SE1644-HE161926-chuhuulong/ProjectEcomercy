/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Brand;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Saka289
 */
public class BrandModel extends DBContext {

    public List<Brand> getAllBrand() {
        List<Brand> list = new ArrayList<>();
        String sql = "select * from Brand";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Brand brand = new Brand();
                brand.setBrandId(rs.getInt("BrandId"));
                brand.setBrandName(rs.getString("bradName"));
                list.add(brand);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Brand getBrandDetail(int brandId) {
        String sql = "select * from Brand\n"
                + "where brandId = " + brandId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Brand brand = new Brand();
                brand.setBrandId(rs.getInt("BrandId"));
                brand.setBrandName(rs.getString("bradName"));
                return brand;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insertBrand(Brand brand) {
        String sql = "insert into Brand values(?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, brand.getBrandName());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateBrand(int brandId, Brand brand) {
        String sql = "UPDATE [dbo].[Brand]\n"
                + "   SET [brandName] = ?\n"
                + " WHERE brandId = " + brandId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, brand.getBrandName());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deteleBrand(int brandId) {
        String sql = "delete from Brand\n"
                + "where brandId = " + brandId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
