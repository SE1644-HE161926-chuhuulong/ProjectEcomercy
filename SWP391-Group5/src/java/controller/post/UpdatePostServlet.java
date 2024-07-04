/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.post;

import entity.Post;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.PostModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author asus
 */
@MultipartConfig
@WebServlet(name = "UpdatePostServlet", urlPatterns = {"/updatepost"})
public class UpdatePostServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdatePostServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdatePostServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("postId");
        int id = Integer.parseInt(id_raw);
        PostModel postModel = new PostModel();
        Post post = postModel.getPostByID(id);

        request.setAttribute("post", post);
        request.getRequestDispatcher("post/updatepost.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");

        int postId = Integer.parseInt(request.getParameter("postId"));
        String postContent = request.getParameter("post-content");
        

        //Document doc = Jsoup.parse(data);

        String postTitle = request.getParameter("post-title");
        String seoContent = request.getParameter("seo-content");

        Part file = request.getPart("files[]");
        String imageFileName = file.getSubmittedFileName();
        String uploadPath = "C:\\prj301\\SWP391\\swp391-se1637-group5\\Source\\SWP391-Group5\\web\\public\\img\\blog\\" + imageFileName;
        try {
            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is = file.getInputStream();
            byte[] data1 = new byte[is.available()];
            is.read(data1);
            fos.write(data1);
            fos.close();
        } catch (IOException e) {
            response.getWriter().print(e);
        }

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        String formattedDate = dateFormat.format(currentDate);
        PostModel p = new PostModel();

        p.UpdatePost(postId, postTitle,postContent , formattedDate,"img/blog/" + imageFileName, seoContent);
        PrintWriter out = response.getWriter();
        out.println(postId);
        out.println(postTitle);

        out.println(postContent );

        out.println(formattedDate);

        out.println("img/blog/" + imageFileName);

        out.println(seoContent);

        

        //Elements imgElements = doc.select("img");
//        for (Element imgElement : imgElements) {
//            String imgUrl = imgElement.attr("src");
//            // Do something with the image URL
//            //p.insertImagePost(imgUrl);
//            out.print(imgUrl);
//        }
        request.getRequestDispatcher("post/updatepost.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
