/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Post;
import entity.PostComment;
import entity.PostListImage;
import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

/**
 *
 * @author asus
 */
public class PostModel extends DBContext {

    public User getUserById(int id) {
        String sql = "SELECT [id]\n"
                + "      ,[roleID]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[email]\n"
                + "      ,[phoneNumber]\n"
                + "      ,[address]\n"
                + "      ,[fullName]\n"
                + "      ,[city]\n"
                + "      ,[district]\n"
                + "      ,[ward]\n"
                + "      ,[avatar]\n"
                + "  FROM [dbo].[User] where id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User u = new User();

                u.setId(id);
                u.setRoleId(rs.getInt("roleID"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setPhoneNumber(rs.getString("phoneNumber"));
                u.setAddress(rs.getString("address"));
                u.setFullName(rs.getString("fullName"));
                u.setCity(rs.getString("city"));
                u.setDistrict(rs.getString("district"));
                u.setWard(rs.getString("ward"));
                u.setAvatar(rs.getString("avatar"));

                return u;
            }

            return null;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public List<Post> getAllPost() {
        List<Post> list = new ArrayList<>();
        String sql = "SELECT  [postId]\n"
                + "      ,[postTitle]\n"
                + "           ,[postContent]\n"
                + "           ,[userCreatedId]\n"
                + "           ,[dateCreated]\n"
                + "           ,[dateModified]\n"
                + "           ,[viewNumber]\n"
                + "           ,[postStatus]\n"
                + "           ,[imageBanner]\n"
                + "           ,[seoContent]\n"
                + "  FROM [SWP391_Group5].[dbo].[Post] WHERE postStatus = 1 order by postId desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setPostId(rs.getInt("postId"));
                p.setPostTitle(rs.getString("postTitle"));
                p.setPostContent(rs.getNString("postContent"));

                User u = getUserById(rs.getInt("userCreatedId"));
                p.setUserCreated(u);

                p.setDateCreated(rs.getDate("dateCreated"));
                p.setDateModified(rs.getDate("dateModified"));
                p.setViewNumber(rs.getInt("viewNumber"));
                p.setPostStatus(rs.getInt("postStatus"));
                p.setImageBanner(rs.getString("imageBanner"));
                p.setSeoContent(rs.getString("seoContent"));

                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println("error");
        }
        return list;

    }
    
    public List<Post> getPostBySearchTitle(String search) {
        List<Post> list = new ArrayList<>();
        String sql = "SELECT  [postId]\n"
                + "      ,[postTitle]\n"
                + "           ,[postContent]\n"
                + "           ,[userCreatedId]\n"
                + "           ,[dateCreated]\n"
                + "           ,[dateModified]\n"
                + "           ,[viewNumber]\n"
                + "           ,[postStatus]\n"
                + "           ,[imageBanner]\n"
                + "           ,[seoContent]\n"
                + "  FROM [SWP391_Group5].[dbo].[Post] Where postTitle like '%"+search+"%' and postStatus=1";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setPostId(rs.getInt("postId"));
                p.setPostTitle(rs.getString("postTitle"));
                p.setPostContent(rs.getNString("postContent"));

                User u = getUserById(rs.getInt("userCreatedId"));
                p.setUserCreated(u);

                p.setDateCreated(rs.getDate("dateCreated"));
                p.setDateModified(rs.getDate("dateModified"));
                p.setViewNumber(rs.getInt("viewNumber"));
                p.setPostStatus(rs.getInt("postStatus"));
                p.setImageBanner(rs.getString("imageBanner"));
                p.setSeoContent(rs.getString("seoContent"));

                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println("error");
        }
        return list;

    }

