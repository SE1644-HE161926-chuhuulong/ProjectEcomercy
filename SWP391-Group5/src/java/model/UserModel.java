/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Utilities.Crypto;
import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author black
 */
public class UserModel extends DBContext {

    public int checkUser(String username, String password) {
        password = Crypto.SHA256(password);

        String sql = "SELECT [id] FROM [User] WHERE [username] = ? AND [password] = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }

        return -1;
    }

    public User getUser(String username, String password) {
        password = Crypto.SHA256(password);
        String sql = "SELECT * FROM [User] WHERE [username] = ? AND [password] = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setRoleId(rs.getInt("roleID"));
                u.setUsername(username);
                u.setPassword(password);
                u.setEmail(rs.getString("email"));
                u.setPhoneNumber(rs.getString("phoneNumber"));
                u.setAddress(rs.getString("phoneNumber"));
                u.setFullName(rs.getString("fullName"));
                u.setCity(rs.getString("city"));
                u.setDistrict(rs.getString("district"));
                u.setWard(rs.getString("ward"));
                u.setAvatar(rs.getString("avatar"));
                return u;
            }

            return null;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public Boolean isUsernameExist(String username) {
        String sql = "SELECT [id] FROM [User] WHERE [username] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM [User] WHERE [username] = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setRoleId(rs.getInt("roleID"));
                u.setUsername(username);
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setPhoneNumber(rs.getString("phoneNumber"));
                u.setAddress(rs.getString("phoneNumber"));
                u.setFullName(rs.getString("fullName"));
                u.setCity(rs.getString("city"));
                u.setDistrict(rs.getString("district"));
                u.setWard(rs.getString("ward"));
                u.setAvatar(rs.getString("avatar"));
                return u;
            }

            return null;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public Boolean insertUser(String username, String password) {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([roleID]\n"
                + "           ,[username]\n"
                + "           ,[password]\n"
                + "           )\n"
                + "     VALUES\n"
                + "           (2, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, Crypto.SHA256(password));
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public Boolean updatePassword(String username, String password) {
        password = Crypto.SHA256(password);
        String sql = "select * from [User]\n"
                + "UPDATE [dbo].[User] SET [password] = ? WHERE username = ? ";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, password);
            st.setString(2, username);
            st.executeUpdate();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public Boolean update(User user) {
        String sql = "UPDATE [dbo].[User]\n"
                + "   SET [roleID] = ?\n"
                + "      ,[username] = ?\n"
                + "      ,[password] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[phoneNumber] = ?\n"
                + "      ,[address] = ?\n"
                + "      ,[fullName] = ?\n"
                + "      ,[city] = ?\n"
                + "      ,[district] = ?\n"
                + "      ,[ward] = ?\n"
                + "      ,[avatar] = ?\n"
                + " WHERE [username] = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, user.getRoleId());
            st.setString(2, user.getUsername());
            st.setString(3, user.getPassword());
            st.setString(4, user.getEmail());
            st.setString(5, user.getPhoneNumber());
            st.setString(6, user.getAddress());
            st.setString(7, user.getFullName());
            st.setString(8, user.getCity());
            st.setString(9, user.getDistrict());
            st.setString(10, user.getWard());
            st.setString(11, user.getAvatar());

            st.executeUpdate();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public User getUserByEmail(String email) {
        String sql = "SELECT [username], [email] FROM [User] WHERE [email] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User u = new User(rs.getString("username"), email);
                return u;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public int createUser(User u) {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([roleID]\n"
                + "           ,[username]\n"
                + "           ,[email]\n"
                + "           ,[fullName]\n"
                + "           ,[avatar])\n"
                + "     VALUES (2, ?, ?, ?, ?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getEmail());
            st.setString(2, u.getEmail());
            st.setString(3, u.getFullName());
            st.setString(4, u.getAvatar());

            return st.executeUpdate();
        } catch (Exception e) {
        }
        return 0;
    }

    public User getUserById(int userId) {
        String sql = "select * from [User]\n"
                + "where id = " + userId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setRoleId(rs.getInt("roleID"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setPhoneNumber(rs.getString("phoneNumber"));
                u.setAddress(rs.getString("phoneNumber"));
                u.setFullName(rs.getString("fullName"));
                u.setCity(rs.getString("city"));
                u.setDistrict(rs.getString("district"));
                u.setWard(rs.getString("ward"));
                u.setAvatar(rs.getString("avatar"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        UserModel u = new UserModel();
        User u1 = u.getUserById(4);
        System.out.println(u1.toString());
    }
}
