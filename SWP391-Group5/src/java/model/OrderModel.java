/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Cart;
import entity.CartItem;
import entity.Order;
import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author black
 */
public class OrderModel extends DBContext {

    public void addOrder(User c, Cart cart) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try {
            //add order
            String sql = "INSERT INTO [dbo].[Order]\n"
                    + "           ([userId]\n"
                    + "           ,[dateCreated]\n"
                    + "           ,[totalPrice]\n"
                    + "           ,[status]\n"
                    + "           ,[note]\n"
                    + "           ,[address])\n"
                    + "     VALUES(?, ?, ?, 0, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getId());
            st.setString(2, date);
            st.setDouble(3, cart.getTotalMoney());
//            st.setString(4, cart.get);
            st.executeUpdate();
            //lay id cua order vua add
            String sql1 = "select top 1 id from [Orders] order by id desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();
            //add bang OrderDetail
            if (rs.next()) {
                int oid = rs.getInt("id");
                for (CartItem i : cart.getItems()) {
                    String sql2 = "insert into [Order_Details] values(?,?,?,?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, oid);
                    st2.setInt(2, i.getProduct().getProductId());
                    st2.setDouble(3, i.getProduct().getPrice() - i.getProduct().getPrice() * i.getProduct().getDiscount() / 100);
                    st2.setInt(4, i.getQuantity());
                    st2.setDouble(5, i.getTotal() - i.getTotal() * i.getProduct().getDiscount() / 100);
                    st2.executeUpdate();
                }
            }
            //cap nhat lai so luong san pham
            String sql3 = "update Product set quantity=quantity-? where id=?";
            PreparedStatement st3 = connection.prepareStatement(sql3);
            for (CartItem i : cart.getItems()) {
                st3.setInt(1, i.getQuantity());
                st3.setInt(2, i.getProduct().getProductId());
                st3.executeUpdate();
            }
        } catch (SQLException e) {

        }
    }
    
    public List<Order> getListOrder() {
        List<Order> list = new ArrayList<Order>();
        String sql = "SELECT [orderID],[orderName],[userId],[dateCreated],[totalPrice],[status],[note],[address]"
                + "  FROM [SWP391_Group5].[dbo].[Order]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt(1);
                String orderName = rs.getString(2);
                int userId = rs.getInt(3);
                String dateCreated = rs.getString(4);
                double totalPrice = rs.getDouble(5);
                int status = rs.getInt(6);
                String note = rs.getString(7);
                String address = rs.getString(8);
                Order order = new Order(orderId, orderName, userId, dateCreated, totalPrice, status, note, address);
                list.add(order);
            }
        } catch (Exception e) {
            System.out.println("Get list category error: " + e.getMessage());
        }
        return list;
    }

    public boolean approveOrder(int orderId, int status) {
        String sql = "UPDATE [dbo].[Order]\n"
                + "   SET [status] = ?\n"
                + "     \n"
                + " WHERE orderID = " + orderId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, status);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