    public List<Post> getFourPopularPost() {
        List<Post> list = new ArrayList<>();
        String sql = "SELECT [postId]\n"
                + "      ,[postTitle]\n"
                + "           ,[postContent]\n"
                + "           ,[userCreatedId]\n"
                + "           ,[dateCreated]\n"
                + "           ,[dateModified]\n"
                + "           ,[viewNumber]\n"
                + "           ,[postStatus]\n"
                + "           ,[imageBanner]\n"
                + "           ,[seoContent]\n"
                + "  FROM [SWP391_Group5].[dbo].[Post] Where [postTitle] Where postStatus =1 ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setPostId(rs.getInt("postId"));
                p.setPostTitle(rs.getString("postTitle"));
                p.setPostContent(rs.getNString("postContent"));

                User u = getUserById(rs.getInt("userCreatedId"));
                p.setUserCreated(u);

                p.setDateCreated(rs.getDate("dateCreated"));
                p.setDateModified(rs.getDate("dateModified"));
                p.setViewNumber(rs.getInt("viewNumber"));
                p.setPostStatus(rs.getInt("postStatus"));
                p.setImageBanner(rs.getString("imageBanner"));
                p.setSeoContent(rs.getString("seoContent"));

                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println("error");
        }
        return list;

    }

    public Post getPostByID(int postId) {

        String sql = "SELECT  [postId]\n"
                + "      ,[postTitle]\n"
                + "      ,[postContent]\n"
                + "      ,[userCreatedId]\n"
                + "      ,[dateCreated]\n"
                + "      ,[dateModified]\n"
                + "      ,[viewNumber]\n"
                + "      ,[postStatus]\n"
                + "      ,[imageBanner]\n"
                + "      ,[seoContent]\n"
                + "  FROM [SWP391_Group5].[dbo].[Post] where postId=" + postId;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            //st.setInt(postId, 1);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Post p = new Post();
                p.setPostId(rs.getInt("postId"));
                p.setPostTitle(rs.getNString("postTitle"));
                p.setPostContent(rs.getNString("postContent"));

                User u = getUserById(rs.getInt("userCreatedId"));
                p.setUserCreated(u);

                p.setDateCreated(rs.getDate("dateCreated"));
                p.setDateModified(rs.getDate("dateModified"));
                p.setViewNumber(rs.getInt("viewNumber"));
                p.setPostStatus(rs.getInt("postStatus"));
                p.setImageBanner(rs.getString("imageBanner"));
                p.setSeoContent(rs.getString("seoContent"));

                return p;

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;

    }

    public static void main(String[] args) {
        PostModel p = new PostModel();
//        Date currentDate = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
//        String formattedDate = dateFormat.format(currentDate);
//        p.insertPost("aa", "bb", 2, formattedDate, formattedDate, 0, 0);
        p.UpdatePost(2, "khima", "khima", "2/2/3022", "", "nam anh len 6");
        //Post ps= p.getPostByID(34);
        //System.out.println(ps.getImageBanner());
    }

    public void increaseView(int postId) {

        String sql = "UPDATE [dbo].[Post]\n"
                + "   SET \n"
                + "      viewNumber = viewNumber+1\n"
                + "      \n"
                + " WHERE postId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, postId);
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public List<PostComment> getAllPostComment(int postId) {

        /*
        private int commentId;
    private User userId;
    private Post postId;
    private String content;
    private LocalDate datePosted;*/
        List<PostComment> list = new ArrayList<>();
        PostModel postModel = new PostModel();
        String sql = "SELECT  [commentId]\n"
                + "      ,[userId]\n"
                + "      ,[postId]\n"
                + "      ,[content]\n"
                + "      ,[datePosted]\n"
                + "  FROM [dbo].[Post Comment] where postId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, postId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                PostComment postComment = new PostComment();
                postComment.setCommentId(rs.getInt("commentId"));
                User u = postModel.getUserById(rs.getInt("userId"));
                postComment.setUserId(u);
                postComment.setPostId(postModel.getPostByID(postId));
                postComment.setContent(rs.getString("content"));
                postComment.setDatePosted(rs.getDate("datePosted"));

                list.add(postComment);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;

    }

    public List<PostListImage> getAllPostListImage(int postId) {

        /*
        private int commentId;
    private User userId;
    private Post postId;
    private String content;
    private LocalDate datePosted;*/
        List<PostListImage> list = new ArrayList<>();
        PostModel postModel = new PostModel();
        String sql = "SELECT  [id]\n"
                + "      ,[image]\n"
                + "      ,[postId]\n"
                + "  FROM [SWP391_Group5].[dbo].[Post list image] where postId =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, postId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                PostListImage postImage = new PostListImage();
                postImage.setId(rs.getInt("id"));
                postImage.setImage(rs.getString("image"));

                postImage.setPostId(postId);

                list.add(postImage);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;

    }

//    public PostListImage getOnePostImage(int postId) {
//
//        /*
//        private int commentId;
//    private User userId;
//    private Post postId;
//    private String content;
//    private LocalDate datePosted;*/
//        PostModel postModel = new PostModel();
//        String sql = "SELECT  [id]\n"
//                + "      ,[image]\n"
//                + "      ,[postId]\n"
//                + "  FROM [SWP391_Group5].[dbo].[Post list image] where postId =?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, postId);
//            ResultSet rs = st.executeQuery();
//            PostListImage postImage = new PostListImage();
//            if (rs.next()) {
//
//                postImage.setId(rs.getInt("id"));
//                postImage.setImage(rs.getString("image"));
//
//                postImage.setPostId(postId);
//
//            }
//            return postImage;
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//
//    }

    public List<Post> getPostByUserID(int userID) {
        List<Post> list = new ArrayList<>();
        String sql = "SELECT  [postId]\n"
                + "      ,[postTitle]\n"
                + "      ,[postContent]\n"
                + "      ,[userCreatedId]\n"
                + "      ,[dateCreated]\n"
                + "      ,[dateModified]\n"
                + "      ,[viewNumber]\n"
                + "      ,[postStatus]\n"
                + "      ,[imageBanner]\n"
                + "      ,[seoContent]\n"
                + "  FROM [SWP391_Group5].[dbo].[Post] where userCreatedId =" + userID;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            //st.setInt(postId, 1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setPostId(rs.getInt("postId"));
                p.setPostTitle(rs.getNString("postTitle"));
                p.setPostContent(rs.getNString("postContent"));

                User u = getUserById(rs.getInt("userCreatedId"));
                p.setUserCreated(u);

                p.setDateCreated(rs.getDate("dateCreated"));
                p.setDateModified(rs.getDate("dateModified"));
                p.setViewNumber(rs.getInt("viewNumber"));
                p.setPostStatus(rs.getInt("postStatus"));
                p.setImageBanner(rs.getString("imageBanner"));
                p.setSeoContent(rs.getString("seoContent"));

                list.add(p);

            }
            return list;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;

    }

    /*
    private int postId;
    private String postTitle;
    private String postContent;
    private User userCreated;
    private Date  dateCreated;
    private Date  dateModified;
    private int viewNumber;
     */
    public void insertPost(String postTitle, String postContent, int userCreatedId, String dateCreated, String dateModified, int viewNumber, int postStatus, String imageBanner, String seoContent) {
        String sql = "INSERT INTO [dbo].[Post]\n"
                + "           ([postTitle]\n"
                + "           ,[postContent]\n"
                + "           ,[userCreatedId]\n"
                + "           ,[dateCreated]\n"
                + "           ,[dateModified]\n"
                + "           ,[viewNumber]\n"
                + "           ,[postStatus]\n"
                + "           ,[imageBanner]\n"
                + "           ,[seoContent])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, postTitle);
            st.setString(2, postContent);
            st.setInt(3, userCreatedId);
            st.setString(4, dateCreated);
            st.setString(5, dateModified);
            st.setInt(6, 0);
            st.setInt(7, 0);
            st.setString(8, imageBanner);
            st.setString(9, seoContent);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);

        }

    }

    public void UpdatePost(int postId, String postTitle, String postContent, String dateModified, String imageBanner, String seoContent) {
        String sql = "UPDATE [dbo].[Post]\n"
                + "   SET [postTitle] = ?\n"
                + "      ,[postContent] = ?\n"
                + "      ,[dateModified] = ?\n"
                + "      ,[postStatus] = 0\n"
                + "      ,[imageBanner] = ?\n"
                + "      ,[seoContent] = ?\n"
                + " WHERE postId= ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, postTitle);
            st.setString(2, postContent);
            st.setString(3, dateModified);
            st.setString(4, imageBanner);
            st.setString(5, seoContent);
            st.setInt(6, postId);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);

        }

    }
    public void DeletePost(int postId) {
        String sql = "DELETE FROM [dbo].[Post]\n" +
"      WHERE postId= ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            
            st.setInt(1, postId);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);

        }

    }
    public void UpdateStatusPost(int postId) {
        String sql = "UPDATE [dbo].[Post]\n"
                + "   SET [postStatus] = 1\n"
                + " WHERE postId= ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            
            st.setInt(1, postId);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);

        }

    }
    

    public int iDlastPost() {
        int id;
        String sql = "SELECT top 1  [postId]\n"
                + "      ,[postTitle]\n"
                + "      ,[postContent]\n"
                + "      ,[userCreatedId]\n"
                + "      ,[dateCreated]\n"
                + "      ,[dateModified]\n"
                + "      ,[viewNumber]\n"
                + "      ,[postStatus]\n"
                + "  FROM [SWP391_Group5].[dbo].[Post] ORDER BY postId DESC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            //st.setInt(postId, 1);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                id = rs.getInt("postId");
                return id;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println("print post success");
        return 0;

    }

    public void insertImagePost(String image) {
        PostModel p = new PostModel();
        int idLastPost = p.iDlastPost();
        String sql = "INSERT INTO [dbo].[Post list image]\n"
                + "           ([image]\n"
                + "           ,[postId])\n"
                + "     VALUES\n"
                + "           (?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, image);
            st.setInt(2, p.iDlastPost());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);

        }
        System.out.println("Print img success");

    }

    public void insertPostComment(int userId, int postId, String comment, String datePosted) {
        PostModel p = new PostModel();

        String sql = "INSERT INTO [dbo].[Post Comment]\n"
                + "           ([userId]\n"
                + "           ,[postId]\n"
                + "           ,[content]\n"
                + "           ,[datePosted])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            st.setInt(2, postId);
            st.setString(3, comment);
            st.setString(4, datePosted);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);

        }
        System.out.println("Print img success");

    }

}
